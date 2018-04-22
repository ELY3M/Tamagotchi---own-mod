package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig.Builder;

public final class RoomConfigImpl extends RoomConfig {
    private final String zzUO;
    private final int zzaJJ;
    private final RoomUpdateListener zzaJU;
    private final RoomStatusUpdateListener zzaJV;
    private final RealTimeMessageReceivedListener zzaJW;
    private final Bundle zzaJZ;
    private final String[] zzaKa;

    RoomConfigImpl(Builder builder) {
        this.zzaJU = builder.zzaJU;
        this.zzaJV = builder.zzaJV;
        this.zzaJW = builder.zzaJW;
        this.zzUO = builder.zzaJX;
        this.zzaJJ = builder.zzaJJ;
        this.zzaJZ = builder.zzaJZ;
        this.zzaKa = (String[]) builder.zzaJY.toArray(new String[builder.zzaJY.size()]);
        zzx.zzb(this.zzaJW, (Object) "Must specify a message listener");
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzaJZ;
    }

    public String getInvitationId() {
        return this.zzUO;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzaKa;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.zzaJW;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.zzaJV;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.zzaJU;
    }

    public int getVariant() {
        return this.zzaJJ;
    }
}
