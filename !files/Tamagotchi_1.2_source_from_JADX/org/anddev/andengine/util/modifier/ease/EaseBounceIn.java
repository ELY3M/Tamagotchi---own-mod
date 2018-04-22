package org.anddev.andengine.util.modifier.ease;

public class EaseBounceIn implements IEaseFunction {
    private static EaseBounceIn INSTANCE;

    private EaseBounceIn() {
    }

    public static EaseBounceIn getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseBounceIn();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed / pDuration);
    }

    public static float getValue(float pPercentage) {
        return 1.0f - EaseBounceOut.getValue(1.0f - pPercentage);
    }
}
