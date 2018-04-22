package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR = new zzo();
    private final String mPath;
    final int mVersionCode;
    private final String zzVo;
    private final String zzbrb;

    static final class zza implements GetInputStreamResult {
        private final Status zzUX;
        private final InputStream zzbsh;

        zza(Status status, InputStream inputStream) {
            this.zzUX = (Status) zzx.zzz(status);
            this.zzbsh = inputStream;
        }

        public InputStream getInputStream() {
            return this.zzbsh;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzbsh != null) {
                try {
                    this.zzbsh.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static final class zzb implements GetOutputStreamResult {
        private final Status zzUX;
        private final OutputStream zzbsi;

        zzb(Status status, OutputStream outputStream) {
            this.zzUX = (Status) zzx.zzz(status);
            this.zzbsi = outputStream;
        }

        public OutputStream getOutputStream() {
            return this.zzbsi;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzbsi != null) {
                try {
                    this.zzbsi.close();
                } catch (IOException e) {
                }
            }
        }
    }

    ChannelImpl(int versionCode, String token, String nodeId, String path) {
        this.mVersionCode = versionCode;
        this.zzVo = (String) zzx.zzz(token);
        this.zzbrb = (String) zzx.zzz(nodeId);
        this.mPath = (String) zzx.zzz(path);
    }

    private static zza<ChannelListener> zza(final String str, final IntentFilter[] intentFilterArr) {
        return new zza<ChannelListener>() {
            public void zza(zzbp com_google_android_gms_wearable_internal_zzbp, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, ChannelListener channelListener, zzq<ChannelListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, channelListener, (zzq) com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener, str, intentFilterArr);
            }
        };
    }

    public PendingResult<Status> addListener(GoogleApiClient client, ChannelListener listener) {
        return zzb.zza(client, zza(this.zzVo, new IntentFilter[]{zzbn.zzgM(ChannelApi.ACTION_CHANNEL_EVENT)}), listener);
    }

    public PendingResult<Status> close(GoogleApiClient client) {
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ ChannelImpl zzbsd;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zzt(this, this.zzbsd.zzVo);
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingResult<Status> close(GoogleApiClient client, final int errorCode) {
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ ChannelImpl zzbsd;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zzh(this, this.zzbsd.zzVo, errorCode);
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) other;
        return this.zzVo.equals(channelImpl.zzVo) && zzw.equal(channelImpl.zzbrb, this.zzbrb) && zzw.equal(channelImpl.mPath, this.mPath) && channelImpl.mVersionCode == this.mVersionCode;
    }

    public PendingResult<GetInputStreamResult> getInputStream(GoogleApiClient client) {
        return client.zza(new zzi<GetInputStreamResult>(this, client) {
            final /* synthetic */ ChannelImpl zzbsd;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zzu(this, this.zzbsd.zzVo);
            }

            public GetInputStreamResult zzbt(Status status) {
                return new zza(status, null);
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzbt(status);
            }
        });
    }

    public String getNodeId() {
        return this.zzbrb;
    }

    public PendingResult<GetOutputStreamResult> getOutputStream(GoogleApiClient client) {
        return client.zza(new zzi<GetOutputStreamResult>(this, client) {
            final /* synthetic */ ChannelImpl zzbsd;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zzv(this, this.zzbsd.zzVo);
            }

            public GetOutputStreamResult zzbu(Status status) {
                return new zzb(status, null);
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzbu(status);
            }
        });
    }

    public String getPath() {
        return this.mPath;
    }

    public String getToken() {
        return this.zzVo;
    }

    public int hashCode() {
        return this.zzVo.hashCode();
    }

    public PendingResult<Status> receiveFile(GoogleApiClient client, final Uri uri, final boolean append) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) uri, (Object) "uri is null");
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ ChannelImpl zzbsd;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbsd.zzVo, uri, append);
            }

            public Status zzb(Status status) {
                return status;
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zzb(client, listener, this.zzVo));
    }

    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri) {
        return sendFile(client, uri, 0, -1);
    }

    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri, long startOffset, long length) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb(this.zzVo, (Object) "token is null");
        zzx.zzb((Object) uri, (Object) "uri is null");
        zzx.zzb(startOffset >= 0, "startOffset is negative: %s", Long.valueOf(startOffset));
        boolean z = length >= 0 || length == -1;
        zzx.zzb(z, "invalid length: %s", Long.valueOf(length));
        final Uri uri2 = uri;
        final long j = startOffset;
        final long j2 = length;
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ ChannelImpl zzbsd;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbsd.zzVo, uri2, j, j2);
            }

            public Status zzb(Status status) {
                return status;
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.zzVo + '\'' + ", nodeId='" + this.zzbrb + '\'' + ", path='" + this.mPath + '\'' + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }
}
