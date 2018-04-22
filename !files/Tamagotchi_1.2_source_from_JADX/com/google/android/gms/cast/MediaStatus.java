package com.google.android.gms.cast;

import android.util.SparseArray;
import com.google.android.gms.cast.internal.zzf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.anddev.andengine.level.util.constants.LevelConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int REPEAT_MODE_REPEAT_ALL = 1;
    public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
    public static final int REPEAT_MODE_REPEAT_OFF = 0;
    public static final int REPEAT_MODE_REPEAT_SINGLE = 2;
    private JSONObject zzaaU;
    private MediaInfo zzaaV;
    private long[] zzabj;
    private int zzabl = 0;
    private long zzabm;
    private double zzabn;
    private int zzabo;
    private int zzabp;
    private long zzabq;
    private long zzabr;
    private double zzabs;
    private boolean zzabt;
    private int zzabu = 0;
    private int zzabv = 0;
    private final zza zzabw = new zza(this);

    private class zza {
        final /* synthetic */ MediaStatus zzabA;
        private int zzabx = 0;
        private List<MediaQueueItem> zzaby = new ArrayList();
        private SparseArray<Integer> zzabz = new SparseArray();

        zza(MediaStatus mediaStatus) {
            this.zzabA = mediaStatus;
        }

        private void clear() {
            this.zzabx = 0;
            this.zzaby.clear();
            this.zzabz.clear();
        }

        private void zza(MediaQueueItem[] mediaQueueItemArr) {
            this.zzaby.clear();
            this.zzabz.clear();
            for (int i = 0; i < mediaQueueItemArr.length; i++) {
                MediaQueueItem mediaQueueItem = mediaQueueItemArr[i];
                this.zzaby.add(mediaQueueItem);
                this.zzabz.put(mediaQueueItem.getItemId(), Integer.valueOf(i));
            }
        }

        private Integer zzbd(int i) {
            return (Integer) this.zzabz.get(i);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean zzh(org.json.JSONObject r11) throws org.json.JSONException {
            /*
            r10 = this;
            r3 = 3;
            r0 = 2;
            r1 = 0;
            r2 = 1;
            r4 = "repeatMode";
            r4 = r11.has(r4);
            if (r4 == 0) goto L_0x00f7;
        L_0x000c:
            r4 = r10.zzabx;
            r5 = "repeatMode";
            r6 = r11.getString(r5);
            r5 = -1;
            r7 = r6.hashCode();
            switch(r7) {
                case -1118317585: goto L_0x0073;
                case -962896020: goto L_0x0069;
                case 1645938909: goto L_0x005f;
                case 1645952171: goto L_0x0055;
                default: goto L_0x001c;
            };
        L_0x001c:
            switch(r5) {
                case 0: goto L_0x007d;
                case 1: goto L_0x007f;
                case 2: goto L_0x0020;
                case 3: goto L_0x0081;
                default: goto L_0x001f;
            };
        L_0x001f:
            r0 = r4;
        L_0x0020:
            r3 = r10.zzabx;
            if (r3 == r0) goto L_0x00f7;
        L_0x0024:
            r10.zzabx = r0;
            r0 = r2;
        L_0x0027:
            r3 = "items";
            r3 = r11.has(r3);
            if (r3 == 0) goto L_0x00f5;
        L_0x002f:
            r3 = "items";
            r4 = r11.getJSONArray(r3);
            r5 = r4.length();
            r6 = new android.util.SparseArray;
            r6.<init>();
            r3 = r1;
        L_0x003f:
            if (r3 >= r5) goto L_0x0083;
        L_0x0041:
            r7 = r4.getJSONObject(r3);
            r8 = "itemId";
            r7 = r7.getInt(r8);
            r7 = java.lang.Integer.valueOf(r7);
            r6.put(r3, r7);
            r3 = r3 + 1;
            goto L_0x003f;
        L_0x0055:
            r7 = "REPEAT_OFF";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x005d:
            r5 = r1;
            goto L_0x001c;
        L_0x005f:
            r7 = "REPEAT_ALL";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x0067:
            r5 = r2;
            goto L_0x001c;
        L_0x0069:
            r7 = "REPEAT_SINGLE";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x0071:
            r5 = r0;
            goto L_0x001c;
        L_0x0073:
            r7 = "REPEAT_ALL_AND_SHUFFLE";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x007b:
            r5 = r3;
            goto L_0x001c;
        L_0x007d:
            r0 = r1;
            goto L_0x0020;
        L_0x007f:
            r0 = r2;
            goto L_0x0020;
        L_0x0081:
            r0 = r3;
            goto L_0x0020;
        L_0x0083:
            r7 = new com.google.android.gms.cast.MediaQueueItem[r5];
            r3 = r1;
            r1 = r0;
        L_0x0087:
            if (r3 >= r5) goto L_0x00e5;
        L_0x0089:
            r0 = r6.get(r3);
            r0 = (java.lang.Integer) r0;
            r8 = r4.getJSONObject(r3);
            r9 = r0.intValue();
            r9 = r10.zzbb(r9);
            if (r9 == 0) goto L_0x00b8;
        L_0x009d:
            r8 = r9.zzh(r8);
            r1 = r1 | r8;
            r7[r3] = r9;
            r0 = r0.intValue();
            r0 = r10.zzbd(r0);
            r0 = r0.intValue();
            if (r3 == r0) goto L_0x00f3;
        L_0x00b2:
            r0 = r2;
        L_0x00b3:
            r1 = r3 + 1;
            r3 = r1;
            r1 = r0;
            goto L_0x0087;
        L_0x00b8:
            r0 = r0.intValue();
            r1 = r10.zzabA;
            r1 = r1.zzabl;
            if (r0 != r1) goto L_0x00dc;
        L_0x00c4:
            r0 = new com.google.android.gms.cast.MediaQueueItem$Builder;
            r1 = r10.zzabA;
            r1 = r1.zzaaV;
            r0.<init>(r1);
            r0 = r0.build();
            r7[r3] = r0;
            r0 = r7[r3];
            r0.zzh(r8);
            r0 = r2;
            goto L_0x00b3;
        L_0x00dc:
            r0 = new com.google.android.gms.cast.MediaQueueItem;
            r0.<init>(r8);
            r7[r3] = r0;
            r0 = r2;
            goto L_0x00b3;
        L_0x00e5:
            r0 = r10.zzaby;
            r0 = r0.size();
            if (r0 == r5) goto L_0x00f1;
        L_0x00ed:
            r10.zza(r7);
        L_0x00f0:
            return r2;
        L_0x00f1:
            r2 = r1;
            goto L_0x00ed;
        L_0x00f3:
            r0 = r1;
            goto L_0x00b3;
        L_0x00f5:
            r2 = r0;
            goto L_0x00f0;
        L_0x00f7:
            r0 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.zza.zzh(org.json.JSONObject):boolean");
        }

        public int getItemCount() {
            return this.zzaby.size();
        }

        public int getRepeatMode() {
            return this.zzabx;
        }

        public MediaQueueItem zzbb(int i) {
            Integer num = (Integer) this.zzabz.get(i);
            return num == null ? null : (MediaQueueItem) this.zzaby.get(num.intValue());
        }

        public MediaQueueItem zzbc(int i) {
            return (i < 0 || i >= this.zzaby.size()) ? null : (MediaQueueItem) this.zzaby.get(i);
        }

        public List<MediaQueueItem> zznP() {
            return Collections.unmodifiableList(this.zzaby);
        }
    }

    public MediaStatus(JSONObject json) throws JSONException {
        zza(json, 0);
    }

    private boolean zzi(int i, int i2) {
        return i == 1 && i2 == 0;
    }

    public long[] getActiveTrackIds() {
        return this.zzabj;
    }

    public int getCurrentItemId() {
        return this.zzabl;
    }

    public JSONObject getCustomData() {
        return this.zzaaU;
    }

    public int getIdleReason() {
        return this.zzabp;
    }

    public int getLoadingItemId() {
        return this.zzabu;
    }

    public MediaInfo getMediaInfo() {
        return this.zzaaV;
    }

    public double getPlaybackRate() {
        return this.zzabn;
    }

    public int getPlayerState() {
        return this.zzabo;
    }

    public int getPreloadedItemId() {
        return this.zzabv;
    }

    public MediaQueueItem getQueueItem(int index) {
        return this.zzabw.zzbc(index);
    }

    public MediaQueueItem getQueueItemById(int itemId) {
        return this.zzabw.zzbb(itemId);
    }

    public int getQueueItemCount() {
        return this.zzabw.getItemCount();
    }

    public List<MediaQueueItem> getQueueItems() {
        return this.zzabw.zznP();
    }

    public int getQueueRepeatMode() {
        return this.zzabw.getRepeatMode();
    }

    public long getStreamPosition() {
        return this.zzabq;
    }

    public double getStreamVolume() {
        return this.zzabs;
    }

    public boolean isMediaCommandSupported(long mediaCommand) {
        return (this.zzabr & mediaCommand) != 0;
    }

    public boolean isMute() {
        return this.zzabt;
    }

    public int zza(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        int i3;
        double d;
        long zzg;
        long[] jArr;
        int i4 = 2;
        int i5 = 1;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.zzabm) {
            this.zzabm = j;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            i3 = string.equals("IDLE") ? 1 : string.equals("PLAYING") ? 2 : string.equals("PAUSED") ? 3 : string.equals("BUFFERING") ? 4 : 0;
            if (i3 != this.zzabo) {
                this.zzabo = i3;
                i2 |= 2;
            }
            if (i3 == 1 && jSONObject.has("idleReason")) {
                string = jSONObject.getString("idleReason");
                if (!string.equals("CANCELLED")) {
                    i4 = string.equals("INTERRUPTED") ? 3 : string.equals("FINISHED") ? 1 : string.equals("ERROR") ? 4 : 0;
                }
                if (i4 != this.zzabp) {
                    this.zzabp = i4;
                    i2 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            d = jSONObject.getDouble("playbackRate");
            if (this.zzabn != d) {
                this.zzabn = d;
                i2 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            zzg = zzf.zzg(jSONObject.getDouble("currentTime"));
            if (zzg != this.zzabq) {
                this.zzabq = zzg;
                i2 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            zzg = jSONObject.getLong("supportedMediaCommands");
            if (zzg != this.zzabr) {
                this.zzabr = zzg;
                i2 |= 2;
            }
        }
        if (jSONObject.has(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME) && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME);
            d = jSONObject2.getDouble(LevelConstants.TAG_LEVEL);
            if (d != this.zzabs) {
                this.zzabs = d;
                i2 |= 2;
            }
            boolean z = jSONObject2.getBoolean("muted");
            if (z != this.zzabt) {
                this.zzabt = z;
                i2 |= 2;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (i4 = 0; i4 < length; i4++) {
                jArr2[i4] = jSONArray.getLong(i4);
            }
            if (this.zzabj != null && this.zzabj.length == length) {
                for (i4 = 0; i4 < length; i4++) {
                    if (this.zzabj[i4] != jArr2[i4]) {
                        break;
                    }
                }
                i5 = 0;
            }
            if (i5 != 0) {
                this.zzabj = jArr2;
            }
            long[] jArr3 = jArr2;
            i3 = i5;
            jArr = jArr3;
        } else if (this.zzabj != null) {
            i3 = 1;
            jArr = null;
        } else {
            jArr = null;
            i3 = 0;
        }
        if (i3 != 0) {
            this.zzabj = jArr;
            i2 |= 2;
        }
        if (jSONObject.has("customData")) {
            this.zzaaU = jSONObject.getJSONObject("customData");
            i2 |= 2;
        }
        if (jSONObject.has("media")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("media");
            this.zzaaV = new MediaInfo(jSONObject3);
            i2 |= 2;
            if (jSONObject3.has("metadata")) {
                i2 |= 4;
            }
        }
        if (jSONObject.has("currentItemId")) {
            i5 = jSONObject.getInt("currentItemId");
            if (this.zzabl != i5) {
                this.zzabl = i5;
                i2 |= 2;
            }
        }
        i5 = jSONObject.optInt("preloadedItemId", 0);
        if (this.zzabv != i5) {
            this.zzabv = i5;
            i2 |= 16;
        }
        i5 = jSONObject.optInt("loadingItemId", 0);
        if (this.zzabu != i5) {
            this.zzabu = i5;
            i2 |= 2;
        }
        if (!zzi(this.zzabo, this.zzabu)) {
            return this.zzabw.zzh(jSONObject) ? i2 | 8 : i2;
        } else {
            this.zzabl = 0;
            this.zzabu = 0;
            this.zzabv = 0;
            if (this.zzabw.getItemCount() <= 0) {
                return i2;
            }
            this.zzabw.clear();
            return i2 | 8;
        }
    }

    public long zznO() {
        return this.zzabm;
    }
}
