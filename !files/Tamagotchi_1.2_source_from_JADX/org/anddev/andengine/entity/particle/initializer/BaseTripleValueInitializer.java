package org.anddev.andengine.entity.particle.initializer;

import org.anddev.andengine.entity.particle.Particle;
import org.anddev.andengine.util.MathUtils;

public abstract class BaseTripleValueInitializer extends BaseDoubleValueInitializer {
    protected float mMaxValueC;
    protected float mMinValueC;

    protected abstract void onInitializeParticle(Particle particle, float f, float f2, float f3);

    public BaseTripleValueInitializer(float pMinValueA, float pMaxValueA, float pMinValueB, float pMaxValueB, float pMinValueC, float pMaxValueC) {
        super(pMinValueA, pMaxValueA, pMinValueB, pMaxValueB);
        this.mMinValueC = pMinValueC;
        this.mMaxValueC = pMaxValueC;
    }

    protected final void onInitializeParticle(Particle pParticle, float pValueA, float pValueB) {
        onInitializeParticle(pParticle, pValueA, pValueB, getRandomValueC());
    }

    private final float getRandomValueC() {
        if (this.mMinValueC == this.mMaxValueC) {
            return this.mMaxValueC;
        }
        return (MathUtils.RANDOM.nextFloat() * (this.mMaxValueC - this.mMinValueC)) + this.mMinValueC;
    }
}
