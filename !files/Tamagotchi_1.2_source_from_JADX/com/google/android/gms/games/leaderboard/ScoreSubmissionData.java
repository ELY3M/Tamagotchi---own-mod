package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.TimeSpan;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] zzaIX = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private String zzaIZ;
    private HashMap<Integer, Result> zzaJD = new HashMap();
    private String zzacX;
    private int zzade;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore, String formattedScore, String scoreTag, boolean newBest) {
            this.rawScore = rawScore;
            this.formattedScore = formattedScore;
            this.scoreTag = scoreTag;
            this.newBest = newBest;
        }

        public String toString() {
            return zzw.zzy(this).zzg("RawScore", Long.valueOf(this.rawScore)).zzg("FormattedScore", this.formattedScore).zzg("ScoreTag", this.scoreTag).zzg("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.zzade = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        zzx.zzac(count == 3);
        for (int i = 0; i < count; i++) {
            int zzbH = dataHolder.zzbH(i);
            if (i == 0) {
                this.zzaIZ = dataHolder.zzd("leaderboardId", i, zzbH);
                this.zzacX = dataHolder.zzd("playerId", i, zzbH);
            }
            if (dataHolder.zze("hasResult", i, zzbH)) {
                zza(new Result(dataHolder.zzb("rawScore", i, zzbH), dataHolder.zzd("formattedScore", i, zzbH), dataHolder.zzd("scoreTag", i, zzbH), dataHolder.zze("newBest", i, zzbH)), dataHolder.zzc("timeSpan", i, zzbH));
            }
        }
    }

    private void zza(Result result, int i) {
        this.zzaJD.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.zzaIZ;
    }

    public String getPlayerId() {
        return this.zzacX;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.zzaJD.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        zza zzg = zzw.zzy(this).zzg("PlayerId", this.zzacX).zzg("StatusCode", Integer.valueOf(this.zzade));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.zzaJD.get(Integer.valueOf(i));
            zzg.zzg("TimesSpan", TimeSpan.zzgw(i));
            zzg.zzg("Result", result == null ? "null" : result.toString());
        }
        return zzg.toString();
    }
}
