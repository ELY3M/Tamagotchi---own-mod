package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class zzqs implements PanoramaResult {
    private final Status zzUX;
    private final Intent zzbdv;

    public zzqs(Status status, Intent intent) {
        this.zzUX = (Status) zzx.zzz(status);
        this.zzbdv = intent;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    public Intent getViewerIntent() {
        return this.zzbdv;
    }
}
