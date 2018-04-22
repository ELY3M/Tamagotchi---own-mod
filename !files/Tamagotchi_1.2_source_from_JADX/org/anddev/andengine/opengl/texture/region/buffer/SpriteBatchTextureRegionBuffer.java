package org.anddev.andengine.opengl.texture.region.buffer;

import org.anddev.andengine.opengl.buffer.BufferObject;
import org.anddev.andengine.opengl.texture.region.BaseTextureRegion;
import org.anddev.andengine.opengl.util.FastFloatBuffer;

public class SpriteBatchTextureRegionBuffer extends BufferObject {
    protected int mIndex;

    public SpriteBatchTextureRegionBuffer(int pCapacity, int pDrawType, boolean pManaged) {
        super((pCapacity * 2) * 6, pDrawType, pManaged);
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setIndex(int pIndex) {
        this.mIndex = pIndex;
    }

    public void add(BaseTextureRegion pTextureRegion) {
        if (pTextureRegion.getTexture() != null) {
            int x1 = Float.floatToRawIntBits(pTextureRegion.getTextureCoordinateX1());
            int y1 = Float.floatToRawIntBits(pTextureRegion.getTextureCoordinateY1());
            int x2 = Float.floatToRawIntBits(pTextureRegion.getTextureCoordinateX2());
            int y2 = Float.floatToRawIntBits(pTextureRegion.getTextureCoordinateY2());
            int[] bufferData = this.mBufferData;
            int index = this.mIndex;
            int index2 = index + 1;
            bufferData[index] = x1;
            index = index2 + 1;
            bufferData[index2] = y1;
            index2 = index + 1;
            bufferData[index] = x1;
            index = index2 + 1;
            bufferData[index2] = y2;
            index2 = index + 1;
            bufferData[index] = x2;
            index = index2 + 1;
            bufferData[index2] = y1;
            index2 = index + 1;
            bufferData[index] = x2;
            index = index2 + 1;
            bufferData[index2] = y1;
            index2 = index + 1;
            bufferData[index] = x1;
            index = index2 + 1;
            bufferData[index2] = y2;
            index2 = index + 1;
            bufferData[index] = x2;
            index = index2 + 1;
            bufferData[index2] = y2;
            this.mIndex = index;
        }
    }

    public void submit() {
        FastFloatBuffer buffer = this.mFloatBuffer;
        buffer.position(0);
        buffer.put(this.mBufferData);
        buffer.position(0);
        super.setHardwareBufferNeedsUpdate();
    }
}
