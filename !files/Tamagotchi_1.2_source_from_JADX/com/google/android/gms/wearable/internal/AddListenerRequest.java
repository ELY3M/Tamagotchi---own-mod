package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzaw.zza;

public class AddListenerRequest implements SafeParcelable {
    public static final Creator<AddListenerRequest> CREATOR = new zzc();
    final int mVersionCode;
    public final zzaw zzbrB;
    public final IntentFilter[] zzbrC;
    public final String zzbrD;
    public final String zzbrE;

    AddListenerRequest(int versionCode, IBinder listener, IntentFilter[] filters, String channelToken, String capability) {
        this.mVersionCode = versionCode;
        if (listener != null) {
            this.zzbrB = zza.zzet(listener);
        } else {
            this.zzbrB = null;
        }
        this.zzbrC = filters;
        this.zzbrD = channelToken;
        this.zzbrE = capability;
    }

    public AddListenerRequest(zzbq stub) {
        this.mVersionCode = 1;
        this.zzbrB = stub;
        this.zzbrC = stub.zzIO();
        this.zzbrD = stub.zzIP();
        this.zzbrE = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    IBinder zzIy() {
        return this.zzbrB == null ? null : this.zzbrB.asBinder();
    }
}
