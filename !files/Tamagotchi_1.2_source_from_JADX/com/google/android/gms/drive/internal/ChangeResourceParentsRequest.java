package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class ChangeResourceParentsRequest implements SafeParcelable {
    public static final Creator<ChangeResourceParentsRequest> CREATOR = new zzf();
    final int mVersionCode;
    final DriveId zzaqf;
    final List<DriveId> zzaqg;
    final List<DriveId> zzaqh;

    ChangeResourceParentsRequest(int versionCode, DriveId targetId, List<DriveId> parentIdsToAdd, List<DriveId> parentIdsToRemove) {
        this.mVersionCode = versionCode;
        this.zzaqf = targetId;
        this.zzaqg = parentIdsToAdd;
        this.zzaqh = parentIdsToRemove;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }
}
