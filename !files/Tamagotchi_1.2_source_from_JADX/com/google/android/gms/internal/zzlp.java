package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzlp {
    private static final zzl zzaaf = new zzl("MetadataUtils");
    private static final String[] zzaeC = new String[]{"Z", "+hh", "+hhmm", "+hh:mm"};
    private static final String zzaeD = ("yyyyMMdd'T'HHmmss" + zzaeC[0]);

    public static String zza(Calendar calendar) {
        if (calendar == null) {
            zzaaf.zzb("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = zzaeD;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        str = simpleDateFormat.format(calendar.getTime());
        return str.endsWith("+0000") ? str.replace("+0000", zzaeC[0]) : str;
    }

    public static void zza(List<WebImage> list, JSONObject jSONObject) {
        try {
            list.clear();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException e) {
                }
            }
        } catch (JSONException e2) {
        }
    }

    public static void zza(JSONObject jSONObject, List<WebImage> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (WebImage toJson : list) {
                jSONArray.put(toJson.toJson());
            }
            try {
                jSONObject.put("images", jSONArray);
            } catch (JSONException e) {
            }
        }
    }

    public static Calendar zzco(String str) {
        if (TextUtils.isEmpty(str)) {
            zzaaf.zzb("Input string is empty or null", new Object[0]);
            return null;
        }
        String zzcp = zzcp(str);
        if (TextUtils.isEmpty(zzcp)) {
            zzaaf.zzb("Invalid date format", new Object[0]);
            return null;
        }
        String zzcq = zzcq(str);
        String str2 = "yyyyMMdd";
        if (!TextUtils.isEmpty(zzcq)) {
            zzcp = zzcp + "T" + zzcq;
            str2 = zzcq.length() == "HHmmss".length() ? "yyyyMMdd'T'HHmmss" : zzaeD;
        }
        Calendar instance = GregorianCalendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat(str2).parse(zzcp));
            return instance;
        } catch (ParseException e) {
            zzaaf.zzb("Error parsing string: %s", e.getMessage());
            return null;
        }
    }

    private static String zzcp(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            zzaaf.zzb("Input string is empty or null", new Object[0]);
        } else {
            try {
                str2 = str.substring(0, "yyyyMMdd".length());
            } catch (IndexOutOfBoundsException e) {
                zzaaf.zze("Error extracting the date: %s", e.getMessage());
            }
        }
        return str2;
    }

    private static String zzcq(String str) {
        if (TextUtils.isEmpty(str)) {
            zzaaf.zzb("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != "yyyyMMdd".length()) {
            zzaaf.zzb("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == "HHmmss".length()) {
                return substring;
            }
            switch (substring.charAt("HHmmss".length())) {
                case '+':
                case '-':
                    return zzcr(substring) ? substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2") : null;
                case 'Z':
                    return substring.length() == "HHmmss".length() + zzaeC[0].length() ? substring.substring(0, substring.length() - 1) + "+0000" : null;
                default:
                    return null;
            }
        } catch (IndexOutOfBoundsException e) {
            zzaaf.zzb("Error extracting the time substring: %s", e.getMessage());
            return null;
        }
    }

    private static boolean zzcr(String str) {
        int length = str.length();
        int length2 = "HHmmss".length();
        return length == zzaeC[1].length() + length2 || length == zzaeC[2].length() + length2 || length == length2 + zzaeC[3].length();
    }
}
