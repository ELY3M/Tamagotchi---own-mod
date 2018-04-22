package org.acra.config;

import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.builder.ReportPrimer;
import org.acra.dialog.BaseCrashReportDialog;
import org.acra.dialog.CrashReportDialog;
import org.acra.security.KeyStoreFactory;
import org.acra.sender.HttpSender.Method;
import org.acra.sender.HttpSender.Type;
import org.acra.sender.ReportSenderFactory;

public final class ACRAConfiguration implements Serializable {
    private String[] additionalDropBoxTags;
    private String[] additionalSharedPreferences;
    @Nullable
    private final Class<? extends Annotation> annotationType;
    private String applicationLogFile;
    private int applicationLogFileLines;
    @Nullable
    private Class buildConfigClass;
    private int connectionTimeout;
    private ReportField[] customReportContent;
    private boolean deleteOldUnsentReportsOnApplicationStart;
    private boolean deleteUnapprovedReportsOnApplicationStart;
    private int dropboxCollectionMinutes;
    private String[] excludeMatchingSettingsKeys;
    private String[] excludeMatchingSharedPreferencesKeys;
    private boolean forceCloseDialogAfterToast;
    private String formUri;
    private String formUriBasicAuthLogin;
    private String formUriBasicAuthPassword;
    private final Map<String, String> httpHeaders = new HashMap();
    private Method httpMethod;
    private boolean includeDropBoxSystemTags;
    private KeyStoreFactory keyStoreFactory;
    private String[] logcatArguments;
    private boolean logcatFilterByPid;
    private String mailTo;
    private Class<? extends BaseCrashReportDialog> reportDialogClass;
    private Class<? extends ReportPrimer> reportPrimerClass;
    private Class<? extends ReportSenderFactory>[] reportSenderFactoryClasses;
    private Type reportType;
    private ReportingInteractionMode reportingInteractionMode;
    @StringRes
    private int resDialogCommentPrompt;
    @StringRes
    private int resDialogEmailPrompt;
    @DrawableRes
    private int resDialogIcon;
    @StringRes
    private int resDialogNegativeButtonText;
    @StringRes
    private int resDialogOkToast;
    @StringRes
    private int resDialogPositiveButtonText;
    @StringRes
    private int resDialogText;
    @StringRes
    private int resDialogTitle;
    @DrawableRes
    private int resNotifIcon;
    @StringRes
    private int resNotifText;
    @StringRes
    private int resNotifTickerText;
    @StringRes
    private int resNotifTitle;
    @StringRes
    private int resToastText;
    private boolean sendReportsInDevMode;
    private int sharedPreferencesMode;
    private String sharedPreferencesName;
    private int socketTimeout;

    ACRAConfiguration(@NonNull ConfigurationBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("A ConfigurationBuilder must be supplied to ACRAConfiguration");
        }
        this.annotationType = builder.annotationType;
        this.additionalDropBoxTags = (String[]) copyArray(builder.additionalDropBoxTags());
        this.additionalSharedPreferences = (String[]) copyArray(builder.additionalSharedPreferences());
        this.connectionTimeout = builder.connectionTimeout();
        this.customReportContent = (ReportField[]) copyArray(builder.customReportContent());
        this.deleteUnapprovedReportsOnApplicationStart = builder.deleteUnapprovedReportsOnApplicationStart();
        this.deleteOldUnsentReportsOnApplicationStart = builder.deleteOldUnsentReportsOnApplicationStart();
        this.dropboxCollectionMinutes = builder.dropboxCollectionMinutes();
        this.forceCloseDialogAfterToast = builder.forceCloseDialogAfterToast();
        this.formUri = builder.formUri();
        this.formUriBasicAuthLogin = builder.formUriBasicAuthLogin();
        this.formUriBasicAuthPassword = builder.formUriBasicAuthPassword();
        this.includeDropBoxSystemTags = builder.includeDropBoxSystemTags();
        this.logcatArguments = (String[]) copyArray(builder.logcatArguments());
        this.mailTo = builder.mailTo();
        this.reportingInteractionMode = builder.reportingInteractionMode();
        this.resDialogIcon = builder.resDialogIcon();
        this.resDialogPositiveButtonText = builder.resDialogPositiveButtonText();
        this.resDialogNegativeButtonText = builder.resDialogNegativeButtonText();
        this.resDialogCommentPrompt = builder.resDialogCommentPrompt();
        this.resDialogEmailPrompt = builder.resDialogEmailPrompt();
        this.resDialogOkToast = builder.resDialogOkToast();
        this.resDialogText = builder.resDialogText();
        this.resDialogTitle = builder.resDialogTitle();
        this.resNotifIcon = builder.resNotifIcon();
        this.resNotifText = builder.resNotifText();
        this.resNotifTickerText = builder.resNotifTickerText();
        this.resNotifTitle = builder.resNotifTitle();
        this.resToastText = builder.resToastText();
        this.sharedPreferencesMode = builder.sharedPreferencesMode();
        this.sharedPreferencesName = builder.sharedPreferencesName();
        this.socketTimeout = builder.socketTimeout();
        this.logcatFilterByPid = builder.logcatFilterByPid();
        this.sendReportsInDevMode = builder.sendReportsInDevMode();
        this.excludeMatchingSharedPreferencesKeys = (String[]) copyArray(builder.excludeMatchingSharedPreferencesKeys());
        this.excludeMatchingSettingsKeys = (String[]) copyArray(builder.excludeMatchingSettingsKeys());
        this.buildConfigClass = builder.buildConfigClass();
        this.applicationLogFile = builder.applicationLogFile();
        this.applicationLogFileLines = builder.applicationLogFileLines();
        this.reportDialogClass = builder.reportDialogClass();
        this.reportPrimerClass = builder.reportPrimerClass();
        this.httpMethod = builder.httpMethod();
        this.httpHeaders.putAll(builder.httpHeaders());
        this.reportType = builder.reportType();
        this.reportSenderFactoryClasses = (Class[]) copyArray(builder.reportSenderFactoryClasses());
        this.keyStoreFactory = builder.keyStoreFactory();
    }

    @NonNull
    public ACRAConfiguration setHttpHeaders(@NonNull Map<String, String> headers) {
        this.httpHeaders.clear();
        this.httpHeaders.putAll(headers);
        return this;
    }

    @NonNull
    public Map<String, String> getHttpHeaders() {
        return Collections.unmodifiableMap(this.httpHeaders);
    }

    @NonNull
    public List<ReportField> getReportFields() {
        ReportField[] fieldsList;
        ReportField[] customReportFields = customReportContent();
        if (customReportFields.length != 0) {
            fieldsList = customReportFields;
        } else if (mailTo() == null || "".equals(mailTo())) {
            fieldsList = ACRAConstants.DEFAULT_REPORT_FIELDS;
        } else {
            fieldsList = ACRAConstants.DEFAULT_MAIL_REPORT_FIELDS;
        }
        return Arrays.asList(fieldsList);
    }

    @NonNull
    public ACRAConfiguration setAdditionalDropboxTags(@NonNull String[] additionalDropboxTags) {
        this.additionalDropBoxTags = (String[]) copyArray(additionalDropboxTags);
        return this;
    }

    @NonNull
    public ACRAConfiguration setAdditionalSharedPreferences(@NonNull String[] additionalSharedPreferences) {
        this.additionalSharedPreferences = (String[]) copyArray(additionalSharedPreferences);
        return this;
    }

    @NonNull
    public ACRAConfiguration setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
        return this;
    }

    @NonNull
    public ACRAConfiguration setCustomReportContent(@NonNull ReportField[] customReportContent) {
        this.customReportContent = (ReportField[]) copyArray(customReportContent);
        return this;
    }

    @NonNull
    public ACRAConfiguration setDeleteUnapprovedReportsOnApplicationStart(boolean deleteUnapprovedReportsOnApplicationStart) {
        this.deleteUnapprovedReportsOnApplicationStart = deleteUnapprovedReportsOnApplicationStart;
        return this;
    }

    @NonNull
    public ACRAConfiguration setDeleteOldUnsentReportsOnApplicationStart(boolean deleteOldUnsentReportsOnApplicationStart) {
        this.deleteOldUnsentReportsOnApplicationStart = deleteOldUnsentReportsOnApplicationStart;
        return this;
    }

    @NonNull
    public ACRAConfiguration setDropboxCollectionMinutes(int dropboxCollectionMinutes) {
        this.dropboxCollectionMinutes = dropboxCollectionMinutes;
        return this;
    }

    @NonNull
    public ACRAConfiguration setForceCloseDialogAfterToast(boolean forceCloseDialogAfterToast) {
        this.forceCloseDialogAfterToast = forceCloseDialogAfterToast;
        return this;
    }

    @NonNull
    public ACRAConfiguration setFormUri(@Nullable String formUri) {
        this.formUri = formUri;
        return this;
    }

    @NonNull
    public ACRAConfiguration setFormUriBasicAuthLogin(@Nullable String formUriBasicAuthLogin) {
        this.formUriBasicAuthLogin = formUriBasicAuthLogin;
        return this;
    }

    @NonNull
    public ACRAConfiguration setFormUriBasicAuthPassword(@Nullable String formUriBasicAuthPassword) {
        this.formUriBasicAuthPassword = formUriBasicAuthPassword;
        return this;
    }

    @NonNull
    public ACRAConfiguration setIncludeDropboxSystemTags(boolean includeDropboxSystemTags) {
        this.includeDropBoxSystemTags = includeDropboxSystemTags;
        return this;
    }

    @NonNull
    public ACRAConfiguration setLogcatArguments(@NonNull String[] logcatArguments) {
        this.logcatArguments = (String[]) copyArray(logcatArguments);
        return this;
    }

    @NonNull
    public ACRAConfiguration setMailTo(@Nullable String mailTo) {
        this.mailTo = mailTo;
        return this;
    }

    @NonNull
    public ACRAConfiguration setMode(@NonNull ReportingInteractionMode mode) throws ACRAConfigurationException {
        this.reportingInteractionMode = mode;
        checkCrashResources();
        return this;
    }

    @NonNull
    public ACRAConfiguration setResDialogPositiveButtonText(@StringRes int resId) {
        this.resDialogPositiveButtonText = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setResDialogNegativeButtonText(@StringRes int resId) {
        this.resDialogNegativeButtonText = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setReportDialogClass(@NonNull Class<? extends BaseCrashReportDialog> reportDialogClass) {
        this.reportDialogClass = reportDialogClass;
        return this;
    }

    @NonNull
    public ACRAConfiguration setResDialogCommentPrompt(@StringRes int resId) {
        this.resDialogCommentPrompt = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setResDialogEmailPrompt(@StringRes int resId) {
        this.resDialogEmailPrompt = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setResDialogIcon(@DrawableRes int resId) {
        this.resDialogIcon = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setResDialogOkToast(@StringRes int resId) {
        this.resDialogOkToast = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setResDialogText(@StringRes int resId) {
        this.resDialogText = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setResDialogTitle(@StringRes int resId) {
        this.resDialogTitle = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setResNotifIcon(@DrawableRes int resId) {
        this.resNotifIcon = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setResNotifText(@StringRes int resId) {
        this.resNotifText = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setResNotifTickerText(@StringRes int resId) {
        this.resNotifTickerText = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setResNotifTitle(@StringRes int resId) {
        this.resNotifTitle = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setResToastText(@StringRes int resId) {
        this.resToastText = resId;
        return this;
    }

    @NonNull
    public ACRAConfiguration setSharedPreferenceMode(int sharedPreferenceMode) {
        this.sharedPreferencesMode = sharedPreferenceMode;
        return this;
    }

    @NonNull
    public ACRAConfiguration setSharedPreferenceName(@NonNull String sharedPreferenceName) {
        this.sharedPreferencesName = sharedPreferenceName;
        return this;
    }

    @NonNull
    public ACRAConfiguration setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
        return this;
    }

    @NonNull
    public ACRAConfiguration setLogcatFilterByPid(boolean filterByPid) {
        this.logcatFilterByPid = filterByPid;
        return this;
    }

    @NonNull
    public ACRAConfiguration setSendReportsInDevMode(boolean sendReportsInDevMode) {
        this.sendReportsInDevMode = sendReportsInDevMode;
        return this;
    }

    @NonNull
    public ACRAConfiguration setSendReportsAtShutdown(boolean sendReportsAtShutdown) {
        return this;
    }

    @NonNull
    public ACRAConfiguration setExcludeMatchingSharedPreferencesKeys(@NonNull String[] excludeMatchingSharedPreferencesKeys) {
        this.excludeMatchingSharedPreferencesKeys = (String[]) copyArray(excludeMatchingSharedPreferencesKeys);
        return this;
    }

    @NonNull
    public ACRAConfiguration setExcludeMatchingSettingsKeys(@NonNull String[] excludeMatchingSettingsKeys) {
        this.excludeMatchingSettingsKeys = (String[]) copyArray(excludeMatchingSettingsKeys);
        return this;
    }

    @NonNull
    public ACRAConfiguration setBuildConfigClass(@Nullable Class buildConfigClass) {
        this.buildConfigClass = buildConfigClass;
        return this;
    }

    @NonNull
    public ACRAConfiguration setApplicationLogFile(@NonNull String applicationLogFile) {
        this.applicationLogFile = applicationLogFile;
        return this;
    }

    @NonNull
    public ACRAConfiguration setApplicationLogFileLines(int applicationLogFileLines) {
        this.applicationLogFileLines = applicationLogFileLines;
        return this;
    }

    @NonNull
    public ACRAConfiguration setHttpMethod(@NonNull Method httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    @NonNull
    public ACRAConfiguration setReportType(@NonNull Type type) {
        this.reportType = type;
        return this;
    }

    public void setKeyStore(@Nullable KeyStore keyStore) {
        throw new UnsupportedOperationException("This method is not supported anymore");
    }

    public void setReportSenderFactoryClasses(@NonNull Class<? extends ReportSenderFactory>[] reportSenderFactoryClasses) {
        this.reportSenderFactoryClasses = (Class[]) copyArray(reportSenderFactoryClasses);
    }

    @NonNull
    public String[] additionalDropBoxTags() {
        return (String[]) copyArray(this.additionalDropBoxTags);
    }

    @NonNull
    public String[] additionalSharedPreferences() {
        return (String[]) copyArray(this.additionalSharedPreferences);
    }

    @Nullable
    public Class<? extends Annotation> annotationType() {
        return this.annotationType;
    }

    public int connectionTimeout() {
        return this.connectionTimeout;
    }

    @NonNull
    public ReportField[] customReportContent() {
        return (ReportField[]) copyArray(this.customReportContent);
    }

    public boolean deleteUnapprovedReportsOnApplicationStart() {
        return this.deleteUnapprovedReportsOnApplicationStart;
    }

    public boolean deleteOldUnsentReportsOnApplicationStart() {
        return this.deleteOldUnsentReportsOnApplicationStart;
    }

    public int dropboxCollectionMinutes() {
        return this.dropboxCollectionMinutes;
    }

    public boolean forceCloseDialogAfterToast() {
        return this.forceCloseDialogAfterToast;
    }

    @Nullable
    public String formUri() {
        return this.formUri;
    }

    @Nullable
    public String formUriBasicAuthLogin() {
        return this.formUriBasicAuthLogin;
    }

    @Nullable
    public String formUriBasicAuthPassword() {
        return this.formUriBasicAuthPassword;
    }

    public boolean includeDropBoxSystemTags() {
        return this.includeDropBoxSystemTags;
    }

    @NonNull
    public String[] logcatArguments() {
        return (String[]) copyArray(this.logcatArguments);
    }

    @Nullable
    public String mailTo() {
        return this.mailTo;
    }

    @NonNull
    public ReportingInteractionMode mode() {
        return this.reportingInteractionMode;
    }

    @StringRes
    public int resDialogPositiveButtonText() {
        return this.resDialogPositiveButtonText;
    }

    @StringRes
    public int resDialogNegativeButtonText() {
        return this.resDialogNegativeButtonText;
    }

    @StringRes
    public int resDialogCommentPrompt() {
        return this.resDialogCommentPrompt;
    }

    @StringRes
    public int resDialogEmailPrompt() {
        return this.resDialogEmailPrompt;
    }

    @DrawableRes
    public int resDialogIcon() {
        return this.resDialogIcon;
    }

    @StringRes
    public int resDialogOkToast() {
        return this.resDialogOkToast;
    }

    @StringRes
    public int resDialogText() {
        return this.resDialogText;
    }

    @StringRes
    public int resDialogTitle() {
        return this.resDialogTitle;
    }

    @DrawableRes
    public int resNotifIcon() {
        return this.resNotifIcon;
    }

    @StringRes
    public int resNotifText() {
        return this.resNotifText;
    }

    @StringRes
    public int resNotifTickerText() {
        return this.resNotifTickerText;
    }

    @StringRes
    public int resNotifTitle() {
        return this.resNotifTitle;
    }

    @StringRes
    public int resToastText() {
        return this.resToastText;
    }

    public int sharedPreferencesMode() {
        return this.sharedPreferencesMode;
    }

    @NonNull
    public String sharedPreferencesName() {
        return this.sharedPreferencesName;
    }

    public int socketTimeout() {
        return this.socketTimeout;
    }

    public boolean logcatFilterByPid() {
        return this.logcatFilterByPid;
    }

    public boolean sendReportsInDevMode() {
        return this.sendReportsInDevMode;
    }

    @NonNull
    public String[] excludeMatchingSharedPreferencesKeys() {
        return (String[]) copyArray(this.excludeMatchingSharedPreferencesKeys);
    }

    @NonNull
    public String[] excludeMatchingSettingsKeys() {
        return (String[]) copyArray(this.excludeMatchingSettingsKeys);
    }

    @Nullable
    public Class buildConfigClass() {
        return this.buildConfigClass;
    }

    @NonNull
    public String applicationLogFile() {
        return this.applicationLogFile;
    }

    public int applicationLogFileLines() {
        return this.applicationLogFileLines;
    }

    @NonNull
    public Class<? extends BaseCrashReportDialog> reportDialogClass() {
        return this.reportDialogClass;
    }

    @NonNull
    public Class<? extends ReportPrimer> reportPrimerClass() {
        return this.reportPrimerClass;
    }

    @NonNull
    public Method httpMethod() {
        return this.httpMethod;
    }

    @NonNull
    public Type reportType() {
        return this.reportType;
    }

    @NonNull
    public Class<? extends ReportSenderFactory>[] reportSenderFactoryClasses() {
        return (Class[]) copyArray(this.reportSenderFactoryClasses);
    }

    @Nullable
    public KeyStoreFactory keyStoreFactory() {
        return this.keyStoreFactory;
    }

    public void checkCrashResources() throws ACRAConfigurationException {
        switch (mode()) {
            case TOAST:
                if (resToastText() == 0) {
                    throw new ACRAConfigurationException("TOAST mode: you have to define the resToastText parameter in your application @ReportsCrashes() annotation.");
                }
                return;
            case NOTIFICATION:
                if (resNotifTickerText() == 0 || resNotifTitle() == 0 || resNotifText() == 0) {
                    throw new ACRAConfigurationException("NOTIFICATION mode: you have to define at least the resNotifTickerText, resNotifTitle, resNotifText parameters in your application @ReportsCrashes() annotation.");
                } else if (CrashReportDialog.class.equals(reportDialogClass()) && resDialogText() == 0) {
                    throw new ACRAConfigurationException("NOTIFICATION mode: using the (default) CrashReportDialog requires you have to define the resDialogText parameter in your application @ReportsCrashes() annotation.");
                } else {
                    return;
                }
            case DIALOG:
                if (CrashReportDialog.class.equals(reportDialogClass()) && resDialogText() == 0) {
                    throw new ACRAConfigurationException("DIALOG mode: using the (default) CrashReportDialog requires you to define the resDialogText parameter in your application @ReportsCrashes() annotation.");
                }
                return;
            default:
                return;
        }
    }

    @NonNull
    private static <T> T[] copyArray(@NonNull T[] source) {
        if (VERSION.SDK_INT >= 9) {
            return Arrays.copyOf(source, source.length);
        }
        Object[] result = (Object[]) ((Object[]) Array.newInstance(source.getClass().getComponentType(), source.length));
        System.arraycopy(source, 0, result, 0, source.length);
        return result;
    }
}
