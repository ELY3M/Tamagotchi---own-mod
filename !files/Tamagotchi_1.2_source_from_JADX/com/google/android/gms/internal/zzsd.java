package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.zza;
import com.google.android.gms.wallet.Wallet.zzb;

@SuppressLint({"MissingRemoteException"})
public class zzsd implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        final String str = googleTransactionId;
        final String str2 = merchantTransactionId;
        final int i = requestCode;
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzsd zzbqw;

            protected void zza(zzse com_google_android_gms_internal_zzse) {
                com_google_android_gms_internal_zzse.zzf(str, str2, i);
                zza(Status.zzagC);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzsd zzbqw;

            protected void zza(zzse com_google_android_gms_internal_zzse) {
                com_google_android_gms_internal_zzse.zzln(requestCode);
                zza(Status.zzagC);
            }
        });
    }

    public void isNewUser(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzsd zzbqw;

            protected void zza(zzse com_google_android_gms_internal_zzse) {
                com_google_android_gms_internal_zzse.zzlo(requestCode);
                zza(Status.zzagC);
            }
        });
    }

    public PendingResult<BooleanResult> isReadyToPay(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza<BooleanResult>(this, googleApiClient) {
            final /* synthetic */ zzsd zzbqw;

            protected BooleanResult zzA(Status status) {
                return new BooleanResult(status, false);
            }

            protected void zza(zzse com_google_android_gms_internal_zzse) {
                com_google_android_gms_internal_zzse.zza(IsReadyToPayRequest.zzIj().zzIk(), (com.google.android.gms.common.api.internal.zza.zzb) this);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzA(status);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzsd zzbqw;

            protected void zza(zzse com_google_android_gms_internal_zzse) {
                com_google_android_gms_internal_zzse.zza(request, requestCode);
                zza(Status.zzagC);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzsd zzbqw;

            protected void zza(zzse com_google_android_gms_internal_zzse) {
                com_google_android_gms_internal_zzse.zza(request, requestCode);
                zza(Status.zzagC);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzsd zzbqw;

            protected void zza(zzse com_google_android_gms_internal_zzse) {
                com_google_android_gms_internal_zzse.zza(request);
                zza(Status.zzagC);
            }
        });
    }
}
