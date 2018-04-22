package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zze.zza;

public final class PublishRequest implements SafeParcelable {
    public static final Creator<PublishRequest> CREATOR = new zzq();
    final int mVersionCode;
    @Deprecated
    public final String zzbbF;
    public final boolean zzbbG;
    @Deprecated
    public final boolean zzbbH;
    public final MessageWrapper zzbcT;
    public final Strategy zzbcU;
    public final zzg zzbcV;
    @Deprecated
    public final String zzbco;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;

    PublishRequest(int versionCode, MessageWrapper messageWrapper, Strategy strategy, IBinder callbackAsBinder, String zeroPartyPackageName, String realClientPackageName, boolean isIgnoreNearbyPermission, IBinder publishCallbackAsBinder, boolean useRealClientApiKey, ClientAppContext clientAppContext) {
        this.mVersionCode = versionCode;
        this.zzbcT = messageWrapper;
        this.zzbcU = strategy;
        this.zzbcr = zza.zzdz(callbackAsBinder);
        this.zzbbF = zeroPartyPackageName;
        this.zzbco = realClientPackageName;
        this.zzbbG = isIgnoreNearbyPermission;
        this.zzbcV = publishCallbackAsBinder == null ? null : zzg.zza.zzdB(publishCallbackAsBinder);
        this.zzbbH = useRealClientApiKey;
        if (clientAppContext == null) {
            clientAppContext = new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH);
        }
        this.zzbcs = clientAppContext;
    }

    PublishRequest(MessageWrapper messageWrapper, Strategy strategy, IBinder callbackAsBinder, boolean isIgnoreNearbyPermission, IBinder publishCallbackAsBinder, ClientAppContext clientAppContext) {
        this(2, messageWrapper, strategy, callbackAsBinder, null, null, isIgnoreNearbyPermission, publishCallbackAsBinder, false, clientAppContext);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbcr.asBinder();
    }

    IBinder zzEF() {
        return this.zzbcV == null ? null : this.zzbcV.asBinder();
    }
}
