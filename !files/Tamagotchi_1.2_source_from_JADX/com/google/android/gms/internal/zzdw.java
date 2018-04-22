package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzr;
import java.util.LinkedList;
import java.util.List;

@zzhb
class zzdw {
    private final List<zza> zzpH = new LinkedList();

    interface zza {
        void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException;
    }

    class C09971 extends com.google.android.gms.ads.internal.client.zzq.zza {
        final /* synthetic */ zzdw zzAc;

        class C07631 implements zza {
            final /* synthetic */ C09971 zzAd;

            C07631(C09971 c09971) {
                this.zzAd = c09971;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdClosed();
                }
                zzr.zzbN().zzee();
            }
        }

        class C07653 implements zza {
            final /* synthetic */ C09971 zzAd;

            C07653(C09971 c09971) {
                this.zzAd = c09971;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdLeftApplication();
                }
            }
        }

        class C07664 implements zza {
            final /* synthetic */ C09971 zzAd;

            C07664(C09971 c09971) {
                this.zzAd = c09971;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdLoaded();
                }
            }
        }

        class C07675 implements zza {
            final /* synthetic */ C09971 zzAd;

            C07675(C09971 c09971) {
                this.zzAd = c09971;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdOpened();
                }
            }
        }

        C09971(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void onAdClosed() throws RemoteException {
            this.zzAc.zzpH.add(new C07631(this));
        }

        public void onAdFailedToLoad(final int errorCode) throws RemoteException {
            this.zzAc.zzpH.add(new zza(this) {
                final /* synthetic */ C09971 zzAd;

                public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                    if (com_google_android_gms_internal_zzdx.zzpK != null) {
                        com_google_android_gms_internal_zzdx.zzpK.onAdFailedToLoad(errorCode);
                    }
                }
            });
            zzin.m33v("Pooled interstitial failed to load.");
        }

        public void onAdLeftApplication() throws RemoteException {
            this.zzAc.zzpH.add(new C07653(this));
        }

        public void onAdLoaded() throws RemoteException {
            this.zzAc.zzpH.add(new C07664(this));
            zzin.m33v("Pooled interstitial loaded.");
        }

        public void onAdOpened() throws RemoteException {
            this.zzAc.zzpH.add(new C07675(this));
        }
    }

    class C09982 extends com.google.android.gms.ads.internal.client.zzw.zza {
        final /* synthetic */ zzdw zzAc;

        C09982(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void onAppEvent(final String name, final String info) throws RemoteException {
            this.zzAc.zzpH.add(new zza(this) {
                final /* synthetic */ C09982 zzAg;

                public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                    if (com_google_android_gms_internal_zzdx.zzAq != null) {
                        com_google_android_gms_internal_zzdx.zzAq.onAppEvent(name, info);
                    }
                }
            });
        }
    }

    class C09993 extends com.google.android.gms.internal.zzgd.zza {
        final /* synthetic */ zzdw zzAc;

        C09993(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void zza(final zzgc com_google_android_gms_internal_zzgc) throws RemoteException {
            this.zzAc.zzpH.add(new zza(this) {
                final /* synthetic */ C09993 zzAi;

                public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                    if (com_google_android_gms_internal_zzdx.zzAr != null) {
                        com_google_android_gms_internal_zzdx.zzAr.zza(com_google_android_gms_internal_zzgc);
                    }
                }
            });
        }
    }

    class C10004 extends com.google.android.gms.internal.zzcf.zza {
        final /* synthetic */ zzdw zzAc;

        C10004(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void zza(final zzce com_google_android_gms_internal_zzce) throws RemoteException {
            this.zzAc.zzpH.add(new zza(this) {
                final /* synthetic */ C10004 zzAk;

                public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                    if (com_google_android_gms_internal_zzdx.zzAs != null) {
                        com_google_android_gms_internal_zzdx.zzAs.zza(com_google_android_gms_internal_zzce);
                    }
                }
            });
        }
    }

    class C10015 extends com.google.android.gms.ads.internal.client.zzp.zza {
        final /* synthetic */ zzdw zzAc;

        class C07711 implements zza {
            final /* synthetic */ C10015 zzAl;

            C07711(C10015 c10015) {
                this.zzAl = c10015;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAt != null) {
                    com_google_android_gms_internal_zzdx.zzAt.onAdClicked();
                }
            }
        }

        C10015(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void onAdClicked() throws RemoteException {
            this.zzAc.zzpH.add(new C07711(this));
        }
    }

    class C10026 extends com.google.android.gms.ads.internal.reward.client.zzd.zza {
        final /* synthetic */ zzdw zzAc;

        class C07721 implements zza {
            final /* synthetic */ C10026 zzAm;

            C07721(C10026 c10026) {
                this.zzAm = c10026;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdLoaded();
                }
            }
        }

        class C07732 implements zza {
            final /* synthetic */ C10026 zzAm;

            C07732(C10026 c10026) {
                this.zzAm = c10026;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdOpened();
                }
            }
        }

        class C07743 implements zza {
            final /* synthetic */ C10026 zzAm;

            C07743(C10026 c10026) {
                this.zzAm = c10026;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoStarted();
                }
            }
        }

        class C07754 implements zza {
            final /* synthetic */ C10026 zzAm;

            C07754(C10026 c10026) {
                this.zzAm = c10026;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdClosed();
                }
            }
        }

        class C07776 implements zza {
            final /* synthetic */ C10026 zzAm;

            C07776(C10026 c10026) {
                this.zzAm = c10026;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdLeftApplication();
                }
            }
        }

        C10026(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void onRewardedVideoAdClosed() throws RemoteException {
            this.zzAc.zzpH.add(new C07754(this));
        }

        public void onRewardedVideoAdFailedToLoad(final int errorCode) throws RemoteException {
            this.zzAc.zzpH.add(new zza(this) {
                final /* synthetic */ C10026 zzAm;

                public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                    if (com_google_android_gms_internal_zzdx.zzAu != null) {
                        com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdFailedToLoad(errorCode);
                    }
                }
            });
        }

        public void onRewardedVideoAdLeftApplication() throws RemoteException {
            this.zzAc.zzpH.add(new C07776(this));
        }

        public void onRewardedVideoAdLoaded() throws RemoteException {
            this.zzAc.zzpH.add(new C07721(this));
        }

        public void onRewardedVideoAdOpened() throws RemoteException {
            this.zzAc.zzpH.add(new C07732(this));
        }

        public void onRewardedVideoStarted() throws RemoteException {
            this.zzAc.zzpH.add(new C07743(this));
        }

        public void zza(final com.google.android.gms.ads.internal.reward.client.zza com_google_android_gms_ads_internal_reward_client_zza) throws RemoteException {
            this.zzAc.zzpH.add(new zza(this) {
                final /* synthetic */ C10026 zzAm;

                public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                    if (com_google_android_gms_internal_zzdx.zzAu != null) {
                        com_google_android_gms_internal_zzdx.zzAu.zza(com_google_android_gms_ads_internal_reward_client_zza);
                    }
                }
            });
        }
    }

    zzdw() {
    }

    void zza(final zzdx com_google_android_gms_internal_zzdx) {
        Handler handler = zzir.zzMc;
        for (final zza com_google_android_gms_internal_zzdw_zza : this.zzpH) {
            handler.post(new Runnable(this) {
                final /* synthetic */ zzdw zzAc;

                public void run() {
                    try {
                        com_google_android_gms_internal_zzdw_zza.zzb(com_google_android_gms_internal_zzdx);
                    } catch (Throwable e) {
                        zzb.zzd("Could not propagate interstitial ad event.", e);
                    }
                }
            });
        }
    }

    void zzc(zzk com_google_android_gms_ads_internal_zzk) {
        com_google_android_gms_ads_internal_zzk.zza(new C09971(this));
        com_google_android_gms_ads_internal_zzk.zza(new C09982(this));
        com_google_android_gms_ads_internal_zzk.zza(new C09993(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10004(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10015(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10026(this));
    }
}
