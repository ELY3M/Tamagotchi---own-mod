package org.acra.sender;

import android.content.Context;
import android.support.annotation.NonNull;
import org.acra.config.ACRAConfiguration;

public interface ReportSenderFactory {
    @NonNull
    ReportSender create(@NonNull Context context, @NonNull ACRAConfiguration aCRAConfiguration);
}
