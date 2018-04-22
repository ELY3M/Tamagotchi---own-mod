package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.sharing.internal.zzc.zza;

public final class TrustedDevicesRequest implements SafeParcelable {
    public static final Creator<TrustedDevicesRequest> CREATOR = new zzk();
    final int versionCode;
    public zzc zzbdo;
    public String zzbdq;
    public byte[] zzbdr;

    TrustedDevicesRequest(int versionCode, String deviceIdentifier, byte[] message, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzbdq = (String) zzx.zzz(deviceIdentifier);
        this.zzbdr = (byte[]) zzx.zzz(message);
        this.zzbdo = zza.zzdH(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbdo.asBinder();
    }
}
