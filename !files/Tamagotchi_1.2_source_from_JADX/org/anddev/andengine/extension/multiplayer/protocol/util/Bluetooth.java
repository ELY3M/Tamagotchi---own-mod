package org.anddev.andengine.extension.multiplayer.protocol.util;

import android.content.Context;
import org.anddev.andengine.util.SystemUtils;

public class Bluetooth {
    private static Boolean SUPPORTED = null;

    public static boolean isSupported(Context pContext) {
        if (SUPPORTED == null) {
            boolean z = SystemUtils.isAndroidVersionOrHigher(7) && SystemUtils.hasSystemFeature(pContext, "android.hardware.bluetooth");
            SUPPORTED = Boolean.valueOf(z);
        }
        return SUPPORTED.booleanValue();
    }

    public static boolean isSupportedByAndroidVersion() {
        return SystemUtils.isAndroidVersionOrHigher(7);
    }
}
