package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;

public class DataTypeResult implements Result, SafeParcelable {
    public static final Creator<DataTypeResult> CREATOR = new zzg();
    private final int mVersionCode;
    private final Status zzUX;
    private final DataType zzavT;

    DataTypeResult(int versionCode, Status status, DataType dataType) {
        this.mVersionCode = versionCode;
        this.zzUX = status;
        this.zzavT = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.mVersionCode = 2;
        this.zzUX = status;
        this.zzavT = dataType;
    }

    public static DataTypeResult zzS(Status status) {
        return new DataTypeResult(status, null);
    }

    private boolean zzb(DataTypeResult dataTypeResult) {
        return this.zzUX.equals(dataTypeResult.zzUX) && zzw.equal(this.zzavT, dataTypeResult.zzavT);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataTypeResult) && zzb((DataTypeResult) that));
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzavT);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("dataType", this.zzavT).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
