package org.anddev.andengine.opengl.texture.atlas.bitmap.source;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import org.anddev.andengine.opengl.texture.source.BaseTextureAtlasSource;

public class ResourceBitmapTextureAtlasSource extends BaseTextureAtlasSource implements IBitmapTextureAtlasSource {
    private final Context mContext;
    private final int mDrawableResourceID;
    private final int mHeight;
    private final int mWidth;

    public ResourceBitmapTextureAtlasSource(Context pContext, int pDrawableResourceID) {
        this(pContext, pDrawableResourceID, 0, 0);
    }

    public ResourceBitmapTextureAtlasSource(Context pContext, int pDrawableResourceID, int pTexturePositionX, int pTexturePositionY) {
        super(pTexturePositionX, pTexturePositionY);
        this.mContext = pContext;
        this.mDrawableResourceID = pDrawableResourceID;
        Options decodeOptions = new Options();
        decodeOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(pContext.getResources(), pDrawableResourceID, decodeOptions);
        this.mWidth = decodeOptions.outWidth;
        this.mHeight = decodeOptions.outHeight;
    }

    protected ResourceBitmapTextureAtlasSource(Context pContext, int pDrawableResourceID, int pTexturePositionX, int pTexturePositionY, int pWidth, int pHeight) {
        super(pTexturePositionX, pTexturePositionY);
        this.mContext = pContext;
        this.mDrawableResourceID = pDrawableResourceID;
        this.mWidth = pWidth;
        this.mHeight = pHeight;
    }

    public ResourceBitmapTextureAtlasSource deepCopy() {
        return new ResourceBitmapTextureAtlasSource(this.mContext, this.mDrawableResourceID, this.mTexturePositionX, this.mTexturePositionY, this.mWidth, this.mHeight);
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Bitmap onLoadBitmap(Config pBitmapConfig) {
        Options decodeOptions = new Options();
        decodeOptions.inPreferredConfig = pBitmapConfig;
        return BitmapFactory.decodeResource(this.mContext.getResources(), this.mDrawableResourceID, decodeOptions);
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getSimpleName())).append("(").append(this.mDrawableResourceID).append(")").toString();
    }
}
