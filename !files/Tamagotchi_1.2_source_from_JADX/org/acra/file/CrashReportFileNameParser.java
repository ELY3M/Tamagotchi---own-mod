package org.acra.file;

import android.support.annotation.NonNull;
import org.acra.ACRAConstants;

public final class CrashReportFileNameParser {
    public boolean isSilent(@NonNull String reportFileName) {
        return reportFileName.contains(ACRAConstants.SILENT_SUFFIX);
    }

    public boolean isApproved(@NonNull String reportFileName) {
        return isSilent(reportFileName) || reportFileName.contains(ACRAConstants.APPROVED_SUFFIX);
    }
}
