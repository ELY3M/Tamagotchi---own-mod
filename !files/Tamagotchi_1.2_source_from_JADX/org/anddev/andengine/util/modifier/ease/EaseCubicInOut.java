package org.anddev.andengine.util.modifier.ease;

public class EaseCubicInOut implements IEaseFunction {
    private static EaseCubicInOut INSTANCE;

    private EaseCubicInOut() {
    }

    public static EaseCubicInOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseCubicInOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        float percentage = pSecondsElapsed / pDuration;
        if (percentage < 0.5f) {
            return EaseCubicIn.getValue(2.0f * percentage) * 0.5f;
        }
        return (EaseCubicOut.getValue((percentage * 2.0f) - 1.0f) * 0.5f) + 0.5f;
    }
}
