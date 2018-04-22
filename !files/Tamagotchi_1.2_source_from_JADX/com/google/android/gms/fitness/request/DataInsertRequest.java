package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;

public class DataInsertRequest implements SafeParcelable {
    public static final Creator<DataInsertRequest> CREATOR = new zze();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final boolean zzaAJ;
    private final DataSet zzaxn;

    DataInsertRequest(int versionCode, DataSet dataSet, IBinder callback, boolean skipSync) {
        this.mVersionCode = versionCode;
        this.zzaxn = dataSet;
        this.zzaAD = zza.zzbR(callback);
        this.zzaAJ = skipSync;
    }

    public DataInsertRequest(DataSet dataSet, zzow callback, boolean skipSync) {
        this.mVersionCode = 4;
        this.zzaxn = dataSet;
        this.zzaAD = callback;
        this.zzaAJ = skipSync;
    }

    private boolean zzc(DataInsertRequest dataInsertRequest) {
        return zzw.equal(this.zzaxn, dataInsertRequest.zzaxn);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataInsertRequest) && zzc((DataInsertRequest) o));
    }

    public IBinder getCallbackBinder() {
        return this.zzaAD == null ? null : this.zzaAD.asBinder();
    }

    public DataSet getDataSet() {
        return this.zzaxn;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaxn);
    }

    public String toString() {
        return zzw.zzy(this).zzg("dataSet", this.zzaxn).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }

    public boolean zzuO() {
        return this.zzaAJ;
    }
}
