package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

public class zzrk implements SearchAuthApi {

    static abstract class zza extends com.google.android.gms.internal.zzrh.zza {
        zza() {
        }

        public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
            throw new UnsupportedOperationException();
        }

        public void zzbj(Status status) {
            throw new UnsupportedOperationException();
        }
    }

    static class zzd implements GoogleNowAuthResult {
        private final Status zzUX;
        private final GoogleNowAuthState zzbgO;

        zzd(Status status, GoogleNowAuthState googleNowAuthState) {
            this.zzUX = status;
            this.zzbgO = googleNowAuthState;
        }

        public GoogleNowAuthState getGoogleNowAuthState() {
            return this.zzbgO;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    static class zzb extends com.google.android.gms.common.api.internal.zza.zza<Status, zzrj> {
        private final String zzXI;
        private final String zzbgJ;
        private final boolean zzbgK = Log.isLoggable("SearchAuth", 3);

        class C10761 extends zza {
            final /* synthetic */ zzb zzbgL;

            C10761(zzb com_google_android_gms_internal_zzrk_zzb) {
                this.zzbgL = com_google_android_gms_internal_zzrk_zzb;
            }

            public void zzbj(Status status) {
                if (this.zzbgL.zzbgK) {
                    Log.d("SearchAuth", "ClearTokenImpl success");
                }
                this.zzbgL.zza((Result) status);
            }
        }

        protected zzb(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzUI, googleApiClient);
            this.zzXI = str;
            this.zzbgJ = googleApiClient.getContext().getPackageName();
        }

        protected void zza(zzrj com_google_android_gms_internal_zzrj) throws RemoteException {
            if (this.zzbgK) {
                Log.d("SearchAuth", "ClearTokenImpl started");
            }
            ((zzri) com_google_android_gms_internal_zzrj.zzqJ()).zzb(new C10761(this), this.zzbgJ, this.zzXI);
        }

        protected Status zzb(Status status) {
            if (this.zzbgK) {
                Log.d("SearchAuth", "ClearTokenImpl received failure: " + status.getStatusMessage());
            }
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    static class zzc extends com.google.android.gms.common.api.internal.zza.zza<GoogleNowAuthResult, zzrj> {
        private final String zzbgJ;
        private final boolean zzbgK = Log.isLoggable("SearchAuth", 3);
        private final String zzbgM;

        class C10771 extends zza {
            final /* synthetic */ zzc zzbgN;

            C10771(zzc com_google_android_gms_internal_zzrk_zzc) {
                this.zzbgN = com_google_android_gms_internal_zzrk_zzc;
            }

            public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
                if (this.zzbgN.zzbgK) {
                    Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                }
                this.zzbgN.zza(new zzd(status, googleNowAuthState));
            }
        }

        protected zzc(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzUI, googleApiClient);
            this.zzbgM = str;
            this.zzbgJ = googleApiClient.getContext().getPackageName();
        }

        protected void zza(zzrj com_google_android_gms_internal_zzrj) throws RemoteException {
            if (this.zzbgK) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            ((zzri) com_google_android_gms_internal_zzrj.zzqJ()).zza(new C10771(this), this.zzbgJ, this.zzbgM);
        }

        protected GoogleNowAuthResult zzbk(Status status) {
            if (this.zzbgK) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl received failure: " + status.getStatusMessage());
            }
            return new zzd(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbk(status);
        }
    }

    public PendingResult<Status> clearToken(GoogleApiClient client, String accessToken) {
        return client.zza(new zzb(client, accessToken));
    }

    public PendingResult<GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient client, String webAppClientId) {
        return client.zza(new zzc(client, webAppClientId));
    }
}
