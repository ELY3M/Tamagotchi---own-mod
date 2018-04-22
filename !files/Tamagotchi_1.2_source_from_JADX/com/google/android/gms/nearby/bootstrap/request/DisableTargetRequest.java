package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzqg.zza;

public class DisableTargetRequest implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int versionCode;
    private final zzqg zzbaV;

    DisableTargetRequest(int versionCode, IBinder callback) {
        this.versionCode = versionCode;
        zzx.zzz(callback);
        this.zzbaV = zza.zzds(callback);
    }

    public int describeContents() {
        zzc com_google_android_gms_nearby_bootstrap_request_zzc = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzbaV == null ? null : this.zzbaV.asBinder();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc com_google_android_gms_nearby_bootstrap_request_zzc = CREATOR;
        zzc.zza(this, out, flags);
    }
}
