package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzov.zza;

public class SessionStopRequest implements SafeParcelable {
    public static final Creator<SessionStopRequest> CREATOR = new zzab();
    private final String mName;
    private final int mVersionCode;
    private final zzov zzaBz;
    private final String zzaxk;

    SessionStopRequest(int versionCode, String name, String identifier, IBinder callback) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzaxk = identifier;
        this.zzaBz = zza.zzbQ(callback);
    }

    public SessionStopRequest(String name, String identifier, zzov callback) {
        this.mVersionCode = 3;
        this.mName = name;
        this.zzaxk = identifier;
        this.zzaBz = callback;
    }

    private boolean zzb(SessionStopRequest sessionStopRequest) {
        return zzw.equal(this.mName, sessionStopRequest.mName) && zzw.equal(this.zzaxk, sessionStopRequest.zzaxk);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionStopRequest) && zzb((SessionStopRequest) o));
    }

    public IBinder getCallbackBinder() {
        return this.zzaBz == null ? null : this.zzaBz.asBinder();
    }

    public String getIdentifier() {
        return this.zzaxk;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzaxk);
    }

    public String toString() {
        return zzw.zzy(this).zzg("name", this.mName).zzg("identifier", this.zzaxk).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzab.zza(this, dest, flags);
    }
}
