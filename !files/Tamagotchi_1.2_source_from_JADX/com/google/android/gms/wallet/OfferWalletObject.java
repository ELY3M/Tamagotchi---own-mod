package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
    public static final Creator<OfferWalletObject> CREATOR = new zzo();
    private final int mVersionCode;
    CommonWalletObject zzboB;
    String zzbpB;
    String zzio;

    OfferWalletObject() {
        this.mVersionCode = 3;
    }

    OfferWalletObject(int versionCode, String id, String redemptionCode, CommonWalletObject commonWalletObject) {
        this.mVersionCode = versionCode;
        this.zzbpB = redemptionCode;
        if (versionCode < 3) {
            this.zzboB = CommonWalletObject.zzIr().zzgK(id).zzIs();
        } else {
            this.zzboB = commonWalletObject;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzboB.getId();
    }

    public String getRedemptionCode() {
        return this.zzbpB;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }
}
