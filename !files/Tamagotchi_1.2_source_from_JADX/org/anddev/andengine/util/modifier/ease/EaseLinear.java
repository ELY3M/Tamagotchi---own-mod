package org.anddev.andengine.util.modifier.ease;

public class EaseLinear implements IEaseFunction {
    private static EaseLinear INSTANCE;

    private EaseLinear() {
    }

    public static EaseLinear getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseLinear();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return pSecondsElapsed / pDuration;
    }
}
