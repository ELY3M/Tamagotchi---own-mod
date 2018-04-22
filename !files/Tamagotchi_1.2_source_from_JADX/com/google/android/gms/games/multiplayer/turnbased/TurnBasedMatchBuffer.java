package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class TurnBasedMatchBuffer extends zzf<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzk(int i, int i2) {
        return zzs(i, i2);
    }

    protected String zzqg() {
        return "external_match_id";
    }

    protected TurnBasedMatch zzs(int i, int i2) {
        return new TurnBasedMatchRef(this.zzahi, i, i2);
    }
}
