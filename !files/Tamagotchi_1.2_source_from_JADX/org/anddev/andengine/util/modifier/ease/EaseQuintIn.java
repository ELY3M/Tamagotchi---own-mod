package org.anddev.andengine.util.modifier.ease;

public class EaseQuintIn implements IEaseFunction {
    private static EaseQuintIn INSTANCE;

    private EaseQuintIn() {
    }

    public static EaseQuintIn getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseQuintIn();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed / pDuration);
    }

    public static float getValue(float pPercentage) {
        return (((pPercentage * pPercentage) * pPercentage) * pPercentage) * pPercentage;
    }
}
