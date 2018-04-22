package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;

public class DisableFitRequest implements SafeParcelable {
    public static final Creator<DisableFitRequest> CREATOR = new zzo();
    private final int mVersionCode;
    private final zzow zzaAD;

    DisableFitRequest(int versionCode, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzaAD = zza.zzbR(callback);
    }

    public DisableFitRequest(zzow callback) {
        this.mVersionCode = 2;
        this.zzaAD = callback;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAD.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("DisableFitRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzo.zza(this, parcel, flags);
    }
}
