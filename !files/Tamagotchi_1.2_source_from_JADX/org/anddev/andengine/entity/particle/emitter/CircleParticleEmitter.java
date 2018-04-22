package org.anddev.andengine.entity.particle.emitter;

import android.util.FloatMath;
import org.anddev.andengine.util.MathUtils;
import org.anddev.andengine.util.constants.MathConstants;

public class CircleParticleEmitter extends BaseCircleParticleEmitter {
    public CircleParticleEmitter(float pCenterX, float pCenterY, float pRadius) {
        super(pCenterX, pCenterY, pRadius);
    }

    public CircleParticleEmitter(float pCenterX, float pCenterY, float pRadiusX, float pRadiusY) {
        super(pCenterX, pCenterY, pRadiusX, pRadiusY);
    }

    public void getPositionOffset(float[] pOffset) {
        float random = (MathUtils.RANDOM.nextFloat() * MathConstants.PI) * 2.0f;
        pOffset[0] = this.mCenterX + ((FloatMath.cos(random) * this.mRadiusX) * MathUtils.RANDOM.nextFloat());
        pOffset[1] = this.mCenterY + ((FloatMath.sin(random) * this.mRadiusY) * MathUtils.RANDOM.nextFloat());
    }
}
