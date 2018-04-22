package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzor;
import com.google.android.gms.internal.zzor.zza;

public class ListSubscriptionsRequest implements SafeParcelable {
    public static final Creator<ListSubscriptionsRequest> CREATOR = new zzs();
    private final int mVersionCode;
    private final zzor zzaBd;
    private final DataType zzavT;

    ListSubscriptionsRequest(int versionCode, DataType dataType, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzavT = dataType;
        this.zzaBd = zza.zzbM(callback);
    }

    public ListSubscriptionsRequest(DataType dataType, zzor callback) {
        this.mVersionCode = 3;
        this.zzavT = dataType;
        this.zzaBd = callback;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaBd == null ? null : this.zzaBd.asBinder();
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzs.zza(this, parcel, flags);
    }
}
