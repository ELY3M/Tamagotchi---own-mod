package org.anddev.andengine.opengl.texture.atlas.bitmap.source;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import org.anddev.andengine.opengl.texture.source.BaseTextureAtlasSource;

public class EmptyBitmapTextureAtlasSource extends BaseTextureAtlasSource implements IBitmapTextureAtlasSource {
    private final int mHeight;
    private final int mWidth;

    public EmptyBitmapTextureAtlasSource(int pWidth, int pHeight) {
        this(0, 0, pWidth, pHeight);
    }

    public EmptyBitmapTextureAtlasSource(int pTexturePositionX, int pTexturePositionY, int pWidth, int pHeight) {
        super(pTexturePositionX, pTexturePositionY);
        this.mWidth = pWidth;
        this.mHeight = pHeight;
    }

    public EmptyBitmapTextureAtlasSource deepCopy() {
        return new EmptyBitmapTextureAtlasSource(this.mTexturePositionX, this.mTexturePositionY, this.mWidth, this.mHeight);
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Bitmap onLoadBitmap(Config pBitmapConfig) {
        return Bitmap.createBitmap(this.mWidth, this.mHeight, pBitmapConfig);
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getSimpleName())).append("(").append(this.mWidth).append(" x ").append(this.mHeight).append(")").toString();
    }
}
