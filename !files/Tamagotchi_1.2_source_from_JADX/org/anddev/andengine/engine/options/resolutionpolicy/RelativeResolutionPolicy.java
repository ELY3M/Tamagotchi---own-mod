package org.anddev.andengine.engine.options.resolutionpolicy;

import android.view.View.MeasureSpec;
import org.anddev.andengine.opengl.view.RenderSurfaceView;

public class RelativeResolutionPolicy extends BaseResolutionPolicy {
    private final float mHeightScale;
    private final float mWidthScale;

    public RelativeResolutionPolicy(float pScale) {
        this(pScale, pScale);
    }

    public RelativeResolutionPolicy(float pWidthScale, float pHeightScale) {
        this.mWidthScale = pWidthScale;
        this.mHeightScale = pHeightScale;
    }

    public void onMeasure(RenderSurfaceView pRenderSurfaceView, int pWidthMeasureSpec, int pHeightMeasureSpec) {
        BaseResolutionPolicy.throwOnNotMeasureSpecEXACTLY(pWidthMeasureSpec, pHeightMeasureSpec);
        pRenderSurfaceView.setMeasuredDimensionProxy((int) (((float) MeasureSpec.getSize(pWidthMeasureSpec)) * this.mWidthScale), (int) (((float) MeasureSpec.getSize(pHeightMeasureSpec)) * this.mHeightScale));
    }
}
