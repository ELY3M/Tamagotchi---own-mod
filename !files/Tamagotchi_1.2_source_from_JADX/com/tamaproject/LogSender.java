package com.tamaproject;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.config.ACRAConfiguration;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

public class LogSender implements ReportSender {
    private final ACRAConfiguration config;

    public LogSender(@NonNull ACRAConfiguration config) {
        this.config = config;
    }

    public void send(@NonNull Context context, @NonNull CrashReportData errorContent) throws ReportSenderException {
        String body = buildBody(errorContent);
        Date date = new Date();
        Date time = new Date();
        String logdate = new SimpleDateFormat("EEE MMM, d yyyy").format(date);
        String logtime = new SimpleDateFormat("h:mm:ss").format(time);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), context.getPackageName() + "-crashlogs.txt"), true));
            bufferedWriter.write("------ Crash on " + logdate + " at " + logtime + " ---------------------------------------------------------------------");
            bufferedWriter.newLine();
            bufferedWriter.write(body);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String buildBody(@NonNull CrashReportData errorContent) {
        ReportField[] fields = this.config.customReportContent();
        if (fields.length == 0) {
            fields = ACRAConstants.DEFAULT_REPORT_FIELDS;
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
