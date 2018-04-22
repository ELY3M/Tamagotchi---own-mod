package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznb;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaQueueItem {
    public static final double DEFAULT_PLAYBACK_DURATION = Double.POSITIVE_INFINITY;
    public static final int INVALID_ITEM_ID = 0;
    private JSONObject zzaaU;
    private MediaInfo zzabd;
    private int zzabe;
    private boolean zzabf;
    private double zzabg;
    private double zzabh;
    private double zzabi;
    private long[] zzabj;

    public static class Builder {
        private final MediaQueueItem zzabk;

        public Builder(MediaInfo media) throws IllegalArgumentException {
            this.zzabk = new MediaQueueItem(media);
        }

        public Builder(MediaQueueItem item) throws IllegalArgumentException {
            this.zzabk = new MediaQueueItem();
        }

        public Builder(JSONObject json) throws JSONException {
            this.zzabk = new MediaQueueItem(json);
        }

        public MediaQueueItem build() {
            this.zzabk.zznN();
            return this.zzabk;
        }

        public Builder clearItemId() {
            this.zzabk.zzba(0);
            return this;
        }

        public Builder setActiveTrackIds(long[] activeTrackIds) {
            this.zzabk.zza(activeTrackIds);
            return this;
        }

        public Builder setAutoplay(boolean autoplay) {
            this.zzabk.zzV(autoplay);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzabk.setCustomData(customData);
            return this;
        }

        public Builder setPlaybackDuration(double playbackDuration) {
            this.zzabk.zzd(playbackDuration);
            return this;
        }

        public Builder setPreloadTime(double preloadTime) throws IllegalArgumentException {
            this.zzabk.zze(preloadTime);
            return this;
        }

        public Builder setStartTime(double startTime) throws IllegalArgumentException {
            this.zzabk.zzc(startTime);
            return this;
        }
    }

    private MediaQueueItem(MediaInfo media) throws IllegalArgumentException {
        this.zzabe = 0;
        this.zzabf = true;
        this.zzabh = DEFAULT_PLAYBACK_DURATION;
        if (media == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzabd = media;
    }

    private MediaQueueItem(MediaQueueItem item) throws IllegalArgumentException {
        this.zzabe = 0;
        this.zzabf = true;
        this.zzabh = DEFAULT_PLAYBACK_DURATION;
        this.zzabd = item.getMedia();
        if (this.zzabd == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzabe = item.getItemId();
        this.zzabf = item.getAutoplay();
        this.zzabg = item.getStartTime();
        this.zzabh = item.getPlaybackDuration();
        this.zzabi = item.getPreloadTime();
        this.zzabj = item.getActiveTrackIds();
        this.zzaaU = item.getCustomData();
    }

    MediaQueueItem(JSONObject json) throws JSONException {
        this.zzabe = 0;
        this.zzabf = true;
        this.zzabh = DEFAULT_PLAYBACK_DURATION;
        zzh(json);
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) other;
        if ((this.zzaaU == null) != (mediaQueueItem.zzaaU == null)) {
            return false;
        }
        if (this.zzaaU != null && mediaQueueItem.zzaaU != null && !zznb.zze(this.zzaaU, mediaQueueItem.zzaaU)) {
            return false;
        }
        if (!(zzf.zza(this.zzabd, mediaQueueItem.zzabd) && this.zzabe == mediaQueueItem.zzabe && this.zzabf == mediaQueueItem.zzabf && this.zzabg == mediaQueueItem.zzabg && this.zzabh == mediaQueueItem.zzabh && this.zzabi == mediaQueueItem.zzabi && zzf.zza(this.zzabj, mediaQueueItem.zzabj))) {
            z = false;
        }
        return z;
    }

    public long[] getActiveTrackIds() {
        return this.zzabj;
    }

    public boolean getAutoplay() {
        return this.zzabf;
    }

    public JSONObject getCustomData() {
        return this.zzaaU;
    }

    public int getItemId() {
        return this.zzabe;
    }

    public MediaInfo getMedia() {
        return this.zzabd;
    }

    public double getPlaybackDuration() {
        return this.zzabh;
    }

    public double getPreloadTime() {
        return this.zzabi;
    }

    public double getStartTime() {
        return this.zzabg;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzabd, Integer.valueOf(this.zzabe), Boolean.valueOf(this.zzabf), Double.valueOf(this.zzabg), Double.valueOf(this.zzabh), Double.valueOf(this.zzabi), this.zzabj, String.valueOf(this.zzaaU));
    }

    void setCustomData(JSONObject customData) {
        this.zzaaU = customData;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("media", this.zzabd.toJson());
            if (this.zzabe != 0) {
                jSONObject.put("itemId", this.zzabe);
            }
            jSONObject.put("autoplay", this.zzabf);
            jSONObject.put("startTime", this.zzabg);
            if (this.zzabh != DEFAULT_PLAYBACK_DURATION) {
                jSONObject.put("playbackDuration", this.zzabh);
            }
            jSONObject.put("preloadTime", this.zzabi);
            if (this.zzabj != null) {
                JSONArray jSONArray = new JSONArray();
                for (long put : this.zzabj) {
                    jSONArray.put(put);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            if (this.zzaaU != null) {
                jSONObject.put("customData", this.zzaaU);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zzV(boolean z) {
        this.zzabf = z;
    }

    void zza(long[] jArr) {
        this.zzabj = jArr;
    }

    void zzba(int i) {
        this.zzabe = i;
    }

    void zzc(double d) throws IllegalArgumentException {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        this.zzabg = d;
    }

    void zzd(double d) throws IllegalArgumentException {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        this.zzabh = d;
    }

    void zze(double d) throws IllegalArgumentException {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
        }
        this.zzabi = d;
    }

    public boolean zzh(JSONObject jSONObject) throws JSONException {
        boolean z;
        boolean z2;
        double d;
        long[] jArr;
        if (jSONObject.has("media")) {
            this.zzabd = new MediaInfo(jSONObject.getJSONObject("media"));
            z = true;
        } else {
            z = false;
        }
        if (jSONObject.has("itemId")) {
            int i = jSONObject.getInt("itemId");
            if (this.zzabe != i) {
                this.zzabe = i;
                z = true;
            }
        }
        if (jSONObject.has("autoplay")) {
            z2 = jSONObject.getBoolean("autoplay");
            if (this.zzabf != z2) {
                this.zzabf = z2;
                z = true;
            }
        }
        if (jSONObject.has("startTime")) {
            d = jSONObject.getDouble("startTime");
            if (Math.abs(d - this.zzabg) > 1.0E-7d) {
                this.zzabg = d;
                z = true;
            }
        }
        if (jSONObject.has("playbackDuration")) {
            d = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d - this.zzabh) > 1.0E-7d) {
                this.zzabh = d;
                z = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            d = jSONObject.getDouble("preloadTime");
            if (Math.abs(d - this.zzabi) > 1.0E-7d) {
                this.zzabi = d;
                z = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            int i2;
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (i2 = 0; i2 < length; i2++) {
                jArr2[i2] = jSONArray.getLong(i2);
            }
            if (this.zzabj == null) {
                jArr = jArr2;
                z2 = true;
            } else if (this.zzabj.length != length) {
                jArr = jArr2;
                z2 = true;
            } else {
                for (i2 = 0; i2 < length; i2++) {
                    if (this.zzabj[i2] != jArr2[i2]) {
                        jArr = jArr2;
                        z2 = true;
                        break;
                    }
                }
                long[] jArr3 = jArr2;
                z2 = false;
                jArr = jArr3;
            }
        } else {
            z2 = false;
            jArr = null;
        }
        if (z2) {
            this.zzabj = jArr;
            z = true;
        }
        if (!jSONObject.has("customData")) {
            return z;
        }
        this.zzaaU = jSONObject.getJSONObject("customData");
        return true;
    }

    void zznN() throws IllegalArgumentException {
        if (this.zzabd == null) {
            throw new IllegalArgumentException("media cannot be null.");
        } else if (Double.isNaN(this.zzabg) || this.zzabg < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        } else if (Double.isNaN(this.zzabh)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        } else if (Double.isNaN(this.zzabi) || this.zzabi < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }
}
