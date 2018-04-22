package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zzd.zza;

public final class SubscribeRequest implements SafeParcelable {
    public static final Creator<SubscribeRequest> CREATOR = new zzs();
    final int mVersionCode;
    @Deprecated
    public final String zzbbF;
    public final boolean zzbbG;
    @Deprecated
    public final boolean zzbbH;
    public final Strategy zzbcU;
    public final zzd zzbcY;
    public final MessageFilter zzbcZ;
    @Deprecated
    public final String zzbco;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;
    public final PendingIntent zzbda;
    public final int zzbdb;
    public final byte[] zzbdc;
    public final zzi zzbdd;

    SubscribeRequest(int versionCode, IBinder messageListener, Strategy strategy, IBinder callbackAsBinder, MessageFilter filter, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName, byte[] hint, boolean isIgnoreNearbyPermission, IBinder subscribeCallbackAsBinder, boolean useRealClientApiKey, ClientAppContext clientAppContext) {
        this.mVersionCode = versionCode;
        this.zzbcY = zza.zzdy(messageListener);
        this.zzbcU = strategy;
        this.zzbcr = zze.zza.zzdz(callbackAsBinder);
        this.zzbcZ = filter;
        this.zzbda = pendingIntent;
        this.zzbdb = messageListenerKey;
        this.zzbbF = zeroPartyPackageName;
        this.zzbco = realClientPackageName;
        this.zzbdc = hint;
        this.zzbbG = isIgnoreNearbyPermission;
        this.zzbdd = subscribeCallbackAsBinder == null ? null : zzi.zza.zzdD(subscribeCallbackAsBinder);
        this.zzbbH = useRealClientApiKey;
        if (clientAppContext == null) {
            ClientAppContext clientAppContext2 = new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH);
        }
        this.zzbcs = clientAppContext;
    }

    public SubscribeRequest(IBinder messageListener, Strategy strategy, IBinder callbackAsBinder, MessageFilter filter, PendingIntent pendingIntent, int messageListenerKey, byte[] hint, boolean isIgnoreNearbyPermission, IBinder subscribeCallbackAsBinder, ClientAppContext clientAppContext) {
        this(3, messageListener, strategy, callbackAsBinder, filter, pendingIntent, messageListenerKey, null, null, hint, isIgnoreNearbyPermission, subscribeCallbackAsBinder, false, clientAppContext);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzs.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbcr == null ? null : this.zzbcr.asBinder();
    }

    IBinder zzEH() {
        return this.zzbcY == null ? null : this.zzbcY.asBinder();
    }

    IBinder zzEI() {
        return this.zzbdd == null ? null : this.zzbdd.asBinder();
    }
}
