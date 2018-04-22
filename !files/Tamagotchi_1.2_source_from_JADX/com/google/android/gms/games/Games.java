package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.RequiresPermission;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.StatsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.api.VideosImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Games {
    public static final Api<GamesOptions> API = new Api("Games.API", zzUJ, zzUI);
    public static final Achievements Achievements = new AchievementsImpl();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    public static final Events Events = new EventsImpl();
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Players Players = new PlayersImpl();
    public static final Quests Quests = new QuestsImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Snapshots Snapshots = new SnapshotsImpl();
    public static final Stats Stats = new StatsImpl();
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
    static final zzc<GamesClientImpl> zzUI = new zzc();
    private static final zza<GamesClientImpl, GamesOptions> zzUJ = new C09491();
    public static final Videos zzaCA = new VideosImpl();
    public static final Acls zzaCB = new AclsImpl();
    private static final zza<GamesClientImpl, GamesOptions> zzaCv = new C09502();
    public static final Scope zzaCw = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api<GamesOptions> zzaCx = new Api("Games.API_1P", zzaCv, zzUI);
    public static final AppContents zzaCy = new AppContentsImpl();
    public static final Multiplayer zzaCz = new MultiplayerImpl();

    private static abstract class GamesClientBuilder extends zza<GamesClientImpl, GamesOptions> {
        private GamesClientBuilder() {
        }

        public int getPriority() {
            return 1;
        }

        public GamesClientImpl zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, com_google_android_gms_common_internal_zzf, gamesOptions == null ? new GamesOptions() : gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    @Deprecated
    public interface GetServerAuthCodeResult extends Result {
        String getCode();
    }

    public interface GetTokenResult extends Result {
    }

    public interface LoadExperimentsResult extends Result {
    }

    static class C09491 extends GamesClientBuilder {
        C09491() {
            super();
        }

        public List<Scope> zza(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.SCOPE_GAMES);
        }

        public /* synthetic */ List zzo(Object obj) {
            return zza((GamesOptions) obj);
        }
    }

    static class C09502 extends GamesClientBuilder {
        C09502() {
            super();
        }

        public List<Scope> zza(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.zzaCw);
        }

        public /* synthetic */ List zzo(Object obj) {
            return zza((GamesOptions) obj);
        }
    }

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl(GoogleApiClient googleApiClient) {
            super(Games.zzUI, googleApiClient);
        }
    }

    public static final class GamesOptions implements Optional {
        public final boolean zzaCE;
        public final boolean zzaCF;
        public final int zzaCG;
        public final boolean zzaCH;
        public final int zzaCI;
        public final String zzaCJ;
        public final ArrayList<String> zzaCK;
        public final boolean zzaCL;

        public static final class Builder {
            boolean zzaCE;
            boolean zzaCF;
            int zzaCG;
            boolean zzaCH;
            int zzaCI;
            String zzaCJ;
            ArrayList<String> zzaCK;
            boolean zzaCL;

            private Builder() {
                this.zzaCE = false;
                this.zzaCF = true;
                this.zzaCG = 17;
                this.zzaCH = false;
                this.zzaCI = 4368;
                this.zzaCJ = null;
                this.zzaCK = new ArrayList();
                this.zzaCL = false;
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            public Builder setRequireGooglePlus(boolean requireGooglePlus) {
                this.zzaCL = requireGooglePlus;
                return this;
            }

            public Builder setSdkVariant(int variant) {
                this.zzaCI = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.zzaCF = showConnectingPopup;
                this.zzaCG = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.zzaCF = showConnectingPopup;
                this.zzaCG = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.zzaCE = false;
            this.zzaCF = true;
            this.zzaCG = 17;
            this.zzaCH = false;
            this.zzaCI = 4368;
            this.zzaCJ = null;
            this.zzaCK = new ArrayList();
            this.zzaCL = false;
        }

        private GamesOptions(Builder builder) {
            this.zzaCE = builder.zzaCE;
            this.zzaCF = builder.zzaCF;
            this.zzaCG = builder.zzaCG;
            this.zzaCH = builder.zzaCH;
            this.zzaCI = builder.zzaCI;
            this.zzaCJ = builder.zzaCJ;
            this.zzaCK = builder.zzaCK;
            this.zzaCL = builder.zzaCL;
        }

        public static Builder builder() {
            return new Builder();
        }

        public Bundle zzvD() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzaCE);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzaCF);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzaCG);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzaCH);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzaCI);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzaCJ);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzaCK);
            bundle.putBoolean("com.google.android.gms.games.key.requireGooglePlus", this.zzaCL);
            return bundle;
        }
    }

    static class C10896 extends BaseGamesApiMethodImpl<LoadExperimentsResult> {
        protected LoadExperimentsResult zzW(final Status status) {
            return new LoadExperimentsResult(this) {
                final /* synthetic */ C10896 zzaCD;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzW(status);
        }
    }

    private static abstract class GetServerAuthCodeImpl extends BaseGamesApiMethodImpl<GetServerAuthCodeResult> {
        private GetServerAuthCodeImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public GetServerAuthCodeResult zzX(final Status status) {
            return new GetServerAuthCodeResult(this) {
                final /* synthetic */ GetServerAuthCodeImpl zzaCM;

                public String getCode() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzX(status);
        }
    }

    private static abstract class GetTokenImpl extends BaseGamesApiMethodImpl<GetTokenResult> {
        public GetTokenResult zzY(final Status status) {
            return new GetTokenResult(this) {
                final /* synthetic */ GetTokenImpl zzaCN;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzY(status);
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    static class C11833 extends GetTokenImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this);
        }
    }

    private Games() {
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return zzh(apiClient).zzwK();
    }

    @RequiresPermission("android.permission.GET_ACCOUNTS")
    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return zzh(apiClient).zzww();
    }

    @Deprecated
    public static PendingResult<GetServerAuthCodeResult> getGamesServerAuthCode(GoogleApiClient apiClient, final String serverClientId) {
        zzx.zzh(serverClientId, "Please provide a valid serverClientId");
        return apiClient.zzb(new GetServerAuthCodeImpl(apiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(serverClientId, (zzb) this);
            }
        });
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return zzh(apiClient).zzwJ();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return zzh(apiClient).zzwI();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        GamesClientImpl zzb = zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzgs(gravity);
        }
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        zzx.zzz(gamesContentView);
        GamesClientImpl zzb = zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzo(gamesContentView);
        }
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.zzb(new SignOutImpl(apiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf(this);
            }
        });
    }

    public static GamesClientImpl zzb(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zzc(googleApiClient, z);
    }

    public static GamesClientImpl zzc(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (GamesClientImpl) googleApiClient.zza(zzUI) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        }
    }

    public static GamesClientImpl zzh(GoogleApiClient googleApiClient) {
        return zzb(googleApiClient, true);
    }
}
