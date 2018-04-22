package org.anddev.andengine.util.modifier.ease;

public class EaseBackOut implements IEaseFunction {
    private static EaseBackOut INSTANCE;

    private EaseBackOut() {
    }

    public static EaseBackOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseBackOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed / pDuration);
    }

    public static float getValue(float pPercentage) {
        float t = pPercentage - 1.0f;
        return ((t * t) * ((2.70158f * t) + 1.70158f)) + 1.0f;
    }
}
