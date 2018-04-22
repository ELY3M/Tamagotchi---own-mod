package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;

public class MessageWrapper implements SafeParcelable {
    public static final zzl CREATOR = new zzl();
    final int mVersionCode;
    public final Message zzbcu;

    MessageWrapper(int versionCode, Message message) {
        this.mVersionCode = versionCode;
        this.zzbcu = (Message) zzx.zzz(message);
    }

    public static final MessageWrapper zzb(Message message) {
        return new MessageWrapper(1, message);
    }

    public int describeContents() {
        zzl com_google_android_gms_nearby_messages_internal_zzl = CREATOR;
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageWrapper)) {
            return false;
        }
        return zzw.equal(this.zzbcu, ((MessageWrapper) o).zzbcu);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbcu);
    }

    public void writeToParcel(Parcel out, int flags) {
        zzl com_google_android_gms_nearby_messages_internal_zzl = CREATOR;
        zzl.zza(this, out, flags);
    }
}
