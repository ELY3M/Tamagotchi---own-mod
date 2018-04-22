package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnSyncMoreResponse implements SafeParcelable {
    public static final Creator<OnSyncMoreResponse> CREATOR = new zzbj();
    final int mVersionCode;
    final boolean zzaqJ;

    OnSyncMoreResponse(int versionCode, boolean moreEntriesMayExist) {
        this.mVersionCode = versionCode;
        this.zzaqJ = moreEntriesMayExist;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbj.zza(this, dest, flags);
    }
}
