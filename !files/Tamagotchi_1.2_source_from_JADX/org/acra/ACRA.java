package org.acra;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build.VERSION;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import org.acra.annotation.ReportsCrashes;
import org.acra.config.ACRAConfiguration;
import org.acra.config.ACRAConfigurationException;
import org.acra.config.ConfigurationBuilder;
import org.acra.legacy.ReportMigrator;
import org.acra.log.ACRALog;
import org.acra.log.AndroidLogDelegate;
import org.acra.prefs.PrefUtils;
import org.acra.prefs.SharedPreferencesFactory;
import org.acra.util.ApplicationStartupProcessor;

public final class ACRA {
    private static final String ACRA_PRIVATE_PROCESS_NAME = ":acra";
    public static final boolean DEV_LOGGING = false;
    public static final String LOG_TAG = ACRA.class.getSimpleName();
    public static final String PREF_ALWAYS_ACCEPT = "acra.alwaysaccept";
    public static final String PREF_DISABLE_ACRA = "acra.disable";
    public static final String PREF_ENABLE_ACRA = "acra.enable";
    public static final String PREF_ENABLE_DEVICE_ID = "acra.deviceid.enable";
    public static final String PREF_ENABLE_SYSTEM_LOGS = "acra.syslog.enable";
    public static final String PREF_LAST_VERSION_NR = "acra.lastVersionNr";
    public static final String PREF_USER_EMAIL_ADDRESS = "acra.user.email";
    private static final String PREF__LEGACY_ALREADY_CONVERTED_TO_4_8_0 = "acra.legacyAlreadyConvertedTo4.8.0";
    @Nullable
    private static ACRAConfiguration configProxy;
    @Nullable
    private static ErrorReporter errorReporterSingleton;
    @NonNull
    public static ACRALog log = new AndroidLogDelegate();
    private static Application mApplication;
    private static OnSharedPreferenceChangeListener mPrefListener;

    static class C05841 implements OnSharedPreferenceChangeListener {
        C05841() {
        }

        public void onSharedPreferenceChanged(@NonNull SharedPreferences sharedPreferences, String key) {
            if (ACRA.PREF_DISABLE_ACRA.equals(key) || ACRA.PREF_ENABLE_ACRA.equals(key)) {
                ACRA.getErrorReporter().setEnabled(!ACRA.shouldDisableACRA(sharedPreferences));
            }
        }
    }

    private ACRA() {
    }

    public static void init(@NonNull Application app) {
        if (((ReportsCrashes) app.getClass().getAnnotation(ReportsCrashes.class)) == null) {
            log.mo4043e(LOG_TAG, "ACRA#init(Application) called but no ReportsCrashes annotation on Application " + app.getPackageName());
        } else {
            init(app, new ConfigurationBuilder(app).build());
        }
    }

    public static void init(@NonNull Application app, @NonNull ACRAConfiguration config) {
        init(app, config, true);
    }

    public static void init(@NonNull Application app, @NonNull ACRAConfiguration config, boolean checkReportsOnApplicationStart) {
        boolean supportedAndroidVersion;
        boolean z = true;
        boolean senderServiceProcess = isACRASenderServiceProcess(app);
        if (senderServiceProcess) {
        }
        if (VERSION.SDK_INT >= 8) {
            supportedAndroidVersion = true;
        } else {
            supportedAndroidVersion = false;
        }
        if (!supportedAndroidVersion) {
            log.mo4050w(LOG_TAG, "ACRA 4.7.0+ requires Froyo or greater. ACRA is disabled and will NOT catch crashes or send messages.");
        }
        if (mApplication != null) {
            log.mo4050w(LOG_TAG, "ACRA#init called more than once. Won't do anything more.");
            return;
        }
        mApplication = app;
        if (config == null) {
            log.mo4043e(LOG_TAG, "ACRA#init called but no ACRAConfiguration provided");
            return;
        }
        configProxy = config;
        SharedPreferences prefs = new SharedPreferencesFactory(mApplication, configProxy).create();
        try {
            config.checkCrashResources();
            if (!prefs.getBoolean(PREF__LEGACY_ALREADY_CONVERTED_TO_4_8_0, false)) {
                new ReportMigrator(app).migrate();
                PrefUtils.save(prefs.edit().putBoolean(PREF__LEGACY_ALREADY_CONVERTED_TO_4_8_0, true));
            }
            boolean enableAcra = supportedAndroidVersion && !shouldDisableACRA(prefs);
            if (!senderServiceProcess) {
                log.mo4046i(LOG_TAG, "ACRA is " + (enableAcra ? "enabled" : "disabled") + " for " + mApplication.getPackageName() + ", initializing...");
            }
            Application application = mApplication;
            ACRAConfiguration aCRAConfiguration = configProxy;
            if (senderServiceProcess) {
                z = false;
            }
            errorReporterSingleton = new ErrorReporter(application, aCRAConfiguration, prefs, enableAcra, supportedAndroidVersion, z);
            if (checkReportsOnApplicationStart && !senderServiceProcess) {
                ApplicationStartupProcessor startupProcessor = new ApplicationStartupProcessor(mApplication, config);
                if (config.deleteOldUnsentReportsOnApplicationStart()) {
                    startupProcessor.deleteUnsentReportsFromOldAppVersion();
                }
                if (config.deleteUnapprovedReportsOnApplicationStart()) {
                    startupProcessor.deleteAllUnapprovedReportsBarOne();
                }
                if (enableAcra) {
                    startupProcessor.sendApprovedReports();
                }
            }
        } catch (ACRAConfigurationException e) {
            log.mo4051w(LOG_TAG, "Error : ", e);
        }
        mPrefListener = new C05841();
        prefs.registerOnSharedPreferenceChangeListener(mPrefListener);
    }

    public static boolean isInitialised() {
        return configProxy != null;
    }

    private static boolean isACRASenderServiceProcess(@NonNull Application app) {
        String processName = getCurrentProcessName(app);
        return processName != null && processName.endsWith(ACRA_PRIVATE_PROCESS_NAME);
    }

    @Nullable
    private static String getCurrentProcessName(@NonNull Application app) {
        int processId = Process.myPid();
        for (RunningAppProcessInfo processInfo : ((ActivityManager) app.getSystemService("activity")).getRunningAppProcesses()) {
            if (processInfo.pid == processId) {
                return processInfo.processName;
            }
        }
        return null;
    }

    @NonNull
    public static ErrorReporter getErrorReporter() {
        if (errorReporterSingleton != null) {
            return errorReporterSingleton;
        }
        throw new IllegalStateException("Cannot access ErrorReporter before ACRA#init");
    }

    private static boolean shouldDisableACRA(@NonNull SharedPreferences prefs) {
        boolean z = true;
        boolean disableAcra = false;
        try {
            boolean enableAcra = prefs.getBoolean(PREF_ENABLE_ACRA, true);
            String str = PREF_DISABLE_ACRA;
            if (enableAcra) {
                z = false;
            }
            disableAcra = prefs.getBoolean(str, z);
        } catch (Exception e) {
        }
        return disableAcra;
    }

    @NonNull
    public static SharedPreferences getACRASharedPreferences() {
        if (configProxy != null) {
            return new SharedPreferencesFactory(mApplication, configProxy).create();
        }
        throw new IllegalStateException("Cannot call ACRA.getACRASharedPreferences() before ACRA.init().");
    }

    @NonNull
    public static ACRAConfiguration getConfig() {
        if (configProxy != null) {
            return configProxy;
        }
        throw new IllegalStateException("Cannot call ACRA.getConfig() before ACRA.init().");
    }

    @NonNull
    public static ACRAConfiguration getNewDefaultConfig(@NonNull Application app) {
        return new ConfigurationBuilder(app).build();
    }

    public static void setLog(@NonNull ACRALog log) {
        if (log == null) {
            throw new NullPointerException("ACRALog cannot be null");
        }
        log = log;
    }
}
