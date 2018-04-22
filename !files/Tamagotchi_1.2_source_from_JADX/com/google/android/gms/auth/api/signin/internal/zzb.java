package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzu;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class zzb extends AsyncTaskLoader<Void> implements zzu {
    private Semaphore zzXp = new Semaphore(0);
    private Set<GoogleApiClient> zzXq;

    public zzb(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.zzXq = set;
    }

    public /* synthetic */ Object loadInBackground() {
        return zzmZ();
    }

    protected void onStartLoading() {
        this.zzXp.drainPermits();
        forceLoad();
    }

    public Void zzmZ() {
        int i = 0;
        for (GoogleApiClient zza : this.zzXq) {
            i = zza.zza((zzu) this) ? i + 1 : i;
        }
        try {
            this.zzXp.tryAcquire(i, 5, TimeUnit.SECONDS);
        } catch (Throwable e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public void zzna() {
        this.zzXp.release();
    }
}
