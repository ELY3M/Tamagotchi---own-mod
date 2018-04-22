package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PutDataRequest implements SafeParcelable {
    public static final Creator<PutDataRequest> CREATOR = new zzh();
    public static final String WEAR_URI_SCHEME = "wear";
    private static final long zzbrf = TimeUnit.MINUTES.toMillis(30);
    private static final Random zzbrg = new SecureRandom();
    private final Uri mUri;
    final int mVersionCode;
    private byte[] zzaKm;
    private final Bundle zzbrh;
    private long zzbri;

    private PutDataRequest(int versionCode, Uri uri) {
        this(versionCode, uri, new Bundle(), null, zzbrf);
    }

    PutDataRequest(int versionCode, Uri uri, Bundle assets, byte[] data, long syncDeadline) {
        this.mVersionCode = versionCode;
        this.mUri = uri;
        this.zzbrh = assets;
        this.zzbrh.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.zzaKm = data;
        this.zzbri = syncDeadline;
    }

    public static PutDataRequest create(String path) {
        return zzr(zzgL(path));
    }

    public static PutDataRequest createFromDataItem(DataItem source) {
        PutDataRequest zzr = zzr(source.getUri());
        for (Entry entry : source.getAssets().entrySet()) {
            if (((DataItemAsset) entry.getValue()).getId() == null) {
                throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + ((String) entry.getKey()));
            }
            zzr.putAsset((String) entry.getKey(), Asset.createFromRef(((DataItemAsset) entry.getValue()).getId()));
        }
        zzr.setData(source.getData());
        return zzr;
    }

    public static PutDataRequest createWithAutoAppendedId(String pathPrefix) {
        StringBuilder stringBuilder = new StringBuilder(pathPrefix);
        if (!pathPrefix.endsWith("/")) {
            stringBuilder.append("/");
        }
        stringBuilder.append("PN").append(zzbrg.nextLong());
        return new PutDataRequest(2, zzgL(stringBuilder.toString()));
    }

    private static Uri zzgL(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        } else if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else if (!str.startsWith("//")) {
            return new Builder().scheme(WEAR_URI_SCHEME).path(str).build();
        } else {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
    }

    public static PutDataRequest zzr(Uri uri) {
        return new PutDataRequest(2, uri);
    }

    public int describeContents() {
        return 0;
    }

    public Asset getAsset(String key) {
        return (Asset) this.zzbrh.getParcelable(key);
    }

    public Map<String, Asset> getAssets() {
        Map hashMap = new HashMap();
        for (String str : this.zzbrh.keySet()) {
            hashMap.put(str, (Asset) this.zzbrh.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public byte[] getData() {
        return this.zzaKm;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean hasAsset(String key) {
        return this.zzbrh.containsKey(key);
    }

    public boolean isUrgent() {
        return this.zzbri == 0;
    }

    public PutDataRequest putAsset(String key, Asset value) {
        zzx.zzz(key);
        zzx.zzz(value);
        this.zzbrh.putParcelable(key, value);
        return this;
    }

    public PutDataRequest removeAsset(String key) {
        this.zzbrh.remove(key);
        return this;
    }

    public PutDataRequest setData(byte[] data) {
        this.zzaKm = data;
        return this;
    }

    public PutDataRequest setUrgent() {
        this.zzbri = 0;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable(DataMap.TAG, 3));
    }

    public String toString(boolean verbose) {
        StringBuilder stringBuilder = new StringBuilder("PutDataRequest[");
        stringBuilder.append("dataSz=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)));
        stringBuilder.append(", numAssets=" + this.zzbrh.size());
        stringBuilder.append(", uri=" + this.mUri);
        stringBuilder.append(", syncDeadline=" + this.zzbri);
        if (verbose) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.zzbrh.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.zzbrh.getParcelable(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public Bundle zzIv() {
        return this.zzbrh;
    }

    public long zzIw() {
        return this.zzbri;
    }
}
