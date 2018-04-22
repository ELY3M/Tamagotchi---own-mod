package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.internal.zzqi.zza;

public class StartScanRequest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    final int versionCode;
    private final zzqg zzbaV;
    private final zzqi zzbaY;

    StartScanRequest(int versionCode, IBinder scanListener, IBinder callback) {
        this.versionCode = versionCode;
        zzx.zzz(scanListener);
        this.zzbaY = zza.zzdu(scanListener);
        zzx.zzz(callback);
        this.zzbaV = zzqg.zza.zzds(callback);
    }

    public int describeContents() {
        zzg com_google_android_gms_nearby_bootstrap_request_zzg = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzbaV == null ? null : this.zzbaV.asBinder();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg com_google_android_gms_nearby_bootstrap_request_zzg = CREATOR;
        zzg.zza(this, out, flags);
    }

    public IBinder zzEi() {
        return this.zzbaY == null ? null : this.zzbaY.asBinder();
    }
}
