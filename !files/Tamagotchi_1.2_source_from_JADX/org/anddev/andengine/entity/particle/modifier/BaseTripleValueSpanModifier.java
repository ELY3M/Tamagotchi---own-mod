package org.anddev.andengine.entity.particle.modifier;

import org.anddev.andengine.entity.particle.Particle;

public abstract class BaseTripleValueSpanModifier extends BaseDoubleValueSpanModifier {
    private final float mFromValueC;
    private final float mSpanValueC = (this.mToValueC - this.mFromValueC);
    private final float mToValueC;

    protected abstract void onSetInitialValues(Particle particle, float f, float f2, float f3);

    protected abstract void onSetValues(Particle particle, float f, float f2, float f3);

    public BaseTripleValueSpanModifier(float pFromValueA, float pToValueA, float pFromValueB, float pToValueB, float pFromValueC, float pToValueC, float pFromTime, float pToTime) {
        super(pFromValueA, pToValueA, pFromValueB, pToValueB, pFromTime, pToTime);
        this.mFromValueC = pFromValueC;
        this.mToValueC = pToValueC;
    }

    @Deprecated
    protected void onSetValues(Particle pParticle, float pValueA, float pValueB) {
    }

    public void onSetInitialValues(Particle pParticle, float pValueA, float pValueB) {
        onSetInitialValues(pParticle, pValueA, pValueB, this.mFromValueC);
    }

    protected void onSetValueInternal(Particle pParticle, float pPercent) {
        onSetValues(pParticle, super.calculateValue(pPercent), super.calculateValueB(pPercent), calculateValueC(pPercent));
    }

    private final float calculateValueC(float pPercent) {
        return this.mFromValueC + (this.mSpanValueC * pPercent);
    }
}
