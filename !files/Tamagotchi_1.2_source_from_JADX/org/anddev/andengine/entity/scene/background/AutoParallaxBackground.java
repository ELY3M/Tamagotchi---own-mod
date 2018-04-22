package org.anddev.andengine.entity.scene.background;

public class AutoParallaxBackground extends ParallaxBackground {
    private float mParallaxChangePerSecond;

    public AutoParallaxBackground(float pRed, float pGreen, float pBlue, float pParallaxChangePerSecond) {
        super(pRed, pGreen, pBlue);
        this.mParallaxChangePerSecond = pParallaxChangePerSecond;
    }

    public void setParallaxChangePerSecond(float pParallaxChangePerSecond) {
        this.mParallaxChangePerSecond = pParallaxChangePerSecond;
    }

    public void onUpdate(float pSecondsElapsed) {
        super.onUpdate(pSecondsElapsed);
        this.mParallaxValue += this.mParallaxChangePerSecond * pSecondsElapsed;
    }
}
