package org.acra.file;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.File;
import java.util.Arrays;
import org.acra.ACRA;

public final class BulkReportDeleter {
    @NonNull
    private final ReportLocator reportLocator;

    public BulkReportDeleter(@NonNull Context context) {
        this.reportLocator = new ReportLocator(context);
    }

    public void deleteReports(boolean approved, int nrToKeep) {
        File[] files = approved ? this.reportLocator.getApprovedReports() : this.reportLocator.getUnapprovedReports();
        Arrays.sort(files, new LastModifiedComparator());
        for (int i = 0; i < files.length - nrToKeep; i++) {
            if (!files[i].delete()) {
                ACRA.log.mo4050w(ACRA.LOG_TAG, "Could not delete report : " + files[i]);
            }
        }
    }
}
