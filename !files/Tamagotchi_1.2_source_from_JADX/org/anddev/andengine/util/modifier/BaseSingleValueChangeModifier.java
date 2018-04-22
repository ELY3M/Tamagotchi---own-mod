package org.anddev.andengine.util.modifier;

import org.anddev.andengine.util.modifier.IModifier.IModifierListener;

public abstract class BaseSingleValueChangeModifier<T> extends BaseDurationModifier<T> {
    private final float mValueChangePerSecond;

    protected abstract void onChangeValue(float f, T t, float f2);

    public BaseSingleValueChangeModifier(float pDuration, float pValueChange) {
        this(pDuration, pValueChange, null);
    }

    public BaseSingleValueChangeModifier(float pDuration, float pValueChange, IModifierListener<T> pModifierListener) {
        super(pDuration, pModifierListener);
        this.mValueChangePerSecond = pValueChange / pDuration;
    }

    protected BaseSingleValueChangeModifier(BaseSingleValueChangeModifier<T> pBaseSingleValueChangeModifier) {
        super((BaseDurationModifier) pBaseSingleValueChangeModifier);
        this.mValueChangePerSecond = pBaseSingleValueChangeModifier.mValueChangePerSecond;
    }

    protected void onManagedInitialize(T t) {
    }

    protected void onManagedUpdate(float pSecondsElapsed, T pItem) {
        onChangeValue(pSecondsElapsed, pItem, this.mValueChangePerSecond * pSecondsElapsed);
    }
}
