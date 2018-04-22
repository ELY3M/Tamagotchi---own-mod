package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.data.zzk.zza;
import com.google.android.gms.internal.zzow;

public class SensorUnregistrationRequest implements SafeParcelable {
    public static final Creator<SensorUnregistrationRequest> CREATOR = new zzw();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;
    private final zzk zzaBh;

    SensorUnregistrationRequest(int versionCode, IBinder listenerBinder, PendingIntent pendingIntent, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzaBh = listenerBinder == null ? null : zza.zzbt(listenerBinder);
        this.mPendingIntent = pendingIntent;
        this.zzaAD = zzow.zza.zzbR(callback);
    }

    public SensorUnregistrationRequest(zzk listener, PendingIntent pendingIntent, zzow callback) {
        this.mVersionCode = 4;
        this.zzaBh = listener;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = callback;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAD == null ? null : this.zzaAD.asBinder();
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.zzaBh});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzw.zza(this, parcel, flags);
    }

    IBinder zzvb() {
        return this.zzaBh == null ? null : this.zzaBh.asBinder();
    }
}
