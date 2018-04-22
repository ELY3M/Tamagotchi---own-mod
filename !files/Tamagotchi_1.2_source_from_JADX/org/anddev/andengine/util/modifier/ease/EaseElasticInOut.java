package org.anddev.andengine.util.modifier.ease;

import org.anddev.andengine.util.constants.MathConstants;

public class EaseElasticInOut implements IEaseFunction, MathConstants {
    private static EaseElasticInOut INSTANCE;

    private EaseElasticInOut() {
    }

    public static EaseElasticInOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseElasticInOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        float percentage = pSecondsElapsed / pDuration;
        if (percentage < 0.5f) {
            return EaseElasticIn.getValue(2.0f * pSecondsElapsed, pDuration, 2.0f * percentage) * 0.5f;
        }
        return (EaseElasticOut.getValue((pSecondsElapsed * 2.0f) - pDuration, pDuration, (2.0f * percentage) - 1.0f) * 0.5f) + 0.5f;
    }
}
