package org.acra.file;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.File;
import java.util.Arrays;

public final class ReportLocator {
    private static final String APPROVED_FOLDER_NAME = "ACRA-approved";
    private static final String UNAPPROVED_FOLDER_NAME = "ACRA-unapproved";
    private final Context context;

    public ReportLocator(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    public File getUnapprovedFolder() {
        return this.context.getDir(UNAPPROVED_FOLDER_NAME, 0);
    }

    @NonNull
    public File[] getUnapprovedReports() {
        File[] reports = getUnapprovedFolder().listFiles();
        if (reports == null) {
            return new File[0];
        }
        return reports;
    }

    @NonNull
    public File getApprovedFolder() {
        return this.context.getDir(APPROVED_FOLDER_NAME, 0);
    }

    @NonNull
    public File[] getApprovedReports() {
        File[] reports = getApprovedFolder().listFiles();
        if (reports == null) {
            return new File[0];
        }
        Arrays.sort(reports, new LastModifiedComparator());
        return reports;
    }
}
