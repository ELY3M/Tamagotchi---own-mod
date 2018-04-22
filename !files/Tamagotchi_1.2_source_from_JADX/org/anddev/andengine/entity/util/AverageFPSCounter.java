package org.anddev.andengine.entity.util;

import org.anddev.andengine.util.constants.TimeConstants;

public abstract class AverageFPSCounter extends FPSCounter implements TimeConstants {
    private static final float AVERAGE_DURATION_DEFAULT = 5.0f;
    protected final float mAverageDuration;

    protected abstract void onHandleAverageDurationElapsed(float f);

    public AverageFPSCounter() {
        this(AVERAGE_DURATION_DEFAULT);
    }

    public AverageFPSCounter(float pAverageDuration) {
        this.mAverageDuration = pAverageDuration;
    }

    public void onUpdate(float pSecondsElapsed) {
        super.onUpdate(pSecondsElapsed);
        if (this.mSecondsElapsed > this.mAverageDuration) {
            onHandleAverageDurationElapsed(getFPS());
            this.mSecondsElapsed -= this.mAverageDuration;
            this.mFrames = 0;
        }
    }
}
