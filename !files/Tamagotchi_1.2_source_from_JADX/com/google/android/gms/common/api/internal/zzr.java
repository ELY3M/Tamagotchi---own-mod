package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

public final class zzr<R extends Result> extends OptionalPendingResult<R> {
    private final zzb<R> zzaiy;

    public zzr(PendingResult<R> pendingResult) {
        if (pendingResult instanceof zzb) {
            this.zzaiy = (zzb) pendingResult;
            return;
        }
        throw new IllegalArgumentException("OptionalPendingResult can only wrap PendingResults generated by an API call.");
    }

    public R await() {
        return this.zzaiy.await();
    }

    public R await(long time, TimeUnit units) {
        return this.zzaiy.await(time, units);
    }

    public void cancel() {
        this.zzaiy.cancel();
    }

    public R get() {
        if (isDone()) {
            return await(0, TimeUnit.MILLISECONDS);
        }
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    public boolean isCanceled() {
        return this.zzaiy.isCanceled();
    }

    public boolean isDone() {
        return this.zzaiy.isReady();
    }

    public void setResultCallback(ResultCallback<? super R> callback) {
        this.zzaiy.setResultCallback(callback);
    }

    public void setResultCallback(ResultCallback<? super R> callback, long time, TimeUnit units) {
        this.zzaiy.setResultCallback(callback, time, units);
    }

    public void zza(zza com_google_android_gms_common_api_PendingResult_zza) {
        this.zzaiy.zza(com_google_android_gms_common_api_PendingResult_zza);
    }

    public Integer zzpa() {
        return this.zzaiy.zzpa();
    }
}
