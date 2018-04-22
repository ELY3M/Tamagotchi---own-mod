package com.google.android.gms.nearby.messages.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishCallback;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

class zzm extends zzj<zzf> {
    private final boolean zzbcv;
    private final ClientAppContext zzbcw;
    private final zzg<StatusCallback, zze> zzbcx = new C08391(this);
    private final zzg<MessageListener, zzc> zzbcy = new C08402(this);

    private interface zza<C> {
        zzq<C> zzEE();
    }

    @TargetApi(14)
    private static class zzb implements ActivityLifecycleCallbacks {
        private final Activity zzbcA;
        private final zzm zzbcB;

        private zzb(Activity activity, zzm com_google_android_gms_nearby_messages_internal_zzm) {
            this.zzbcA = activity;
            this.zzbcB = com_google_android_gms_nearby_messages_internal_zzm;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (activity == this.zzbcA) {
                Log.v("NearbyMessagesClient", String.format("Unregistering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", new Object[]{activity.getPackageName()}));
                activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            }
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
            if (activity == this.zzbcA) {
                try {
                    this.zzbcB.zzjq(1);
                } catch (RemoteException e) {
                    Log.v("NearbyMessagesClient", String.format("Failed to emit ACTIVITY_STOPPED from ClientLifecycleSafetyNet for Activity %s: %s", new Object[]{activity.getPackageName(), e}));
                }
            }
        }
    }

    private static abstract class zzg<C, W extends zza<C>> {
        private final SimpleArrayMap<C, W> zzanP;

        private zzg() {
            this.zzanP = new SimpleArrayMap(1);
        }

        @Nullable
        W zzG(C c) {
            return (zza) this.zzanP.get(c);
        }

        @Nullable
        W zzH(C c) {
            zza com_google_android_gms_nearby_messages_internal_zzm_zza = (zza) this.zzanP.remove(c);
            if (com_google_android_gms_nearby_messages_internal_zzm_zza != null) {
                com_google_android_gms_nearby_messages_internal_zzm_zza.zzEE().clear();
            }
            return com_google_android_gms_nearby_messages_internal_zzm_zza;
        }

        W zza(zzq<C> com_google_android_gms_common_api_internal_zzq_C, C c) {
            zza com_google_android_gms_nearby_messages_internal_zzm_zza = (zza) this.zzanP.get(c);
            if (com_google_android_gms_nearby_messages_internal_zzm_zza != null) {
                com_google_android_gms_common_api_internal_zzq_C.clear();
                return com_google_android_gms_nearby_messages_internal_zzm_zza;
            }
            W zzf = zzf(com_google_android_gms_common_api_internal_zzq_C);
            this.zzanP.put(c, zzf);
            return zzf;
        }

        protected abstract W zzf(zzq<C> com_google_android_gms_common_api_internal_zzq_C);
    }

    class C08391 extends zzg<StatusCallback, zze> {
        final /* synthetic */ zzm zzbcz;

        C08391(zzm com_google_android_gms_nearby_messages_internal_zzm) {
            this.zzbcz = com_google_android_gms_nearby_messages_internal_zzm;
            super();
        }

        protected zze zze(zzq<StatusCallback> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_StatusCallback) {
            return new zze(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_StatusCallback);
        }

        protected /* synthetic */ zza zzf(zzq com_google_android_gms_common_api_internal_zzq) {
            return zze(com_google_android_gms_common_api_internal_zzq);
        }
    }

    class C08402 extends zzg<MessageListener, zzc> {
        final /* synthetic */ zzm zzbcz;

        C08402(zzm com_google_android_gms_nearby_messages_internal_zzm) {
            this.zzbcz = com_google_android_gms_nearby_messages_internal_zzm;
            super();
        }

        protected /* synthetic */ zza zzf(zzq com_google_android_gms_common_api_internal_zzq) {
            return zzg(com_google_android_gms_common_api_internal_zzq);
        }

        protected zzc zzg(zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_MessageListener) {
            return new zzc(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_MessageListener);
        }
    }

    private static class zzc extends com.google.android.gms.nearby.messages.internal.zzd.zza implements zza<MessageListener> {
        private final zzq<MessageListener> zzbbi;

        private zzc(zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_MessageListener) {
            this.zzbbi = com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_MessageListener;
        }

        public zzq<MessageListener> zzEE() {
            return this.zzbbi;
        }

        public void zza(final MessageWrapper messageWrapper) throws RemoteException {
            this.zzbbi.zza(new com.google.android.gms.common.api.internal.zzq.zzb<MessageListener>(this) {
                final /* synthetic */ zzc zzbcD;

                public void zza(MessageListener messageListener) {
                    messageListener.onFound(messageWrapper.zzbcu);
                }

                public void zzpr() {
                }

                public /* synthetic */ void zzt(Object obj) {
                    zza((MessageListener) obj);
                }
            });
        }

        public void zza(final MessageWrapper[] messageWrapperArr) throws RemoteException {
            this.zzbbi.zza(new com.google.android.gms.common.api.internal.zzq.zzb<MessageListener>(this) {
                final /* synthetic */ zzc zzbcD;

                public void zza(MessageListener messageListener) {
                    for (MessageWrapper messageWrapper : messageWrapperArr) {
                        messageListener.zza(messageWrapper.zzbcu);
                    }
                }

                public void zzpr() {
                }

                public /* synthetic */ void zzt(Object obj) {
                    zza((MessageListener) obj);
                }
            });
        }

        public void zzb(final MessageWrapper messageWrapper) throws RemoteException {
            this.zzbbi.zza(new com.google.android.gms.common.api.internal.zzq.zzb<MessageListener>(this) {
                final /* synthetic */ zzc zzbcD;

                public void zza(MessageListener messageListener) {
                    messageListener.onLost(messageWrapper.zzbcu);
                }

                public void zzpr() {
                }

                public /* synthetic */ void zzt(Object obj) {
                    zza((MessageListener) obj);
                }
            });
        }
    }

    private static class zzd extends com.google.android.gms.nearby.messages.internal.zzg.zza {
        private final PublishCallback zzbcG;

        private zzd(PublishCallback publishCallback) {
            this.zzbcG = publishCallback;
        }

        @Nullable
        private static zzd zza(@Nullable PublishCallback publishCallback) {
            return publishCallback == null ? null : new zzd(publishCallback);
        }

        public void onExpired() {
            this.zzbcG.onExpired();
        }
    }

    private static class zze extends com.google.android.gms.nearby.messages.internal.zzh.zza implements zza<StatusCallback> {
        private final zzq<StatusCallback> zzbcH;

        private zze(zzq<StatusCallback> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_StatusCallback) {
            this.zzbcH = com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_StatusCallback;
        }

        public void onPermissionChanged(final boolean granted) {
            this.zzbcH.zza(new com.google.android.gms.common.api.internal.zzq.zzb<StatusCallback>(this) {
                final /* synthetic */ zze zzbcJ;

                public void zza(StatusCallback statusCallback) {
                    statusCallback.onPermissionChanged(granted);
                }

                public void zzpr() {
                }

                public /* synthetic */ void zzt(Object obj) {
                    zza((StatusCallback) obj);
                }
            });
        }

        public zzq<StatusCallback> zzEE() {
            return this.zzbcH;
        }
    }

    private static class zzf extends com.google.android.gms.nearby.messages.internal.zzi.zza {
        private final SubscribeCallback zzbcK;

        private zzf(SubscribeCallback subscribeCallback) {
            this.zzbcK = subscribeCallback;
        }

        @Nullable
        private static zzf zza(@Nullable SubscribeCallback subscribeCallback) {
            return subscribeCallback == null ? null : new zzf(subscribeCallback);
        }

        public void onExpired() {
            this.zzbcK.onExpired();
        }
    }

    @TargetApi(14)
    zzm(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, MessagesOptions messagesOptions) {
        super(context, looper, 62, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        String zzqv = com_google_android_gms_common_internal_zzf.zzqv();
        int zzaU = zzaU(context);
        if (messagesOptions != null) {
            this.zzbcw = new ClientAppContext(zzqv, messagesOptions.zzbbF, messagesOptions.zzbbH, zzaU);
            this.zzbcv = messagesOptions.zzbbG;
        } else {
            this.zzbcw = new ClientAppContext(zzqv, null, false, zzaU);
            this.zzbcv = false;
        }
        if (zzaU == 1 && zzne.zzsg()) {
            Activity activity = (Activity) context;
            Log.v("NearbyMessagesClient", String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", new Object[]{activity.getPackageName()}));
            activity.getApplication().registerActivityLifecycleCallbacks(new zzb(activity, this));
        }
    }

    private static <C> zzq<C> zza(GoogleApiClient googleApiClient, C c, zzg<C, ? extends zza<C>> com_google_android_gms_nearby_messages_internal_zzm_zzg_C___extends_com_google_android_gms_nearby_messages_internal_zzm_zza_C) {
        zza zzG = com_google_android_gms_nearby_messages_internal_zzm_zzg_C___extends_com_google_android_gms_nearby_messages_internal_zzm_zza_C.zzG(c);
        return zzG != null ? zzG.zzEE() : googleApiClient.zzr(c);
    }

    private static int zzaU(Context context) {
        return context instanceof Activity ? 1 : context instanceof Application ? 2 : context instanceof Service ? 3 : 0;
    }

    public void disconnect() {
        try {
            zzjq(2);
        } catch (RemoteException e) {
            Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", new Object[]{e}));
        }
        super.disconnect();
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdE(iBinder);
    }

    zzq<MessageListener> zza(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return zza(googleApiClient, (Object) messageListener, this.zzbcy);
    }

    zzq<StatusCallback> zza(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        return zza(googleApiClient, (Object) statusCallback, this.zzbcx);
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, PendingIntent pendingIntent) throws RemoteException {
        ((zzf) zzqJ()).zza(new UnsubscribeRequest(null, zzp.zzn(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), pendingIntent, 0, this.zzbcw));
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, PendingIntent pendingIntent, SubscribeOptions subscribeOptions) throws RemoteException {
        ((zzf) zzqJ()).zza(new SubscribeRequest(null, subscribeOptions.getStrategy(), zzp.zzn(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), subscribeOptions.getFilter(), pendingIntent, 0, null, this.zzbcv, zzf.zza(subscribeOptions.getCallback()), this.zzbcw));
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_MessageListener, MessageListener messageListener) throws RemoteException {
        if (this.zzbcy.zzG(messageListener) != null) {
            ((zzf) zzqJ()).zza(new UnsubscribeRequest((IBinder) this.zzbcy.zza(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_MessageListener, messageListener), zzp.zzn(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), null, 0, this.zzbcw));
            this.zzbcy.zzH(messageListener);
        }
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_MessageListener, MessageListener messageListener, SubscribeOptions subscribeOptions, @Nullable byte[] bArr) throws RemoteException {
        ((zzf) zzqJ()).zza(new SubscribeRequest((IBinder) this.zzbcy.zza(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_MessageListener, messageListener), subscribeOptions.getStrategy(), zzp.zzn(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), subscribeOptions.getFilter(), null, 0, bArr, this.zzbcv, zzf.zza(subscribeOptions.getCallback()), this.zzbcw));
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, zzq<StatusCallback> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_StatusCallback, StatusCallback statusCallback) throws RemoteException {
        RegisterStatusCallbackRequest registerStatusCallbackRequest = new RegisterStatusCallbackRequest(zzp.zzn(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), (IBinder) this.zzbcx.zza(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_StatusCallback, statusCallback), this.zzbcw);
        registerStatusCallbackRequest.zzbcX = true;
        ((zzf) zzqJ()).zza(registerStatusCallbackRequest);
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, MessageWrapper messageWrapper) throws RemoteException {
        ((zzf) zzqJ()).zza(new UnpublishRequest(messageWrapper, zzp.zzn(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), this.zzbcw));
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, MessageWrapper messageWrapper, PublishOptions publishOptions) throws RemoteException {
        ((zzf) zzqJ()).zza(new PublishRequest(messageWrapper, publishOptions.getStrategy(), zzp.zzn(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), this.zzbcv, zzd.zza(publishOptions.getCallback()), this.zzbcw));
    }

    void zzb(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, zzq<StatusCallback> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_StatusCallback, StatusCallback statusCallback) throws RemoteException {
        if (this.zzbcx.zzG(statusCallback) != null) {
            RegisterStatusCallbackRequest registerStatusCallbackRequest = new RegisterStatusCallbackRequest(zzp.zzn(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), (IBinder) this.zzbcx.zza(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_messages_StatusCallback, statusCallback), this.zzbcw);
            registerStatusCallbackRequest.zzbcX = false;
            ((zzf) zzqJ()).zza(registerStatusCallbackRequest);
            this.zzbcx.zzH(statusCallback);
        }
    }

    protected zzf zzdE(IBinder iBinder) {
        return com.google.android.gms.nearby.messages.internal.zzf.zza.zzdA(iBinder);
    }

    @NonNull
    protected String zzgu() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    @NonNull
    protected String zzgv() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    void zzjq(int i) throws RemoteException {
        String str;
        switch (i) {
            case 1:
                str = "ACTIVITY_STOPPED";
                break;
            case 2:
                str = "CLIENT_DISCONNECTED";
                break;
            default:
                Log.w("NearbyMessagesClient", String.format("Received unknown/unforeseen client lifecycle event %d, can't do anything with it.", new Object[]{Integer.valueOf(i)}));
                return;
        }
        if (isConnected()) {
            HandleClientLifecycleEventRequest handleClientLifecycleEventRequest = new HandleClientLifecycleEventRequest(this.zzbcw, i);
            Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", new Object[]{str}));
            ((zzf) zzqJ()).zza(handleClientLifecycleEventRequest);
            return;
        }
        Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", new Object[]{str}));
    }

    void zzm(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        ((zzf) zzqJ()).zza(new GetPermissionStatusRequest(zzp.zzn(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), this.zzbcw));
    }
}
