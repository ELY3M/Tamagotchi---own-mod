package org.anddev.andengine.opengl.texture.compressed.pvr;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.opengl.texture.ITexture.ITextureStateListener;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.Texture.PixelFormat;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.util.ArrayUtils;
import org.anddev.andengine.util.ByteBufferOutputStream;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.MathUtils;
import org.anddev.andengine.util.StreamUtils;

public abstract class PVRTexture extends Texture {
    public static final int FLAG_ALPHA = 32768;
    public static final int FLAG_BUMPMAP = 1024;
    public static final int FLAG_CUBEMAP = 4096;
    public static final int FLAG_FALSEMIPCOL = 8192;
    public static final int FLAG_MIPMAP = 256;
    public static final int FLAG_TILING = 2048;
    public static final int FLAG_TWIDDLE = 512;
    public static final int FLAG_VERTICALFLIP = 65536;
    public static final int FLAG_VOLUME = 16384;
    private final PVRTextureHeader mPVRTextureHeader;

    public enum PVRTextureFormat {
        RGBA_4444(16, false, PixelFormat.RGBA_4444),
        RGBA_5551(17, false, PixelFormat.RGBA_5551),
        RGBA_8888(18, false, PixelFormat.RGBA_8888),
        RGB_565(19, false, PixelFormat.RGB_565),
        I_8(22, false, PixelFormat.I_8),
        AI_88(23, false, PixelFormat.AI_88),
        A_8(27, false, PixelFormat.A_8);
        
        private final boolean mCompressed;
        private final int mID;
        private final PixelFormat mPixelFormat;

        private PVRTextureFormat(int pID, boolean pCompressed, PixelFormat pPixelFormat) {
            this.mID = pID;
            this.mCompressed = pCompressed;
            this.mPixelFormat = pPixelFormat;
        }

        public static PVRTextureFormat fromID(int pID) {
            for (PVRTextureFormat pvrTextureFormat : values()) {
                if (pvrTextureFormat.mID == pID) {
                    return pvrTextureFormat;
                }
            }
            throw new IllegalArgumentException("Unexpected " + PVRTextureFormat.class.getSimpleName() + "-ID: '" + pID + "'.");
        }

        public static PVRTextureFormat fromPixelFormat(PixelFormat pPixelFormat) throws IllegalArgumentException {
            switch (m28xc82e07aa()[pPixelFormat.ordinal()]) {
                case 2:
                    return RGBA_4444;
                case 4:
                    return RGBA_8888;
                case 5:
                    return RGB_565;
                default:
                    throw new IllegalArgumentException("Unsupported " + PixelFormat.class.getName() + ": '" + pPixelFormat + "'.");
            }
        }

        public int getID() {
            return this.mID;
        }

        public boolean isCompressed() {
            return this.mCompressed;
        }

        public PixelFormat getPixelFormat() {
            return this.mPixelFormat;
        }
    }

    public static class PVRTextureHeader {
        private static final int FORMAT_FLAG_MASK = 255;
        public static final byte[] MAGIC_IDENTIFIER = new byte[]{(byte) 80, (byte) 86, (byte) 82, (byte) 33};
        public static final int SIZE = 52;
        private final ByteBuffer mDataByteBuffer;
        private final PVRTextureFormat mPVRTextureFormat;

        public PVRTextureHeader(byte[] pData) {
            this.mDataByteBuffer = ByteBuffer.wrap(pData);
            this.mDataByteBuffer.rewind();
            this.mDataByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            if (ArrayUtils.equals(pData, 44, MAGIC_IDENTIFIER, 0, MAGIC_IDENTIFIER.length)) {
                this.mPVRTextureFormat = PVRTextureFormat.fromID(getFlags() & 255);
                return;
            }
            throw new IllegalArgumentException("Invalid " + getClass().getSimpleName() + "!");
        }

        public PVRTextureFormat getPVRTextureFormat() {
            return this.mPVRTextureFormat;
        }

        public int headerLength() {
            return this.mDataByteBuffer.getInt(0);
        }

        public int getHeight() {
            return this.mDataByteBuffer.getInt(4);
        }

        public int getWidth() {
            return this.mDataByteBuffer.getInt(8);
        }

        public int getNumMipmaps() {
            return this.mDataByteBuffer.getInt(12);
        }

        public int getFlags() {
            return this.mDataByteBuffer.getInt(16);
        }

        public int getDataLength() {
            return this.mDataByteBuffer.getInt(20);
        }

        public int getBitsPerPixel() {
            return this.mDataByteBuffer.getInt(24);
        }

        public int getBitmaskRed() {
            return this.mDataByteBuffer.getInt(28);
        }

        public int getBitmaskGreen() {
            return this.mDataByteBuffer.getInt(32);
        }

        public int getBitmaskBlue() {
            return this.mDataByteBuffer.getInt(36);
        }

        public int getBitmaskAlpha() {
            return this.mDataByteBuffer.getInt(40);
        }

        public boolean hasAlpha() {
            return getBitmaskAlpha() != 0;
        }

        public int getPVRTag() {
            return this.mDataByteBuffer.getInt(44);
        }

        public int numSurfs() {
            return this.mDataByteBuffer.getInt(48);
        }
    }

    protected abstract InputStream onGetInputStream() throws IOException;

    public PVRTexture(PVRTextureFormat pPVRTextureFormat) throws IllegalArgumentException, IOException {
        this(pPVRTextureFormat, TextureOptions.DEFAULT, null);
    }

    public PVRTexture(PVRTextureFormat pPVRTextureFormat, ITextureStateListener pTextureStateListener) throws IllegalArgumentException, IOException {
        this(pPVRTextureFormat, TextureOptions.DEFAULT, pTextureStateListener);
    }

    public PVRTexture(PVRTextureFormat pPVRTextureFormat, TextureOptions pTextureOptions) throws IllegalArgumentException, IOException {
        this(pPVRTextureFormat, pTextureOptions, null);
    }

    public PVRTexture(PVRTextureFormat pPVRTextureFormat, TextureOptions pTextureOptions, ITextureStateListener pTextureStateListener) throws IllegalArgumentException, IOException {
        super(pPVRTextureFormat.getPixelFormat(), pTextureOptions, pTextureStateListener);
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            this.mPVRTextureHeader = new PVRTextureHeader(StreamUtils.streamToBytes(inputStream, 52));
            if (!MathUtils.isPowerOfTwo(getWidth()) || !MathUtils.isPowerOfTwo(getHeight())) {
                throw new IllegalArgumentException("mWidth and mHeight must be a power of 2!");
            } else if (this.mPVRTextureHeader.getPVRTextureFormat().getPixelFormat() != pPVRTextureFormat.getPixelFormat()) {
                throw new IllegalArgumentException("Other PVRTextureFormat: '" + this.mPVRTextureHeader.getPVRTextureFormat().getPixelFormat() + "' found than expected: '" + pPVRTextureFormat.getPixelFormat() + "'.");
            } else if (this.mPVRTextureHeader.getPVRTextureFormat().isCompressed()) {
                throw new IllegalArgumentException("Invalid PVRTextureFormat: '" + this.mPVRTextureHeader.getPVRTextureFormat() + "'.");
            } else {
                this.mUpdateOnHardwareNeeded = true;
            }
        } finally {
            StreamUtils.close(inputStream);
        }
    }

    public int getWidth() {
        return this.mPVRTextureHeader.getWidth();
    }

    public int getHeight() {
        return this.mPVRTextureHeader.getHeight();
    }

    public PVRTextureHeader getPVRTextureHeader() {
        return this.mPVRTextureHeader;
    }

    protected InputStream getInputStream() throws IOException {
        return onGetInputStream();
    }

    protected void generateHardwareTextureID(GL10 pGL) {
        pGL.glPixelStorei(3317, 1);
        super.generateHardwareTextureID(pGL);
    }

    protected void writeTextureToHardware(GL10 pGL) throws IOException {
        ByteBuffer pvrDataBuffer = getPVRDataBuffer();
        int width = getWidth();
        int height = getHeight();
        int dataLength = this.mPVRTextureHeader.getDataLength();
        int glFormat = this.mPixelFormat.getGLFormat();
        int glType = this.mPixelFormat.getGLType();
        int bytesPerPixel = this.mPVRTextureHeader.getBitsPerPixel() / 8;
        int mipmapLevel = 0;
        int currentPixelDataOffset = 0;
        while (currentPixelDataOffset < dataLength) {
            int currentPixelDataSize = (width * height) * bytesPerPixel;
            if (mipmapLevel > 0 && !(width == height && MathUtils.nextPowerOfTwo(width) == width)) {
                Debug.m68w(String.format("Mipmap level '%u' is not squared. Width: '%u', height: '%u'. Texture won't render correctly.", new Object[]{Integer.valueOf(mipmapLevel), Integer.valueOf(width), Integer.valueOf(height)}));
            }
            pvrDataBuffer.position(currentPixelDataOffset + 52);
            pvrDataBuffer.limit((currentPixelDataOffset + 52) + currentPixelDataSize);
            pGL.glTexImage2D(3553, mipmapLevel, glFormat, width, height, 0, glFormat, glType, pvrDataBuffer.slice());
            currentPixelDataOffset += currentPixelDataSize;
            width = Math.max(width >> 1, 1);
            height = Math.max(height >> 1, 1);
            mipmapLevel++;
        }
    }

    protected ByteBuffer getPVRDataBuffer() throws IOException {
        InputStream inputStream = getInputStream();
        try {
            OutputStream os = new ByteBufferOutputStream(1024, 524288);
            StreamUtils.copy(inputStream, os);
            ByteBuffer toByteBuffer = os.toByteBuffer();
            return toByteBuffer;
        } finally {
            StreamUtils.close(inputStream);
        }
    }
}
