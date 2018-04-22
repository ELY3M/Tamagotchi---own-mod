package org.anddev.andengine.util.modifier;

import org.anddev.andengine.util.modifier.IModifier.DeepCopyNotSupportedException;
import org.anddev.andengine.util.modifier.IModifier.IModifierListener;
import org.anddev.andengine.util.modifier.util.ModifierUtils;

public class SequenceModifier<T> extends BaseModifier<T> implements IModifierListener<T> {
    private int mCurrentSubSequenceModifierIndex;
    private final float mDuration;
    private boolean mFinishedCached;
    private float mSecondsElapsed;
    private ISubSequenceModifierListener<T> mSubSequenceModifierListener;
    private final IModifier<T>[] mSubSequenceModifiers;

    public interface ISubSequenceModifierListener<T> {
        void onSubSequenceFinished(IModifier<T> iModifier, T t, int i);

        void onSubSequenceStarted(IModifier<T> iModifier, T t, int i);
    }

    public SequenceModifier(IModifier<T>... pModifiers) throws IllegalArgumentException {
        this(null, null, pModifiers);
    }

    public SequenceModifier(ISubSequenceModifierListener<T> pSubSequenceModifierListener, IModifier<T>... pModifiers) throws IllegalArgumentException {
        this(pSubSequenceModifierListener, null, pModifiers);
    }

    public SequenceModifier(IModifierListener<T> pModifierListener, IModifier<T>... pModifiers) throws IllegalArgumentException {
        this(null, pModifierListener, pModifiers);
    }

    public SequenceModifier(ISubSequenceModifierListener<T> pSubSequenceModifierListener, IModifierListener<T> pModifierListener, IModifier<T>... pModifiers) throws IllegalArgumentException {
        super(pModifierListener);
        if (pModifiers.length == 0) {
            throw new IllegalArgumentException("pModifiers must not be empty!");
        }
        this.mSubSequenceModifierListener = pSubSequenceModifierListener;
        this.mSubSequenceModifiers = pModifiers;
        this.mDuration = ModifierUtils.getSequenceDurationOfModifier(pModifiers);
        pModifiers[0].addModifierListener(this);
    }

    protected SequenceModifier(SequenceModifier<T> pSequenceModifier) throws DeepCopyNotSupportedException {
        this.mDuration = pSequenceModifier.mDuration;
        IModifier[] otherModifiers = pSequenceModifier.mSubSequenceModifiers;
        this.mSubSequenceModifiers = new IModifier[otherModifiers.length];
        IModifier[] shapeModifiers = this.mSubSequenceModifiers;
        for (int i = shapeModifiers.length - 1; i >= 0; i--) {
            shapeModifiers[i] = otherModifiers[i].deepCopy();
        }
        shapeModifiers[0].addModifierListener(this);
    }

    public SequenceModifier<T> deepCopy() throws DeepCopyNotSupportedException {
        return new SequenceModifier(this);
    }

    public ISubSequenceModifierListener<T> getSubSequenceModifierListener() {
        return this.mSubSequenceModifierListener;
    }

    public void setSubSequenceModifierListener(ISubSequenceModifierListener<T> pSubSequenceModifierListener) {
        this.mSubSequenceModifierListener = pSubSequenceModifierListener;
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
        float secondsElapsedRemaining = pSecondsElapsed;
        this.mFinishedCached = false;
        while (secondsElapsedRemaining > 0.0f && !this.mFinishedCached) {
            secondsElapsedRemaining -= this.mSubSequenceModifiers[this.mCurrentSubSequenceModifierIndex].onUpdate(secondsElapsedRemaining, pItem);
        }
        this.mFinishedCached = false;
        float secondsElapsedUsed = pSecondsElapsed - secondsElapsedRemaining;
        this.mSecondsElapsed += secondsElapsedUsed;
        return secondsElapsedUsed;
    }

    public void reset() {
        if (isFinished()) {
            this.mSubSequenceModifiers[this.mSubSequenceModifiers.length - 1].removeModifierListener(this);
        } else {
            this.mSubSequenceModifiers[this.mCurrentSubSequenceModifierIndex].removeModifierListener(this);
        }
        this.mCurrentSubSequenceModifierIndex = 0;
        this.mFinished = false;
        this.mSecondsElapsed = 0.0f;
        this.mSubSequenceModifiers[0].addModifierListener(this);
        IModifier[] shapeModifiers = this.mSubSequenceModifiers;
        for (int i = shapeModifiers.length - 1; i >= 0; i--) {
            shapeModifiers[i].reset();
        }
    }

    public void onModifierStarted(IModifier<T> pModifier, T pItem) {
        if (this.mCurrentSubSequenceModifierIndex == 0) {
            onModifierStarted(pItem);
        }
        if (this.mSubSequenceModifierListener != null) {
            this.mSubSequenceModifierListener.onSubSequenceStarted(pModifier, pItem, this.mCurrentSubSequenceModifierIndex);
        }
    }

    public void onModifierFinished(IModifier<T> pModifier, T pItem) {
        if (this.mSubSequenceModifierListener != null) {
            this.mSubSequenceModifierListener.onSubSequenceFinished(pModifier, pItem, this.mCurrentSubSequenceModifierIndex);
        }
        pModifier.removeModifierListener(this);
        this.mCurrentSubSequenceModifierIndex++;
        if (this.mCurrentSubSequenceModifierIndex < this.mSubSequenceModifiers.length) {
            this.mSubSequenceModifiers[this.mCurrentSubSequenceModifierIndex].addModifierListener(this);
            return;
        }
        this.mFinished = true;
        this.mFinishedCached = true;
        onModifierFinished(pItem);
    }
}
