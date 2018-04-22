package org.anddev.andengine.engine.handler.physics;

import org.anddev.andengine.engine.handler.BaseEntityUpdateHandler;
import org.anddev.andengine.entity.IEntity;

public class PhysicsHandler extends BaseEntityUpdateHandler {
    protected float mAccelerationX = 0.0f;
    protected float mAccelerationY = 0.0f;
    protected float mAngularVelocity = 0.0f;
    private boolean mEnabled = true;
    protected float mVelocityX = 0.0f;
    protected float mVelocityY = 0.0f;

    public PhysicsHandler(IEntity pEntity) {
        super(pEntity);
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean pEnabled) {
        this.mEnabled = pEnabled;
    }

    public float getVelocityX() {
        return this.mVelocityX;
    }

    public float getVelocityY() {
        return this.mVelocityY;
    }

    public void setVelocityX(float pVelocityX) {
        this.mVelocityX = pVelocityX;
    }

    public void setVelocityY(float pVelocityY) {
        this.mVelocityY = pVelocityY;
    }

    public void setVelocity(float pVelocity) {
        this.mVelocityX = pVelocity;
        this.mVelocityY = pVelocity;
    }

    public void setVelocity(float pVelocityX, float pVelocityY) {
        this.mVelocityX = pVelocityX;
        this.mVelocityY = pVelocityY;
    }

    public float getAccelerationX() {
        return this.mAccelerationX;
    }

    public float getAccelerationY() {
        return this.mAccelerationY;
    }

    public void setAccelerationX(float pAccelerationX) {
        this.mAccelerationX = pAccelerationX;
    }

    public void setAccelerationY(float pAccelerationY) {
        this.mAccelerationY = pAccelerationY;
    }

    public void setAcceleration(float pAccelerationX, float pAccelerationY) {
        this.mAccelerationX = pAccelerationX;
        this.mAccelerationY = pAccelerationY;
    }

    public void setAcceleration(float pAcceleration) {
        this.mAccelerationX = pAcceleration;
        this.mAccelerationY = pAcceleration;
    }

    public void accelerate(float pAccelerationX, float pAccelerationY) {
        this.mAccelerationX += pAccelerationX;
        this.mAccelerationY += pAccelerationY;
    }

    public float getAngularVelocity() {
        return this.mAngularVelocity;
    }

    public void setAngularVelocity(float pAngularVelocity) {
        this.mAngularVelocity = pAngularVelocity;
    }

    protected void onUpdate(float pSecondsElapsed, IEntity pEntity) {
        if (this.mEnabled) {
            float accelerationX = this.mAccelerationX;
            float accelerationY = this.mAccelerationY;
            if (!(accelerationX == 0.0f && accelerationY == 0.0f)) {
                this.mVelocityX += accelerationX * pSecondsElapsed;
                this.mVelocityY += accelerationY * pSecondsElapsed;
            }
            float angularVelocity = this.mAngularVelocity;
            if (angularVelocity != 0.0f) {
                pEntity.setRotation(pEntity.getRotation() + (angularVelocity * pSecondsElapsed));
            }
            float velocityX = this.mVelocityX;
            float velocityY = this.mVelocityY;
            if (velocityX != 0.0f || velocityY != 0.0f) {
                pEntity.setPosition(pEntity.getX() + (velocityX * pSecondsElapsed), pEntity.getY() + (velocityY * pSecondsElapsed));
            }
        }
    }

    public void reset() {
        this.mAccelerationX = 0.0f;
        this.mAccelerationY = 0.0f;
        this.mVelocityX = 0.0f;
        this.mVelocityY = 0.0f;
        this.mAngularVelocity = 0.0f;
    }
}
