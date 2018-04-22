package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;

public class DeleteAllUserDataRequest implements SafeParcelable {
    public static final Creator<DeleteAllUserDataRequest> CREATOR = new zzn();
    private final int mVersionCode;
    private final zzow zzaAD;

    DeleteAllUserDataRequest(int versionCode, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzaAD = zza.zzbR(callback);
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
        zzn.zza(this, parcel, flags);
    }
}
