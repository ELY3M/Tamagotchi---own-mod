package org.anddev.andengine.opengl.texture.atlas.bitmap.source;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.anddev.andengine.opengl.texture.source.BaseTextureAtlasSource;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.StreamUtils;

public class FileBitmapTextureAtlasSource extends BaseTextureAtlasSource implements IBitmapTextureAtlasSource {
    private final File mFile;
    private final int mHeight;
    private final int mWidth;

    public FileBitmapTextureAtlasSource(File pFile) {
        this(pFile, 0, 0);
    }

    public FileBitmapTextureAtlasSource(File pFile, int pTexturePositionX, int pTexturePositionY) {
        IOException e;
        Throwable th;
        super(pTexturePositionX, pTexturePositionY);
        this.mFile = pFile;
        Options decodeOptions = new Options();
        decodeOptions.inJustDecodeBounds = true;
        InputStream in = null;
        try {
            InputStream in2 = new FileInputStream(pFile);
            try {
                BitmapFactory.decodeStream(in2, null, decodeOptions);
                StreamUtils.close(in2);
                in = in2;
            } catch (IOException e2) {
                e = e2;
                in = in2;
                try {
                    Debug.m62e("Failed loading Bitmap in FileBitmapTextureAtlasSource. File: " + pFile, e);
                    StreamUtils.close(in);
                    this.mWidth = decodeOptions.outWidth;
                    this.mHeight = decodeOptions.outHeight;
                } catch (Throwable th2) {
                    th = th2;
                    StreamUtils.close(in);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                in = in2;
                StreamUtils.close(in);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            Debug.m62e("Failed loading Bitmap in FileBitmapTextureAtlasSource. File: " + pFile, e);
            StreamUtils.close(in);
            this.mWidth = decodeOptions.outWidth;
            this.mHeight = decodeOptions.outHeight;
        }
        this.mWidth = decodeOptions.outWidth;
        this.mHeight = decodeOptions.outHeight;
    }

    FileBitmapTextureAtlasSource(File pFile, int pTexturePositionX, int pTexturePositionY, int pWidth, int pHeight) {
        super(pTexturePositionX, pTexturePositionY);
        this.mFile = pFile;
        this.mWidth = pWidth;
        this.mHeight = pHeight;
    }

    public FileBitmapTextureAtlasSource deepCopy() {
        return new FileBitmapTextureAtlasSource(this.mFile, this.mTexturePositionX, this.mTexturePositionY, this.mWidth, this.mHeight);
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Bitmap onLoadBitmap(Config pBitmapConfig) {
        IOException e;
        Throwable th;
        Bitmap bitmap = null;
        Options decodeOptions = new Options();
        decodeOptions.inPreferredConfig = pBitmapConfig;
        InputStream in = null;
        try {
            InputStream in2 = new FileInputStream(this.mFile);
            try {
                bitmap = BitmapFactory.decodeStream(in2, null, decodeOptions);
                StreamUtils.close(in2);
                in = in2;
            } catch (IOException e2) {
                e = e2;
                in = in2;
                try {
                    Debug.m62e("Failed loading Bitmap in " + getClass().getSimpleName() + ". File: " + this.mFile, e);
                    StreamUtils.close(in);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    StreamUtils.close(in);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                in = in2;
                StreamUtils.close(in);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            Debug.m62e("Failed loading Bitmap in " + getClass().getSimpleName() + ". File: " + this.mFile, e);
            StreamUtils.close(in);
            return bitmap;
        }
        return bitmap;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getSimpleName())).append("(").append(this.mFile).append(")").toString();
    }
}
