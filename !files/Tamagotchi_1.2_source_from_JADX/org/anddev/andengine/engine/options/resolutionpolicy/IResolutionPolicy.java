package org.anddev.andengine.engine.options.resolutionpolicy;

import org.anddev.andengine.opengl.view.RenderSurfaceView;

public interface IResolutionPolicy {
    void onMeasure(RenderSurfaceView renderSurfaceView, int i, int i2);
}
