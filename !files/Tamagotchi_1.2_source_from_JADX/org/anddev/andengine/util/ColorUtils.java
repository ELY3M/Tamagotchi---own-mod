package org.anddev.andengine.util;

import android.graphics.Color;
import org.anddev.andengine.util.constants.ColorConstants;

public class ColorUtils {
    private static final int COLOR_FLOAT_TO_INT_FACTOR = 255;
    private static final float[] HSV_TO_COLOR = new float[3];
    private static final int HSV_TO_COLOR_HUE_INDEX = 0;
    private static final int HSV_TO_COLOR_SATURATION_INDEX = 1;
    private static final int HSV_TO_COLOR_VALUE_INDEX = 2;

    public static int HSVToColor(float pHue, float pSaturation, float pValue) {
        HSV_TO_COLOR[0] = pHue;
        HSV_TO_COLOR[1] = pSaturation;
        HSV_TO_COLOR[2] = pValue;
        return Color.HSVToColor(HSV_TO_COLOR);
    }

    public static int RGBToColor(float pRed, float pGreen, float pBlue) {
        return Color.rgb((int) (pRed * ColorConstants.COLOR_FACTOR_INT_TO_FLOAT), (int) (pGreen * ColorConstants.COLOR_FACTOR_INT_TO_FLOAT), (int) (ColorConstants.COLOR_FACTOR_INT_TO_FLOAT * pBlue));
    }
}
