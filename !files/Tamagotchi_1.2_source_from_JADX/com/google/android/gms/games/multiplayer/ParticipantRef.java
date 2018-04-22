package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef extends zzc implements Participant {
    private final PlayerRef zzaJO;

    public ParticipantRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.zzaJO = new PlayerRef(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ParticipantEntity.zza(this, obj);
    }

    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    public int getCapabilities() {
        return getInteger("capabilities");
    }

    public String getDisplayName() {
        return zzcB("external_player_id") ? getString("default_display_name") : this.zzaJO.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (zzcB("external_player_id")) {
            zza("default_display_name", dataOut);
        } else {
            this.zzaJO.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return zzcB("external_player_id") ? zzcA("default_display_hi_res_image_uri") : this.zzaJO.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return zzcB("external_player_id") ? getString("default_display_hi_res_image_url") : this.zzaJO.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return zzcB("external_player_id") ? zzcA("default_display_image_uri") : this.zzaJO.getIconImageUri();
    }

    public String getIconImageUrl() {
        return zzcB("external_player_id") ? getString("default_display_image_url") : this.zzaJO.getIconImageUrl();
    }

    public String getParticipantId() {
        return getString("external_participant_id");
    }

    public Player getPlayer() {
        return zzcB("external_player_id") ? null : this.zzaJO;
    }

    public ParticipantResult getResult() {
        if (zzcB("result_type")) {
            return null;
        }
        return new ParticipantResult(getParticipantId(), getInteger("result_type"), getInteger("placing"));
    }

    public int getStatus() {
        return getInteger("player_status");
    }

    public int hashCode() {
        return ParticipantEntity.zza(this);
    }

    public boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public String toString() {
        return ParticipantEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ParticipantEntity) freeze()).writeToParcel(dest, flags);
    }

    public String zzwt() {
        return getString("client_address");
    }
}
