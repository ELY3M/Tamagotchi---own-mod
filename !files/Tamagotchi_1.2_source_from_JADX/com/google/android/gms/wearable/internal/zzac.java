package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItemAsset;

public class zzac extends zzc implements DataItemAsset {
    public zzac(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public /* synthetic */ Object freeze() {
        return zzIL();
    }

    public String getDataItemKey() {
        return getString("asset_key");
    }

    public String getId() {
        return getString("asset_id");
    }

    public DataItemAsset zzIL() {
        return new zzaa(this);
    }
}
