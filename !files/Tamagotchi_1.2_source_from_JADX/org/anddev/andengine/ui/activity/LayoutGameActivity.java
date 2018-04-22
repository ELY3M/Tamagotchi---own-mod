package org.anddev.andengine.ui.activity;

import org.anddev.andengine.opengl.view.RenderSurfaceView;

public abstract class LayoutGameActivity extends BaseGameActivity {
    protected abstract int getLayoutID();

    protected abstract int getRenderSurfaceViewID();

    protected void onSetContentView() {
        super.setContentView(getLayoutID());
        this.mRenderSurfaceView = (RenderSurfaceView) findViewById(getRenderSurfaceViewID());
        this.mRenderSurfaceView.setEGLConfigChooser(false);
        this.mRenderSurfaceView.setRenderer(this.mEngine);
    }
}
