package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public class zzpe implements RecordingApi {

    private static class zza extends com.google.android.gms.internal.zzor.zza {
        private final zzb<ListSubscriptionsResult> zzamC;

        private zza(zzb<ListSubscriptionsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult;
        }

        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzamC.zzs(listSubscriptionsResult);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final Subscription subscription) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzpe zzaAe;

            protected void zza(zzod com_google_android_gms_internal_zzod) throws RemoteException {
                ((zzoo) com_google_android_gms_internal_zzod.zzqJ()).zza(new SubscribeRequest(subscription, false, new zzph(this)));
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client) {
        return client.zza(new zza<ListSubscriptionsResult>(this, client) {
            final /* synthetic */ zzpe zzaAe;

            protected ListSubscriptionsResult zzM(Status status) {
                return ListSubscriptionsResult.zzT(status);
            }

            protected void zza(zzod com_google_android_gms_internal_zzod) throws RemoteException {
                ((zzoo) com_google_android_gms_internal_zzod.zzqJ()).zza(new ListSubscriptionsRequest(null, new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzM(status);
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client, final DataType dataType) {
        return client.zza(new zza<ListSubscriptionsResult>(this, client) {
            final /* synthetic */ zzpe zzaAe;

            protected ListSubscriptionsResult zzM(Status status) {
                return ListSubscriptionsResult.zzT(status);
            }

            protected void zza(zzod com_google_android_gms_internal_zzod) throws RemoteException {
                ((zzoo) com_google_android_gms_internal_zzod.zzqJ()).zza(new ListSubscriptionsRequest(dataType, new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzM(status);
            }
        });
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataSource dataSource) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataSource).zzuz());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataType dataType) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataType).zzuz());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataSource dataSource) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpe zzaAe;

            protected void zza(zzod com_google_android_gms_internal_zzod) throws RemoteException {
                ((zzoo) com_google_android_gms_internal_zzod.zzqJ()).zza(new UnsubscribeRequest(null, dataSource, new zzph(this)));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataType dataType) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpe zzaAe;

            protected void zza(zzod com_google_android_gms_internal_zzod) throws RemoteException {
                ((zzoo) com_google_android_gms_internal_zzod.zzqJ()).zza(new UnsubscribeRequest(dataType, null, new zzph(this)));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(client, subscription.getDataSource()) : unsubscribe(client, subscription.getDataType());
    }
}
