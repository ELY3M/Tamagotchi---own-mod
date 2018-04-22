package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest implements SafeParcelable {
    public static final Creator<OpenContentsRequest> CREATOR = new zzbk();
    final int mVersionCode;
    final int zzaoy;
    final DriveId zzaqj;
    final int zzasx;

    OpenContentsRequest(int versionCode, DriveId id, int mode, int baseRequestId) {
        this.mVersionCode = versionCode;
        this.zzaqj = id;
        this.zzaoy = mode;
        this.zzasx = baseRequestId;
    }

    public OpenContentsRequest(DriveId id, int mode, int baseRequestId) {
        this(1, id, mode, baseRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbk.zza(this, dest, flags);
    }
}
