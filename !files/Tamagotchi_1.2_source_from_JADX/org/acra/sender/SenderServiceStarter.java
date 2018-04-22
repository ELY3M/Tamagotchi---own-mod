package org.acra.sender;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import org.acra.config.ACRAConfiguration;

public class SenderServiceStarter {
    private final ACRAConfiguration config;
    private final Context context;

    public SenderServiceStarter(@NonNull Context context, @NonNull ACRAConfiguration config) {
        this.context = context;
        this.config = config;
    }

    public void startService(boolean onlySendSilentReports, boolean approveReportsFirst) {
        Intent intent = new Intent(this.context, SenderService.class);
        intent.putExtra(SenderService.EXTRA_ONLY_SEND_SILENT_REPORTS, onlySendSilentReports);
        intent.putExtra(SenderService.EXTRA_APPROVE_REPORTS_FIRST, approveReportsFirst);
        intent.putExtra(SenderService.EXTRA_REPORT_SENDER_FACTORIES, new ArrayList(Arrays.asList(this.config.reportSenderFactoryClasses())));
        intent.putExtra(SenderService.EXTRA_ACRA_CONFIG, this.config);
        this.context.startService(intent);
    }
}
