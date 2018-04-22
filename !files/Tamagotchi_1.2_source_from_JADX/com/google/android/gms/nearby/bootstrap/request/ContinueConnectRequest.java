package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzqg.zza;

public class ContinueConnectRequest implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int versionCode;
    private final zzqg zzbaV;
    private final String zzbaW;

    ContinueConnectRequest(int versionCode, String token, IBinder callback) {
        this.versionCode = versionCode;
        this.zzbaW = (String) zzx.zzz(token);
        this.zzbaV = zza.zzds(callback);
    }

    public int describeContents() {
        zzb com_google_android_gms_nearby_bootstrap_request_zzb = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzbaV == null ? null : this.zzbaV.asBinder();
    }

    public String getToken() {
        return this.zzbaW;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb com_google_android_gms_nearby_bootstrap_request_zzb = CREATOR;
        zzb.zza(this, out, flags);
    }
}
