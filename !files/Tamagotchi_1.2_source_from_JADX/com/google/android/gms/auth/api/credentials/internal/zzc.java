package com.google.android.gms.auth.api.credentials.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzc implements CredentialRequestResult {
    private final Status zzUX;
    private final Credential zzWu;

    public zzc(Status status, Credential credential) {
        this.zzUX = status;
        this.zzWu = credential;
    }

    public static zzc zzh(Status status) {
        return new zzc(status, null);
    }

    public Credential getCredential() {
        return this.zzWu;
    }

    public Status getStatus() {
        return this.zzUX;
    }
}
