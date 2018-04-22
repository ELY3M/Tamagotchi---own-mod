package com.google.android.gms.auth.api.credentials.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;

public final class zzd implements CredentialsApi {

    private static class zza extends zza {
        private zzb<Status> zzWz;

        zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzWz = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzg(Status status) {
            this.zzWz.zzs(status);
        }
    }

    private PasswordSpecification zza(GoogleApiClient googleApiClient) {
        AuthCredentialsOptions zzmD = ((zzf) googleApiClient.zza(Auth.zzVu)).zzmD();
        return (zzmD == null || zzmD.zzmr() == null) ? PasswordSpecification.zzWl : zzmD.zzmr();
    }

    public PendingResult<Status> delete(GoogleApiClient client, final Credential credential) {
        return client.zzb(new zze<Status>(this, client) {
            final /* synthetic */ zzd zzWw;

            protected void zza(Context context, zzj com_google_android_gms_auth_api_credentials_internal_zzj) throws RemoteException {
                com_google_android_gms_auth_api_credentials_internal_zzj.zza(new zza(this), new DeleteRequest(credential));
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingResult<Status> disableAutoSignIn(GoogleApiClient client) {
        return client.zzb(new zze<Status>(this, client) {
            final /* synthetic */ zzd zzWw;

            protected void zza(Context context, zzj com_google_android_gms_auth_api_credentials_internal_zzj) throws RemoteException {
                com_google_android_gms_auth_api_credentials_internal_zzj.zza(new zza(this));
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingIntent getHintPickerIntent(GoogleApiClient client, HintRequest request) {
        zzx.zzb((Object) client, (Object) "client must not be null");
        zzx.zzb((Object) request, (Object) "request must not be null");
        zzx.zzb(client.zza(Auth.CREDENTIALS_API), (Object) "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
        return PendingIntent.getActivity(client.getContext(), 2000, zzb.zza(client.getContext(), request, zza(client)), DriveFile.MODE_READ_ONLY);
    }

    public PendingResult<CredentialRequestResult> request(GoogleApiClient client, final CredentialRequest request) {
        return client.zza(new zze<CredentialRequestResult>(this, client) {
            final /* synthetic */ zzd zzWw;

            class C10541 extends zza {
                final /* synthetic */ C10811 zzWx;

                C10541(C10811 c10811) {
                    this.zzWx = c10811;
                }

                public void zza(Status status, Credential credential) {
                    this.zzWx.zza(new zzc(status, credential));
                }

                public void zzg(Status status) {
                    this.zzWx.zza(zzc.zzh(status));
                }
            }

            protected void zza(Context context, zzj com_google_android_gms_auth_api_credentials_internal_zzj) throws RemoteException {
                com_google_android_gms_auth_api_credentials_internal_zzj.zza(new C10541(this), request);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzi(status);
            }

            protected CredentialRequestResult zzi(Status status) {
                return zzc.zzh(status);
            }
        });
    }

    public PendingResult<Status> save(GoogleApiClient client, final Credential credential) {
        return client.zzb(new zze<Status>(this, client) {
            final /* synthetic */ zzd zzWw;

            protected void zza(Context context, zzj com_google_android_gms_auth_api_credentials_internal_zzj) throws RemoteException {
                com_google_android_gms_auth_api_credentials_internal_zzj.zza(new zza(this), new SaveRequest(credential));
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }
}
