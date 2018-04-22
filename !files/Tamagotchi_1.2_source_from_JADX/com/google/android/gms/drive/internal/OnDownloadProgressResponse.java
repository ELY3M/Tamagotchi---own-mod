package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFileRange;
import java.util.Collections;
import java.util.List;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Creator<OnDownloadProgressResponse> CREATOR = new zzay();
    private static final List<DriveFileRange> zzash = Collections.emptyList();
    final int mVersionCode;
    final int zzBc;
    final long zzasi;
    final long zzasj;
    final List<DriveFileRange> zzask;

    OnDownloadProgressResponse(int versionCode, long bytesLoaded, long bytesExpected, int status, List<DriveFileRange> rangesAvailable) {
        this.mVersionCode = versionCode;
        this.zzasi = bytesLoaded;
        this.zzasj = bytesExpected;
        this.zzBc = status;
        this.zzask = rangesAvailable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzay.zza(this, dest, flags);
    }

    public long zztq() {
        return this.zzasi;
    }

    public long zztr() {
        return this.zzasj;
    }
}
