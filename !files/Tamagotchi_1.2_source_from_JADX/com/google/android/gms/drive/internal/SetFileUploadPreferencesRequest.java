package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SetFileUploadPreferencesRequest implements SafeParcelable {
    public static final Creator<SetFileUploadPreferencesRequest> CREATOR = new zzbr();
    final int mVersionCode;
    final FileUploadPreferencesImpl zzasg;

    SetFileUploadPreferencesRequest(int versionCode, FileUploadPreferencesImpl preferences) {
        this.mVersionCode = versionCode;
        this.zzasg = preferences;
    }

    public SetFileUploadPreferencesRequest(FileUploadPreferencesImpl preferences) {
        this(1, preferences);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbr.zza(this, dest, flags);
    }
}
