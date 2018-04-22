package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class LeaderboardVariantRef extends zzc implements LeaderboardVariant {
    LeaderboardVariantRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardVariantEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzxO();
    }

    public int getCollection() {
        return getInteger("collection");
    }

    public String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    public String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    public long getNumScores() {
        return zzcB("total_scores") ? -1 : getLong("total_scores");
    }

    public long getPlayerRank() {
        return zzcB("player_rank") ? -1 : getLong("player_rank");
    }

    public String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public long getRawPlayerScore() {
        return zzcB("player_raw_score") ? -1 : getLong("player_raw_score");
    }

    public int getTimeSpan() {
        return getInteger("timespan");
    }

    public boolean hasPlayerInfo() {
        return !zzcB("player_raw_score");
    }

    public int hashCode() {
        return LeaderboardVariantEntity.zza(this);
    }

    public String toString() {
        return LeaderboardVariantEntity.zzb(this);
    }

    public String zzxL() {
        return getString("top_page_token_next");
    }

    public String zzxM() {
        return getString("window_page_token_prev");
    }

    public String zzxN() {
        return getString("window_page_token_next");
    }

    public LeaderboardVariant zzxO() {
        return new LeaderboardVariantEntity(this);
    }
}
