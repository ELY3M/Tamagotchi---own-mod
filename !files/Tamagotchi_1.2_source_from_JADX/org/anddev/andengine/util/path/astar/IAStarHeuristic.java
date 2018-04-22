package org.anddev.andengine.util.path.astar;

import org.anddev.andengine.util.path.ITiledMap;

public interface IAStarHeuristic<T> {
    float getExpectedRestCost(ITiledMap<T> iTiledMap, T t, int i, int i2, int i3, int i4);
}
