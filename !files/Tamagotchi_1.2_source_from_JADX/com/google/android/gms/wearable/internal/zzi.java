package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza.zza;
import com.google.android.gms.wearable.Wearable;

abstract class zzi<R extends Result> extends zza<R, zzbp> {
    public zzi(GoogleApiClient googleApiClient) {
        super(Wearable.zzUI, googleApiClient);
    }
}
