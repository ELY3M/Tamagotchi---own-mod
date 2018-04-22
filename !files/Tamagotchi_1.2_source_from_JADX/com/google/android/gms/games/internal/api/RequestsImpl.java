package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {
        public LoadRequestSummariesResult zzaz(final Status status) {
            return new LoadRequestSummariesResult(this) {
                final /* synthetic */ LoadRequestSummariesImpl zzaHm;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaz(status);
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {
        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadRequestsResult zzaA(final Status status) {
            return new LoadRequestsResult(this) {
                final /* synthetic */ LoadRequestsImpl zzaHn;

                public GameRequestBuffer getRequests(int type) {
                    return new GameRequestBuffer(DataHolder.zzbI(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaA(status);
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {
        public SendRequestResult zzaB(final Status status) {
            return new SendRequestResult(this) {
                final /* synthetic */ SendRequestImpl zzaHo;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaB(status);
        }
    }

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {
        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateRequestsResult zzaC(final Status status) {
            return new UpdateRequestsResult(this) {
                final /* synthetic */ UpdateRequestsImpl zzaHp;

                public Set<String> getRequestIds() {
                    return null;
                }

                public int getRequestOutcome(String requestId) {
                    throw new IllegalArgumentException("Unknown request ID " + requestId);
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaC(status);
        }
    }

    class C12374 extends SendRequestImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String[] zzaHi;
        final /* synthetic */ int zzaHj;
        final /* synthetic */ byte[] zzaHk;
        final /* synthetic */ int zzaHl;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFQ, this.zzaHi, this.zzaHj, this.zzaHk, this.zzaHl);
        }
    }

    class C12385 extends SendRequestImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String[] zzaHi;
        final /* synthetic */ int zzaHj;
        final /* synthetic */ byte[] zzaHk;
        final /* synthetic */ int zzaHl;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFQ, this.zzaHi, this.zzaHj, this.zzaHk, this.zzaHl);
        }
    }

    class C12396 extends UpdateRequestsImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHa;
        final /* synthetic */ String[] zzaHe;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFQ, this.zzaHa, this.zzaHe);
        }
    }

    class C12407 extends LoadRequestsImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGl;
        final /* synthetic */ String zzaHa;
        final /* synthetic */ int zzaHg;
        final /* synthetic */ int zzaHh;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFQ, this.zzaHa, this.zzaHg, this.zzaHh, this.zzaGl);
        }
    }

    class C12418 extends LoadRequestSummariesImpl {
        final /* synthetic */ String zzaHa;
        final /* synthetic */ int zzaHh;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf(this, this.zzaHa, this.zzaHh);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.zzb(new UpdateRequestsImpl(this, apiClient) {
            final /* synthetic */ RequestsImpl zzaHf;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, strArr);
            }
        });
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.zzb(new UpdateRequestsImpl(this, apiClient) {
            final /* synthetic */ RequestsImpl zzaHf;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc((zzb) this, strArr);
            }
        });
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwM();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwO();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwN();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.zzh(apiClient).zza(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, int requestDirection, int types, int sortOrder) {
        final int i = requestDirection;
        final int i2 = types;
        final int i3 = sortOrder;
        return apiClient.zza(new LoadRequestsImpl(this, apiClient) {
            final /* synthetic */ RequestsImpl zzaHf;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, i, i2, i3);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzd(apiClient.zzr(listener));
        }
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzwG();
        }
    }
}
