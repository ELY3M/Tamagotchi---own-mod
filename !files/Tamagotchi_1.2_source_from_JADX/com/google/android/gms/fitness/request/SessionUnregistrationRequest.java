package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;

public class SessionUnregistrationRequest implements SafeParcelable {
    public static final Creator<SessionUnregistrationRequest> CREATOR = new zzac();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;

    SessionUnregistrationRequest(int versionCode, PendingIntent intent, IBinder callback) {
        this.mVersionCode = versionCode;
        this.mPendingIntent = intent;
        this.zzaAD = zza.zzbR(callback);
    }

    public SessionUnregistrationRequest(PendingIntent pendingIntent, zzow callback) {
        this.mVersionCode = 5;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = callback;
    }

    private boolean zzb(SessionUnregistrationRequest sessionUnregistrationRequest) {
        return zzw.equal(this.mPendingIntent, sessionUnregistrationRequest.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionUnregistrationRequest) && zzb((SessionUnregistrationRequest) that));
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

    public int hashCode() {
        return zzw.hashCode(this.mPendingIntent);
    }

    public String toString() {
        return zzw.zzy(this).zzg("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzac.zza(this, parcel, flags);
    }
}
