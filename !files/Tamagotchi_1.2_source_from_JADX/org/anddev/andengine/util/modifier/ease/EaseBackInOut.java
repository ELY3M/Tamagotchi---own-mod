package org.anddev.andengine.util.modifier.ease;

public class EaseBackInOut implements IEaseFunction {
    private static EaseBackInOut INSTANCE;

    private EaseBackInOut() {
    }

    public static EaseBackInOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseBackInOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        float percentage = pSecondsElapsed / pDuration;
        if (percentage < 0.5f) {
            return EaseBackIn.getValue(2.0f * percentage) * 0.5f;
        }
        return (EaseBackOut.getValue((percentage * 2.0f) - 1.0f) * 0.5f) + 0.5f;
    }
}
