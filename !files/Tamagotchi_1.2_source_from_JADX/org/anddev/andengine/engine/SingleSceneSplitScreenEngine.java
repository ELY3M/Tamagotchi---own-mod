package org.anddev.andengine.engine;

import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.util.GLHelper;

public class SingleSceneSplitScreenEngine extends Engine {
    private final Camera mSecondCamera;

    public SingleSceneSplitScreenEngine(EngineOptions pEngineOptions, Camera pSecondCamera) {
        super(pEngineOptions);
        this.mSecondCamera = pSecondCamera;
    }

    @Deprecated
    public Camera getCamera() {
        return this.mCamera;
    }

    public Camera getFirstCamera() {
        return this.mCamera;
    }

    public Camera getSecondCamera() {
        return this.mSecondCamera;
    }

    protected void onDrawScene(GL10 pGL) {
        Camera firstCamera = getFirstCamera();
        Camera secondCamera = getSecondCamera();
        int surfaceWidthHalf = this.mSurfaceWidth >> 1;
        int surfaceHeight = this.mSurfaceHeight;
        GLHelper.enableScissorTest(pGL);
        pGL.glScissor(0, 0, surfaceWidthHalf, surfaceHeight);
        pGL.glViewport(0, 0, surfaceWidthHalf, surfaceHeight);
        this.mScene.onDraw(pGL, firstCamera);
        firstCamera.onDrawHUD(pGL);
        pGL.glScissor(surfaceWidthHalf, 0, surfaceWidthHalf, surfaceHeight);
        pGL.glViewport(surfaceWidthHalf, 0, surfaceWidthHalf, surfaceHeight);
        this.mScene.onDraw(pGL, secondCamera);
        secondCamera.onDrawHUD(pGL);
        GLHelper.disableScissorTest(pGL);
    }

    protected Camera getCameraFromSurfaceTouchEvent(TouchEvent pTouchEvent) {
        if (pTouchEvent.getX() <= ((float) (this.mSurfaceWidth >> 1))) {
            return getFirstCamera();
        }
        return getSecondCamera();
    }

    protected void convertSurfaceToSceneTouchEvent(Camera pCamera, TouchEvent pSurfaceTouchEvent) {
        int surfaceWidthHalf = this.mSurfaceWidth >> 1;
        if (pCamera == getFirstCamera()) {
            pCamera.convertSurfaceToSceneTouchEvent(pSurfaceTouchEvent, surfaceWidthHalf, this.mSurfaceHeight);
            return;
        }
        pSurfaceTouchEvent.offset((float) (-surfaceWidthHalf), 0.0f);
        pCamera.convertSurfaceToSceneTouchEvent(pSurfaceTouchEvent, surfaceWidthHalf, this.mSurfaceHeight);
    }

    protected void updateUpdateHandlers(float pSecondsElapsed) {
        super.updateUpdateHandlers(pSecondsElapsed);
        getSecondCamera().onUpdate(pSecondsElapsed);
    }

    protected void onUpdateCameraSurface() {
        int surfaceWidthHalf = this.mSurfaceWidth >> 1;
        getFirstCamera().setSurfaceSize(0, 0, surfaceWidthHalf, this.mSurfaceHeight);
        getSecondCamera().setSurfaceSize(surfaceWidthHalf, 0, surfaceWidthHalf, this.mSurfaceHeight);
    }
}
