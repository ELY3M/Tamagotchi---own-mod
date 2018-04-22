package org.acra.util;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.Toast;
import org.acra.ACRA;

public final class ToastSender {
    private ToastSender() {
    }

    public static void sendToast(@NonNull Context context, @StringRes int toastResourceId, @IntRange(from = 0, to = 1) int toastLength) {
        try {
            Toast.makeText(context, toastResourceId, toastLength).show();
        } catch (RuntimeException e) {
            ACRA.log.mo4051w(ACRA.LOG_TAG, "Could not send crash Toast", e);
        }
    }
}
