package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Creator<WalletFragmentInitParams> CREATOR = new zza();
    final int mVersionCode;
    private String zzVa;
    private MaskedWalletRequest zzbqc;
    private MaskedWallet zzbqd;
    private int zzbqq;

    public final class Builder {
        final /* synthetic */ WalletFragmentInitParams zzbqr;

        private Builder(WalletFragmentInitParams walletFragmentInitParams) {
            this.zzbqr = walletFragmentInitParams;
        }

        public WalletFragmentInitParams build() {
            boolean z = true;
            boolean z2 = (this.zzbqr.zzbqd != null && this.zzbqr.zzbqc == null) || (this.zzbqr.zzbqd == null && this.zzbqr.zzbqc != null);
            zzx.zza(z2, (Object) "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            if (this.zzbqr.zzbqq < 0) {
                z = false;
            }
            zzx.zza(z, (Object) "masked wallet request code is required and must be non-negative");
            return this.zzbqr;
        }

        public Builder setAccountName(String accountName) {
            this.zzbqr.zzVa = accountName;
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedWallet) {
            this.zzbqr.zzbqd = maskedWallet;
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest request) {
            this.zzbqr.zzbqc = request;
            return this;
        }

        public Builder setMaskedWalletRequestCode(int requestCode) {
            this.zzbqr.zzbqq = requestCode;
            return this;
        }
    }

    private WalletFragmentInitParams() {
        this.mVersionCode = 1;
        this.zzbqq = -1;
    }

    WalletFragmentInitParams(int versionCode, String accountName, MaskedWalletRequest maskedWalletRequest, int maskedWalletRequestCode, MaskedWallet maskedWallet) {
        this.mVersionCode = versionCode;
        this.zzVa = accountName;
        this.zzbqc = maskedWalletRequest;
        this.zzbqq = maskedWalletRequestCode;
        this.zzbqd = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.zzVa;
    }

    public MaskedWallet getMaskedWallet() {
        return this.zzbqd;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.zzbqc;
    }

    public int getMaskedWalletRequestCode() {
        return this.zzbqq;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
