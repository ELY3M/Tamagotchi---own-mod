package org.acra.config;

import android.app.Application;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.builder.NoOpReportPrimer;
import org.acra.builder.ReportPrimer;
import org.acra.dialog.BaseCrashReportDialog;
import org.acra.dialog.CrashReportDialog;
import org.acra.security.KeyStoreFactory;
import org.acra.sender.DefaultReportSenderFactory;
import org.acra.sender.HttpSender.Method;
import org.acra.sender.HttpSender.Type;
import org.acra.sender.ReportSenderFactory;

public final class ConfigurationBuilder {
    private String[] additionalDropBoxTags;
    private String[] additionalSharedPreferences;
    @Nullable
    final Class<? extends Annotation> annotationType;
    private String applicationLogFile;
    private Integer applicationLogFileLines;
    private Class buildConfigClass;
    private Integer connectionTimeout;
    private ReportField[] customReportContent;
    private Boolean deleteOldUnsentReportsOnApplicationStart;
    private Boolean deleteUnapprovedReportsOnApplicationStart;
    private Integer dropboxCollectionMinutes;
    private String[] excludeMatchingSettingsKeys;
    private String[] excludeMatchingSharedPreferencesKeys;
    private Boolean forceCloseDialogAfterToast;
    private String formUri;
    private String formUriBasicAuthLogin;
    private String formUriBasicAuthPassword;
    private final Map<String, String> httpHeaders = new HashMap();
    private Method httpMethod;
    private Boolean includeDropBoxSystemTags;
    private KeyStoreFactory keyStoreFactory;
    private String[] logcatArguments;
    private Boolean logcatFilterByPid;
    private String mailTo;
    private Class<? extends BaseCrashReportDialog> reportDialogClass;
    private Class<? extends ReportPrimer> reportPrimerClass;
    private Class<? extends ReportSenderFactory>[] reportSenderFactoryClasses;
    private Type reportType;
    private ReportingInteractionMode reportingInteractionMode;
    @StringRes
    private Integer resDialogCommentPrompt;
    @StringRes
    private Integer resDialogEmailPrompt;
    @DrawableRes
    private Integer resDialogIcon;
    @StringRes
    private Integer resDialogNegativeButtonText;
    @StringRes
    private Integer resDialogOkToast;
    @StringRes
    private Integer resDialogPositiveButtonText;
    @StringRes
    private Integer resDialogText;
    @StringRes
    private Integer resDialogTitle;
    @DrawableRes
    private Integer resNotifIcon;
    @StringRes
    private Integer resNotifText;
    @StringRes
    private Integer resNotifTickerText;
    @StringRes
    private Integer resNotifTitle;
    @StringRes
    private Integer resToastText;
    private Boolean sendReportsInDevMode;
    private Integer sharedPreferencesMode;
    private String sharedPreferencesName;
    private Integer socketTimeout;

    public ConfigurationBuilder(@NonNull Application app) {
        ReportsCrashes annotationConfig = (ReportsCrashes) app.getClass().getAnnotation(ReportsCrashes.class);
        if (annotationConfig != null) {
            this.annotationType = annotationConfig.annotationType();
            this.additionalDropBoxTags = annotationConfig.additionalDropBoxTags();
            this.additionalSharedPreferences = annotationConfig.additionalSharedPreferences();
            this.connectionTimeout = Integer.valueOf(annotationConfig.connectionTimeout());
            this.customReportContent = annotationConfig.customReportContent();
            this.deleteUnapprovedReportsOnApplicationStart = Boolean.valueOf(annotationConfig.deleteUnapprovedReportsOnApplicationStart());
            this.deleteOldUnsentReportsOnApplicationStart = Boolean.valueOf(annotationConfig.deleteOldUnsentReportsOnApplicationStart());
            this.dropboxCollectionMinutes = Integer.valueOf(annotationConfig.dropboxCollectionMinutes());
            this.forceCloseDialogAfterToast = Boolean.valueOf(annotationConfig.forceCloseDialogAfterToast());
            this.formUri = annotationConfig.formUri();
            this.formUriBasicAuthLogin = annotationConfig.formUriBasicAuthLogin();
            this.formUriBasicAuthPassword = annotationConfig.formUriBasicAuthPassword();
            this.includeDropBoxSystemTags = Boolean.valueOf(annotationConfig.includeDropBoxSystemTags());
            this.logcatArguments = annotationConfig.logcatArguments();
            this.mailTo = annotationConfig.mailTo();
            this.reportingInteractionMode = annotationConfig.mode();
            this.resDialogIcon = Integer.valueOf(annotationConfig.resDialogIcon());
            this.resDialogPositiveButtonText = Integer.valueOf(annotationConfig.resDialogPositiveButtonText());
            this.resDialogNegativeButtonText = Integer.valueOf(annotationConfig.resDialogNegativeButtonText());
            this.resDialogCommentPrompt = Integer.valueOf(annotationConfig.resDialogCommentPrompt());
            this.resDialogEmailPrompt = Integer.valueOf(annotationConfig.resDialogEmailPrompt());
            this.resDialogOkToast = Integer.valueOf(annotationConfig.resDialogOkToast());
            this.resDialogText = Integer.valueOf(annotationConfig.resDialogText());
            this.resDialogTitle = Integer.valueOf(annotationConfig.resDialogTitle());
            this.resNotifIcon = Integer.valueOf(annotationConfig.resNotifIcon());
            this.resNotifText = Integer.valueOf(annotationConfig.resNotifText());
            this.resNotifTickerText = Integer.valueOf(annotationConfig.resNotifTickerText());
            this.resNotifTitle = Integer.valueOf(annotationConfig.resNotifTitle());
            this.resToastText = Integer.valueOf(annotationConfig.resToastText());
            this.sharedPreferencesMode = Integer.valueOf(annotationConfig.sharedPreferencesMode());
            this.sharedPreferencesName = annotationConfig.sharedPreferencesName();
            this.socketTimeout = Integer.valueOf(annotationConfig.socketTimeout());
            this.logcatFilterByPid = Boolean.valueOf(annotationConfig.logcatFilterByPid());
            this.sendReportsInDevMode = Boolean.valueOf(annotationConfig.sendReportsInDevMode());
            this.excludeMatchingSharedPreferencesKeys = annotationConfig.excludeMatchingSharedPreferencesKeys();
            this.excludeMatchingSettingsKeys = annotationConfig.excludeMatchingSettingsKeys();
            this.buildConfigClass = annotationConfig.buildConfigClass();
            this.applicationLogFile = annotationConfig.applicationLogFile();
            this.applicationLogFileLines = Integer.valueOf(annotationConfig.applicationLogFileLines());
            this.reportDialogClass = annotationConfig.reportDialogClass();
            this.reportPrimerClass = annotationConfig.reportPrimerClass();
            this.httpMethod = annotationConfig.httpMethod();
            this.reportType = annotationConfig.reportType();
            this.reportSenderFactoryClasses = annotationConfig.reportSenderFactoryClasses();
            return;
        }
        this.annotationType = null;
    }

    @NonNull
    public ACRAConfiguration build() {
        return new ACRAConfiguration(this);
    }

    @NonNull
    public ConfigurationBuilder setHttpHeaders(@NonNull Map<String, String> headers) {
        this.httpHeaders.clear();
        this.httpHeaders.putAll(headers);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setAdditionalDropboxTags(@NonNull String[] additionalDropboxTags) {
        this.additionalDropBoxTags = additionalDropboxTags;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setAdditionalSharedPreferences(@NonNull String[] additionalSharedPreferences) {
        this.additionalSharedPreferences = additionalSharedPreferences;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = Integer.valueOf(connectionTimeout);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setCustomReportContent(@NonNull ReportField[] customReportContent) {
        this.customReportContent = customReportContent;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setDeleteUnapprovedReportsOnApplicationStart(boolean deleteUnapprovedReportsOnApplicationStart) {
        this.deleteUnapprovedReportsOnApplicationStart = Boolean.valueOf(deleteUnapprovedReportsOnApplicationStart);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setDeleteOldUnsentReportsOnApplicationStart(boolean deleteOldUnsentReportsOnApplicationStart) {
        this.deleteOldUnsentReportsOnApplicationStart = Boolean.valueOf(deleteOldUnsentReportsOnApplicationStart);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setDropboxCollectionMinutes(int dropboxCollectionMinutes) {
        this.dropboxCollectionMinutes = Integer.valueOf(dropboxCollectionMinutes);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setForceCloseDialogAfterToast(boolean forceCloseDialogAfterToast) {
        this.forceCloseDialogAfterToast = Boolean.valueOf(forceCloseDialogAfterToast);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setFormUri(@Nullable String formUri) {
        this.formUri = formUri;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setFormUriBasicAuthLogin(@Nullable String formUriBasicAuthLogin) {
        this.formUriBasicAuthLogin = formUriBasicAuthLogin;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setFormUriBasicAuthPassword(@Nullable String formUriBasicAuthPassword) {
        this.formUriBasicAuthPassword = formUriBasicAuthPassword;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setIncludeDropboxSystemTags(boolean includeDropboxSystemTags) {
        this.includeDropBoxSystemTags = Boolean.valueOf(includeDropboxSystemTags);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setLogcatArguments(@NonNull String[] logcatArguments) {
        this.logcatArguments = logcatArguments;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setMailTo(@Nullable String mailTo) {
        this.mailTo = mailTo;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setMode(@NonNull ReportingInteractionMode mode) throws ACRAConfigurationException {
        this.reportingInteractionMode = mode;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setReportingInteractionMode(@NonNull ReportingInteractionMode mode) throws ACRAConfigurationException {
        this.reportingInteractionMode = mode;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResDialogPositiveButtonText(@StringRes int resId) {
        this.resDialogPositiveButtonText = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResDialogNegativeButtonText(@StringRes int resId) {
        this.resDialogNegativeButtonText = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setReportDialogClass(@NonNull Class<? extends BaseCrashReportDialog> reportDialogClass) {
        this.reportDialogClass = reportDialogClass;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResDialogCommentPrompt(@StringRes int resId) {
        this.resDialogCommentPrompt = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResDialogEmailPrompt(@StringRes int resId) {
        this.resDialogEmailPrompt = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResDialogIcon(@DrawableRes int resId) {
        this.resDialogIcon = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResDialogOkToast(@StringRes int resId) {
        this.resDialogOkToast = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResDialogText(@StringRes int resId) {
        this.resDialogText = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResDialogTitle(@StringRes int resId) {
        this.resDialogTitle = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResNotifIcon(@DrawableRes int resId) {
        this.resNotifIcon = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResNotifText(@StringRes int resId) {
        this.resNotifText = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResNotifTickerText(@StringRes int resId) {
        this.resNotifTickerText = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResNotifTitle(@StringRes int resId) {
        this.resNotifTitle = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setResToastText(@StringRes int resId) {
        this.resToastText = Integer.valueOf(resId);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setSharedPreferenceMode(int sharedPreferenceMode) {
        this.sharedPreferencesMode = Integer.valueOf(sharedPreferenceMode);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setSharedPreferenceName(@NonNull String sharedPreferenceName) {
        this.sharedPreferencesName = sharedPreferenceName;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setSocketTimeout(int socketTimeout) {
        this.socketTimeout = Integer.valueOf(socketTimeout);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setLogcatFilterByPid(boolean filterByPid) {
        this.logcatFilterByPid = Boolean.valueOf(filterByPid);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setSendReportsInDevMode(boolean sendReportsInDevMode) {
        this.sendReportsInDevMode = Boolean.valueOf(sendReportsInDevMode);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setSendReportsAtShutdown(boolean sendReportsAtShutdown) {
        return this;
    }

    @NonNull
    public ConfigurationBuilder setExcludeMatchingSharedPreferencesKeys(@NonNull String[] excludeMatchingSharedPreferencesKeys) {
        this.excludeMatchingSharedPreferencesKeys = excludeMatchingSharedPreferencesKeys;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setExcludeMatchingSettingsKeys(@NonNull String[] excludeMatchingSettingsKeys) {
        this.excludeMatchingSettingsKeys = excludeMatchingSettingsKeys;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setBuildConfigClass(@Nullable Class buildConfigClass) {
        this.buildConfigClass = buildConfigClass;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setApplicationLogFile(@NonNull String applicationLogFile) {
        this.applicationLogFile = applicationLogFile;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setApplicationLogFileLines(int applicationLogFileLines) {
        this.applicationLogFileLines = Integer.valueOf(applicationLogFileLines);
        return this;
    }

    @NonNull
    public ConfigurationBuilder setHttpMethod(@NonNull Method httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setReportType(@NonNull Type type) {
        this.reportType = type;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setKeyStoreFactory(KeyStoreFactory keyStoreFactory) {
        this.keyStoreFactory = keyStoreFactory;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setReportSenderFactoryClasses(@NonNull Class<? extends ReportSenderFactory>[] reportSenderFactoryClasses) {
        this.reportSenderFactoryClasses = reportSenderFactoryClasses;
        return this;
    }

    @NonNull
    public ConfigurationBuilder setReportPrimerClass(@NonNull Class<? extends ReportPrimer> reportPrimerClass) {
        this.reportPrimerClass = reportPrimerClass;
        return this;
    }

    @NonNull
    String[] additionalDropBoxTags() {
        if (this.additionalDropBoxTags != null) {
            return this.additionalDropBoxTags;
        }
        return new String[0];
    }

    @NonNull
    String[] additionalSharedPreferences() {
        if (this.additionalSharedPreferences != null) {
            return this.additionalSharedPreferences;
        }
        return new String[0];
    }

    @Nullable
    Class<? extends Annotation> annotationType() {
        return this.annotationType;
    }

    int connectionTimeout() {
        if (this.connectionTimeout != null) {
            return this.connectionTimeout.intValue();
        }
        return 5000;
    }

    @NonNull
    ReportField[] customReportContent() {
        if (this.customReportContent != null) {
            return this.customReportContent;
        }
        return new ReportField[0];
    }

    boolean deleteUnapprovedReportsOnApplicationStart() {
        if (this.deleteUnapprovedReportsOnApplicationStart != null) {
            return this.deleteUnapprovedReportsOnApplicationStart.booleanValue();
        }
        return true;
    }

    boolean deleteOldUnsentReportsOnApplicationStart() {
        if (this.deleteOldUnsentReportsOnApplicationStart != null) {
            return this.deleteOldUnsentReportsOnApplicationStart.booleanValue();
        }
        return true;
    }

    int dropboxCollectionMinutes() {
        if (this.dropboxCollectionMinutes != null) {
            return this.dropboxCollectionMinutes.intValue();
        }
        return 5;
    }

    boolean forceCloseDialogAfterToast() {
        if (this.forceCloseDialogAfterToast != null) {
            return this.forceCloseDialogAfterToast.booleanValue();
        }
        return false;
    }

    @NonNull
    String formUri() {
        if (this.formUri != null) {
            return this.formUri;
        }
        return "";
    }

    @NonNull
    String formUriBasicAuthLogin() {
        if (this.formUriBasicAuthLogin != null) {
            return this.formUriBasicAuthLogin;
        }
        return ACRAConstants.NULL_VALUE;
    }

    @NonNull
    String formUriBasicAuthPassword() {
        if (this.formUriBasicAuthPassword != null) {
            return this.formUriBasicAuthPassword;
        }
        return ACRAConstants.NULL_VALUE;
    }

    boolean includeDropBoxSystemTags() {
        if (this.includeDropBoxSystemTags != null) {
            return this.includeDropBoxSystemTags.booleanValue();
        }
        return false;
    }

    @NonNull
    String[] logcatArguments() {
        if (this.logcatArguments != null) {
            return this.logcatArguments;
        }
        return new String[]{"-t", Integer.toString(100), "-v", "time"};
    }

    @NonNull
    String mailTo() {
        if (this.mailTo != null) {
            return this.mailTo;
        }
        return "";
    }

    @NonNull
    ReportingInteractionMode reportingInteractionMode() {
        if (this.reportingInteractionMode != null) {
            return this.reportingInteractionMode;
        }
        return ReportingInteractionMode.SILENT;
    }

    @StringRes
    public int resDialogPositiveButtonText() {
        if (this.resDialogPositiveButtonText != null) {
            return this.resDialogPositiveButtonText.intValue();
        }
        return 0;
    }

    @StringRes
    int resDialogNegativeButtonText() {
        if (this.resDialogNegativeButtonText != null) {
            return this.resDialogNegativeButtonText.intValue();
        }
        return 0;
    }

    @StringRes
    int resDialogCommentPrompt() {
        if (this.resDialogCommentPrompt != null) {
            return this.resDialogCommentPrompt.intValue();
        }
        return 0;
    }

    @StringRes
    int resDialogEmailPrompt() {
        if (this.resDialogEmailPrompt != null) {
            return this.resDialogEmailPrompt.intValue();
        }
        return 0;
    }

    @DrawableRes
    int resDialogIcon() {
        if (this.resDialogIcon != null) {
            return this.resDialogIcon.intValue();
        }
        return ACRAConstants.DEFAULT_DIALOG_ICON;
    }

    @StringRes
    int resDialogOkToast() {
        if (this.resDialogOkToast != null) {
            return this.resDialogOkToast.intValue();
        }
        return 0;
    }

    @StringRes
    int resDialogText() {
        if (this.resDialogText != null) {
            return this.resDialogText.intValue();
        }
        return 0;
    }

    @StringRes
    int resDialogTitle() {
        if (this.resDialogTitle != null) {
            return this.resDialogTitle.intValue();
        }
        return 0;
    }

    @DrawableRes
    int resNotifIcon() {
        if (this.resNotifIcon != null) {
            return this.resNotifIcon.intValue();
        }
        return ACRAConstants.DEFAULT_NOTIFICATION_ICON;
    }

    @StringRes
    int resNotifText() {
        if (this.resNotifText != null) {
            return this.resNotifText.intValue();
        }
        return 0;
    }

    @StringRes
    int resNotifTickerText() {
        if (this.resNotifTickerText != null) {
            return this.resNotifTickerText.intValue();
        }
        return 0;
    }

    @StringRes
    int resNotifTitle() {
        if (this.resNotifTitle != null) {
            return this.resNotifTitle.intValue();
        }
        return 0;
    }

    @StringRes
    int resToastText() {
        if (this.resToastText != null) {
            return this.resToastText.intValue();
        }
        return 0;
    }

    int sharedPreferencesMode() {
        if (this.sharedPreferencesMode != null) {
            return this.sharedPreferencesMode.intValue();
        }
        return 0;
    }

    @NonNull
    String sharedPreferencesName() {
        if (this.sharedPreferencesName != null) {
            return this.sharedPreferencesName;
        }
        return "";
    }

    int socketTimeout() {
        if (this.socketTimeout != null) {
            return this.socketTimeout.intValue();
        }
        return 8000;
    }

    boolean logcatFilterByPid() {
        if (this.logcatFilterByPid != null) {
            return this.logcatFilterByPid.booleanValue();
        }
        return false;
    }

    boolean sendReportsInDevMode() {
        if (this.sendReportsInDevMode != null) {
            return this.sendReportsInDevMode.booleanValue();
        }
        return true;
    }

    @NonNull
    String[] excludeMatchingSharedPreferencesKeys() {
        if (this.excludeMatchingSharedPreferencesKeys != null) {
            return this.excludeMatchingSharedPreferencesKeys;
        }
        return new String[0];
    }

    @NonNull
    String[] excludeMatchingSettingsKeys() {
        if (this.excludeMatchingSettingsKeys != null) {
            return this.excludeMatchingSettingsKeys;
        }
        return new String[0];
    }

    @Nullable
    Class buildConfigClass() {
        return this.buildConfigClass;
    }

    @NonNull
    String applicationLogFile() {
        if (this.applicationLogFile != null) {
            return this.applicationLogFile;
        }
        return "";
    }

    int applicationLogFileLines() {
        if (this.applicationLogFileLines != null) {
            return this.applicationLogFileLines.intValue();
        }
        return 100;
    }

    @NonNull
    Class<? extends BaseCrashReportDialog> reportDialogClass() {
        if (this.reportDialogClass != null) {
            return this.reportDialogClass;
        }
        return CrashReportDialog.class;
    }

    @NonNull
    Class<? extends ReportPrimer> reportPrimerClass() {
        if (this.reportPrimerClass != null) {
            return this.reportPrimerClass;
        }
        return NoOpReportPrimer.class;
    }

    @NonNull
    Method httpMethod() {
        if (this.httpMethod != null) {
            return this.httpMethod;
        }
        return Method.POST;
    }

    @NonNull
    Type reportType() {
        if (this.reportType != null) {
            return this.reportType;
        }
        return Type.FORM;
    }

    @NonNull
    Class<? extends ReportSenderFactory>[] reportSenderFactoryClasses() {
        if (this.reportSenderFactoryClasses != null) {
            return this.reportSenderFactoryClasses;
        }
        return new Class[]{DefaultReportSenderFactory.class};
    }

    @Nullable
    KeyStoreFactory keyStoreFactory() {
        return this.keyStoreFactory;
    }

    @NonNull
    Map<String, String> httpHeaders() {
        return this.httpHeaders;
    }
}
