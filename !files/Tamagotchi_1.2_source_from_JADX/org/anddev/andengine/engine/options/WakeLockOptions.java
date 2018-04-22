package org.anddev.andengine.engine.options;

public enum WakeLockOptions {
    BRIGHT(26),
    SCREEN_BRIGHT(10),
    SCREEN_DIM(6),
    SCREEN_ON(-1);
    
    private final int mFlag;

    private WakeLockOptions(int pFlag) {
        this.mFlag = pFlag;
    }

    public int getFlag() {
        return this.mFlag;
    }
}
