package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends zzc implements LeaderboardScore {
    private final PlayerRef zzaJq;

    LeaderboardScoreRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.zzaJq = new PlayerRef(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardScoreEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzxK();
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        zza("display_rank", dataOut);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        zza("display_score", dataOut);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        return zzcB("external_player_id") ? null : this.zzaJq;
    }

    public String getScoreHolderDisplayName() {
        return zzcB("external_player_id") ? getString("default_display_name") : this.zzaJq.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (zzcB("external_player_id")) {
            zza("default_display_name", dataOut);
        } else {
            this.zzaJq.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return zzcB("external_player_id") ? null : this.zzaJq.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return zzcB("external_player_id") ? null : this.zzaJq.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return zzcB("external_player_id") ? zzcA("default_display_image_uri") : this.zzaJq.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return zzcB("external_player_id") ? getString("default_display_image_url") : this.zzaJq.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }

    public LeaderboardScore zzxK() {
        return new LeaderboardScoreEntity(this);
    }
}
