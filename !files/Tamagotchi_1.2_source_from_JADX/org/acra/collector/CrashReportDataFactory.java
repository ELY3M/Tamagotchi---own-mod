package org.acra.collector;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.ACRAConfiguration;
import org.acra.util.Installation;
import org.acra.util.PackageManagerWrapper;
import org.acra.util.ReportUtils;

public final class CrashReportDataFactory {
    private final Calendar appStartDate;
    private final ACRAConfiguration config;
    private final Context context;
    private final Map<String, String> customParameters = new LinkedHashMap();
    private final String initialConfiguration;
    private final SharedPreferences prefs;

    public CrashReportDataFactory(@NonNull Context context, @NonNull ACRAConfiguration config, @NonNull SharedPreferences prefs, @NonNull Calendar appStartDate, @Nullable String initialConfiguration) {
        this.context = context;
        this.config = config;
        this.prefs = prefs;
        this.appStartDate = appStartDate;
        this.initialConfiguration = initialConfiguration;
    }

    public String putCustomData(@NonNull String key, String value) {
        return (String) this.customParameters.put(key, value);
    }

    public String removeCustomData(@NonNull String key) {
        return (String) this.customParameters.remove(key);
    }

    public void clearCustomData() {
        this.customParameters.clear();
    }

    public String getCustomData(@NonNull String key) {
        return (String) this.customParameters.get(key);
    }

    @NonNull
    public CrashReportData createCrashData(@NonNull ReportBuilder builder) {
        CrashReportData crashReportData = new CrashReportData();
        List<ReportField> crashReportFields = this.config.getReportFields();
        try {
            crashReportData.put(ReportField.STACK_TRACE, getStackTrace(builder.getMessage(), builder.getException()));
        } catch (RuntimeException e) {
            ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving STACK_TRACE data", e);
        }
        try {
            PackageManagerWrapper pm = new PackageManagerWrapper(this.context);
            boolean hasReadLogsPermission = pm.hasPermission("android.permission.READ_LOGS") || VERSION.SDK_INT >= 16;
            if (this.prefs.getBoolean(ACRA.PREF_ENABLE_SYSTEM_LOGS, true) && hasReadLogsPermission) {
                LogCatCollector logCatCollector = new LogCatCollector();
                if (crashReportFields.contains(ReportField.LOGCAT)) {
                    try {
                        crashReportData.put(ReportField.LOGCAT, logCatCollector.collectLogCat(this.config, null));
                    } catch (RuntimeException e2) {
                        ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving LOGCAT data", e2);
                    }
                }
                if (crashReportFields.contains(ReportField.EVENTSLOG)) {
                    try {
                        crashReportData.put(ReportField.EVENTSLOG, logCatCollector.collectLogCat(this.config, "events"));
                    } catch (RuntimeException e22) {
                        ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving EVENTSLOG data", e22);
                    }
                }
                if (crashReportFields.contains(ReportField.RADIOLOG)) {
                    try {
                        crashReportData.put(ReportField.RADIOLOG, logCatCollector.collectLogCat(this.config, "radio"));
                    } catch (RuntimeException e222) {
                        ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving RADIOLOG data", e222);
                    }
                }
                if (crashReportFields.contains(ReportField.DROPBOX)) {
                    try {
                        crashReportData.put(ReportField.DROPBOX, new DropBoxCollector().read(this.context, this.config));
                    } catch (RuntimeException e2222) {
                        ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving DROPBOX data", e2222);
                    }
                }
            }
            try {
                crashReportData.put(ReportField.USER_APP_START_DATE, ReportUtils.getTimeString(this.appStartDate));
            } catch (RuntimeException e22222) {
                ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving USER_APP_START_DATE data", e22222);
            }
            if (builder.isSendSilently()) {
                crashReportData.put(ReportField.IS_SILENT, "true");
            }
            try {
                crashReportData.put(ReportField.REPORT_ID, UUID.randomUUID().toString());
            } catch (RuntimeException e222222) {
                ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving REPORT_ID data", e222222);
            }
            try {
                crashReportData.put(ReportField.USER_CRASH_DATE, ReportUtils.getTimeString(new GregorianCalendar()));
            } catch (RuntimeException e2222222) {
                ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving USER_CRASH_DATE data", e2222222);
            }
            if (crashReportFields.contains(ReportField.STACK_TRACE_HASH)) {
                try {
                    crashReportData.put(ReportField.STACK_TRACE_HASH, getStackTraceHash(builder.getException()));
                } catch (RuntimeException e22222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving STACK_TRACE_HASH data", e22222222);
                }
            }
            if (crashReportFields.contains(ReportField.INSTALLATION_ID)) {
                try {
                    crashReportData.put(ReportField.INSTALLATION_ID, Installation.id(this.context));
                } catch (RuntimeException e222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving INSTALLATION_ID data", e222222222);
                }
            }
            if (crashReportFields.contains(ReportField.INITIAL_CONFIGURATION)) {
                try {
                    crashReportData.put(ReportField.INITIAL_CONFIGURATION, this.initialConfiguration);
                } catch (RuntimeException e2222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving INITIAL_CONFIGURATION data", e2222222222);
                }
            }
            if (crashReportFields.contains(ReportField.CRASH_CONFIGURATION)) {
                try {
                    crashReportData.put(ReportField.CRASH_CONFIGURATION, ConfigurationCollector.collectConfiguration(this.context));
                } catch (RuntimeException e22222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving CRASH_CONFIGURATION data", e22222222222);
                }
            }
            if (!(builder.getException() instanceof OutOfMemoryError) && crashReportFields.contains(ReportField.DUMPSYS_MEMINFO)) {
                try {
                    crashReportData.put(ReportField.DUMPSYS_MEMINFO, DumpSysCollector.collectMemInfo());
                } catch (RuntimeException e222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving DUMPSYS_MEMINFO data", e222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.PACKAGE_NAME)) {
                try {
                    crashReportData.put(ReportField.PACKAGE_NAME, this.context.getPackageName());
                } catch (RuntimeException e2222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving PACKAGE_NAME data", e2222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.BUILD)) {
                try {
                    crashReportData.put(ReportField.BUILD, ReflectionCollector.collectConstants(Build.class) + ReflectionCollector.collectConstants(VERSION.class, "VERSION"));
                } catch (RuntimeException e22222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving BUILD data", e22222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.PHONE_MODEL)) {
                try {
                    crashReportData.put(ReportField.PHONE_MODEL, Build.MODEL);
                } catch (RuntimeException e222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving PHONE_MODEL data", e222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.ANDROID_VERSION)) {
                try {
                    crashReportData.put(ReportField.ANDROID_VERSION, VERSION.RELEASE);
                } catch (RuntimeException e2222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving ANDROID_VERSION data", e2222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.BRAND)) {
                try {
                    crashReportData.put(ReportField.BRAND, Build.BRAND);
                } catch (RuntimeException e22222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving BRAND data", e22222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.PRODUCT)) {
                try {
                    crashReportData.put(ReportField.PRODUCT, Build.PRODUCT);
                } catch (RuntimeException e222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving PRODUCT data", e222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.TOTAL_MEM_SIZE)) {
                try {
                    crashReportData.put(ReportField.TOTAL_MEM_SIZE, Long.toString(ReportUtils.getTotalInternalMemorySize()));
                } catch (RuntimeException e2222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving TOTAL_MEM_SIZE data", e2222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.AVAILABLE_MEM_SIZE)) {
                try {
                    crashReportData.put(ReportField.AVAILABLE_MEM_SIZE, Long.toString(ReportUtils.getAvailableInternalMemorySize()));
                } catch (RuntimeException e22222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving AVAILABLE_MEM_SIZE data", e22222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.FILE_PATH)) {
                try {
                    crashReportData.put(ReportField.FILE_PATH, ReportUtils.getApplicationFilePath(this.context));
                } catch (RuntimeException e222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving FILE_PATH data", e222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.DISPLAY)) {
                try {
                    crashReportData.put(ReportField.DISPLAY, DisplayManagerCollector.collectDisplays(this.context));
                } catch (RuntimeException e2222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving DISPLAY data", e2222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.CUSTOM_DATA)) {
                try {
                    crashReportData.put(ReportField.CUSTOM_DATA, createCustomInfoString(builder.getCustomData()));
                } catch (RuntimeException e22222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving CUSTOM_DATA data", e22222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.BUILD_CONFIG)) {
                try {
                    crashReportData.put(ReportField.BUILD_CONFIG, ReflectionCollector.collectConstants(getBuildConfigClass()));
                } catch (ClassNotFoundException e3) {
                } catch (RuntimeException e222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving BUILD_CONFIG data", e222222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.USER_EMAIL)) {
                try {
                    crashReportData.put(ReportField.USER_EMAIL, this.prefs.getString(ACRA.PREF_USER_EMAIL_ADDRESS, "N/A"));
                } catch (RuntimeException e2222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving USER_EMAIL data", e2222222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.DEVICE_FEATURES)) {
                try {
                    crashReportData.put(ReportField.DEVICE_FEATURES, DeviceFeaturesCollector.getFeatures(this.context));
                } catch (RuntimeException e22222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving DEVICE_FEATURES data", e22222222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.ENVIRONMENT)) {
                try {
                    crashReportData.put(ReportField.ENVIRONMENT, ReflectionCollector.collectStaticGettersResults(Environment.class));
                } catch (RuntimeException e222222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving ENVIRONMENT data", e222222222222222222222222222);
                }
            }
            SettingsCollector settingsCollector = new SettingsCollector(this.context, this.config);
            if (crashReportFields.contains(ReportField.SETTINGS_SYSTEM)) {
                try {
                    crashReportData.put(ReportField.SETTINGS_SYSTEM, settingsCollector.collectSystemSettings());
                } catch (RuntimeException e2222222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving SETTINGS_SYSTEM data", e2222222222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.SETTINGS_SECURE)) {
                try {
                    crashReportData.put(ReportField.SETTINGS_SECURE, settingsCollector.collectSecureSettings());
                } catch (RuntimeException e22222222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving SETTINGS_SECURE data", e22222222222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.SETTINGS_GLOBAL)) {
                try {
                    crashReportData.put(ReportField.SETTINGS_GLOBAL, settingsCollector.collectGlobalSettings());
                } catch (RuntimeException e222222222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving SETTINGS_GLOBAL data", e222222222222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.SHARED_PREFERENCES)) {
                try {
                    crashReportData.put(ReportField.SHARED_PREFERENCES, new SharedPreferencesCollector(this.context, this.config).collect());
                } catch (RuntimeException e2222222222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving SHARED_PREFERENCES data", e2222222222222222222222222222222);
                }
            }
            try {
                PackageInfo pi = pm.getPackageInfo();
                if (pi != null) {
                    if (crashReportFields.contains(ReportField.APP_VERSION_CODE)) {
                        crashReportData.put(ReportField.APP_VERSION_CODE, Integer.toString(pi.versionCode));
                    }
                    if (crashReportFields.contains(ReportField.APP_VERSION_NAME)) {
                        Object obj;
                        Enum enumR = ReportField.APP_VERSION_NAME;
                        if (pi.versionName != null) {
                            obj = pi.versionName;
                        } else {
                            obj = "not set";
                        }
                        crashReportData.put(enumR, obj);
                    }
                } else {
                    crashReportData.put(ReportField.APP_VERSION_NAME, "Package info unavailable");
                }
            } catch (RuntimeException e22222222222222222222222222222222) {
                ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving APP_VERSION_CODE and APP_VERSION_NAME data", e22222222222222222222222222222222);
            }
            if (crashReportFields.contains(ReportField.DEVICE_ID) && this.prefs.getBoolean(ACRA.PREF_ENABLE_DEVICE_ID, true) && pm.hasPermission("android.permission.READ_PHONE_STATE")) {
                try {
                    String deviceId = ReportUtils.getDeviceId(this.context);
                    if (deviceId != null) {
                        crashReportData.put(ReportField.DEVICE_ID, deviceId);
                    }
                } catch (RuntimeException e222222222222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving DEVICE_ID data", e222222222222222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.APPLICATION_LOG)) {
                try {
                    crashReportData.put(ReportField.APPLICATION_LOG, new LogFileCollector().collectLogFile(this.context, this.config.applicationLogFile(), this.config.applicationLogFileLines()));
                } catch (IOException e4) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while reading application log file " + this.config.applicationLogFile(), e4);
                } catch (RuntimeException e2222222222222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving APPLICATION_LOG data", e2222222222222222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.MEDIA_CODEC_LIST)) {
                try {
                    crashReportData.put(ReportField.MEDIA_CODEC_LIST, MediaCodecListCollector.collectMediaCodecList());
                } catch (RuntimeException e22222222222222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving MEDIA_CODEC_LIST data", e22222222222222222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.THREAD_DETAILS)) {
                try {
                    crashReportData.put(ReportField.THREAD_DETAILS, ThreadCollector.collect(builder.getUncaughtExceptionThread()));
                } catch (RuntimeException e222222222222222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving THREAD_DETAILS data", e222222222222222222222222222222222222);
                }
            }
            if (crashReportFields.contains(ReportField.USER_IP)) {
                try {
                    crashReportData.put(ReportField.USER_IP, ReportUtils.getLocalIpAddress());
                } catch (RuntimeException e2222222222222222222222222222222222222) {
                    ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving USER_IP data", e2222222222222222222222222222222222222);
                }
            }
        } catch (RuntimeException e22222222222222222222222222222222222222) {
            ACRA.log.mo4044e(ACRA.LOG_TAG, "Error while retrieving crash data", e22222222222222222222222222222222222222);
        }
        return crashReportData;
    }

    @NonNull
    private String createCustomInfoString(@Nullable Map<String, String> reportCustomData) {
        Map<String, String> params = this.customParameters;
        if (reportCustomData != null) {
            Map<String, String> params2 = new HashMap(params);
            params2.putAll(reportCustomData);
            params = params2;
        }
        StringBuilder customInfo = new StringBuilder();
        for (Entry<String, String> currentEntry : params.entrySet()) {
            customInfo.append((String) currentEntry.getKey());
            customInfo.append(" = ");
            String currentVal = (String) currentEntry.getValue();
            if (currentVal != null) {
                customInfo.append(currentVal.replaceAll("\n", "\\\\n"));
            } else {
                customInfo.append("null");
            }
            customInfo.append("\n");
        }
        return customInfo.toString();
    }

    @NonNull
    private String getStackTrace(@Nullable String msg, @Nullable Throwable th) {
        Writer result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        if (!(msg == null || TextUtils.isEmpty(msg))) {
            printWriter.println(msg);
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        String stacktraceAsString = result.toString();
        printWriter.close();
        return stacktraceAsString;
    }

    @NonNull
    private String getStackTraceHash(@Nullable Throwable th) {
        StringBuilder res = new StringBuilder();
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            for (StackTraceElement e : cause.getStackTrace()) {
                res.append(e.getClassName());
                res.append(e.getMethodName());
            }
        }
        return Integer.toHexString(res.toString().hashCode());
    }

    @NonNull
    private Class<?> getBuildConfigClass() throws ClassNotFoundException {
        Class configuredBuildConfig = this.config.buildConfigClass();
        if (configuredBuildConfig == null || configuredBuildConfig.equals(Object.class)) {
            String className = this.context.getPackageName() + ".BuildConfig";
            try {
                configuredBuildConfig = Class.forName(className);
            } catch (ClassNotFoundException e) {
                ACRA.log.mo4043e(ACRA.LOG_TAG, "Not adding buildConfig to log. Class Not found : " + className + ". Please configure 'buildConfigClass' in your ACRA config");
                throw e;
            }
        }
        return configuredBuildConfig;
    }
}
