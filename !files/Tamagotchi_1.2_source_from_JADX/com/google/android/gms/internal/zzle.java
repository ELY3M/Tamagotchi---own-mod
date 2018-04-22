package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

class zzle implements ProxyResult {
    private Status zzUX;
    private ProxyResponse zzWK;

    public zzle(ProxyResponse proxyResponse) {
        this.zzWK = proxyResponse;
        this.zzUX = Status.zzagC;
    }

    public zzle(Status status) {
        this.zzUX = status;
    }

    public ProxyResponse getResponse() {
        return this.zzWK;
    }

    public Status getStatus() {
        return this.zzUX;
    }
}
