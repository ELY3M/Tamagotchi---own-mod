package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.C0196R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions implements SafeParcelable {
    public static final Creator<WalletFragmentOptions> CREATOR = new zzb();
    private int mTheme;
    final int mVersionCode;
    private int zzaoy;
    private int zzbpM;
    private WalletFragmentStyle zzbqs;

    public final class Builder {
        final /* synthetic */ WalletFragmentOptions zzbqt;

        private Builder(WalletFragmentOptions walletFragmentOptions) {
            this.zzbqt = walletFragmentOptions;
        }

        public WalletFragmentOptions build() {
            return this.zzbqt;
        }

        public Builder setEnvironment(int environment) {
            this.zzbqt.zzbpM = environment;
            return this;
        }

        public Builder setFragmentStyle(int styleResourceId) {
            this.zzbqt.zzbqs = new WalletFragmentStyle().setStyleResourceId(styleResourceId);
            return this;
        }

        public Builder setFragmentStyle(WalletFragmentStyle fragmentStyle) {
            this.zzbqt.zzbqs = fragmentStyle;
            return this;
        }

        public Builder setMode(int mode) {
            this.zzbqt.zzaoy = mode;
            return this;
        }

        public Builder setTheme(int theme) {
            this.zzbqt.mTheme = theme;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.mVersionCode = 1;
        this.zzbpM = 3;
        this.zzbqs = new WalletFragmentStyle();
    }

    WalletFragmentOptions(int versionCode, int environment, int theme, WalletFragmentStyle fragmentStyle, int mode) {
        this.mVersionCode = versionCode;
        this.zzbpM = environment;
        this.mTheme = theme;
        this.zzbqs = fragmentStyle;
        this.zzaoy = mode;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public static WalletFragmentOptions zzb(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0196R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(C0196R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(C0196R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(C0196R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(C0196R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.zzbpM = i2;
        walletFragmentOptions.zzbqs = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.zzbqs.zzbc(context);
        walletFragmentOptions.zzaoy = i3;
        return walletFragmentOptions;
    }

    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.zzbpM;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.zzbqs;
    }

    public int getMode() {
        return this.zzaoy;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public void zzbc(Context context) {
        if (this.zzbqs != null) {
            this.zzbqs.zzbc(context);
        }
    }
}
