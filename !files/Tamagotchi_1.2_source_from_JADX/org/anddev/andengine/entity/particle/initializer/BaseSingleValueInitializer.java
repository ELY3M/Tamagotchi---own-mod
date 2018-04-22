package org.anddev.andengine.entity.particle.initializer;

import org.anddev.andengine.entity.particle.Particle;
import org.anddev.andengine.util.MathUtils;

public abstract class BaseSingleValueInitializer implements IParticleInitializer {
    protected float mMaxValue;
    protected float mMinValue;

    protected abstract void onInitializeParticle(Particle particle, float f);

    public BaseSingleValueInitializer(float pMinValue, float pMaxValue) {
        this.mMinValue = pMinValue;
        this.mMaxValue = pMaxValue;
    }

    public final void onInitializeParticle(Particle pParticle) {
        onInitializeParticle(pParticle, getRandomValue());
    }

    private final float getRandomValue() {
        if (this.mMinValue == this.mMaxValue) {
            return this.mMaxValue;
        }
        return (MathUtils.RANDOM.nextFloat() * (this.mMaxValue - this.mMinValue)) + this.mMinValue;
    }
}
