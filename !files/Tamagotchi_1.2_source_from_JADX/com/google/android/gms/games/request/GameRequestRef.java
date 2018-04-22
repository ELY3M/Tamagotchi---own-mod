package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;

public final class GameRequestRef extends zzc implements GameRequest {
    private final int zzaDQ;

    public GameRequestRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.zzaDQ = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameRequestEntity.zza(this, obj);
    }

    public GameRequest freeze() {
        return new GameRequestEntity(this);
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public byte[] getData() {
        return getByteArray(TMXConstants.TAG_DATA);
    }

    public long getExpirationTimestamp() {
        return getLong("expiration_timestamp");
    }

    public Game getGame() {
        return new GameRef(this.zzahi, this.zzaje);
    }

    public int getRecipientStatus(String playerId) {
        for (int i = this.zzaje; i < this.zzaje + this.zzaDQ; i++) {
            int zzbH = this.zzahi.zzbH(i);
            if (this.zzahi.zzd("recipient_external_player_id", i, zzbH).equals(playerId)) {
                return this.zzahi.zzc("recipient_status", i, zzbH);
            }
        }
        return -1;
    }

    public List<Player> getRecipients() {
        List arrayList = new ArrayList(this.zzaDQ);
        for (int i = 0; i < this.zzaDQ; i++) {
            arrayList.add(new PlayerRef(this.zzahi, this.zzaje + i, "recipient_"));
        }
        return arrayList;
    }

    public String getRequestId() {
        return getString("external_request_id");
    }

    public Player getSender() {
        return new PlayerRef(this.zzahi, zzqc(), "sender_");
    }

    public int getStatus() {
        return getInteger("status");
    }

    public int getType() {
        return getInteger(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE);
    }

    public int hashCode() {
        return GameRequestEntity.zza(this);
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public String toString() {
        return GameRequestEntity.zzc(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((GameRequestEntity) freeze()).writeToParcel(dest, flags);
    }
}
