package org.anddev.andengine.input.touch.detector;

import android.os.SystemClock;
import android.view.MotionEvent;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.input.touch.TouchEvent;

public class HoldDetector extends BaseDetector implements IUpdateHandler {
    private static final float TIME_BETWEEN_UPDATES_DEFAULT = 0.1f;
    private static final float TRIGGER_HOLD_MAXIMUM_DISTANCE_DEFAULT = 10.0f;
    private static final long TRIGGER_HOLD_MINIMUM_MILLISECONDS_DEFAULT = 200;
    private long mDownTimeMilliseconds;
    private float mDownX;
    private float mDownY;
    private final IHoldDetectorListener mHoldDetectorListener;
    private float mHoldX;
    private float mHoldY;
    private boolean mMaximumDistanceExceeded;
    private final TimerHandler mTimerHandler;
    private float mTriggerHoldMaximumDistance;
    private long mTriggerHoldMinimumMilliseconds;
    private boolean mTriggerOnHold;
    private boolean mTriggerOnHoldFinished;

    public interface IHoldDetectorListener {
        void onHold(HoldDetector holdDetector, long j, float f, float f2);

        void onHoldFinished(HoldDetector holdDetector, long j, float f, float f2);
    }

    class C09221 implements ITimerCallback {
        C09221() {
        }

        public void onTimePassed(TimerHandler pTimerHandler) {
            HoldDetector.this.fireListener();
        }
    }

    public HoldDetector(IHoldDetectorListener pClickDetectorListener) {
        this(TRIGGER_HOLD_MINIMUM_MILLISECONDS_DEFAULT, TRIGGER_HOLD_MAXIMUM_DISTANCE_DEFAULT, TIME_BETWEEN_UPDATES_DEFAULT, pClickDetectorListener);
    }

    public HoldDetector(long pTriggerHoldMinimumMilliseconds, float pTriggerHoldMaximumDistance, float pTimeBetweenUpdates, IHoldDetectorListener pClickDetectorListener) {
        this.mDownTimeMilliseconds = Long.MIN_VALUE;
        this.mMaximumDistanceExceeded = false;
        this.mTriggerOnHold = false;
        this.mTriggerOnHoldFinished = false;
        this.mTriggerHoldMinimumMilliseconds = pTriggerHoldMinimumMilliseconds;
        this.mTriggerHoldMaximumDistance = pTriggerHoldMaximumDistance;
        this.mHoldDetectorListener = pClickDetectorListener;
        this.mTimerHandler = new TimerHandler(pTimeBetweenUpdates, true, new C09221());
    }

    public long getTriggerHoldMinimumMilliseconds() {
        return this.mTriggerHoldMinimumMilliseconds;
    }

    public void setTriggerHoldMinimumMilliseconds(long pTriggerHoldMinimumMilliseconds) {
        this.mTriggerHoldMinimumMilliseconds = pTriggerHoldMinimumMilliseconds;
    }

    public float getTriggerHoldMaximumDistance() {
        return this.mTriggerHoldMaximumDistance;
    }

    public void setTriggerHoldMaximumDistance(float pTriggerHoldMaximumDistance) {
        this.mTriggerHoldMaximumDistance = pTriggerHoldMaximumDistance;
    }

    public boolean isHolding() {
        return this.mTriggerOnHold;
    }

    public void onUpdate(float pSecondsElapsed) {
        this.mTimerHandler.onUpdate(pSecondsElapsed);
    }

    public void reset() {
        this.mTimerHandler.reset();
    }

    public boolean onManagedTouchEvent(TouchEvent pSceneTouchEvent) {
        boolean z = false;
        MotionEvent motionEvent = pSceneTouchEvent.getMotionEvent();
        this.mHoldX = pSceneTouchEvent.getX();
        this.mHoldY = pSceneTouchEvent.getY();
        float triggerHoldMaximumDistance;
        switch (pSceneTouchEvent.getAction()) {
            case 0:
                this.mDownTimeMilliseconds = motionEvent.getDownTime();
                this.mDownX = motionEvent.getX();
                this.mDownY = motionEvent.getY();
                this.mMaximumDistanceExceeded = false;
                return true;
            case 1:
            case 3:
                long upTimeMilliseconds = motionEvent.getEventTime();
                triggerHoldMaximumDistance = this.mTriggerHoldMaximumDistance;
                if (this.mMaximumDistanceExceeded || Math.abs(this.mDownX - motionEvent.getX()) > triggerHoldMaximumDistance || Math.abs(this.mDownY - motionEvent.getY()) > triggerHoldMaximumDistance) {
                    z = true;
                }
                this.mMaximumDistanceExceeded = z;
                if ((!this.mTriggerOnHold && this.mMaximumDistanceExceeded) || upTimeMilliseconds - this.mDownTimeMilliseconds < this.mTriggerHoldMinimumMilliseconds) {
                    return true;
                }
                this.mTriggerOnHoldFinished = true;
                return true;
            case 2:
                long currentTimeMilliseconds = motionEvent.getEventTime();
                triggerHoldMaximumDistance = this.mTriggerHoldMaximumDistance;
                if (this.mMaximumDistanceExceeded || Math.abs(this.mDownX - motionEvent.getX()) > triggerHoldMaximumDistance || Math.abs(this.mDownY - motionEvent.getY()) > triggerHoldMaximumDistance) {
                    z = true;
                }
                this.mMaximumDistanceExceeded = z;
                if ((!this.mTriggerOnHold && this.mMaximumDistanceExceeded) || currentTimeMilliseconds - this.mDownTimeMilliseconds < this.mTriggerHoldMinimumMilliseconds) {
                    return true;
                }
                this.mTriggerOnHold = true;
                return true;
            default:
                return false;
        }
    }

    protected void fireListener() {
        if (this.mTriggerOnHoldFinished) {
            this.mHoldDetectorListener.onHoldFinished(this, SystemClock.uptimeMillis() - this.mDownTimeMilliseconds, this.mHoldX, this.mHoldY);
            this.mTriggerOnHoldFinished = false;
            this.mTriggerOnHold = false;
        } else if (this.mTriggerOnHold) {
            this.mHoldDetectorListener.onHold(this, SystemClock.uptimeMillis() - this.mDownTimeMilliseconds, this.mHoldX, this.mHoldY);
        }
    }
}
