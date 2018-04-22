package org.anddev.andengine.extension.input.touch.controller;

import android.content.Context;
import org.anddev.andengine.util.SystemUtils;

public class MultiTouch {
    private static Boolean SUPPORTED = null;
    private static Boolean SUPPORTED_DISTINCT = null;

    public static boolean isSupportedByAndroidVersion() {
        return SystemUtils.isAndroidVersionOrHigher(5);
    }

    public static boolean isSupported(Context pContext) {
        if (SUPPORTED == null) {
            boolean z = SystemUtils.isAndroidVersionOrHigher(5) && SystemUtils.hasSystemFeature(pContext, "android.hardware.touchscreen.multitouch");
            SUPPORTED = Boolean.valueOf(z);
        }
        return SUPPORTED.booleanValue();
    }

    public static boolean isSupportedDistinct(Context pContext) {
        if (SUPPORTED_DISTINCT == null) {
            boolean z = SystemUtils.isAndroidVersionOrHigher(7) && SystemUtils.hasSystemFeature(pContext, "android.hardware.touchscreen.multitouch.distinct");
            SUPPORTED_DISTINCT = Boolean.valueOf(z);
        }
        return SUPPORTED_DISTINCT.booleanValue();
    }
}
