package org.acra.sender;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.config.ACRAConfiguration;
import org.acra.util.HttpRequest;
import org.acra.util.JSONReportBuilder.JSONReportException;

public class HttpSender implements ReportSender {
    private final ACRAConfiguration config;
    @Nullable
    private final Uri mFormUri;
    private final Map<ReportField, String> mMapping;
    private final Method mMethod;
    @Nullable
    private String mPassword;
    private final Type mType;
    @Nullable
    private String mUsername;

    public enum Method {
        POST,
        PUT
    }

    public enum Type {
        FORM {
            @NonNull
            public String getContentType() {
                return "application/x-www-form-urlencoded";
            }
        },
        JSON {
            @NonNull
            public String getContentType() {
                return "application/json";
            }
        };

        @NonNull
        public abstract String getContentType();
    }

    public HttpSender(@NonNull ACRAConfiguration config, @NonNull Method method, @NonNull Type type, @Nullable Map<ReportField, String> mapping) {
        this(config, method, type, null, mapping);
    }

    public HttpSender(@NonNull ACRAConfiguration config, @NonNull Method method, @NonNull Type type, @Nullable String formUri, @Nullable Map<ReportField, String> mapping) {
        this.config = config;
        this.mMethod = method;
        this.mFormUri = formUri == null ? null : Uri.parse(formUri);
        this.mMapping = mapping;
        this.mType = type;
        this.mUsername = null;
        this.mPassword = null;
    }

    public void setBasicAuth(@Nullable String username, @Nullable String password) {
        this.mUsername = username;
        this.mPassword = password;
    }

    public void send(@NonNull Context context, @NonNull CrashReportData report) throws ReportSenderException {
        String password = null;
        try {
            URL reportUrl;
            String reportAsString;
            if (this.mFormUri == null) {
                reportUrl = new URL(this.config.formUri());
            } else {
                reportUrl = new URL(this.mFormUri.toString());
            }
            String login = this.mUsername != null ? this.mUsername : isNull(this.config.formUriBasicAuthLogin()) ? null : this.config.formUriBasicAuthLogin();
            if (this.mPassword != null) {
                password = this.mPassword;
            } else if (!isNull(this.config.formUriBasicAuthPassword())) {
                password = this.config.formUriBasicAuthPassword();
            }
            HttpRequest request = new HttpRequest(this.config);
            request.setConnectionTimeOut(this.config.connectionTimeout());
            request.setSocketTimeOut(this.config.socketTimeout());
            request.setLogin(login);
            request.setPassword(password);
            request.setHeaders(this.config.getHttpHeaders());
            switch (this.mType) {
                case JSON:
                    reportAsString = report.toJSON().toString();
                    break;
                default:
                    reportAsString = HttpRequest.getParamsAsFormString(remap(report));
                    break;
            }
            switch (this.mMethod) {
                case POST:
                    break;
                case PUT:
                    reportUrl = new URL(reportUrl.toString() + '/' + report.getProperty(ReportField.REPORT_ID));
                    break;
                default:
                    throw new UnsupportedOperationException("Unknown method: " + this.mMethod.name());
            }
            request.send(context, reportUrl, this.mMethod, reportAsString, this.mType);
        } catch (IOException e) {
            throw new ReportSenderException("Error while sending " + this.config.reportType() + " report via Http " + this.mMethod.name(), e);
        } catch (JSONReportException e2) {
            throw new ReportSenderException("Error while sending " + this.config.reportType() + " report via Http " + this.mMethod.name(), e2);
        }
    }

    @NonNull
    private Map<String, String> remap(@NonNull Map<ReportField, String> report) {
        ReportField[] fields = this.config.customReportContent();
        if (fields.length == 0) {
            fields = ACRAConstants.DEFAULT_REPORT_FIELDS;
        }
        Map<String, String> finalReport = new HashMap(report.size());
        for (ReportField field : fields) {
            if (this.mMapping == null || this.mMapping.get(field) == null) {
                finalReport.put(field.toString(), report.get(field));
            } else {
                finalReport.put(this.mMapping.get(field), report.get(field));
            }
        }
        return finalReport;
    }

    private boolean isNull(@Nullable String aString) {
        return aString == null || ACRAConstants.NULL_VALUE.equals(aString);
    }
}
