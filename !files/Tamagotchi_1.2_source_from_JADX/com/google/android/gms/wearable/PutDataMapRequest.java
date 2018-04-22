package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.zzsi;
import com.google.android.gms.internal.zzsi.zza;
import com.google.android.gms.internal.zzsu;

public class PutDataMapRequest {
    private final DataMap zzbrd = new DataMap();
    private final PutDataRequest zzbre;

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        this.zzbre = putDataRequest;
        if (dataMap != null) {
            this.zzbrd.putAll(dataMap);
        }
    }

    public static PutDataMapRequest create(String path) {
        return new PutDataMapRequest(PutDataRequest.create(path), null);
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem source) {
        return new PutDataMapRequest(PutDataRequest.zzr(source.getUri()), source.getDataMap());
    }

    public static PutDataMapRequest createWithAutoAppendedId(String pathPrefix) {
        return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(pathPrefix), null);
    }

    public PutDataRequest asPutDataRequest() {
        zza zza = zzsi.zza(this.zzbrd);
        this.zzbre.setData(zzsu.toByteArray(zza.zzbty));
        int size = zza.zzbtz.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) zza.zzbtz.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable(DataMap.TAG, 3)) {
                    Log.d(DataMap.TAG, "asPutDataRequest: adding asset: " + num + " " + asset);
                }
                this.zzbre.putAsset(num, asset);
                i++;
            }
        }
        return this.zzbre;
    }

    public DataMap getDataMap() {
        return this.zzbrd;
    }

    public Uri getUri() {
        return this.zzbre.getUri();
    }

    public boolean isUrgent() {
        return this.zzbre.isUrgent();
    }

    public PutDataMapRequest setUrgent() {
        this.zzbre.setUrgent();
        return this;
    }
}
