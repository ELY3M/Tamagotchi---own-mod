package org.anddev.andengine.entity.particle.modifier;

import org.anddev.andengine.entity.particle.Particle;

public abstract class BaseDoubleValueSpanModifier extends BaseSingleValueSpanModifier {
    private final float mFromValueB;
    private final float mSpanValueB = (this.mToValueB - this.mFromValueB);
    private final float mToValueB;

    protected abstract void onSetInitialValues(Particle particle, float f, float f2);

    protected abstract void onSetValues(Particle particle, float f, float f2);

    public BaseDoubleValueSpanModifier(float pFromValueA, float pToValueA, float pFromValueB, float pToValueB, float pFromTime, float pToTime) {
        super(pFromValueA, pToValueA, pFromTime, pToTime);
        this.mFromValueB = pFromValueB;
        this.mToValueB = pToValueB;
    }

    @Deprecated
    protected void onSetValue(Particle pParticle, float pValue) {
    }

    public void onSetInitialValue(Particle pParticle, float pValueA) {
        onSetInitialValues(pParticle, pValueA, this.mFromValueB);
    }

    protected void onSetValueInternal(Particle pParticle, float pPercent) {
        onSetValues(pParticle, super.calculateValue(pPercent), calculateValueB(pPercent));
    }

    protected final float calculateValueB(float pPercent) {
        return this.mFromValueB + (this.mSpanValueB * pPercent);
    }
}
