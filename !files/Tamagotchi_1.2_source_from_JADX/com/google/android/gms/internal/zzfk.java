package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzhb
public final class zzfk<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzez zzCK;

    class C03791 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C03791(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdClicked();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClicked.", e);
            }
        }
    }

    class C03802 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C03802(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdOpened();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    class C03813 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C03813(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdLoaded();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    class C03824 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C03824(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdClosed();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    class C03846 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C03846(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdLeftApplication();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    class C03857 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C03857(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdOpened();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    class C03868 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C03868(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdLoaded();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    class C03879 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C03879(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdClosed();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    public zzfk(zzez com_google_android_gms_internal_zzez) {
        this.zzCK = com_google_android_gms_internal_zzez;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onClick.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdClicked();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClicked.", e);
                return;
            }
        }
        zzb.zzaK("onClick must be called on the main UI thread.");
        zza.zzMS.post(new C03791(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onDismissScreen.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdClosed();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzb.zzaK("onDismissScreen must be called on the main UI thread.");
        zza.zzMS.post(new C03824(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaI("Adapter called onDismissScreen.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdClosed();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzb.zzaK("onDismissScreen must be called on the main UI thread.");
        zza.zzMS.post(new C03879(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        zzb.zzaI("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzb.zzaK("onFailedToReceiveAd must be called on the main UI thread.");
        zza.zzMS.post(new Runnable(this) {
            final /* synthetic */ zzfk zzCQ;

            public void run() {
                try {
                    this.zzCQ.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
                } catch (Throwable e) {
                    zzb.zzd("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        zzb.zzaI("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzb.zzaK("onFailedToReceiveAd must be called on the main UI thread.");
        zza.zzMS.post(new Runnable(this) {
            final /* synthetic */ zzfk zzCQ;

            public void run() {
                try {
                    this.zzCQ.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
                } catch (Throwable e) {
                    zzb.zzd("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onLeaveApplication.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzb.zzaK("onLeaveApplication must be called on the main UI thread.");
        zza.zzMS.post(new C03846(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaI("Adapter called onLeaveApplication.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzb.zzaK("onLeaveApplication must be called on the main UI thread.");
        zza.zzMS.post(new Runnable(this) {
            final /* synthetic */ zzfk zzCQ;

            {
                this.zzCQ = r1;
            }

            public void run() {
                try {
                    this.zzCQ.zzCK.onAdLeftApplication();
                } catch (Throwable e) {
                    zzb.zzd("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onPresentScreen.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdOpened();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzb.zzaK("onPresentScreen must be called on the main UI thread.");
        zza.zzMS.post(new C03857(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaI("Adapter called onPresentScreen.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdOpened();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzb.zzaK("onPresentScreen must be called on the main UI thread.");
        zza.zzMS.post(new C03802(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onReceivedAd.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzb.zzaK("onReceivedAd must be called on the main UI thread.");
        zza.zzMS.post(new C03868(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaI("Adapter called onReceivedAd.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzb.zzaK("onReceivedAd must be called on the main UI thread.");
        zza.zzMS.post(new C03813(this));
    }
}
