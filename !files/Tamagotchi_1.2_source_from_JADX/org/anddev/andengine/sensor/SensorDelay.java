package org.anddev.andengine.sensor;

public enum SensorDelay {
    NORMAL(3),
    UI(2),
    GAME(1),
    FASTEST(0);
    
    private final int mDelay;

    private SensorDelay(int pDelay) {
        this.mDelay = pDelay;
    }

    public int getDelay() {
        return this.mDelay;
    }
}
