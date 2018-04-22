package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public class zzlq implements CastRemoteDisplayApi {
    private static final zzl zzaaf = new zzl("CastRemoteDisplayApiImpl");
    private com.google.android.gms.common.api.Api.zzc<zzlr> zzaeE;
    private VirtualDisplay zzaeF;
    private final zzlu zzaeG = new C10051(this);

    class C10051 extends com.google.android.gms.internal.zzlu.zza {
        final /* synthetic */ zzlq zzaeH;

        C10051(zzlq com_google_android_gms_internal_zzlq) {
            this.zzaeH = com_google_android_gms_internal_zzlq;
        }

        public void zzbp(int i) {
            zzlq.zzaaf.zzb("onRemoteDisplayEnded", new Object[0]);
            this.zzaeH.zzoB();
        }
    }

    private abstract class zza extends com.google.android.gms.internal.zzls.zza {
        final /* synthetic */ zzlq zzaeH;

        private zza(zzlq com_google_android_gms_internal_zzlq) {
            this.zzaeH = com_google_android_gms_internal_zzlq;
        }

        public void onDisconnected() throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void onError(int statusCode) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zza(int i, int i2, Surface surface) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zzoD() throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    private static final class zzc implements CastRemoteDisplaySessionResult {
        private final Status zzUX;
        private final Display zzaar;

        public zzc(Display display) {
            this.zzUX = Status.zzagC;
            this.zzaar = display;
        }

        public zzc(Status status) {
            this.zzUX = status;
            this.zzaar = null;
        }

        public Display getPresentationDisplay() {
            return this.zzaar;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private abstract class zzb extends com.google.android.gms.common.api.internal.zza.zza<CastRemoteDisplaySessionResult, zzlr> {
        final /* synthetic */ zzlq zzaeH;

        @TargetApi(19)
        protected final class zza extends zza {
            private final zzlr zzaeJ;
            final /* synthetic */ zzb zzaeK;

            public zza(zzb com_google_android_gms_internal_zzlq_zzb, zzlr com_google_android_gms_internal_zzlr) {
                this.zzaeK = com_google_android_gms_internal_zzlq_zzb;
                super();
                this.zzaeJ = com_google_android_gms_internal_zzlr;
            }

            private int zzj(int i, int i2) {
                if (i >= i2) {
                    i = i2;
                }
                return (i * 320) / 1080;
            }

            public void onError(int statusCode) throws RemoteException {
                zzlq.zzaaf.zzb("onError: %d", Integer.valueOf(statusCode));
                this.zzaeK.zzaeH.zzoB();
                this.zzaeK.zza(new zzc(Status.zzagE));
            }

            public void zza(int i, int i2, Surface surface) {
                zzlq.zzaaf.zzb("onConnected", new Object[0]);
                DisplayManager displayManager = (DisplayManager) this.zzaeJ.getContext().getSystemService(ISVGConstants.ATTRIBUTE_DISPLAY);
                if (displayManager == null) {
                    zzlq.zzaaf.zzc("Unable to get the display manager", new Object[0]);
                    this.zzaeK.zza(new zzc(Status.zzagE));
                    return;
                }
                this.zzaeK.zzaeH.zzoB();
                this.zzaeK.zzaeH.zzaeF = displayManager.createVirtualDisplay("private_display", i, i2, zzj(i, i2), surface, 2);
                if (this.zzaeK.zzaeH.zzaeF == null) {
                    zzlq.zzaaf.zzc("Unable to create virtual display", new Object[0]);
                    this.zzaeK.zza(new zzc(Status.zzagE));
                } else if (this.zzaeK.zzaeH.zzaeF.getDisplay() == null) {
                    zzlq.zzaaf.zzc("Virtual display does not have a display", new Object[0]);
                    this.zzaeK.zza(new zzc(Status.zzagE));
                } else {
                    try {
                        this.zzaeJ.zza(this, this.zzaeK.zzaeH.zzaeF.getDisplay().getDisplayId());
                    } catch (RemoteException e) {
                        zzlq.zzaaf.zzc("Unable to provision the route's new virtual Display", new Object[0]);
                        this.zzaeK.zza(new zzc(Status.zzagE));
                    } catch (IllegalStateException e2) {
                        zzlq.zzaaf.zzc("Unable to provision the route's new virtual Display", new Object[0]);
                        this.zzaeK.zza(new zzc(Status.zzagE));
                    }
                }
            }

            public void zzoD() {
                zzlq.zzaaf.zzb("onConnectedWithDisplay", new Object[0]);
                Display display = this.zzaeK.zzaeH.zzaeF.getDisplay();
                if (display != null) {
                    this.zzaeK.zza(new zzc(display));
                    return;
                }
                zzlq.zzaaf.zzc("Virtual display no longer has a display", new Object[0]);
                this.zzaeK.zza(new zzc(Status.zzagE));
            }
        }

        protected final class zzb extends zza {
            final /* synthetic */ zzb zzaeK;

            protected zzb(zzb com_google_android_gms_internal_zzlq_zzb) {
                this.zzaeK = com_google_android_gms_internal_zzlq_zzb;
                super();
            }

            public void onDisconnected() throws RemoteException {
                zzlq.zzaaf.zzb("onDisconnected", new Object[0]);
                this.zzaeK.zzaeH.zzoB();
                this.zzaeK.zza(new zzc(Status.zzagC));
            }

            public void onError(int statusCode) throws RemoteException {
                zzlq.zzaaf.zzb("onError: %d", Integer.valueOf(statusCode));
                this.zzaeK.zzaeH.zzoB();
                this.zzaeK.zza(new zzc(Status.zzagE));
            }
        }

        public zzb(zzlq com_google_android_gms_internal_zzlq, GoogleApiClient googleApiClient) {
            this.zzaeH = com_google_android_gms_internal_zzlq;
            super(com_google_android_gms_internal_zzlq.zzaeE, googleApiClient);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzt(status);
        }

        protected CastRemoteDisplaySessionResult zzt(Status status) {
            return new zzc(status);
        }
    }

    public zzlq(com.google.android.gms.common.api.Api.zzc<zzlr> com_google_android_gms_common_api_Api_zzc_com_google_android_gms_internal_zzlr) {
        this.zzaeE = com_google_android_gms_common_api_Api_zzc_com_google_android_gms_internal_zzlr;
    }

    @TargetApi(19)
    private void zzoB() {
        if (this.zzaeF != null) {
            if (this.zzaeF.getDisplay() != null) {
                zzaaf.zzb("releasing virtual display: " + this.zzaeF.getDisplay().getDisplayId(), new Object[0]);
            }
            this.zzaeF.release();
            this.zzaeF = null;
        }
    }

    public PendingResult<CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient apiClient, final String appId) {
        zzaaf.zzb("startRemoteDisplay", new Object[0]);
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ zzlq zzaeH;

            protected void zza(zzlr com_google_android_gms_internal_zzlr) throws RemoteException {
                com_google_android_gms_internal_zzlr.zza(new zza(this, com_google_android_gms_internal_zzlr), this.zzaeH.zzaeG, appId);
            }
        });
    }

    public PendingResult<CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient apiClient) {
        zzaaf.zzb("stopRemoteDisplay", new Object[0]);
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ zzlq zzaeH;

            protected void zza(zzlr com_google_android_gms_internal_zzlr) throws RemoteException {
                com_google_android_gms_internal_zzlr.zza(new zzb(this));
            }
        });
    }
}
