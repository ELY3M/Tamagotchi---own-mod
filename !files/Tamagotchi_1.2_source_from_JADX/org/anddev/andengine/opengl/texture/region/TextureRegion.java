package org.anddev.andengine.opengl.texture.region;

import org.anddev.andengine.opengl.texture.ITexture;

public class TextureRegion extends BaseTextureRegion {
    public TextureRegion(ITexture pTexture, int pTexturePositionX, int pTexturePositionY, int pWidth, int pHeight) {
        super(pTexture, pTexturePositionX, pTexturePositionY, pWidth, pHeight);
    }

    public TextureRegion deepCopy() {
        return new TextureRegion(this.mTexture, this.mTexturePositionX, this.mTexturePositionY, this.mWidth, this.mHeight);
    }

    public float getTextureCoordinateX1() {
        return ((float) this.mTexturePositionX) / ((float) this.mTexture.getWidth());
    }

    public float getTextureCoordinateY1() {
        return ((float) this.mTexturePositionY) / ((float) this.mTexture.getHeight());
    }

    public float getTextureCoordinateX2() {
        return ((float) (this.mTexturePositionX + this.mWidth)) / ((float) this.mTexture.getWidth());
    }

    public float getTextureCoordinateY2() {
        return ((float) (this.mTexturePositionY + this.mHeight)) / ((float) this.mTexture.getHeight());
    }
}
