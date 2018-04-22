package org.anddev.andengine.extension.input.touch.detector;

import android.util.FloatMath;
import android.view.MotionEvent;
import org.anddev.andengine.extension.input.touch.controller.MultiTouch;
import org.anddev.andengine.extension.input.touch.exception.MultiTouchException;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.input.touch.detector.BaseDetector;

public class PinchZoomDetector extends BaseDetector {
    private static final float TRIGGER_PINCHZOOM_MINIMUM_DISTANCE_DEFAULT = 10.0f;
    private float mCurrentDistance;
    private float mInitialDistance;
    private final IPinchZoomDetectorListener mPinchZoomDetectorListener;
    private boolean mPinchZooming;

    public interface IPinchZoomDetectorListener {
        void onPinchZoom(PinchZoomDetector pinchZoomDetector, TouchEvent touchEvent, float f);

        void onPinchZoomFinished(PinchZoomDetector pinchZoomDetector, TouchEvent touchEvent, float f);

        void onPinchZoomStarted(PinchZoomDetector pinchZoomDetector, TouchEvent touchEvent);
    }

    public PinchZoomDetector(IPinchZoomDetectorListener pPinchZoomDetectorListener) throws MultiTouchException {
        if (MultiTouch.isSupportedByAndroidVersion()) {
            this.mPinchZoomDetectorListener = pPinchZoomDetectorListener;
            return;
        }
        throw new MultiTouchException();
    }

    public boolean isZooming() {
        return this.mPinchZooming;
    }

    public boolean onManagedTouchEvent(TouchEvent pSceneTouchEvent) {
        MotionEvent motionEvent = pSceneTouchEvent.getMotionEvent();
        switch (motionEvent.getAction() & 255) {
            case 1:
            case 6:
                if (this.mPinchZooming) {
                    this.mPinchZooming = false;
                    this.mPinchZoomDetectorListener.onPinchZoomFinished(this, pSceneTouchEvent, getZoomFactor());
                    break;
                }
                break;
            case 2:
                if (this.mPinchZooming) {
                    this.mCurrentDistance = calculatePointerDistance(motionEvent);
                    if (this.mCurrentDistance > TRIGGER_PINCHZOOM_MINIMUM_DISTANCE_DEFAULT) {
                        this.mPinchZoomDetectorListener.onPinchZoom(this, pSceneTouchEvent, getZoomFactor());
                        break;
                    }
                }
                break;
            case 5:
                if (!this.mPinchZooming) {
                    this.mInitialDistance = calculatePointerDistance(motionEvent);
                    if (this.mInitialDistance > TRIGGER_PINCHZOOM_MINIMUM_DISTANCE_DEFAULT) {
                        this.mPinchZooming = true;
                        this.mPinchZoomDetectorListener.onPinchZoomStarted(this, pSceneTouchEvent);
                        break;
                    }
                }
                break;
        }
        return true;
    }

    private float getZoomFactor() {
        return this.mCurrentDistance / this.mInitialDistance;
    }

    private static float calculatePointerDistance(MotionEvent pMotionEvent) {
        float x = pMotionEvent.getX(0) - pMotionEvent.getX(1);
        float y = pMotionEvent.getY(0) - pMotionEvent.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }
}
