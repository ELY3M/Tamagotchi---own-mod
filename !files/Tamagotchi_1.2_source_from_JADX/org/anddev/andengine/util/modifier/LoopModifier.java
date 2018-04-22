package org.anddev.andengine.util.modifier;

import org.anddev.andengine.util.modifier.IModifier.DeepCopyNotSupportedException;
import org.anddev.andengine.util.modifier.IModifier.IModifierListener;

public class LoopModifier<T> extends BaseModifier<T> implements IModifierListener<T> {
    public static final int LOOP_CONTINUOUS = -1;
    private final float mDuration;
    private boolean mFinishedCached;
    private int mLoop;
    private final int mLoopCount;
    private ILoopModifierListener<T> mLoopModifierListener;
    private final IModifier<T> mModifier;
    private boolean mModifierStartedCalled;
    private float mSecondsElapsed;

    public interface ILoopModifierListener<T> {
        void onLoopFinished(LoopModifier<T> loopModifier, int i, int i2);

        void onLoopStarted(LoopModifier<T> loopModifier, int i, int i2);
    }

    public LoopModifier(IModifier<T> pModifier) {
        this(pModifier, -1);
    }

    public LoopModifier(IModifier<T> pModifier, int pLoopCount) {
        this(pModifier, pLoopCount, null, null);
    }

    public LoopModifier(IModifier<T> pModifier, int pLoopCount, IModifierListener<T> pModifierListener) {
        this(pModifier, pLoopCount, null, pModifierListener);
    }

    public LoopModifier(IModifier<T> pModifier, int pLoopCount, ILoopModifierListener<T> pLoopModifierListener) {
        this(pModifier, pLoopCount, pLoopModifierListener, null);
    }

    public LoopModifier(IModifier<T> pModifier, int pLoopCount, ILoopModifierListener<T> pLoopModifierListener, IModifierListener<T> pModifierListener) {
        super(pModifierListener);
        this.mModifier = pModifier;
        this.mLoopCount = pLoopCount;
        this.mLoopModifierListener = pLoopModifierListener;
        this.mLoop = 0;
        this.mDuration = pLoopCount == -1 ? Float.POSITIVE_INFINITY : pModifier.getDuration() * ((float) pLoopCount);
        this.mModifier.addModifierListener(this);
    }

    protected LoopModifier(LoopModifier<T> pLoopModifier) throws DeepCopyNotSupportedException {
        this(pLoopModifier.mModifier.deepCopy(), pLoopModifier.mLoopCount);
    }

    public LoopModifier<T> deepCopy() throws DeepCopyNotSupportedException {
        return new LoopModifier(this);
    }

    public ILoopModifierListener<T> getLoopModifierListener() {
        return this.mLoopModifierListener;
    }

    public void setLoopModifierListener(ILoopModifierListener<T> pLoopModifierListener) {
        this.mLoopModifierListener = pLoopModifierListener;
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
            secondsElapsedRemaining -= this.mModifier.onUpdate(secondsElapsedRemaining, pItem);
        }
        this.mFinishedCached = false;
        float secondsElapsedUsed = pSecondsElapsed - secondsElapsedRemaining;
        this.mSecondsElapsed += secondsElapsedUsed;
        return secondsElapsedUsed;
    }

    public void reset() {
        this.mLoop = 0;
        this.mSecondsElapsed = 0.0f;
        this.mModifierStartedCalled = false;
        this.mModifier.reset();
    }

    public void onModifierStarted(IModifier<T> iModifier, T pItem) {
        if (!this.mModifierStartedCalled) {
            this.mModifierStartedCalled = true;
            onModifierStarted(pItem);
        }
        if (this.mLoopModifierListener != null) {
            this.mLoopModifierListener.onLoopStarted(this, this.mLoop, this.mLoopCount);
        }
    }

    public void onModifierFinished(IModifier<T> iModifier, T pItem) {
        if (this.mLoopModifierListener != null) {
            this.mLoopModifierListener.onLoopFinished(this, this.mLoop, this.mLoopCount);
        }
        if (this.mLoopCount == -1) {
            this.mSecondsElapsed = 0.0f;
            this.mModifier.reset();
            return;
        }
        this.mLoop++;
        if (this.mLoop >= this.mLoopCount) {
            this.mFinished = true;
            this.mFinishedCached = true;
            onModifierFinished(pItem);
            return;
        }
        this.mSecondsElapsed = 0.0f;
        this.mModifier.reset();
    }
}
