package org.anddev.andengine.engine;

import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.util.constants.TimeConstants;

public class FixedStepEngine extends Engine {
    private long mSecondsElapsedAccumulator;
    private final long mStepLength;

    public FixedStepEngine(EngineOptions pEngineOptions, int pStepsPerSecond) {
        super(pEngineOptions);
        this.mStepLength = TimeConstants.NANOSECONDSPERSECOND / ((long) pStepsPerSecond);
    }

    public void onUpdate(long pNanosecondsElapsed) throws InterruptedException {
        this.mSecondsElapsedAccumulator += pNanosecondsElapsed;
        long stepLength = this.mStepLength;
        while (this.mSecondsElapsedAccumulator >= stepLength) {
            super.onUpdate(stepLength);
            this.mSecondsElapsedAccumulator -= stepLength;
        }
    }
}
