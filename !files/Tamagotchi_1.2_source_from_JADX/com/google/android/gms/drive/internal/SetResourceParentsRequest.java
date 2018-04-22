package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
    public static final Creator<SetResourceParentsRequest> CREATOR = new zzbt();
    final int mVersionCode;
    final DriveId zzaqf;
    final List<DriveId> zzasC;

    SetResourceParentsRequest(int versionCode, DriveId targetId, List<DriveId> parentIds) {
        this.mVersionCode = versionCode;
        this.zzaqf = targetId;
        this.zzasC = parentIds;
    }

    public SetResourceParentsRequest(DriveId targetId, List<DriveId> parentIds) {
        this(1, targetId, parentIds);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbt.zza(this, dest, flags);
    }
}
