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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl implements Leaderboards {

    private static abstract class LoadMetadataImpl extends BaseGamesApiMethodImpl<LeaderboardMetadataResult> {
        private LoadMetadataImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaderboardMetadataResult zzak(final Status status) {
            return new LeaderboardMetadataResult(this) {
                final /* synthetic */ LoadMetadataImpl zzaGy;

                public LeaderboardBuffer getLeaderboards() {
                    return new LeaderboardBuffer(DataHolder.zzbI(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzak(status);
        }
    }

    private static abstract class LoadPlayerScoreImpl extends BaseGamesApiMethodImpl<LoadPlayerScoreResult> {
        private LoadPlayerScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayerScoreResult zzal(final Status status) {
            return new LoadPlayerScoreResult(this) {
                final /* synthetic */ LoadPlayerScoreImpl zzaGz;

                public LeaderboardScore getScore() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzal(status);
        }
    }

    private static abstract class LoadScoresImpl extends BaseGamesApiMethodImpl<LoadScoresResult> {
        private LoadScoresImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadScoresResult zzam(final Status status) {
            return new LoadScoresResult(this) {
                final /* synthetic */ LoadScoresImpl zzaGA;

                public Leaderboard getLeaderboard() {
                    return null;
                }

                public LeaderboardScoreBuffer getScores() {
                    return new LeaderboardScoreBuffer(DataHolder.zzbI(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzam(status);
        }
    }

    protected static abstract class SubmitScoreImpl extends BaseGamesApiMethodImpl<SubmitScoreResult> {
        protected SubmitScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public SubmitScoreResult zzan(final Status status) {
            return new SubmitScoreResult(this) {
                final /* synthetic */ SubmitScoreImpl zzaGB;

                public ScoreSubmissionData getScoreData() {
                    return new ScoreSubmissionData(DataHolder.zzbI(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzan(status);
        }
    }

    class AnonymousClass10 extends LoadScoresImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaGq;
        final /* synthetic */ int zzaGr;
        final /* synthetic */ int zzaGs;
        final /* synthetic */ int zzaGt;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaGq, this.zzaGr, this.zzaGs, this.zzaGt, this.zzaFO);
        }
    }

    class AnonymousClass11 extends LoadScoresImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaGq;
        final /* synthetic */ int zzaGr;
        final /* synthetic */ int zzaGs;
        final /* synthetic */ int zzaGt;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaFQ, this.zzaGq, this.zzaGr, this.zzaGs, this.zzaGt, this.zzaFO);
        }
    }

    class C12148 extends LoadMetadataImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaFQ, this.zzaFO);
        }
    }

    class C12159 extends LoadMetadataImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaGq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFQ, this.zzaGq, this.zzaFO);
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwz();
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return getLeaderboardIntent(apiClient, leaderboardId, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId, int timeSpan) {
        return getLeaderboardIntent(apiClient, leaderboardId, timeSpan, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId, int timeSpan, int collection) {
        return Games.zzh(apiClient).zzl(leaderboardId, timeSpan, collection);
    }

    public PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        return apiClient.zza(new LoadPlayerScoreImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaGp;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, null, str, i, i2);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final String leaderboardId, final boolean forceReload) {
        return apiClient.zza(new LoadMetadataImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaGp;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, leaderboardId, forceReload);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadMetadataImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaGp;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, forceReload);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient apiClient, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        final LeaderboardScoreBuffer leaderboardScoreBuffer = buffer;
        final int i = maxResults;
        final int i2 = pageDirection;
        return apiClient.zza(new LoadScoresImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaGp;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, leaderboardScoreBuffer, i, i2);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.zza(new LoadScoresImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaGp;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, str, i, i2, i3, z);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.zza(new LoadScoresImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaGp;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, i, i2, i3, z);
            }
        });
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, null);
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            try {
                zzb.zza(null, leaderboardId, score, scoreTag);
            } catch (RemoteException e) {
                GamesLog.zzz("LeaderboardsImpl", "service died");
            }
        }
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, null);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        final String str = leaderboardId;
        final long j = score;
        final String str2 = scoreTag;
        return apiClient.zzb(new SubmitScoreImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaGp;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, j, str2);
            }
        });
    }
}
