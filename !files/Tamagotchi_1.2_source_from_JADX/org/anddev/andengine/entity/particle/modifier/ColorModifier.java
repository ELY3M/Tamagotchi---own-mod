package org.anddev.andengine.entity.particle.modifier;

import org.anddev.andengine.entity.particle.Particle;

public class ColorModifier extends BaseTripleValueSpanModifier {
    public ColorModifier(float pFromRed, float pToRed, float pFromGreen, float pToGreen, float pFromBlue, float pToBlue, float pFromTime, float pToTime) {
        super(pFromRed, pToRed, pFromGreen, pToGreen, pFromBlue, pToBlue, pFromTime, pToTime);
    }

    protected void onSetInitialValues(Particle pParticle, float pRed, float pGreen, float pBlue) {
        pParticle.setColor(pRed, pGreen, pBlue);
    }

    protected void onSetValues(Particle pParticle, float pRed, float pGreen, float pBlue) {
        pParticle.setColor(pRed, pGreen, pBlue);
    }
}
