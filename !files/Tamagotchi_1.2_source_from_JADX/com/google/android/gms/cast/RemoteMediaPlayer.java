package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONObject;

@SuppressLint({"MissingRemoteException"})
public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final zzm zzabE = new zzm(this, null) {
        final /* synthetic */ RemoteMediaPlayer zzabK;

        protected void onMetadataUpdated() {
            this.zzabK.onMetadataUpdated();
        }

        protected void onPreloadStatusUpdated() {
            this.zzabK.onPreloadStatusUpdated();
        }

        protected void onQueueStatusUpdated() {
            this.zzabK.onQueueStatusUpdated();
        }

        protected void onStatusUpdated() {
            this.zzabK.onStatusUpdated();
        }
    };
    private final zza zzabF = new zza(this);
    private OnPreloadStatusUpdatedListener zzabG;
    private OnQueueStatusUpdatedListener zzabH;
    private OnMetadataUpdatedListener zzabI;
    private OnStatusUpdatedListener zzabJ;
    private final Object zzpV = new Object();

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    private class zza implements zzn {
        final /* synthetic */ RemoteMediaPlayer zzabK;
        private GoogleApiClient zzaci;
        private long zzacj = 0;

        private final class zza implements ResultCallback<Status> {
            private final long zzack;
            final /* synthetic */ zza zzacl;

            zza(zza com_google_android_gms_cast_RemoteMediaPlayer_zza, long j) {
                this.zzacl = com_google_android_gms_cast_RemoteMediaPlayer_zza;
                this.zzack = j;
            }

            public /* synthetic */ void onResult(Result result) {
                zzp((Status) result);
            }

            public void zzp(Status status) {
                if (!status.isSuccess()) {
                    this.zzacl.zzabK.zzabE.zzb(this.zzack, status.getStatusCode());
                }
            }
        }

        public zza(RemoteMediaPlayer remoteMediaPlayer) {
            this.zzabK = remoteMediaPlayer;
        }

        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzaci == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzaci, str, str2).setResultCallback(new zza(this, j));
        }

        public void zzc(GoogleApiClient googleApiClient) {
            this.zzaci = googleApiClient;
        }

        public long zznQ() {
            long j = this.zzacj + 1;
            this.zzacj = j;
            return j;
        }
    }

    private static final class zzc implements MediaChannelResult {
        private final Status zzUX;
        private final JSONObject zzaaU;

        zzc(Status status, JSONObject jSONObject) {
            this.zzUX = status;
            this.zzaaU = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.zzaaU;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static abstract class zzb extends com.google.android.gms.cast.internal.zzb<MediaChannelResult> {
        zzo zzacm = new C06961(this);

        class C06961 implements zzo {
            final /* synthetic */ zzb zzacn;

            C06961(zzb com_google_android_gms_cast_RemoteMediaPlayer_zzb) {
                this.zzacn = com_google_android_gms_cast_RemoteMediaPlayer_zzb;
            }

            public void zza(long j, int i, Object obj) {
                this.zzacn.zza(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }

            public void zzy(long j) {
                this.zzacn.zza(this.zzacn.zzq(new Status(2103)));
            }
        }

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzq(status);
        }

        public MediaChannelResult zzq(final Status status) {
            return new MediaChannelResult(this) {
                final /* synthetic */ zzb zzacn;

                public JSONObject getCustomData() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public RemoteMediaPlayer() {
        this.zzabE.zza(this.zzabF);
    }

    private void onMetadataUpdated() {
        if (this.zzabI != null) {
            this.zzabI.onMetadataUpdated();
        }
    }

    private void onPreloadStatusUpdated() {
        if (this.zzabG != null) {
            this.zzabG.onPreloadStatusUpdated();
        }
    }

    private void onQueueStatusUpdated() {
        if (this.zzabH != null) {
            this.zzabH.onQueueStatusUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.zzabJ != null) {
            this.zzabJ.onStatusUpdated();
        }
    }

    private int zzbf(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = 0; i2 < mediaStatus.getQueueItemCount(); i2++) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzpV) {
            approximateStreamPosition = this.zzabE.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzpV) {
            mediaInfo = this.zzabE.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzpV) {
            mediaStatus = this.zzabE.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzabE.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzpV) {
            streamDuration = this.zzabE.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, customData);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, long[] activeTrackIds, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z = autoplay;
        final long j = playPosition;
        final long[] jArr = activeTrackIds;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, mediaInfo2, z, j, jArr, jSONObject);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.zzabE.zzcf(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(apiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, customData);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(apiClient);
                    try {
                        this.zzabK.zzabE.zzc(this.zzacm, customData);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueAppendItem(GoogleApiClient apiClient, MediaQueueItem item, JSONObject customData) throws IllegalArgumentException {
        return queueInsertItems(apiClient, new MediaQueueItem[]{item}, 0, customData);
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient apiClient, MediaQueueItem item, int insertBeforeItemId, long playPosition, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem mediaQueueItem = item;
        final int i = insertBeforeItemId;
        final long j = playPosition;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, new MediaQueueItem[]{mediaQueueItem}, i, 0, 0, j, jSONObject);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient apiClient, MediaQueueItem item, int insertBeforeItemId, JSONObject customData) {
        return queueInsertAndPlayItem(apiClient, item, insertBeforeItemId, -1, customData);
    }

    public PendingResult<MediaChannelResult> queueInsertItems(GoogleApiClient apiClient, MediaQueueItem[] itemsToInsert, int insertBeforeItemId, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem[] mediaQueueItemArr = itemsToInsert;
        final int i = insertBeforeItemId;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, mediaQueueItemArr, i, 0, -1, -1, jSONObject);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient apiClient, int itemId, long playPosition, JSONObject customData) {
        final int i = itemId;
        final GoogleApiClient googleApiClient = apiClient;
        final long j = playPosition;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    if (this.zzabK.zzbf(i) == -1) {
                        zza(zzq(new Status(0)));
                        return;
                    }
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, i, j, null, 0, null, jSONObject);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                    } finally {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        return queueJumpToItem(apiClient, itemId, -1, customData);
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient apiClient, MediaQueueItem[] items, int startIndex, int repeatMode, long playPosition, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem[] mediaQueueItemArr = items;
        final int i = startIndex;
        final int i2 = repeatMode;
        final long j = playPosition;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, mediaQueueItemArr, i, i2, j, jSONObject);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient apiClient, MediaQueueItem[] items, int startIndex, int repeatMode, JSONObject customData) throws IllegalArgumentException {
        return queueLoad(apiClient, items, startIndex, repeatMode, -1, customData);
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(GoogleApiClient apiClient, int itemId, int newIndex, JSONObject customData) {
        final int i = itemId;
        final int i2 = newIndex;
        final GoogleApiClient googleApiClient = apiClient;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                int i = 0;
                synchronized (this.zzabK.zzpV) {
                    int zza = this.zzabK.zzbf(i);
                    if (zza == -1) {
                        zza(zzq(new Status(0)));
                    } else if (i2 < 0) {
                        zza(zzq(new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", new Object[]{Integer.valueOf(i2)}))));
                    } else if (zza == i2) {
                        zza(zzq(new Status(0)));
                    } else {
                        MediaQueueItem queueItem = this.zzabK.getMediaStatus().getQueueItem(i2 > zza ? i2 + 1 : i2);
                        if (queueItem != null) {
                            i = queueItem.getItemId();
                        }
                        this.zzabK.zzabF.zzc(googleApiClient);
                        try {
                            this.zzabK.zzabE.zza(this.zzacm, new int[]{i}, i, jSONObject);
                        } catch (IOException e) {
                            zza(zzq(new Status(2100)));
                        } finally {
                            this.zzabK.zzabF.zzc(null);
                        }
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueNext(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(apiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, 0, -1, null, 1, null, customData);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queuePrev(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(apiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, 0, -1, null, -1, null, customData);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        final int i = itemId;
        final GoogleApiClient googleApiClient = apiClient;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    if (this.zzabK.zzbf(i) == -1) {
                        zza(zzq(new Status(0)));
                        return;
                    }
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, new int[]{i}, jSONObject);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                    } finally {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(GoogleApiClient apiClient, int[] itemIdsToRemove, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final int[] iArr = itemIdsToRemove;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, iArr, jSONObject);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueReorderItems(GoogleApiClient apiClient, int[] itemIdsToReorder, int insertBeforeItemId, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final int[] iArr = itemIdsToReorder;
        final int i = insertBeforeItemId;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, iArr, i, jSONObject);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(GoogleApiClient apiClient, int repeatMode, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final int i = repeatMode;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, 0, -1, null, 0, Integer.valueOf(i), jSONObject);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(GoogleApiClient apiClient, MediaQueueItem[] itemsToUpdate, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem[] mediaQueueItemArr = itemsToUpdate;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, 0, -1, mediaQueueItemArr, 0, null, jSONObject);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(apiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final long j = position;
        final int i = resumeState;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, j, i, jSONObject);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient apiClient, final long[] trackIds) {
        if (trackIds != null) {
            return apiClient.zzb(new zzb(this, apiClient) {
                final /* synthetic */ RemoteMediaPlayer zzabK;

                protected void zza(zze com_google_android_gms_cast_internal_zze) {
                    synchronized (this.zzabK.zzpV) {
                        this.zzabK.zzabF.zzc(apiClient);
                        try {
                            this.zzabK.zzabE.zza(this.zzacm, trackIds);
                            this.zzabK.zzabF.zzc(null);
                        } catch (IOException e) {
                            zza(zzq(new Status(2100)));
                            this.zzabK.zzabF.zzc(null);
                        } catch (Throwable th) {
                            this.zzabK.zzabF.zzc(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.zzabI = listener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener listener) {
        this.zzabG = listener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener listener) {
        this.zzabH = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.zzabJ = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final boolean z = muteState;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, z, jSONObject);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IllegalStateException e) {
                        try {
                            zza(zzq(new Status(2100)));
                            this.zzabK.zzabF.zzc(null);
                        } catch (Throwable th) {
                            this.zzabK.zzabF.zzc(null);
                        }
                    } catch (IOException e2) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (Double.isInfinite(volume) || Double.isNaN(volume)) {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
        final GoogleApiClient googleApiClient = apiClient;
        final double d = volume;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(googleApiClient);
                    try {
                        this.zzabK.zzabE.zza(this.zzacm, d, jSONObject);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IllegalStateException e) {
                        try {
                            zza(zzq(new Status(2100)));
                            this.zzabK.zzabF.zzc(null);
                        } catch (Throwable th) {
                            this.zzabK.zzabF.zzc(null);
                        }
                    } catch (IllegalArgumentException e2) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e3) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient apiClient, final TextTrackStyle trackStyle) {
        if (trackStyle != null) {
            return apiClient.zzb(new zzb(this, apiClient) {
                final /* synthetic */ RemoteMediaPlayer zzabK;

                protected void zza(zze com_google_android_gms_cast_internal_zze) {
                    synchronized (this.zzabK.zzpV) {
                        this.zzabK.zzabF.zzc(apiClient);
                        try {
                            this.zzabK.zzabE.zza(this.zzacm, trackStyle);
                            this.zzabK.zzabF.zzc(null);
                        } catch (IOException e) {
                            zza(zzq(new Status(2100)));
                            this.zzabK.zzabF.zzc(null);
                        } catch (Throwable th) {
                            this.zzabK.zzabF.zzc(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzabK;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzabK.zzpV) {
                    this.zzabK.zzabF.zzc(apiClient);
                    try {
                        this.zzabK.zzabE.zzb(this.zzacm, customData);
                        this.zzabK.zzabF.zzc(null);
                    } catch (IOException e) {
                        zza(zzq(new Status(2100)));
                        this.zzabK.zzabF.zzc(null);
                    } catch (Throwable th) {
                        this.zzabK.zzabF.zzc(null);
                    }
                }
            }
        });
    }
}
