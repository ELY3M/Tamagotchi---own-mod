package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
    private final int mVersionCode;
    private final String zzaDX;
    private final int zzaDY;

    public ConnectionInfo(int versionCode, String clientAddress, int registrationLatency) {
        this.mVersionCode = versionCode;
        this.zzaDX = clientAddress;
        this.zzaDY = registrationLatency;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        ConnectionInfoCreator.zza(this, out, flags);
    }

    public String zzwt() {
        return this.zzaDX;
    }

    public int zzwu() {
        return this.zzaDY;
    }
}
