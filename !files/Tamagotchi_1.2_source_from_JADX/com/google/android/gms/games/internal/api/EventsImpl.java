package com.google.android.gms.games.internal.api;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadEventsResult zzaf(final Status status) {
            return new LoadEventsResult(this) {
                final /* synthetic */ LoadImpl zzaGe;

                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.zzbI(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaf(status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {
        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Result zzc(final Status status) {
            return new Result(this) {
                final /* synthetic */ UpdateImpl zzaGf;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @SuppressLint({"MissingRemoteException"})
    public void increment(GoogleApiClient apiClient, final String eventId, final int incrementAmount) {
        GamesClientImpl zzc = Games.zzc(apiClient, false);
        if (zzc != null) {
            if (zzc.isConnected()) {
                zzc.zzp(eventId, incrementAmount);
            } else {
                apiClient.zzb(new UpdateImpl(this, apiClient) {
                    final /* synthetic */ EventsImpl zzaGb;

                    public void zza(GamesClientImpl gamesClientImpl) {
                        gamesClientImpl.zzp(eventId, incrementAmount);
                    }
                });
            }
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadImpl(this, apiClient) {
            final /* synthetic */ EventsImpl zzaGb;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzd((zzb) this, forceReload);
            }
        });
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... eventIds) {
        return apiClient.zza(new LoadImpl(this, apiClient) {
            final /* synthetic */ EventsImpl zzaGb;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, forceReload, eventIds);
            }
        });
    }
}
