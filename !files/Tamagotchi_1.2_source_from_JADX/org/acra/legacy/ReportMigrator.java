package org.acra.legacy;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.File;
import java.io.FilenameFilter;
import org.acra.ACRA;
import org.acra.ACRAConstants;
import org.acra.file.CrashReportFileNameParser;
import org.acra.file.ReportLocator;

public final class ReportMigrator {
    private final Context context;
    private final CrashReportFileNameParser fileNameParser = new CrashReportFileNameParser();
    @NonNull
    private final ReportLocator reportLocator;

    class C05911 implements FilenameFilter {
        C05911() {
        }

        public boolean accept(File dir, @NonNull String name) {
            return name.endsWith(ACRAConstants.REPORTFILE_EXTENSION);
        }
    }

    public ReportMigrator(@NonNull Context context) {
        this.context = context;
        this.reportLocator = new ReportLocator(context);
    }

    public void migrate() {
        ACRA.log.mo4046i(ACRA.LOG_TAG, "Migrating unsent ACRA reports to new file locations");
        File[] reportFiles = getCrashReportFiles();
        for (File file : reportFiles) {
            String fileName = file.getName();
            if (this.fileNameParser.isApproved(fileName)) {
                if (file.renameTo(new File(this.reportLocator.getApprovedFolder(), fileName))) {
                }
            } else if (file.renameTo(new File(this.reportLocator.getUnapprovedFolder(), fileName))) {
            }
        }
        ACRA.log.mo4046i(ACRA.LOG_TAG, "Migrated " + reportFiles.length + " unsent reports");
    }

    @NonNull
    private File[] getCrashReportFiles() {
        File dir = this.context.getFilesDir();
        if (dir == null) {
            ACRA.log.mo4050w(ACRA.LOG_TAG, "Application files directory does not exist! The application may not be installed correctly. Please try reinstalling.");
            return new File[0];
        }
        File[] result = dir.listFiles(new C05911());
        return result == null ? new File[0] : result;
    }
}
