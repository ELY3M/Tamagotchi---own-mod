package org.anddev.andengine.entity.scene;

import android.util.SparseArray;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.runnable.RunnableHandler;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.scene.background.IBackground;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.util.GLHelper;
import org.anddev.andengine.util.IMatcher;
import org.anddev.andengine.util.SmartList;

public class Scene extends Entity {
    private static final int TOUCHAREAS_CAPACITY_DEFAULT = 4;
    private IBackground mBackground = new ColorBackground(0.0f, 0.0f, 0.0f);
    private boolean mBackgroundEnabled = true;
    protected Scene mChildScene;
    private boolean mChildSceneModalDraw;
    private boolean mChildSceneModalTouch;
    private boolean mChildSceneModalUpdate;
    private IOnAreaTouchListener mOnAreaTouchListener;
    private boolean mOnAreaTouchTraversalBackToFront = true;
    private IOnSceneTouchListener mOnSceneTouchListener;
    private boolean mOnSceneTouchListenerBindingEnabled = false;
    private final SparseArray<IOnSceneTouchListener> mOnSceneTouchListenerBindings = new SparseArray();
    protected Scene mParentScene;
    private final RunnableHandler mRunnableHandler = new RunnableHandler();
    private float mSecondsElapsedTotal;
    private boolean mTouchAreaBindingEnabled = false;
    private final SparseArray<ITouchArea> mTouchAreaBindings = new SparseArray();
    protected SmartList<ITouchArea> mTouchAreas = new SmartList(4);

    public interface IOnAreaTouchListener {
        boolean onAreaTouched(TouchEvent touchEvent, ITouchArea iTouchArea, float f, float f2);
    }

    public interface IOnSceneTouchListener {
        boolean onSceneTouchEvent(Scene scene, TouchEvent touchEvent);
    }

    public interface ITouchArea {

        public interface ITouchAreaMatcher extends IMatcher<ITouchArea> {
        }

        boolean contains(float f, float f2);

        float[] convertLocalToSceneCoordinates(float f, float f2);

        float[] convertSceneToLocalCoordinates(float f, float f2);

        boolean onAreaTouched(TouchEvent touchEvent, float f, float f2);
    }

    @Deprecated
    public Scene(int pChildCount) {
        for (int i = 0; i < pChildCount; i++) {
            attachChild(new Entity());
        }
    }

    public float getSecondsElapsedTotal() {
        return this.mSecondsElapsedTotal;
    }

    public IBackground getBackground() {
        return this.mBackground;
    }

    public void setBackground(IBackground pBackground) {
        this.mBackground = pBackground;
    }

    public boolean isBackgroundEnabled() {
        return this.mBackgroundEnabled;
    }

    public void setBackgroundEnabled(boolean pEnabled) {
        this.mBackgroundEnabled = pEnabled;
    }

    public void setOnSceneTouchListener(IOnSceneTouchListener pOnSceneTouchListener) {
        this.mOnSceneTouchListener = pOnSceneTouchListener;
    }

    public IOnSceneTouchListener getOnSceneTouchListener() {
        return this.mOnSceneTouchListener;
    }

    public boolean hasOnSceneTouchListener() {
        return this.mOnSceneTouchListener != null;
    }

    public void setOnAreaTouchListener(IOnAreaTouchListener pOnAreaTouchListener) {
        this.mOnAreaTouchListener = pOnAreaTouchListener;
    }

    public IOnAreaTouchListener getOnAreaTouchListener() {
        return this.mOnAreaTouchListener;
    }

    public boolean hasOnAreaTouchListener() {
        return this.mOnAreaTouchListener != null;
    }

    private void setParentScene(Scene pParentScene) {
        this.mParentScene = pParentScene;
    }

    public boolean hasChildScene() {
        return this.mChildScene != null;
    }

    public Scene getChildScene() {
        return this.mChildScene;
    }

    public void setChildSceneModal(Scene pChildScene) {
        setChildScene(pChildScene, true, true, true);
    }

    public void setChildScene(Scene pChildScene) {
        setChildScene(pChildScene, false, false, false);
    }

    public void setChildScene(Scene pChildScene, boolean pModalDraw, boolean pModalUpdate, boolean pModalTouch) {
        pChildScene.setParentScene(this);
        this.mChildScene = pChildScene;
        this.mChildSceneModalDraw = pModalDraw;
        this.mChildSceneModalUpdate = pModalUpdate;
        this.mChildSceneModalTouch = pModalTouch;
    }

    public void clearChildScene() {
        this.mChildScene = null;
    }

    public void setOnAreaTouchTraversalBackToFront() {
        this.mOnAreaTouchTraversalBackToFront = true;
    }

    public void setOnAreaTouchTraversalFrontToBack() {
        this.mOnAreaTouchTraversalBackToFront = false;
    }

    public boolean isTouchAreaBindingEnabled() {
        return this.mTouchAreaBindingEnabled;
    }

    public void setTouchAreaBindingEnabled(boolean pTouchAreaBindingEnabled) {
        if (this.mTouchAreaBindingEnabled && !pTouchAreaBindingEnabled) {
            this.mTouchAreaBindings.clear();
        }
        this.mTouchAreaBindingEnabled = pTouchAreaBindingEnabled;
    }

    public boolean isOnSceneTouchListenerBindingEnabled() {
        return this.mOnSceneTouchListenerBindingEnabled;
    }

    public void setOnSceneTouchListenerBindingEnabled(boolean pOnSceneTouchListenerBindingEnabled) {
        if (this.mOnSceneTouchListenerBindingEnabled && !pOnSceneTouchListenerBindingEnabled) {
            this.mOnSceneTouchListenerBindings.clear();
        }
        this.mOnSceneTouchListenerBindingEnabled = pOnSceneTouchListenerBindingEnabled;
    }

    protected void onManagedDraw(GL10 pGL, Camera pCamera) {
        Scene childScene = this.mChildScene;
        if (childScene == null || !this.mChildSceneModalDraw) {
            if (this.mBackgroundEnabled) {
                pCamera.onApplySceneBackgroundMatrix(pGL);
                GLHelper.setModelViewIdentityMatrix(pGL);
                this.mBackground.onDraw(pGL, pCamera);
            }
            pCamera.onApplySceneMatrix(pGL);
            GLHelper.setModelViewIdentityMatrix(pGL);
            super.onManagedDraw(pGL, pCamera);
        }
        if (childScene != null) {
            childScene.onDraw(pGL, pCamera);
        }
    }

    protected void onManagedUpdate(float pSecondsElapsed) {
        this.mSecondsElapsedTotal += pSecondsElapsed;
        this.mRunnableHandler.onUpdate(pSecondsElapsed);
        Scene childScene = this.mChildScene;
        if (childScene == null || !this.mChildSceneModalUpdate) {
            this.mBackground.onUpdate(pSecondsElapsed);
            super.onManagedUpdate(pSecondsElapsed);
        }
        if (childScene != null) {
            childScene.onUpdate(pSecondsElapsed);
        }
    }

    public boolean onSceneTouchEvent(TouchEvent pSceneTouchEvent) {
        Boolean handled;
        float sceneTouchEventX;
        float sceneTouchEventY;
        int action = pSceneTouchEvent.getAction();
        boolean isActionDown = pSceneTouchEvent.isActionDown();
        if (!isActionDown) {
            if (this.mOnSceneTouchListenerBindingEnabled && ((IOnSceneTouchListener) this.mOnSceneTouchListenerBindings.get(pSceneTouchEvent.getPointerID())) != null) {
                switch (action) {
                    case 1:
                    case 3:
                        this.mOnSceneTouchListenerBindings.remove(pSceneTouchEvent.getPointerID());
                        break;
                }
                handled = Boolean.valueOf(this.mOnSceneTouchListener.onSceneTouchEvent(this, pSceneTouchEvent));
                if (handled != null && handled.booleanValue()) {
                    return true;
                }
            }
            if (this.mTouchAreaBindingEnabled) {
                SparseArray<ITouchArea> touchAreaBindings = this.mTouchAreaBindings;
                ITouchArea boundTouchArea = (ITouchArea) touchAreaBindings.get(pSceneTouchEvent.getPointerID());
                if (boundTouchArea != null) {
                    sceneTouchEventX = pSceneTouchEvent.getX();
                    sceneTouchEventY = pSceneTouchEvent.getY();
                    switch (action) {
                        case 1:
                        case 3:
                            touchAreaBindings.remove(pSceneTouchEvent.getPointerID());
                            break;
                    }
                    handled = onAreaTouchEvent(pSceneTouchEvent, sceneTouchEventX, sceneTouchEventY, boundTouchArea);
                    if (handled != null && handled.booleanValue()) {
                        return true;
                    }
                }
            }
        }
        if (this.mChildScene != null) {
            if (onChildSceneTouchEvent(pSceneTouchEvent)) {
                return true;
            }
            if (this.mChildSceneModalTouch) {
                return false;
            }
        }
        sceneTouchEventX = pSceneTouchEvent.getX();
        sceneTouchEventY = pSceneTouchEvent.getY();
        ArrayList touchAreas = this.mTouchAreas;
        if (touchAreas != null) {
            int touchAreaCount = touchAreas.size();
            if (touchAreaCount > 0) {
                int i;
                ITouchArea touchArea;
                if (this.mOnAreaTouchTraversalBackToFront) {
                    for (i = 0; i < touchAreaCount; i++) {
                        touchArea = (ITouchArea) touchAreas.get(i);
                        if (touchArea.contains(sceneTouchEventX, sceneTouchEventY)) {
                            handled = onAreaTouchEvent(pSceneTouchEvent, sceneTouchEventX, sceneTouchEventY, touchArea);
                            if (handled != null && handled.booleanValue()) {
                                if (this.mTouchAreaBindingEnabled && isActionDown) {
                                    this.mTouchAreaBindings.put(pSceneTouchEvent.getPointerID(), touchArea);
                                }
                                return true;
                            }
                        }
                    }
                } else {
                    for (i = touchAreaCount - 1; i >= 0; i--) {
                        touchArea = (ITouchArea) touchAreas.get(i);
                        if (touchArea.contains(sceneTouchEventX, sceneTouchEventY)) {
                            handled = onAreaTouchEvent(pSceneTouchEvent, sceneTouchEventX, sceneTouchEventY, touchArea);
                            if (handled != null && handled.booleanValue()) {
                                if (this.mTouchAreaBindingEnabled && isActionDown) {
                                    this.mTouchAreaBindings.put(pSceneTouchEvent.getPointerID(), touchArea);
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        }
        if (this.mOnSceneTouchListener == null) {
            return false;
        }
        handled = Boolean.valueOf(this.mOnSceneTouchListener.onSceneTouchEvent(this, pSceneTouchEvent));
        if (handled == null || !handled.booleanValue()) {
            return false;
        }
        if (this.mOnSceneTouchListenerBindingEnabled && isActionDown) {
            this.mOnSceneTouchListenerBindings.put(pSceneTouchEvent.getPointerID(), this.mOnSceneTouchListener);
        }
        return true;
    }

    private Boolean onAreaTouchEvent(TouchEvent pSceneTouchEvent, float sceneTouchEventX, float sceneTouchEventY, ITouchArea touchArea) {
        float[] touchAreaLocalCoordinates = touchArea.convertSceneToLocalCoordinates(sceneTouchEventX, sceneTouchEventY);
        float touchAreaLocalX = touchAreaLocalCoordinates[0];
        float touchAreaLocalY = touchAreaLocalCoordinates[1];
        if (touchArea.onAreaTouched(pSceneTouchEvent, touchAreaLocalX, touchAreaLocalY)) {
            return Boolean.TRUE;
        }
        if (this.mOnAreaTouchListener != null) {
            return Boolean.valueOf(this.mOnAreaTouchListener.onAreaTouched(pSceneTouchEvent, touchArea, touchAreaLocalX, touchAreaLocalY));
        }
        return null;
    }

    protected boolean onChildSceneTouchEvent(TouchEvent pSceneTouchEvent) {
        return this.mChildScene.onSceneTouchEvent(pSceneTouchEvent);
    }

    public void reset() {
        super.reset();
        clearChildScene();
    }

    public void setParent(IEntity pEntity) {
    }

    public void postRunnable(Runnable pRunnable) {
        this.mRunnableHandler.postRunnable(pRunnable);
    }

    public void registerTouchArea(ITouchArea pTouchArea) {
        this.mTouchAreas.add(pTouchArea);
    }

    public boolean unregisterTouchArea(ITouchArea pTouchArea) {
        return this.mTouchAreas.remove(pTouchArea);
    }

    public boolean unregisterTouchAreas(ITouchAreaMatcher pTouchAreaMatcher) {
        return this.mTouchAreas.removeAll(pTouchAreaMatcher);
    }

    public void clearTouchAreas() {
        this.mTouchAreas.clear();
    }

    public ArrayList<ITouchArea> getTouchAreas() {
        return this.mTouchAreas;
    }

    public void back() {
        clearChildScene();
        if (this.mParentScene != null) {
            this.mParentScene.clearChildScene();
            this.mParentScene = null;
        }
    }
}
