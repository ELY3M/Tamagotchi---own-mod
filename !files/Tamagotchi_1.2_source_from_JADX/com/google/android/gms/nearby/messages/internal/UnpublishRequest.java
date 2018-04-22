package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zze.zza;

public final class UnpublishRequest implements SafeParcelable {
    public static final Creator<UnpublishRequest> CREATOR = new zzt();
    final int mVersionCode;
    @Deprecated
    public final String zzbbF;
    @Deprecated
    public final boolean zzbbH;
    public final MessageWrapper zzbcT;
    @Deprecated
    public final String zzbco;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;

    UnpublishRequest(int versionCode, MessageWrapper messageWrapper, IBinder callbackAsBinder, String zeroPartyPackageName, String realClientPackageName, boolean useRealClientApiKey, ClientAppContext clientAppContext) {
        this.mVersionCode = versionCode;
        this.zzbcT = messageWrapper;
        this.zzbcr = zza.zzdz(callbackAsBinder);
        this.zzbbF = zeroPartyPackageName;
        this.zzbco = realClientPackageName;
        this.zzbbH = useRealClientApiKey;
        if (clientAppContext == null) {
            clientAppContext = new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH);
        }
        this.zzbcs = clientAppContext;
    }

    UnpublishRequest(MessageWrapper messageWrapper, IBinder callbackAsBinder, ClientAppContext clientAppContext) {
        this(1, messageWrapper, callbackAsBinder, null, null, false, clientAppContext);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzt.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbcr.asBinder();
    }
}
