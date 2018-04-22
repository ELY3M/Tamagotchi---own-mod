package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class MessageEventParcelable implements SafeParcelable, MessageEvent {
    public static final Creator<MessageEventParcelable> CREATOR = new zzba();
    private final String mPath;
    final int mVersionCode;
    private final byte[] zzaKm;
    private final String zzaPI;
    private final int zzaox;

    MessageEventParcelable(int versionCode, int requestId, String path, byte[] data, String source) {
        this.mVersionCode = versionCode;
        this.zzaox = requestId;
        this.mPath = path;
        this.zzaKm = data;
        this.zzaPI = source;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.zzaKm;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getRequestId() {
        return this.zzaox;
    }

    public String getSourceNodeId() {
        return this.zzaPI;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.zzaox + "," + this.mPath + ", size=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzba.zza(this, dest, flags);
    }
}
