package org.anddev.andengine.entity.particle.initializer;

import org.anddev.andengine.entity.particle.Particle;

public class ColorInitializer extends BaseTripleValueInitializer {
    public ColorInitializer(float pRed, float pGreen, float pBlue) {
        super(pRed, pRed, pGreen, pGreen, pBlue, pBlue);
    }

    public ColorInitializer(float pMinRed, float pMaxRed, float pMinGreen, float pMaxGreen, float pMinBlue, float pMaxBlue) {
        super(pMinRed, pMaxRed, pMinGreen, pMaxGreen, pMinBlue, pMaxBlue);
    }

    protected void onInitializeParticle(Particle pParticle, float pRed, float pGreen, float pBlue) {
        pParticle.setColor(pRed, pGreen, pBlue);
    }
}
