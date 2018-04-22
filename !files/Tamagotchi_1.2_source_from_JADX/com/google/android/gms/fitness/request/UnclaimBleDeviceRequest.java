package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;

public class UnclaimBleDeviceRequest implements SafeParcelable {
    public static final Creator<UnclaimBleDeviceRequest> CREATOR = new zzag();
    private final int mVersionCode;
    private final String zzaAB;
    private final zzow zzaAD;

    UnclaimBleDeviceRequest(int versionCode, String deviceAddress, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzaAB = deviceAddress;
        this.zzaAD = zza.zzbR(callback);
    }

    public UnclaimBleDeviceRequest(String deviceAddress, zzow callback) {
        this.mVersionCode = 5;
        this.zzaAB = deviceAddress;
        this.zzaAD = callback;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAD == null ? null : this.zzaAD.asBinder();
    }

    public String getDeviceAddress() {
        return this.zzaAB;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[]{this.zzaAB});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzag.zza(this, parcel, flags);
    }
}
