package org.anddev.andengine.util.modifier.ease;

public class EaseCubicIn implements IEaseFunction {
    private static EaseCubicIn INSTANCE;

    private EaseCubicIn() {
    }

    public static EaseCubicIn getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseCubicIn();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed / pDuration);
    }

    public static float getValue(float pPercentage) {
        return (pPercentage * pPercentage) * pPercentage;
    }
}
