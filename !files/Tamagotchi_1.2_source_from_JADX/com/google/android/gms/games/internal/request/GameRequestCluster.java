package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestCluster implements SafeParcelable, GameRequest {
    public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
    private final int mVersionCode;
    private final ArrayList<GameRequestEntity> zzaIW;

    GameRequestCluster(int versionCode, ArrayList<GameRequestEntity> requestList) {
        this.mVersionCode = versionCode;
        this.zzaIW = requestList;
        zzxr();
    }

    private void zzxr() {
        zzb.zzab(!this.zzaIW.isEmpty());
        GameRequest gameRequest = (GameRequest) this.zzaIW.get(0);
        int size = this.zzaIW.size();
        for (int i = 1; i < size; i++) {
            GameRequest gameRequest2 = (GameRequest) this.zzaIW.get(i);
            zzb.zza(gameRequest.getType() == gameRequest2.getType(), "All the requests must be of the same type");
            zzb.zza(gameRequest.getSender().equals(gameRequest2.getSender()), "All the requests must be from the same sender");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GameRequestCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GameRequestCluster gameRequestCluster = (GameRequestCluster) obj;
        if (gameRequestCluster.zzaIW.size() != this.zzaIW.size()) {
            return false;
        }
        int size = this.zzaIW.size();
        for (int i = 0; i < size; i++) {
            if (!((GameRequest) this.zzaIW.get(i)).equals((GameRequest) gameRequestCluster.zzaIW.get(i))) {
                return false;
            }
        }
        return true;
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public byte[] getData() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getExpirationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getRecipientStatus(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public /* synthetic */ List getRecipients() {
        return zzxG();
    }

    public String getRequestId() {
        return ((GameRequestEntity) this.zzaIW.get(0)).getRequestId();
    }

    public Player getSender() {
        return ((GameRequestEntity) this.zzaIW.get(0)).getSender();
    }

    public int getStatus() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getType() {
        return ((GameRequestEntity) this.zzaIW.get(0)).getType();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaIW.toArray());
    }

    public boolean isConsumed(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestClusterCreator.zza(this, dest, flags);
    }

    public ArrayList<GameRequest> zzxF() {
        return new ArrayList(this.zzaIW);
    }

    public ArrayList<Player> zzxG() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
}
