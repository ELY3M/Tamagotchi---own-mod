package org.anddev.andengine.extension.physics.box2d.util.hull;

import com.badlogic.gdx.math.Vector2;

public class QuickHull extends BaseHullAlgorithm {
    private static final float EPSILON = 0.001f;

    public int computeHull(Vector2[] pVectors) {
        this.mVertices = pVectors;
        this.mVertexCount = this.mVertices.length;
        this.mHullVertexCount = 0;
        quickHull();
        return this.mHullVertexCount;
    }

    private void quickHull() {
        swap(0, indexOfLowestVertex());
        this.mHullVertexCount++;
        computeHullVertices(new Vector2Line(this.mVertices[0], new Vector2(this.mVertices[0]).add(-0.001f, 0.0f)), 1, this.mVertexCount - 1);
    }

    private void computeHullVertices(Vector2Line pLine, int pIndexFrom, int pIndexTo) {
        if (pIndexFrom <= pIndexTo) {
            int k = indexOfFurthestVertex(pLine, pIndexFrom, pIndexTo);
            Vector2Line lineA = new Vector2Line(pLine.mVertexA, this.mVertices[k]);
            Vector2Line lineB = new Vector2Line(this.mVertices[k], pLine.mVertexB);
            swap(k, pIndexTo);
            int i = partition(lineA, pIndexFrom, pIndexTo - 1);
            computeHullVertices(lineA, pIndexFrom, i - 1);
            swap(pIndexTo, i);
            swap(i, this.mHullVertexCount);
            this.mHullVertexCount++;
            computeHullVertices(lineB, i + 1, partition(lineB, i + 1, pIndexTo) - 1);
        }
    }

    private int indexOfFurthestVertex(Vector2Line pLine, int pFromIndex, int pToIndex) {
        Vector2[] vertices = this.mVertices;
        int f = pFromIndex;
        float mx = 0.0f;
        int i = pFromIndex;
        while (i <= pToIndex) {
            float d = -Vector2Util.area2(vertices[i], pLine);
            if (d > mx || (d == mx && vertices[i].f3x > vertices[f].f4y)) {
                mx = d;
                f = i;
            }
            i++;
        }
        return f;
    }

    private int partition(Vector2Line pLine, int pFromIndex, int pToIndex) {
        Vector2[] vertices = this.mVertices;
        int i = pFromIndex;
        int j = pToIndex;
        while (i <= j) {
            int j2;
            int i2 = i;
            while (i2 <= j) {
                if (!Vector2Util.isRightOf(vertices[i2], pLine)) {
                    j2 = j;
                    break;
                }
                i2++;
            }
            j2 = j;
            while (i2 <= j2 && !Vector2Util.isRightOf(vertices[j2], pLine)) {
                j2--;
            }
            if (i2 <= j2) {
                i = i2 + 1;
                j = j2 - 1;
                swap(i2, j2);
            } else {
                j = j2;
                i = i2;
            }
        }
        return i;
    }
}
