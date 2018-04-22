package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig.Builder;

public final class TurnBasedMatchConfigImpl extends TurnBasedMatchConfig {
    private final int zzaJJ;
    private final Bundle zzaJZ;
    private final String[] zzaKa;
    private final int zzaKi;

    TurnBasedMatchConfigImpl(Builder builder) {
        this.zzaJJ = builder.zzaJJ;
        this.zzaKi = builder.zzaKi;
        this.zzaJZ = builder.zzaJZ;
        this.zzaKa = (String[]) builder.zzaJY.toArray(new String[builder.zzaJY.size()]);
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzaJZ;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzaKa;
    }

    public int getVariant() {
        return this.zzaJJ;
    }

    public int zzxP() {
        return this.zzaKi;
    }
}
