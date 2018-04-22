package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFolderRequest implements SafeParcelable {
    public static final Creator<CreateFolderRequest> CREATOR = new zzo();
    final int mVersionCode;
    final MetadataBundle zzaqw;
    final DriveId zzaqy;

    CreateFolderRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata) {
        this.mVersionCode = versionCode;
        this.zzaqy = (DriveId) zzx.zzz(parentDriveId);
        this.zzaqw = (MetadataBundle) zzx.zzz(metadata);
    }

    public CreateFolderRequest(DriveId parentDriveId, MetadataBundle metadata) {
        this(1, parentDriveId, metadata);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }
}
