package org.anddev.andengine.extension.augmentedreality;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.io.IOException;
import org.anddev.andengine.util.Debug;

class CameraPreviewSurfaceView extends SurfaceView implements Callback {
    private Camera mCamera;
    private final SurfaceHolder mSurfaceHolder = getHolder();

    public CameraPreviewSurfaceView(Context pContext) {
        super(pContext);
        this.mSurfaceHolder.addCallback(this);
        this.mSurfaceHolder.setType(3);
    }

    public void surfaceCreated(SurfaceHolder pSurfaceHolder) {
        this.mCamera = Camera.open();
        try {
            this.mCamera.setPreviewDisplay(pSurfaceHolder);
        } catch (IOException e) {
            Debug.m62e("Error in Camera.setPreviewDisplay", e);
        }
    }

    public void surfaceDestroyed(SurfaceHolder pSurfaceHolder) {
        this.mCamera.stopPreview();
        this.mCamera.release();
        this.mCamera = null;
    }

    public void surfaceChanged(SurfaceHolder pSurfaceHolder, int pPixelFormat, int pWidth, int pHeight) {
        Parameters parameters = this.mCamera.getParameters();
        parameters.setPreviewSize(pWidth, pHeight);
        this.mCamera.setParameters(parameters);
        this.mCamera.startPreview();
    }
}
