package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
    AppContentActionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 1, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentActionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvS();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "action_data", this.zzaje);
    }

    public String getId() {
        return getString("action_id");
    }

    public String getType() {
        return getString("action_type");
    }

    public int hashCode() {
        return AppContentActionEntity.zza(this);
    }

    public String toString() {
        return AppContentActionEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentActionEntity) zzvS()).writeToParcel(dest, flags);
    }

    public AppContentAnnotation zzvO() {
        List zzb = AppContentUtils.zzb(this.zzahi, this.zzaDN, "action_annotation", this.zzaje);
        return zzb.size() == 1 ? (AppContentAnnotation) zzb.get(0) : null;
    }

    public List<AppContentCondition> zzvP() {
        return AppContentUtils.zzc(this.zzahi, this.zzaDN, "action_conditions", this.zzaje);
    }

    public String zzvQ() {
        return getString("action_content_description");
    }

    public String zzvR() {
        return getString("overflow_text");
    }

    public AppContentAction zzvS() {
        return new AppContentActionEntity(this);
    }
}
