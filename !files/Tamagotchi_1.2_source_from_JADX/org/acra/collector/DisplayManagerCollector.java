package org.acra.collector;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

final class DisplayManagerCollector {
    static final SparseArray<String> mFlagsNames = new SparseArray();

    private DisplayManagerCollector() {
    }

    @NonNull
    public static String collectDisplays(@NonNull Context ctx) {
        StringBuilder result = new StringBuilder();
        for (Display display : VERSION.SDK_INT < 17 ? new Display[]{((WindowManager) ctx.getSystemService("window")).getDefaultDisplay()} : ((DisplayManager) ctx.getSystemService(ISVGConstants.ATTRIBUTE_DISPLAY)).getDisplays()) {
            result.append(collectDisplayData(display));
        }
        return result.toString();
    }

    @NonNull
    private static Object collectDisplayData(@NonNull Display display) {
        display.getMetrics(new DisplayMetrics());
        return collectCurrentSizeRange(display) + collectFlags(display) + display.getDisplayId() + ".height=" + display.getHeight() + '\n' + collectMetrics(display) + collectName(display) + display.getDisplayId() + ".orientation=" + display.getRotation() + '\n' + display.getDisplayId() + ".pixelFormat=" + display.getPixelFormat() + '\n' + collectRealMetrics(display) + collectRealSize(display) + collectRectSize(display) + display.getDisplayId() + ".refreshRate=" + display.getRefreshRate() + '\n' + collectRotation(display) + collectSize(display) + display.getDisplayId() + ".width=" + display.getWidth() + '\n' + collectIsValid(display);
    }

    @NonNull
    private static String collectIsValid(@NonNull Display display) {
        if (VERSION.SDK_INT >= 17) {
            return display.getDisplayId() + ".isValid=" + display.isValid() + '\n';
        }
        return "";
    }

    @NonNull
    private static String collectRotation(@NonNull Display display) {
        return display.getDisplayId() + ".rotation=" + rotationToString(display.getRotation()) + '\n';
    }

    @NonNull
    private static String rotationToString(int rotation) {
        switch (rotation) {
            case 0:
                return "ROTATION_0";
            case 1:
                return "ROTATION_90";
            case 2:
                return "ROTATION_180";
            case 3:
                return "ROTATION_270";
            default:
                return String.valueOf(rotation);
        }
    }

    @NonNull
    private static String collectRectSize(@NonNull Display display) {
        if (VERSION.SDK_INT < 13) {
            return "";
        }
        Rect size = new Rect();
        display.getRectSize(size);
        return display.getDisplayId() + ".rectSize=[" + size.top + ',' + size.left + ',' + size.width() + ',' + size.height() + ']' + '\n';
    }

    @NonNull
    private static String collectSize(@NonNull Display display) {
        if (VERSION.SDK_INT < 13) {
            return "";
        }
        Point size = new Point();
        display.getSize(size);
        return display.getDisplayId() + ".size=[" + size.x + ',' + size.y + ']' + '\n';
    }

    private static String collectRealSize(@NonNull Display display) {
        if (VERSION.SDK_INT < 17) {
            return "";
        }
        Point size = new Point();
        display.getRealSize(size);
        return display.getDisplayId() + ".realSize=[" + size.x + ',' + size.y + ']' + '\n';
    }

    @NonNull
    private static String collectCurrentSizeRange(@NonNull Display display) {
        if (VERSION.SDK_INT < 16) {
            return "";
        }
        Point smallest = new Point();
        Point largest = new Point();
        display.getCurrentSizeRange(smallest, largest);
        return display.getDisplayId() + ".currentSizeRange.smallest=[" + smallest.x + ',' + smallest.y + "]\n" + display.getDisplayId() + ".currentSizeRange.largest=[" + largest.x + ',' + largest.y + "]\n";
    }

    @NonNull
    private static String collectFlags(@NonNull Display display) {
        if (VERSION.SDK_INT < 17) {
            return "";
        }
        int flags = display.getFlags();
        for (Field field : display.getClass().getFields()) {
            if (field.getName().startsWith("FLAG_")) {
                try {
                    mFlagsNames.put(field.getInt(null), field.getName());
                } catch (IllegalAccessException e) {
                }
            }
        }
        return display.getDisplayId() + ".flags=" + activeFlags(mFlagsNames, flags) + '\n';
    }

    @NonNull
    private static String collectName(@NonNull Display display) {
        if (VERSION.SDK_INT >= 17) {
            return display.getDisplayId() + ".name=" + display.getName() + '\n';
        }
        return "";
    }

    @NonNull
    private static String collectMetrics(@NonNull Display display) {
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        return collectMetrics(display.getDisplayId() + ".metrics", metrics);
    }

    @NonNull
    private static String collectRealMetrics(@NonNull Display display) {
        if (VERSION.SDK_INT < 17) {
            return "";
        }
        DisplayMetrics metrics = new DisplayMetrics();
        display.getRealMetrics(metrics);
        return collectMetrics(display.getDisplayId() + ".realMetrics", metrics);
    }

    @NonNull
    private static String collectMetrics(@NonNull String prefix, @NonNull DisplayMetrics metrics) {
        return prefix + ".density=" + metrics.density + '\n' + prefix + ".densityDpi=" + metrics.densityDpi + '\n' + prefix + ".scaledDensity=x" + metrics.scaledDensity + '\n' + prefix + ".widthPixels=" + metrics.widthPixels + '\n' + prefix + ".heightPixels=" + metrics.heightPixels + '\n' + prefix + ".xdpi=" + metrics.xdpi + '\n' + prefix + ".ydpi=" + metrics.ydpi + '\n';
    }

    @NonNull
    private static String activeFlags(@NonNull SparseArray<String> valueNames, int bitfield) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < valueNames.size(); i++) {
            int value = bitfield & valueNames.keyAt(i);
            if (value > 0) {
                if (result.length() > 0) {
                    result.append('+');
                }
                result.append((String) valueNames.get(value));
            }
        }
        return result.toString();
    }
}
