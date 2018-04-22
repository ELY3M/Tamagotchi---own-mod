package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest implements SafeParcelable {
    public static final Creator<CloseContentsRequest> CREATOR = new zzi();
    final int mVersionCode;
    final Contents zzaql;
    final int zzaqn;
    final Boolean zzaqp;

    CloseContentsRequest(int versionCode, Contents contentsReference, Boolean saveResults, int contentsRequestId) {
        this.mVersionCode = versionCode;
        this.zzaql = contentsReference;
        this.zzaqp = saveResults;
        this.zzaqn = contentsRequestId;
    }

    public CloseContentsRequest(int contentsRequestId, boolean saveResults) {
        this(1, null, Boolean.valueOf(saveResults), contentsRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
