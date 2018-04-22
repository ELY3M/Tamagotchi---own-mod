package org.acra.sender;

import android.content.Context;
import android.support.annotation.NonNull;
import org.acra.collector.CrashReportData;

public interface ReportSender {
    void send(@NonNull Context context, @NonNull CrashReportData crashReportData) throws ReportSenderException;
}
