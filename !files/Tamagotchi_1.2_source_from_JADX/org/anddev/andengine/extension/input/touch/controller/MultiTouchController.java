package org.anddev.andengine.extension.input.touch.controller;

import android.view.MotionEvent;
import org.anddev.andengine.extension.input.touch.exception.MultiTouchException;
import org.anddev.andengine.input.touch.controller.BaseTouchController;

public class MultiTouchController extends BaseTouchController {
    public MultiTouchController() throws MultiTouchException {
        if (!MultiTouch.isSupportedByAndroidVersion()) {
            throw new MultiTouchException();
        }
    }

    public boolean onHandleMotionEvent(MotionEvent pMotionEvent) {
        int action = pMotionEvent.getAction() & 255;
        switch (action) {
            case 0:
            case 5:
                return onHandleTouchAction(0, pMotionEvent);
            case 1:
            case 6:
                return onHandleTouchAction(1, pMotionEvent);
            case 2:
                return onHandleTouchMove(pMotionEvent);
            case 3:
            case 4:
                return onHandleTouchAction(action, pMotionEvent);
            default:
                throw new IllegalArgumentException("Invalid Action detected: " + action);
        }
    }

    private boolean onHandleTouchMove(MotionEvent pMotionEvent) {
        boolean handled = false;
        for (int i = pMotionEvent.getPointerCount() - 1; i >= 0; i--) {
            int pointerIndex = i;
            handled = handled || fireTouchEvent(pMotionEvent.getX(pointerIndex), pMotionEvent.getY(pointerIndex), 2, pMotionEvent.getPointerId(pointerIndex), pMotionEvent);
        }
        return handled;
    }

    private boolean onHandleTouchAction(int pAction, MotionEvent pMotionEvent) {
        int pointerIndex = getPointerIndex(pMotionEvent);
        return fireTouchEvent(pMotionEvent.getX(pointerIndex), pMotionEvent.getY(pointerIndex), pAction, pMotionEvent.getPointerId(pointerIndex), pMotionEvent);
    }

    private int getPointerIndex(MotionEvent pMotionEvent) {
        return (pMotionEvent.getAction() & 65280) >> 8;
    }
}
