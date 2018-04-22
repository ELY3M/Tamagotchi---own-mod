package org.acra.sender;

import android.content.Context;
import android.support.annotation.NonNull;
import org.acra.ACRA;
import org.acra.collector.CrashReportData;

final class NullSender implements ReportSender {
    NullSender() {
    }

    public void send(@NonNull Context context, @NonNull CrashReportData errorContent) throws ReportSenderException {
        ACRA.log.mo4050w(ACRA.LOG_TAG, context.getPackageName() + " reports will NOT be sent - no valid ReportSender is configured. Try setting 'formUri' or 'mailTo'");
    }
}
