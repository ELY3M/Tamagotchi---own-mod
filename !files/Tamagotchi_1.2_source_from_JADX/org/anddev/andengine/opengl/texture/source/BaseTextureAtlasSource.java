package org.anddev.andengine.opengl.texture.source;

public abstract class BaseTextureAtlasSource implements ITextureAtlasSource {
    protected int mTexturePositionX;
    protected int mTexturePositionY;

    public BaseTextureAtlasSource(int pTexturePositionX, int pTexturePositionY) {
        this.mTexturePositionX = pTexturePositionX;
        this.mTexturePositionY = pTexturePositionY;
    }

    public int getTexturePositionX() {
        return this.mTexturePositionX;
    }

    public int getTexturePositionY() {
        return this.mTexturePositionY;
    }

    public void setTexturePositionX(int pTexturePositionX) {
        this.mTexturePositionX = pTexturePositionX;
    }

    public void setTexturePositionY(int pTexturePositionY) {
        this.mTexturePositionY = pTexturePositionY;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getSimpleName())).append("( ").append(getWidth()).append("x").append(getHeight()).append(" @ ").append(this.mTexturePositionX).append("/").append(this.mTexturePositionY).append(" )").toString();
    }
}
