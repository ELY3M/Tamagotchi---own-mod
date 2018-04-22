package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public class ReadRawResult implements Result, SafeParcelable {
    public static final Creator<ReadRawResult> CREATOR = new zzi();
    private final int mVersionCode;
    private final List<DataHolder> zzaBN;
    private final DataHolder zzahi;

    ReadRawResult(int versionCode, DataHolder dataHolder, List<DataHolder> dataHolders) {
        this.mVersionCode = versionCode;
        this.zzahi = dataHolder;
        if (dataHolders == null) {
            dataHolders = Collections.singletonList(dataHolder);
        }
        this.zzaBN = dataHolders;
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return new Status(this.zzahi.getStatusCode());
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    DataHolder zzsX() {
        return this.zzahi;
    }

    public List<DataHolder> zzvo() {
        return this.zzaBN;
    }
}
