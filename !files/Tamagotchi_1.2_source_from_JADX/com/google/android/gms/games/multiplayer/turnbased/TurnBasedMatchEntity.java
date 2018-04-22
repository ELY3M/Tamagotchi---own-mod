package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zzms;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
    public static final Creator<TurnBasedMatchEntity> CREATOR = new TurnBasedMatchEntityCreator();
    private final int mVersion;
    private final int mVersionCode;
    private final long zzaDt;
    private final String zzaER;
    private final GameEntity zzaJE;
    private final long zzaJF;
    private final ArrayList<ParticipantEntity> zzaJI;
    private final int zzaJJ;
    private final Bundle zzaJZ;
    private final String zzaKb;
    private final String zzaKj;
    private final String zzaKk;
    private final int zzaKl;
    private final byte[] zzaKm;
    private final String zzaKn;
    private final byte[] zzaKo;
    private final int zzaKp;
    private final int zzaKq;
    private final boolean zzaKr;
    private final String zzaKs;
    private final String zzaxl;

    TurnBasedMatchEntity(int versionCode, GameEntity game, String matchId, String creatorId, long creationTimestamp, String lastUpdaterId, long lastUpdatedTimestamp, String pendingParticipantId, int matchStatus, int variant, int version, byte[] data, ArrayList<ParticipantEntity> participants, String rematchId, byte[] previousData, int matchNumber, Bundle autoMatchCriteria, int turnStatus, boolean isLocallyModified, String description, String descriptionParticipantId) {
        this.mVersionCode = versionCode;
        this.zzaJE = game;
        this.zzaER = matchId;
        this.zzaKb = creatorId;
        this.zzaJF = creationTimestamp;
        this.zzaKj = lastUpdaterId;
        this.zzaDt = lastUpdatedTimestamp;
        this.zzaKk = pendingParticipantId;
        this.zzaKl = matchStatus;
        this.zzaKq = turnStatus;
        this.zzaJJ = variant;
        this.mVersion = version;
        this.zzaKm = data;
        this.zzaJI = participants;
        this.zzaKn = rematchId;
        this.zzaKo = previousData;
        this.zzaKp = matchNumber;
        this.zzaJZ = autoMatchCriteria;
        this.zzaKr = isLocallyModified;
        this.zzaxl = description;
        this.zzaKs = descriptionParticipantId;
    }

    public TurnBasedMatchEntity(TurnBasedMatch match) {
        this.mVersionCode = 2;
        this.zzaJE = new GameEntity(match.getGame());
        this.zzaER = match.getMatchId();
        this.zzaKb = match.getCreatorId();
        this.zzaJF = match.getCreationTimestamp();
        this.zzaKj = match.getLastUpdaterId();
        this.zzaDt = match.getLastUpdatedTimestamp();
        this.zzaKk = match.getPendingParticipantId();
        this.zzaKl = match.getStatus();
        this.zzaKq = match.getTurnStatus();
        this.zzaJJ = match.getVariant();
        this.mVersion = match.getVersion();
        this.zzaKn = match.getRematchId();
        this.zzaKp = match.getMatchNumber();
        this.zzaJZ = match.getAutoMatchCriteria();
        this.zzaKr = match.isLocallyModified();
        this.zzaxl = match.getDescription();
        this.zzaKs = match.getDescriptionParticipantId();
        Object data = match.getData();
        if (data == null) {
            this.zzaKm = null;
        } else {
            this.zzaKm = new byte[data.length];
            System.arraycopy(data, 0, this.zzaKm, 0, data.length);
        }
        data = match.getPreviousMatchData();
        if (data == null) {
            this.zzaKo = null;
        } else {
            this.zzaKo = new byte[data.length];
            System.arraycopy(data, 0, this.zzaKo, 0, data.length);
        }
        ArrayList participants = match.getParticipants();
        int size = participants.size();
        this.zzaJI = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaJI.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
    }

    static int zza(TurnBasedMatch turnBasedMatch) {
        return zzw.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), turnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static int zza(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static boolean zza(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return zzw.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && zzw.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && zzw.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && zzw.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && zzw.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && zzw.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && zzw.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && zzw.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && zzw.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && zzw.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && zzw.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && zzw.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && zzw.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && zzw.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && zzw.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && zzw.equal(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && zzw.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && zzw.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static String zzb(TurnBasedMatch turnBasedMatch) {
        return zzw.zzy(turnBasedMatch).zzg("Game", turnBasedMatch.getGame()).zzg("MatchId", turnBasedMatch.getMatchId()).zzg("CreatorId", turnBasedMatch.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).zzg("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).zzg("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).zzg("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).zzg("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).zzg("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).zzg("Description", turnBasedMatch.getDescription()).zzg("Variant", Integer.valueOf(turnBasedMatch.getVariant())).zzg("Data", turnBasedMatch.getData()).zzg("Version", Integer.valueOf(turnBasedMatch.getVersion())).zzg("Participants", turnBasedMatch.getParticipants()).zzg("RematchId", turnBasedMatch.getRematchId()).zzg("PreviousData", turnBasedMatch.getPreviousMatchData()).zzg("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).zzg("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).zzg("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).zzg("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).zzg("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    static String zzb(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant zzc(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static ArrayList<String> zzc(TurnBasedMatch turnBasedMatch) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public boolean canRematch() {
        return this.zzaKl == 2 && this.zzaKn == null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza((TurnBasedMatch) this, obj);
    }

    public TurnBasedMatch freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzaJZ;
    }

    public int getAvailableAutoMatchSlots() {
        return this.zzaJZ == null ? 0 : this.zzaJZ.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public long getCreationTimestamp() {
        return this.zzaJF;
    }

    public String getCreatorId() {
        return this.zzaKb;
    }

    public byte[] getData() {
        return this.zzaKm;
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzaxl, dataOut);
    }

    public Participant getDescriptionParticipant() {
        String descriptionParticipantId = getDescriptionParticipantId();
        return descriptionParticipantId == null ? null : getParticipant(descriptionParticipantId);
    }

    public String getDescriptionParticipantId() {
        return this.zzaKs;
    }

    public Game getGame() {
        return this.zzaJE;
    }

    public long getLastUpdatedTimestamp() {
        return this.zzaDt;
    }

    public String getLastUpdaterId() {
        return this.zzaKj;
    }

    public String getMatchId() {
        return this.zzaER;
    }

    public int getMatchNumber() {
        return this.zzaKp;
    }

    public Participant getParticipant(String participantId) {
        return zzc(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return zzb(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return zzc(this);
    }

    public int getParticipantStatus(String participantId) {
        return zza((TurnBasedMatch) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzaJI);
    }

    public String getPendingParticipantId() {
        return this.zzaKk;
    }

    public byte[] getPreviousMatchData() {
        return this.zzaKo;
    }

    public String getRematchId() {
        return this.zzaKn;
    }

    public int getStatus() {
        return this.zzaKl;
    }

    public int getTurnStatus() {
        return this.zzaKq;
    }

    public int getVariant() {
        return this.zzaJJ;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isLocallyModified() {
        return this.zzaKr;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        TurnBasedMatchEntityCreator.zza(this, out, flags);
    }
}
