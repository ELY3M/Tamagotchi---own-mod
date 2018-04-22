package org.anddev.andengine.input.touch.detector;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.input.touch.TouchEvent;

public abstract class BaseDetector implements IOnSceneTouchListener {
    private boolean mEnabled = true;

    protected abstract boolean onManagedTouchEvent(TouchEvent touchEvent);

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean pEnabled) {
        this.mEnabled = pEnabled;
    }

    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        return onTouchEvent(pSceneTouchEvent);
    }

    public final boolean onTouchEvent(TouchEvent pSceneTouchEvent) {
        if (this.mEnabled) {
            return onManagedTouchEvent(pSceneTouchEvent);
        }
        return false;
    }
}
