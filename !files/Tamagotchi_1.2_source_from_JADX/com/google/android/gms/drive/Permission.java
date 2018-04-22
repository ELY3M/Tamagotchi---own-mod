package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class Permission implements SafeParcelable {
    public static final Creator<Permission> CREATOR = new zzj();
    final int mVersionCode;
    private String zzapk;
    private int zzapl;
    private String zzapm;
    private String zzapn;
    private int zzapo;
    private boolean zzapp;

    Permission(int versionCode, String accountIdentifier, int accountType, String accountDisplayName, String photoLink, int role, boolean isLinkRequired) {
        this.mVersionCode = versionCode;
        this.zzapk = accountIdentifier;
        this.zzapl = accountType;
        this.zzapm = accountDisplayName;
        this.zzapn = photoLink;
        this.zzapo = role;
        this.zzapp = isLinkRequired;
    }

    public static boolean zzcA(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzcz(int i) {
        switch (i) {
            case 256:
            case 257:
            case CallbackHandler.MSG_ROUTE_REMOVED /*258*/:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        Permission permission = (Permission) o;
        return zzw.equal(this.zzapk, permission.zzapk) && this.zzapl == permission.zzapl && this.zzapo == permission.zzapo && this.zzapp == permission.zzapp;
    }

    public int getRole() {
        return !zzcA(this.zzapo) ? -1 : this.zzapo;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapk, Integer.valueOf(this.zzapl), Integer.valueOf(this.zzapo), Boolean.valueOf(this.zzapp));
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    public String zzsO() {
        return !zzcz(this.zzapl) ? null : this.zzapk;
    }

    public int zzsP() {
        return !zzcz(this.zzapl) ? -1 : this.zzapl;
    }

    public String zzsQ() {
        return this.zzapm;
    }

    public String zzsR() {
        return this.zzapn;
    }

    public boolean zzsS() {
        return this.zzapp;
    }
}
