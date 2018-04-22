package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Session;
import java.util.Collections;
import java.util.List;

public class SessionStopResult implements Result, SafeParcelable {
    public static final Creator<SessionStopResult> CREATOR = new zzk();
    private final int mVersionCode;
    private final Status zzUX;
    private final List<Session> zzaAG;

    SessionStopResult(int versionCode, Status status, List<Session> sessions) {
        this.mVersionCode = versionCode;
        this.zzUX = status;
        this.zzaAG = Collections.unmodifiableList(sessions);
    }

    public SessionStopResult(Status status, List<Session> sessions) {
        this.mVersionCode = 3;
        this.zzUX = status;
        this.zzaAG = Collections.unmodifiableList(sessions);
    }

    public static SessionStopResult zzV(Status status) {
        return new SessionStopResult(status, Collections.emptyList());
    }

    private boolean zzb(SessionStopResult sessionStopResult) {
        return this.zzUX.equals(sessionStopResult.zzUX) && zzw.equal(this.zzaAG, sessionStopResult.zzaAG);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof SessionStopResult) && zzb((SessionStopResult) o));
    }

    public List<Session> getSessions() {
        return this.zzaAG;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzaAG);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("sessions", this.zzaAG).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
