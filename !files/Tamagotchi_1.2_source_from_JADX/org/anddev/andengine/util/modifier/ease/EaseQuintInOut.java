package org.anddev.andengine.util.modifier.ease;

public class EaseQuintInOut implements IEaseFunction {
    private static EaseQuintInOut INSTANCE;

    private EaseQuintInOut() {
    }

    public static EaseQuintInOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseQuintInOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        float percentage = pSecondsElapsed / pDuration;
        if (percentage < 0.5f) {
            return EaseQuintIn.getValue(2.0f * percentage) * 0.5f;
        }
        return (EaseQuintOut.getValue((percentage * 2.0f) - 1.0f) * 0.5f) + 0.5f;
    }
}
