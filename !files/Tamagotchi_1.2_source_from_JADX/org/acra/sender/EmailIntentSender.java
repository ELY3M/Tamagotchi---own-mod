package org.acra.sender;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.google.android.gms.drive.DriveFile;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.config.ACRAConfiguration;

public class EmailIntentSender implements ReportSender {
    private final ACRAConfiguration config;

    public EmailIntentSender(@NonNull ACRAConfiguration config) {
        this.config = config;
    }

    public void send(@NonNull Context context, @NonNull CrashReportData errorContent) throws ReportSenderException {
        String subject = context.getPackageName() + " Crash Report";
        String body = buildBody(errorContent);
        Intent emailIntent = new Intent("android.intent.action.SENDTO");
        emailIntent.setData(Uri.fromParts("mailto", this.config.mailTo(), null));
        emailIntent.addFlags(DriveFile.MODE_READ_ONLY);
        emailIntent.putExtra("android.intent.extra.SUBJECT", subject);
        emailIntent.putExtra("android.intent.extra.TEXT", body);
        context.startActivity(emailIntent);
    }

    private String buildBody(@NonNull CrashReportData errorContent) {
        ReportField[] fields = this.config.customReportContent();
        if (fields.length == 0) {
            fields = ACRAConstants.DEFAULT_MAIL_REPORT_FIELDS;
        }
        StringBuilder builder = new StringBuilder();
        for (ReportField field : fields) {
            builder.append(field.toString()).append("=");
            builder.append((String) errorContent.get(field));
            builder.append('\n');
        }
        return builder.toString();
    }
}
