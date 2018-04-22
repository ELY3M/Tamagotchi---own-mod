package org.anddev.andengine.util.modifier.ease;

import android.util.FloatMath;
import org.anddev.andengine.util.constants.MathConstants;

public class EaseSineOut implements IEaseFunction, MathConstants {
    private static EaseSineOut INSTANCE;

    private EaseSineOut() {
    }

    public static EaseSineOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseSineOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed / pDuration);
    }

    public static float getValue(float pPercentage) {
        return FloatMath.sin(MathConstants.PI_HALF * pPercentage);
    }
}
