package org.anddev.andengine.opengl.vertex;

import org.anddev.andengine.opengl.buffer.BufferObject;

public abstract class VertexBuffer extends BufferObject {
    public VertexBuffer(int pCapacity, int pDrawType, boolean pManaged) {
        super(pCapacity, pDrawType, pManaged);
    }
}
