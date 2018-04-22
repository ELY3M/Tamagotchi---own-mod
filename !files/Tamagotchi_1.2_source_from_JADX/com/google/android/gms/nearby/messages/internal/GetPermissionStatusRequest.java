package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zze.zza;

public class GetPermissionStatusRequest implements SafeParcelable {
    public static final Creator<GetPermissionStatusRequest> CREATOR = new zzb();
    final int mVersionCode;
    @Deprecated
    public final String zzbbF;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;

    GetPermissionStatusRequest(int versionCode, IBinder callbackAsBinder, String zeroPartyPackageName, ClientAppContext clientAppContext) {
        this.mVersionCode = versionCode;
        this.zzbcr = zza.zzdz(callbackAsBinder);
        this.zzbbF = zeroPartyPackageName;
        if (clientAppContext == null) {
            clientAppContext = new ClientAppContext(null, this.zzbbF);
        }
        this.zzbcs = clientAppContext;
    }

    GetPermissionStatusRequest(IBinder callbackAsBinder, ClientAppContext clientAppContext) {
        this(1, callbackAsBinder, null, clientAppContext);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbcr.asBinder();
    }
}
