package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzsa.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class zzsf extends zzg<zzsa> {
    private static zzsf zzbqD;

    protected zzsf() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    private static zzsf zzIq() {
        if (zzbqD == null) {
            zzbqD = new zzsf();
        }
        return zzbqD;
    }

    public static zzrx zza(Activity activity, zzc com_google_android_gms_dynamic_zzc, WalletFragmentOptions walletFragmentOptions, zzry com_google_android_gms_internal_zzry) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((zzsa) zzIq().zzaB(activity)).zza(zze.zzC(activity), com_google_android_gms_dynamic_zzc, walletFragmentOptions, com_google_android_gms_internal_zzry);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzeq(iBinder);
    }

    protected zzsa zzeq(IBinder iBinder) {
        return zza.zzem(iBinder);
    }
}
