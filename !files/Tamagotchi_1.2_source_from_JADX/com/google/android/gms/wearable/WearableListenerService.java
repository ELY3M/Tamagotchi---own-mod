package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.zze;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import java.util.List;

public abstract class WearableListenerService extends Service implements CapabilityListener, ChannelListener, DataListener, MessageListener, NodeListener, com.google.android.gms.wearable.NodeApi.zza {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private boolean zzQl;
    private String zzTJ;
    private IBinder zzakD;
    private Handler zzbro;
    private final Object zzbrp = new Object();

    private final class zza extends com.google.android.gms.wearable.internal.zzaw.zza {
        private volatile int zzakz;
        final /* synthetic */ WearableListenerService zzbrq;

        private zza(WearableListenerService wearableListenerService) {
            this.zzbrq = wearableListenerService;
            this.zzakz = -1;
        }

        private void zzIx() throws SecurityException {
            int callingUid = Binder.getCallingUid();
            if (callingUid != this.zzakz) {
                if (zze.zzf(this.zzbrq, callingUid)) {
                    this.zzakz = callingUid;
                    return;
                }
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }

        private boolean zza(Runnable runnable, String str, Object obj) {
            return !(this.zzbrq instanceof zzj) ? false : zzb(runnable, str, obj);
        }

        private boolean zzb(Runnable runnable, String str, Object obj) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", String.format("%s: %s %s", new Object[]{str, this.zzbrq.zzTJ, obj}));
            }
            zzIx();
            synchronized (this.zzbrq.zzbrp) {
                if (this.zzbrq.zzQl) {
                    return false;
                }
                this.zzbrq.zzbro.post(runnable);
                return true;
            }
        }

        public void onConnectedNodes(final List<NodeParcelable> connectedNodes) {
            zzb(new Runnable(this) {
                final /* synthetic */ zza zzbrs;

                public void run() {
                    this.zzbrs.zzbrq.onConnectedNodes(connectedNodes);
                }
            }, "onConnectedNodes", connectedNodes);
        }

        public void zza(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            zza(new Runnable(this) {
                final /* synthetic */ zza zzbrs;

                public void run() {
                    ((zzj) this.zzbrs.zzbrq).zza(amsEntityUpdateParcelable);
                }
            }, "onEntityUpdate", amsEntityUpdateParcelable);
        }

        public void zza(final AncsNotificationParcelable ancsNotificationParcelable) {
            zza(new Runnable(this) {
                final /* synthetic */ zza zzbrs;

                public void run() {
                    ((zzj) this.zzbrs.zzbrq).zza(ancsNotificationParcelable);
                }
            }, "onNotificationReceived", ancsNotificationParcelable);
        }

        public void zza(final CapabilityInfoParcelable capabilityInfoParcelable) {
            zzb(new Runnable(this) {
                final /* synthetic */ zza zzbrs;

                public void run() {
                    this.zzbrs.zzbrq.onCapabilityChanged(capabilityInfoParcelable);
                }
            }, "onConnectedCapabilityChanged", capabilityInfoParcelable);
        }

        public void zza(final ChannelEventParcelable channelEventParcelable) {
            zzb(new Runnable(this) {
                final /* synthetic */ zza zzbrs;

                public void run() {
                    channelEventParcelable.zza(this.zzbrs.zzbrq);
                }
            }, "onChannelEvent", channelEventParcelable);
        }

        public void zza(final MessageEventParcelable messageEventParcelable) {
            zzb(new Runnable(this) {
                final /* synthetic */ zza zzbrs;

                public void run() {
                    this.zzbrs.zzbrq.onMessageReceived(messageEventParcelable);
                }
            }, "onMessageReceived", messageEventParcelable);
        }

        public void zza(final NodeParcelable nodeParcelable) {
            zzb(new Runnable(this) {
                final /* synthetic */ zza zzbrs;

                public void run() {
                    this.zzbrs.zzbrq.onPeerConnected(nodeParcelable);
                }
            }, "onPeerConnected", nodeParcelable);
        }

        public void zzag(final DataHolder dataHolder) {
            try {
                if (!zzb(new Runnable(this) {
                    final /* synthetic */ zza zzbrs;

                    public void run() {
                        DataEventBuffer dataEventBuffer = new DataEventBuffer(dataHolder);
                        try {
                            this.zzbrs.zzbrq.onDataChanged(dataEventBuffer);
                        } finally {
                            dataEventBuffer.release();
                        }
                    }
                }, "onDataItemChanged", dataHolder)) {
                }
            } finally {
                dataHolder.close();
            }
        }

        public void zzb(final NodeParcelable nodeParcelable) {
            zzb(new Runnable(this) {
                final /* synthetic */ zza zzbrs;

                public void run() {
                    this.zzbrs.zzbrq.onPeerDisconnected(nodeParcelable);
                }
            }, "onPeerDisconnected", nodeParcelable);
        }
    }

    public final IBinder onBind(Intent intent) {
        return BIND_LISTENER_INTENT_ACTION.equals(intent.getAction()) ? this.zzakD : null;
    }

    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
    }

    public void onChannelClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onChannelOpened(Channel channel) {
    }

    public void onConnectedNodes(List<Node> list) {
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + new ComponentName(getPackageName(), getClass().getName()).flattenToShortString());
        }
        this.zzTJ = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.zzbro = new Handler(handlerThread.getLooper());
        this.zzakD = new zza();
    }

    public void onDataChanged(DataEventBuffer dataEvents) {
    }

    public void onDestroy() {
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onDestroy: " + new ComponentName(getPackageName(), getClass().getName()).flattenToShortString());
        }
        synchronized (this.zzbrp) {
            this.zzQl = true;
            if (this.zzbro == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.zzbro.getLooper().quit();
        }
        super.onDestroy();
    }

    public void onInputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onOutputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onPeerConnected(Node peer) {
    }

    public void onPeerDisconnected(Node peer) {
    }
}
