package org.anddev.andengine.entity.particle.emitter;

public class PointParticleEmitter extends BaseParticleEmitter {
    public PointParticleEmitter(float pCenterX, float pCenterY) {
        super(pCenterX, pCenterY);
    }

    public void getPositionOffset(float[] pOffset) {
        pOffset[0] = this.mCenterX;
        pOffset[1] = this.mCenterY;
    }
}
