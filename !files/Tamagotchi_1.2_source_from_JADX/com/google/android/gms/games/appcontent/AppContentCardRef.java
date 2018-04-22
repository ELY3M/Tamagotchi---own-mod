package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
    AppContentCardRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 0, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentCardEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzwe();
    }

    public List<AppContentAction> getActions() {
        return AppContentUtils.zza(this.zzahi, this.zzaDN, "card_actions", this.zzaje);
    }

    public String getDescription() {
        return getString("card_description");
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "card_data", this.zzaje);
    }

    public String getId() {
        return getString("card_id");
    }

    public String getTitle() {
        return getString("card_title");
    }

    public String getType() {
        return getString("card_type");
    }

    public int hashCode() {
        return AppContentCardEntity.zza(this);
    }

    public String toString() {
        return AppContentCardEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentCardEntity) zzwe()).writeToParcel(dest, flags);
    }

    public List<AppContentCondition> zzvP() {
        return AppContentUtils.zzc(this.zzahi, this.zzaDN, "card_conditions", this.zzaje);
    }

    public String zzvQ() {
        return getString("card_content_description");
    }

    public List<AppContentAnnotation> zzwa() {
        return AppContentUtils.zzb(this.zzahi, this.zzaDN, "card_annotations", this.zzaje);
    }

    public int zzwb() {
        return getInteger("card_current_steps");
    }

    public String zzwc() {
        return getString("card_subtitle");
    }

    public int zzwd() {
        return getInteger("card_total_steps");
    }

    public AppContentCard zzwe() {
        return new AppContentCardEntity(this);
    }
}
