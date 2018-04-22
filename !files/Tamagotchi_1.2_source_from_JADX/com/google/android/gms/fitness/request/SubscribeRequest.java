package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;

public class SubscribeRequest implements SafeParcelable {
    public static final Creator<SubscribeRequest> CREATOR = new zzaf();
    private final int mVersionCode;
    private final zzow zzaAD;
    private Subscription zzaBC;
    private final boolean zzaBD;

    SubscribeRequest(int versionCode, Subscription subscription, boolean serverOnly, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzaBC = subscription;
        this.zzaBD = serverOnly;
        this.zzaAD = zza.zzbR(callback);
    }

    public SubscribeRequest(Subscription subscription, boolean serverOnly, zzow callback) {
        this.mVersionCode = 3;
        this.zzaBC = subscription;
        this.zzaBD = serverOnly;
        this.zzaAD = callback;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAD == null ? null : this.zzaAD.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzw.zzy(this).zzg("subscription", this.zzaBC).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaf.zza(this, dest, flags);
    }

    public Subscription zzvh() {
        return this.zzaBC;
    }

    public boolean zzvi() {
        return this.zzaBD;
    }
}
