package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.BaseDoubleValueChangeModifier;

public abstract class DoubleValueChangeEntityModifier extends BaseDoubleValueChangeModifier<IEntity> implements IEntityModifier {
    public DoubleValueChangeEntityModifier(float pDuration, float pValueChangeA, float pValueChangeB) {
        super(pDuration, pValueChangeA, pValueChangeB);
    }

    public DoubleValueChangeEntityModifier(float pDuration, float pValueChangeA, float pValueChangeB, IEntityModifierListener pModifierListener) {
        super(pDuration, pValueChangeA, pValueChangeB, pModifierListener);
    }

    public DoubleValueChangeEntityModifier(DoubleValueChangeEntityModifier pDoubleValueChangeEntityModifier) {
        super(pDoubleValueChangeEntityModifier);
    }
}
