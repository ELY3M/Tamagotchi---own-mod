package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParentDriveIdSet implements SafeParcelable {
    public static final Creator<ParentDriveIdSet> CREATOR = new zzl();
    final int mVersionCode;
    final List<PartialDriveId> zzasS;

    public ParentDriveIdSet() {
        this(1, new ArrayList());
    }

    ParentDriveIdSet(int versionCode, List<PartialDriveId> partialDriveIds) {
        this.mVersionCode = versionCode;
        this.zzasS = partialDriveIds;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzl.zza(this, out, flags);
    }

    public Set<DriveId> zzD(long j) {
        Set<DriveId> hashSet = new HashSet();
        for (PartialDriveId zzE : this.zzasS) {
            hashSet.add(zzE.zzE(j));
        }
        return hashSet;
    }

    public void zza(PartialDriveId partialDriveId) {
        this.zzasS.add(partialDriveId);
    }
}
