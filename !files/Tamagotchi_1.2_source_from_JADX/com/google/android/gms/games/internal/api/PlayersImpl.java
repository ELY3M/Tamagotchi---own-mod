package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {
        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayersResult zzas(final Status status) {
            return new LoadPlayersResult(this) {
                final /* synthetic */ LoadPlayersImpl zzaGR;

                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.zzbI(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzas(status);
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {
        protected LoadProfileSettingsResult zzat(final Status status) {
            return new LoadProfileSettingsResult(this) {
                final /* synthetic */ LoadProfileSettingsResultImpl zzaGS;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzat(status);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {
        public LoadXpForGameCategoriesResult zzau(final Status status) {
            return new LoadXpForGameCategoriesResult(this) {
                final /* synthetic */ LoadXpForGameCategoriesResultImpl zzaGT;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzau(status);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {
        public LoadXpStreamResult zzav(final Status status) {
            return new LoadXpStreamResult(this) {
                final /* synthetic */ LoadXpStreamResultImpl zzaGU;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzav(status);
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", this.zzaFQ, this.zzaGL, true, false);
        }
    }

    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzaFQ, this.zzaGL, false, this.zzaFO);
        }
    }

    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzaFQ, this.zzaGL, true, false);
        }
    }

    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaGL, false, this.zzaFO);
        }
    }

    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaGL, true, false);
        }
    }

    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaGL, false, this.zzaFO);
        }
    }

    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaGL, true, false);
        }
    }

    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzaGL, false, this.zzaFO);
        }
    }

    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzaGL, true, false);
        }
    }

    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGh;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaGh, this.zzaGL, false, this.zzaFO);
        }
    }

    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGh;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaGh, this.zzaGL, true, false);
        }
    }

    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaGC;
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGM;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaGM, this.zzaGC, this.zzaGL, false, this.zzaFO);
        }
    }

    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ String zzaGC;
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGM;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaGM, this.zzaGC, this.zzaGL, true, false);
        }
    }

    class AnonymousClass23 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String zzaGN;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this, this.zzaGN);
        }
    }

    class AnonymousClass24 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzaGN;
        final /* synthetic */ int zzaGO;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaGN, this.zzaGO);
        }
    }

    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzaGN;
        final /* synthetic */ int zzaGO;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaGN, this.zzaGO);
        }
    }

    class AnonymousClass26 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaFO;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg((zzb) this, this.zzaFO);
        }
    }

    class AnonymousClass27 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaGP;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb) this, this.zzaGP);
        }
    }

    class C12213 extends LoadPlayersImpl {
        final /* synthetic */ String[] zzaGQ;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaGQ);
        }
    }

    class C12279 extends LoadPlayersImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", this.zzaFQ, this.zzaGL, false, false);
        }
    }

    public Intent getCompareProfileIntent(GoogleApiClient apiClient, Player player) {
        return Games.zzh(apiClient).zza(new PlayerEntity(player));
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwx();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzah(true);
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwH();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaGK;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaGK;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, pageSize, false, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaGK;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaGK;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, "played_with", pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaGK;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, playerId, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaGK;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, playerId, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaGK;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, "played_with", pageSize, false, forceReload);
            }
        });
    }
}
