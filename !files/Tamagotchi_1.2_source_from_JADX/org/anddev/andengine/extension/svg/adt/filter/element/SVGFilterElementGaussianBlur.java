package org.anddev.andengine.extension.svg.adt.filter.element;

import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Paint;

public class SVGFilterElementGaussianBlur implements ISVGFilterElement {
    private final BlurMaskFilter mBlurMaskFilter;

    public SVGFilterElementGaussianBlur(float pStandardDeviation) {
        this.mBlurMaskFilter = new BlurMaskFilter(pStandardDeviation * 2.0f, Blur.NORMAL);
    }

    public void apply(Paint pPaint) {
        pPaint.setMaskFilter(this.mBlurMaskFilter);
    }
}
