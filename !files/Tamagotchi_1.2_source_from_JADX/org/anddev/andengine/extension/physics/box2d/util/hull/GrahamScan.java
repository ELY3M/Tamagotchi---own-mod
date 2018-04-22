package org.anddev.andengine.extension.physics.box2d.util.hull;

import com.badlogic.gdx.math.Vector2;

public class GrahamScan extends BaseHullAlgorithm {
    public int computeHull(Vector2[] pVertices) {
        this.mVertices = pVertices;
        this.mVertexCount = pVertices.length;
        if (this.mVertexCount < 3) {
            return this.mVertexCount;
        }
        this.mHullVertexCount = 0;
        grahamScan();
        return this.mHullVertexCount;
    }

    private void grahamScan() {
        swap(0, indexOfLowestVertex());
        Vector2 pl = new Vector2(this.mVertices[0]);
        makeAllVerticesRelativeTo(pl);
        sort();
        makeAllVerticesRelativeTo(new Vector2(pl).mul(-1.0f));
        int i = 3;
        int k = 3;
        while (k < this.mVertexCount) {
            swap(i, k);
            while (!isConvex(i - 1)) {
                int i2 = i - 1;
                swap(i - 1, i);
                i = i2;
            }
            k++;
            i++;
        }
        this.mHullVertexCount = i;
    }

    private void makeAllVerticesRelativeTo(Vector2 pVector) {
        Vector2[] vertices = this.mVertices;
        int vertexCount = this.mVertexCount;
        Vector2 vertexCopy = new Vector2(pVector);
        for (int i = 0; i < vertexCount; i++) {
            vertices[i].sub(vertexCopy);
        }
    }

    private boolean isConvex(int pIndex) {
        Vector2[] vertices = this.mVertices;
        return Vector2Util.isConvex(vertices[pIndex], vertices[pIndex - 1], vertices[pIndex + 1]);
    }

    private void sort() {
        quicksort(1, this.mVertexCount - 1);
    }

    private void quicksort(int pFromIndex, int pToIndex) {
        Vector2[] vertices = this.mVertices;
        int i = pFromIndex;
        int j = pToIndex;
        Vector2 q = vertices[(pFromIndex + pToIndex) / 2];
        while (i <= j) {
            while (Vector2Util.isLess(vertices[i], q)) {
                i++;
            }
            while (Vector2Util.isLess(q, vertices[j])) {
                j--;
            }
            if (i <= j) {
                int i2 = i + 1;
                int j2 = j - 1;
                swap(i, j);
                j = j2;
                i = i2;
            }
        }
        if (pFromIndex < j) {
            quicksort(pFromIndex, j);
        }
        if (i < pToIndex) {
            quicksort(i, pToIndex);
        }
    }
}
