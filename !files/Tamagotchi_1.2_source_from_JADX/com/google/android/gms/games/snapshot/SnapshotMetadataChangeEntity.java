package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    private final int mVersionCode;
    private final Long zzaKO;
    private final Uri zzaKQ;
    private final Long zzaKR;
    private BitmapTeleporter zzaKS;
    private final String zzaxl;

    SnapshotMetadataChangeEntity() {
        this(5, null, null, null, null, null);
    }

    SnapshotMetadataChangeEntity(int versionCode, String description, Long playedTimeMillis, BitmapTeleporter coverImage, Uri coverImageUri, Long progressValue) {
        boolean z = true;
        this.mVersionCode = versionCode;
        this.zzaxl = description;
        this.zzaKR = playedTimeMillis;
        this.zzaKS = coverImage;
        this.zzaKQ = coverImageUri;
        this.zzaKO = progressValue;
        if (this.zzaKS != null) {
            if (this.zzaKQ != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot set both a URI and an image");
        } else if (this.zzaKQ != null) {
            if (this.zzaKS != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChangeEntity(String description, Long playedTimeMillis, BitmapTeleporter coverImage, Uri coverImageUri, Long progressValue) {
        this(5, description, playedTimeMillis, coverImage, coverImageUri, progressValue);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getCoverImage() {
        return this.zzaKS == null ? null : this.zzaKS.zzqa();
    }

    public Uri getCoverImageUri() {
        return this.zzaKQ;
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public Long getPlayedTimeMillis() {
        return this.zzaKR;
    }

    public Long getProgressValue() {
        return this.zzaKO;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataChangeCreator.zza(this, out, flags);
    }

    public BitmapTeleporter zzxU() {
        return this.zzaKS;
    }
}
