package org.anddev.andengine.engine.options.resolutionpolicy;

import android.view.View.MeasureSpec;

public abstract class BaseResolutionPolicy implements IResolutionPolicy {
    protected static void throwOnNotMeasureSpecEXACTLY(int pWidthMeasureSpec, int pHeightMeasureSpec) {
        int specWidthMode = MeasureSpec.getMode(pWidthMeasureSpec);
        int specHeightMode = MeasureSpec.getMode(pHeightMeasureSpec);
        if (specWidthMode != 1073741824 || specHeightMode != 1073741824) {
            throw new IllegalStateException("This IResolutionPolicy requires MeasureSpec.EXACTLY ! That means ");
        }
    }
}
