package org.anddev.andengine.entity.text;

import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.util.HorizontalAlign;

public class TickerText extends Text {
    private float mCharactersPerSecond;
    private int mCharactersVisible = 0;
    private float mDuration;
    private boolean mReverse = false;
    private float mSecondsElapsed = 0.0f;

    public TickerText(float pX, float pY, Font pFont, String pText, HorizontalAlign pHorizontalAlign, float pCharactersPerSecond) {
        super(pX, pY, pFont, pText, pHorizontalAlign);
        setCharactersPerSecond(pCharactersPerSecond);
    }

    public boolean isReverse() {
        return this.mReverse;
    }

    public void setReverse(boolean pReverse) {
        this.mReverse = pReverse;
    }

    public float getCharactersPerSecond() {
        return this.mCharactersPerSecond;
    }

    public void setCharactersPerSecond(float pCharactersPerSecond) {
        this.mCharactersPerSecond = pCharactersPerSecond;
        this.mDuration = ((float) this.mCharactersMaximum) * this.mCharactersPerSecond;
    }

    public int getCharactersVisible() {
        return this.mCharactersVisible;
    }

    protected void onManagedUpdate(float pSecondsElapsed) {
        super.onManagedUpdate(pSecondsElapsed);
        if (this.mReverse) {
            if (this.mCharactersVisible < this.mCharactersMaximum) {
                this.mSecondsElapsed = Math.max(0.0f, this.mSecondsElapsed - pSecondsElapsed);
                this.mCharactersVisible = (int) (this.mSecondsElapsed * this.mCharactersPerSecond);
            }
        } else if (this.mCharactersVisible < this.mCharactersMaximum) {
            this.mSecondsElapsed = Math.min(this.mDuration, this.mSecondsElapsed + pSecondsElapsed);
            this.mCharactersVisible = (int) (this.mSecondsElapsed * this.mCharactersPerSecond);
        }
    }

    protected void drawVertices(GL10 pGL, Camera pCamera) {
        pGL.glDrawArrays(4, 0, this.mCharactersVisible * 6);
    }

    public void reset() {
        super.reset();
        this.mCharactersVisible = 0;
        this.mSecondsElapsed = 0.0f;
        this.mReverse = false;
    }
}
