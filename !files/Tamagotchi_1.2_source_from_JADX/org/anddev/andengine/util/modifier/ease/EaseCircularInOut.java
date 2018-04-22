package org.anddev.andengine.util.modifier.ease;

public class EaseCircularInOut implements IEaseFunction {
    private static EaseCircularInOut INSTANCE;

    private EaseCircularInOut() {
    }

    public static EaseCircularInOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseCircularInOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        float percentage = pSecondsElapsed / pDuration;
        if (percentage < 0.5f) {
            return EaseCircularIn.getValue(2.0f * percentage) * 0.5f;
        }
        return (EaseCircularOut.getValue((percentage * 2.0f) - 1.0f) * 0.5f) + 0.5f;
    }
}
