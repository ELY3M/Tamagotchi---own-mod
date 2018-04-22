package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzb;

public class PlayerStatsRef extends zzc implements PlayerStats {
    private Bundle zzaLk;

    PlayerStatsRef(DataHolder holder, int rowIndex) {
        super(holder, rowIndex);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerStatsEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzxW();
    }

    public float getAverageSessionLength() {
        return getFloat("ave_session_length_minutes");
    }

    public float getChurnProbability() {
        return getFloat("churn_probability");
    }

    public int getDaysSinceLastPlayed() {
        return getInteger("days_since_last_played");
    }

    public int getNumberOfPurchases() {
        return getInteger("num_purchases");
    }

    public int getNumberOfSessions() {
        return getInteger("num_sessions");
    }

    public float getSessionPercentile() {
        return getFloat("num_sessions_percentile");
    }

    public float getSpendPercentile() {
        return getFloat("spend_percentile");
    }

    public float getSpendProbability() {
        return !zzcz("spend_probability") ? -1.0f : getFloat("spend_probability");
    }

    public int hashCode() {
        return PlayerStatsEntity.zza(this);
    }

    public String toString() {
        return PlayerStatsEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerStatsEntity) zzxW()).writeToParcel(dest, flags);
    }

    public Bundle zzxV() {
        int i = 0;
        if (this.zzaLk != null) {
            return this.zzaLk;
        }
        this.zzaLk = new Bundle();
        String string = getString("unknown_raw_keys");
        String string2 = getString("unknown_raw_values");
        if (!(string == null || string2 == null)) {
            String[] split = string.split(",");
            String[] split2 = string2.split(",");
            zzb.zza(split.length <= split2.length, "Invalid raw arguments!");
            while (i < split.length) {
                this.zzaLk.putString(split[i], split2[i]);
                i++;
            }
        }
        return this.zzaLk;
    }

    public PlayerStats zzxW() {
        return new PlayerStatsEntity(this);
    }
}
