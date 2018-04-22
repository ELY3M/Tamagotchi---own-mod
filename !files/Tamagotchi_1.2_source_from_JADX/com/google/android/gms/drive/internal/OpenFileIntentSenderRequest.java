package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<OpenFileIntentSenderRequest> CREATOR = new zzbm();
    final int mVersionCode;
    final String zzapg;
    final String[] zzaph;
    final DriveId zzapj;
    final FilterHolder zzasz;

    OpenFileIntentSenderRequest(int versionCode, String title, String[] mimeTypes, DriveId startFolder, FilterHolder filterHolder) {
        this.mVersionCode = versionCode;
        this.zzapg = title;
        this.zzaph = mimeTypes;
        this.zzapj = startFolder;
        this.zzasz = filterHolder;
    }

    public OpenFileIntentSenderRequest(String title, String[] mimeTypes, DriveId startFolder, FilterHolder filterHolder) {
        this(1, title, mimeTypes, startFolder, filterHolder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbm.zza(this, dest, flags);
    }
}
