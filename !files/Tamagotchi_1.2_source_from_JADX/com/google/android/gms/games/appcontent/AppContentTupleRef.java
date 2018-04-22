package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class AppContentTupleRef extends zzc implements AppContentTuple {
    AppContentTupleRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentTupleEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzwq();
    }

    public String getName() {
        return getString("tuple_name");
    }

    public String getValue() {
        return getString("tuple_value");
    }

    public int hashCode() {
        return AppContentTupleEntity.zza(this);
    }

    public String toString() {
        return AppContentTupleEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentTupleEntity) zzwq()).writeToParcel(dest, flags);
    }

    public AppContentTuple zzwq() {
        return new AppContentTupleEntity(this);
    }
}
