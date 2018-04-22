package org.anddev.andengine.util.modifier;

import org.anddev.andengine.util.modifier.IModifier.IModifierListener;

public abstract class BaseDurationModifier<T> extends BaseModifier<T> {
    protected final float mDuration;
    private float mSecondsElapsed;

    protected abstract void onManagedInitialize(T t);

    protected abstract void onManagedUpdate(float f, T t);

    public BaseDurationModifier(float pDuration) {
        this.mDuration = pDuration;
    }

    public BaseDurationModifier(float pDuration, IModifierListener<T> pModifierListener) {
        super(pModifierListener);
        this.mDuration = pDuration;
    }

    protected BaseDurationModifier(BaseDurationModifier<T> pBaseModifier) {
        this(pBaseModifier.mDuration);
    }

    public float getSecondsElapsed() {
        return this.mSecondsElapsed;
    }

    public float getDuration() {
        return this.mDuration;
    }

    public final float onUpdate(float pSecondsElapsed, T pItem) {
        float f = 0.0f;
        if (!this.mFinished) {
            if (this.mSecondsElapsed == 0.0f) {
                onManagedInitialize(pItem);
                onModifierStarted(pItem);
            }
            if (this.mSecondsElapsed + pSecondsElapsed < this.mDuration) {
                f = pSecondsElapsed;
            } else {
                f = this.mDuration - this.mSecondsElapsed;
            }
            this.mSecondsElapsed += f;
            onManagedUpdate(f, pItem);
            if (this.mDuration != -1.0f && this.mSecondsElapsed >= this.mDuration) {
                this.mSecondsElapsed = this.mDuration;
                this.mFinished = true;
                onModifierFinished(pItem);
            }
        }
        return f;
    }

    public void reset() {
        this.mFinished = false;
        this.mSecondsElapsed = 0.0f;
    }
}
