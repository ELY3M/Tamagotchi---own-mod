package org.acra.annotation;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.builder.NoOpReportPrimer;
import org.acra.builder.ReportPrimer;
import org.acra.dialog.BaseCrashReportDialog;
import org.acra.dialog.CrashReportDialog;
import org.acra.sender.DefaultReportSenderFactory;
import org.acra.sender.HttpSender.Method;
import org.acra.sender.HttpSender.Type;
import org.acra.sender.ReportSenderFactory;

@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportsCrashes {
    @NonNull
    String[] additionalDropBoxTags() default {};

    @NonNull
    String[] additionalSharedPreferences() default {};

    @NonNull
    String applicationLogFile() default "";

    int applicationLogFileLines() default 100;

    @NonNull
    Class buildConfigClass() default Object.class;

    int connectionTimeout() default 5000;

    @NonNull
    ReportField[] customReportContent() default {};

    boolean deleteOldUnsentReportsOnApplicationStart() default true;

    boolean deleteUnapprovedReportsOnApplicationStart() default true;

    int dropboxCollectionMinutes() default 5;

    @NonNull
    String[] excludeMatchingSettingsKeys() default {};

    @NonNull
    String[] excludeMatchingSharedPreferencesKeys() default {};

    boolean forceCloseDialogAfterToast() default false;

    @NonNull
    String formUri() default "";

    @NonNull
    String formUriBasicAuthLogin() default "ACRA-NULL-STRING";

    @NonNull
    String formUriBasicAuthPassword() default "ACRA-NULL-STRING";

    @NonNull
    Method httpMethod() default Method.POST;

    boolean includeDropBoxSystemTags() default false;

    @NonNull
    String[] logcatArguments() default {"-t", "100", "-v", "time"};

    boolean logcatFilterByPid() default false;

    @NonNull
    String mailTo() default "";

    @NonNull
    ReportingInteractionMode mode() default ReportingInteractionMode.SILENT;

    @NonNull
    Class<? extends BaseCrashReportDialog> reportDialogClass() default CrashReportDialog.class;

    @NonNull
    Class<? extends ReportPrimer> reportPrimerClass() default NoOpReportPrimer.class;

    @NonNull
    Class<? extends ReportSenderFactory>[] reportSenderFactoryClasses() default {DefaultReportSenderFactory.class};

    @NonNull
    Type reportType() default Type.FORM;

    @StringRes
    int resDialogCommentPrompt() default 0;

    @StringRes
    int resDialogEmailPrompt() default 0;

    @DrawableRes
    int resDialogIcon() default 17301543;

    @StringRes
    int resDialogNegativeButtonText() default 17039360;

    @StringRes
    int resDialogOkToast() default 0;

    @StringRes
    int resDialogPositiveButtonText() default 17039370;

    @StringRes
    int resDialogText() default 0;

    @StringRes
    int resDialogTitle() default 0;

    @DrawableRes
    int resNotifIcon() default 17301624;

    @StringRes
    int resNotifText() default 0;

    @StringRes
    int resNotifTickerText() default 0;

    @StringRes
    int resNotifTitle() default 0;

    @StringRes
    int resToastText() default 0;

    boolean sendReportsAtShutdown() default true;

    boolean sendReportsInDevMode() default true;

    int sharedPreferencesMode() default 0;

    @NonNull
    String sharedPreferencesName() default "";

    int socketTimeout() default 8000;
}
