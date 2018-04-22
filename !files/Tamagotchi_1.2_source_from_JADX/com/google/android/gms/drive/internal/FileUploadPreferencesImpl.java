package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
    public static final Creator<FileUploadPreferencesImpl> CREATOR = new zzag();
    final int mVersionCode;
    int zzarG;
    int zzarH;
    boolean zzarI;

    FileUploadPreferencesImpl(int versionCode, int networkTypePreference, int batteryUsagePreference, boolean allowRoaming) {
        this.mVersionCode = versionCode;
        this.zzarG = networkTypePreference;
        this.zzarH = batteryUsagePreference;
        this.zzarI = allowRoaming;
    }

    public static boolean zzdj(int i) {
        switch (i) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzdk(int i) {
        switch (i) {
            case 256:
            case 257:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getBatteryUsagePreference() {
        return !zzdk(this.zzarH) ? 0 : this.zzarH;
    }

    public int getNetworkTypePreference() {
        return !zzdj(this.zzarG) ? 0 : this.zzarG;
    }

    public boolean isRoamingAllowed() {
        return this.zzarI;
    }

    public void setBatteryUsagePreference(int batteryUsagePreference) {
        if (zzdk(batteryUsagePreference)) {
            this.zzarH = batteryUsagePreference;
            return;
        }
        throw new IllegalArgumentException("Invalid battery usage preference value.");
    }

    public void setNetworkTypePreference(int networkTypePreference) {
        if (zzdj(networkTypePreference)) {
            this.zzarG = networkTypePreference;
            return;
        }
        throw new IllegalArgumentException("Invalid data connection preference value.");
    }

    public void setRoamingAllowed(boolean allowRoaming) {
        this.zzarI = allowRoaming;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzag.zza(this, parcel, flags);
    }
}
