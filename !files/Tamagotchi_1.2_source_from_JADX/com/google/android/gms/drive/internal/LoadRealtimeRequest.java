package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class LoadRealtimeRequest implements SafeParcelable {
    public static final Creator<LoadRealtimeRequest> CREATOR = new zzar();
    final int mVersionCode;
    final DriveId zzaoz;
    final boolean zzarQ;
    final List<String> zzarR;
    final boolean zzarS;
    final DataHolder zzarT;
    final String zzarU;

    LoadRealtimeRequest(int versionCode, DriveId driveId, boolean useTestMode, List<String> customTypeWhitelist, boolean isInMemory, DataHolder json, String localId) {
        this.mVersionCode = versionCode;
        this.zzaoz = driveId;
        this.zzarQ = useTestMode;
        this.zzarR = customTypeWhitelist;
        this.zzarS = isInMemory;
        this.zzarT = json;
        this.zzarU = localId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzar.zza(this, dest, flags);
    }
}
