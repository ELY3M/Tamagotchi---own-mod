package org.anddev.andengine.entity.util;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.constants.TimeConstants;

public class FrameCountCrasher implements IUpdateHandler, TimeConstants {
    private final float[] mFrameLengths;
    private int mFramesLeft;

    public FrameCountCrasher(int pFrameCount) {
        this.mFramesLeft = pFrameCount;
        this.mFrameLengths = new float[pFrameCount];
    }

    public void onUpdate(float pSecondsElapsed) {
        this.mFramesLeft--;
        float[] frameLengths = this.mFrameLengths;
        if (this.mFramesLeft >= 0) {
            frameLengths[this.mFramesLeft] = pSecondsElapsed;
            return;
        }
        for (int i = frameLengths.length - 1; i >= 0; i--) {
            Debug.m59d("Elapsed: " + frameLengths[i]);
        }
        throw new RuntimeException();
    }

    public void reset() {
    }
}
