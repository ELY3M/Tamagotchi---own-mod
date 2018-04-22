package org.anddev.andengine.util.cache;

import org.anddev.andengine.opengl.buffer.BufferObjectManager;
import org.anddev.andengine.opengl.vertex.RectangleVertexBuffer;
import org.anddev.andengine.util.MultiKey;
import org.anddev.andengine.util.MultiKeyHashMap;

public class RectangleVertexBufferCache {
    private final int mDrawType;
    private final MultiKeyHashMap<Integer, RectangleVertexBuffer> mRectangleVertexBufferCache;

    public RectangleVertexBufferCache() {
        this(35044);
    }

    public RectangleVertexBufferCache(int pDrawType) {
        this.mRectangleVertexBufferCache = new MultiKeyHashMap();
        this.mDrawType = pDrawType;
    }

    public RectangleVertexBuffer get(int pWidth, int pHeight) {
        RectangleVertexBuffer cachedRectangleVertexBuffer = (RectangleVertexBuffer) this.mRectangleVertexBufferCache.get(Integer.valueOf(pWidth), Integer.valueOf(pHeight));
        return cachedRectangleVertexBuffer != null ? cachedRectangleVertexBuffer : put(pWidth, pHeight, new RectangleVertexBuffer(this.mDrawType, false));
    }

    public RectangleVertexBuffer put(int pWidth, int pHeight, RectangleVertexBuffer pRectangleVertexBuffer) {
        pRectangleVertexBuffer.update((float) pWidth, (float) pHeight);
        BufferObjectManager.getActiveInstance().loadBufferObject(pRectangleVertexBuffer);
        this.mRectangleVertexBufferCache.put(new MultiKey(Integer.valueOf(pWidth), Integer.valueOf(pHeight)), pRectangleVertexBuffer);
        return pRectangleVertexBuffer;
    }
}
