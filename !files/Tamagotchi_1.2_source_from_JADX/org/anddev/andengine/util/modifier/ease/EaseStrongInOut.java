package org.anddev.andengine.util.modifier.ease;

public class EaseStrongInOut implements IEaseFunction {
    private static EaseStrongInOut INSTANCE;

    private EaseStrongInOut() {
    }

    public static EaseStrongInOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseStrongInOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        float percentage = pSecondsElapsed / pDuration;
        if (percentage < 0.5f) {
            return EaseStrongIn.getValue(2.0f * percentage) * 0.5f;
        }
        return (EaseStrongOut.getValue((percentage * 2.0f) - 1.0f) * 0.5f) + 0.5f;
    }
}
