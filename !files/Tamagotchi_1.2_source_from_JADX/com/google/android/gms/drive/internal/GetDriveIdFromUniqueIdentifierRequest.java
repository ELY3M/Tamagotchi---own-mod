package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
    public static final Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new zzai();
    final int mVersionCode;
    final String zzaoZ;
    final boolean zzarM;

    GetDriveIdFromUniqueIdentifierRequest(int versionCode, String uniqueIdentifier, boolean isInAppFolder) {
        this.mVersionCode = versionCode;
        this.zzaoZ = uniqueIdentifier;
        this.zzarM = isInAppFolder;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzai.zza(this, dest, flags);
    }
}
