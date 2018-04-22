package org.anddev.andengine.extension.physics.box2d.util.hull;

import com.badlogic.gdx.math.Vector2;

class Vector2Util {
    Vector2Util() {
    }

    public static boolean isLess(Vector2 pVertexA, Vector2 pVertexB) {
        float f = pVertexA.cross(pVertexB);
        return f > 0.0f || (f == 0.0f && isLonger(pVertexA, pVertexB));
    }

    public static boolean isLonger(Vector2 pVertexA, Vector2 pVertexB) {
        return pVertexA.lenManhattan() > pVertexB.lenManhattan();
    }

    public static float getManhattanDistance(Vector2 pVertexA, Vector2 pVertexB) {
        return Math.abs(pVertexA.f3x - pVertexB.f3x) + Math.abs(pVertexA.f4y - pVertexB.f4y);
    }

    public static boolean isConvex(Vector2 pVertexTest, Vector2 pVertexA, Vector2 pVertexB) {
        float f = area2(pVertexTest, pVertexA, pVertexB);
        return f < 0.0f || (f == 0.0f && !isBetween(pVertexTest, pVertexA, pVertexB));
    }

    public static float area2(Vector2 pVertexTest, Vector2 pVertexA, Vector2 pVertexB) {
        return ((pVertexA.f3x - pVertexTest.f3x) * (pVertexB.f4y - pVertexTest.f4y)) - ((pVertexB.f3x - pVertexTest.f3x) * (pVertexA.f4y - pVertexTest.f4y));
    }

    public static float area2(Vector2 pVertexTest, Vector2Line pLine) {
        return area2(pVertexTest, pLine.mVertexA, pLine.mVertexB);
    }

    public static boolean isBetween(Vector2 pVertexTest, Vector2 pVertexA, Vector2 pVertexB) {
        return getManhattanDistance(pVertexA, pVertexB) >= getManhattanDistance(pVertexTest, pVertexA) + getManhattanDistance(pVertexTest, pVertexB);
    }

    public static boolean isRightOf(Vector2 pVertexTest, Vector2Line pLine) {
        return area2(pVertexTest, pLine) < 0.0f;
    }
}
