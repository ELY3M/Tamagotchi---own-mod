package org.anddev.andengine.entity.particle.modifier;

import org.anddev.andengine.entity.particle.Particle;

public class ScaleModifier extends BaseDoubleValueSpanModifier {
    public ScaleModifier(float pFromScale, float pToScale, float pFromTime, float pToTime) {
        this(pFromScale, pToScale, pFromScale, pToScale, pFromTime, pToTime);
    }

    public ScaleModifier(float pFromScaleX, float pToScaleX, float pFromScaleY, float pToScaleY, float pFromTime, float pToTime) {
        super(pFromScaleX, pToScaleX, pFromScaleY, pToScaleY, pFromTime, pToTime);
    }

    protected void onSetInitialValues(Particle pParticle, float pScaleX, float pScaleY) {
        pParticle.setScale(pScaleX, pScaleY);
    }

    protected void onSetValues(Particle pParticle, float pScaleX, float pScaleY) {
        pParticle.setScale(pScaleX, pScaleY);
    }
}
