package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ControlProgressRequest implements SafeParcelable {
    public static final Creator<ControlProgressRequest> CREATOR = new zzj();
    final int mVersionCode;
    final DriveId zzaoz;
    final int zzaqq;
    final int zzaqr;
    final ParcelableTransferPreferences zzaqs;

    ControlProgressRequest(int versionCode, int controllerType, int methodCode, DriveId driveId, ParcelableTransferPreferences transferPreferences) {
        this.mVersionCode = versionCode;
        this.zzaqq = controllerType;
        this.zzaqr = methodCode;
        this.zzaoz = driveId;
        this.zzaqs = transferPreferences;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
