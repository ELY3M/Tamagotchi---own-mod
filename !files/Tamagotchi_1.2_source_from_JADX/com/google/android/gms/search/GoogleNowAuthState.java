package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GoogleNowAuthState implements SafeParcelable {
    public static final Creator<GoogleNowAuthState> CREATOR = new zza();
    final int mVersionCode;
    String zzXI;
    String zzbgG;
    long zzbgH;

    GoogleNowAuthState(int versionCode, String authCode, String accessToken, long nextAllowedTimeMillis) {
        this.mVersionCode = versionCode;
        this.zzbgG = authCode;
        this.zzXI = accessToken;
        this.zzbgH = nextAllowedTimeMillis;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccessToken() {
        return this.zzXI;
    }

    public String getAuthCode() {
        return this.zzbgG;
    }

    public long getNextAllowedTimeMillis() {
        return this.zzbgH;
    }

    public String toString() {
        return "mAuthCode = " + this.zzbgG + "\nmAccessToken = " + this.zzXI + "\nmNextAllowedTimeMillis = " + this.zzbgH;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
