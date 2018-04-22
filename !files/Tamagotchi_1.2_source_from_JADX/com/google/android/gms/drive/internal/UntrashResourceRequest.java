package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UntrashResourceRequest implements SafeParcelable {
    public static final Creator<UntrashResourceRequest> CREATOR = new zzbz();
    final int mVersionCode;
    final DriveId zzaqj;

    UntrashResourceRequest(int versionCode, DriveId id) {
        this.mVersionCode = versionCode;
        this.zzaqj = id;
    }

    public UntrashResourceRequest(DriveId id) {
        this(1, id);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbz.zza(this, dest, flags);
    }
}
