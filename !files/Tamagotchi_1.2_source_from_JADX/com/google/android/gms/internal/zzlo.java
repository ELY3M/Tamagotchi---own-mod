package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzf;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzlo {
    private final int zzabo;
    private final String zzacX;
    private final JSONObject zzadn;

    public zzlo(String str, int i, JSONObject jSONObject) {
        this.zzacX = str;
        this.zzabo = i;
        this.zzadn = jSONObject;
    }

    public zzlo(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("playerId"), jSONObject.optInt("playerState"), jSONObject.optJSONObject("playerData"));
    }

    public boolean equals(Object otherObj) {
        if (otherObj == null || !(otherObj instanceof zzlo)) {
            return false;
        }
        zzlo com_google_android_gms_internal_zzlo = (zzlo) otherObj;
        return this.zzabo == com_google_android_gms_internal_zzlo.getPlayerState() && zzf.zza(this.zzacX, com_google_android_gms_internal_zzlo.getPlayerId()) && zznb.zze(this.zzadn, com_google_android_gms_internal_zzlo.getPlayerData());
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
}
