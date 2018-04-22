package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckResourceIdsExistRequest implements SafeParcelable {
    public static final Creator<CheckResourceIdsExistRequest> CREATOR = new zzg();
    private final int mVersionCode;
    private final List<String> zzaqi;

    CheckResourceIdsExistRequest(int versionCode, List<String> resourceIds) {
        this.mVersionCode = versionCode;
        this.zzaqi = resourceIds;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    public List<String> zztc() {
        return this.zzaqi;
    }
}
