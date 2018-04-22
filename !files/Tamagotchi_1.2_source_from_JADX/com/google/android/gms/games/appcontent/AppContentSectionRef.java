package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int zzaDQ;

    AppContentSectionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow, int numChildren) {
        super(dataHolderCollection, 0, dataRow);
        this.zzaDQ = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentSectionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzwm();
    }

    public /* synthetic */ List getActions() {
        return zzwn();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "section_data", this.zzaje);
    }

    public String getId() {
        return getString("section_id");
    }

    public String getTitle() {
        return getString("section_title");
    }

    public String getType() {
        return getString("section_type");
    }

    public int hashCode() {
        return AppContentSectionEntity.zza(this);
    }

    public String toString() {
        return AppContentSectionEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentSectionEntity) zzwm()).writeToParcel(dest, flags);
    }

    public String zzvQ() {
        return getString("section_content_description");
    }

    public /* synthetic */ List zzwa() {
        return zzwo();
    }

    public String zzwc() {
        return getString("section_subtitle");
    }

    public /* synthetic */ List zzwk() {
        return zzwp();
    }

    public String zzwl() {
        return getString("section_card_type");
    }

    public AppContentSection zzwm() {
        return new AppContentSectionEntity(this);
    }

    public ArrayList<AppContentAction> zzwn() {
        return AppContentUtils.zza(this.zzahi, this.zzaDN, "section_actions", this.zzaje);
    }

    public ArrayList<AppContentAnnotation> zzwo() {
        return AppContentUtils.zzb(this.zzahi, this.zzaDN, "section_annotations", this.zzaje);
    }

    public ArrayList<AppContentCard> zzwp() {
        ArrayList<AppContentCard> arrayList = new ArrayList(this.zzaDQ);
        for (int i = 0; i < this.zzaDQ; i++) {
            arrayList.add(new AppContentCardRef(this.zzaDN, this.zzaje + i));
        }
        return arrayList;
    }
}
