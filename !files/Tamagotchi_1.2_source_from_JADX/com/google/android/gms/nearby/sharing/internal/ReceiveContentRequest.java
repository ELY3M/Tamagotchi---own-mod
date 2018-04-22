package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zza.zza;

public final class ReceiveContentRequest implements SafeParcelable {
    public static final Creator<ReceiveContentRequest> CREATOR = new zzg();
    public String packageName;
    final int versionCode;
    public IBinder zzbdk;
    public zzc zzbdo;
    public zza zzbdp;

    ReceiveContentRequest() {
        this.versionCode = 1;
    }

    ReceiveContentRequest(int versionCode, IBinder clientBinder, IBinder contentReceiverAsBinder, String packageName, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzbdk = clientBinder;
        this.zzbdp = zza.zzdF(contentReceiverAsBinder);
        this.packageName = packageName;
        this.zzbdo = zzc.zza.zzdH(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbdo.asBinder();
    }

    IBinder zzEQ() {
        return this.zzbdp == null ? null : this.zzbdp.asBinder();
    }
}
