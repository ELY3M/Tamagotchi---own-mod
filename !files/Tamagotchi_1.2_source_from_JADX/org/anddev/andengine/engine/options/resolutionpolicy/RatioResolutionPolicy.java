package org.anddev.andengine.engine.options.resolutionpolicy;

import android.view.View.MeasureSpec;
import org.anddev.andengine.opengl.view.RenderSurfaceView;

public class RatioResolutionPolicy extends BaseResolutionPolicy {
    private final float mRatio;

    public RatioResolutionPolicy(float pRatio) {
        this.mRatio = pRatio;
    }

    public RatioResolutionPolicy(float pWidthRatio, float pHeightRatio) {
        this.mRatio = pWidthRatio / pHeightRatio;
    }

    public void onMeasure(RenderSurfaceView pRenderSurfaceView, int pWidthMeasureSpec, int pHeightMeasureSpec) {
        int measuredWidth;
        int measuredHeight;
        BaseResolutionPolicy.throwOnNotMeasureSpecEXACTLY(pWidthMeasureSpec, pHeightMeasureSpec);
        int specWidth = MeasureSpec.getSize(pWidthMeasureSpec);
        int specHeight = MeasureSpec.getSize(pHeightMeasureSpec);
        float desiredRatio = this.mRatio;
        if (((float) specWidth) / ((float) specHeight) < desiredRatio) {
            measuredWidth = specWidth;
            measuredHeight = Math.round(((float) measuredWidth) / desiredRatio);
        } else {
            measuredHeight = specHeight;
            measuredWidth = Math.round(((float) measuredHeight) * desiredRatio);
        }
        pRenderSurfaceView.setMeasuredDimensionProxy(measuredWidth, measuredHeight);
    }
}
