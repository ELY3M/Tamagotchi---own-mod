package org.anddev.andengine.entity.particle;

import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.vertex.RectangleVertexBuffer;

public class Particle extends Sprite {
    boolean mDead = false;
    private float mDeathTime = -1.0f;
    private float mLifeTime = 0.0f;
    private final PhysicsHandler mPhysicsHandler = new PhysicsHandler(this);

    public Particle(float pX, float pY, TextureRegion pTextureRegion) {
        super(pX, pY, pTextureRegion);
    }

    public Particle(float pX, float pY, TextureRegion pTextureRegion, RectangleVertexBuffer pRectangleVertexBuffer) {
        super(pX, pY, pTextureRegion, pRectangleVertexBuffer);
    }

    public float getLifeTime() {
        return this.mLifeTime;
    }

    public float getDeathTime() {
        return this.mDeathTime;
    }

    public void setDeathTime(float pDeathTime) {
        this.mDeathTime = pDeathTime;
    }

    public boolean isDead() {
        return this.mDead;
    }

    public void setDead(boolean pDead) {
        this.mDead = pDead;
    }

    public PhysicsHandler getPhysicsHandler() {
        return this.mPhysicsHandler;
    }

    protected void onManagedUpdate(float pSecondsElapsed) {
        if (!this.mDead) {
            this.mLifeTime += pSecondsElapsed;
            this.mPhysicsHandler.onUpdate(pSecondsElapsed);
            super.onManagedUpdate(pSecondsElapsed);
            float deathTime = this.mDeathTime;
            if (deathTime != -1.0f && this.mLifeTime > deathTime) {
                setDead(true);
            }
        }
    }

    public void reset() {
        super.reset();
        this.mPhysicsHandler.reset();
        this.mDead = false;
        this.mDeathTime = -1.0f;
        this.mLifeTime = 0.0f;
    }
}
