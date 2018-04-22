package org.anddev.andengine.opengl.texture.atlas.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLUtils;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.opengl.texture.Texture.PixelFormat;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.ITextureAtlas.ITextureAtlasStateListener;
import org.anddev.andengine.opengl.texture.atlas.TextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.bitmap.BitmapTexture.BitmapTextureFormat;
import org.anddev.andengine.opengl.util.GLHelper;
import org.anddev.andengine.util.Debug;

public class BitmapTextureAtlas extends TextureAtlas<IBitmapTextureAtlasSource> {
    private final BitmapTextureFormat mBitmapTextureFormat;

    public BitmapTextureAtlas(int pWidth, int pHeight) {
        this(pWidth, pHeight, BitmapTextureFormat.RGBA_8888);
    }

    public BitmapTextureAtlas(int pWidth, int pHeight, BitmapTextureFormat pBitmapTextureFormat) {
        this(pWidth, pHeight, pBitmapTextureFormat, TextureOptions.DEFAULT, null);
    }

    public BitmapTextureAtlas(int pWidth, int pHeight, ITextureAtlasStateListener<IBitmapTextureAtlasSource> pTextureAtlasStateListener) {
        this(pWidth, pHeight, BitmapTextureFormat.RGBA_8888, TextureOptions.DEFAULT, pTextureAtlasStateListener);
    }

    public BitmapTextureAtlas(int pWidth, int pHeight, BitmapTextureFormat pBitmapTextureFormat, ITextureAtlasStateListener<IBitmapTextureAtlasSource> pTextureAtlasStateListener) {
        this(pWidth, pHeight, pBitmapTextureFormat, TextureOptions.DEFAULT, pTextureAtlasStateListener);
    }

    public BitmapTextureAtlas(int pWidth, int pHeight, TextureOptions pTextureOptions) throws IllegalArgumentException {
        this(pWidth, pHeight, BitmapTextureFormat.RGBA_8888, pTextureOptions, null);
    }

    public BitmapTextureAtlas(int pWidth, int pHeight, BitmapTextureFormat pBitmapTextureFormat, TextureOptions pTextureOptions) throws IllegalArgumentException {
        this(pWidth, pHeight, pBitmapTextureFormat, pTextureOptions, null);
    }

    public BitmapTextureAtlas(int pWidth, int pHeight, TextureOptions pTextureOptions, ITextureAtlasStateListener<IBitmapTextureAtlasSource> pTextureAtlasStateListener) throws IllegalArgumentException {
        this(pWidth, pHeight, BitmapTextureFormat.RGBA_8888, pTextureOptions, pTextureAtlasStateListener);
    }

    public BitmapTextureAtlas(int pWidth, int pHeight, BitmapTextureFormat pBitmapTextureFormat, TextureOptions pTextureOptions, ITextureAtlasStateListener<IBitmapTextureAtlasSource> pTextureAtlasStateListener) throws IllegalArgumentException {
        super(pWidth, pHeight, pBitmapTextureFormat.getPixelFormat(), pTextureOptions, pTextureAtlasStateListener);
        this.mBitmapTextureFormat = pBitmapTextureFormat;
    }

    public BitmapTextureFormat getBitmapTextureFormat() {
        return this.mBitmapTextureFormat;
    }

    protected void writeTextureToHardware(GL10 pGL) {
        int y;
        int x;
        Config bitmapConfig = this.mBitmapTextureFormat.getBitmapConfig();
        int glFormat = this.mPixelFormat.getGLFormat();
        int glType = this.mPixelFormat.getGLType();
        boolean preMultipyAlpha = this.mTextureOptions.mPreMultipyAlpha;
        ArrayList<IBitmapTextureAtlasSource> textureSources = this.mTextureAtlasSources;
        int textureSourceCount = textureSources.size();
        int[] blacklinesHackColors = new int[1024];
        for (y = 0; y < 32; y++) {
            for (x = 0; x < 32; x++) {
                blacklinesHackColors[(y * 32) + x] = 0;
            }
        }
        Bitmap blacklinesHackBitmap = Bitmap.createBitmap(blacklinesHackColors, 32, 32, bitmapConfig);
        if (blacklinesHackBitmap == null) {
            throw new IllegalArgumentException("Blacklines Hack: returned a null Bitmap.");
        }
        for (y = 0; y < this.mHeight; y += 32) {
            for (x = 0; x < this.mHeight; x += 32) {
                if (preMultipyAlpha) {
                    GLUtils.texSubImage2D(3553, 0, x, y, blacklinesHackBitmap, glFormat, glType);
                } else {
                    GLHelper.glTexSubImage2D(pGL, 3553, 0, x, y, blacklinesHackBitmap, this.mPixelFormat);
                }
            }
        }
        blacklinesHackBitmap.recycle();
        for (int j = 0; j < textureSourceCount; j++) {
            IBitmapTextureAtlasSource bitmapTextureAtlasSource = (IBitmapTextureAtlasSource) textureSources.get(j);
            if (bitmapTextureAtlasSource != null) {
                Bitmap bitmap = bitmapTextureAtlasSource.onLoadBitmap(bitmapConfig);
                if (bitmap == null) {
                    try {
                        throw new IllegalArgumentException(new StringBuilder(String.valueOf(bitmapTextureAtlasSource.getClass().getSimpleName())).append(": ").append(bitmapTextureAtlasSource.toString()).append(" returned a null Bitmap.").toString());
                    } catch (Throwable iae) {
                        Debug.m62e("Error loading: " + bitmapTextureAtlasSource.toString(), iae);
                        if (getTextureStateListener() != null) {
                            getTextureStateListener().onTextureAtlasSourceLoadExeption(this, bitmapTextureAtlasSource, iae);
                        } else {
                            throw iae;
                        }
                    }
                }
                if (preMultipyAlpha) {
                    GLUtils.texSubImage2D(3553, 0, bitmapTextureAtlasSource.getTexturePositionX(), bitmapTextureAtlasSource.getTexturePositionY(), bitmap, glFormat, glType);
                } else {
                    GLHelper.glTexSubImage2D(pGL, 3553, 0, bitmapTextureAtlasSource.getTexturePositionX(), bitmapTextureAtlasSource.getTexturePositionY(), bitmap, this.mPixelFormat);
                }
                bitmap.recycle();
            }
        }
    }

    protected void bindTextureOnHardware(GL10 pGL) {
        super.bindTextureOnHardware(pGL);
        PixelFormat pixelFormat = this.mBitmapTextureFormat.getPixelFormat();
        int glFormat = pixelFormat.getGLFormat();
        GL10 gl10 = pGL;
        gl10.glTexImage2D(3553, 0, glFormat, this.mWidth, this.mHeight, 0, glFormat, pixelFormat.getGLType(), null);
    }
}
