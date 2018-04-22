package org.anddev.andengine.entity.particle.modifier;

import org.anddev.andengine.entity.particle.Particle;

public abstract class BaseSingleValueSpanModifier implements IParticleModifier {
    private final float mDuration = (this.mToTime - this.mFromTime);
    private final float mFromTime;
    private final float mFromValue;
    private final float mSpanValue = (this.mToValue - this.mFromValue);
    private final float mToTime;
    private final float mToValue;

    protected abstract void onSetInitialValue(Particle particle, float f);

    protected abstract void onSetValue(Particle particle, float f);

    public BaseSingleValueSpanModifier(float pFromValue, float pToValue, float pFromTime, float pToTime) {
        this.mFromValue = pFromValue;
        this.mToValue = pToValue;
        this.mFromTime = pFromTime;
        this.mToTime = pToTime;
    }

    public void onInitializeParticle(Particle pParticle) {
        onSetInitialValue(pParticle, this.mFromValue);
    }

    public void onUpdateParticle(Particle pParticle) {
        float lifeTime = pParticle.getLifeTime();
        if (lifeTime > this.mFromTime && lifeTime < this.mToTime) {
            onSetValueInternal(pParticle, (lifeTime - this.mFromTime) / this.mDuration);
        }
    }

    public void onUpdateParticle(Particle pParticle, float overrideToTime) {
        float lifeTime = pParticle.getLifeTime();
        if (lifeTime > this.mFromTime) {
            onSetValueInternal(pParticle, (lifeTime - this.mFromTime) / (overrideToTime - this.mFromTime));
        }
    }

    protected void onSetValueInternal(Particle pParticle, float pPercent) {
        onSetValue(pParticle, calculateValue(pPercent));
    }

    protected final float calculateValue(float pPercent) {
        return this.mFromValue + (this.mSpanValue * pPercent);
    }
}
