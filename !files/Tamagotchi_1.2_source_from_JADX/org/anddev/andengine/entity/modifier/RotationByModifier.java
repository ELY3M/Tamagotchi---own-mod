package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;

public class RotationByModifier extends SingleValueChangeEntityModifier {
    public RotationByModifier(float pDuration, float pRotation) {
        super(pDuration, pRotation);
    }

    public RotationByModifier(float pDuration, float pRotation, IEntityModifierListener pEntityModifierListener) {
        super(pDuration, pRotation, pEntityModifierListener);
    }

    protected RotationByModifier(RotationByModifier pRotationByModifier) {
        super(pRotationByModifier);
    }

    public RotationByModifier deepCopy() {
        return new RotationByModifier(this);
    }

    protected void onChangeValue(float pSecondsElapsed, IEntity pEntity, float pRotation) {
        pEntity.setRotation(pEntity.getRotation() + pRotation);
    }
}
