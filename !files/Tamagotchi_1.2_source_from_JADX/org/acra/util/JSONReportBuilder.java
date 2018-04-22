package org.acra.util;

import android.support.annotation.NonNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.collector.CollectorUtil;
import org.acra.collector.CrashReportData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JSONReportBuilder {

    public static class JSONReportException extends Exception {
        private static final long serialVersionUID = -694684023635442219L;

        public JSONReportException(String message, Throwable e) {
            super(message, e);
        }
    }

    private JSONReportBuilder() {
    }

    @NonNull
    public static JSONObject buildJSONReport(@NonNull CrashReportData errorContent) throws JSONReportException {
        JSONException e;
        JSONObject jsonReport = new JSONObject();
        BufferedReader reader = null;
        for (ReportField key : errorContent.keySet()) {
            if (key.containsKeyValuePairs()) {
                JSONObject subObject = new JSONObject();
                BufferedReader reader2 = new BufferedReader(new StringReader(errorContent.getProperty(key)), 1024);
                while (true) {
                    try {
                        String line = reader2.readLine();
                        if (line == null) {
                            break;
                        }
                        addJSONFromProperty(subObject, line);
                    } catch (IOException e2) {
                        try {
                            ACRA.log.mo4051w(ACRA.LOG_TAG, "Error while converting " + key.name() + " to JSON.", e2);
                        } catch (JSONException e3) {
                            e = e3;
                            reader = reader2;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            reader = reader2;
                        }
                    }
                }
                jsonReport.accumulate(key.name(), subObject);
                reader = reader2;
            } else {
                try {
                    jsonReport.accumulate(key.name(), guessType(errorContent.getProperty(key)));
                } catch (JSONException e4) {
                    e = e4;
                }
            }
            CollectorUtil.safeClose(reader);
        }
        return jsonReport;
        try {
            throw new JSONReportException("Could not create JSON object for key " + key, e);
        } catch (Throwable th3) {
            th2 = th3;
            CollectorUtil.safeClose(reader);
            throw th2;
        }
    }

    private static void addJSONFromProperty(@NonNull JSONObject destination, @NonNull String propertyString) throws JSONException {
        int equalsIndex = propertyString.indexOf(61);
        if (equalsIndex > 0) {
            String currentKey = propertyString.substring(0, equalsIndex).trim();
            Object guessType = guessType(propertyString.substring(equalsIndex + 1).trim());
            if (guessType instanceof String) {
                guessType = ((String) guessType).replaceAll("\\\\n", "\n");
            }
            String[] splitKey = currentKey.split("\\.");
            if (splitKey.length > 1) {
                addJSONSubTree(destination, splitKey, guessType);
                return;
            } else {
                destination.accumulate(currentKey, guessType);
                return;
            }
        }
        destination.put(propertyString.trim(), true);
    }

    @NonNull
    private static Object guessType(@NonNull String value) {
        if (value.equalsIgnoreCase("true")) {
            return Boolean.valueOf(true);
        }
        if (value.equalsIgnoreCase("false")) {
            return Boolean.valueOf(false);
        }
        if (!value.matches("(?:^|\\s)([1-9](?:\\d*|(?:\\d{0,2})(?:,\\d{3})*)(?:\\.\\d*[1-9])?|0?\\.\\d*[1-9]|0)(?:\\s|$)")) {
            return value;
        }
        try {
            return NumberFormat.getInstance(Locale.US).parse(value);
        } catch (ParseException e) {
            return value;
        }
    }

    private static void addJSONSubTree(@NonNull JSONObject destination, @NonNull String[] keys, Object value) throws JSONException {
        for (int i = 0; i < keys.length; i++) {
            String subKey = keys[i];
            if (i < keys.length - 1) {
                JSONObject intermediate = null;
                if (destination.isNull(subKey)) {
                    intermediate = new JSONObject();
                    destination.accumulate(subKey, intermediate);
                } else {
                    Object target = destination.get(subKey);
                    if (target instanceof JSONObject) {
                        intermediate = destination.getJSONObject(subKey);
                    } else if (target instanceof JSONArray) {
                        JSONArray wildCard = destination.getJSONArray(subKey);
                        for (int j = 0; j < wildCard.length(); j++) {
                            intermediate = wildCard.optJSONObject(j);
                            if (intermediate != null) {
                                break;
                            }
                        }
                    }
                    if (intermediate == null) {
                        ACRA.log.mo4050w(ACRA.LOG_TAG, "Unknown json subtree type, see issue #186");
                        return;
                    }
                }
                destination = intermediate;
            } else {
                destination.accumulate(subKey, value);
            }
        }
    }
}
