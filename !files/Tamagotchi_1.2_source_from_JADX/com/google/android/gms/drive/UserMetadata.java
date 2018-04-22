package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata implements SafeParcelable {
    public static final Creator<UserMetadata> CREATOR = new zzl();
    final int mVersionCode;
    final String zzWQ;
    final String zzaps;
    final String zzapt;
    final boolean zzapu;
    final String zzapv;

    UserMetadata(int versionCode, String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this.mVersionCode = versionCode;
        this.zzaps = permissionId;
        this.zzWQ = displayName;
        this.zzapt = pictureUrl;
        this.zzapu = isAuthenticatedUser;
        this.zzapv = emailAddress;
    }

    public UserMetadata(String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this(1, permissionId, displayName, pictureUrl, isAuthenticatedUser, emailAddress);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.zzaps, this.zzWQ, this.zzapt, Boolean.valueOf(this.zzapu), this.zzapv});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }
}
