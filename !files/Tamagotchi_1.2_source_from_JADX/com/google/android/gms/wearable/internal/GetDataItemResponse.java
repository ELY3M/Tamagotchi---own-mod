package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDataItemResponse implements SafeParcelable {
    public static final Creator<GetDataItemResponse> CREATOR = new zzar();
    public final int statusCode;
    public final int versionCode;
    public final DataItemParcelable zzbsJ;

    GetDataItemResponse(int versionCode, int statusCode, DataItemParcelable dataItem) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsJ = dataItem;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzar.zza(this, dest, flags);
    }
}
