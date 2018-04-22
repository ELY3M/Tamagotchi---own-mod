package org.acra.prefs;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

public final class PrefUtils {
    private PrefUtils() {
    }

    public static void save(@NonNull Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
