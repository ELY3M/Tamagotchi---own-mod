package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrp;

public final class AnalyticsService extends Service {
    private static Boolean zzOO;
    private final Handler mHandler = new Handler();

    public static boolean zzZ(Context context) {
        zzx.zzz(context);
        if (zzOO != null) {
            return zzOO.booleanValue();
        }
        boolean zza = zzam.zza(context, AnalyticsService.class);
        zzOO = Boolean.valueOf(zza);
        return zza;
    }

    private void zziz() {
        try {
            synchronized (AnalyticsReceiver.zzqy) {
                zzrp com_google_android_gms_internal_zzrp = AnalyticsReceiver.zzOM;
                if (com_google_android_gms_internal_zzrp != null && com_google_android_gms_internal_zzrp.isHeld()) {
                    com_google_android_gms_internal_zzrp.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onCreate() {
        super.onCreate();
        zzf zzaa = zzf.zzaa(this);
        zzaf zzjm = zzaa.zzjm();
        if (zzaa.zzjn().zzkr()) {
            zzjm.zzbd("Device AnalyticsService is starting up");
        } else {
            zzjm.zzbd("Local AnalyticsService is starting up");
        }
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onDestroy() {
        zzf zzaa = zzf.zzaa(this);
        zzaf zzjm = zzaa.zzjm();
        if (zzaa.zzjn().zzkr()) {
            zzjm.zzbd("Device AnalyticsService is shutting down");
        } else {
            zzjm.zzbd("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public int onStartCommand(Intent intent, int flags, final int startId) {
        zziz();
        final zzf zzaa = zzf.zzaa(this);
        final zzaf zzjm = zzaa.zzjm();
        String action = intent.getAction();
        if (zzaa.zzjn().zzkr()) {
            zzjm.zza("Device AnalyticsService called. startId, action", Integer.valueOf(startId), action);
        } else {
            zzjm.zza("Local AnalyticsService called. startId, action", Integer.valueOf(startId), action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            zzaa.zziH().zza(new zzw(this) {
                final /* synthetic */ AnalyticsService zzOS;

                class C02361 implements Runnable {
                    final /* synthetic */ C06721 zzOT;

                    C02361(C06721 c06721) {
                        this.zzOT = c06721;
                    }

                    public void run() {
                        if (!this.zzOT.zzOS.stopSelfResult(startId)) {
                            return;
                        }
                        if (zzaa.zzjn().zzkr()) {
                            zzjm.zzbd("Device AnalyticsService processed last dispatch request");
                        } else {
                            zzjm.zzbd("Local AnalyticsService processed last dispatch request");
                        }
                    }
                }

                public void zzc(Throwable th) {
                    this.zzOS.mHandler.post(new C02361(this));
                }
            });
        }
        return 2;
    }
}
