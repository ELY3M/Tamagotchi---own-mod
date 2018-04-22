package org.anddev.andengine.input.touch.detector;

import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.input.touch.detector.ScrollDetector.IScrollDetectorListener;

public class SurfaceScrollDetector extends ScrollDetector {
    public SurfaceScrollDetector(float pTriggerScrollMinimumDistance, IScrollDetectorListener pScrollDetectorListener) {
        super(pTriggerScrollMinimumDistance, pScrollDetectorListener);
    }

    public SurfaceScrollDetector(IScrollDetectorListener pScrollDetectorListener) {
        super(pScrollDetectorListener);
    }

    protected float getX(TouchEvent pTouchEvent) {
        return pTouchEvent.getMotionEvent().getX();
    }

    protected float getY(TouchEvent pTouchEvent) {
        return pTouchEvent.getMotionEvent().getY();
    }
}
