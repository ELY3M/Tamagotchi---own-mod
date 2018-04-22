package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zzg;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzb extends zzd {
    private final zzl zzQb;

    class C02485 implements Runnable {
        final /* synthetic */ zzb zzQd;

        C02485(zzb com_google_android_gms_analytics_internal_zzb) {
            this.zzQd = com_google_android_gms_analytics_internal_zzb;
        }

        public void run() {
            this.zzQd.zzQb.zzjc();
        }
    }

    class C02507 implements Callable<Void> {
        final /* synthetic */ zzb zzQd;

        C02507(zzb com_google_android_gms_analytics_internal_zzb) {
            this.zzQd = com_google_android_gms_analytics_internal_zzb;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzdt();
        }

        public Void zzdt() throws Exception {
            this.zzQd.zzQb.zzka();
            return null;
        }
    }

    public zzb(zzf com_google_android_gms_analytics_internal_zzf, zzg com_google_android_gms_analytics_internal_zzg) {
        super(com_google_android_gms_analytics_internal_zzf);
        zzx.zzz(com_google_android_gms_analytics_internal_zzg);
        this.zzQb = com_google_android_gms_analytics_internal_zzg.zzj(com_google_android_gms_analytics_internal_zzf);
    }

    void onServiceConnected() {
        zzjk();
        this.zzQb.onServiceConnected();
    }

    public void setLocalDispatchPeriod(final int dispatchPeriodInSeconds) {
        zzjv();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(dispatchPeriodInSeconds));
        zzjo().zzf(new Runnable(this) {
            final /* synthetic */ zzb zzQd;

            public void run() {
                this.zzQd.zzQb.zzs(((long) dispatchPeriodInSeconds) * 1000);
            }
        });
    }

    public void start() {
        this.zzQb.start();
    }

    public void zzJ(final boolean z) {
        zza("Network connectivity status changed", Boolean.valueOf(z));
        zzjo().zzf(new Runnable(this) {
            final /* synthetic */ zzb zzQd;

            public void run() {
                this.zzQd.zzQb.zzJ(z);
            }
        });
    }

    public long zza(zzh com_google_android_gms_analytics_internal_zzh) {
        zzjv();
        zzx.zzz(com_google_android_gms_analytics_internal_zzh);
        zzjk();
        long zza = this.zzQb.zza(com_google_android_gms_analytics_internal_zzh, true);
        if (zza == 0) {
            this.zzQb.zzc(com_google_android_gms_analytics_internal_zzh);
        }
        return zza;
    }

    public void zza(final zzab com_google_android_gms_analytics_internal_zzab) {
        zzx.zzz(com_google_android_gms_analytics_internal_zzab);
        zzjv();
        zzb("Hit delivery requested", com_google_android_gms_analytics_internal_zzab);
        zzjo().zzf(new Runnable(this) {
            final /* synthetic */ zzb zzQd;

            public void run() {
                this.zzQd.zzQb.zza(com_google_android_gms_analytics_internal_zzab);
            }
        });
    }

    public void zza(final zzw com_google_android_gms_analytics_internal_zzw) {
        zzjv();
        zzjo().zzf(new Runnable(this) {
            final /* synthetic */ zzb zzQd;

            public void run() {
                this.zzQd.zzQb.zzb(com_google_android_gms_analytics_internal_zzw);
            }
        });
    }

    public void zza(final String str, final Runnable runnable) {
        zzx.zzh(str, "campaign param can't be empty");
        zzjo().zzf(new Runnable(this) {
            final /* synthetic */ zzb zzQd;

            public void run() {
                this.zzQd.zzQb.zzbl(str);
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    protected void zziJ() {
        this.zzQb.zza();
    }

    public void zzjc() {
        zzjv();
        zzjj();
        zzjo().zzf(new C02485(this));
    }

    public void zzjd() {
        zzjv();
        Context context = getContext();
        if (AnalyticsReceiver.zzY(context) && AnalyticsService.zzZ(context)) {
            Intent intent = new Intent(context, AnalyticsService.class);
            intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            context.startService(intent);
            return;
        }
        zza(null);
    }

    public boolean zzje() {
        zzjv();
        try {
            zzjo().zzc(new C02507(this)).get(4, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            zzd("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zze("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            zzd("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    public void zzjf() {
        zzjv();
        zzg.zzjk();
        this.zzQb.zzjf();
    }

    public void zzjg() {
        zzbd("Radio powered up");
        zzjd();
    }

    void zzjh() {
        zzjk();
        this.zzQb.zzjh();
    }
}
