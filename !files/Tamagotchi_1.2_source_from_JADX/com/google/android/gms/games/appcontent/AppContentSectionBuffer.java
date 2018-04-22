package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import java.util.ArrayList;

public final class AppContentSectionBuffer extends zzf<AppContentSection> {
    private final ArrayList<DataHolder> zzaDN;

    public void release() {
        super.release();
        int size = this.zzaDN.size();
        for (int i = 1; i < size; i++) {
            DataHolder dataHolder = (DataHolder) this.zzaDN.get(i);
            if (dataHolder != null) {
                dataHolder.close();
            }
        }
    }

    protected /* synthetic */ Object zzk(int i, int i2) {
        return zzo(i, i2);
    }

    protected AppContentSection zzo(int i, int i2) {
        return new AppContentSectionRef(this.zzaDN, i, i2);
    }

    protected String zzqg() {
        return "section_id";
    }

    protected String zzqi() {
        return "card_id";
    }
}
