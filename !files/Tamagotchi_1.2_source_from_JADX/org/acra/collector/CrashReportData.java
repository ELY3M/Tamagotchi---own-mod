package org.acra.collector;

import android.support.annotation.NonNull;
import java.util.EnumMap;
import org.acra.ReportField;
import org.acra.util.JSONReportBuilder;
import org.acra.util.JSONReportBuilder.JSONReportException;
import org.json.JSONObject;

public final class CrashReportData extends EnumMap<ReportField, String> {
    private static final long serialVersionUID = 4112578634029874840L;

    public CrashReportData() {
        super(ReportField.class);
    }

    public String getProperty(@NonNull ReportField key) {
        return (String) super.get(key);
    }

    @NonNull
    public JSONObject toJSON() throws JSONReportException {
        return JSONReportBuilder.buildJSONReport(this);
    }
}
