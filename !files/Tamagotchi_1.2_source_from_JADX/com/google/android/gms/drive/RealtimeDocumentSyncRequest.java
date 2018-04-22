package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class RealtimeDocumentSyncRequest implements SafeParcelable {
    public static final Creator<RealtimeDocumentSyncRequest> CREATOR = new zzk();
    final int mVersionCode;
    final List<String> zzapq;
    final List<String> zzapr;

    RealtimeDocumentSyncRequest(int versionCode, List<String> documentsToSync, List<String> documentsToDeleteCache) {
        this.mVersionCode = versionCode;
        this.zzapq = (List) zzx.zzz(documentsToSync);
        this.zzapr = (List) zzx.zzz(documentsToDeleteCache);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
