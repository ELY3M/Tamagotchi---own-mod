package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class zzqq implements PanoramaApi {

    private static final class zzb extends com.google.android.gms.internal.zzqo.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<PanoramaResult> zzamC;

        public zzb(com.google.android.gms.common.api.internal.zza.zzb<PanoramaResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_panorama_PanoramaApi_PanoramaResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_panorama_PanoramaApi_PanoramaResult;
        }

        public void zza(int i, Bundle bundle, int i2, Intent intent) {
            this.zzamC.zzs(new zzqs(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static abstract class zzc<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzqr> {
        protected zzc(GoogleApiClient googleApiClient) {
            super(Panorama.zzUI, googleApiClient);
        }

        protected abstract void zza(Context context, zzqp com_google_android_gms_internal_zzqp) throws RemoteException;

        protected final void zza(zzqr com_google_android_gms_internal_zzqr) throws RemoteException {
            zza(com_google_android_gms_internal_zzqr.getContext(), (zzqp) com_google_android_gms_internal_zzqr.zzqJ());
        }
    }

    private static abstract class zza extends zzc<PanoramaResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected PanoramaResult zzbd(Status status) {
            return new zzqs(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbd(status);
        }
    }

    private static void zza(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    private static void zza(final Context context, zzqp com_google_android_gms_internal_zzqp, final zzqo com_google_android_gms_internal_zzqo, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        try {
            com_google_android_gms_internal_zzqp.zza(new com.google.android.gms.internal.zzqo.zza() {
                public void zza(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                    zzqq.zza(context, uri);
                    com_google_android_gms_internal_zzqo.zza(i, bundle, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            zza(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            zza(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(this, client) {
            final /* synthetic */ zzqq zzbdt;

            protected void zza(Context context, zzqp com_google_android_gms_internal_zzqp) throws RemoteException {
                com_google_android_gms_internal_zzqp.zza(new zzb(this), uri, null, false);
            }
        });
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(this, client) {
            final /* synthetic */ zzqq zzbdt;

            protected void zza(Context context, zzqp com_google_android_gms_internal_zzqp) throws RemoteException {
                zzqq.zza(context, com_google_android_gms_internal_zzqp, new zzb(this), uri, null);
            }
        });
    }
}
