package org.anddev.andengine.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import org.anddev.andengine.util.constants.Constants;

public class SimplePreferences implements Constants {
    private static Editor EDITORINSTANCE;
    private static SharedPreferences INSTANCE;

    public static SharedPreferences getInstance(Context pContext) {
        if (INSTANCE == null) {
            INSTANCE = PreferenceManager.getDefaultSharedPreferences(pContext);
        }
        return INSTANCE;
    }

    public static Editor getEditorInstance(Context pContext) {
        if (EDITORINSTANCE == null) {
            EDITORINSTANCE = getInstance(pContext).edit();
        }
        return EDITORINSTANCE;
    }

    public static int incrementAccessCount(Context pContext, String pKey) {
        return incrementAccessCount(pContext, pKey, 1);
    }

    public static int incrementAccessCount(Context pContext, String pKey, int pIncrement) {
        SharedPreferences prefs = getInstance(pContext);
        int newAccessCount = prefs.getInt(pKey, 0) + pIncrement;
        prefs.edit().putInt(pKey, newAccessCount).commit();
        return newAccessCount;
    }

    public static int getAccessCount(Context pCtx, String pKey) {
        return getInstance(pCtx).getInt(pKey, 0);
    }
}
