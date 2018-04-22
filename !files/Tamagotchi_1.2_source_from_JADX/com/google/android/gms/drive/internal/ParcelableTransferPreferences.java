package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableTransferPreferences implements SafeParcelable {
    public static final Creator<ParcelableTransferPreferences> CREATOR = new zzbn();
    final int mVersionCode;
    final int zzarG;
    final int zzarH;
    final boolean zzasA;

    ParcelableTransferPreferences(int versionCode, int networkTypePreference, int batteryUsagePreference, boolean isRoamingAllowed) {
        this.mVersionCode = versionCode;
        this.zzarG = networkTypePreference;
        this.zzarH = batteryUsagePreference;
        this.zzasA = isRoamingAllowed;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbn.zza(this, dest, flags);
    }
}
