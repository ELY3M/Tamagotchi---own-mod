package org.anddev.andengine.extension.physics.box2d.util.triangulation;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EarClippingTriangulator implements ITriangulationAlgoritm {
    private static final int CONCAVE = 1;
    private static final int CONVEX = -1;
    private int mConcaveVertexCount;

    public List<Vector2> computeTriangles(List<Vector2> pVertices) {
        ArrayList<Vector2> triangles = new ArrayList();
        ArrayList<Vector2> vertices = new ArrayList(pVertices.size());
        vertices.addAll(pVertices);
        if (vertices.size() == 3) {
            triangles.addAll(vertices);
        } else {
            while (vertices.size() >= 3) {
                int[] vertexTypes = classifyVertices(vertices);
                int vertexCount = vertices.size();
                for (int index = 0; index < vertexCount; index++) {
                    if (isEarTip(vertices, index, vertexTypes)) {
                        cutEarTip(vertices, index, triangles);
                        break;
                    }
                }
            }
        }
        return triangles;
    }

    private static boolean areVerticesClockwise(ArrayList<Vector2> pVertices) {
        float area = 0.0f;
        for (int i = 0; i < pVertices.size(); i++) {
            Vector2 p1 = (Vector2) pVertices.get(i);
            Vector2 p2 = (Vector2) pVertices.get(computeNextIndex(pVertices, i));
            area += (p1.f3x * p2.f4y) - (p2.f3x * p1.f4y);
        }
        if (area < 0.0f) {
            return true;
        }
        return false;
    }

    private int[] classifyVertices(ArrayList<Vector2> pVertices) {
        int vertexCount = pVertices.size();
        int[] vertexTypes = new int[vertexCount];
        this.mConcaveVertexCount = 0;
        if (!areVerticesClockwise(pVertices)) {
            Collections.reverse(pVertices);
        }
        for (int index = 0; index < vertexCount; index++) {
            int previousIndex = computePreviousIndex(pVertices, index);
            Vector2 previousVertex = (Vector2) pVertices.get(previousIndex);
            Vector2 currentVertex = (Vector2) pVertices.get(index);
            Vector2 nextVertex = (Vector2) pVertices.get(computeNextIndex(pVertices, index));
            if (isTriangleConvex(previousVertex.f3x, previousVertex.f4y, currentVertex.f3x, currentVertex.f4y, nextVertex.f3x, nextVertex.f4y)) {
                vertexTypes[index] = -1;
            } else {
                vertexTypes[index] = 1;
                this.mConcaveVertexCount++;
            }
        }
        return vertexTypes;
    }

    private static boolean isTriangleConvex(float pX1, float pY1, float pX2, float pY2, float pX3, float pY3) {
        if (computeSpannedAreaSign(pX1, pY1, pX2, pY2, pX3, pY3) < 0) {
            return false;
        }
        return true;
    }

    private static int computeSpannedAreaSign(float pX1, float pY1, float pX2, float pY2, float pX3, float pY3) {
        return (int) Math.signum(((0.0f + ((pY3 - pY2) * pX1)) + ((pY1 - pY3) * pX2)) + ((pY2 - pY1) * pX3));
    }

    private static boolean isAnyVertexInTriangle(ArrayList<Vector2> pVertices, int[] pVertexTypes, float pX1, float pY1, float pX2, float pY2, float pX3, float pY3) {
        int vertexCount = pVertices.size();
        for (int i = 0; i < vertexCount - 1; i++) {
            if (pVertexTypes[i] == 1) {
                Vector2 currentVertex = (Vector2) pVertices.get(i);
                float currentVertexX = currentVertex.f3x;
                float currentVertexY = currentVertex.f4y;
                int areaSign1 = computeSpannedAreaSign(pX1, pY1, pX2, pY2, currentVertexX, currentVertexY);
                int areaSign2 = computeSpannedAreaSign(pX2, pY2, pX3, pY3, currentVertexX, currentVertexY);
                int areaSign3 = computeSpannedAreaSign(pX3, pY3, pX1, pY1, currentVertexX, currentVertexY);
                if (areaSign1 > 0 && areaSign2 > 0 && areaSign3 > 0) {
                    return true;
                }
                if (areaSign1 <= 0 && areaSign2 <= 0 && areaSign3 <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEarTip(ArrayList<Vector2> pVertices, int pEarTipIndex, int[] pVertexTypes) {
        if (this.mConcaveVertexCount == 0) {
            return true;
        }
        Vector2 previousVertex = (Vector2) pVertices.get(computePreviousIndex(pVertices, pEarTipIndex));
        Vector2 currentVertex = (Vector2) pVertices.get(pEarTipIndex);
        Vector2 nextVertex = (Vector2) pVertices.get(computeNextIndex(pVertices, pEarTipIndex));
        if (isAnyVertexInTriangle(pVertices, pVertexTypes, previousVertex.f3x, previousVertex.f4y, currentVertex.f3x, currentVertex.f4y, nextVertex.f3x, nextVertex.f4y)) {
            return false;
        }
        return true;
    }

    private void cutEarTip(ArrayList<Vector2> pVertices, int pEarTipIndex, ArrayList<Vector2> pTriangles) {
        int previousIndex = computePreviousIndex(pVertices, pEarTipIndex);
        int nextIndex = computeNextIndex(pVertices, pEarTipIndex);
        if (!isCollinear(pVertices, previousIndex, pEarTipIndex, nextIndex)) {
            pTriangles.add(new Vector2((Vector2) pVertices.get(previousIndex)));
            pTriangles.add(new Vector2((Vector2) pVertices.get(pEarTipIndex)));
            pTriangles.add(new Vector2((Vector2) pVertices.get(nextIndex)));
        }
        pVertices.remove(pEarTipIndex);
        if (pVertices.size() >= 3) {
            removeCollinearNeighborEarsAfterRemovingEarTip(pVertices, pEarTipIndex);
        }
    }

    private static void removeCollinearNeighborEarsAfterRemovingEarTip(ArrayList<Vector2> pVertices, int pEarTipCutIndex) {
        int collinearityCheckNextIndex = pEarTipCutIndex % pVertices.size();
        int collinearCheckPreviousIndex = computePreviousIndex(pVertices, collinearityCheckNextIndex);
        if (isCollinear(pVertices, collinearityCheckNextIndex)) {
            pVertices.remove(collinearityCheckNextIndex);
            if (pVertices.size() > 3) {
                collinearCheckPreviousIndex = computePreviousIndex(pVertices, collinearityCheckNextIndex);
                if (isCollinear(pVertices, collinearCheckPreviousIndex)) {
                    pVertices.remove(collinearCheckPreviousIndex);
                }
            }
        } else if (isCollinear(pVertices, collinearCheckPreviousIndex)) {
            pVertices.remove(collinearCheckPreviousIndex);
        }
    }

    private static boolean isCollinear(ArrayList<Vector2> pVertices, int pIndex) {
        return isCollinear(pVertices, computePreviousIndex(pVertices, pIndex), pIndex, computeNextIndex(pVertices, pIndex));
    }

    private static boolean isCollinear(ArrayList<Vector2> pVertices, int pPreviousIndex, int pIndex, int pNextIndex) {
        Vector2 previousVertex = (Vector2) pVertices.get(pPreviousIndex);
        Vector2 vertex = (Vector2) pVertices.get(pIndex);
        Vector2 nextVertex = (Vector2) pVertices.get(pNextIndex);
        return computeSpannedAreaSign(previousVertex.f3x, previousVertex.f4y, vertex.f3x, vertex.f4y, nextVertex.f3x, nextVertex.f4y) == 0;
    }

    private static int computePreviousIndex(List<Vector2> pVertices, int pIndex) {
        return pIndex == 0 ? pVertices.size() - 1 : pIndex - 1;
    }

    private static int computeNextIndex(List<Vector2> pVertices, int pIndex) {
        return pIndex == pVertices.size() + -1 ? 0 : pIndex + 1;
    }
}
