package org.anddev.andengine.opengl.texture.compressed.etc1;

import android.opengl.ETC1;
import android.opengl.ETC1Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.opengl.texture.ITexture.ITextureStateListener;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.Texture.PixelFormat;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.util.StreamUtils;

public abstract class ETC1Texture extends Texture {
    private ETC1TextureHeader mETC1TextureHeader;

    public static class ETC1TextureHeader {
        private final ByteBuffer mDataByteBuffer;
        private final int mHeight;
        private final int mWidth;

        public ETC1TextureHeader(byte[] pData) {
            if (pData.length != 16) {
                throw new IllegalArgumentException("Invalid " + getClass().getSimpleName() + "!");
            }
            this.mDataByteBuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder());
            this.mDataByteBuffer.put(pData, 0, 16);
            this.mDataByteBuffer.position(0);
            if (ETC1.isValid(this.mDataByteBuffer)) {
                this.mWidth = ETC1.getWidth(this.mDataByteBuffer);
                this.mHeight = ETC1.getHeight(this.mDataByteBuffer);
                return;
            }
            throw new IllegalArgumentException("Invalid " + getClass().getSimpleName() + "!");
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }
    }

    protected abstract InputStream getInputStream() throws IOException;

    public ETC1Texture() throws IOException {
        this(TextureOptions.DEFAULT, null);
    }

    public ETC1Texture(ITextureStateListener pTextureStateListener) throws IOException {
        this(TextureOptions.DEFAULT, pTextureStateListener);
    }

    public ETC1Texture(TextureOptions pTextureOptions) throws IOException {
        this(pTextureOptions, null);
    }

    public ETC1Texture(TextureOptions pTextureOptions, ITextureStateListener pTextureStateListener) throws IOException {
        super(PixelFormat.RGB_565, pTextureOptions, pTextureStateListener);
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            this.mETC1TextureHeader = new ETC1TextureHeader(StreamUtils.streamToBytes(inputStream, 16));
        } finally {
            StreamUtils.close(inputStream);
        }
    }

    public int getWidth() {
        return this.mETC1TextureHeader.getWidth();
    }

    public int getHeight() {
        return this.mETC1TextureHeader.getHeight();
    }

    protected void writeTextureToHardware(GL10 pGL) throws IOException {
        InputStream inputStream = getInputStream();
        ETC1Util.loadTexture(3553, 0, 0, this.mPixelFormat.getGLFormat(), this.mPixelFormat.getGLType(), inputStream);
    }
}
