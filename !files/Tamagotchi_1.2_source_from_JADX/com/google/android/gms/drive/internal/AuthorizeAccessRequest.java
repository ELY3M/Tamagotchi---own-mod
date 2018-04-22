package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Creator<AuthorizeAccessRequest> CREATOR = new zzc();
    final int mVersionCode;
    final DriveId zzaoz;
    final long zzaqe;

    AuthorizeAccessRequest(int versionCode, long projectNumber, DriveId driveId) {
        this.mVersionCode = versionCode;
        this.zzaqe = projectNumber;
        this.zzaoz = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
