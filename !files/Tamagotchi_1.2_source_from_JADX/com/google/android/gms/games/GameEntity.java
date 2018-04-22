package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzms;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
    private final int mVersionCode;
    private final boolean zzDZ;
    private final String zzWQ;
    private final String zzZC;
    private final String zzaCa;
    private final String zzaCb;
    private final String zzaCc;
    private final Uri zzaCd;
    private final Uri zzaCe;
    private final Uri zzaCf;
    private final boolean zzaCg;
    private final boolean zzaCh;
    private final String zzaCi;
    private final int zzaCj;
    private final int zzaCk;
    private final int zzaCl;
    private final boolean zzaCm;
    private final boolean zzaCn;
    private final String zzaCo;
    private final String zzaCp;
    private final String zzaCq;
    private final boolean zzaCr;
    private final boolean zzaCs;
    private final String zzaCt;
    private final boolean zzaCu;
    private final String zzaxl;

    static final class GameEntityCreatorCompat extends GameEntityCreator {
        GameEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzea(parcel);
        }

        public GameEntity zzea(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzqB()) || DowngradeableSafeParcel.zzcF(GameEntity.class.getCanonicalName())) {
                return super.zzea(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            Uri parse2 = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            return new GameEntity(7, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString7 == null ? null : Uri.parse(readString7), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null, false);
        }
    }

    GameEntity(int versionCode, String applicationId, String displayName, String primaryCategory, String secondaryCategory, String description, String developerName, Uri iconImageUri, Uri hiResImageUri, Uri featuredImageUri, boolean playEnabledGame, boolean instanceInstalled, String instancePackageName, int gameplayAclStatus, int achievementTotalCount, int leaderboardCount, boolean realTimeEnabled, boolean turnBasedEnabled, String iconImageUrl, String hiResImageUrl, String featuredImageUrl, boolean muted, boolean identitySharingConfirmed, boolean snapshotsEnabled, String themeColor, boolean hasGamepadSupport) {
        this.mVersionCode = versionCode;
        this.zzZC = applicationId;
        this.zzWQ = displayName;
        this.zzaCa = primaryCategory;
        this.zzaCb = secondaryCategory;
        this.zzaxl = description;
        this.zzaCc = developerName;
        this.zzaCd = iconImageUri;
        this.zzaCo = iconImageUrl;
        this.zzaCe = hiResImageUri;
        this.zzaCp = hiResImageUrl;
        this.zzaCf = featuredImageUri;
        this.zzaCq = featuredImageUrl;
        this.zzaCg = playEnabledGame;
        this.zzaCh = instanceInstalled;
        this.zzaCi = instancePackageName;
        this.zzaCj = gameplayAclStatus;
        this.zzaCk = achievementTotalCount;
        this.zzaCl = leaderboardCount;
        this.zzaCm = realTimeEnabled;
        this.zzaCn = turnBasedEnabled;
        this.zzDZ = muted;
        this.zzaCr = identitySharingConfirmed;
        this.zzaCs = snapshotsEnabled;
        this.zzaCt = themeColor;
        this.zzaCu = hasGamepadSupport;
    }

    public GameEntity(Game game) {
        this.mVersionCode = 7;
        this.zzZC = game.getApplicationId();
        this.zzaCa = game.getPrimaryCategory();
        this.zzaCb = game.getSecondaryCategory();
        this.zzaxl = game.getDescription();
        this.zzaCc = game.getDeveloperName();
        this.zzWQ = game.getDisplayName();
        this.zzaCd = game.getIconImageUri();
        this.zzaCo = game.getIconImageUrl();
        this.zzaCe = game.getHiResImageUri();
        this.zzaCp = game.getHiResImageUrl();
        this.zzaCf = game.getFeaturedImageUri();
        this.zzaCq = game.getFeaturedImageUrl();
        this.zzaCg = game.zzvx();
        this.zzaCh = game.zzvz();
        this.zzaCi = game.zzvA();
        this.zzaCj = game.zzvB();
        this.zzaCk = game.getAchievementTotalCount();
        this.zzaCl = game.getLeaderboardCount();
        this.zzaCm = game.isRealTimeMultiplayerEnabled();
        this.zzaCn = game.isTurnBasedMultiplayerEnabled();
        this.zzDZ = game.isMuted();
        this.zzaCr = game.zzvy();
        this.zzaCs = game.areSnapshotsEnabled();
        this.zzaCt = game.getThemeColor();
        this.zzaCu = game.hasGamepadSupport();
    }

    static int zza(Game game) {
        return zzw.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zzvx()), Boolean.valueOf(game.zzvz()), game.zzvA(), Integer.valueOf(game.zzvB()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.zzvy()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()));
    }

    static boolean zza(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (zzw.equal(game2.getApplicationId(), game.getApplicationId()) && zzw.equal(game2.getDisplayName(), game.getDisplayName()) && zzw.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && zzw.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && zzw.equal(game2.getDescription(), game.getDescription()) && zzw.equal(game2.getDeveloperName(), game.getDeveloperName()) && zzw.equal(game2.getIconImageUri(), game.getIconImageUri()) && zzw.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && zzw.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && zzw.equal(Boolean.valueOf(game2.zzvx()), Boolean.valueOf(game.zzvx())) && zzw.equal(Boolean.valueOf(game2.zzvz()), Boolean.valueOf(game.zzvz())) && zzw.equal(game2.zzvA(), game.zzvA()) && zzw.equal(Integer.valueOf(game2.zzvB()), Integer.valueOf(game.zzvB())) && zzw.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && zzw.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && zzw.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            Boolean valueOf = Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled());
            boolean z = game.isTurnBasedMultiplayerEnabled() && zzw.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && zzw.equal(Boolean.valueOf(game2.zzvy()), Boolean.valueOf(game.zzvy()));
            if (zzw.equal(valueOf, Boolean.valueOf(z)) && zzw.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && zzw.equal(game2.getThemeColor(), game.getThemeColor()) && zzw.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()))) {
                return true;
            }
        }
        return false;
    }

    static String zzb(Game game) {
        return zzw.zzy(game).zzg("ApplicationId", game.getApplicationId()).zzg("DisplayName", game.getDisplayName()).zzg("PrimaryCategory", game.getPrimaryCategory()).zzg("SecondaryCategory", game.getSecondaryCategory()).zzg("Description", game.getDescription()).zzg("DeveloperName", game.getDeveloperName()).zzg("IconImageUri", game.getIconImageUri()).zzg("IconImageUrl", game.getIconImageUrl()).zzg("HiResImageUri", game.getHiResImageUri()).zzg("HiResImageUrl", game.getHiResImageUrl()).zzg("FeaturedImageUri", game.getFeaturedImageUri()).zzg("FeaturedImageUrl", game.getFeaturedImageUrl()).zzg("PlayEnabledGame", Boolean.valueOf(game.zzvx())).zzg("InstanceInstalled", Boolean.valueOf(game.zzvz())).zzg("InstancePackageName", game.zzvA()).zzg("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).zzg("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).zzg("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).zzg("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).zzg("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).zzg("ThemeColor", game.getThemeColor()).zzg("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    public boolean areSnapshotsEnabled() {
        return this.zzaCs;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.zzaCk;
    }

    public String getApplicationId() {
        return this.zzZC;
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzaxl, dataOut);
    }

    public String getDeveloperName() {
        return this.zzaCc;
    }

    public void getDeveloperName(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzaCc, dataOut);
    }

    public String getDisplayName() {
        return this.zzWQ;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzWQ, dataOut);
    }

    public Uri getFeaturedImageUri() {
        return this.zzaCf;
    }

    public String getFeaturedImageUrl() {
        return this.zzaCq;
    }

    public Uri getHiResImageUri() {
        return this.zzaCe;
    }

    public String getHiResImageUrl() {
        return this.zzaCp;
    }

    public Uri getIconImageUri() {
        return this.zzaCd;
    }

    public String getIconImageUrl() {
        return this.zzaCo;
    }

    public int getLeaderboardCount() {
        return this.zzaCl;
    }

    public String getPrimaryCategory() {
        return this.zzaCa;
    }

    public String getSecondaryCategory() {
        return this.zzaCb;
    }

    public String getThemeColor() {
        return this.zzaCt;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasGamepadSupport() {
        return this.zzaCu;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isMuted() {
        return this.zzDZ;
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return this.zzaCm;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return this.zzaCn;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 1;
        String str = null;
        if (zzqC()) {
            dest.writeString(this.zzZC);
            dest.writeString(this.zzWQ);
            dest.writeString(this.zzaCa);
            dest.writeString(this.zzaCb);
            dest.writeString(this.zzaxl);
            dest.writeString(this.zzaCc);
            dest.writeString(this.zzaCd == null ? null : this.zzaCd.toString());
            dest.writeString(this.zzaCe == null ? null : this.zzaCe.toString());
            if (this.zzaCf != null) {
                str = this.zzaCf.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.zzaCg ? 1 : 0);
            if (!this.zzaCh) {
                i = 0;
            }
            dest.writeInt(i);
            dest.writeString(this.zzaCi);
            dest.writeInt(this.zzaCj);
            dest.writeInt(this.zzaCk);
            dest.writeInt(this.zzaCl);
            return;
        }
        GameEntityCreator.zza(this, dest, flags);
    }

    public String zzvA() {
        return this.zzaCi;
    }

    public int zzvB() {
        return this.zzaCj;
    }

    public boolean zzvx() {
        return this.zzaCg;
    }

    public boolean zzvy() {
        return this.zzaCr;
    }

    public boolean zzvz() {
        return this.zzaCh;
    }
}
