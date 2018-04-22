package org.anddev.andengine.util.path.astar;

import android.util.FloatMath;
import org.anddev.andengine.util.path.ITiledMap;

public class EuclideanHeuristic<T> implements IAStarHeuristic<T> {
    public float getExpectedRestCost(ITiledMap<T> iTiledMap, T t, int pTileFromX, int pTileFromY, int pTileToX, int pTileToY) {
        float dX = (float) (pTileToX - pTileFromX);
        float dY = (float) (pTileToY - pTileFromY);
        return FloatMath.sqrt((dX * dX) + (dY * dY));
    }
}
