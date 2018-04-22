package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class zzz extends zzc implements DataEvent {
    private final int zzaDQ;

    public zzz(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaDQ = i2;
    }

    public /* synthetic */ Object freeze() {
        return zzIK();
    }

    public DataItem getDataItem() {
        return new zzaf(this.zzahi, this.zzaje, this.zzaDQ);
    }

    public int getType() {
        return getInteger("event_type");
    }

    public String toString() {
        String str = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown";
        return "DataEventRef{ type=" + str + ", dataitem=" + getDataItem() + " }";
    }

    public DataEvent zzIK() {
        return new zzy(this);
    }
}
