package org.anddev.andengine.opengl.texture.compressed.pvr;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.anddev.andengine.opengl.texture.ITexture.ITextureStateListener;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.compressed.pvr.PVRTexture.PVRTextureFormat;
import org.anddev.andengine.util.ArrayUtils;
import org.anddev.andengine.util.StreamUtils;

public abstract class PVRCCZTexture extends PVRTexture {
    private CCZHeader mCCZHeader;

    public enum CCZCompressionFormat {
        ZLIB((short) 0),
        BZIP2((short) 1),
        GZIP((short) 2),
        NONE((short) 3);
        
        private final short mID;

        private CCZCompressionFormat(short pID) {
            this.mID = pID;
        }

        public InputStream wrap(InputStream pInputStream) throws IOException {
            switch (m27x54df9ceb()[ordinal()]) {
                case 1:
                    return new InflaterInputStream(pInputStream, new Inflater());
                case 3:
                    return new GZIPInputStream(pInputStream);
                default:
                    throw new IllegalArgumentException("Unexpected " + CCZCompressionFormat.class.getSimpleName() + ": '" + this + "'.");
            }
        }

        public static CCZCompressionFormat fromID(short pID) {
            for (CCZCompressionFormat cczCompressionFormat : values()) {
                if (cczCompressionFormat.mID == pID) {
                    return cczCompressionFormat;
                }
            }
            throw new IllegalArgumentException("Unexpected " + CCZCompressionFormat.class.getSimpleName() + "-ID: '" + pID + "'.");
        }
    }

    public static class CCZHeader {
        public static final byte[] MAGIC_IDENTIFIER = new byte[]{(byte) 67, (byte) 67, (byte) 90, (byte) 33};
        public static final int SIZE = 16;
        private final CCZCompressionFormat mCCZCompressionFormat;
        private final ByteBuffer mDataByteBuffer;

        public CCZHeader(byte[] pData) {
            this.mDataByteBuffer = ByteBuffer.wrap(pData);
            this.mDataByteBuffer.rewind();
            this.mDataByteBuffer.order(ByteOrder.BIG_ENDIAN);
            if (ArrayUtils.equals(pData, 0, MAGIC_IDENTIFIER, 0, MAGIC_IDENTIFIER.length)) {
                this.mCCZCompressionFormat = CCZCompressionFormat.fromID(getCCZCompressionFormatID());
                return;
            }
            throw new IllegalArgumentException("Invalid " + getClass().getSimpleName() + "!");
        }

        private short getCCZCompressionFormatID() {
            return this.mDataByteBuffer.getShort(4);
        }

        public CCZCompressionFormat getCCZCompressionFormat() {
            return this.mCCZCompressionFormat;
        }

        public short getVersion() {
            return this.mDataByteBuffer.getShort(6);
        }

        public int getUserdata() {
            return this.mDataByteBuffer.getInt(8);
        }

        public int getUncompressedSize() {
            return this.mDataByteBuffer.getInt(12);
        }
    }

    public PVRCCZTexture(PVRTextureFormat pPVRTextureFormat) throws IllegalArgumentException, IOException {
        super(pPVRTextureFormat);
    }

    public PVRCCZTexture(PVRTextureFormat pPVRTextureFormat, ITextureStateListener pTextureStateListener) throws IllegalArgumentException, IOException {
        super(pPVRTextureFormat, pTextureStateListener);
    }

    public PVRCCZTexture(PVRTextureFormat pPVRTextureFormat, TextureOptions pTextureOptions) throws IllegalArgumentException, IOException {
        super(pPVRTextureFormat, pTextureOptions);
    }

    public PVRCCZTexture(PVRTextureFormat pPVRTextureFormat, TextureOptions pTextureOptions, ITextureStateListener pTextureStateListener) throws IllegalArgumentException, IOException {
        super(pPVRTextureFormat, pTextureOptions, pTextureStateListener);
    }

    protected final InputStream getInputStream() throws IOException {
        InputStream inputStream = onGetInputStream();
        this.mCCZHeader = new CCZHeader(StreamUtils.streamToBytes(inputStream, 16));
        return this.mCCZHeader.getCCZCompressionFormat().wrap(inputStream);
    }

    protected ByteBuffer getPVRDataBuffer() throws IOException {
        InputStream inputStream = getInputStream();
        try {
            byte[] data = new byte[this.mCCZHeader.getUncompressedSize()];
            StreamUtils.copy(inputStream, data);
            ByteBuffer wrap = ByteBuffer.wrap(data);
            return wrap;
        } finally {
            StreamUtils.close(inputStream);
        }
    }
}
