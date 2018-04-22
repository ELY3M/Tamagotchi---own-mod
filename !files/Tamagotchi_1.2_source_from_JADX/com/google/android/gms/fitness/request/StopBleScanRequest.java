package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzq.zza;
import com.google.android.gms.internal.zzow;

public class StopBleScanRequest implements SafeParcelable {
    public static final Creator<StopBleScanRequest> CREATOR = new zzae();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final zzq zzaBA;

    StopBleScanRequest(int versionCode, IBinder bleScanCallback, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzaBA = zza.zzbU(bleScanCallback);
        this.zzaAD = zzow.zza.zzbR(callback);
    }

    public StopBleScanRequest(BleScanCallback bleScanCallback, zzow callback) {
        this(zza.zza.zzuJ().zzb(bleScanCallback), callback);
    }

    public StopBleScanRequest(zzq bleScanCallback, zzow callback) {
        this.mVersionCode = 3;
        this.zzaBA = bleScanCallback;
        this.zzaAD = callback;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAD == null ? null : this.zzaAD.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzae.zza(this, parcel, flags);
    }

    public IBinder zzvg() {
        return this.zzaBA.asBinder();
    }
}
