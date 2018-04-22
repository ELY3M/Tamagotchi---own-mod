package org.anddev.andengine.util.modifier;

import java.util.Arrays;
import org.anddev.andengine.util.modifier.IModifier.DeepCopyNotSupportedException;
import org.anddev.andengine.util.modifier.IModifier.IModifierListener;

public class ParallelModifier<T> extends BaseModifier<T> implements IModifierListener<T> {
    private final float mDuration;
    private boolean mFinishedCached;
    private final IModifier<T>[] mModifiers;
    private float mSecondsElapsed;

    public ParallelModifier(IModifier<T>... pModifiers) throws IllegalArgumentException {
        this(null, pModifiers);
    }

    public ParallelModifier(IModifierListener<T> pModifierListener, IModifier<T>... pModifiers) throws IllegalArgumentException {
        super(pModifierListener);
        if (pModifiers.length == 0) {
            throw new IllegalArgumentException("pModifiers must not be empty!");
        }
        Arrays.sort(pModifiers, MODIFIER_COMPARATOR_DURATION_DESCENDING);
        this.mModifiers = pModifiers;
        IModifier<T> modifierWithLongestDuration = pModifiers[0];
        this.mDuration = modifierWithLongestDuration.getDuration();
        modifierWithLongestDuration.addModifierListener(this);
    }

    protected ParallelModifier(ParallelModifier<T> pParallelModifier) throws DeepCopyNotSupportedException {
        IModifier[] otherModifiers = pParallelModifier.mModifiers;
        this.mModifiers = new IModifier[otherModifiers.length];
        IModifier[] modifiers = this.mModifiers;
        for (int i = modifiers.length - 1; i >= 0; i--) {
            modifiers[i] = otherModifiers[i].deepCopy();
        }
        IModifier<T> modifierWithLongestDuration = modifiers[0];
        this.mDuration = modifierWithLongestDuration.getDuration();
        modifierWithLongestDuration.addModifierListener(this);
    }

    public ParallelModifier<T> deepCopy() throws DeepCopyNotSupportedException {
        return new ParallelModifier(this);
    }

    public float getSecondsElapsed() {
        return this.mSecondsElapsed;
    }

    public float getDuration() {
        return this.mDuration;
    }

    public float onUpdate(float pSecondsElapsed, T pItem) {
        if (this.mFinished) {
            return 0.0f;
        }
        float secondsElapsedUsed;
        float secondsElapsedRemaining = pSecondsElapsed;
        IModifier[] shapeModifiers = this.mModifiers;
        this.mFinishedCached = false;
        while (secondsElapsedRemaining > 0.0f && !this.mFinishedCached) {
            secondsElapsedUsed = 0.0f;
            for (int i = shapeModifiers.length - 1; i >= 0; i--) {
                secondsElapsedUsed = Math.max(secondsElapsedUsed, shapeModifiers[i].onUpdate(pSecondsElapsed, pItem));
            }
            secondsElapsedRemaining -= secondsElapsedUsed;
        }
        this.mFinishedCached = false;
        secondsElapsedUsed = pSecondsElapsed - secondsElapsedRemaining;
        this.mSecondsElapsed += secondsElapsedUsed;
        return secondsElapsedUsed;
    }

    public void reset() {
        this.mFinished = false;
        this.mSecondsElapsed = 0.0f;
        IModifier[] shapeModifiers = this.mModifiers;
        for (int i = shapeModifiers.length - 1; i >= 0; i--) {
            shapeModifiers[i].reset();
        }
    }

    public void onModifierStarted(IModifier<T> iModifier, T pItem) {
        onModifierStarted(pItem);
    }

    public void onModifierFinished(IModifier<T> iModifier, T pItem) {
        this.mFinished = true;
        this.mFinishedCached = true;
        onModifierFinished(pItem);
    }
}
