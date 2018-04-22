package org.anddev.andengine.input.touch.controller;

import android.view.MotionEvent;

public class SingleTouchControler extends BaseTouchController {
    public boolean onHandleMotionEvent(MotionEvent pMotionEvent) {
        return fireTouchEvent(pMotionEvent.getX(), pMotionEvent.getY(), pMotionEvent.getAction(), 0, pMotionEvent);
    }
}
