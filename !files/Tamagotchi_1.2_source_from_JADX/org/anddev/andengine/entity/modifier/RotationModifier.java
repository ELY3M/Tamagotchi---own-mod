package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public class RotationModifier extends SingleValueSpanEntityModifier {
    public RotationModifier(float pDuration, float pFromRotation, float pToRotation) {
        this(pDuration, pFromRotation, pToRotation, null, IEaseFunction.DEFAULT);
    }

    public RotationModifier(float pDuration, float pFromRotation, float pToRotation, IEaseFunction pEaseFunction) {
        this(pDuration, pFromRotation, pToRotation, null, pEaseFunction);
    }

    public RotationModifier(float pDuration, float pFromRotation, float pToRotation, IEntityModifierListener pEntityModifierListener) {
        super(pDuration, pFromRotation, pToRotation, pEntityModifierListener, IEaseFunction.DEFAULT);
    }

    public RotationModifier(float pDuration, float pFromRotation, float pToRotation, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        super(pDuration, pFromRotation, pToRotation, pEntityModifierListener, pEaseFunction);
    }

    protected RotationModifier(RotationModifier pRotationModifier) {
        super(pRotationModifier);
    }

    public RotationModifier deepCopy() {
        return new RotationModifier(this);
    }

    protected void onSetInitialValue(IEntity pEntity, float pRotation) {
        pEntity.setRotation(pRotation);
    }

    protected void onSetValue(IEntity pEntity, float pPercentageDone, float pRotation) {
        pEntity.setRotation(pRotation);
    }
}
