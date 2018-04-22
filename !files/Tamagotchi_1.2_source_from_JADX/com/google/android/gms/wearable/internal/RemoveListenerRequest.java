package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzaw.zza;

public class RemoveListenerRequest implements SafeParcelable {
    public static final Creator<RemoveListenerRequest> CREATOR = new zzbg();
    final int mVersionCode;
    public final zzaw zzbrB;

    RemoveListenerRequest(int versionCode, IBinder listener) {
        this.mVersionCode = versionCode;
        if (listener != null) {
            this.zzbrB = zza.zzet(listener);
        } else {
            this.zzbrB = null;
        }
    }

    public RemoveListenerRequest(zzaw listener) {
        this.mVersionCode = 1;
        this.zzbrB = listener;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbg.zza(this, dest, flags);
    }

    IBinder zzIy() {
        return this.zzbrB == null ? null : this.zzbrB.asBinder();
    }
}
