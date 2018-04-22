package org.anddev.andengine.extension.augmentedreality;

import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import org.anddev.andengine.opengl.view.ComponentSizeChooser;
import org.anddev.andengine.opengl.view.RenderSurfaceView;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public abstract class BaseAugmentedRealityGameActivity extends BaseGameActivity {
    private CameraPreviewSurfaceView mCameraPreviewSurfaceView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mCameraPreviewSurfaceView = new CameraPreviewSurfaceView(this);
        addContentView(this.mCameraPreviewSurfaceView, new LayoutParams(-2, -2));
        this.mRenderSurfaceView.bringToFront();
    }

    protected void onSetContentView() {
        this.mRenderSurfaceView = new RenderSurfaceView(this);
        this.mRenderSurfaceView.setEGLConfigChooser(new ComponentSizeChooser(4, 4, 4, 4, 16, 0));
        this.mRenderSurfaceView.getHolder().setFormat(-3);
        this.mRenderSurfaceView.setRenderer(this.mEngine);
        setContentView(this.mRenderSurfaceView, createSurfaceViewLayoutParams());
    }

    protected void onPause() {
        super.onPause();
    }
}
