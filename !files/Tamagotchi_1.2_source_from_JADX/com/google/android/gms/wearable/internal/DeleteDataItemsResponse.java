package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DeleteDataItemsResponse implements SafeParcelable {
    public static final Creator<DeleteDataItemsResponse> CREATOR = new zzag();
    public final int statusCode;
    public final int versionCode;
    public final int zzbsz;

    DeleteDataItemsResponse(int versionCode, int statusCode, int numDeleted) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsz = numDeleted;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzag.zza(this, dest, flags);
    }
}
