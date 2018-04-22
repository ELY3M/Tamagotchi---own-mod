package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class zzy implements DataEvent {
    private int zzabB;
    private DataItem zzbsv;

    public zzy(DataEvent dataEvent) {
        this.zzabB = dataEvent.getType();
        this.zzbsv = (DataItem) dataEvent.getDataItem().freeze();
    }

    public /* synthetic */ Object freeze() {
        return zzIK();
    }

    public DataItem getDataItem() {
        return this.zzbsv;
    }

    public int getType() {
        return this.zzabB;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        String str = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown";
        return "DataEventEntity{ type=" + str + ", dataitem=" + getDataItem() + " }";
    }

    public DataEvent zzIK() {
        return this;
    }
}
