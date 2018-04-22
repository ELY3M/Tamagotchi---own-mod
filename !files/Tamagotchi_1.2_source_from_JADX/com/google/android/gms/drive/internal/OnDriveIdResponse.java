package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Creator<OnDriveIdResponse> CREATOR = new zzaz();
    final int mVersionCode;
    DriveId zzaqj;

    OnDriveIdResponse(int versionCode, DriveId driveId) {
        this.mVersionCode = versionCode;
        this.zzaqj = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzaqj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaz.zza(this, dest, flags);
    }
}
