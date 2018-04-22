package org.anddev.andengine.util.path;

public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);
    
    private final int mDeltaX;
    private final int mDeltaY;

    private Direction(int pDeltaX, int pDeltaY) {
        this.mDeltaX = pDeltaX;
        this.mDeltaY = pDeltaY;
    }

    public static Direction fromDelta(int pDeltaX, int pDeltaY) {
        if (pDeltaX == 0) {
            if (pDeltaY == 1) {
                return DOWN;
            }
            if (pDeltaY == -1) {
                return UP;
            }
        } else if (pDeltaY == 0) {
            if (pDeltaX == 1) {
                return RIGHT;
            }
            if (pDeltaX == -1) {
                return LEFT;
            }
        }
        throw new IllegalArgumentException();
    }

    public int getDeltaX() {
        return this.mDeltaX;
    }

    public int getDeltaY() {
        return this.mDeltaY;
    }
}
