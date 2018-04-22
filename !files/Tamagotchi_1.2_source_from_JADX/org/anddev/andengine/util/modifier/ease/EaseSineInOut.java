package org.anddev.andengine.util.modifier.ease;

import android.util.FloatMath;
import org.anddev.andengine.util.constants.MathConstants;

public class EaseSineInOut implements IEaseFunction {
    private static EaseSineInOut INSTANCE;

    private EaseSineInOut() {
    }

    public static EaseSineInOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseSineInOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return -0.5f * (FloatMath.cos(MathConstants.PI * (pSecondsElapsed / pDuration)) - 1.0f);
    }
}
