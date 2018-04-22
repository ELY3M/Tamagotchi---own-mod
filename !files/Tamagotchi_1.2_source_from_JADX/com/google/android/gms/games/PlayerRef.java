package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends zzc implements Player {
    private final PlayerLevelInfo zzaCS;
    private final PlayerColumnNames zzaDh;
    private final MostRecentGameInfoRef zzaDi;

    public PlayerRef(DataHolder holder, int dataRow) {
        this(holder, dataRow, null);
    }

    public PlayerRef(DataHolder holder, int dataRow, String prefix) {
        super(holder, dataRow);
        this.zzaDh = new PlayerColumnNames(prefix);
        this.zzaDi = new MostRecentGameInfoRef(holder, dataRow, this.zzaDh);
        if (zzvJ()) {
            PlayerLevel playerLevel;
            int integer = getInteger(this.zzaDh.zzaIC);
            int integer2 = getInteger(this.zzaDh.zzaIF);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(this.zzaDh.zzaID), getLong(this.zzaDh.zzaIE));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(this.zzaDh.zzaIE), getLong(this.zzaDh.zzaIG));
            } else {
                playerLevel = playerLevel2;
            }
            this.zzaCS = new PlayerLevelInfo(getLong(this.zzaDh.zzaIB), getLong(this.zzaDh.zzaIH), playerLevel2, playerLevel);
            return;
        }
        this.zzaCS = null;
    }

    private boolean zzvJ() {
        return (zzcB(this.zzaDh.zzaIB) || getLong(this.zzaDh.zzaIB) == -1) ? false : true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.zza(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public Uri getBannerImageLandscapeUri() {
        return zzcA(this.zzaDh.zzaIS);
    }

    public String getBannerImageLandscapeUrl() {
        return getString(this.zzaDh.zzaIT);
    }

    public Uri getBannerImagePortraitUri() {
        return zzcA(this.zzaDh.zzaIU);
    }

    public String getBannerImagePortraitUrl() {
        return getString(this.zzaDh.zzaIV);
    }

    public String getDisplayName() {
        return getString(this.zzaDh.zzaIt);
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zza(this.zzaDh.zzaIt, dataOut);
    }

    public Uri getHiResImageUri() {
        return zzcA(this.zzaDh.zzaIw);
    }

    public String getHiResImageUrl() {
        return getString(this.zzaDh.zzaIx);
    }

    public Uri getIconImageUri() {
        return zzcA(this.zzaDh.zzaIu);
    }

    public String getIconImageUrl() {
        return getString(this.zzaDh.zzaIv);
    }

    public long getLastPlayedWithTimestamp() {
        return (!zzcz(this.zzaDh.zzaIA) || zzcB(this.zzaDh.zzaIA)) ? -1 : getLong(this.zzaDh.zzaIA);
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzaCS;
    }

    public String getName() {
        return getString(this.zzaDh.name);
    }

    public String getPlayerId() {
        return getString(this.zzaDh.zzaIs);
    }

    public long getRetrievedTimestamp() {
        return getLong(this.zzaDh.zzaIy);
    }

    public String getTitle() {
        return getString(this.zzaDh.title);
    }

    public void getTitle(CharArrayBuffer dataOut) {
        zza(this.zzaDh.title, dataOut);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.zzb(this);
    }

    public String toString() {
        return PlayerEntity.zzc((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }

    public String zzvE() {
        return getString(this.zzaDh.zzaIR);
    }

    public boolean zzvF() {
        return getBoolean(this.zzaDh.zzaIQ);
    }

    public int zzvG() {
        return getInteger(this.zzaDh.zzaIz);
    }

    public boolean zzvH() {
        return getBoolean(this.zzaDh.zzaIJ);
    }

    public MostRecentGameInfo zzvI() {
        return zzcB(this.zzaDh.zzaIK) ? null : this.zzaDi;
    }
}
