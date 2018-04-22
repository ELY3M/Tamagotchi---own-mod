package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class AddPermissionRequest implements SafeParcelable {
    public static final Creator<AddPermissionRequest> CREATOR = new zzb();
    final int mVersionCode;
    final String zzaoV;
    final DriveId zzaoz;
    final Permission zzaqa;
    final boolean zzaqb;
    final String zzaqc;
    final boolean zzaqd;

    AddPermissionRequest(int versionCode, DriveId driveId, Permission permission, boolean sendNotificationEmail, String emailMessage, boolean sendEventOnCompletion, String trackingTag) {
        this.mVersionCode = versionCode;
        this.zzaoz = driveId;
        this.zzaqa = permission;
        this.zzaqb = sendNotificationEmail;
        this.zzaqc = emailMessage;
        this.zzaqd = sendEventOnCompletion;
        this.zzaoV = trackingTag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
