package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzms;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
    private final String zzWQ;
    private final Uri zzaCd;
    private final String zzaCo;
    private final String zzaIZ;
    private final int zzaJa;
    private final ArrayList<LeaderboardVariantEntity> zzaJb;
    private final Game zzaJc;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.zzaIZ = leaderboard.getLeaderboardId();
        this.zzWQ = leaderboard.getDisplayName();
        this.zzaCd = leaderboard.getIconImageUri();
        this.zzaCo = leaderboard.getIconImageUrl();
        this.zzaJa = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.zzaJc = game == null ? null : new GameEntity(game);
        ArrayList variants = leaderboard.getVariants();
        int size = variants.size();
        this.zzaJb = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaJb.add((LeaderboardVariantEntity) ((LeaderboardVariant) variants.get(i)).freeze());
        }
    }

    static int zza(Leaderboard leaderboard) {
        return zzw.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    static boolean zza(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return zzw.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && zzw.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && zzw.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && zzw.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && zzw.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    static String zzb(Leaderboard leaderboard) {
        return zzw.zzy(leaderboard).zzg("LeaderboardId", leaderboard.getLeaderboardId()).zzg("DisplayName", leaderboard.getDisplayName()).zzg("IconImageUri", leaderboard.getIconImageUri()).zzg("IconImageUrl", leaderboard.getIconImageUrl()).zzg("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).zzg("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzxI();
    }

    public String getDisplayName() {
        return this.zzWQ;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzWQ, dataOut);
    }

    public Game getGame() {
        return this.zzaJc;
    }

    public Uri getIconImageUri() {
        return this.zzaCd;
    }

    public String getIconImageUrl() {
        return this.zzaCo;
    }

    public String getLeaderboardId() {
        return this.zzaIZ;
    }

    public int getScoreOrder() {
        return this.zzaJa;
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList(this.zzaJb);
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public Leaderboard zzxI() {
        return this;
    }
}
