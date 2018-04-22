package org.anddev.andengine.sensor.location;

import android.location.Criteria;

public class LocationSensorOptions extends Criteria {
    private static final long MINIMUMTRIGGERDISTANCE_DEFAULT = 10;
    private static final long MINIMUMTRIGGERTIME_DEFAULT = 1000;
    private boolean mEnabledOnly = true;
    private long mMinimumTriggerDistance = MINIMUMTRIGGERDISTANCE_DEFAULT;
    private long mMinimumTriggerTime = 1000;

    public LocationSensorOptions(int pAccuracy, boolean pAltitudeRequired, boolean pBearingRequired, boolean pCostAllowed, int pPowerRequirement, boolean pSpeedRequired, boolean pEnabledOnly, long pMinimumTriggerTime, long pMinimumTriggerDistance) {
        this.mEnabledOnly = pEnabledOnly;
        this.mMinimumTriggerTime = pMinimumTriggerTime;
        this.mMinimumTriggerDistance = pMinimumTriggerDistance;
        setAccuracy(pAccuracy);
        setAltitudeRequired(pAltitudeRequired);
        setBearingRequired(pBearingRequired);
        setCostAllowed(pCostAllowed);
        setPowerRequirement(pPowerRequirement);
        setSpeedRequired(pSpeedRequired);
    }

    public void setEnabledOnly(boolean pEnabledOnly) {
        this.mEnabledOnly = pEnabledOnly;
    }

    public boolean isEnabledOnly() {
        return this.mEnabledOnly;
    }

    public long getMinimumTriggerTime() {
        return this.mMinimumTriggerTime;
    }

    public void setMinimumTriggerTime(long pMinimumTriggerTime) {
        this.mMinimumTriggerTime = pMinimumTriggerTime;
    }

    public long getMinimumTriggerDistance() {
        return this.mMinimumTriggerDistance;
    }

    public void setMinimumTriggerDistance(long pMinimumTriggerDistance) {
        this.mMinimumTriggerDistance = pMinimumTriggerDistance;
    }
}
