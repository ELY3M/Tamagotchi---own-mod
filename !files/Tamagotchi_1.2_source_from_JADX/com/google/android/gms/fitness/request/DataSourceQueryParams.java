package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceQueryParams implements SafeParcelable {
    public static final Creator<DataSourceQueryParams> CREATOR = new zzg();
    final int mVersionCode;
    public final long zzUZ;
    public final int zzaAO;
    public final long zzaAT;
    public final int zzaAU;
    public final DataSource zzavU;
    public final long zzawk;

    DataSourceQueryParams(int versionCode, DataSource dataSource, long id, long startTimeNanos, long endTimeNanos, int limit, int readBehind) {
        this.mVersionCode = versionCode;
        this.zzavU = dataSource;
        this.zzUZ = id;
        this.zzawk = startTimeNanos;
        this.zzaAT = endTimeNanos;
        this.zzaAO = limit;
        this.zzaAU = readBehind;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
