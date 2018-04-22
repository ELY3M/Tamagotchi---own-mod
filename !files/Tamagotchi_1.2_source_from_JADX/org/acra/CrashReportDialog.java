package org.acra;

import android.os.Bundle;

public final class CrashReportDialog extends org.acra.dialog.CrashReportDialog {
    protected void buildAndShowDialog(Bundle savedInstanceState) {
        ACRA.log.mo4050w(ACRA.LOG_TAG, "org.acra.CrashReportDialog has been deprecated. Please use org.acra.dialog.CrashReportDialog instead");
        super.buildAndShowDialog(savedInstanceState);
    }
}
