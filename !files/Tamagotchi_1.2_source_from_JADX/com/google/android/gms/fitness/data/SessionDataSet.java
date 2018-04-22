package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class SessionDataSet implements SafeParcelable {
    public static final Creator<SessionDataSet> CREATOR = new zzr();
    final int mVersionCode;
    private final Session zzavX;
    private final DataSet zzaxn;

    SessionDataSet(int versionCode, Session session, DataSet dataSet) {
        this.mVersionCode = versionCode;
        this.zzavX = session;
        this.zzaxn = dataSet;
    }

    private boolean zza(SessionDataSet sessionDataSet) {
        return zzw.equal(this.zzavX, sessionDataSet.zzavX) && zzw.equal(this.zzaxn, sessionDataSet.zzaxn);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionDataSet) && zza((SessionDataSet) o));
    }

    public DataSet getDataSet() {
        return this.zzaxn;
    }

    public Session getSession() {
        return this.zzavX;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavX, this.zzaxn);
    }

    public String toString() {
        return zzw.zzy(this).zzg("session", this.zzavX).zzg("dataSet", this.zzaxn).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzr.zza(this, dest, flags);
    }
}
