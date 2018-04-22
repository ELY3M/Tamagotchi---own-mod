package org.anddev.andengine.util.modifier;

import org.anddev.andengine.util.modifier.IModifier.IModifierListener;

public abstract class BaseDoubleValueChangeModifier<T> extends BaseSingleValueChangeModifier<T> {
    private float mValueChangeBPerSecond;

    protected abstract void onChangeValues(float f, T t, float f2, float f3);

    public BaseDoubleValueChangeModifier(float pDuration, float pValueChangeA, float pValueChangeB) {
        this(pDuration, pValueChangeA, pValueChangeB, null);
    }

    public BaseDoubleValueChangeModifier(float pDuration, float pValueChangeA, float pValueChangeB, IModifierListener<T> pModifierListener) {
        super(pDuration, pValueChangeA, pModifierListener);
        this.mValueChangeBPerSecond = pValueChangeB / pDuration;
    }

    protected BaseDoubleValueChangeModifier(BaseDoubleValueChangeModifier<T> pBaseDoubleValueChangeModifier) {
        super(pBaseDoubleValueChangeModifier);
        this.mValueChangeBPerSecond = pBaseDoubleValueChangeModifier.mValueChangeBPerSecond;
    }

    protected void onChangeValue(float pSecondsElapsed, T pItem, float pValueA) {
        onChangeValues(pSecondsElapsed, pItem, pValueA, this.mValueChangeBPerSecond * pSecondsElapsed);
    }
}
