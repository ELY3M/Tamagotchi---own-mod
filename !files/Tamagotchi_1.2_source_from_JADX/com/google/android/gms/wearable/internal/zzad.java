package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzad implements DataItem {
    private Uri mUri;
    private byte[] zzaKm;
    private Map<String, DataItemAsset> zzbsy;

    public zzad(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.zzaKm = dataItem.getData();
        Map hashMap = new HashMap();
        for (Entry entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((DataItemAsset) entry.getValue()).freeze());
            }
        }
        this.zzbsy = Collections.unmodifiableMap(hashMap);
    }

    public /* synthetic */ Object freeze() {
        return zzIM();
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

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity{ ");
        stringBuilder.append("uri=" + this.mUri);
        stringBuilder.append(", dataSz=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)));
        stringBuilder.append(", numAssets=" + this.zzbsy.size());
        if (verbose && !this.zzbsy.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            for (Entry entry : this.zzbsy.entrySet()) {
                stringBuilder.append(str + ((String) entry.getKey()) + ": " + ((DataItemAsset) entry.getValue()).getId());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public DataItem zzIM() {
        return this;
    }
}
