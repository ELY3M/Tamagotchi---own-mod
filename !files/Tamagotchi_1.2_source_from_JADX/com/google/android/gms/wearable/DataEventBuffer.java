package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzz;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public class DataEventBuffer extends zzf<DataEvent> implements Result {
    private final Status zzUX;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzUX = new Status(dataHolder.getStatusCode());
    }

    public Status getStatus() {
        return this.zzUX;
    }

    protected /* synthetic */ Object zzk(int i, int i2) {
        return zzw(i, i2);
    }

    protected String zzqg() {
        return ISVGConstants.TAG_PATH;
    }

    protected DataEvent zzw(int i, int i2) {
        return new zzz(this.zzahi, i, i2);
    }
}
