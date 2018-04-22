package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class CredentialRequest implements SafeParcelable {
    public static final Creator<CredentialRequest> CREATOR = new zzc();
    final int mVersionCode;
    private final boolean zzWd;
    private final String[] zzWe;
    private final CredentialPickerConfig zzWf;
    private final CredentialPickerConfig zzWg;

    public static final class Builder {
        private boolean zzWd;
        private String[] zzWe;
        private CredentialPickerConfig zzWf;
        private CredentialPickerConfig zzWg;

        public CredentialRequest build() {
            if (this.zzWe == null) {
                this.zzWe = new String[0];
            }
            if (this.zzWd || this.zzWe.length != 0) {
                return new CredentialRequest();
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public Builder setAccountTypes(String... accountTypes) {
            if (accountTypes == null) {
                accountTypes = new String[0];
            }
            this.zzWe = accountTypes;
            return this;
        }

        public Builder setCredentialHintPickerConfig(CredentialPickerConfig config) {
            this.zzWg = config;
            return this;
        }

        public Builder setCredentialPickerConfig(CredentialPickerConfig config) {
            this.zzWf = config;
            return this;
        }

        public Builder setPasswordLoginSupported(boolean passwordLoginSupported) {
            this.zzWd = passwordLoginSupported;
            return this;
        }

        @Deprecated
        public Builder setSupportsPasswordLogin(boolean supportsPasswordLogin) {
            return setPasswordLoginSupported(supportsPasswordLogin);
        }
    }

    CredentialRequest(int version, boolean passwordLoginSupported, String[] accountTypes, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialHintPickerConfig) {
        this.mVersionCode = version;
        this.zzWd = passwordLoginSupported;
        this.zzWe = (String[]) zzx.zzz(accountTypes);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzWf = credentialPickerConfig;
        if (credentialHintPickerConfig == null) {
            credentialHintPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzWg = credentialHintPickerConfig;
    }

    private CredentialRequest(Builder builder) {
        this(2, builder.zzWd, builder.zzWe, builder.zzWf, builder.zzWg);
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    public String[] getAccountTypes() {
        return this.zzWe;
    }

    @NonNull
    public CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzWg;
    }

    @NonNull
    public CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzWf;
    }

    @Deprecated
    public boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public boolean isPasswordLoginSupported() {
        return this.zzWd;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
