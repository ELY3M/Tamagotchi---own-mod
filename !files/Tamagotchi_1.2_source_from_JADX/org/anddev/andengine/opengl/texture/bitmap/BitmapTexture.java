package org.anddev.andengine.opengl.texture.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.opengl.GLUtils;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.opengl.texture.ITexture.ITextureStateListener;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.Texture.PixelFormat;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.util.GLHelper;
import org.anddev.andengine.util.MathUtils;
import org.anddev.andengine.util.StreamUtils;

public abstract class BitmapTexture extends Texture {
    private final BitmapTextureFormat mBitmapTextureFormat;
    private final int mHeight;
    private final int mWidth;

    public enum BitmapTextureFormat {
        RGBA_8888(Config.ARGB_8888, PixelFormat.RGBA_8888),
        RGB_565(Config.RGB_565, PixelFormat.RGB_565),
        RGBA_4444(Config.ARGB_4444, PixelFormat.RGBA_4444),
        A_8(Config.ALPHA_8, PixelFormat.A_8);
        
        private final Config mBitmapConfig;
        private final PixelFormat mPixelFormat;

        private BitmapTextureFormat(Config pBitmapConfig, PixelFormat pPixelFormat) {
            this.mBitmapConfig = pBitmapConfig;
            this.mPixelFormat = pPixelFormat;
        }

        public static BitmapTextureFormat fromPixelFormat(PixelFormat pPixelFormat) {
            switch (m26xc82e07aa()[pPixelFormat.ordinal()]) {
                case 2:
                    return RGBA_4444;
                case 4:
                    return RGBA_8888;
                case 5:
                    return RGB_565;
                case 6:
                    return A_8;
                default:
                    throw new IllegalArgumentException("Unsupported " + PixelFormat.class.getName() + ": '" + pPixelFormat + "'.");
            }
        }

        public Config getBitmapConfig() {
            return this.mBitmapConfig;
        }

        public PixelFormat getPixelFormat() {
            return this.mPixelFormat;
        }
    }

    protected abstract InputStream onGetInputStream() throws IOException;

    public BitmapTexture() throws IOException {
        this(BitmapTextureFormat.RGBA_8888, TextureOptions.DEFAULT, null);
    }

    public BitmapTexture(BitmapTextureFormat pBitmapTextureFormat) throws IOException {
        this(pBitmapTextureFormat, TextureOptions.DEFAULT, null);
    }

    public BitmapTexture(TextureOptions pTextureOptions) throws IOException {
        this(BitmapTextureFormat.RGBA_8888, pTextureOptions, null);
    }

    public BitmapTexture(BitmapTextureFormat pBitmapTextureFormat, TextureOptions pTextureOptions) throws IOException {
        this(pBitmapTextureFormat, pTextureOptions, null);
    }

    public BitmapTexture(BitmapTextureFormat pBitmapTextureFormat, TextureOptions pTextureOptions, ITextureStateListener pTextureStateListener) throws IOException {
        super(pBitmapTextureFormat.getPixelFormat(), pTextureOptions, pTextureStateListener);
        this.mBitmapTextureFormat = pBitmapTextureFormat;
        Options decodeOptions = new Options();
        decodeOptions.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(onGetInputStream(), null, decodeOptions);
            this.mWidth = decodeOptions.outWidth;
            this.mHeight = decodeOptions.outHeight;
            if (!MathUtils.isPowerOfTwo(this.mWidth) || !MathUtils.isPowerOfTwo(this.mHeight)) {
                throw new IllegalArgumentException("pWidth and pHeight must be a power of 2!");
            }
        } finally {
            StreamUtils.close(null);
        }
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    protected void writeTextureToHardware(GL10 pGL) throws IOException {
        Config bitmapConfig = this.mBitmapTextureFormat.getBitmapConfig();
        boolean preMultipyAlpha = this.mTextureOptions.mPreMultipyAlpha;
        Options decodeOptions = new Options();
        decodeOptions.inPreferredConfig = bitmapConfig;
        Bitmap bitmap = BitmapFactory.decodeStream(onGetInputStream(), null, decodeOptions);
        if (preMultipyAlpha) {
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLHelper.glTexImage2D(pGL, 3553, 0, bitmap, 0, this.mPixelFormat);
        }
        bitmap.recycle();
    }
}
