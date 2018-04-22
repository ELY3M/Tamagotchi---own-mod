package org.anddev.andengine.input.touch.controller;

import android.view.MotionEvent;
import org.anddev.andengine.engine.options.TouchOptions;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.input.touch.controller.ITouchController.ITouchEventCallback;
import org.anddev.andengine.util.pool.RunnablePoolItem;
import org.anddev.andengine.util.pool.RunnablePoolUpdateHandler;

public abstract class BaseTouchController implements ITouchController {
    private boolean mRunOnUpdateThread;
    private ITouchEventCallback mTouchEventCallback;
    private final RunnablePoolUpdateHandler<TouchEventRunnablePoolItem> mTouchEventRunnablePoolUpdateHandler = new C10801();

    class TouchEventRunnablePoolItem extends RunnablePoolItem {
        private TouchEvent mTouchEvent;

        TouchEventRunnablePoolItem() {
        }

        public void set(TouchEvent pTouchEvent) {
            this.mTouchEvent = pTouchEvent;
        }

        public void run() {
            BaseTouchController.this.mTouchEventCallback.onTouchEvent(this.mTouchEvent);
        }

        protected void onRecycle() {
            super.onRecycle();
            TouchEvent touchEvent = this.mTouchEvent;
            touchEvent.getMotionEvent().recycle();
            touchEvent.recycle();
        }
    }

    class C10801 extends RunnablePoolUpdateHandler<TouchEventRunnablePoolItem> {
        C10801() {
        }

        protected TouchEventRunnablePoolItem onAllocatePoolItem() {
            return new TouchEventRunnablePoolItem();
        }
    }

    public void setTouchEventCallback(ITouchEventCallback pTouchEventCallback) {
        this.mTouchEventCallback = pTouchEventCallback;
    }

    public void reset() {
        if (this.mRunOnUpdateThread) {
            this.mTouchEventRunnablePoolUpdateHandler.reset();
        }
    }

    public void onUpdate(float pSecondsElapsed) {
        if (this.mRunOnUpdateThread) {
            this.mTouchEventRunnablePoolUpdateHandler.onUpdate(pSecondsElapsed);
        }
    }

    protected boolean fireTouchEvent(float pX, float pY, int pAction, int pPointerID, MotionEvent pMotionEvent) {
        if (this.mRunOnUpdateThread) {
            TouchEventRunnablePoolItem touchEventRunnablePoolItem = (TouchEventRunnablePoolItem) this.mTouchEventRunnablePoolUpdateHandler.obtainPoolItem();
            touchEventRunnablePoolItem.set(TouchEvent.obtain(pX, pY, pAction, pPointerID, MotionEvent.obtain(pMotionEvent)));
            this.mTouchEventRunnablePoolUpdateHandler.postPoolItem(touchEventRunnablePoolItem);
            return true;
        }
        TouchEvent touchEvent = TouchEvent.obtain(pX, pY, pAction, pPointerID, pMotionEvent);
        boolean handled = this.mTouchEventCallback.onTouchEvent(touchEvent);
        touchEvent.recycle();
        return handled;
    }

    public void applyTouchOptions(TouchOptions pTouchOptions) {
        this.mRunOnUpdateThread = pTouchOptions.isRunOnUpdateThread();
    }
}
