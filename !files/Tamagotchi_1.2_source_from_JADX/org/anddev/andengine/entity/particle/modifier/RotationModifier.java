package org.anddev.andengine.entity.particle.modifier;

import org.anddev.andengine.entity.particle.Particle;

public class RotationModifier extends BaseSingleValueSpanModifier {
    public RotationModifier(float pFromRotation, float pToRotation, float pFromTime, float pToTime) {
        super(pFromRotation, pToRotation, pFromTime, pToTime);
    }

    protected void onSetInitialValue(Particle pParticle, float pRotation) {
        pParticle.setRotation(pRotation);
    }

    protected void onSetValue(Particle pParticle, float pRotation) {
        pParticle.setRotation(pRotation);
    }
}
