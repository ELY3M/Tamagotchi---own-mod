package org.anddev.andengine.entity.particle.emitter;

import org.anddev.andengine.util.MathUtils;

public class RectangleOutlineParticleEmitter extends BaseRectangleParticleEmitter {
    public RectangleOutlineParticleEmitter(float pCenterX, float pCenterY, float pWidth, float pHeight) {
        super(pCenterX, pCenterY, pWidth, pHeight);
    }

    public void getPositionOffset(float[] pOffset) {
        pOffset[0] = this.mCenterX + (((float) MathUtils.randomSign()) * this.mWidthHalf);
        pOffset[1] = this.mCenterY + (((float) MathUtils.randomSign()) * this.mHeightHalf);
    }
}
