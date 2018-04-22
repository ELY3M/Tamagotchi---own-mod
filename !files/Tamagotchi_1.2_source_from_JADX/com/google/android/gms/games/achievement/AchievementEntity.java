package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzms;

public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final Creator<AchievementEntity> CREATOR = new AchievementEntityCreator();
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final String zzaDj;
    private final Uri zzaDk;
    private final String zzaDl;
    private final Uri zzaDm;
    private final String zzaDn;
    private final int zzaDo;
    private final String zzaDp;
    private final PlayerEntity zzaDq;
    private final int zzaDr;
    private final String zzaDs;
    private final long zzaDt;
    private final long zzaDu;
    private final int zzabB;
    private final String zzaxl;

    AchievementEntity(int versionCode, String achievementId, int type, String name, String description, Uri unlockedImageUri, String unlockedImageUrl, Uri revealedImageUri, String revealedImageUrl, int totalSteps, String formattedTotalSteps, PlayerEntity player, int state, int currentSteps, String formattedCurrentSteps, long lastUpdatedTimestamp, long xpValue) {
        this.mVersionCode = versionCode;
        this.zzaDj = achievementId;
        this.zzabB = type;
        this.mName = name;
        this.zzaxl = description;
        this.zzaDk = unlockedImageUri;
        this.zzaDl = unlockedImageUrl;
        this.zzaDm = revealedImageUri;
        this.zzaDn = revealedImageUrl;
        this.zzaDo = totalSteps;
        this.zzaDp = formattedTotalSteps;
        this.zzaDq = player;
        this.mState = state;
        this.zzaDr = currentSteps;
        this.zzaDs = formattedCurrentSteps;
        this.zzaDt = lastUpdatedTimestamp;
        this.zzaDu = xpValue;
    }

    public AchievementEntity(Achievement achievement) {
        this.mVersionCode = 1;
        this.zzaDj = achievement.getAchievementId();
        this.zzabB = achievement.getType();
        this.mName = achievement.getName();
        this.zzaxl = achievement.getDescription();
        this.zzaDk = achievement.getUnlockedImageUri();
        this.zzaDl = achievement.getUnlockedImageUrl();
        this.zzaDm = achievement.getRevealedImageUri();
        this.zzaDn = achievement.getRevealedImageUrl();
        this.zzaDq = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.zzaDt = achievement.getLastUpdatedTimestamp();
        this.zzaDu = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.zzaDo = achievement.getTotalSteps();
            this.zzaDp = achievement.getFormattedTotalSteps();
            this.zzaDr = achievement.getCurrentSteps();
            this.zzaDs = achievement.getFormattedCurrentSteps();
        } else {
            this.zzaDo = 0;
            this.zzaDp = null;
            this.zzaDr = 0;
            this.zzaDs = null;
        }
        zzb.zzv(this.zzaDj);
        zzb.zzv(this.zzaxl);
    }

    static int zza(Achievement achievement) {
        int currentSteps;
        int totalSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            totalSteps = 0;
            currentSteps = 0;
        }
        return zzw.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps));
    }

    static boolean zza(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        boolean equal;
        boolean equal2;
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            equal = zzw.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            equal2 = zzw.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            equal2 = true;
            equal = true;
        }
        return zzw.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && zzw.equal(achievement2.getName(), achievement.getName()) && zzw.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && zzw.equal(achievement2.getDescription(), achievement.getDescription()) && zzw.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && zzw.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && zzw.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && zzw.equal(achievement2.getPlayer(), achievement.getPlayer()) && equal && equal2;
    }

    static String zzb(Achievement achievement) {
        zza zzg = zzw.zzy(achievement).zzg("Id", achievement.getAchievementId()).zzg("Type", Integer.valueOf(achievement.getType())).zzg("Name", achievement.getName()).zzg("Description", achievement.getDescription()).zzg("Player", achievement.getPlayer()).zzg("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            zzg.zzg("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            zzg.zzg("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return zzg.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Achievement freeze() {
        return this;
    }

    public String getAchievementId() {
        return this.zzaDj;
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzab(z);
        return zzvM();
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzaxl, dataOut);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzab(z);
        return zzvN();
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzab(z);
        zzms.zzb(this.zzaDs, dataOut);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzab(z);
        return zzvL();
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzab(z);
        zzms.zzb(this.zzaDp, dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return this.zzaDt;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        zzms.zzb(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.zzaDq;
    }

    public Uri getRevealedImageUri() {
        return this.zzaDm;
    }

    public String getRevealedImageUrl() {
        return this.zzaDn;
    }

    public int getState() {
        return this.mState;
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzab(z);
        return zzvK();
    }

    public int getType() {
        return this.zzabB;
    }

    public Uri getUnlockedImageUri() {
        return this.zzaDk;
    }

    public String getUnlockedImageUrl() {
        return this.zzaDl;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public long getXpValue() {
        return this.zzaDu;
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

    public void writeToParcel(Parcel dest, int flags) {
        AchievementEntityCreator.zza(this, dest, flags);
    }

    public int zzvK() {
        return this.zzaDo;
    }

    public String zzvL() {
        return this.zzaDp;
    }

    public int zzvM() {
        return this.zzaDr;
    }

    public String zzvN() {
        return this.zzaDs;
    }
}
