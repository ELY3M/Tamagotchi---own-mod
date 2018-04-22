package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpn;

public final class Address {
    public static final Api<AddressOptions> API = new Api("Address.API", zzUJ, zzUI);
    static final zzc<zzpn> zzUI = new zzc();
    private static final com.google.android.gms.common.api.Api.zza<zzpn, AddressOptions> zzUJ = new C07371();

    static class C07371 extends com.google.android.gms.common.api.Api.zza<zzpn, AddressOptions> {
        C07371() {
        }

        public zzpn zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new zzpn((Activity) context, looper, com_google_android_gms_common_internal_zzf, addressOptions.theme, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    private static abstract class zza extends com.google.android.gms.common.api.internal.zza.zza<Status, zzpn> {
        public zza(GoogleApiClient googleApiClient) {
            super(Address.zzUI, googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.zza(new zza(googleApiClient) {
            protected void zza(zzpn com_google_android_gms_internal_zzpn) throws RemoteException {
                com_google_android_gms_internal_zzpn.zza(request, requestCode);
                zza(Status.zzagC);
            }
        });
    }
}
