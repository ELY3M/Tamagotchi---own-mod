package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final InvitationBuffer zzaKe;
    private final TurnBasedMatchBuffer zzaKf;
    private final TurnBasedMatchBuffer zzaKg;
    private final TurnBasedMatchBuffer zzaKh;

    public LoadMatchesResponse(Bundle matchData) {
        DataHolder zza = zza(matchData, 0);
        if (zza != null) {
            this.zzaKe = new InvitationBuffer(zza);
        } else {
            this.zzaKe = null;
        }
        zza = zza(matchData, 1);
        if (zza != null) {
            this.zzaKf = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzaKf = null;
        }
        zza = zza(matchData, 2);
        if (zza != null) {
            this.zzaKg = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzaKg = null;
        }
        zza = zza(matchData, 3);
        if (zza != null) {
            this.zzaKh = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzaKh = null;
        }
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String zzgw = TurnBasedMatchTurnStatus.zzgw(i);
        return !bundle.containsKey(zzgw) ? null : (DataHolder) bundle.getParcelable(zzgw);
    }

    @Deprecated
    public void close() {
        release();
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzaKh;
    }

    public InvitationBuffer getInvitations() {
        return this.zzaKe;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzaKf;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzaKg;
    }

    public boolean hasData() {
        return (this.zzaKe == null || this.zzaKe.getCount() <= 0) ? (this.zzaKf == null || this.zzaKf.getCount() <= 0) ? (this.zzaKg == null || this.zzaKg.getCount() <= 0) ? this.zzaKh != null && this.zzaKh.getCount() > 0 : true : true : true;
    }

    public void release() {
        if (this.zzaKe != null) {
            this.zzaKe.release();
        }
        if (this.zzaKf != null) {
            this.zzaKf.release();
        }
        if (this.zzaKg != null) {
            this.zzaKg.release();
        }
        if (this.zzaKh != null) {
            this.zzaKh.release();
        }
    }
}
