package org.anddev.andengine.util.modifier.ease;

import android.util.FloatMath;
import org.anddev.andengine.util.constants.MathConstants;

public class EaseElasticOut implements IEaseFunction, MathConstants {
    private static EaseElasticOut INSTANCE;

    private EaseElasticOut() {
    }

    public static EaseElasticOut getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EaseElasticOut();
        }
        return INSTANCE;
    }

    public float getPercentage(float pSecondsElapsed, float pDuration) {
        return getValue(pSecondsElapsed, pDuration, pSecondsElapsed / pDuration);
    }

    public static float getValue(float pSecondsElapsed, float pDuration, float pPercentageDone) {
        if (pSecondsElapsed == 0.0f) {
            return 0.0f;
        }
        if (pSecondsElapsed == pDuration) {
            return 1.0f;
        }
        float p = pDuration * 0.3f;
        return (((float) Math.pow(2.0d, (double) (-10.0f * pPercentageDone))) * FloatMath.sin((((pPercentageDone * pDuration) - (p / 4.0f)) * MathConstants.PI_TWICE) / p)) + 1.0f;
    }
}
