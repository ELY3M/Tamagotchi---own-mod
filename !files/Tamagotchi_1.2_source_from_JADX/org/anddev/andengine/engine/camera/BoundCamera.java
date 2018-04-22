package org.anddev.andengine.engine.camera;

public class BoundCamera extends Camera {
    private float mBoundsCenterX;
    private float mBoundsCenterY;
    protected boolean mBoundsEnabled;
    private float mBoundsHeight;
    private float mBoundsMaxX;
    private float mBoundsMaxY;
    private float mBoundsMinX;
    private float mBoundsMinY;
    private float mBoundsWidth;

    public BoundCamera(float pX, float pY, float pWidth, float pHeight) {
        super(pX, pY, pWidth, pHeight);
    }

    public BoundCamera(float pX, float pY, float pWidth, float pHeight, float pBoundMinX, float pBoundMaxX, float pBoundMinY, float pBoundMaxY) {
        super(pX, pY, pWidth, pHeight);
        setBounds(pBoundMinX, pBoundMaxX, pBoundMinY, pBoundMaxY);
        this.mBoundsEnabled = true;
    }

    public boolean isBoundsEnabled() {
        return this.mBoundsEnabled;
    }

    public void setBoundsEnabled(boolean pBoundsEnabled) {
        this.mBoundsEnabled = pBoundsEnabled;
    }

    public void setBounds(float pBoundMinX, float pBoundMaxX, float pBoundMinY, float pBoundMaxY) {
        this.mBoundsMinX = pBoundMinX;
        this.mBoundsMaxX = pBoundMaxX;
        this.mBoundsMinY = pBoundMinY;
        this.mBoundsMaxY = pBoundMaxY;
        this.mBoundsWidth = this.mBoundsMaxX - this.mBoundsMinX;
        this.mBoundsHeight = this.mBoundsMaxY - this.mBoundsMinY;
        this.mBoundsCenterX = this.mBoundsMinX + (this.mBoundsWidth * 0.5f);
        this.mBoundsCenterY = this.mBoundsMinY + (this.mBoundsHeight * 0.5f);
    }

    public float getBoundsWidth() {
        return this.mBoundsWidth;
    }

    public float getBoundsHeight() {
        return this.mBoundsHeight;
    }

    public void setCenter(float pCenterX, float pCenterY) {
        super.setCenter(pCenterX, pCenterY);
        if (this.mBoundsEnabled) {
            ensureInBounds();
        }
    }

    protected void ensureInBounds() {
        super.setCenter(determineBoundedX(), determineBoundedY());
    }

    private float determineBoundedX() {
        if (this.mBoundsWidth < getWidth()) {
            return this.mBoundsCenterX;
        }
        boolean minXBoundExceeded;
        boolean maxXBoundExceeded;
        float currentCenterX = getCenterX();
        float minXBoundExceededAmount = this.mBoundsMinX - getMinX();
        if (minXBoundExceededAmount > 0.0f) {
            minXBoundExceeded = true;
        } else {
            minXBoundExceeded = false;
        }
        float maxXBoundExceededAmount = getMaxX() - this.mBoundsMaxX;
        if (maxXBoundExceededAmount > 0.0f) {
            maxXBoundExceeded = true;
        } else {
            maxXBoundExceeded = false;
        }
        if (minXBoundExceeded) {
            if (maxXBoundExceeded) {
                return (currentCenterX - maxXBoundExceededAmount) + minXBoundExceededAmount;
            }
            return currentCenterX + minXBoundExceededAmount;
        } else if (maxXBoundExceeded) {
            return currentCenterX - maxXBoundExceededAmount;
        } else {
            return currentCenterX;
        }
    }

    private float determineBoundedY() {
        if (this.mBoundsHeight < getHeight()) {
            return this.mBoundsCenterY;
        }
        boolean minYBoundExceeded;
        boolean maxYBoundExceeded;
        float currentCenterY = getCenterY();
        float minYBoundExceededAmount = this.mBoundsMinY - getMinY();
        if (minYBoundExceededAmount > 0.0f) {
            minYBoundExceeded = true;
        } else {
            minYBoundExceeded = false;
        }
        float maxYBoundExceededAmount = getMaxY() - this.mBoundsMaxY;
        if (maxYBoundExceededAmount > 0.0f) {
            maxYBoundExceeded = true;
        } else {
            maxYBoundExceeded = false;
        }
        if (minYBoundExceeded) {
            if (maxYBoundExceeded) {
                return (currentCenterY - maxYBoundExceededAmount) + minYBoundExceededAmount;
            }
            return currentCenterY + minYBoundExceededAmount;
        } else if (maxYBoundExceeded) {
            return currentCenterY - maxYBoundExceededAmount;
        } else {
            return currentCenterY;
        }
    }
}
