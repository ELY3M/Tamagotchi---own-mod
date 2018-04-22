package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzog;
import com.google.android.gms.internal.zzog.zza;

public class DailyTotalRequest implements SafeParcelable {
    public static final Creator<DailyTotalRequest> CREATOR = new zzc();
    private final int mVersionCode;
    private final zzog zzaAE;
    private DataType zzavT;

    DailyTotalRequest(int versionCode, IBinder callback, DataType dataType) {
        this.mVersionCode = versionCode;
        this.zzaAE = zza.zzbB(callback);
        this.zzavT = dataType;
    }

    public DailyTotalRequest(zzog callback, DataType dataType) {
        this.mVersionCode = 2;
        this.zzaAE = callback;
        this.zzavT = dataType;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAE.asBinder();
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("DailyTotalRequest{%s}", new Object[]{this.zzavT.zzuo()});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzc.zza(this, parcel, flags);
    }
}
