package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.zzh;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR = new zzn();
    final int mVersionCode;
    final String zzaoV;
    final String zzaoY;
    final int zzaqA;
    final boolean zzaqd;
    final Contents zzaql;
    final MetadataBundle zzaqw;
    final Integer zzaqx;
    final DriveId zzaqy;
    final int zzaqz;

    CreateFileRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference, Integer fileType, boolean sendEventOnCompletion, String trackingTag, int createStrategy, int openContentsRequestId, String convertTo) {
        if (!(contentsReference == null || openContentsRequestId == 0)) {
            zzx.zzb(contentsReference.getRequestId() == openContentsRequestId, (Object) "inconsistent contents reference");
        }
        if ((fileType == null || fileType.intValue() == 0) && contentsReference == null && openContentsRequestId == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.mVersionCode = versionCode;
        this.zzaqy = (DriveId) zzx.zzz(parentDriveId);
        this.zzaqw = (MetadataBundle) zzx.zzz(metadata);
        this.zzaql = contentsReference;
        this.zzaqx = fileType;
        this.zzaoV = trackingTag;
        this.zzaqz = createStrategy;
        this.zzaqd = sendEventOnCompletion;
        this.zzaqA = openContentsRequestId;
        this.zzaoY = convertTo;
    }

    public CreateFileRequest(DriveId parentDriveId, MetadataBundle metadata, int openContentsRequestId, int fileType, zzh fileCreationOptions) {
        this(2, parentDriveId, metadata, null, Integer.valueOf(fileType), fileCreationOptions.zzsC(), fileCreationOptions.zzsB(), fileCreationOptions.zzsD(), openContentsRequestId, fileCreationOptions.zzsF());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }
}
