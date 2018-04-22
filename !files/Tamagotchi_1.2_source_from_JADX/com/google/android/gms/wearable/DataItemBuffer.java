package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzaf;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public class DataItemBuffer extends zzf<DataItem> implements Result {
    private final Status zzUX;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzUX = new Status(dataHolder.getStatusCode());
    }

    public Status getStatus() {
        return this.zzUX;
    }

    protected /* synthetic */ Object zzk(int i, int i2) {
        return zzx(i, i2);
    }

    protected String zzqg() {
        return ISVGConstants.TAG_PATH;
    }

    protected DataItem zzx(int i, int i2) {
        return new zzaf(this.zzahi, i, i2);
    }
}
