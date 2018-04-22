package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.DataItemAsset;

@KeepName
public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR = new zzab();
    final int mVersionCode;
    private final String zzvs;
    private final String zzyv;

    DataItemAssetParcelable(int versionCode, String id, String key) {
        this.mVersionCode = versionCode;
        this.zzyv = id;
        this.zzvs = key;
    }

    public DataItemAssetParcelable(DataItemAsset value) {
        this.mVersionCode = 1;
        this.zzyv = (String) zzx.zzz(value.getId());
        this.zzvs = (String) zzx.zzz(value.getDataItemKey());
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return zzIL();
    }

    public String getDataItemKey() {
        return this.zzvs;
    }

    public String getId() {
        return this.zzyv;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzyv == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.zzyv);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.zzvs);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzab.zza(this, dest, flags);
    }

    public DataItemAsset zzIL() {
        return this;
    }
}
