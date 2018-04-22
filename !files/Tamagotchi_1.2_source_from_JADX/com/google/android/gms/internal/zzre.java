package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.AttestationResult;
import com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult;
import java.util.List;

public class zzre implements SafetyNetApi {

    static class zza implements AttestationResult {
        private final Status zzUX;
        private final AttestationData zzbgB;

        public zza(Status status, AttestationData attestationData) {
            this.zzUX = status;
            this.zzbgB = attestationData;
        }

        public String getJwsResult() {
            return this.zzbgB == null ? null : this.zzbgB.getJwsResult();
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    static class zzd implements SafeBrowsingResult {
        private Status zzUX;
        private final SafeBrowsingData zzbgF;
        private String zzbgv = null;

        public zzd(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzUX = status;
            this.zzbgF = safeBrowsingData;
            if (this.zzbgF != null) {
                this.zzbgv = this.zzbgF.getMetadata();
            } else if (this.zzUX.isSuccess()) {
                this.zzUX = new Status(8);
            }
        }

        public String getMetadata() {
            return this.zzbgv;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    static abstract class zzb extends zzrb<AttestationResult> {
        protected zzrc zzbgC = new C10741(this);

        class C10741 extends zzra {
            final /* synthetic */ zzb zzbgD;

            C10741(zzb com_google_android_gms_internal_zzre_zzb) {
                this.zzbgD = com_google_android_gms_internal_zzre_zzb;
            }

            public void zza(Status status, AttestationData attestationData) {
                this.zzbgD.zza(new zza(status, attestationData));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected AttestationResult zzbh(Status status) {
            return new zza(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbh(status);
        }
    }

    static abstract class zzc extends zzrb<SafeBrowsingResult> {
        protected zzrc zzbgC = new C10751(this);

        class C10751 extends zzra {
            final /* synthetic */ zzc zzbgE;

            C10751(zzc com_google_android_gms_internal_zzre_zzc) {
                this.zzbgE = com_google_android_gms_internal_zzre_zzc;
            }

            public void zza(Status status, SafeBrowsingData safeBrowsingData) {
                this.zzbgE.zza(new zzd(status, safeBrowsingData));
            }
        }

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected SafeBrowsingResult zzbi(Status status) {
            return new zzd(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbi(status);
        }
    }

    public PendingResult<AttestationResult> attest(GoogleApiClient googleApiClient, final byte[] nonce) {
        return googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzre zzbgy;

            protected void zza(zzrf com_google_android_gms_internal_zzrf) throws RemoteException {
                com_google_android_gms_internal_zzrf.zza(this.zzbgC, nonce);
            }
        });
    }

    public PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, final List<Integer> threatTypes, final String uri) {
        if (threatTypes == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(uri)) {
            return googleApiClient.zza(new zzc(this, googleApiClient) {
                final /* synthetic */ zzre zzbgy;

                protected void zza(zzrf com_google_android_gms_internal_zzrf) throws RemoteException {
                    com_google_android_gms_internal_zzrf.zza(this.zzbgC, threatTypes, 1, uri);
                }
            });
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }
}
