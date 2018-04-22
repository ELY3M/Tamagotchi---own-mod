package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzkl implements AppInviteApi {

    static class zza extends com.google.android.gms.internal.zzko.zza {
        zza() {
        }

        public void zza(Status status, Intent intent) {
            throw new UnsupportedOperationException();
        }

        public void zzd(Status status) throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    static abstract class zzb<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzkm> {
        public zzb(GoogleApiClient googleApiClient) {
            super(AppInvite.zzUI, googleApiClient);
        }
    }

    final class zzc extends zzb<Status> {
        private final String zzUO;
        final /* synthetic */ zzkl zzUP;

        class C10681 extends zza {
            final /* synthetic */ zzc zzUQ;

            C10681(zzc com_google_android_gms_internal_zzkl_zzc) {
                this.zzUQ = com_google_android_gms_internal_zzkl_zzc;
            }

            public void zzd(Status status) throws RemoteException {
                this.zzUQ.zza((Result) status);
            }
        }

        public zzc(zzkl com_google_android_gms_internal_zzkl, GoogleApiClient googleApiClient, String str) {
            this.zzUP = com_google_android_gms_internal_zzkl;
            super(googleApiClient);
            this.zzUO = str;
        }

        protected void zza(zzkm com_google_android_gms_internal_zzkm) throws RemoteException {
            com_google_android_gms_internal_zzkm.zzb(new C10681(this), this.zzUO);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    final class zzd extends zzb<Status> {
        private final String zzUO;
        final /* synthetic */ zzkl zzUP;

        class C10691 extends zza {
            final /* synthetic */ zzd zzUR;

            C10691(zzd com_google_android_gms_internal_zzkl_zzd) {
                this.zzUR = com_google_android_gms_internal_zzkl_zzd;
            }

            public void zzd(Status status) throws RemoteException {
                this.zzUR.zza((Result) status);
            }
        }

        public zzd(zzkl com_google_android_gms_internal_zzkl, GoogleApiClient googleApiClient, String str) {
            this.zzUP = com_google_android_gms_internal_zzkl;
            super(googleApiClient);
            this.zzUO = str;
        }

        protected void zza(zzkm com_google_android_gms_internal_zzkm) throws RemoteException {
            com_google_android_gms_internal_zzkm.zza(new C10691(this), this.zzUO);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    final class zze extends zzb<AppInviteInvitationResult> {
        final /* synthetic */ zzkl zzUP;
        private final Activity zzUS;
        private final boolean zzUT;
        private final Intent zzUU;

        class C10701 extends zza {
            final /* synthetic */ zze zzUV;

            C10701(zze com_google_android_gms_internal_zzkl_zze) {
                this.zzUV = com_google_android_gms_internal_zzkl_zze;
            }

            public void zza(Status status, Intent intent) {
                this.zzUV.zza(new zzkn(status, intent));
                if (AppInviteReferral.hasReferral(intent) && this.zzUV.zzUT && this.zzUV.zzUS != null) {
                    this.zzUV.zzUS.startActivity(intent);
                }
            }
        }

        public zze(zzkl com_google_android_gms_internal_zzkl, GoogleApiClient googleApiClient, Activity activity, boolean z) {
            this.zzUP = com_google_android_gms_internal_zzkl;
            super(googleApiClient);
            this.zzUS = activity;
            this.zzUT = z;
            this.zzUU = this.zzUS != null ? this.zzUS.getIntent() : null;
        }

        protected void zza(zzkm com_google_android_gms_internal_zzkm) throws RemoteException {
            if (AppInviteReferral.hasReferral(this.zzUU)) {
                zza(new zzkn(Status.zzagC, this.zzUU));
            } else {
                com_google_android_gms_internal_zzkm.zza(new C10701(this));
            }
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zze(status);
        }

        protected AppInviteInvitationResult zze(Status status) {
            return new zzkn(status, new Intent());
        }
    }

    public PendingResult<Status> convertInvitation(GoogleApiClient client, String invitationId) {
        return client.zza(new zzd(this, client, invitationId));
    }

    public PendingResult<AppInviteInvitationResult> getInvitation(GoogleApiClient client, Activity currentActivity, boolean launchDeepLink) {
        return client.zza(new zze(this, client, currentActivity, launchDeepLink));
    }

    public PendingResult<Status> updateInvitationOnInstall(GoogleApiClient client, String invitationId) {
        return client.zza(new zzc(this, client, invitationId));
    }
}
