package org.anddev.andengine.entity.particle.modifier;

import org.anddev.andengine.entity.particle.Particle;

public class AlphaModifier extends BaseSingleValueSpanModifier {
    public AlphaModifier(float pFromAlpha, float pToAlpha, float pFromTime, float pToTime) {
        super(pFromAlpha, pToAlpha, pFromTime, pToTime);
    }

    protected void onSetInitialValue(Particle pParticle, float pAlpha) {
        pParticle.setAlpha(pAlpha);
    }

    protected void onSetValue(Particle pParticle, float pAlpha) {
        pParticle.setAlpha(pAlpha);
    }
}
