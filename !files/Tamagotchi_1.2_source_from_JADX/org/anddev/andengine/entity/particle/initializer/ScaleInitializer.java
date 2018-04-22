package org.anddev.andengine.entity.particle.initializer;

import org.anddev.andengine.entity.particle.Particle;

public class ScaleInitializer extends BaseSingleValueInitializer {
    public ScaleInitializer(float pScale) {
        this(pScale, pScale);
    }

    public ScaleInitializer(float pMinScale, float pMaxScale) {
        super(pMinScale, pMaxScale);
    }

    protected void onInitializeParticle(Particle pParticle, float pScale) {
        pParticle.setScale(pScale);
    }
}
