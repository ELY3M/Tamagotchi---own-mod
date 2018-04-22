package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzms;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
    private final int mVersionCode;
    private final int zzBc;
    private final String zzWQ;
    private final Uri zzaCd;
    private final Uri zzaCe;
    private final String zzaCo;
    private final String zzaCp;
    private final String zzaDX;
    private final PlayerEntity zzaDq;
    private final String zzaFa;
    private final boolean zzaJM;
    private final ParticipantResult zzaJN;
    private final int zzaab;

    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzes(parcel);
        }

        public ParticipantEntity zzes(Parcel parcel) {
            Object obj = 1;
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzqB()) || DowngradeableSafeParcel.zzcF(ParticipantEntity.class.getCanonicalName())) {
                return super.zzes(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                obj = null;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z, obj != null ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }
    }

    ParticipantEntity(int versionCode, String participantId, String displayName, Uri iconImageUri, Uri hiResImageUri, int status, String clientAddress, boolean connectedToRoom, PlayerEntity player, int capabilities, ParticipantResult result, String iconImageUrl, String hiResImageUrl) {
        this.mVersionCode = versionCode;
        this.zzaFa = participantId;
        this.zzWQ = displayName;
        this.zzaCd = iconImageUri;
        this.zzaCe = hiResImageUri;
        this.zzBc = status;
        this.zzaDX = clientAddress;
        this.zzaJM = connectedToRoom;
        this.zzaDq = player;
        this.zzaab = capabilities;
        this.zzaJN = result;
        this.zzaCo = iconImageUrl;
        this.zzaCp = hiResImageUrl;
    }

    public ParticipantEntity(Participant participant) {
        this.mVersionCode = 3;
        this.zzaFa = participant.getParticipantId();
        this.zzWQ = participant.getDisplayName();
        this.zzaCd = participant.getIconImageUri();
        this.zzaCe = participant.getHiResImageUri();
        this.zzBc = participant.getStatus();
        this.zzaDX = participant.zzwt();
        this.zzaJM = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.zzaDq = player == null ? null : new PlayerEntity(player);
        this.zzaab = participant.getCapabilities();
        this.zzaJN = participant.getResult();
        this.zzaCo = participant.getIconImageUrl();
        this.zzaCp = participant.getHiResImageUrl();
    }

    static int zza(Participant participant) {
        return zzw.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zzwt(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    static boolean zza(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return zzw.equal(participant2.getPlayer(), participant.getPlayer()) && zzw.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && zzw.equal(participant2.zzwt(), participant.zzwt()) && zzw.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && zzw.equal(participant2.getDisplayName(), participant.getDisplayName()) && zzw.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && zzw.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && zzw.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && zzw.equal(participant2.getResult(), participant.getResult()) && zzw.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    static String zzb(Participant participant) {
        return zzw.zzy(participant).zzg("ParticipantId", participant.getParticipantId()).zzg("Player", participant.getPlayer()).zzg("Status", Integer.valueOf(participant.getStatus())).zzg("ClientAddress", participant.zzwt()).zzg("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).zzg("DisplayName", participant.getDisplayName()).zzg("IconImage", participant.getIconImageUri()).zzg("IconImageUrl", participant.getIconImageUrl()).zzg("HiResImage", participant.getHiResImageUri()).zzg("HiResImageUrl", participant.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(participant.getCapabilities())).zzg("Result", participant.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public int getCapabilities() {
        return this.zzaab;
    }

    public String getDisplayName() {
        return this.zzaDq == null ? this.zzWQ : this.zzaDq.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (this.zzaDq == null) {
            zzms.zzb(this.zzWQ, dataOut);
        } else {
            this.zzaDq.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return this.zzaDq == null ? this.zzaCe : this.zzaDq.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.zzaDq == null ? this.zzaCp : this.zzaDq.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.zzaDq == null ? this.zzaCd : this.zzaDq.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.zzaDq == null ? this.zzaCo : this.zzaDq.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.zzaFa;
    }

    public Player getPlayer() {
        return this.zzaDq;
    }

    public ParticipantResult getResult() {
        return this.zzaJN;
    }

    public int getStatus() {
        return this.zzBc;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConnectedToRoom() {
        return this.zzaJM;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        int i = 0;
        if (zzqC()) {
            dest.writeString(this.zzaFa);
            dest.writeString(this.zzWQ);
            dest.writeString(this.zzaCd == null ? null : this.zzaCd.toString());
            if (this.zzaCe != null) {
                str = this.zzaCe.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.zzBc);
            dest.writeString(this.zzaDX);
            dest.writeInt(this.zzaJM ? 1 : 0);
            if (this.zzaDq != null) {
                i = 1;
            }
            dest.writeInt(i);
            if (this.zzaDq != null) {
                this.zzaDq.writeToParcel(dest, flags);
                return;
            }
            return;
        }
        ParticipantEntityCreator.zza(this, dest, flags);
    }

    public String zzwt() {
        return this.zzaDX;
    }
}
