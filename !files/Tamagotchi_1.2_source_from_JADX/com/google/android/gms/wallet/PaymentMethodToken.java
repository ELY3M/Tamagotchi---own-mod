package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PaymentMethodToken implements SafeParcelable {
    public static final Creator<PaymentMethodToken> CREATOR = new zzp();
    private final int mVersionCode;
    String zzbaW;
    int zzbpC;

    private PaymentMethodToken() {
        this.mVersionCode = 1;
    }

    PaymentMethodToken(int versionCode, int tokenizationType, String token) {
        this.mVersionCode = versionCode;
        this.zzbpC = tokenizationType;
        this.zzbaW = token;
    }

    public int describeContents() {
        return 0;
    }

    public int getPaymentMethodTokenizationType() {
        return this.zzbpC;
    }

    public String getToken() {
        return this.zzbaW;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzp.zza(this, out, flags);
    }
}
