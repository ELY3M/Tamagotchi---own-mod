package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

public class zzpb implements ConfigApi {

    private static class zza extends com.google.android.gms.internal.zzoj.zza {
        private final zzb<DataTypeResult> zzamC;

        private zza(zzb<DataTypeResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_DataTypeResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_DataTypeResult;
        }

        public void zza(DataTypeResult dataTypeResult) {
            this.zzamC.zzs(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient client, final DataTypeCreateRequest request) {
        return client.zzb(new zza<DataTypeResult>(this, client) {
            final /* synthetic */ zzpb zzazS;

            protected DataTypeResult zzJ(Status status) {
                return DataTypeResult.zzS(status);
            }

            protected void zza(zzoa com_google_android_gms_internal_zzoa) throws RemoteException {
                ((zzol) com_google_android_gms_internal_zzoa.zzqJ()).zza(new DataTypeCreateRequest(request, new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzJ(status);
            }
        });
    }

    public PendingResult<Status> disableFit(GoogleApiClient client) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpb zzazS;

            protected void zza(zzoa com_google_android_gms_internal_zzoa) throws RemoteException {
                ((zzol) com_google_android_gms_internal_zzoa.zzqJ()).zza(new DisableFitRequest(new zzph(this)));
            }
        });
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient client, final String dataTypeName) {
        return client.zza(new zza<DataTypeResult>(this, client) {
            final /* synthetic */ zzpb zzazS;

            protected DataTypeResult zzJ(Status status) {
                return DataTypeResult.zzS(status);
            }

            protected void zza(zzoa com_google_android_gms_internal_zzoa) throws RemoteException {
                ((zzol) com_google_android_gms_internal_zzoa.zzqJ()).zza(new DataTypeReadRequest(dataTypeName, new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzJ(status);
            }
        });
    }
}
