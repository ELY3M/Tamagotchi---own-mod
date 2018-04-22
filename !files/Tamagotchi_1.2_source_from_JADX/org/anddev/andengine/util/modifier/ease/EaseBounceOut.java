package org.anddev.andengine.util.modifier.ease;

public class EaseBounceOut implements IEaseFunction {
    private static EaseBounceOut INSTANCE;

    private EaseBounceOut() {
    }

    public static EaseBounceOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseBounceOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed / pDuration);
    }

    public static float getValue(float pPercentage) {
        if (pPercentage < 0.36363637f) {
            return (7.5625f * pPercentage) * pPercentage;
        }
        float t;
        if (pPercentage < 0.72727275f) {
            t = pPercentage - 0.54545456f;
            return ((7.5625f * t) * t) + 0.75f;
        } else if (pPercentage < 0.90909094f) {
            t = pPercentage - 0.8181818f;
            return ((7.5625f * t) * t) + 0.9375f;
        } else {
            t = pPercentage - 0.95454544f;
            return ((7.5625f * t) * t) + 0.984375f;
        }
    }
}
