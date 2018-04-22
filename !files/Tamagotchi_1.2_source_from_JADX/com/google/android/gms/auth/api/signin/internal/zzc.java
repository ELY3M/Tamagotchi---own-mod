package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;

public class zzc implements GoogleSignInApi {

    private abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzd> {
        final /* synthetic */ zzc zzXs;

        public zza(zzc com_google_android_gms_auth_api_signin_internal_zzc, GoogleApiClient googleApiClient) {
            this.zzXs = com_google_android_gms_auth_api_signin_internal_zzc;
            super(Auth.zzVx, googleApiClient);
        }
    }

    private OptionalPendingResult<GoogleSignInResult> zza(GoogleApiClient googleApiClient, final GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "trySilentSignIn");
        return new zzr(googleApiClient.zza(new zza<GoogleSignInResult>(this, googleApiClient) {
            final /* synthetic */ zzc zzXs;

            protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
                final zzq zzaf = zzq.zzaf(com_google_android_gms_auth_api_signin_internal_zzd.getContext());
                ((zzh) com_google_android_gms_auth_api_signin_internal_zzd.zzqJ()).zza(new zza(this) {
                    final /* synthetic */ C10851 zzXu;

                    public void zza(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
                        if (googleSignInAccount != null) {
                            zzaf.zzb(googleSignInAccount, googleSignInOptions);
                        }
                        this.zzXu.zza(new GoogleSignInResult(googleSignInAccount, status));
                    }
                }, googleSignInOptions);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzn(status);
            }

            protected GoogleSignInResult zzn(Status status) {
                return new GoogleSignInResult(null, status);
            }
        }));
    }

    private boolean zza(Account account, Account account2) {
        return account == null ? account2 == null : account.equals(account2);
    }

    private GoogleSignInOptions zzb(GoogleApiClient googleApiClient) {
        return ((zzd) googleApiClient.zza(Auth.zzVx)).zznd();
    }

    public Intent getSignInIntent(GoogleApiClient client) {
        zzx.zzz(client);
        return ((zzd) client.zza(Auth.zzVx)).zznc();
    }

    public GoogleSignInResult getSignInResultFromIntent(Intent data) {
        if (data == null || (!data.hasExtra("googleSignInStatus") && !data.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) data.getParcelableExtra("googleSignInAccount");
        Status status = (Status) data.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.zzagC;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }

    public PendingResult<Status> revokeAccess(GoogleApiClient client) {
        zzq.zzaf(client.getContext()).zznr();
        for (GoogleApiClient zzoW : GoogleApiClient.zzoV()) {
            zzoW.zzoW();
        }
        return client.zzb(new zza<Status>(this, client) {
            final /* synthetic */ zzc zzXs;

            class C10571 extends zza {
                final /* synthetic */ C10873 zzXw;

                C10571(C10873 c10873) {
                    this.zzXw = c10873;
                }

                public void zzm(Status status) throws RemoteException {
                    this.zzXw.zza((Result) status);
                }
            }

            protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
                ((zzh) com_google_android_gms_auth_api_signin_internal_zzd.zzqJ()).zzc(new C10571(this), com_google_android_gms_auth_api_signin_internal_zzd.zznd());
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingResult<Status> signOut(GoogleApiClient client) {
        zzq.zzaf(client.getContext()).zznr();
        for (GoogleApiClient zzoW : GoogleApiClient.zzoV()) {
            zzoW.zzoW();
        }
        return client.zzb(new zza<Status>(this, client) {
            final /* synthetic */ zzc zzXs;

            class C10561 extends zza {
                final /* synthetic */ C10862 zzXv;

                C10561(C10862 c10862) {
                    this.zzXv = c10862;
                }

                public void zzl(Status status) throws RemoteException {
                    this.zzXv.zza((Result) status);
                }
            }

            protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
                ((zzh) com_google_android_gms_auth_api_signin_internal_zzd.zzqJ()).zzb(new C10561(this), com_google_android_gms_auth_api_signin_internal_zzd.zznd());
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient client) {
        GoogleSignInOptions zzb = zzb(client);
        Result zza = zza(client.getContext(), zzb);
        return zza != null ? PendingResults.zzb(zza, client) : zza(client, zzb);
    }

    public GoogleSignInResult zza(Context context, GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "getSavedSignInResultIfEligible");
        zzx.zzz(googleSignInOptions);
        zzq zzaf = zzq.zzaf(context);
        GoogleSignInOptions zznp = zzaf.zznp();
        if (zznp == null || !zza(zznp.getAccount(), googleSignInOptions.getAccount()) || googleSignInOptions.zzmP()) {
            return null;
        }
        if ((googleSignInOptions.zzmO() && (!zznp.zzmO() || !googleSignInOptions.zzmR().equals(zznp.zzmR()))) || !new HashSet(zznp.zzmN()).containsAll(new HashSet(googleSignInOptions.zzmN()))) {
            return null;
        }
        GoogleSignInAccount zzno = zzaf.zzno();
        return (zzno == null || zzno.zzb()) ? null : new GoogleSignInResult(zzno, Status.zzagC);
    }
}
