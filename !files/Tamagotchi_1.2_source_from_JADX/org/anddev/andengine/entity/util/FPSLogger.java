package org.anddev.andengine.entity.util;

import android.support.v4.widget.AutoScrollHelper;
import org.anddev.andengine.util.Debug;

public class FPSLogger extends AverageFPSCounter {
    protected float mLongestFrame = Float.MIN_VALUE;
    protected float mShortestFrame = AutoScrollHelper.NO_MAX;

    public FPSLogger(float pAverageDuration) {
        super(pAverageDuration);
    }

    protected void onHandleAverageDurationElapsed(float pFPS) {
        onLogFPS();
        this.mLongestFrame = Float.MIN_VALUE;
        this.mShortestFrame = AutoScrollHelper.NO_MAX;
    }

    public void onUpdate(float pSecondsElapsed) {
        super.onUpdate(pSecondsElapsed);
        this.mShortestFrame = Math.min(this.mShortestFrame, pSecondsElapsed);
        this.mLongestFrame = Math.max(this.mLongestFrame, pSecondsElapsed);
    }

    public void reset() {
        super.reset();
        this.mShortestFrame = AutoScrollHelper.NO_MAX;
        this.mLongestFrame = Float.MIN_VALUE;
    }

    protected void onLogFPS() {
        Debug.m59d(String.format("FPS: %.2f (MIN: %.0f ms | MAX: %.0f ms)", new Object[]{Float.valueOf(((float) this.mFrames) / this.mSecondsElapsed), Float.valueOf(this.mShortestFrame * 1000.0f), Float.valueOf(this.mLongestFrame * 1000.0f)}));
    }
}
