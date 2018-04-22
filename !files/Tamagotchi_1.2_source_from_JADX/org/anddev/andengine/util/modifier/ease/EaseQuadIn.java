package org.anddev.andengine.util.modifier.ease;

public class EaseQuadIn implements IEaseFunction {
    private static EaseQuadIn INSTANCE;

    private EaseQuadIn() {
    }

    public static EaseQuadIn getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseQuadIn();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed / pDuration);
    }

    public static float getValue(float pPercentage) {
        return pPercentage * pPercentage;
    }
}
