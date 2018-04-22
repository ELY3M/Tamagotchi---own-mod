package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zze;
import com.google.android.gms.common.api.internal.zzf;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.api.internal.zzq.zzb;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.Games.GetServerAuthCodeResult;
import com.google.android.gms.games.Games.GetTokenResult;
import com.google.android.gms.games.Games.LoadExperimentsResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;
import com.google.android.gms.games.video.VideoBuffer;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.games.video.Videos.ListVideosResult;
import com.google.android.gms.games.video.Videos.VideoAvailableResult;
import com.google.android.gms.games.video.Videos.VideoCapabilitiesResult;
import com.google.android.gms.signin.internal.zzh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GamesClientImpl extends zzj<IGamesService> {
    EventIncrementManager zzaDZ = new C07351(this);
    private final String zzaEa;
    private PlayerEntity zzaEb;
    private GameEntity zzaEc;
    private final PopupManager zzaEd;
    private boolean zzaEe = false;
    private final Binder zzaEf;
    private final long zzaEg;
    private final GamesOptions zzaEh;

    class C07351 extends EventIncrementManager {
        final /* synthetic */ GamesClientImpl zzaEi;

        C07351(GamesClientImpl gamesClientImpl) {
            this.zzaEi = gamesClientImpl;
        }

        public EventIncrementCache zzwS() {
            return new GameClientEventIncrementCache(this.zzaEi);
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl zzaEi;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.zzaEi = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), 1000);
        }

        protected void zzs(String str, int i) {
            try {
                if (this.zzaEi.isConnected()) {
                    ((IGamesService) this.zzaEi.zzqJ()).zzp(str, i);
                } else {
                    GamesLog.zzA("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                this.zzaEi.zzb(e);
            }
        }
    }

    private static final class InvitationReceivedNotifier implements zzb<OnInvitationReceivedListener> {
        private final Invitation zzaEu;

        InvitationReceivedNotifier(Invitation invitation) {
            this.zzaEu = invitation;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.zzaEu);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }
    }

    private static final class InvitationRemovedNotifier implements zzb<OnInvitationReceivedListener> {
        private final String zzUO;

        InvitationRemovedNotifier(String invitationId) {
            this.zzUO = invitationId;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.zzUO);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }
    }

    private static final class LeftRoomNotifier implements zzb<RoomUpdateListener> {
        private final String zzaEw;
        private final int zzade;

        LeftRoomNotifier(int statusCode, String roomId) {
            this.zzade = statusCode;
            this.zzaEw = roomId;
        }

        public void zza(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.zzade, this.zzaEw);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((RoomUpdateListener) obj);
        }
    }

    private static final class MatchRemovedNotifier implements zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final String zzaER;

        MatchRemovedNotifier(String matchId) {
            this.zzaER = matchId;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzaER);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }
    }

    private static final class MatchUpdateReceivedNotifier implements zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch zzaES;

        MatchUpdateReceivedNotifier(TurnBasedMatch match) {
            this.zzaES = match;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzaES);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }
    }

    private static final class MessageReceivedNotifier implements zzb<RealTimeMessageReceivedListener> {
        private final RealTimeMessage zzaET;

        MessageReceivedNotifier(RealTimeMessage message) {
            this.zzaET = message;
        }

        public void zza(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzaET);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((RealTimeMessageReceivedListener) obj);
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements zzb<OnNearbyPlayerDetectedListener> {
        private final Player zzaEU;

        public void zza(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.zza(this.zzaEU);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((OnNearbyPlayerDetectedListener) obj);
        }
    }

    private static final class P2PConnectedNotifier implements zzb<RoomStatusUpdateListener> {
        private final String zzaFa;

        P2PConnectedNotifier(String participantId) {
            this.zzaFa = participantId;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.zzaFa);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }
    }

    private static final class P2PDisconnectedNotifier implements zzb<RoomStatusUpdateListener> {
        private final String zzaFa;

        P2PDisconnectedNotifier(String participantId) {
            this.zzaFa = participantId;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.zzaFa);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }
    }

    private static final class QuestCompletedNotifier implements zzb<QuestUpdateListener> {
        private final Quest zzaEk;

        QuestCompletedNotifier(Quest quest) {
            this.zzaEk = quest;
        }

        public void zza(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.zzaEk);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((QuestUpdateListener) obj);
        }
    }

    private static final class RealTimeMessageSentNotifier implements zzb<ReliableMessageSentCallback> {
        private final String zzaFf;
        private final int zzaFg;
        private final int zzade;

        RealTimeMessageSentNotifier(int statusCode, int token, String recipientParticipantId) {
            this.zzade = statusCode;
            this.zzaFg = token;
            this.zzaFf = recipientParticipantId;
        }

        public void zza(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.zzade, this.zzaFg, this.zzaFf);
            }
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((ReliableMessageSentCallback) obj);
        }
    }

    private static final class RequestReceivedNotifier implements zzb<OnRequestReceivedListener> {
        private final GameRequest zzaFi;

        RequestReceivedNotifier(GameRequest request) {
            this.zzaFi = request;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.zzaFi);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }
    }

    private static final class RequestRemovedNotifier implements zzb<OnRequestReceivedListener> {
        private final String zzEY;

        RequestRemovedNotifier(String requestId) {
            this.zzEY = requestId;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.zzEY);
        }

        public void zzpr() {
        }

        public /* synthetic */ void zzt(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }
    }

    private static abstract class AbstractRoomNotifier extends zze<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            zza(roomUpdateListener, GamesClientImpl.zzY(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void zza(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static abstract class AbstractRoomStatusNotifier extends zze<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            zza(roomStatusUpdateListener, GamesClientImpl.zzY(dataHolder));
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static final class CancelMatchResultImpl implements CancelMatchResult {
        private final Status zzUX;
        private final String zzaEm;

        CancelMatchResultImpl(Status status, String externalMatchId) {
            this.zzUX = status;
            this.zzaEm = externalMatchId;
        }

        public String getMatchId() {
            return this.zzaEm;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final Status zzUX;
        private final String zzaEp;

        DeleteSnapshotResultImpl(int statusCode, String snapshotId) {
            this.zzUX = GamesStatusCodes.zzgc(statusCode);
            this.zzaEp = snapshotId;
        }

        public String getSnapshotId() {
            return this.zzaEp;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final Status zzUX;
        private final String zzaEq;
        private final boolean zzaEr;

        public GameMuteStatusChangeResultImpl(int statusCode, String externalGameId, boolean isMuted) {
            this.zzUX = GamesStatusCodes.zzgc(statusCode);
            this.zzaEq = externalGameId;
            this.zzaEr = isMuted;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final Status zzUX;
        private final String zzaEq;
        private final boolean zzaEr;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.zzUX = GamesStatusCodes.zzgc(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.zzaEq = dataHolder.zzd("external_game_id", 0, 0);
                    this.zzaEr = dataHolder.zze("muted", 0, 0);
                } else {
                    this.zzaEq = null;
                    this.zzaEr = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static abstract class GamesDataHolderResult extends zzf {
        protected GamesDataHolderResult(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zzgc(dataHolder.getStatusCode()));
        }
    }

    private static final class GetServerAuthCodeResultImpl implements GetServerAuthCodeResult {
        private final Status zzUX;
        private final String zzaEs;

        GetServerAuthCodeResultImpl(Status status, String code) {
            this.zzUX = status;
            this.zzaEs = code;
        }

        public String getCode() {
            return this.zzaEs;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class GetTokenResultImpl implements GetTokenResult {
        private final Status zzUX;
        private final String zzVo;

        GetTokenResultImpl(Status status, String token) {
            this.zzUX = status;
            this.zzVo = token;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class InboxCountResultImpl implements InboxCountResult {
        private final Status zzUX;
        private final Bundle zzaEt;

        InboxCountResultImpl(Status status, Bundle inboxCounts) {
            this.zzUX = status;
            this.zzaEt = inboxCounts;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class LoadExperimentsResultImpl implements LoadExperimentsResult {
        private final Status zzUX;
        private final Set<Long> zzaEB = new HashSet();

        LoadExperimentsResultImpl(int statusCode, long[] experimentIds) {
            this.zzUX = new Status(statusCode);
            for (long valueOf : experimentIds) {
                this.zzaEB.add(Long.valueOf(valueOf));
            }
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final Status zzUX;
        private final LoadMatchesResponse zzaEG;

        LoadMatchesResultImpl(Status status, Bundle matchData) {
            this.zzUX = status;
            this.zzaEG = new LoadMatchesResponse(matchData);
        }

        public LoadMatchesResponse getMatches() {
            return this.zzaEG;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            this.zzaEG.release();
        }
    }

    private static final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Status zzUX;
        private final Bundle zzaEL;

        LoadRequestsResultImpl(Status status, Bundle requestData) {
            this.zzUX = status;
            this.zzaEL = requestData;
        }

        public GameRequestBuffer getRequests(int requestType) {
            String zzgw = RequestType.zzgw(requestType);
            return !this.zzaEL.containsKey(zzgw) ? null : new GameRequestBuffer((DataHolder) this.zzaEL.get(zzgw));
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            for (String parcelable : this.zzaEL.keySet()) {
                DataHolder dataHolder = (DataHolder) this.zzaEL.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final Status zzUX;
        private final List<String> zzaEO;
        private final Bundle zzaEP;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle xpData) {
            this.zzUX = status;
            this.zzaEO = xpData.getStringArrayList("game_category_list");
            this.zzaEP = xpData;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final Status zzUX;
        private final String zzaDj;

        UpdateAchievementResultImpl(int statusCode, String achievementId) {
            this.zzUX = GamesStatusCodes.zzgc(statusCode);
            this.zzaDj = achievementId;
        }

        public String getAchievementId() {
            return this.zzaDj;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static final class VideoAvailableResultImpl implements VideoAvailableResult {
        private final Status zzUX;
        private final boolean zzaFC;

        VideoAvailableResultImpl(Status status, boolean isAvailable) {
            this.zzUX = status;
            this.zzaFC = isAvailable;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static final class VideoCapabilitiesResultImpl implements VideoCapabilitiesResult {
        private final Status zzUX;
        private final VideoCapabilities zzaFD;

        VideoCapabilitiesResultImpl(Status status, VideoCapabilities capabilities) {
            this.zzUX = status;
            this.zzaFD = capabilities;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> zzaEj = new ArrayList();

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder);
            for (Object add : participantIds) {
                this.zzaEj.add(add);
            }
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            zza(roomStatusUpdateListener, room, this.zzaEj);
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static final class AcceptQuestResultImpl extends GamesDataHolderResult implements AcceptQuestResult {
        private final Quest zzaEk;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaEk = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.zzaEk = null;
                }
                questBuffer.release();
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public Quest getQuest() {
            return this.zzaEk;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<UpdateAchievementResult> zzamC;

        AchievementUpdatedBinderCallback(zza.zzb<UpdateAchievementResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzh(int i, String str) {
            this.zzamC.zzs(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadAchievementsResult> zzamC;

        AchievementsLoadedBinderCallback(zza.zzb<LoadAchievementsResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzh(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadAppContentResult> zzaEl;

        public AppContentLoadedBinderCallbacks(zza.zzb<LoadAppContentResult> resultHolder) {
            this.zzaEl = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder[] dataHolderArr) {
            this.zzaEl.zzs(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class ClaimMilestoneResultImpl extends GamesDataHolderResult implements ClaimMilestoneResult {
        private final Quest zzaEk;
        private final Milestone zzaEn;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String milestoneId) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaEk = new QuestEntity((Quest) questBuffer.get(0));
                    List zzxR = this.zzaEk.zzxR();
                    int size = zzxR.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) zzxR.get(i)).getMilestoneId().equals(milestoneId)) {
                            this.zzaEn = (Milestone) zzxR.get(i);
                            return;
                        }
                    }
                    this.zzaEn = null;
                } else {
                    this.zzaEn = null;
                    this.zzaEk = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public Milestone getMilestone() {
            return this.zzaEn;
        }

        public Quest getQuest() {
            return this.zzaEk;
        }
    }

    private static final class CommitSnapshotResultImpl extends GamesDataHolderResult implements CommitSnapshotResult {
        private final SnapshotMetadata zzaEo;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzaEo = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.zzaEo = null;
                }
                snapshotMetadataBuffer.release();
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.zzaEo;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends GamesDataHolderResult implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<ContactSettingLoadResult> zzamC;

        ContactSettingsLoadedBinderCallback(zza.zzb<ContactSettingLoadResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzI(DataHolder dataHolder) {
            this.zzamC.zzs(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzamC;

        ContactSettingsUpdatedBinderCallback(zza.zzb<Status> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzgo(int i) {
            this.zzamC.zzs(GamesStatusCodes.zzgc(i));
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadEventsResult> zzamC;

        EventsLoadedBinderCallback(zza.zzb<LoadEventsResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzi(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadEventResultImpl(dataHolder));
        }
    }

    private static final class ExperimentsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadExperimentsResult> zzamC;

        ExperimentsLoadedBinderCallback(zza.zzb<LoadExperimentsResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zza(int i, long[] jArr) {
            this.zzamC.zzs(new LoadExperimentsResultImpl(i, jArr));
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadGameInstancesResult> zzamC;

        GameInstancesLoadedBinderCallback(zza.zzb<LoadGameInstancesResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzp(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GameMuteStatusChangeResult> zzamC;

        GameMuteStatusChangedBinderCallback(zza.zzb<GameMuteStatusChangeResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zza(int i, String str, boolean z) {
            this.zzamC.zzs(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GameMuteStatusLoadResult> zzamC;

        GameMuteStatusLoadedBinderCallback(zza.zzb<GameMuteStatusLoadResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzG(DataHolder dataHolder) {
            this.zzamC.zzs(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadGameSearchSuggestionsResult> zzamC;

        GameSearchSuggestionsLoadedBinderCallback(zza.zzb<LoadGameSearchSuggestionsResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzq(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadGamesResult> zzamC;

        GamesLoadedBinderCallback(zza.zzb<LoadGamesResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzn(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class GetAuthTokenBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<GetTokenResult> zzamC;

        public GetAuthTokenBinderCallbacks(zza.zzb<GetTokenResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzg(int i, String str) {
            this.zzamC.zzs(new GetTokenResultImpl(GamesStatusCodes.zzgc(i), str));
        }
    }

    private static final class GetServerAuthCodeBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<GetServerAuthCodeResult> zzamC;

        public GetServerAuthCodeBinderCallbacks(zza.zzb<GetServerAuthCodeResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzg(int i, String str) {
            this.zzamC.zzs(new GetServerAuthCodeResultImpl(GamesStatusCodes.zzgc(i), str));
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<InboxCountResult> zzamC;

        InboxCountsLoadedBinderCallback(zza.zzb<InboxCountResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzg(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzamC.zzs(new InboxCountResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzq<OnInvitationReceivedListener> zzari;

        InvitationReceivedBinderCallback(zzq<OnInvitationReceivedListener> listener) {
            this.zzari = listener;
        }

        public void onInvitationRemoved(String invitationId) {
            this.zzari.zza(new InvitationRemovedNotifier(invitationId));
        }

        public void zzs(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.release();
                if (invitation != null) {
                    this.zzari.zza(new InvitationReceivedNotifier(invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.release();
            }
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadInvitationsResult> zzamC;

        InvitationsLoadedBinderCallback(zza.zzb<LoadInvitationsResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzr(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends GamesDataHolderResult implements LeaderboardMetadataResult {
        private final LeaderboardBuffer zzaEv;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEv = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.zzaEv;
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadScoresResult> zzamC;

        LeaderboardScoresLoadedBinderCallback(zza.zzb<LoadScoresResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            this.zzamC.zzs(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LeaderboardMetadataResult> zzamC;

        LeaderboardsLoadedBinderCallback(zza.zzb<LeaderboardMetadataResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzj(DataHolder dataHolder) {
            this.zzamC.zzs(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class ListVideosBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<ListVideosResult> zzamC;

        ListVideosBinderCallback(zza.zzb<ListVideosResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzX(DataHolder dataHolder) {
            this.zzamC.zzs(new ListVideosResultImpl(dataHolder));
        }
    }

    public static final class ListVideosResultImpl extends GamesDataHolderResult implements ListVideosResult {
        private final VideoBuffer zzaEx;

        public ListVideosResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEx = new VideoBuffer(dataHolder);
        }
    }

    private static final class LoadAchievementsResultImpl extends GamesDataHolderResult implements LoadAchievementsResult {
        private final AchievementBuffer zzaEy;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEy = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.zzaEy;
        }
    }

    private static final class LoadAclResultImpl extends GamesDataHolderResult implements LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadAppContentsResultImpl extends GamesDataHolderResult implements LoadAppContentResult {
        private final ArrayList<DataHolder> zzaEz;

        LoadAppContentsResultImpl(DataHolder[] appContentData) {
            super(appContentData[0]);
            this.zzaEz = new ArrayList(Arrays.asList(appContentData));
        }
    }

    private static final class LoadEventResultImpl extends GamesDataHolderResult implements LoadEventsResult {
        private final EventBuffer zzaEA;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEA = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.zzaEA;
        }
    }

    private static final class LoadGameInstancesResultImpl extends GamesDataHolderResult implements LoadGameInstancesResult {
        private final GameInstanceBuffer zzaEC;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEC = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult implements LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer zzaED;

        LoadGameSearchSuggestionsResultImpl(DataHolder data) {
            super(data);
            this.zzaED = new GameSearchSuggestionBuffer(data);
        }
    }

    private static final class LoadGamesResultImpl extends GamesDataHolderResult implements LoadGamesResult {
        private final GameBuffer zzaEE;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEE = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.zzaEE;
        }
    }

    private static final class LoadInvitationsResultImpl extends GamesDataHolderResult implements LoadInvitationsResult {
        private final InvitationBuffer zzaEF;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEF = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.zzaEF;
        }
    }

    private static final class LoadPlayerScoreResultImpl extends GamesDataHolderResult implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzaEH;

        LoadPlayerScoreResultImpl(DataHolder scoreHolder) {
            super(scoreHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzaEH = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.zzaEH = null;
                }
                leaderboardScoreBuffer.release();
            } catch (Throwable th) {
                leaderboardScoreBuffer.release();
            }
        }

        public LeaderboardScore getScore() {
            return this.zzaEH;
        }
    }

    private static final class LoadPlayerStatsResultImpl extends GamesDataHolderResult implements LoadPlayerStatsResult {
        private final PlayerStats zzaEI;

        LoadPlayerStatsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                if (playerStatsBuffer.getCount() > 0) {
                    this.zzaEI = new PlayerStatsEntity(playerStatsBuffer.zzgV(0));
                } else {
                    this.zzaEI = null;
                }
                playerStatsBuffer.release();
            } catch (Throwable th) {
                playerStatsBuffer.release();
            }
        }

        public PlayerStats getPlayerStats() {
            return this.zzaEI;
        }
    }

    private static final class LoadPlayersResultImpl extends GamesDataHolderResult implements LoadPlayersResult {
        private final PlayerBuffer zzaEJ;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEJ = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.zzaEJ;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends GamesDataHolderResult implements LoadProfileSettingsResult {
        private final boolean zzaEK;
        private final boolean zzsj;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int zzbH = dataHolder.zzbH(0);
                    this.zzsj = dataHolder.zze("profile_visible", 0, zzbH);
                    this.zzaEK = dataHolder.zze("profile_visibility_explicitly_set", 0, zzbH);
                } else {
                    this.zzsj = true;
                    this.zzaEK = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class LoadQuestsResultImpl extends GamesDataHolderResult implements LoadQuestsResult {
        private final DataHolder zzahi;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzahi = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.zzahi);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends GamesDataHolderResult implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadScoresResultImpl extends GamesDataHolderResult implements LoadScoresResult {
        private final LeaderboardEntity zzaEM;
        private final LeaderboardScoreBuffer zzaEN;

        LoadScoresResultImpl(DataHolder leaderboard, DataHolder scores) {
            super(scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzaEM = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.zzaEM = null;
                }
                leaderboardBuffer.release();
                this.zzaEN = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.release();
            }
        }

        public Leaderboard getLeaderboard() {
            return this.zzaEM;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.zzaEN;
        }
    }

    private static final class LoadSnapshotsResultImpl extends GamesDataHolderResult implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.zzahi);
        }
    }

    private static final class LoadXpStreamResultImpl extends GamesDataHolderResult implements LoadXpStreamResult {
        private final ExperienceEventBuffer zzaEQ;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEQ = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzq<OnTurnBasedMatchUpdateReceivedListener> zzari;

        MatchUpdateReceivedBinderCallback(zzq<OnTurnBasedMatchUpdateReceivedListener> listener) {
            this.zzari = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.zzari.zza(new MatchRemovedNotifier(matchId));
        }

        public void zzy(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.release();
                if (turnBasedMatch != null) {
                    this.zzari.zza(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadAclResult> zzamC;

        NotifyAclLoadedBinderCallback(zza.zzb<LoadAclResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzH(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadAclResultImpl(dataHolder));
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzamC;

        NotifyAclUpdatedBinderCallback(zza.zzb<Status> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzgn(int i) {
            this.zzamC.zzs(GamesStatusCodes.zzgc(i));
        }
    }

    private static final class OpenSnapshotResultImpl extends GamesDataHolderResult implements OpenSnapshotResult {
        private final Snapshot zzaEV;
        private final String zzaEW;
        private final Snapshot zzaEX;
        private final Contents zzaEY;
        private final SnapshotContents zzaEZ;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents currentContents) {
            this(dataHolder, null, currentContents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder metadataHolder, String conflictId, Contents currentContents, Contents conflictContents, Contents resolutionContents) {
            boolean z = true;
            super(metadataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(metadataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzaEV = null;
                    this.zzaEX = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (metadataHolder.getStatusCode() == 4004) {
                        z = false;
                    }
                    com.google.android.gms.common.internal.zzb.zzab(z);
                    this.zzaEV = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzaEX = null;
                } else {
                    this.zzaEV = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzaEX = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(conflictContents));
                }
                snapshotMetadataBuffer.release();
                this.zzaEW = conflictId;
                this.zzaEY = resolutionContents;
                this.zzaEZ = new SnapshotContentsEntity(resolutionContents);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public String getConflictId() {
            return this.zzaEW;
        }

        public Snapshot getConflictingSnapshot() {
            return this.zzaEX;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzaEZ;
        }

        public Snapshot getSnapshot() {
            return this.zzaEV;
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadPlayerScoreResult> zzamC;

        PlayerLeaderboardScoreLoadedBinderCallback(zza.zzb<LoadPlayerScoreResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzJ(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerStatsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadPlayerStatsResult> zzamC;

        public PlayerStatsLoadedBinderCallbacks(zza.zzb<LoadPlayerStatsResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzW(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayerStatsResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadXpForGameCategoriesResult> zzamC;

        PlayerXpForGameCategoriesLoadedBinderCallback(zza.zzb<LoadXpForGameCategoriesResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzf(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzamC.zzs(new LoadXpForGameCategoriesResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadXpStreamResult> zzamC;

        PlayerXpStreamLoadedBinderCallback(zza.zzb<LoadXpStreamResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzU(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadPlayersResult> zzamC;

        PlayersLoadedBinderCallback(zza.zzb<LoadPlayersResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzl(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayersResultImpl(dataHolder));
        }

        public void zzm(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private static final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient {
        private final PopupManager zzaEd;

        public PopupLocationInfoBinderCallbacks(PopupManager popupManager) {
            this.zzaEd = popupManager;
        }

        public PopupLocationInfoParcelable zzws() {
            return new PopupLocationInfoParcelable(this.zzaEd.zzxk());
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadProfileSettingsResult> zzamC;

        ProfileSettingsLoadedBinderCallback(zza.zzb<LoadProfileSettingsResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzV(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzamC;

        ProfileSettingsUpdatedBinderCallback(zza.zzb<Status> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzgp(int i) {
            this.zzamC.zzs(GamesStatusCodes.zzgc(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<AcceptQuestResult> zzaFb;

        public QuestAcceptedBinderCallbacks(zza.zzb<AcceptQuestResult> resultHolder) {
            this.zzaFb = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzQ(DataHolder dataHolder) {
            this.zzaFb.zzs(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<ClaimMilestoneResult> zzaFc;
        private final String zzaFd;

        public QuestMilestoneClaimBinderCallbacks(zza.zzb<ClaimMilestoneResult> resultHolder, String milestoneId) {
            this.zzaFc = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
            this.zzaFd = (String) zzx.zzb((Object) milestoneId, (Object) "MilestoneId must not be null");
        }

        public void zzP(DataHolder dataHolder) {
            this.zzaFc.zzs(new ClaimMilestoneResultImpl(dataHolder, this.zzaFd));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final zzq<QuestUpdateListener> zzari;

        QuestUpdateBinderCallback(zzq<QuestUpdateListener> listener) {
            this.zzari = listener;
        }

        private Quest zzaa(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.release();
                return quest;
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public void zzR(DataHolder dataHolder) {
            Quest zzaa = zzaa(dataHolder);
            if (zzaa != null) {
                this.zzari.zza(new QuestCompletedNotifier(zzaa));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadQuestsResult> zzaFe;

        public QuestsLoadedBinderCallbacks(zza.zzb<LoadQuestsResult> resultHolder) {
            this.zzaFe = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzT(DataHolder dataHolder) {
            this.zzaFe.zzs(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final zzq<ReliableMessageSentCallback> zzaFh;

        public RealTimeReliableMessageBinderCallbacks(zzq<ReliableMessageSentCallback> messageSentCallbacks) {
            this.zzaFh = messageSentCallbacks;
        }

        public void zzb(int i, int i2, String str) {
            if (this.zzaFh != null) {
                this.zzaFh.zza(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzq<OnRequestReceivedListener> zzari;

        RequestReceivedBinderCallback(zzq<OnRequestReceivedListener> listener) {
            this.zzari = listener;
        }

        public void onRequestRemoved(String requestId) {
            this.zzari.zza(new RequestRemovedNotifier(requestId));
        }

        public void zzt(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.release();
                if (gameRequest != null) {
                    this.zzari.zza(new RequestReceivedNotifier(gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<SendRequestResult> zzaFj;

        public RequestSentBinderCallbacks(zza.zzb<SendRequestResult> resultHolder) {
            this.zzaFj = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzL(DataHolder dataHolder) {
            this.zzaFj.zzs(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadRequestSummariesResult> zzaFk;

        public RequestSummariesLoadedBinderCallbacks(zza.zzb<LoadRequestSummariesResult> resultHolder) {
            this.zzaFk = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzM(DataHolder dataHolder) {
            this.zzaFk.zzs(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadRequestsResult> zzaFl;

        public RequestsLoadedBinderCallbacks(zza.zzb<LoadRequestsResult> resultHolder) {
            this.zzaFl = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzd(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaFl.zzs(new LoadRequestsResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<UpdateRequestsResult> zzaFm;

        public RequestsUpdatedBinderCallbacks(zza.zzb<UpdateRequestsResult> resultHolder) {
            this.zzaFm = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzK(DataHolder dataHolder) {
            this.zzaFm.zzs(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final zzq<? extends RoomUpdateListener> zzaFn;
        private final zzq<? extends RoomStatusUpdateListener> zzaFo;
        private final zzq<RealTimeMessageReceivedListener> zzaFp;

        public RoomBinderCallbacks(zzq<RoomUpdateListener> roomCallbacks) {
            this.zzaFn = (zzq) zzx.zzb((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.zzaFo = null;
            this.zzaFp = null;
        }

        public RoomBinderCallbacks(zzq<? extends RoomUpdateListener> roomCallbacks, zzq<? extends RoomStatusUpdateListener> roomStatusCallbacks, zzq<RealTimeMessageReceivedListener> realTimeMessageReceivedCallbacks) {
            this.zzaFn = (zzq) zzx.zzb((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.zzaFo = roomStatusCallbacks;
            this.zzaFp = realTimeMessageReceivedCallbacks;
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.zzaFn.zza(new LeftRoomNotifier(statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new P2PConnectedNotifier(participantId));
            }
        }

        public void onP2PDisconnected(String participantId) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new P2PDisconnectedNotifier(participantId));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            if (this.zzaFp != null) {
                this.zzaFp.zza(new MessageReceivedNotifier(message));
            }
        }

        public void zzA(DataHolder dataHolder) {
            this.zzaFn.zza(new JoinedRoomNotifier(dataHolder));
        }

        public void zzB(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new RoomConnectingNotifier(dataHolder));
            }
        }

        public void zzC(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        public void zzD(DataHolder dataHolder) {
            this.zzaFn.zza(new RoomConnectedNotifier(dataHolder));
        }

        public void zzE(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new ConnectedToRoomNotifier(dataHolder));
            }
        }

        public void zzF(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        public void zza(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzb(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzc(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzd(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        public void zze(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzf(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzz(DataHolder dataHolder) {
            this.zzaFn.zza(new RoomCreatedNotifier(dataHolder));
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendRequestResultImpl extends GamesDataHolderResult implements SendRequestResult {
        private final GameRequest zzaFi;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.zzaFi = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.zzaFi = null;
                }
                gameRequestBuffer.release();
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzamC;

        public SignOutCompleteBinderCallbacks(zza.zzb<Status> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzwr() {
            this.zzamC.zzs(GamesStatusCodes.zzgc(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<CommitSnapshotResult> zzaFq;

        public SnapshotCommittedBinderCallbacks(zza.zzb<CommitSnapshotResult> resultHolder) {
            this.zzaFq = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzO(DataHolder dataHolder) {
            this.zzaFq.zzs(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<DeleteSnapshotResult> zzamC;

        public SnapshotDeletedBinderCallbacks(zza.zzb<DeleteSnapshotResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzj(int i, String str) {
            this.zzamC.zzs(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<OpenSnapshotResult> zzaFr;

        public SnapshotOpenedBinderCallbacks(zza.zzb<OpenSnapshotResult> resultHolder) {
            this.zzaFr = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, Contents contents) {
            this.zzaFr.zzs(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        public void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.zzaFr.zzs(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadSnapshotsResult> zzaFs;

        public SnapshotsLoadedBinderCallbacks(zza.zzb<LoadSnapshotsResult> resultHolder) {
            this.zzaFs = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzN(DataHolder dataHolder) {
            this.zzaFs.zzs(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class StartRecordingBinderCallback extends AbstractGamesCallbacks {
        private final BaseGamesApiMethodImpl<Status> zzaFt;

        StartRecordingBinderCallback(BaseGamesApiMethodImpl<Status> holder) {
            this.zzaFt = (BaseGamesApiMethodImpl) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzgq(int i) {
            this.zzaFt.zza(new Status(i));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<SubmitScoreResult> zzamC;

        public SubmitScoreBinderCallbacks(zza.zzb<SubmitScoreResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzk(DataHolder dataHolder) {
            this.zzamC.zzs(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends GamesDataHolderResult implements SubmitScoreResult {
        private final ScoreSubmissionData zzaFu;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzaFu = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.zzaFu;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<CancelMatchResult> zzaFv;

        public TurnBasedMatchCanceledBinderCallbacks(zza.zzb<CancelMatchResult> resultHolder) {
            this.zzaFv = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzi(int i, String str) {
            this.zzaFv.zzs(new CancelMatchResultImpl(GamesStatusCodes.zzgc(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<InitiateMatchResult> zzaFw;

        public TurnBasedMatchInitiatedBinderCallbacks(zza.zzb<InitiateMatchResult> resultHolder) {
            this.zzaFw = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzv(DataHolder dataHolder) {
            this.zzaFw.zzs(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LeaveMatchResult> zzaFx;

        public TurnBasedMatchLeftBinderCallbacks(zza.zzb<LeaveMatchResult> resultHolder) {
            this.zzaFx = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzx(DataHolder dataHolder) {
            this.zzaFx.zzs(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadMatchResult> zzaFy;

        public TurnBasedMatchLoadedBinderCallbacks(zza.zzb<LoadMatchResult> resultHolder) {
            this.zzaFy = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzu(DataHolder dataHolder) {
            this.zzaFy.zzs(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static abstract class TurnBasedMatchResult extends GamesDataHolderResult {
        final TurnBasedMatch zzaES;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.zzaES = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.zzaES = null;
                }
                turnBasedMatchBuffer.release();
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.zzaES;
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<UpdateMatchResult> zzaFz;

        public TurnBasedMatchUpdatedBinderCallbacks(zza.zzb<UpdateMatchResult> resultHolder) {
            this.zzaFz = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzw(DataHolder dataHolder) {
            this.zzaFz.zzs(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadMatchesResult> zzaFA;

        public TurnBasedMatchesLoadedBinderCallbacks(zza.zzb<LoadMatchesResult> resultHolder) {
            this.zzaFA = (zza.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzc(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaFA.zzs(new LoadMatchesResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    private static final class UpdateRequestsResultImpl extends GamesDataHolderResult implements UpdateRequestsResult {
        private final RequestUpdateOutcomes zzaFB;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaFB = RequestUpdateOutcomes.zzab(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.zzaFB.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.zzaFB.getRequestOutcome(requestId);
        }
    }

    private static final class VideoRecordingAvailableBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<VideoAvailableResult> zzamC;

        VideoRecordingAvailableBinderCallback(zza.zzb<VideoAvailableResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzd(int i, boolean z) {
            this.zzamC.zzs(new VideoAvailableResultImpl(new Status(i), z));
        }
    }

    private static final class VideoRecordingCapabilitiesBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<VideoCapabilitiesResult> zzamC;

        VideoRecordingCapabilitiesBinderCallback(zza.zzb<VideoCapabilitiesResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zza(int i, VideoCapabilities videoCapabilities) {
            this.zzamC.zzs(new VideoCapabilitiesResultImpl(new Status(i), videoCapabilities));
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    public GamesClientImpl(Context context, Looper looper, com.google.android.gms.common.internal.zzf clientSettings, GamesOptions options, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
        super(context, looper, 1, clientSettings, connectedListener, connectionFailedListener);
        this.zzaEa = clientSettings.zzqv();
        this.zzaEf = new Binder();
        this.zzaEd = PopupManager.zza(this, clientSettings.zzqr());
        zzo(clientSettings.zzqx());
        this.zzaEg = (long) hashCode();
        this.zzaEh = options;
    }

    private static Room zzY(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.release();
            return room;
        } catch (Throwable th) {
            roomBuffer.release();
        }
    }

    private void zzb(RemoteException remoteException) {
        GamesLog.zzb("GamesClientImpl", "service died", remoteException);
    }

    private void zzwv() {
        this.zzaEb = null;
        this.zzaEc = null;
    }

    public void disconnect() {
        this.zzaEe = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) zzqJ();
                iGamesService.zzwR();
                this.zzaDZ.flush();
                iGamesService.zzF(this.zzaEg);
            } catch (RemoteException e) {
                GamesLog.zzz("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public void onConnectionFailed(ConnectionResult result) {
        super.onConnectionFailed(result);
        this.zzaEe = false;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzbV(iBinder);
    }

    public int zza(zzq<ReliableMessageSentCallback> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) zzqJ()).zza(new RealTimeReliableMessageBinderCallbacks(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zza(byte[] bArr, String str, String[] strArr) {
        zzx.zzb((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) zzqJ()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent zza = ((IGamesService) zzqJ()).zza(i, bArr, i2, str);
            zzx.zzb((Object) bitmap, (Object) "Must provide a non null icon");
            zza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return zza;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(PlayerEntity playerEntity) {
        try {
            return ((IGamesService) zzqJ()).zza(playerEntity);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(Room room, int i) {
        try {
            return ((IGamesService) zzqJ()).zza((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) zzqJ()).zza(str, z, z2, i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.zzaEe = bundle.getBoolean("show_welcome_popup");
            this.zzaEb = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzaEc = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) zzqJ()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public void zza(GoogleApiClient.zza com_google_android_gms_common_api_GoogleApiClient_zza) {
        zzwv();
        super.zza(com_google_android_gms_common_api_GoogleApiClient_zza);
    }

    public void zza(zza.zzb<LoadInvitationsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new InvitationsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), i);
    }

    public void zza(zza.zzb<LoadRequestsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), i, i2, i3);
    }

    public void zza(zza.zzb<LoadAppContentResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult, int i, String str, String[] strArr, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new AppContentLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult), i, str, strArr, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zza(zza.zzb<LoadMatchesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), i, iArr);
    }

    public void zza(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), leaderboardScoreBuffer.zzxJ().asBundle(), i, i2);
    }

    public void zza(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzxP(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
    }

    public void zza(zza.zzb<CommitSnapshotResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        BitmapTeleporter zzxU = snapshotMetadataChange.zzxU();
        if (zzxU != null) {
            zzxU.zzc(getContext().getCacheDir());
        }
        Contents zzsx = snapshotContents.zzsx();
        snapshotContents.close();
        ((IGamesService) zzqJ()).zza(new SnapshotCommittedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzsx);
    }

    public void zza(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zzqJ()).zza(iGamesCallbacks, str, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public void zza(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zza(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public void zza(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                ((IGamesService) zzqJ()).zzd(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<LoadMatchesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, String str, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), str, i, iArr);
    }

    public void zza(zza.zzb<SubmitScoreResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult, String str, long j, String str2) throws RemoteException {
        ((IGamesService) zzqJ()).zza(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult == null ? null : new SubmitScoreBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult), str, j, str2);
    }

    public void zza(zza.zzb<LeaveMatchResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzqJ()).zzc(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str, str2);
    }

    public void zza(zza.zzb<LoadPlayerScoreResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult, String str, String str2, int i, int i2) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult), str, str2, i, i2);
    }

    public void zza(zza.zzb<LoadRequestsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, String str, String str2, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), str, str2, i, i2, i3);
    }

    public void zza(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    obj = 2;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    obj = 1;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
            case 2:
                ((IGamesService) zzqJ()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<OpenSnapshotResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        zzx.zza(!snapshotContents.isClosed(), (Object) "SnapshotContents already closed");
        BitmapTeleporter zzxU = snapshotMetadataChange.zzxU();
        if (zzxU != null) {
            zzxU.zzc(getContext().getCacheDir());
        }
        Contents zzsx = snapshotContents.zzsx();
        snapshotContents.close();
        ((IGamesService) zzqJ()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzsx);
    }

    public void zza(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, str2, z);
    }

    public void zza(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, boolean z, String[] strArr) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, strArr, z);
    }

    public void zza(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, iArr, i, z);
    }

    public void zza(zza.zzb<UpdateRequestsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String str, String str2, String[] strArr) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), str, str2, strArr);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzf(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, z);
    }

    public void zza(zza.zzb<OpenSnapshotResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, boolean z, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, z, i);
    }

    public void zza(zza.zzb<UpdateMatchResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, str2, participantResultArr);
    }

    public void zza(zza.zzb<UpdateMatchResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, participantResultArr);
    }

    public void zza(zza.zzb<SendRequestResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_SendRequestResult, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new RequestSentBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_SendRequestResult), str, strArr, i, bArr, i2);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), z);
    }

    public void zza(zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, boolean z, Bundle bundle) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new ContactSettingsUpdatedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), z, bundle);
    }

    public void zza(zza.zzb<LoadEventsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z, String... strArr) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza(new EventsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z, strArr);
    }

    public void zza(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), iArr, i, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzqJ()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), strArr);
    }

    public void zza(zzq<OnInvitationReceivedListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener) {
        try {
            ((IGamesService) zzqJ()).zza(new InvitationReceivedBinderCallback(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzq<RoomUpdateListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zzq<RoomStatusUpdateListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zzq<RealTimeMessageReceivedListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzqJ()).zza(new RoomBinderCallbacks(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzaEf, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzq<RoomUpdateListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, String str) {
        try {
            ((IGamesService) zzqJ()).zzc(new RoomBinderCallbacks(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener), str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(BaseGamesApiMethodImpl<Status> baseGamesApiMethodImpl, String str, String str2, VideoConfiguration videoConfiguration) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new StartRecordingBinderCallback(baseGamesApiMethodImpl), str, str2, videoConfiguration);
    }

    public void zza(@NonNull IGamesService iGamesService) {
        super.zza((IInterface) iGamesService);
        if (this.zzaEe) {
            this.zzaEd.zzxh();
            this.zzaEe = false;
        }
        if (!this.zzaEh.zzaCE) {
            zzb(iGamesService);
        }
    }

    public void zza(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        Contents zzsx = snapshotContents.zzsx();
        snapshotContents.close();
        try {
            ((IGamesService) zzqJ()).zza(zzsx);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public String zzah(boolean z) {
        if (z && this.zzaEb != null) {
            return this.zzaEb.getPlayerId();
        }
        try {
            return ((IGamesService) zzqJ()).zzwT();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzb(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzqJ()).zzb(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzb(int[] iArr) {
        try {
            return ((IGamesService) zzqJ()).zzb(iArr);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    protected Set<Scope> zzb(Set<Scope> set) {
        Scope scope = new Scope(Scopes.GAMES);
        Scope scope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        int i = 0;
        boolean z = false;
        for (Scope scope3 : set) {
            int i2;
            boolean z2;
            if (scope3.equals(scope)) {
                i2 = i;
                z2 = true;
            } else if (scope3.equals(scope2)) {
                i2 = 1;
                z2 = z;
            } else {
                i2 = i;
                z2 = z;
            }
            z = z2;
            i = i2;
        }
        if (i != 0) {
            zzx.zza(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzx.zza(z, "Games APIs requires %s to function.", Scopes.GAMES);
        }
        return set;
    }

    public void zzb(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqJ()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzb(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zzqJ()).zzb(iGamesCallbacks, str, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public void zzb(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zzb(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public void zzb(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zzb(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqJ()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
    }

    public void zzb(zza.zzb<ClaimMilestoneResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, String str, String str2) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zzf(new QuestMilestoneClaimBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, str2), str, str2);
    }

    public void zzb(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zzb(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqJ()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
    }

    public void zzb(zza.zzb<LoadAchievementsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), str, str2, z);
    }

    public void zzb(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzc(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzb(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), z);
    }

    public void zzb(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, boolean z, String[] strArr) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), strArr, z);
    }

    public void zzb(zza.zzb<UpdateRequestsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzb(zzq<OnTurnBasedMatchUpdateReceivedListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener) {
        try {
            ((IGamesService) zzqJ()).zzb(new MatchUpdateReceivedBinderCallback(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(zzq<RoomUpdateListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zzq<RoomStatusUpdateListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zzq<RealTimeMessageReceivedListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzqJ()).zza(new RoomBinderCallbacks(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzaEf, roomConfig.getInvitationId(), false, this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(IGamesService iGamesService) {
        try {
            iGamesService.zza(new PopupLocationInfoBinderCallbacks(this.zzaEd), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(String str, zza.zzb<GetServerAuthCodeResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Games_GetServerAuthCodeResult) throws RemoteException {
        zzx.zzh(str, "Please provide a valid serverClientId");
        ((IGamesService) zzqJ()).zza(str, new GetServerAuthCodeBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Games_GetServerAuthCodeResult));
    }

    protected IGamesService zzbV(IBinder iBinder) {
        return Stub.zzbY(iBinder);
    }

    public Intent zzc(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzqJ()).zzc(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzc(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqJ()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzc(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzc(zza.zzb<LoadXpStreamResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zzb(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzc(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzqJ()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzc(zza.zzb<LoadSnapshotsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzc(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), str, str2, z);
    }

    public void zzc(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzd(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzc(zza.zzb<LoadAchievementsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), z);
    }

    public void zzc(zza.zzb<UpdateRequestsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzqJ()).zzb(new RequestsUpdatedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzc(zzq<QuestUpdateListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_quest_QuestUpdateListener) {
        try {
            ((IGamesService) zzqJ()).zzd(new QuestUpdateBinderCallback(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_quest_QuestUpdateListener), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public int zzd(byte[] bArr, String str) {
        try {
            return ((IGamesService) zzqJ()).zzb(bArr, str, null);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzd(zza.zzb<GetTokenResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Games_GetTokenResult) throws RemoteException {
        ((IGamesService) zzqJ()).zzk(new GetAuthTokenBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Games_GetTokenResult));
    }

    public void zzd(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqJ()).zze(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzd(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzd(zza.zzb<LoadXpStreamResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zzc(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzd(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzqJ()).zze(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzd(zza.zzb<GameMuteStatusChangeResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new GameMuteStatusChangedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult), str, z);
    }

    public void zzd(zza.zzb<LoadEventsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zzf(new EventsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z);
    }

    public void zzd(zzq<OnRequestReceivedListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_request_OnRequestReceivedListener) {
        try {
            ((IGamesService) zzqJ()).zzc(new RequestReceivedBinderCallback(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_games_request_OnRequestReceivedListener), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzdH(String str) {
        try {
            ((IGamesService) zzqJ()).zzdP(str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzdI(String str) {
        try {
            return ((IGamesService) zzqJ()).zzdI(str);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzdJ(String str) {
        try {
            ((IGamesService) zzqJ()).zza(str, this.zzaEd.zzxj(), this.zzaEd.zzxi());
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zze(zza.zzb<LoadGamesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult) throws RemoteException {
        ((IGamesService) zzqJ()).zzd(new GamesLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult));
    }

    public void zze(zza.zzb<LeaveMatchResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzo(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str);
    }

    public void zze(zza.zzb<LoadInvitationsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zzb(new InvitationsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str, i, false);
    }

    public void zze(zza.zzb<LoadPlayerStatsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_stats_Stats_LoadPlayerStatsResult, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzi(new PlayerStatsLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_stats_Stats_LoadPlayerStatsResult), z);
    }

    public void zzf(zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza(new SignOutCompleteBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status));
    }

    public void zzf(zza.zzb<CancelMatchResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzn(new TurnBasedMatchCanceledBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult), str);
    }

    public void zzf(zza.zzb<LoadRequestSummariesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult, String str, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zza(new RequestSummariesLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult), str, i);
    }

    public void zzf(zza.zzb<LoadSnapshotsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzd(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), z);
    }

    public void zzg(zza.zzb<VideoCapabilitiesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_video_Videos_VideoCapabilitiesResult) throws RemoteException {
        ((IGamesService) zzqJ()).zzm(new VideoRecordingCapabilitiesBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_video_Videos_VideoCapabilitiesResult));
    }

    public void zzg(zza.zzb<LoadMatchResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzp(new TurnBasedMatchLoadedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult), str);
    }

    public void zzg(zza.zzb<LoadProfileSettingsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzg(new ProfileSettingsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult), z);
    }

    public void zzgs(int i) {
        this.zzaEd.setGravity(i);
    }

    public void zzgt(int i) {
        try {
            ((IGamesService) zzqJ()).zzgt(i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    protected String zzgu() {
        return "com.google.android.gms.games.service.START";
    }

    protected String zzgv() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void zzh(zza.zzb<VideoAvailableResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_video_Videos_VideoAvailableResult) throws RemoteException {
        ((IGamesService) zzqJ()).zzn(new VideoRecordingAvailableBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_video_Videos_VideoAvailableResult));
    }

    public void zzh(zza.zzb<AcceptQuestResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult, String str) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zzu(new QuestAcceptedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult), str);
    }

    public void zzh(zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzh(new ProfileSettingsUpdatedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), z);
    }

    public void zzi(zza.zzb<ListVideosResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_video_Videos_ListVideosResult) throws RemoteException {
        ((IGamesService) zzqJ()).zzl(new ListVideosBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_video_Videos_ListVideosResult));
    }

    public void zzi(zza.zzb<DeleteSnapshotResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzr(new SnapshotDeletedBinderCallbacks(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult), str);
    }

    public void zzi(zza.zzb<ContactSettingLoadResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zze(new ContactSettingsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult), z);
    }

    public void zzj(zza.zzb<LoadAclResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult) throws RemoteException {
        ((IGamesService) zzqJ()).zzh(new NotifyAclLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult));
    }

    public void zzj(zza.zzb<LoadGameInstancesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzf(new GameInstancesLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult), str);
    }

    public void zzk(zza.zzb<InboxCountResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Notifications_InboxCountResult) throws RemoteException {
        ((IGamesService) zzqJ()).zzt(new InboxCountsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Notifications_InboxCountResult), null);
    }

    public void zzk(zza.zzb<LoadGameSearchSuggestionsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzq(new GameSearchSuggestionsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult), str);
    }

    public Intent zzl(String str, int i, int i2) {
        try {
            return ((IGamesService) zzqJ()).zzm(str, i, i2);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzl(zza.zzb<LoadExperimentsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Games_LoadExperimentsResult) throws RemoteException {
        ((IGamesService) zzqJ()).zzo(new ExperimentsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Games_LoadExperimentsResult));
    }

    public void zzl(zza.zzb<LoadXpForGameCategoriesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult), str);
    }

    public void zzm(zza.zzb<LoadInvitationsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzk(new InvitationsLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str);
    }

    public boolean zzmE() {
        return true;
    }

    protected Bundle zzml() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zzvD = this.zzaEh.zzvD();
        zzvD.putString("com.google.android.gms.games.key.gamePackageName", this.zzaEa);
        zzvD.putString("com.google.android.gms.games.key.desiredLocale", locale);
        zzvD.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzaEd.zzxj()));
        zzvD.putInt("com.google.android.gms.games.key.API_VERSION", 3);
        zzvD.putBundle("com.google.android.gms.games.key.signInOptions", zzh.zza(zzqH()));
        return zzvD;
    }

    public void zzn(zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzj(new NotifyAclUpdatedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), str);
    }

    public void zzo(View view) {
        this.zzaEd.zzp(view);
    }

    public void zzo(zza.zzb<GameMuteStatusLoadResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzi(new GameMuteStatusLoadedBinderCallback(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult), str);
    }

    public Bundle zzoi() {
        try {
            Bundle zzoi = ((IGamesService) zzqJ()).zzoi();
            if (zzoi == null) {
                return zzoi;
            }
            zzoi.setClassLoader(GamesClientImpl.class.getClassLoader());
            return zzoi;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzp(String str, int i) {
        this.zzaDZ.zzp(str, i);
    }

    public void zzq(String str, int i) {
        try {
            ((IGamesService) zzqJ()).zzq(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzr(String str, int i) {
        try {
            ((IGamesService) zzqJ()).zzr(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzwA() {
        try {
            return ((IGamesService) zzqJ()).zzwA();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzwB() {
        try {
            return ((IGamesService) zzqJ()).zzwB();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzwC() {
        try {
            return ((IGamesService) zzqJ()).zzwC();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzwD() {
        try {
            ((IGamesService) zzqJ()).zzG(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzwE() {
        try {
            ((IGamesService) zzqJ()).zzH(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzwF() {
        try {
            ((IGamesService) zzqJ()).zzJ(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzwG() {
        try {
            ((IGamesService) zzqJ()).zzI(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzwH() {
        try {
            return ((IGamesService) zzqJ()).zzwH();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzwI() {
        try {
            return ((IGamesService) zzqJ()).zzwI();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzwJ() {
        try {
            return ((IGamesService) zzqJ()).zzwJ();
        } catch (RemoteException e) {
            zzb(e);
            return 4368;
        }
    }

    public String zzwK() {
        try {
            return ((IGamesService) zzqJ()).zzwK();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzwL() {
        try {
            return ((IGamesService) zzqJ()).zzwL();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zzwM() {
        try {
            return ((IGamesService) zzqJ()).zzwM();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzwN() {
        try {
            return ((IGamesService) zzqJ()).zzwN();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzwO() {
        try {
            return ((IGamesService) zzqJ()).zzwO();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzwP() {
        try {
            return ((IGamesService) zzqJ()).zzwP();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzwQ() {
        try {
            return ((IGamesService) zzqJ()).zzwQ();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzwR() {
        if (isConnected()) {
            try {
                ((IGamesService) zzqJ()).zzwR();
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public String zzww() {
        try {
            return ((IGamesService) zzqJ()).zzww();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Player zzwx() {
        zzqI();
        synchronized (this) {
            if (this.zzaEb == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) zzqJ()).zzwU());
                    if (playerBuffer.getCount() > 0) {
                        this.zzaEb = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    zzb(e);
                } catch (Throwable th) {
                    playerBuffer.release();
                }
            }
        }
        return this.zzaEb;
    }

    public Game zzwy() {
        GameBuffer gameBuffer;
        zzqI();
        synchronized (this) {
            if (this.zzaEc == null) {
                try {
                    gameBuffer = new GameBuffer(((IGamesService) zzqJ()).zzwW());
                    if (gameBuffer.getCount() > 0) {
                        this.zzaEc = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    zzb(e);
                } catch (Throwable th) {
                    gameBuffer.release();
                }
            }
        }
        return this.zzaEc;
    }

    public Intent zzwz() {
        try {
            return ((IGamesService) zzqJ()).zzwz();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }
}
