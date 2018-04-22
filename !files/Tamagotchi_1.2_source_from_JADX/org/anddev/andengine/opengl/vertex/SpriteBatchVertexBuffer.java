package org.anddev.andengine.opengl.vertex;

import org.anddev.andengine.opengl.util.FastFloatBuffer;
import org.anddev.andengine.util.Transformation;

public class SpriteBatchVertexBuffer extends VertexBuffer {
    private static final Transformation TRANSFORATION_TMP = new Transformation();
    public static final int VERTICES_PER_RECTANGLE = 6;
    private static final float[] VERTICES_TMP = new float[8];
    protected int mIndex;

    public SpriteBatchVertexBuffer(int pCapacity, int pDrawType, boolean pManaged) {
        super((pCapacity * 2) * 6, pDrawType, pManaged);
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setIndex(int pIndex) {
        this.mIndex = pIndex;
    }

    public void add(float pX, float pY, float pWidth, float pHeight, float pRotation) {
        float widthHalf = pWidth * 0.5f;
        float heightHalf = pHeight * 0.5f;
        TRANSFORATION_TMP.setToIdentity();
        TRANSFORATION_TMP.postTranslate(-widthHalf, -heightHalf);
        TRANSFORATION_TMP.postRotate(pRotation);
        TRANSFORATION_TMP.postTranslate(widthHalf, heightHalf);
        TRANSFORATION_TMP.postTranslate(pX, pY);
        add(pWidth, pHeight, TRANSFORATION_TMP);
    }

    public void add(float pX, float pY, float pWidth, float pHeight, float pScaleX, float pScaleY) {
        float widthHalf = pWidth * 0.5f;
        float heightHalf = pHeight * 0.5f;
        TRANSFORATION_TMP.setToIdentity();
        TRANSFORATION_TMP.postTranslate(-widthHalf, -heightHalf);
        TRANSFORATION_TMP.postScale(pScaleX, pScaleY);
        TRANSFORATION_TMP.postTranslate(widthHalf, heightHalf);
        TRANSFORATION_TMP.postTranslate(pX, pY);
        add(pWidth, pHeight, TRANSFORATION_TMP);
    }

    public void add(float pX, float pY, float pWidth, float pHeight, float pRotation, float pScaleX, float pScaleY) {
        float widthHalf = pWidth * 0.5f;
        float heightHalf = pHeight * 0.5f;
        TRANSFORATION_TMP.setToIdentity();
        TRANSFORATION_TMP.postTranslate(-widthHalf, -heightHalf);
        TRANSFORATION_TMP.postScale(pScaleX, pScaleY);
        TRANSFORATION_TMP.postRotate(pRotation);
        TRANSFORATION_TMP.postTranslate(widthHalf, heightHalf);
        TRANSFORATION_TMP.postTranslate(pX, pY);
        add(pWidth, pHeight, TRANSFORATION_TMP);
    }

    public void add(float pWidth, float pHeight, Transformation pTransformation) {
        VERTICES_TMP[0] = 0.0f;
        VERTICES_TMP[1] = 0.0f;
        VERTICES_TMP[2] = 0.0f;
        VERTICES_TMP[3] = pHeight;
        VERTICES_TMP[4] = pWidth;
        VERTICES_TMP[5] = 0.0f;
        VERTICES_TMP[6] = pWidth;
        VERTICES_TMP[7] = pHeight;
        pTransformation.transform(VERTICES_TMP);
        addInner(VERTICES_TMP[0], VERTICES_TMP[1], VERTICES_TMP[2], VERTICES_TMP[3], VERTICES_TMP[4], VERTICES_TMP[5], VERTICES_TMP[6], VERTICES_TMP[7]);
    }

    public void add(float pX, float pY, float pWidth, float pHeight) {
        addInner(pX, pY, pX + pWidth, pY + pHeight);
    }

    public void addInner(float pX1, float pY1, float pX2, float pY2) {
        int x1 = Float.floatToRawIntBits(pX1);
        int y1 = Float.floatToRawIntBits(pY1);
        int x2 = Float.floatToRawIntBits(pX2);
        int y2 = Float.floatToRawIntBits(pY2);
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

    public void addInner(float pX1, float pY1, float pX2, float pY2, float pX3, float pY3, float pX4, float pY4) {
        int x1 = Float.floatToRawIntBits(pX1);
        int y1 = Float.floatToRawIntBits(pY1);
        int x2 = Float.floatToRawIntBits(pX2);
        int y2 = Float.floatToRawIntBits(pY2);
        int x3 = Float.floatToRawIntBits(pX3);
        int y3 = Float.floatToRawIntBits(pY3);
        int x4 = Float.floatToRawIntBits(pX4);
        int y4 = Float.floatToRawIntBits(pY4);
        int[] bufferData = this.mBufferData;
        int index = this.mIndex;
        int index2 = index + 1;
        bufferData[index] = x1;
        index = index2 + 1;
        bufferData[index2] = y1;
        index2 = index + 1;
        bufferData[index] = x2;
        index = index2 + 1;
        bufferData[index2] = y2;
        index2 = index + 1;
        bufferData[index] = x3;
        index = index2 + 1;
        bufferData[index2] = y3;
        index2 = index + 1;
        bufferData[index] = x3;
        index = index2 + 1;
        bufferData[index2] = y3;
        index2 = index + 1;
        bufferData[index] = x2;
        index = index2 + 1;
        bufferData[index2] = y2;
        index2 = index + 1;
        bufferData[index] = x4;
        index = index2 + 1;
        bufferData[index2] = y4;
        this.mIndex = index;
    }

    public void submit() {
        FastFloatBuffer buffer = this.mFloatBuffer;
        buffer.position(0);
        buffer.put(this.mBufferData);
        buffer.position(0);
        super.setHardwareBufferNeedsUpdate();
    }
}
