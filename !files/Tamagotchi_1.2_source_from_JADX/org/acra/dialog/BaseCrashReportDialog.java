package org.acra.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import org.acra.ACRA;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.config.ACRAConfiguration;
import org.acra.file.BulkReportDeleter;
import org.acra.file.CrashReportPersister;
import org.acra.sender.SenderServiceStarter;
import org.acra.util.ToastSender;

public abstract class BaseCrashReportDialog extends Activity {
    private ACRAConfiguration config;
    private Throwable exception;
    private File reportFile;

    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.config = (ACRAConfiguration) getIntent().getSerializableExtra(ACRAConstants.EXTRA_REPORT_CONFIG);
        if (this.config == null) {
            throw new IllegalStateException("CrashReportDialog has to be called with extra ACRAConstants#EXTRA_REPORT_CONFIG");
        } else if (getIntent().getBooleanExtra(ACRAConstants.EXTRA_FORCE_CANCEL, false)) {
            cancelReports();
            finish();
        } else {
            this.reportFile = (File) getIntent().getSerializableExtra(ACRAConstants.EXTRA_REPORT_FILE);
            if (this.reportFile == null) {
                throw new IllegalStateException("CrashReportDialog has to be called with extra ACRAConstants#EXTRA_REPORT_FILE");
            }
            this.exception = (Throwable) getIntent().getSerializableExtra(ACRAConstants.EXTRA_REPORT_EXCEPTION);
        }
    }

    @CallSuper
    protected void cancelReports() {
        new BulkReportDeleter(getApplicationContext()).deleteReports(false, 0);
    }

    @CallSuper
    protected void sendCrash(@Nullable String comment, @Nullable String userEmail) {
        CrashReportPersister persister = new CrashReportPersister();
        try {
            CrashReportData crashData = persister.load(this.reportFile);
            Enum enumR = ReportField.USER_COMMENT;
            if (comment == null) {
                comment = "";
            }
            crashData.put(enumR, comment);
            enumR = ReportField.USER_EMAIL;
            if (userEmail == null) {
                userEmail = "";
            }
            crashData.put(enumR, userEmail);
            persister.store(crashData, this.reportFile);
        } catch (IOException e) {
            ACRA.log.mo4051w(ACRA.LOG_TAG, "User comment not added: ", e);
        }
        new SenderServiceStarter(getApplicationContext(), this.config).startService(false, true);
        int toastId = this.config.resDialogOkToast();
        if (toastId != 0) {
            ToastSender.sendToast(getApplicationContext(), toastId, 1);
        }
    }

    protected final ACRAConfiguration getConfig() {
        return this.config;
    }

    protected final Throwable getException() {
        return this.exception;
    }
}
