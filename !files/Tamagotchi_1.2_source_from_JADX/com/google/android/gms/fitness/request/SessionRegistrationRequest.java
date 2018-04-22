package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;

public class SessionRegistrationRequest implements SafeParcelable {
    public static final Creator<SessionRegistrationRequest> CREATOR = new zzz();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;
    private final int zzaBy;

    SessionRegistrationRequest(int versionCode, PendingIntent intent, IBinder callback, int sessionRegistrationOption) {
        this.mVersionCode = versionCode;
        this.mPendingIntent = intent;
        this.zzaAD = callback == null ? null : zza.zzbR(callback);
        this.zzaBy = sessionRegistrationOption;
    }

    public SessionRegistrationRequest(PendingIntent pendingIntent, zzow callback, int sessionRegistrationOption) {
        this.mVersionCode = 6;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = callback;
        this.zzaBy = sessionRegistrationOption;
    }

    private boolean zzb(SessionRegistrationRequest sessionRegistrationRequest) {
        return this.zzaBy == sessionRegistrationRequest.zzaBy && zzw.equal(this.mPendingIntent, sessionRegistrationRequest.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionRegistrationRequest) && zzb((SessionRegistrationRequest) that));
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
        return zzw.hashCode(this.mPendingIntent, Integer.valueOf(this.zzaBy));
    }

    public String toString() {
        return zzw.zzy(this).zzg("pendingIntent", this.mPendingIntent).zzg("sessionRegistrationOption", Integer.valueOf(this.zzaBy)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzz.zza(this, parcel, flags);
    }

    public int zzvf() {
        return this.zzaBy;
    }
}
