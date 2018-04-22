package com.google.android.gms.internal;

import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONObject;

public final class zzln implements PlayerInfo {
    private final int zzabo;
    private final String zzacX;
    private final JSONObject zzadn;
    private final boolean zzado;

    public zzln(String str, int i, JSONObject jSONObject, boolean z) {
        this.zzacX = str;
        this.zzabo = i;
        this.zzadn = jSONObject;
        this.zzado = z;
    }

    public boolean equals(Object otherObj) {
        if (otherObj == null || !(otherObj instanceof PlayerInfo)) {
            return false;
        }
        PlayerInfo playerInfo = (PlayerInfo) otherObj;
        return this.zzado == playerInfo.isControllable() && this.zzabo == playerInfo.getPlayerState() && zzf.zza(this.zzacX, playerInfo.getPlayerId()) && zznb.zze(this.zzadn, playerInfo.getPlayerData());
    }

    public JSONObject getPlayerData() {
        return this.zzadn;
    }

    public String getPlayerId() {
        return this.zzacX;
    }

    public int getPlayerState() {
        return this.zzabo;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzacX, Integer.valueOf(this.zzabo), this.zzadn, Boolean.valueOf(this.zzado));
    }

    public boolean isConnected() {
        switch (this.zzabo) {
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    public boolean isControllable() {
        return this.zzado;
    }
}
