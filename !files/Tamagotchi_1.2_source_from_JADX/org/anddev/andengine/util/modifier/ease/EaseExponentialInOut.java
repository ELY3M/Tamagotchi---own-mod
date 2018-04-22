package org.anddev.andengine.util.modifier.ease;

public class EaseExponentialInOut implements IEaseFunction {
    private static EaseExponentialInOut INSTANCE;

    private EaseExponentialInOut() {
    }

    public static EaseExponentialInOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseExponentialInOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        float percentage = pSecondsElapsed / pDuration;
        if (percentage < 0.5f) {
            return EaseExponentialIn.getValue(2.0f * percentage) * 0.5f;
        }
        return (EaseExponentialOut.getValue((percentage * 2.0f) - 1.0f) * 0.5f) + 0.5f;
    }
}
