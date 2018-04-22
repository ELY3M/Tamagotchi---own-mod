package org.anddev.andengine.util.modifier.ease;

public class EaseQuadOut implements IEaseFunction {
    private static EaseQuadOut INSTANCE;

    private EaseQuadOut() {
    }

    public static EaseQuadOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseQuadOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed / pDuration);
    }

    public static float getValue(float pPercentage) {
        return (-pPercentage) * (pPercentage - 2.0f);
    }
}
