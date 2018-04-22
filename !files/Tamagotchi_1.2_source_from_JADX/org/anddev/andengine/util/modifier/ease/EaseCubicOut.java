package org.anddev.andengine.util.modifier.ease;

public class EaseCubicOut implements IEaseFunction {
    private static EaseCubicOut INSTANCE;

    private EaseCubicOut() {
    }

    public static EaseCubicOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseCubicOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed / pDuration);
    }

    public static float getValue(float pPercentage) {
        float t = pPercentage - 1.0f;
        return ((t * t) * t) + 1.0f;
    }
}
