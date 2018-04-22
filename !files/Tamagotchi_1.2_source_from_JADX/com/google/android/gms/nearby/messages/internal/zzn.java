package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.PublishOptions.Builder;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import java.util.List;

public class zzn implements Messages {
    public static final zzc<zzm> zzUI = new zzc();
    public static final com.google.android.gms.common.api.Api.zza<zzm, MessagesOptions> zzUJ = new C08451();

    static class C08451 extends com.google.android.gms.common.api.Api.zza<zzm, MessagesOptions> {
        C08451() {
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public zzm zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, MessagesOptions messagesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzm(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf, messagesOptions);
        }
    }

    static abstract class zza extends com.google.android.gms.common.api.internal.zza.zza<Status, zzm> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzn.zzUI, googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    @Nullable
    private static Message zzA(Intent intent) {
        return (Message) zzj.zzc(intent, "com.google.android.gms.nearby.messages.MESSAGES");
    }

    @Nullable
    private static Message zzB(Intent intent) {
        return (Message) zzj.zzc(intent, "com.google.android.gms.nearby.messages.LOST_MESSAGE");
    }

    private static List<Message> zzC(Intent intent) {
        return zzj.zzd(intent, "com.google.android.gms.nearby.messages.UPDATED_MESSAGES");
    }

    public PendingResult<Status> getPermissionStatus(GoogleApiClient client) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzn zzbcN;

            protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzm.zzm(this);
            }
        });
    }

    public void handleIntent(Intent intent, MessageListener messageListener) {
        Message zzA = zzA(intent);
        if (zzA != null) {
            messageListener.onFound(zzA);
        }
        zzA = zzB(intent);
        if (zzA != null) {
            messageListener.onLost(zzA);
        }
        for (Message zzA2 : zzC(intent)) {
            messageListener.zza(zzA2);
        }
    }

    public PendingResult<Status> publish(GoogleApiClient client, Message message) {
        return publish(client, message, PublishOptions.DEFAULT);
    }

    public PendingResult<Status> publish(GoogleApiClient client, final Message message, final PublishOptions options) {
        zzx.zzz(message);
        zzx.zzz(options);
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzn zzbcN;

            protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzm.zza((zzb) this, MessageWrapper.zzb(message), options);
            }
        });
    }

    @Deprecated
    public PendingResult<Status> publish(GoogleApiClient client, Message message, Strategy strategy) {
        return publish(client, message, new Builder().setStrategy(strategy).build());
    }

    public PendingResult<Status> registerStatusCallback(GoogleApiClient client, final StatusCallback statusCallback) {
        zzx.zzz(statusCallback);
        final zzq zza = ((zzm) client.zza(zzUI)).zza(client, statusCallback);
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzn zzbcN;

            protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzm.zza((zzb) this, zza, statusCallback);
            }
        });
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, PendingIntent pendingIntent) {
        return subscribe(client, pendingIntent, SubscribeOptions.DEFAULT);
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, final PendingIntent pendingIntent, final SubscribeOptions options) {
        zzx.zzz(pendingIntent);
        zzx.zzz(options);
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzn zzbcN;

            protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzm.zza((zzb) this, pendingIntent, options);
            }
        });
    }

    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener) {
        return subscribe(client, listener, SubscribeOptions.DEFAULT);
    }

    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, Strategy strategy) {
        return subscribe(client, listener, new SubscribeOptions.Builder().setStrategy(strategy).build());
    }

    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, Strategy strategy, MessageFilter filter) {
        return subscribe(client, listener, new SubscribeOptions.Builder().setStrategy(strategy).setFilter(filter).build());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, SubscribeOptions options) {
        zzx.zzz(listener);
        zzx.zzz(options);
        final zzq zza = ((zzm) client.zza(zzUI)).zza(client, listener);
        final MessageListener messageListener = listener;
        final SubscribeOptions subscribeOptions = options;
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzn zzbcN;

            protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzm.zza(this, zza, messageListener, subscribeOptions, null);
            }
        });
    }

    public PendingResult<Status> unpublish(GoogleApiClient client, final Message message) {
        zzx.zzz(message);
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzn zzbcN;

            protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzm.zza((zzb) this, MessageWrapper.zzb(message));
            }
        });
    }

    public PendingResult<Status> unregisterStatusCallback(GoogleApiClient client, final StatusCallback statusCallback) {
        final zzq zza = ((zzm) client.zza(zzUI)).zza(client, statusCallback);
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzn zzbcN;

            protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzm.zzb(this, zza, statusCallback);
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final PendingIntent pendingIntent) {
        zzx.zzz(pendingIntent);
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzn zzbcN;

            protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzm.zza((zzb) this, pendingIntent);
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final MessageListener listener) {
        zzx.zzz(listener);
        final zzq zza = ((zzm) client.zza(zzUI)).zza(client, listener);
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzn zzbcN;

            protected void zza(zzm com_google_android_gms_nearby_messages_internal_zzm) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzm.zza((zzb) this, zza, listener);
            }
        });
    }
}
