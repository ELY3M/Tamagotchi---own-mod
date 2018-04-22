package org.anddev.andengine.util.modifier.ease;

public class EaseExponentialOut implements IEaseFunction {
    private static EaseExponentialOut INSTANCE;

    private EaseExponentialOut() {
    }

    public static EaseExponentialOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseExponentialOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed / pDuration);
    }

    public static float getValue(float pPercentage) {
        return pPercentage == 1.0f ? 1.0f : 1.0f + (-((float) Math.pow(2.0d, (double) (-10.0f * pPercentage))));
    }
}
