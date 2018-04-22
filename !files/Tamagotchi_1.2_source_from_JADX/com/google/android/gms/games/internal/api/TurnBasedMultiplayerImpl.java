package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    private static abstract class CancelMatchImpl extends BaseGamesApiMethodImpl<CancelMatchResult> {
        private final String zzyv;

        public CancelMatchImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzyv = id;
        }

        public CancelMatchResult zzaI(final Status status) {
            return new CancelMatchResult(this) {
                final /* synthetic */ CancelMatchImpl zzaHO;

                public String getMatchId() {
                    return this.zzaHO.zzyv;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaI(status);
        }
    }

    private static abstract class InitiateMatchImpl extends BaseGamesApiMethodImpl<InitiateMatchResult> {
        private InitiateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public InitiateMatchResult zzaJ(final Status status) {
            return new InitiateMatchResult(this) {
                final /* synthetic */ InitiateMatchImpl zzaHP;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaJ(status);
        }
    }

    private static abstract class LeaveMatchImpl extends BaseGamesApiMethodImpl<LeaveMatchResult> {
        private LeaveMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaveMatchResult zzaK(final Status status) {
            return new LeaveMatchResult(this) {
                final /* synthetic */ LeaveMatchImpl zzaHQ;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaK(status);
        }
    }

    private static abstract class LoadMatchImpl extends BaseGamesApiMethodImpl<LoadMatchResult> {
        private LoadMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchResult zzaL(final Status status) {
            return new LoadMatchResult(this) {
                final /* synthetic */ LoadMatchImpl zzaHR;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaL(status);
        }
    }

    private static abstract class LoadMatchesImpl extends BaseGamesApiMethodImpl<LoadMatchesResult> {
        private LoadMatchesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchesResult zzaM(final Status status) {
            return new LoadMatchesResult(this) {
                final /* synthetic */ LoadMatchesImpl zzaHS;

                public LoadMatchesResponse getMatches() {
                    return new LoadMatchesResponse(new Bundle());
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaM(status);
        }
    }

    private static abstract class UpdateMatchImpl extends BaseGamesApiMethodImpl<UpdateMatchResult> {
        private UpdateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateMatchResult zzaN(final Status status) {
            return new UpdateMatchResult(this) {
                final /* synthetic */ UpdateMatchImpl zzaHT;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaN(status);
        }
    }

    class AnonymousClass11 extends InitiateMatchImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHI;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaFQ, this.zzaHI);
        }
    }

    class AnonymousClass12 extends InitiateMatchImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHI;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaFQ, this.zzaHI);
        }
    }

    class AnonymousClass13 extends LoadMatchesImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaHJ;
        final /* synthetic */ int[] zzaHK;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFQ, this.zzaHJ, this.zzaHK);
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, final String invitationId) {
        return apiClient.zzb(new InitiateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzd((zzb) this, invitationId);
            }
        });
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.zzb(new CancelMatchImpl(this, apiClient, matchId) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf((zzb) this, matchId);
            }
        });
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient apiClient, final TurnBasedMatchConfig config) {
        return apiClient.zzb(new InitiateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, config);
            }
        });
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzr(invitationId, 1);
        }
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzq(invitationId, 1);
        }
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzdH(matchId);
        }
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, null, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, ParticipantResult... results) {
        final String str = matchId;
        final byte[] bArr = matchData;
        final ParticipantResult[] participantResultArr = results;
        return apiClient.zzb(new UpdateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, bArr, participantResultArr);
            }
        });
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwB();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwL();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.zzh(apiClient).zzb(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.zzh(apiClient).zzb(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.zzb(new LeaveMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zze((zzb) this, matchId);
            }
        });
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, final String matchId, final String pendingParticipantId) {
        return apiClient.zzb(new LeaveMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, matchId, pendingParticipantId);
            }
        });
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.zza(new LoadMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzg((zzb) this, matchId);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, final int invitationSortOrder, final int[] matchTurnStatuses) {
        return apiClient.zza(new LoadMatchesImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, invitationSortOrder, matchTurnStatuses);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzb(apiClient.zzr(listener));
        }
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.zzb(new InitiateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc((zzb) this, matchId);
            }
        });
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        final String str = matchId;
        final byte[] bArr = matchData;
        final String str2 = pendingParticipantId;
        final ParticipantResult[] participantResultArr = results;
        return apiClient.zzb(new UpdateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaHH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, bArr, str2, participantResultArr);
            }
        });
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzwE();
        }
    }
}
