package org.anddev.andengine.entity.scene.background;

import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.util.constants.ColorConstants;

public class ColorBackground extends BaseBackground {
    private float mAlpha = 1.0f;
    private float mBlue = 0.0f;
    private boolean mColorEnabled = true;
    private float mGreen = 0.0f;
    private float mRed = 0.0f;

    protected ColorBackground() {
    }

    public ColorBackground(float pRed, float pGreen, float pBlue) {
        this.mRed = pRed;
        this.mGreen = pGreen;
        this.mBlue = pBlue;
    }

    public ColorBackground(float pRed, float pGreen, float pBlue, float pAlpha) {
        this.mRed = pRed;
        this.mGreen = pGreen;
        this.mBlue = pBlue;
        this.mAlpha = pAlpha;
    }

    public void setColor(float pRed, float pGreen, float pBlue) {
        this.mRed = pRed;
        this.mGreen = pGreen;
        this.mBlue = pBlue;
    }

    public void setColor(float pRed, float pGreen, float pBlue, float pAlpha) {
        setColor(pRed, pGreen, pBlue);
        this.mAlpha = pAlpha;
    }

    public void setColor(int pRed, int pGreen, int pBlue) throws IllegalArgumentException {
        setColor(((float) pRed) / ColorConstants.COLOR_FACTOR_INT_TO_FLOAT, ((float) pGreen) / ColorConstants.COLOR_FACTOR_INT_TO_FLOAT, ((float) pBlue) / ColorConstants.COLOR_FACTOR_INT_TO_FLOAT);
    }

    public void setColor(int pRed, int pGreen, int pBlue, int pAlpha) throws IllegalArgumentException {
        setColor(((float) pRed) / ColorConstants.COLOR_FACTOR_INT_TO_FLOAT, ((float) pGreen) / ColorConstants.COLOR_FACTOR_INT_TO_FLOAT, ((float) pBlue) / ColorConstants.COLOR_FACTOR_INT_TO_FLOAT, ((float) pAlpha) / ColorConstants.COLOR_FACTOR_INT_TO_FLOAT);
    }

    public void setColorEnabled(boolean pColorEnabled) {
        this.mColorEnabled = pColorEnabled;
    }

    public boolean isColorEnabled() {
        return this.mColorEnabled;
    }

    public void onDraw(GL10 pGL, Camera pCamera) {
        if (this.mColorEnabled) {
            pGL.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
            pGL.glClear(16384);
        }
    }
}
