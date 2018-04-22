package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceStatsResult implements SafeParcelable {
    public static final Creator<DataSourceStatsResult> CREATOR = new zzd();
    final int mVersionCode;
    public final long zzUZ;
    public final boolean zzaBI;
    public final long zzaBJ;
    public final long zzaBK;
    public final DataSource zzavU;

    DataSourceStatsResult(int versionCode, DataSource dataSource, long id, boolean isRemote, long minEndTimeNanos, long maxEndTimeNanos) {
        this.mVersionCode = versionCode;
        this.zzavU = dataSource;
        this.zzUZ = id;
        this.zzaBI = isRemote;
        this.zzaBJ = minEndTimeNanos;
        this.zzaBK = maxEndTimeNanos;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
