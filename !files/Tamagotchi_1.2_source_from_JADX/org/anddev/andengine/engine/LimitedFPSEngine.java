package org.anddev.andengine.engine;

import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.util.constants.TimeConstants;

public class LimitedFPSEngine extends Engine {
    private final long mPreferredFrameLengthNanoseconds;

    public LimitedFPSEngine(EngineOptions pEngineOptions, int pFramesPerSecond) {
        super(pEngineOptions);
        this.mPreferredFrameLengthNanoseconds = TimeConstants.NANOSECONDSPERSECOND / ((long) pFramesPerSecond);
    }

    public void onUpdate(long pNanosecondsElapsed) throws InterruptedException {
        long deltaFrameLengthNanoseconds = this.mPreferredFrameLengthNanoseconds - pNanosecondsElapsed;
        if (deltaFrameLengthNanoseconds <= 0) {
            super.onUpdate(pNanosecondsElapsed);
            return;
        }
        Thread.sleep((long) ((int) (deltaFrameLengthNanoseconds / TimeConstants.NANOSECONDSPERMILLISECOND)));
        super.onUpdate(pNanosecondsElapsed + deltaFrameLengthNanoseconds);
    }
}
