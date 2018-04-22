package org.anddev.andengine.entity.particle.emitter;

import org.anddev.andengine.util.MathUtils;

public class RectangleParticleEmitter extends BaseRectangleParticleEmitter {
    public RectangleParticleEmitter(float pCenterX, float pCenterY, float pWidth, float pHeight) {
        super(pCenterX, pCenterY, pWidth, pHeight);
    }

    public void getPositionOffset(float[] pOffset) {
        pOffset[0] = (this.mCenterX - this.mWidthHalf) + (MathUtils.RANDOM.nextFloat() * this.mWidth);
        pOffset[1] = (this.mCenterY - this.mHeightHalf) + (MathUtils.RANDOM.nextFloat() * this.mHeight);
    }
}
