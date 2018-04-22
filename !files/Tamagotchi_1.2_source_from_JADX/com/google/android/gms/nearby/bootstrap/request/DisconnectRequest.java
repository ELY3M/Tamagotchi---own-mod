package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzqg.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class DisconnectRequest implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    final int versionCode;
    private final Device zzbaS;
    private final zzqg zzbaV;

    DisconnectRequest(int versionCode, Device device, IBinder callback) {
        this.versionCode = versionCode;
        this.zzbaS = (Device) zzx.zzz(device);
        zzx.zzz(callback);
        this.zzbaV = zza.zzds(callback);
    }

    public int describeContents() {
        zzd com_google_android_gms_nearby_bootstrap_request_zzd = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzbaV.asBinder();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd com_google_android_gms_nearby_bootstrap_request_zzd = CREATOR;
        zzd.zza(this, out, flags);
    }

    public Device zzEd() {
        return this.zzbaS;
    }
}
