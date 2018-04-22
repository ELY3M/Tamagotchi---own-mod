package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PutDataResponse implements SafeParcelable {
    public static final Creator<PutDataResponse> CREATOR = new zzbf();
    public final int statusCode;
    public final int versionCode;
    public final DataItemParcelable zzbsJ;

    PutDataResponse(int versionCode, int statusCode, DataItemParcelable dataItem) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsJ = dataItem;
    }

    public PutDataResponse(int statusCode, DataItemParcelable dataItem) {
        this(1, statusCode, dataItem);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbf.zza(this, dest, flags);
    }
}
