package org.anddev.andengine.entity.particle.emitter;

public abstract class BaseParticleEmitter implements IParticleEmitter {
    protected float mCenterX;
    protected float mCenterY;

    public BaseParticleEmitter(float pCenterX, float pCenterY) {
        this.mCenterX = pCenterX;
        this.mCenterY = pCenterY;
    }

    public float getCenterX() {
        return this.mCenterX;
    }

    public float getCenterY() {
        return this.mCenterY;
    }

    public void setCenterX(float pCenterX) {
        this.mCenterX = pCenterX;
    }

    public void setCenterY(float pCenterY) {
        this.mCenterY = pCenterY;
    }

    public void setCenter(float pCenterX, float pCenterY) {
        this.mCenterX = pCenterX;
        this.mCenterY = pCenterY;
    }

    public void onUpdate(float pSecondsElapsed) {
    }

    public void reset() {
    }
}
