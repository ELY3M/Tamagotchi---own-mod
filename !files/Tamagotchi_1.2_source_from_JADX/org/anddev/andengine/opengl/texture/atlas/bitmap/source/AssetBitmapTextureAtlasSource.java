package org.anddev.andengine.opengl.texture.atlas.bitmap.source;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.IOException;
import java.io.InputStream;
import org.anddev.andengine.opengl.texture.source.BaseTextureAtlasSource;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.StreamUtils;

public class AssetBitmapTextureAtlasSource extends BaseTextureAtlasSource implements IBitmapTextureAtlasSource {
    private final String mAssetPath;
    private final Context mContext;
    private final int mHeight;
    private final int mWidth;

    public AssetBitmapTextureAtlasSource(Context pContext, String pAssetPath) {
        this(pContext, pAssetPath, 0, 0);
    }

    public AssetBitmapTextureAtlasSource(Context pContext, String pAssetPath, int pTexturePositionX, int pTexturePositionY) {
        super(pTexturePositionX, pTexturePositionY);
        this.mContext = pContext;
        this.mAssetPath = pAssetPath;
        Options decodeOptions = new Options();
        decodeOptions.inJustDecodeBounds = true;
        InputStream in = null;
        try {
            in = pContext.getAssets().open(pAssetPath);
            BitmapFactory.decodeStream(in, null, decodeOptions);
        } catch (IOException e) {
            Debug.m62e("Failed loading Bitmap in AssetBitmapTextureAtlasSource. AssetPath: " + pAssetPath, e);
        } finally {
            StreamUtils.close(in);
        }
        this.mWidth = decodeOptions.outWidth;
        this.mHeight = decodeOptions.outHeight;
    }

    AssetBitmapTextureAtlasSource(Context pContext, String pAssetPath, int pTexturePositionX, int pTexturePositionY, int pWidth, int pHeight) {
        super(pTexturePositionX, pTexturePositionY);
        this.mContext = pContext;
        this.mAssetPath = pAssetPath;
        this.mWidth = pWidth;
        this.mHeight = pHeight;
    }

    public AssetBitmapTextureAtlasSource deepCopy() {
        return new AssetBitmapTextureAtlasSource(this.mContext, this.mAssetPath, this.mTexturePositionX, this.mTexturePositionY, this.mWidth, this.mHeight);
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Bitmap onLoadBitmap(Config pBitmapConfig) {
        Bitmap bitmap = null;
        InputStream in = null;
        try {
            Options decodeOptions = new Options();
            decodeOptions.inPreferredConfig = pBitmapConfig;
            in = this.mContext.getAssets().open(this.mAssetPath);
            bitmap = BitmapFactory.decodeStream(in, null, decodeOptions);
        } catch (IOException e) {
            Debug.m62e("Failed loading Bitmap in " + getClass().getSimpleName() + ". AssetPath: " + this.mAssetPath, e);
        } finally {
            StreamUtils.close(in);
        }
        return bitmap;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getSimpleName())).append("(").append(this.mAssetPath).append(")").toString();
    }
}
