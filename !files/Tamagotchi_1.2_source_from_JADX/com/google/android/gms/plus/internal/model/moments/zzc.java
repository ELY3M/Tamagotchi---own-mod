package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class zzc extends com.google.android.gms.common.data.zzc implements Moment {
    private MomentEntity zzbfK;

    public zzc(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private MomentEntity zzFo() {
        synchronized (this) {
            if (this.zzbfK == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.zzbfK = MomentEntity.CREATOR.zzgD(obtain);
                obtain.recycle();
            }
        }
        return this.zzbfK;
    }

    public /* synthetic */ Object freeze() {
        return zzFn();
    }

    public String getId() {
        return zzFo().getId();
    }

    public ItemScope getResult() {
        return zzFo().getResult();
    }

    public String getStartDate() {
        return zzFo().getStartDate();
    }

    public ItemScope getTarget() {
        return zzFo().getTarget();
    }

    public String getType() {
        return zzFo().getType();
    }

    public boolean hasId() {
        return zzFo().hasId();
    }

    public boolean hasResult() {
        return zzFo().hasResult();
    }

    public boolean hasStartDate() {
        return zzFo().hasStartDate();
    }

    public boolean hasTarget() {
        return zzFo().hasTarget();
    }

    public boolean hasType() {
        return zzFo().hasType();
    }

    public MomentEntity zzFn() {
        return zzFo();
    }
}
