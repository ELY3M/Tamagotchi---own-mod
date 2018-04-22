package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Permission;
import java.util.List;

public class GetPermissionsResponse implements SafeParcelable {
    public static final Creator<GetPermissionsResponse> CREATOR = new zzal();
    final int mVersionCode;
    final List<Permission> zzarO;
    final int zzzw;

    GetPermissionsResponse(int versionCode, List<Permission> permissionList, int responseCode) {
        this.mVersionCode = versionCode;
        this.zzarO = permissionList;
        this.zzzw = responseCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzal.zza(this, dest, flags);
    }
}
