package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;
import java.util.concurrent.TimeUnit;

public class SessionStartRequest implements SafeParcelable {
    public static final Creator<SessionStartRequest> CREATOR = new zzaa();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final Session zzavX;

    SessionStartRequest(int versionCode, Session session, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzavX = session;
        this.zzaAD = zza.zzbR(callback);
    }

    public SessionStartRequest(Session session, zzow callback) {
        zzx.zzb(session.getStartTime(TimeUnit.MILLISECONDS) < System.currentTimeMillis(), (Object) "Cannot start a session in the future");
        zzx.zzb(session.isOngoing(), (Object) "Cannot start a session which has already ended");
        this.mVersionCode = 3;
        this.zzavX = session;
        this.zzaAD = callback;
    }

    private boolean zzb(SessionStartRequest sessionStartRequest) {
        return zzw.equal(this.zzavX, sessionStartRequest.zzavX);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionStartRequest) && zzb((SessionStartRequest) o));
    }

    public IBinder getCallbackBinder() {
        return this.zzaAD == null ? null : this.zzaAD.asBinder();
    }

    public Session getSession() {
        return this.zzavX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavX);
    }

    public String toString() {
        return zzw.zzy(this).zzg("session", this.zzavX).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaa.zza(this, dest, flags);
    }
}
