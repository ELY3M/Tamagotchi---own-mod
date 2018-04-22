package org.acra.sender;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.NonNull;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.acra.ACRA;
import org.acra.config.ACRAConfiguration;
import org.acra.file.CrashReportFileNameParser;
import org.acra.file.ReportLocator;

public class SenderService extends IntentService {
    public static final String EXTRA_ACRA_CONFIG = "acraConfig";
    public static final String EXTRA_APPROVE_REPORTS_FIRST = "approveReportsFirst";
    public static final String EXTRA_ONLY_SEND_SILENT_REPORTS = "onlySendSilentReports";
    public static final String EXTRA_REPORT_SENDER_FACTORIES = "reportSenderFactories";
    private final ReportLocator locator = new ReportLocator(this);

    public SenderService() {
        super("ACRA SenderService");
    }

    protected void onHandleIntent(@NonNull Intent intent) {
        boolean onlySendSilentReports = intent.getBooleanExtra(EXTRA_ONLY_SEND_SILENT_REPORTS, false);
        boolean approveReportsFirst = intent.getBooleanExtra(EXTRA_APPROVE_REPORTS_FIRST, false);
        ACRAConfiguration config = (ACRAConfiguration) intent.getSerializableExtra(EXTRA_ACRA_CONFIG);
        try {
            List<ReportSender> senderInstances = getSenderInstances(config, (List) intent.getSerializableExtra(EXTRA_REPORT_SENDER_FACTORIES));
            if (approveReportsFirst) {
                markReportsAsApproved();
            }
            File[] reports = this.locator.getApprovedReports();
            ReportDistributor reportDistributor = new ReportDistributor(this, config, senderInstances);
            CrashReportFileNameParser fileNameParser = new CrashReportFileNameParser();
            for (File report : reports) {
                if (!onlySendSilentReports || fileNameParser.isSilent(report.getName())) {
                    if (0 < 5) {
                        reportDistributor.distribute(report);
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            ACRA.log.mo4044e(ACRA.LOG_TAG, "", e);
        }
    }

    @NonNull
    private List<ReportSender> getSenderInstances(@NonNull ACRAConfiguration config, @NonNull List<Class<? extends ReportSenderFactory>> factoryClasses) {
        List<ReportSender> reportSenders = new ArrayList();
        for (Class<? extends ReportSenderFactory> factoryClass : factoryClasses) {
            try {
                reportSenders.add(((ReportSenderFactory) factoryClass.newInstance()).create(getApplication(), config));
            } catch (InstantiationException e) {
                ACRA.log.mo4051w(ACRA.LOG_TAG, "Could not construct ReportSender from " + factoryClass, e);
            } catch (IllegalAccessException e2) {
                ACRA.log.mo4051w(ACRA.LOG_TAG, "Could not construct ReportSender from " + factoryClass, e2);
            }
        }
        return reportSenders;
    }

    private void markReportsAsApproved() {
        for (File report : this.locator.getUnapprovedReports()) {
            File approvedReport = new File(this.locator.getApprovedFolder(), report.getName());
            if (!report.renameTo(approvedReport)) {
                ACRA.log.mo4050w(ACRA.LOG_TAG, "Could not rename approved report from " + report + " to " + approvedReport);
            }
        }
    }
}
