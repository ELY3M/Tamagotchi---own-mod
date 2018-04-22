package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class MessageType implements SafeParcelable {
    public static final Creator<MessageType> CREATOR = new zzk();
    final int mVersionCode;
    public final String type;
    public final String zzamD;

    MessageType(int versionCode, String namespace, String type) {
        this.mVersionCode = versionCode;
        this.zzamD = namespace;
        this.type = type;
    }

    public MessageType(String namespace, String type) {
        this(1, namespace, type);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageType)) {
            return false;
        }
        MessageType messageType = (MessageType) o;
        return zzw.equal(this.zzamD, messageType.zzamD) && zzw.equal(this.type, messageType.type);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzamD, this.type);
    }

    public String toString() {
        return "namespace=" + this.zzamD + ", type=" + this.type;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
