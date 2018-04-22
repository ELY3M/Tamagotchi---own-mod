package org.anddev.andengine.entity.util;

import org.anddev.andengine.engine.handler.IUpdateHandler;

public class FPSCounter implements IUpdateHandler {
    protected int mFrames;
    protected float mSecondsElapsed;

    public float getFPS() {
        return ((float) this.mFrames) / this.mSecondsElapsed;
    }

    public void onUpdate(float pSecondsElapsed) {
        this.mFrames++;
        this.mSecondsElapsed += pSecondsElapsed;
    }

    public void reset() {
        this.mFrames = 0;
        this.mSecondsElapsed = 0.0f;
    }
}
