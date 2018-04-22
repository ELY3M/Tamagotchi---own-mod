package org.anddev.andengine.util.modifier.ease;

public class EaseQuartInOut implements IEaseFunction {
    private static EaseQuartInOut INSTANCE;

    private EaseQuartInOut() {
    }

    public static EaseQuartInOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseQuartInOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        float percentage = pSecondsElapsed / pDuration;
        if (percentage < 0.5f) {
            return EaseQuartIn.getValue(2.0f * percentage) * 0.5f;
        }
        return (EaseQuartOut.getValue((percentage * 2.0f) - 1.0f) * 0.5f) + 0.5f;
    }
}
