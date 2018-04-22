package org.anddev.andengine.entity.particle.initializer;

import org.anddev.andengine.entity.particle.Particle;
import org.anddev.andengine.util.MathUtils;

public abstract class BaseDoubleValueInitializer extends BaseSingleValueInitializer {
    protected float mMaxValueB;
    protected float mMinValueB;

    protected abstract void onInitializeParticle(Particle particle, float f, float f2);

    public BaseDoubleValueInitializer(float pMinValueA, float pMaxValueA, float pMinValueB, float pMaxValueB) {
        super(pMinValueA, pMaxValueA);
        this.mMinValueB = pMinValueB;
        this.mMaxValueB = pMaxValueB;
    }

    protected final void onInitializeParticle(Particle pParticle, float pValueA) {
        onInitializeParticle(pParticle, pValueA, getRandomValueB());
    }

    private final float getRandomValueB() {
        if (this.mMinValueB == this.mMaxValueB) {
            return this.mMaxValueB;
        }
        return (MathUtils.RANDOM.nextFloat() * (this.mMaxValueB - this.mMinValueB)) + this.mMinValueB;
    }
}
