package org.anddev.andengine.util.modifier.ease;

public class EaseExponentialIn implements IEaseFunction {
    private static EaseExponentialIn INSTANCE;

    private EaseExponentialIn() {
    }

    public static EaseExponentialIn getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseExponentialIn();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed / pDuration);
    }

    public static float getValue(float pPercentage) {
        return (float) (pPercentage == 0.0f ? 0.0d : Math.pow(2.0d, (double) (10.0f * (pPercentage - 1.0f))) - 0.0010000000474974513d);
    }
}
