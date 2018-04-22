package org.anddev.andengine.util.modifier.ease;

public class EaseBounceInOut implements IEaseFunction {
    private static EaseBounceInOut INSTANCE;

    private EaseBounceInOut() {
    }

    public static EaseBounceInOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseBounceInOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        float percentage = pSecondsElapsed / pDuration;
        if (percentage < 0.5f) {
            return EaseBounceIn.getValue(2.0f * percentage) * 0.5f;
        }
        return (EaseBounceOut.getValue((percentage * 2.0f) - 1.0f) * 0.5f) + 0.5f;
    }
}
