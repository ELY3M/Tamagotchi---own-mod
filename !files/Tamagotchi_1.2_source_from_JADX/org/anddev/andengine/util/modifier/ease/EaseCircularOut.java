package org.anddev.andengine.util.modifier.ease;

import android.util.FloatMath;

public class EaseCircularOut implements IEaseFunction {
    private static EaseCircularOut INSTANCE;

    private EaseCircularOut() {
    }

    public static EaseCircularOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseCircularOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed / pDuration);
    }

    public static float getValue(float pPercentage) {
        float t = pPercentage - 1.0f;
        return FloatMath.sqrt(1.0f - (t * t));
    }
}
