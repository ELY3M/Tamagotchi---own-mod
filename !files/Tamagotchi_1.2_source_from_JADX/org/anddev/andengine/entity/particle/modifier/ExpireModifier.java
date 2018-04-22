package org.anddev.andengine.entity.particle.modifier;

import org.anddev.andengine.entity.particle.Particle;
import org.anddev.andengine.util.MathUtils;

public class ExpireModifier implements IParticleModifier {
    private float mMaxLifeTime;
    private float mMinLifeTime;

    public ExpireModifier(float pLifeTime) {
        this(pLifeTime, pLifeTime);
    }

    public ExpireModifier(float pMinLifeTime, float pMaxLifeTime) {
        this.mMinLifeTime = pMinLifeTime;
        this.mMaxLifeTime = pMaxLifeTime;
    }

    public float getMinLifeTime() {
        return this.mMinLifeTime;
    }

    public float getMaxLifeTime() {
        return this.mMaxLifeTime;
    }

    public void setLifeTime(float pLifeTime) {
        this.mMinLifeTime = pLifeTime;
        this.mMaxLifeTime = pLifeTime;
    }

    public void setLifeTime(float pMinLifeTime, float pMaxLifeTime) {
        this.mMinLifeTime = pMinLifeTime;
        this.mMaxLifeTime = pMaxLifeTime;
    }

    public void onInitializeParticle(Particle pParticle) {
        pParticle.setDeathTime((MathUtils.RANDOM.nextFloat() * (this.mMaxLifeTime - this.mMinLifeTime)) + this.mMinLifeTime);
    }

    public void onUpdateParticle(Particle pParticle) {
    }
}
