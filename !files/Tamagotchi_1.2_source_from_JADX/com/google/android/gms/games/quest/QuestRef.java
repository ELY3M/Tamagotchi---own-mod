package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;
import java.util.List;

public final class QuestRef extends zzc implements Quest {
    private final int zzaDQ;
    private final Game zzaJc;

    QuestRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.zzaJc = new GameRef(holder, dataRow);
        this.zzaDQ = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return QuestEntity.zza(this, obj);
    }

    public Quest freeze() {
        return new QuestEntity(this);
    }

    public long getAcceptedTimestamp() {
        return getLong("accepted_ts");
    }

    public Uri getBannerImageUri() {
        return zzcA("quest_banner_image_uri");
    }

    public String getBannerImageUrl() {
        return getString("quest_banner_image_url");
    }

    public Milestone getCurrentMilestone() {
        return (Milestone) zzxR().get(0);
    }

    public String getDescription() {
        return getString("quest_description");
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zza("quest_description", dataOut);
    }

    public long getEndTimestamp() {
        return getLong("quest_end_ts");
    }

    public Game getGame() {
        return this.zzaJc;
    }

    public Uri getIconImageUri() {
        return zzcA("quest_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("quest_icon_image_url");
    }

    public long getLastUpdatedTimestamp() {
        return getLong("quest_last_updated_ts");
    }

    public String getName() {
        return getString("quest_name");
    }

    public void getName(CharArrayBuffer dataOut) {
        zza("quest_name", dataOut);
    }

    public String getQuestId() {
        return getString("external_quest_id");
    }

    public long getStartTimestamp() {
        return getLong("quest_start_ts");
    }

    public int getState() {
        return getInteger("quest_state");
    }

    public int getType() {
        return getInteger("quest_type");
    }

    public int hashCode() {
        return QuestEntity.zza(this);
    }

    public boolean isEndingSoon() {
        return zzxS() <= System.currentTimeMillis() + 1800000;
    }

    public String toString() {
        return QuestEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((QuestEntity) freeze()).writeToParcel(dest, flags);
    }

    public List<Milestone> zzxR() {
        List arrayList = new ArrayList(this.zzaDQ);
        for (int i = 0; i < this.zzaDQ; i++) {
            arrayList.add(new MilestoneRef(this.zzahi, this.zzaje + i));
        }
        return arrayList;
    }

    public long zzxS() {
        return getLong("notification_ts");
    }
}
