package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zze.zza;

public final class RegisterStatusCallbackRequest implements SafeParcelable {
    public static final Creator<RegisterStatusCallbackRequest> CREATOR = new zzr();
    final int versionCode;
    @Deprecated
    public String zzbbF;
    public final zzh zzbcW;
    public boolean zzbcX;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;

    RegisterStatusCallbackRequest(int versionCode, IBinder callbackAsBinder, IBinder statusCallbackAsBinder, boolean isRegister, String zeroPartyPackageName, ClientAppContext clientAppContext) {
        this.versionCode = versionCode;
        this.zzbcr = zza.zzdz(callbackAsBinder);
        this.zzbcW = zzh.zza.zzdC(statusCallbackAsBinder);
        this.zzbcX = isRegister;
        this.zzbbF = zeroPartyPackageName;
        if (clientAppContext == null) {
            clientAppContext = new ClientAppContext(null, this.zzbbF);
        }
        this.zzbcs = clientAppContext;
    }

    RegisterStatusCallbackRequest(IBinder callbackAsBinder, IBinder statusCallbackAsBinder, ClientAppContext clientAppContext) {
        this(1, callbackAsBinder, statusCallbackAsBinder, false, null, clientAppContext);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzr.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbcr.asBinder();
    }

    IBinder zzEG() {
        return this.zzbcW.asBinder();
    }
}
