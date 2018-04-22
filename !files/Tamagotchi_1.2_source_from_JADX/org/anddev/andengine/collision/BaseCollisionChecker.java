package org.anddev.andengine.collision;

public class BaseCollisionChecker {
    public static boolean checkAxisAlignedRectangleCollision(float pLeftA, float pTopA, float pRightA, float pBottomA, float pLeftB, float pTopB, float pRightB, float pBottomB) {
        return pLeftA < pRightB && pLeftB < pRightA && pTopA < pBottomB && pTopB < pBottomA;
    }

    public static int relativeCCW(float pX1, float pY1, float pX2, float pY2, float pPX, float pPY) {
        pX2 -= pX1;
        pY2 -= pY1;
        pPX -= pX1;
        pPY -= pY1;
        float ccw = (pPX * pY2) - (pPY * pX2);
        if (ccw == 0.0f) {
            ccw = (pPX * pX2) + (pPY * pY2);
            if (ccw > 0.0f) {
                ccw = ((pPX - pX2) * pX2) + ((pPY - pY2) * pY2);
                if (ccw < 0.0f) {
                    ccw = 0.0f;
                }
            }
        }
        if (ccw < 0.0f) {
            return -1;
        }
        return ccw > 0.0f ? 1 : 0;
    }
}
