package org.anddev.andengine.entity.scene;

import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.shape.Shape;
import org.anddev.andengine.input.touch.TouchEvent;

public class CameraScene extends Scene {
    protected Camera mCamera;

    public CameraScene() {
        this(null);
    }

    public CameraScene(Camera pCamera) {
        this.mCamera = pCamera;
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public void setCamera(Camera pCamera) {
        this.mCamera = pCamera;
    }

    public boolean onSceneTouchEvent(TouchEvent pSceneTouchEvent) {
        if (this.mCamera == null) {
            return false;
        }
        this.mCamera.convertSceneToCameraSceneTouchEvent(pSceneTouchEvent);
        if (super.onSceneTouchEvent(pSceneTouchEvent)) {
            return true;
        }
        this.mCamera.convertCameraSceneToSceneTouchEvent(pSceneTouchEvent);
        return false;
    }

    protected boolean onChildSceneTouchEvent(TouchEvent pSceneTouchEvent) {
        if (!(this.mChildScene instanceof CameraScene)) {
            return super.onChildSceneTouchEvent(pSceneTouchEvent);
        }
        this.mCamera.convertCameraSceneToSceneTouchEvent(pSceneTouchEvent);
        boolean result = super.onChildSceneTouchEvent(pSceneTouchEvent);
        this.mCamera.convertSceneToCameraSceneTouchEvent(pSceneTouchEvent);
        return result;
    }

    protected void onManagedDraw(GL10 pGL, Camera pCamera) {
        if (this.mCamera != null) {
            pGL.glMatrixMode(5889);
            this.mCamera.onApplyCameraSceneMatrix(pGL);
            pGL.glMatrixMode(5888);
            pGL.glPushMatrix();
            pGL.glLoadIdentity();
            super.onManagedDraw(pGL, pCamera);
            pGL.glPopMatrix();
            pGL.glMatrixMode(5889);
        }
    }

    public void centerShapeInCamera(Shape pShape) {
        Camera camera = this.mCamera;
        pShape.setPosition((camera.getWidth() - pShape.getWidth()) * 0.5f, (camera.getHeight() - pShape.getHeight()) * 0.5f);
    }

    public void centerShapeInCameraHorizontally(Shape pShape) {
        pShape.setPosition((this.mCamera.getWidth() - pShape.getWidth()) * 0.5f, pShape.getY());
    }

    public void centerShapeInCameraVertically(Shape pShape) {
        pShape.setPosition(pShape.getX(), (this.mCamera.getHeight() - pShape.getHeight()) * 0.5f);
    }
}
