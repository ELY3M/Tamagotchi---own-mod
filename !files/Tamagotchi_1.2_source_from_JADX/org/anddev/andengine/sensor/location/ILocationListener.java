package org.anddev.andengine.sensor.location;

import android.location.Location;
import android.os.Bundle;

public interface ILocationListener {
    void onLocationChanged(Location location);

    void onLocationLost();

    void onLocationProviderDisabled();

    void onLocationProviderEnabled();

    void onLocationProviderStatusChanged(LocationProviderStatus locationProviderStatus, Bundle bundle);
}
