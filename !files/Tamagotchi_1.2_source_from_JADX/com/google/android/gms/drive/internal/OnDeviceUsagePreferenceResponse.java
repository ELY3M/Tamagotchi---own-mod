package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
    public static final Creator<OnDeviceUsagePreferenceResponse> CREATOR = new zzax();
    final int mVersionCode;
    final FileUploadPreferencesImpl zzasg;

    OnDeviceUsagePreferenceResponse(int versionCode, FileUploadPreferencesImpl preferences) {
        this.mVersionCode = versionCode;
        this.zzasg = preferences;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzax.zza(this, dest, flags);
    }

    public FileUploadPreferencesImpl zztp() {
        return this.zzasg;
    }
}
