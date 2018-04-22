package org.anddev.andengine.extension.svg.adt;

import android.graphics.Picture;
import android.graphics.RectF;

public class SVG {
    private final RectF mBounds;
    private final RectF mComputedBounds;
    private final Picture mPicture;

    public SVG(Picture pPicture, RectF pBounds, RectF pComputedBounds) {
        this.mPicture = pPicture;
        this.mBounds = pBounds;
        this.mComputedBounds = pComputedBounds;
    }

    public Picture getPicture() {
        return this.mPicture;
    }

    public RectF getBounds() {
        return this.mBounds;
    }

    public RectF getComputedBounds() {
        return this.mComputedBounds;
    }
}
