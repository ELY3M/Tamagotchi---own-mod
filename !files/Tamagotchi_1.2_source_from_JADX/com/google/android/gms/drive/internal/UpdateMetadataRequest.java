package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest implements SafeParcelable {
    public static final Creator<UpdateMetadataRequest> CREATOR = new zzca();
    final int mVersionCode;
    final DriveId zzaqj;
    final MetadataBundle zzaqk;

    UpdateMetadataRequest(int versionCode, DriveId id, MetadataBundle metadataChangeSet) {
        this.mVersionCode = versionCode;
        this.zzaqj = id;
        this.zzaqk = metadataChangeSet;
    }

    public UpdateMetadataRequest(DriveId id, MetadataBundle metadataChangeSet) {
        this(1, id, metadataChangeSet);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzca.zza(this, dest, flags);
    }
}
