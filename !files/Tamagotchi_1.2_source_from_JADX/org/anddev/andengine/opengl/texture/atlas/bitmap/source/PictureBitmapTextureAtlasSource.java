package org.anddev.andengine.opengl.texture.atlas.bitmap.source;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Picture;
import org.anddev.andengine.opengl.texture.source.BaseTextureAtlasSource;
import org.anddev.andengine.util.Debug;

public abstract class PictureBitmapTextureAtlasSource extends BaseTextureAtlasSource implements IBitmapTextureAtlasSource {
    protected final int mHeight;
    protected final Picture mPicture;
    protected final int mWidth;

    public abstract PictureBitmapTextureAtlasSource deepCopy();

    public PictureBitmapTextureAtlasSource(Picture pPicture) {
        this(pPicture, 0, 0);
    }

    public PictureBitmapTextureAtlasSource(Picture pPicture, int pTexturePositionX, int pTexturePositionY) {
        this(pPicture, pTexturePositionX, pTexturePositionY, pPicture.getWidth(), pPicture.getHeight());
    }

    public PictureBitmapTextureAtlasSource(Picture pPicture, int pTexturePositionX, int pTexturePositionY, float pScale) {
        this(pPicture, pTexturePositionX, pTexturePositionY, Math.round(((float) pPicture.getWidth()) * pScale), Math.round(((float) pPicture.getHeight()) * pScale));
    }

    public PictureBitmapTextureAtlasSource(Picture pPicture, int pTexturePositionX, int pTexturePositionY, int pWidth, int pHeight) {
        super(pTexturePositionX, pTexturePositionY);
        this.mPicture = pPicture;
        this.mWidth = pWidth;
        this.mHeight = pHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Bitmap onLoadBitmap(Config pBitmapConfig) {
        Picture picture = this.mPicture;
        if (picture == null) {
            Debug.m61e("Failed loading Bitmap in PictureBitmapTextureAtlasSource.");
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, pBitmapConfig);
        Canvas canvas = new Canvas(bitmap);
        canvas.scale(((float) this.mWidth) / ((float) this.mPicture.getWidth()), ((float) this.mHeight) / ((float) this.mPicture.getHeight()), 0.0f, 0.0f);
        picture.draw(canvas);
        return bitmap;
    }
}
