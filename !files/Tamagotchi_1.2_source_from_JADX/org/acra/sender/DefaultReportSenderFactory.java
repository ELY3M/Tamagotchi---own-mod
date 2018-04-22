package org.acra.sender;

import android.content.Context;
import android.support.annotation.NonNull;
import org.acra.ACRA;
import org.acra.config.ACRAConfiguration;
import org.acra.util.PackageManagerWrapper;

public final class DefaultReportSenderFactory implements ReportSenderFactory {
    @NonNull
    public ReportSender create(@NonNull Context context, @NonNull ACRAConfiguration config) {
        PackageManagerWrapper pm = new PackageManagerWrapper(context);
        if (!"".equals(config.mailTo())) {
            ACRA.log.mo4050w(ACRA.LOG_TAG, context.getPackageName() + " reports will be sent by email (if accepted by user).");
            return new EmailIntentSenderFactory().create(context, config);
        } else if (!pm.hasPermission("android.permission.INTERNET")) {
            ACRA.log.mo4043e(ACRA.LOG_TAG, context.getPackageName() + " should be granted permission " + "android.permission.INTERNET" + " if you want your crash reports to be sent. If you don't want to add this permission to your application you can also enable sending reports by email. If this is your will then provide your email address in @AcraConfig(mailTo=\"your.account@domain.com\"");
            return new NullSender();
        } else if (config.formUri() == null || "".equals(config.formUri())) {
            return new NullSender();
        } else {
            return new HttpSenderFactory().create(context, config);
        }
    }
}
