package org.anddev.andengine.engine.camera;

public class SmoothCamera extends ZoomCamera {
    private float mMaxVelocityX;
    private float mMaxVelocityY;
    private float mMaxZoomFactorChange;
    private float mTargetCenterX = getCenterX();
    private float mTargetCenterY = getCenterY();
    private float mTargetZoomFactor = 1.0f;

    public SmoothCamera(float pX, float pY, float pWidth, float pHeight, float pMaxVelocityX, float pMaxVelocityY, float pMaxZoomFactorChange) {
        super(pX, pY, pWidth, pHeight);
        this.mMaxVelocityX = pMaxVelocityX;
        this.mMaxVelocityY = pMaxVelocityY;
        this.mMaxZoomFactorChange = pMaxZoomFactorChange;
    }

    public void setCenter(float pCenterX, float pCenterY) {
        this.mTargetCenterX = pCenterX;
        this.mTargetCenterY = pCenterY;
    }

    public void setCenterDirect(float pCenterX, float pCenterY) {
        super.setCenter(pCenterX, pCenterY);
        this.mTargetCenterX = pCenterX;
        this.mTargetCenterY = pCenterY;
    }

    public void setZoomFactor(float pZoomFactor) {
        if (this.mTargetZoomFactor == pZoomFactor) {
            return;
        }
        if (this.mTargetZoomFactor == this.mZoomFactor) {
            this.mTargetZoomFactor = pZoomFactor;
            onSmoothZoomStarted();
            return;
        }
        this.mTargetZoomFactor = pZoomFactor;
    }

    public void setZoomFactorDirect(float pZoomFactor) {
        if (this.mTargetZoomFactor != this.mZoomFactor) {
            this.mTargetZoomFactor = pZoomFactor;
            super.setZoomFactor(pZoomFactor);
            onSmoothZoomFinished();
            return;
        }
        this.mTargetZoomFactor = pZoomFactor;
        super.setZoomFactor(pZoomFactor);
    }

    public void setMaxVelocityX(float pMaxVelocityX) {
        this.mMaxVelocityX = pMaxVelocityX;
    }

    public void setMaxVelocityY(float pMaxVelocityY) {
        this.mMaxVelocityY = pMaxVelocityY;
    }

    public void setMaxVelocity(float pMaxVelocityX, float pMaxVelocityY) {
        this.mMaxVelocityX = pMaxVelocityX;
        this.mMaxVelocityY = pMaxVelocityY;
    }

    public void setMaxZoomFactorChange(float pMaxZoomFactorChange) {
        this.mMaxZoomFactorChange = pMaxZoomFactorChange;
    }

    protected void onSmoothZoomStarted() {
    }

    protected void onSmoothZoomFinished() {
    }

    public void onUpdate(float pSecondsElapsed) {
        super.onUpdate(pSecondsElapsed);
        float currentCenterX = getCenterX();
        float currentCenterY = getCenterY();
        float targetCenterX = this.mTargetCenterX;
        float targetCenterY = this.mTargetCenterY;
        if (!(currentCenterX == targetCenterX && currentCenterY == targetCenterY)) {
            super.setCenter(currentCenterX + limitToMaxVelocityX(targetCenterX - currentCenterX, pSecondsElapsed), currentCenterY + limitToMaxVelocityY(targetCenterY - currentCenterY, pSecondsElapsed));
        }
        float currentZoom = getZoomFactor();
        float targetZoomFactor = this.mTargetZoomFactor;
        if (currentZoom != targetZoomFactor) {
            super.setZoomFactor(currentZoom + limitToMaxZoomFactorChange(targetZoomFactor - currentZoom, pSecondsElapsed));
            if (this.mZoomFactor == this.mTargetZoomFactor) {
                onSmoothZoomFinished();
            }
        }
    }

    private float limitToMaxVelocityX(float pValue, float pSecondsElapsed) {
        if (pValue > 0.0f) {
            return Math.min(pValue, this.mMaxVelocityX * pSecondsElapsed);
        }
        return Math.max(pValue, (-this.mMaxVelocityX) * pSecondsElapsed);
    }

    private float limitToMaxVelocityY(float pValue, float pSecondsElapsed) {
        if (pValue > 0.0f) {
            return Math.min(pValue, this.mMaxVelocityY * pSecondsElapsed);
        }
        return Math.max(pValue, (-this.mMaxVelocityY) * pSecondsElapsed);
    }

    private float limitToMaxZoomFactorChange(float pValue, float pSecondsElapsed) {
        if (pValue > 0.0f) {
            return Math.min(pValue, this.mMaxZoomFactorChange * pSecondsElapsed);
        }
        return Math.max(pValue, (-this.mMaxZoomFactorChange) * pSecondsElapsed);
    }
}
