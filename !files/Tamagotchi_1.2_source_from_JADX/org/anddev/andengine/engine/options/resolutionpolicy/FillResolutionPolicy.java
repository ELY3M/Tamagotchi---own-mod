package org.anddev.andengine.engine.options.resolutionpolicy;

import android.view.View.MeasureSpec;
import org.anddev.andengine.opengl.view.RenderSurfaceView;

public class FillResolutionPolicy extends BaseResolutionPolicy {
    public void onMeasure(RenderSurfaceView pRenderSurfaceView, int pWidthMeasureSpec, int pHeightMeasureSpec) {
        BaseResolutionPolicy.throwOnNotMeasureSpecEXACTLY(pWidthMeasureSpec, pHeightMeasureSpec);
        pRenderSurfaceView.setMeasuredDimensionProxy(MeasureSpec.getSize(pWidthMeasureSpec), MeasureSpec.getSize(pHeightMeasureSpec));
    }
}
