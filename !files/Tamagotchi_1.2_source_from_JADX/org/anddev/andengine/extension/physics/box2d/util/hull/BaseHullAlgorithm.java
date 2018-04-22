package org.anddev.andengine.extension.physics.box2d.util.hull;

import com.badlogic.gdx.math.Vector2;

public abstract class BaseHullAlgorithm implements IHullAlgorithm {
    protected int mHullVertexCount;
    protected int mVertexCount;
    protected Vector2[] mVertices;

    protected int indexOfLowestVertex() {
        Vector2[] vertices = this.mVertices;
        int vertexCount = this.mVertexCount;
        int min = 0;
        for (int i = 1; i < vertexCount; i++) {
            float dY = vertices[i].f4y - vertices[min].f4y;
            float dX = vertices[i].f3x - vertices[min].f3x;
            if (dY < 0.0f || (dY == 0.0f && dX < 0.0f)) {
                min = i;
            }
        }
        return min;
    }

    protected void swap(int pIndexA, int pIndexB) {
        Vector2[] vertices = this.mVertices;
        Vector2 tmp = vertices[pIndexA];
        vertices[pIndexA] = vertices[pIndexB];
        vertices[pIndexB] = tmp;
    }
}
