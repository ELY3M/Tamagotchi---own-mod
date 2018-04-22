package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest implements SafeParcelable {
    public static final Creator<FullWalletRequest> CREATOR = new zzf();
    private final int mVersionCode;
    String zzboo;
    String zzbop;
    Cart zzboz;

    public final class Builder {
        final /* synthetic */ FullWalletRequest zzboA;

        private Builder(FullWalletRequest fullWalletRequest) {
            this.zzboA = fullWalletRequest;
        }

        public FullWalletRequest build() {
            return this.zzboA;
        }

        public Builder setCart(Cart cart) {
            this.zzboA.zzboz = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.zzboA.zzboo = googleTransactionId;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzboA.zzbop = merchantTransactionId;
            return this;
        }
    }

    FullWalletRequest() {
        this.mVersionCode = 1;
    }

    FullWalletRequest(int versionCode, String googleTransactionId, String merchantTransactionId, Cart cart) {
        this.mVersionCode = versionCode;
        this.zzboo = googleTransactionId;
        this.zzbop = merchantTransactionId;
        this.zzboz = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.zzboz;
    }

    public String getGoogleTransactionId() {
        return this.zzboo;
    }

    public String getMerchantTransactionId() {
        return this.zzbop;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }
}
