package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DataItemParcelable implements SafeParcelable, DataItem {
    public static final Creator<DataItemParcelable> CREATOR = new zzae();
    private final Uri mUri;
    final int mVersionCode;
    private byte[] zzaKm;
    private final Map<String, DataItemAsset> zzbsy;

    DataItemParcelable(int versionCode, Uri uri, Bundle assetBundle, byte[] data) {
        this.mVersionCode = versionCode;
        this.mUri = uri;
        Map hashMap = new HashMap();
        assetBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : assetBundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) assetBundle.getParcelable(str));
        }
        this.zzbsy = hashMap;
        this.zzaKm = data;
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return zzIN();
    }

    public Map<String, DataItemAsset> getAssets() {
        return this.zzbsy;
    }

    public byte[] getData() {
        return this.zzaKm;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    public /* synthetic */ DataItem setData(byte[] bArr) {
        return zzz(bArr);
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder stringBuilder = new StringBuilder("DataItemParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(",dataSz=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)));
        stringBuilder.append(", numAssets=" + this.zzbsy.size());
        stringBuilder.append(", uri=" + this.mUri);
        if (verbose) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.zzbsy.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.zzbsy.get(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzae.zza(this, dest, flags);
    }

    public DataItemParcelable zzIN() {
        return this;
    }

    public Bundle zzIv() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Entry entry : this.zzbsy.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), new DataItemAssetParcelable((DataItemAsset) entry.getValue()));
        }
        return bundle;
    }

    public DataItemParcelable zzz(byte[] bArr) {
        this.zzaKm = bArr;
        return this;
    }
}
