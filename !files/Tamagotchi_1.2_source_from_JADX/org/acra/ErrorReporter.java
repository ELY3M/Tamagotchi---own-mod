package org.acra;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.GregorianCalendar;
import org.acra.builder.LastActivityManager;
import org.acra.builder.NoOpReportPrimer;
import org.acra.builder.ReportBuilder;
import org.acra.builder.ReportExecutor;
import org.acra.builder.ReportPrimer;
import org.acra.collector.ConfigurationCollector;
import org.acra.collector.CrashReportDataFactory;
import org.acra.config.ACRAConfiguration;
import org.acra.util.ApplicationStartupProcessor;

public class ErrorReporter implements UncaughtExceptionHandler {
    @NonNull
    private final ACRAConfiguration config;
    private final Application context;
    @NonNull
    private final CrashReportDataFactory crashReportDataFactory;
    @NonNull
    private volatile ExceptionHandlerInitializer exceptionHandlerInitializer = new C08981();
    @NonNull
    private final ReportExecutor reportExecutor;
    private final boolean supportedAndroidVersion;

    class C08981 implements ExceptionHandlerInitializer {
        C08981() {
        }

        public void initializeExceptionHandler(ErrorReporter reporter) {
        }
    }

    class C08992 implements ExceptionHandlerInitializer {
        C08992() {
        }

        public void initializeExceptionHandler(ErrorReporter reporter) {
        }
    }

    ErrorReporter(@NonNull Application context, @NonNull ACRAConfiguration config, @NonNull SharedPreferences prefs, boolean enabled, boolean supportedAndroidVersion, boolean listenForUncaughtExceptions) {
        String initialConfiguration;
        UncaughtExceptionHandler defaultExceptionHandler;
        this.context = context;
        this.config = config;
        this.supportedAndroidVersion = supportedAndroidVersion;
        if (config.getReportFields().contains(ReportField.INITIAL_CONFIGURATION)) {
            initialConfiguration = ConfigurationCollector.collectConfiguration(this.context);
        } else {
            initialConfiguration = null;
        }
        this.crashReportDataFactory = new CrashReportDataFactory(this.context, config, prefs, new GregorianCalendar(), initialConfiguration);
        if (listenForUncaughtExceptions) {
            defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        } else {
            defaultExceptionHandler = null;
        }
        Context context2 = context;
        ACRAConfiguration aCRAConfiguration = config;
        this.reportExecutor = new ReportExecutor(context2, aCRAConfiguration, this.crashReportDataFactory, new LastActivityManager(this.context), defaultExceptionHandler, getReportPrimer(config));
        this.reportExecutor.setEnabled(enabled);
    }

    @Deprecated
    public void addCustomData(@NonNull String key, String value) {
        putCustomData(key, value);
    }

    public String putCustomData(@NonNull String key, String value) {
        return this.crashReportDataFactory.putCustomData(key, value);
    }

    public void setExceptionHandlerInitializer(@Nullable ExceptionHandlerInitializer initializer) {
        if (initializer == null) {
            initializer = new C08992();
        }
        this.exceptionHandlerInitializer = initializer;
    }

    public String removeCustomData(@NonNull String key) {
        return this.crashReportDataFactory.removeCustomData(key);
    }

    public void clearCustomData() {
        this.crashReportDataFactory.clearCustomData();
    }

    public String getCustomData(@NonNull String key) {
        return this.crashReportDataFactory.getCustomData(key);
    }

    public void uncaughtException(@Nullable Thread t, @NonNull Throwable e) {
        if (this.reportExecutor.isEnabled()) {
            try {
                ACRA.log.mo4044e(ACRA.LOG_TAG, "ACRA caught a " + e.getClass().getSimpleName() + " for " + this.context.getPackageName(), e);
                performDeprecatedReportPriming();
                new ReportBuilder().uncaughtExceptionThread(t).exception(e).endApplication().build(this.reportExecutor);
                return;
            } catch (Throwable fatality) {
                ACRA.log.mo4044e(ACRA.LOG_TAG, "ACRA failed to capture the error - handing off to native error reporter", fatality);
                this.reportExecutor.handReportToDefaultExceptionHandler(t, e);
                return;
            }
        }
        this.reportExecutor.handReportToDefaultExceptionHandler(t, e);
    }

    public void handleSilentException(@Nullable Throwable e) {
        performDeprecatedReportPriming();
        new ReportBuilder().exception(e).sendSilently().build(this.reportExecutor);
    }

    public void setEnabled(boolean enabled) {
        if (this.supportedAndroidVersion) {
            ACRA.log.mo4046i(ACRA.LOG_TAG, "ACRA is " + (enabled ? "enabled" : "disabled") + " for " + this.context.getPackageName());
            this.reportExecutor.setEnabled(enabled);
            return;
        }
        ACRA.log.mo4050w(ACRA.LOG_TAG, "ACRA 4.7.0+ requires Froyo or greater. ACRA is disabled and will NOT catch crashes or send messages.");
    }

    public void checkReportsOnApplicationStart() {
        ApplicationStartupProcessor startupProcessor = new ApplicationStartupProcessor(this.context, this.config);
        if (this.config.deleteOldUnsentReportsOnApplicationStart()) {
            startupProcessor.deleteUnsentReportsFromOldAppVersion();
        }
        if (this.config.deleteUnapprovedReportsOnApplicationStart()) {
            startupProcessor.deleteAllUnapprovedReportsBarOne();
        }
        if (this.reportExecutor.isEnabled()) {
            startupProcessor.sendApprovedReports();
        }
    }

    public void handleException(@Nullable Throwable e, boolean endApplication) {
        performDeprecatedReportPriming();
        ReportBuilder builder = new ReportBuilder();
        builder.exception(e);
        if (endApplication) {
            builder.endApplication();
        }
        builder.build(this.reportExecutor);
    }

    public void handleException(@Nullable Throwable e) {
        handleException(e, false);
    }

    private void performDeprecatedReportPriming() {
        try {
            this.exceptionHandlerInitializer.initializeExceptionHandler(this);
        } catch (Exception e) {
            ACRA.log.mo4050w(ACRA.LOG_TAG, "Failed to initialize " + this.exceptionHandlerInitializer + " from #handleException");
        }
    }

    @NonNull
    private static ReportPrimer getReportPrimer(@NonNull ACRAConfiguration config) {
        try {
            return (ReportPrimer) config.reportPrimerClass().newInstance();
        } catch (InstantiationException e) {
            ACRA.log.mo4051w(ACRA.LOG_TAG, "Could not construct ReportPrimer from " + config.reportPrimerClass() + " - not priming", e);
        } catch (IllegalAccessException e2) {
            ACRA.log.mo4051w(ACRA.LOG_TAG, "Could not construct ReportPrimer from " + config.reportPrimerClass() + " - not priming", e2);
        }
        return new NoOpReportPrimer();
    }
}
