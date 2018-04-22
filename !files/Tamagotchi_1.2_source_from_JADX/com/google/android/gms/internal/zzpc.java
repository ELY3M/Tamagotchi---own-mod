package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;

public class zzpc implements HistoryApi {

    private static class zza extends com.google.android.gms.internal.zzoh.zza {
        private int zzaAc;
        private DataReadResult zzaAd;
        private final zzb<DataReadResult> zzamC;

        private zza(zzb<DataReadResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_DataReadResult) {
            this.zzaAc = 0;
            this.zzaAd = null;
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_DataReadResult;
        }

        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                if (Log.isLoggable("Fitness", 2)) {
                    Log.v("Fitness", "Received batch result " + this.zzaAc);
                }
                if (this.zzaAd == null) {
                    this.zzaAd = dataReadResult;
                } else {
                    this.zzaAd.zzb(dataReadResult);
                }
                this.zzaAc++;
                if (this.zzaAc == this.zzaAd.zzvj()) {
                    this.zzamC.zzs(this.zzaAd);
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final DataSet dataSet, final boolean z) {
        zzx.zzb((Object) dataSet, (Object) "Must set the data set");
        zzx.zza(!dataSet.getDataPoints().isEmpty(), (Object) "Cannot use an empty data set");
        zzx.zzb(dataSet.getDataSource().zzum(), (Object) "Must set the app package name for the data source");
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzpc zzazW;

            protected void zza(zzob com_google_android_gms_internal_zzob) throws RemoteException {
                ((zzom) com_google_android_gms_internal_zzob.zzqJ()).zza(new DataInsertRequest(dataSet, new zzph(this), z));
            }
        });
    }

    public PendingResult<Status> deleteData(GoogleApiClient client, final DataDeleteRequest request) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzpc zzazW;

            protected void zza(zzob com_google_android_gms_internal_zzob) throws RemoteException {
                ((zzom) com_google_android_gms_internal_zzob.zzqJ()).zza(new DataDeleteRequest(request, new zzph(this)));
            }
        });
    }

    public PendingResult<Status> insertData(GoogleApiClient client, DataSet dataSet) {
        return zza(client, dataSet, false);
    }

    public PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient client, final DataType dataType) {
        return client.zza(new zza<DailyTotalResult>(this, client) {
            final /* synthetic */ zzpc zzazW;

            class C10081 extends com.google.android.gms.internal.zzog.zza {
                final /* synthetic */ C11025 zzaAb;

                C10081(C11025 c11025) {
                    this.zzaAb = c11025;
                }

                public void zza(DailyTotalResult dailyTotalResult) throws RemoteException {
                    this.zzaAb.zza((Result) dailyTotalResult);
                }
            }

            protected DailyTotalResult zzL(Status status) {
                return DailyTotalResult.zza(status, dataType);
            }

            protected void zza(zzob com_google_android_gms_internal_zzob) throws RemoteException {
                ((zzom) com_google_android_gms_internal_zzob.zzqJ()).zza(new DailyTotalRequest(new C10081(this), dataType));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzL(status);
            }
        });
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient client, final DataReadRequest request) {
        return client.zza(new zza<DataReadResult>(this, client) {
            final /* synthetic */ zzpc zzazW;

            protected DataReadResult zzK(Status status) {
                return DataReadResult.zza(status, request);
            }

            protected void zza(zzob com_google_android_gms_internal_zzob) throws RemoteException {
                ((zzom) com_google_android_gms_internal_zzob.zzqJ()).zza(new DataReadRequest(request, new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzK(status);
            }
        });
    }

    public PendingResult<Status> updateData(GoogleApiClient client, final DataUpdateRequest request) {
        zzx.zzb(request.getDataSet(), (Object) "Must set the data set");
        zzx.zza(request.zzlO(), (Object) "Must set a non-zero value for startTimeMillis/startTime");
        zzx.zza(request.zzud(), (Object) "Must set a non-zero value for endTimeMillis/endTime");
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzpc zzazW;

            protected void zza(zzob com_google_android_gms_internal_zzob) throws RemoteException {
                ((zzom) com_google_android_gms_internal_zzob.zzqJ()).zza(new DataUpdateRequest(request, new zzph(this)));
            }
        });
    }
}
