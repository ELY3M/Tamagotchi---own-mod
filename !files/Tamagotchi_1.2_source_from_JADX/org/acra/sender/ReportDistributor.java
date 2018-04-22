package org.acra.sender;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.acra.ACRA;
import org.acra.collector.CrashReportData;
import org.acra.config.ACRAConfiguration;
import org.acra.file.CrashReportPersister;

final class ReportDistributor {
    private final ACRAConfiguration config;
    private final Context context;
    private final List<ReportSender> reportSenders;

    public ReportDistributor(@NonNull Context context, @NonNull ACRAConfiguration config, @NonNull List<ReportSender> reportSenders) {
        this.context = context;
        this.config = config;
        this.reportSenders = reportSenders;
    }

    public void distribute(@NonNull File reportFile) {
        ACRA.log.mo4046i(ACRA.LOG_TAG, "Sending report " + reportFile);
        try {
            sendCrashReport(new CrashReportPersister().load(reportFile));
            deleteFile(reportFile);
        } catch (RuntimeException e) {
            ACRA.log.mo4044e(ACRA.LOG_TAG, "Failed to send crash reports for " + reportFile, e);
            deleteFile(reportFile);
        } catch (IOException e2) {
            ACRA.log.mo4044e(ACRA.LOG_TAG, "Failed to load crash report for " + reportFile, e2);
            deleteFile(reportFile);
        } catch (ReportSenderException e3) {
            ACRA.log.mo4044e(ACRA.LOG_TAG, "Failed to send crash report for " + reportFile, e3);
        }
    }

    private void sendCrashReport(@NonNull CrashReportData errorContent) throws ReportSenderException {
        if (!isDebuggable() || this.config.sendReportsInDevMode()) {
            boolean sentAtLeastOnce = false;
            ReportSenderException sendFailure = null;
            String failedSender = null;
            for (ReportSender sender : this.reportSenders) {
                try {
                    sender.send(this.context, errorContent);
                    sentAtLeastOnce = true;
                } catch (ReportSenderException e) {
                    sendFailure = e;
                    failedSender = sender.getClass().getName();
                }
            }
            if (sendFailure == null) {
                return;
            }
            if (sentAtLeastOnce) {
                ACRA.log.mo4050w(ACRA.LOG_TAG, "ReportSender of class " + failedSender + " failed but other senders completed their task. ACRA will not send this report again.");
                return;
            }
            throw sendFailure;
        }
    }

    private void deleteFile(@NonNull File file) {
        if (!file.delete()) {
            ACRA.log.mo4050w(ACRA.LOG_TAG, "Could not delete error report : " + file);
        }
    }

    private boolean isDebuggable() {
        try {
            if ((this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 0).flags & 2) > 0) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
