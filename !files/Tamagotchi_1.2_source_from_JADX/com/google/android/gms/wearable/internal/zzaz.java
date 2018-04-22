package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzaz implements MessageApi {

    public static class zzb implements SendMessageResult {
        private final Status zzUX;
        private final int zzaox;

        public zzb(Status status, int i) {
            this.zzUX = status;
            this.zzaox = i;
        }

        public int getRequestId() {
            return this.zzaox;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class zza extends zzi<Status> {
        private zzq<MessageListener> zzbbi;
        private MessageListener zzbsS;
        private IntentFilter[] zzbsT;

        private zza(GoogleApiClient googleApiClient, MessageListener messageListener, zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_MessageApi_MessageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzbsS = (MessageListener) zzx.zzz(messageListener);
            this.zzbbi = (zzq) zzx.zzz(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_MessageApi_MessageListener);
            this.zzbsT = (IntentFilter[]) zzx.zzz(intentFilterArr);
        }

        protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, this.zzbsS, this.zzbbi, this.zzbsT);
            this.zzbsS = null;
            this.zzbbi = null;
            this.zzbsT = null;
        }

        public Status zzb(Status status) {
            this.zzbsS = null;
            this.zzbbi = null;
            this.zzbsT = null;
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, messageListener, googleApiClient.zzr(messageListener), intentFilterArr));
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener) {
        return zza(client, listener, new IntentFilter[]{zzbn.zzgM(MessageApi.ACTION_MESSAGE_RECEIVED)});
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener, Uri uri, int filterType) {
        zzx.zzb(uri != null, (Object) "uri must not be null");
        boolean z = filterType == 0 || filterType == 1;
        zzx.zzb(z, (Object) "invalid filter type");
        return zza(client, listener, new IntentFilter[]{zzbn.zza(MessageApi.ACTION_MESSAGE_RECEIVED, uri, filterType)});
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final MessageListener listener) {
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ zzaz zzbsQ;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, listener);
            }

            public Status zzb(Status status) {
                return status;
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient client, String nodeId, String action, byte[] data) {
        final String str = nodeId;
        final String str2 = action;
        final byte[] bArr = data;
        return client.zza(new zzi<SendMessageResult>(this, client) {
            final /* synthetic */ zzaz zzbsQ;

            protected void zza(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
                com_google_android_gms_wearable_internal_zzbp.zza((com.google.android.gms.common.api.internal.zza.zzb) this, str, str2, bArr);
            }

            protected SendMessageResult zzbz(Status status) {
                return new zzb(status, -1);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbz(status);
            }
        });
    }
}
