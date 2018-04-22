package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class PlayerLevel implements SafeParcelable {
    public static final Creator<PlayerLevel> CREATOR = new PlayerLevelCreator();
    private final int mVersionCode;
    private final int zzaDa;
    private final long zzaDb;
    private final long zzaDc;

    PlayerLevel(int versionCode, int levelNumber, long minXp, long maxXp) {
        boolean z = true;
        zzx.zza(minXp >= 0, (Object) "Min XP must be positive!");
        if (maxXp <= minXp) {
            z = false;
        }
        zzx.zza(z, (Object) "Max XP must be more than min XP!");
        this.mVersionCode = versionCode;
        this.zzaDa = levelNumber;
        this.zzaDb = minXp;
        this.zzaDc = maxXp;
    }

    public PlayerLevel(int value, long minXp, long maxXp) {
        this(1, value, minXp, maxXp);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return zzw.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && zzw.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && zzw.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public int getLevelNumber() {
        return this.zzaDa;
    }

    public long getMaxXp() {
        return this.zzaDc;
    }

    public long getMinXp() {
        return this.zzaDb;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaDa), Long.valueOf(this.zzaDb), Long.valueOf(this.zzaDc));
    }

    public String toString() {
        return zzw.zzy(this).zzg("LevelNumber", Integer.valueOf(getLevelNumber())).zzg("MinXp", Long.valueOf(getMinXp())).zzg("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelCreator.zza(this, out, flags);
    }
}
