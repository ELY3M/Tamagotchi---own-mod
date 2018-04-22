package org.anddev.andengine.util;

import android.app.Dialog;

public class DialogUtils {
    public static void keepScreenOn(Dialog pDialog) {
        pDialog.getWindow().addFlags(128);
    }
}
