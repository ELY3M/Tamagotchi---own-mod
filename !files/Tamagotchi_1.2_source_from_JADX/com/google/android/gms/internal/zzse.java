package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenResponse;
import com.google.android.gms.wallet.firstparty.GetInstrumentsResponse;
import java.lang.ref.WeakReference;

public class zzse extends zzj<zzrz> {
    private final Context mContext;
    private final int mTheme;
    private final String zzVa;
    private final int zzbpM;
    private final boolean zzbpN;

    private static class zza extends com.google.android.gms.internal.zzsc.zza {
        private zza() {
        }

        public void zza(int i, FullWallet fullWallet, Bundle bundle) {
        }

        public void zza(int i, MaskedWallet maskedWallet, Bundle bundle) {
        }

        public void zza(int i, boolean z, Bundle bundle) {
        }

        public void zza(Status status, Bundle bundle) {
        }

        public void zza(Status status, GetBuyFlowInitializationTokenResponse getBuyFlowInitializationTokenResponse, Bundle bundle) {
        }

        public void zza(Status status, GetInstrumentsResponse getInstrumentsResponse, Bundle bundle) {
        }

        public void zza(Status status, boolean z, Bundle bundle) {
        }

        public void zzb(int i, boolean z, Bundle bundle) {
        }

        public void zzj(int i, Bundle bundle) {
        }
    }

    private static class zzb extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<BooleanResult> zzamC;

        public zzb(com.google.android.gms.common.api.internal.zza.zzb<BooleanResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_BooleanResult) {
            super();
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_BooleanResult;
        }

        public void zza(Status status, boolean z, Bundle bundle) {
            this.zzamC.zzs(new BooleanResult(status, z));
        }
    }

    static final class zzc extends zza {
        private final int zzagz;
        private final WeakReference<Activity> zzbqC;

        public zzc(Context context, int i) {
            super();
            this.zzbqC = new WeakReference((Activity) context);
            this.zzagz = i;
        }

        public void zza(int i, FullWallet fullWallet, Bundle bundle) {
            Activity activity = (Activity) this.zzbqC.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onFullWalletLoaded, Activity has gone");
                return;
            }
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzagz);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = activity.createPendingResult(this.zzagz, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void zza(int i, MaskedWallet maskedWallet, Bundle bundle) {
            Activity activity = (Activity) this.zzbqC.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onMaskedWalletLoaded, Activity has gone");
                return;
            }
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzagz);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = activity.createPendingResult(this.zzagz, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void zza(int i, boolean z, Bundle bundle) {
            Activity activity = (Activity) this.zzbqC.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onPreAuthorizationDetermined, Activity has gone");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent createPendingResult = activity.createPendingResult(this.zzagz, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (Throwable e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        public void zza(Status status, boolean z, Bundle bundle) {
            Activity activity = (Activity) this.zzbqC.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onIsReadyToPayDetermined, Activity has gone");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_READY_TO_PAY, z);
            PendingIntent createPendingResult = activity.createPendingResult(this.zzagz, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onIsReadyToPayDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (Throwable e) {
                Log.w("WalletClientImpl", "Exception setting pending result in onIsReadyToPayDetermined", e);
            }
        }

        public void zzb(int i, boolean z, Bundle bundle) {
            Activity activity = (Activity) this.zzbqC.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onIsNewUserDetermined, Activity has gone");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_NEW_USER, z);
            PendingIntent createPendingResult = activity.createPendingResult(this.zzagz, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onIsNewUserDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (Throwable e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        public void zzj(int i, Bundle bundle) {
            zzx.zzb((Object) bundle, (Object) "Bundle should not be null");
            Activity activity = (Activity) this.zzbqC.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onWalletObjectsCreated, Activity has gone");
                return;
            }
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzagz);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, WalletConstants.ERROR_CODE_UNKNOWN);
            PendingIntent createPendingResult = activity.createPendingResult(this.zzagz, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                return;
            }
            try {
                createPendingResult.send(1);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }
    }

    public zzse(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i, int i2, boolean z) {
        super(context, looper, 4, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.mContext = context;
        this.zzbpM = i;
        this.zzVa = com_google_android_gms_common_internal_zzf.getAccountName();
        this.mTheme = i2;
        this.zzbpN = z;
    }

    private Bundle zzIp() {
        return zza(this.zzbpM, this.mContext.getPackageName(), this.zzVa, this.mTheme, this.zzbpN);
    }

    public static Bundle zza(int i, String str, String str2, int i2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putBoolean("com.google.android.gms.wallet.EXTRA_USING_ANDROID_PAY_BRAND", z);
        bundle.putString("androidPackageName", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str2, "com.google"));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzep(iBinder);
    }

    public void zza(FullWalletRequest fullWalletRequest, int i) {
        zzsc com_google_android_gms_internal_zzse_zzc = new zzc(this.mContext, i);
        try {
            ((zzrz) zzqJ()).zza(fullWalletRequest, zzIp(), com_google_android_gms_internal_zzse_zzc);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            com_google_android_gms_internal_zzse_zzc.zza(8, null, Bundle.EMPTY);
        }
    }

    public void zza(IsReadyToPayRequest isReadyToPayRequest, com.google.android.gms.common.api.internal.zza.zzb<BooleanResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_BooleanResult) {
        zzsc com_google_android_gms_internal_zzse_zzb = new zzb(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_BooleanResult);
        try {
            ((zzrz) zzqJ()).zza(isReadyToPayRequest, zzIp(), com_google_android_gms_internal_zzse_zzb);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during isReadyToPay", e);
            com_google_android_gms_internal_zzse_zzb.zza(Status.zzagE, false, Bundle.EMPTY);
        }
    }

    public void zza(MaskedWalletRequest maskedWalletRequest, int i) {
        Bundle zzIp = zzIp();
        zzsc com_google_android_gms_internal_zzse_zzc = new zzc(this.mContext, i);
        try {
            ((zzrz) zzqJ()).zza(maskedWalletRequest, zzIp, com_google_android_gms_internal_zzse_zzc);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            com_google_android_gms_internal_zzse_zzc.zza(8, null, Bundle.EMPTY);
        }
    }

    public void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        try {
            ((zzrz) zzqJ()).zza(notifyTransactionStatusRequest, zzIp());
        } catch (RemoteException e) {
        }
    }

    protected zzrz zzep(IBinder iBinder) {
        return com.google.android.gms.internal.zzrz.zza.zzel(iBinder);
    }

    public void zzf(String str, String str2, int i) {
        Bundle zzIp = zzIp();
        Object com_google_android_gms_internal_zzse_zzc = new zzc(this.mContext, i);
        try {
            ((zzrz) zzqJ()).zza(str, str2, zzIp, com_google_android_gms_internal_zzse_zzc);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            com_google_android_gms_internal_zzse_zzc.zza(8, null, Bundle.EMPTY);
        }
    }

    protected String zzgu() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    protected String zzgv() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public void zzln(int i) {
        Bundle zzIp = zzIp();
        zzsc com_google_android_gms_internal_zzse_zzc = new zzc(this.mContext, i);
        try {
            ((zzrz) zzqJ()).zza(zzIp, com_google_android_gms_internal_zzse_zzc);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            com_google_android_gms_internal_zzse_zzc.zza(8, false, Bundle.EMPTY);
        }
    }

    public void zzlo(int i) {
        Bundle zzIp = zzIp();
        Object com_google_android_gms_internal_zzse_zzc = new zzc(this.mContext, i);
        try {
            ((zzrz) zzqJ()).zzb(zzIp, com_google_android_gms_internal_zzse_zzc);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during isNewUser", e);
            com_google_android_gms_internal_zzse_zzc.zzb(8, false, Bundle.EMPTY);
        }
    }

    public boolean zzqK() {
        return true;
    }
}
