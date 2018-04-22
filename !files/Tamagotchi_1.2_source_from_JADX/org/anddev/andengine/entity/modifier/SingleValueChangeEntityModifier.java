package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.BaseSingleValueChangeModifier;

public abstract class SingleValueChangeEntityModifier extends BaseSingleValueChangeModifier<IEntity> implements IEntityModifier {
    public SingleValueChangeEntityModifier(float pDuration, float pValueChange) {
        super(pDuration, pValueChange);
    }

    public SingleValueChangeEntityModifier(float pDuration, float pValueChange, IEntityModifierListener pEntityModifierListener) {
        super(pDuration, pValueChange, pEntityModifierListener);
    }

    protected SingleValueChangeEntityModifier(SingleValueChangeEntityModifier pSingleValueChangeEntityModifier) {
        super(pSingleValueChangeEntityModifier);
    }
}
