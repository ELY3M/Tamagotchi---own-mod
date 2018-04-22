package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza.zza;
import com.google.android.gms.safetynet.SafetyNet;

abstract class zzrb<R extends Result> extends zza<R, zzrf> {
    public zzrb(GoogleApiClient googleApiClient) {
        super(SafetyNet.zzUI, googleApiClient);
    }
}
