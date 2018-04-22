package org.anddev.andengine.entity.particle.initializer;

import org.anddev.andengine.entity.particle.Particle;

public class AlphaInitializer extends BaseSingleValueInitializer {
    public AlphaInitializer(float pAlpha) {
        super(pAlpha, pAlpha);
    }

    public AlphaInitializer(float pMinAlpha, float pMaxAlpha) {
        super(pMinAlpha, pMaxAlpha);
    }

    protected void onInitializeParticle(Particle pParticle, float pAlpha) {
        pParticle.setAlpha(pAlpha);
    }
}
