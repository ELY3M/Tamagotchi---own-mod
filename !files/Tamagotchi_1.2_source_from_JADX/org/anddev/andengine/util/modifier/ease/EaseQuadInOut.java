package org.anddev.andengine.util.modifier.ease;

public class EaseQuadInOut implements IEaseFunction {
    private static EaseQuadInOut INSTANCE;

    private EaseQuadInOut() {
    }

    public static EaseQuadInOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseQuadInOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        float percentage = pSecondsElapsed / pDuration;
        if (percentage < 0.5f) {
            return EaseQuadIn.getValue(2.0f * percentage) * 0.5f;
        }
        return (EaseQuadOut.getValue((percentage * 2.0f) - 1.0f) * 0.5f) + 0.5f;
    }
}
