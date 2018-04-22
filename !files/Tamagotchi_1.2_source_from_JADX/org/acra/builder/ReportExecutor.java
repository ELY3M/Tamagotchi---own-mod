package org.acra.builder;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.Builder;
import com.google.android.gms.drive.DriveFile;
import java.io.File;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;
import org.acra.ACRA;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.collector.CrashReportData;
import org.acra.collector.CrashReportDataFactory;
import org.acra.config.ACRAConfiguration;
import org.acra.file.CrashReportPersister;
import org.acra.file.ReportLocator;
import org.acra.prefs.SharedPreferencesFactory;
import org.acra.sender.SenderServiceStarter;
import org.acra.util.ToastSender;

public final class ReportExecutor {
    private static final int THREAD_SLEEP_INTERVAL_MILLIS = 100;
    private static int mNotificationCounter = 0;
    private final ACRAConfiguration config;
    private final Context context;
    private final CrashReportDataFactory crashReportDataFactory;
    private final UncaughtExceptionHandler defaultExceptionHandler;
    private boolean enabled = false;
    private final LastActivityManager lastActivityManager;
    private final ReportPrimer reportPrimer;

    private static class TimeHelper {
        private Long initialTimeMillis;

        private TimeHelper() {
        }

        public void setInitialTimeMillis(long initialTimeMillis) {
            this.initialTimeMillis = Long.valueOf(initialTimeMillis);
        }

        public long getElapsedTime() {
            return this.initialTimeMillis == null ? 0 : System.currentTimeMillis() - this.initialTimeMillis.longValue();
        }
    }

    public ReportExecutor(@NonNull Context context, @NonNull ACRAConfiguration config, @NonNull CrashReportDataFactory crashReportDataFactory, @NonNull LastActivityManager lastActivityManager, @Nullable UncaughtExceptionHandler defaultExceptionHandler, @NonNull ReportPrimer reportPrimer) {
        this.context = context;
        this.config = config;
        this.crashReportDataFactory = crashReportDataFactory;
        this.lastActivityManager = lastActivityManager;
        this.defaultExceptionHandler = defaultExceptionHandler;
        this.reportPrimer = reportPrimer;
    }

    public void handReportToDefaultExceptionHandler(@Nullable Thread t, @NonNull Throwable e) {
        if (this.defaultExceptionHandler != null) {
            ACRA.log.mo4046i(ACRA.LOG_TAG, "ACRA is disabled for " + this.context.getPackageName() + " - forwarding uncaught Exception on to default ExceptionHandler");
            this.defaultExceptionHandler.uncaughtException(t, e);
            return;
        }
        ACRA.log.mo4043e(ACRA.LOG_TAG, "ACRA is disabled for " + this.context.getPackageName() + " - no default ExceptionHandler");
        ACRA.log.mo4044e(ACRA.LOG_TAG, "ACRA caught a " + e.getClass().getSimpleName() + " for " + this.context.getPackageName(), e);
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void execute(@NonNull ReportBuilder reportBuilder) {
        if (this.enabled) {
            ReportingInteractionMode reportingInteractionMode;
            boolean shouldDisplayToast;
            boolean showDirectDialog;
            this.reportPrimer.primeReport(this.context, reportBuilder);
            boolean sendOnlySilentReports = false;
            if (reportBuilder.isSendSilently()) {
                reportingInteractionMode = ReportingInteractionMode.SILENT;
                if (this.config.mode() != ReportingInteractionMode.SILENT) {
                    sendOnlySilentReports = true;
                }
            } else {
                reportingInteractionMode = this.config.mode();
            }
            if (reportingInteractionMode == ReportingInteractionMode.TOAST || (this.config.resToastText() != 0 && (reportingInteractionMode == ReportingInteractionMode.NOTIFICATION || reportingInteractionMode == ReportingInteractionMode.DIALOG))) {
                shouldDisplayToast = true;
            } else {
                shouldDisplayToast = false;
            }
            final TimeHelper sentToastTimeMillis = new TimeHelper();
            if (shouldDisplayToast) {
                new Thread() {
                    public void run() {
                        Looper.prepare();
                        ToastSender.sendToast(ReportExecutor.this.context, ReportExecutor.this.config.resToastText(), 1);
                        sentToastTimeMillis.setInitialTimeMillis(System.currentTimeMillis());
                        Looper.loop();
                    }
                }.start();
            }
            CrashReportData crashReportData = this.crashReportDataFactory.createCrashData(reportBuilder);
            final File reportFile = getReportFileName(crashReportData);
            saveCrashReportFile(reportFile, crashReportData);
            SharedPreferences prefs = new SharedPreferencesFactory(this.context, this.config).create();
            if (reportingInteractionMode == ReportingInteractionMode.SILENT || reportingInteractionMode == ReportingInteractionMode.TOAST || prefs.getBoolean(ACRA.PREF_ALWAYS_ACCEPT, false)) {
                startSendingReports(sendOnlySilentReports, true);
                if (reportingInteractionMode == ReportingInteractionMode.SILENT && !reportBuilder.isEndApplication()) {
                    return;
                }
            } else if (reportingInteractionMode == ReportingInteractionMode.NOTIFICATION) {
                createNotification(reportFile, reportBuilder);
            }
            if (reportingInteractionMode != ReportingInteractionMode.DIALOG || prefs.getBoolean(ACRA.PREF_ALWAYS_ACCEPT, false)) {
                showDirectDialog = false;
            } else {
                showDirectDialog = true;
            }
            if (shouldDisplayToast) {
                final ReportBuilder reportBuilder2 = reportBuilder;
                new Thread() {
                    public void run() {
                        while (sentToastTimeMillis.getElapsedTime() < 2000) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                            }
                        }
                        ReportExecutor.this.dialogAndEnd(reportBuilder2, reportFile, showDirectDialog);
                    }
                }.start();
                return;
            }
            dialogAndEnd(reportBuilder, reportFile, showDirectDialog);
            return;
        }
        ACRA.log.mo4048v(ACRA.LOG_TAG, "ACRA is disabled. Report not sent.");
    }

    private void dialogAndEnd(@NonNull ReportBuilder reportBuilder, @NonNull File reportFile, boolean shouldShowDialog) {
        if (shouldShowDialog) {
            Intent dialogIntent = createCrashReportDialogIntent(reportFile, reportBuilder);
            dialogIntent.setFlags(DriveFile.MODE_READ_ONLY);
            this.context.startActivity(dialogIntent);
        }
        if (reportBuilder.isEndApplication()) {
            endApplication(reportBuilder.getUncaughtExceptionThread(), reportBuilder.getException());
        }
    }

    private void endApplication(@Nullable Thread uncaughtExceptionThread, Throwable th) {
        boolean handlingUncaughtException = true;
        boolean letDefaultHandlerEndApplication;
        if (this.config.mode() == ReportingInteractionMode.SILENT || (this.config.mode() == ReportingInteractionMode.TOAST && this.config.forceCloseDialogAfterToast())) {
            letDefaultHandlerEndApplication = true;
        } else {
            letDefaultHandlerEndApplication = false;
        }
        if (uncaughtExceptionThread == null) {
            handlingUncaughtException = false;
        }
        if (handlingUncaughtException && letDefaultHandlerEndApplication && this.defaultExceptionHandler != null) {
            this.defaultExceptionHandler.uncaughtException(uncaughtExceptionThread, th);
            return;
        }
        Activity lastActivity = this.lastActivityManager.getLastActivity();
        if (lastActivity != null) {
            lastActivity.finish();
            this.lastActivityManager.clearLastActivity();
        }
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    private void startSendingReports(boolean onlySendSilentReports, boolean approveReportsFirst) {
        if (this.enabled) {
            new SenderServiceStarter(this.context, this.config).startService(onlySendSilentReports, approveReportsFirst);
        } else {
            ACRA.log.mo4050w(ACRA.LOG_TAG, "Would be sending reports, but ACRA is disabled");
        }
    }

    private void createNotification(@NonNull File reportFile, @NonNull ReportBuilder reportBuilder) {
        NotificationManager notificationManager = (NotificationManager) this.context.getSystemService("notification");
        int icon = this.config.resNotifIcon();
        CharSequence tickerText = this.context.getText(this.config.resNotifTickerText());
        long when = System.currentTimeMillis();
        Intent crashReportDialogIntent = createCrashReportDialogIntent(reportFile, reportBuilder);
        Context context = this.context;
        int i = mNotificationCounter;
        mNotificationCounter = i + 1;
        PendingIntent contentIntent = PendingIntent.getActivity(context, i, crashReportDialogIntent, 134217728);
        CharSequence contentTitle = this.context.getText(this.config.resNotifTitle());
        Notification notification = new Builder(this.context).setSmallIcon(icon).setTicker(tickerText).setWhen(when).setAutoCancel(true).setContentTitle(contentTitle).setContentText(this.context.getText(this.config.resNotifText())).setContentIntent(contentIntent).build();
        notification.flags |= 16;
        Intent deleteIntent = createCrashReportDialogIntent(reportFile, reportBuilder);
        deleteIntent.putExtra(ACRAConstants.EXTRA_FORCE_CANCEL, true);
        notification.deleteIntent = PendingIntent.getActivity(this.context, -1, deleteIntent, 0);
        notificationManager.notify(ACRAConstants.NOTIF_CRASH_ID, notification);
    }

    @NonNull
    private File getReportFileName(@NonNull CrashReportData crashData) {
        String timestamp = crashData.getProperty(ReportField.USER_CRASH_DATE);
        String isSilent = crashData.getProperty(ReportField.IS_SILENT);
        StringBuilder append = new StringBuilder().append("");
        if (timestamp == null) {
            timestamp = Long.valueOf(new Date().getTime());
        }
        return new File(new ReportLocator(this.context).getUnapprovedFolder(), append.append(timestamp).append(isSilent != null ? ACRAConstants.SILENT_SUFFIX : "").append(ACRAConstants.REPORTFILE_EXTENSION).toString());
    }

    private void saveCrashReportFile(@NonNull File file, @NonNull CrashReportData crashData) {
        try {
            new CrashReportPersister().store(crashData, file);
        } catch (Exception e) {
            ACRA.log.mo4044e(ACRA.LOG_TAG, "An error occurred while writing the report file...", e);
        }
    }

    @NonNull
    private Intent createCrashReportDialogIntent(@NonNull File reportFile, @NonNull ReportBuilder reportBuilder) {
        Intent dialogIntent = new Intent(this.context, this.config.reportDialogClass());
        dialogIntent.putExtra(ACRAConstants.EXTRA_REPORT_FILE, reportFile);
        dialogIntent.putExtra(ACRAConstants.EXTRA_REPORT_EXCEPTION, reportBuilder.getException());
        dialogIntent.putExtra(ACRAConstants.EXTRA_REPORT_CONFIG, this.config);
        return dialogIntent;
    }
}
