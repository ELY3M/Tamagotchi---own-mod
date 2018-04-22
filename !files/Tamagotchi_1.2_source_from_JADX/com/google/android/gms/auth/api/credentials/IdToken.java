package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdToken implements SafeParcelable {
    public static final Creator<IdToken> CREATOR = new zze();
    final int mVersionCode;
    private final String zzVY;
    private final String zzWk;

    IdToken(int version, String accountType, String idToken) {
        this.mVersionCode = version;
        this.zzVY = accountType;
        this.zzWk = idToken;
    }

    public IdToken(String accountType, String idToken) {
        this(1, accountType, idToken);
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountType() {
        return this.zzVY;
    }

    public String getIdToken() {
        return this.zzWk;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }
}
