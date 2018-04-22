package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrp;

public class CampaignTrackingService extends Service {
    private static Boolean zzOO;
    private Handler mHandler;

    private Handler getHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler;
        }
        handler = new Handler(getMainLooper());
        this.mHandler = handler;
        return handler;
    }

    public static boolean zzZ(Context context) {
        zzx.zzz(context);
        if (zzOO != null) {
            return zzOO.booleanValue();
        }
        boolean zza = zzam.zza(context, CampaignTrackingService.class);
        zzOO = Boolean.valueOf(zza);
        return zza;
    }

    private void zziz() {
        try {
            synchronized (CampaignTrackingReceiver.zzqy) {
                zzrp com_google_android_gms_internal_zzrp = CampaignTrackingReceiver.zzOM;
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
        zzf.zzaa(this).zzjm().zzbd("CampaignTrackingService is starting up");
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onDestroy() {
        zzf.zzaa(this).zzjm().zzbd("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public int onStartCommand(Intent intent, int flags, final int startId) {
        zziz();
        zzf zzaa = zzf.zzaa(this);
        final zzaf zzjm = zzaa.zzjm();
        String str = null;
        if (zzaa.zzjn().zzkr()) {
            zzjm.zzbh("Unexpected installation campaign (package side)");
        } else {
            str = intent.getStringExtra("referrer");
        }
        final Handler handler = getHandler();
        if (TextUtils.isEmpty(str)) {
            if (!zzaa.zzjn().zzkr()) {
                zzjm.zzbg("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            zzaa.zzjo().zzf(new Runnable(this) {
                final /* synthetic */ CampaignTrackingService zzOZ;

                public void run() {
                    this.zzOZ.zza(zzjm, handler, startId);
                }
            });
        } else {
            int zzkv = zzaa.zzjn().zzkv();
            if (str.length() > zzkv) {
                zzjm.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(zzkv));
                str = str.substring(0, zzkv);
            }
            zzjm.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(startId), str);
            zzaa.zziH().zza(str, new Runnable(this) {
                final /* synthetic */ CampaignTrackingService zzOZ;

                public void run() {
                    this.zzOZ.zza(zzjm, handler, startId);
                }
            });
        }
        return 2;
    }

    protected void zza(final zzaf com_google_android_gms_analytics_internal_zzaf, Handler handler, final int i) {
        handler.post(new Runnable(this) {
            final /* synthetic */ CampaignTrackingService zzOZ;

            public void run() {
                boolean stopSelfResult = this.zzOZ.stopSelfResult(i);
                if (stopSelfResult) {
                    com_google_android_gms_analytics_internal_zzaf.zza("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
                }
            }
        });
    }
}
