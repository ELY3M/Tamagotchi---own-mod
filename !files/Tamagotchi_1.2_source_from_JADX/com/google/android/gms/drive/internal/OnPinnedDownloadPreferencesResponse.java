package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnPinnedDownloadPreferencesResponse implements SafeParcelable {
    public static final Creator<OnPinnedDownloadPreferencesResponse> CREATOR = new zzbf();
    final int mVersionCode;
    final ParcelableTransferPreferences zzasu;

    OnPinnedDownloadPreferencesResponse(int versionCode, ParcelableTransferPreferences prefs) {
        this.mVersionCode = versionCode;
        this.zzasu = prefs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbf.zza(this, dest, flags);
    }
}
