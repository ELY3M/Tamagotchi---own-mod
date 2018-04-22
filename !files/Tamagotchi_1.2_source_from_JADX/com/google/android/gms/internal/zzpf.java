package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class zzpf implements SensorsApi {

    private interface zza {
        void zzuI();
    }

    private static class zzb extends com.google.android.gms.internal.zzoi.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<DataSourcesResult> zzamC;

        private zzb(com.google.android.gms.common.api.internal.zza.zzb<DataSourcesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_DataSourcesResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_DataSourcesResult;
        }

        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzamC.zzs(dataSourcesResult);
        }
    }

    private static class zzc extends com.google.android.gms.internal.zzow.zza {
        private final zza zzaAq;
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;

        private zzc(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, zza com_google_android_gms_internal_zzpf_zza) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
            this.zzaAq = com_google_android_gms_internal_zzpf_zza;
        }

        public void zzp(Status status) {
            if (this.zzaAq != null && status.isSuccess()) {
                this.zzaAq.zzuI();
            }
            this.zzamC.zzs(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, zzk com_google_android_gms_fitness_data_zzk, PendingIntent pendingIntent, zza com_google_android_gms_internal_zzpf_zza) {
        final zza com_google_android_gms_internal_zzpf_zza2 = com_google_android_gms_internal_zzpf_zza;
        final zzk com_google_android_gms_fitness_data_zzk2 = com_google_android_gms_fitness_data_zzk;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzpf zzaAi;

            protected void zza(zzoe com_google_android_gms_internal_zzoe) throws RemoteException {
                ((zzop) com_google_android_gms_internal_zzoe.zzqJ()).zza(new SensorUnregistrationRequest(com_google_android_gms_fitness_data_zzk2, pendingIntent2, new zzc(this, com_google_android_gms_internal_zzpf_zza2)));
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzk com_google_android_gms_fitness_data_zzk, PendingIntent pendingIntent) {
        final SensorRequest sensorRequest2 = sensorRequest;
        final zzk com_google_android_gms_fitness_data_zzk2 = com_google_android_gms_fitness_data_zzk;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzpf zzaAi;

            protected void zza(zzoe com_google_android_gms_internal_zzoe) throws RemoteException {
                ((zzop) com_google_android_gms_internal_zzoe.zzqJ()).zza(new SensorRegistrationRequest(sensorRequest2, com_google_android_gms_fitness_data_zzk2, pendingIntent2, new zzph(this)));
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, PendingIntent intent) {
        return zza(client, request, null, intent);
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, OnDataPointListener listener) {
        return zza(client, request, com.google.android.gms.fitness.data.zzl.zza.zzuu().zza(listener), null);
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient client, final DataSourcesRequest request) {
        return client.zza(new zza<DataSourcesResult>(this, client) {
            final /* synthetic */ zzpf zzaAi;

            protected DataSourcesResult zzN(Status status) {
                return DataSourcesResult.zzR(status);
            }

            protected void zza(zzoe com_google_android_gms_internal_zzoe) throws RemoteException {
                ((zzop) com_google_android_gms_internal_zzoe.zzqJ()).zza(new DataSourcesRequest(request, new zzb(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzN(status);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient client, PendingIntent pendingIntent) {
        return zza(client, null, pendingIntent, null);
    }

    public PendingResult<Status> remove(GoogleApiClient client, final OnDataPointListener listener) {
        zzk zzb = com.google.android.gms.fitness.data.zzl.zza.zzuu().zzb(listener);
        return zzb == null ? PendingResults.zza(Status.zzagC, client) : zza(client, zzb, null, new zza(this) {
            final /* synthetic */ zzpf zzaAi;

            public void zzuI() {
                com.google.android.gms.fitness.data.zzl.zza.zzuu().zzc(listener);
            }
        });
    }
}
