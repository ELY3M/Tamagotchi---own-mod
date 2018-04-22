package org.anddev.andengine.extension.physics.box2d.util.hull;

import com.badlogic.gdx.math.Vector2;
import org.anddev.andengine.extension.physics.box2d.util.Vector2Pool;

public class JarvisMarch extends BaseHullAlgorithm {
    public int computeHull(Vector2[] pVectors) {
        this.mVertices = pVectors;
        this.mVertexCount = pVectors.length;
        this.mHullVertexCount = 0;
        jarvisMarch();
        return this.mHullVertexCount;
    }

    private void jarvisMarch() {
        Vector2[] vertices = this.mVertices;
        int index = indexOfLowestVertex();
        do {
            swap(this.mHullVertexCount, index);
            index = indexOfRightmostVertexOf(vertices[this.mHullVertexCount]);
            this.mHullVertexCount++;
        } while (index > 0);
    }

    private int indexOfRightmostVertexOf(Vector2 pVector) {
        Vector2[] vertices = this.mVertices;
        int vertexCount = this.mVertexCount;
        int i = 0;
        for (int j = 1; j < vertexCount; j++) {
            Vector2 vector2A = Vector2Pool.obtain().set(vertices[j]);
            Vector2 vector2B = Vector2Pool.obtain().set(vertices[i]);
            if (Vector2Util.isLess(vector2A.sub(pVector), vector2B.sub(pVector))) {
                i = j;
            }
            Vector2Pool.recycle(vector2A);
            Vector2Pool.recycle(vector2B);
        }
        return i;
    }
}
