package org.anddev.andengine.util.path.astar;

import org.anddev.andengine.util.path.ITiledMap;

public class ManhattanHeuristic<T> implements IAStarHeuristic<T> {
    public float getExpectedRestCost(ITiledMap<T> iTiledMap, T t, int pTileFromX, int pTileFromY, int pTileToX, int pTileToY) {
        return (float) (Math.abs(pTileFromX - pTileToX) + Math.abs(pTileToX - pTileToY));
    }
}
