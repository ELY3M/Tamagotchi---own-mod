package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.C0196R;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplayOptions;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(19)
public abstract class CastRemoteDisplayLocalService extends Service {
    private static final zzl zzaaf = new zzl("CastRemoteDisplayLocalService");
    private static final int zzaag = C0196R.id.cast_notification_id;
    private static final Object zzaah = new Object();
    private static AtomicBoolean zzaai = new AtomicBoolean(false);
    private static CastRemoteDisplayLocalService zzaax;
    private Handler mHandler;
    private Notification mNotification;
    private String zzZC;
    private GoogleApiClient zzaaj;
    private CastRemoteDisplaySessionCallbacks zzaak;
    private Callbacks zzaal;
    private zzb zzaam;
    private NotificationSettings zzaan;
    private boolean zzaao;
    private PendingIntent zzaap;
    private CastDevice zzaaq;
    private Display zzaar;
    private Context zzaas;
    private ServiceConnection zzaat;
    private MediaRouter zzaau;
    private boolean zzaav = false;
    private final Callback zzaaw = new C06911(this);
    private final IBinder zzaay = new zza();

    class C02733 implements Runnable {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C02733(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        public void run() {
            this.zzaaz.zzbe("onCreate after delay. The local service been started: " + this.zzaaz.zzaav);
            if (!this.zzaaz.zzaav) {
                this.zzaaz.zzbh("The local service has not been been started, stopping it");
                this.zzaaz.stopSelf();
            }
        }
    }

    public interface Callbacks {
        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onServiceCreated(CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    public static final class NotificationSettings {
        private Notification mNotification;
        private PendingIntent zzaaF;
        private String zzaaG;
        private String zzaaH;

        public static final class Builder {
            private NotificationSettings zzaaI = new NotificationSettings();

            public NotificationSettings build() {
                if (this.zzaaI.mNotification != null) {
                    if (!TextUtils.isEmpty(this.zzaaI.zzaaG)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    } else if (!TextUtils.isEmpty(this.zzaaI.zzaaH)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    } else if (this.zzaaI.zzaaF != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zzaaI.zzaaG) && TextUtils.isEmpty(this.zzaaI.zzaaH) && this.zzaaI.zzaaF == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zzaaI;
            }

            public Builder setNotification(Notification notification) {
                this.zzaaI.mNotification = notification;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent notificationPendingIntent) {
                this.zzaaI.zzaaF = notificationPendingIntent;
                return this;
            }

            public Builder setNotificationText(String notificationText) {
                this.zzaaI.zzaaH = notificationText;
                return this;
            }

            public Builder setNotificationTitle(String notificationTitle) {
                this.zzaaI.zzaaG = notificationTitle;
                return this;
            }
        }

        private NotificationSettings() {
        }

        private NotificationSettings(NotificationSettings newSettings) {
            this.mNotification = newSettings.mNotification;
            this.zzaaF = newSettings.zzaaF;
            this.zzaaG = newSettings.zzaaG;
            this.zzaaH = newSettings.zzaaH;
        }
    }

    private class zza extends Binder {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        private zza(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        CastRemoteDisplayLocalService zznM() {
            return this.zzaaz;
        }
    }

    private static final class zzb extends BroadcastReceiver {
        private zzb() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT")) {
                CastRemoteDisplayLocalService.zzaaf.zzb("disconnecting", new Object[0]);
                CastRemoteDisplayLocalService.stopService();
            }
        }
    }

    class C06911 extends Callback {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C06911(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        public void onRouteUnselected(MediaRouter router, RouteInfo info) {
            this.zzaaz.zzbe("onRouteUnselected");
            if (this.zzaaz.zzaaq == null) {
                this.zzaaz.zzbe("onRouteUnselected, no device was selected");
            } else if (CastDevice.getFromBundle(info.getExtras()).getDeviceId().equals(this.zzaaz.zzaaq.getDeviceId())) {
                CastRemoteDisplayLocalService.stopService();
            } else {
                this.zzaaz.zzbe("onRouteUnselected, device does not match");
            }
        }
    }

    class C06922 implements OnConnectionFailedListener {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C06922(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            this.zzaaz.zzbh("Connection failed: " + connectionResult);
            this.zzaaz.zznE();
        }
    }

    class C06937 implements CastRemoteDisplaySessionCallbacks {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C06937(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        public void onRemoteDisplayEnded(Status status) {
            CastRemoteDisplayLocalService.zzaaf.zzb(String.format("Cast screen has ended: %d", new Object[]{Integer.valueOf(status.getStatusCode())}), new Object[0]);
            CastRemoteDisplayLocalService.zzS(false);
        }
    }

    class C06948 implements ResultCallback<CastRemoteDisplaySessionResult> {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C06948(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        public /* synthetic */ void onResult(Result result) {
            zza((CastRemoteDisplaySessionResult) result);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zza(com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult r6) {
            /*
            r5 = this;
            r4 = 0;
            r3 = 0;
            r0 = r6.getStatus();
            r0 = r0.isSuccess();
            if (r0 != 0) goto L_0x001d;
        L_0x000c:
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaaf;
            r1 = "Connection was not successful";
            r2 = new java.lang.Object[r3];
            r0.zzc(r1, r2);
            r0 = r5.zzaaz;
            r0.zznE();
        L_0x001c:
            return;
        L_0x001d:
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaaf;
            r1 = "startRemoteDisplay successful";
            r2 = new java.lang.Object[r3];
            r0.zzb(r1, r2);
            r1 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaah;
            monitor-enter(r1);
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaax;	 Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0049;
        L_0x0033:
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaaf;	 Catch:{ all -> 0x0046 }
            r2 = "Remote Display started but session already cancelled";
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0046 }
            r0.zzb(r2, r3);	 Catch:{ all -> 0x0046 }
            r0 = r5.zzaaz;	 Catch:{ all -> 0x0046 }
            r0.zznE();	 Catch:{ all -> 0x0046 }
            monitor-exit(r1);	 Catch:{ all -> 0x0046 }
            goto L_0x001c;
        L_0x0046:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0046 }
            throw r0;
        L_0x0049:
            monitor-exit(r1);	 Catch:{ all -> 0x0046 }
            r0 = r6.getPresentationDisplay();
            if (r0 == 0) goto L_0x0086;
        L_0x0050:
            r1 = r5.zzaaz;
            r1.zza(r0);
        L_0x0055:
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaai;
            r0.set(r3);
            r0 = r5.zzaaz;
            r0 = r0.zzaas;
            if (r0 == 0) goto L_0x001c;
        L_0x0064:
            r0 = r5.zzaaz;
            r0 = r0.zzaat;
            if (r0 == 0) goto L_0x001c;
        L_0x006c:
            r0 = r5.zzaaz;	 Catch:{ IllegalArgumentException -> 0x0092 }
            r0 = r0.zzaas;	 Catch:{ IllegalArgumentException -> 0x0092 }
            r1 = r5.zzaaz;	 Catch:{ IllegalArgumentException -> 0x0092 }
            r1 = r1.zzaat;	 Catch:{ IllegalArgumentException -> 0x0092 }
            r0.unbindService(r1);	 Catch:{ IllegalArgumentException -> 0x0092 }
        L_0x007b:
            r0 = r5.zzaaz;
            r0.zzaat = r4;
            r0 = r5.zzaaz;
            r0.zzaas = r4;
            goto L_0x001c;
        L_0x0086:
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaaf;
            r1 = "Cast Remote Display session created without display";
            r2 = new java.lang.Object[r3];
            r0.zzc(r1, r2);
            goto L_0x0055;
        L_0x0092:
            r0 = move-exception;
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaaf;
            r1 = "No need to unbind service, already unbound";
            r2 = new java.lang.Object[r3];
            r0.zzb(r1, r2);
            goto L_0x007b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastRemoteDisplayLocalService.8.zza(com.google.android.gms.cast.CastRemoteDisplay$CastRemoteDisplaySessionResult):void");
        }
    }

    class C06959 implements ResultCallback<CastRemoteDisplaySessionResult> {
        final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

        C06959(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzaaz = castRemoteDisplayLocalService;
        }

        public /* synthetic */ void onResult(Result result) {
            zza((CastRemoteDisplaySessionResult) result);
        }

        public void zza(CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
            if (castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                this.zzaaz.zzbe("remote display stopped");
            } else {
                this.zzaaz.zzbe("Unable to stop the remote display, result unsuccessful");
            }
            this.zzaaz.zzaar = null;
        }
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzaah) {
            castRemoteDisplayLocalService = zzaax;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zzaaf.zzY(true);
    }

    public static void startService(Context activityContext, Class<? extends CastRemoteDisplayLocalService> serviceClass, String applicationId, CastDevice device, NotificationSettings notificationSettings, Callbacks callbacks) {
        zzaaf.zzb("Starting Service", new Object[0]);
        synchronized (zzaah) {
            if (zzaax != null) {
                zzaaf.zzf("An existing service had not been stopped before starting one", new Object[0]);
                zzS(true);
            }
        }
        zzb(activityContext, (Class) serviceClass);
        zzx.zzb((Object) activityContext, (Object) "activityContext is required.");
        zzx.zzb((Object) serviceClass, (Object) "serviceClass is required.");
        zzx.zzb((Object) applicationId, (Object) "applicationId is required.");
        zzx.zzb((Object) device, (Object) "device is required.");
        zzx.zzb((Object) notificationSettings, (Object) "notificationSettings is required.");
        zzx.zzb((Object) callbacks, (Object) "callbacks is required.");
        if (notificationSettings.mNotification == null && notificationSettings.zzaaF == null) {
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        } else if (zzaai.getAndSet(true)) {
            zzaaf.zzc("Service is already being started, startService has been called twice", new Object[0]);
        } else {
            Intent intent = new Intent(activityContext, serviceClass);
            activityContext.startService(intent);
            final String str = applicationId;
            final CastDevice castDevice = device;
            final NotificationSettings notificationSettings2 = notificationSettings;
            final Context context = activityContext;
            final Callbacks callbacks2 = callbacks;
            activityContext.bindService(intent, new ServiceConnection() {
                public void onServiceConnected(ComponentName className, IBinder binder) {
                    CastRemoteDisplayLocalService zznM = ((zza) binder).zznM();
                    if (zznM == null || !zznM.zza(str, castDevice, notificationSettings2, context, this, callbacks2)) {
                        CastRemoteDisplayLocalService.zzaaf.zzc("Connected but unable to get the service instance", new Object[0]);
                        callbacks2.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
                        CastRemoteDisplayLocalService.zzaai.set(false);
                        try {
                            context.unbindService(this);
                        } catch (IllegalArgumentException e) {
                            CastRemoteDisplayLocalService.zzaaf.zzb("No need to unbind service, already unbound", new Object[0]);
                        }
                    }
                }

                public void onServiceDisconnected(ComponentName arg0) {
                    CastRemoteDisplayLocalService.zzaaf.zzb("onServiceDisconnected", new Object[0]);
                    callbacks2.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_DISCONNECTED, "Service Disconnected"));
                    CastRemoteDisplayLocalService.zzaai.set(false);
                    try {
                        context.unbindService(this);
                    } catch (IllegalArgumentException e) {
                        CastRemoteDisplayLocalService.zzaaf.zzb("No need to unbind service, already unbound", new Object[0]);
                    }
                }
            }, 64);
        }
    }

    public static void stopService() {
        zzS(false);
    }

    private void zzQ(final boolean z) {
        if (this.mHandler == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

                public void run() {
                    this.zzaaz.zzR(z);
                }
            });
        } else {
            zzR(z);
        }
    }

    private void zzR(boolean z) {
        zzbe("Stopping Service");
        zzx.zzcD("stopServiceInstanceInternal must be called on the main thread");
        if (!(z || this.zzaau == null)) {
            zzbe("Setting default route");
            this.zzaau.selectRoute(this.zzaau.getDefaultRoute());
        }
        if (this.zzaam != null) {
            zzbe("Unregistering notification receiver");
            unregisterReceiver(this.zzaam);
        }
        zznF();
        zznG();
        zznB();
        if (this.zzaaj != null) {
            this.zzaaj.disconnect();
            this.zzaaj = null;
        }
        if (!(this.zzaas == null || this.zzaat == null)) {
            try {
                this.zzaas.unbindService(this.zzaat);
            } catch (IllegalArgumentException e) {
                zzbe("No need to unbind service, already unbound");
            }
            this.zzaat = null;
            this.zzaas = null;
        }
        this.zzZC = null;
        this.zzaaj = null;
        this.mNotification = null;
        this.zzaar = null;
    }

    private static void zzS(boolean z) {
        zzaaf.zzb("Stopping Service", new Object[0]);
        zzaai.set(false);
        synchronized (zzaah) {
            if (zzaax == null) {
                zzaaf.zzc("Service is already being stopped", new Object[0]);
                return;
            }
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzaax;
            zzaax = null;
            castRemoteDisplayLocalService.zzQ(z);
        }
    }

    private Notification zzT(boolean z) {
        int i;
        int i2;
        CharSequence string;
        zzbe("createDefaultNotification");
        int i3 = getApplicationInfo().labelRes;
        CharSequence zzc = this.zzaan.zzaaG;
        CharSequence zzd = this.zzaan.zzaaH;
        if (z) {
            i = C0196R.string.cast_notification_connected_message;
            i2 = C0196R.drawable.cast_ic_notification_on;
        } else {
            i = C0196R.string.cast_notification_connecting_message;
            i2 = C0196R.drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(zzc)) {
            zzc = getString(i3);
        }
        if (TextUtils.isEmpty(zzd)) {
            string = getString(i, new Object[]{this.zzaaq.getFriendlyName()});
        } else {
            string = zzd;
        }
        return new Builder(this).setContentTitle(zzc).setContentText(string).setContentIntent(this.zzaan.zzaaF).setSmallIcon(i2).setOngoing(true).addAction(17301560, getString(C0196R.string.cast_notification_disconnect), zznH()).build();
    }

    private GoogleApiClient zza(CastDevice castDevice) {
        return new GoogleApiClient.Builder(this, new ConnectionCallbacks(this) {
            final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

            {
                this.zzaaz = r1;
            }

            public void onConnected(Bundle bundle) {
                this.zzaaz.zzbe("onConnected");
                this.zzaaz.zznC();
            }

            public void onConnectionSuspended(int cause) {
                CastRemoteDisplayLocalService.zzaaf.zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[]{this, Integer.valueOf(cause)}), new Object[0]);
            }
        }, new C06922(this)).addApi(CastRemoteDisplay.API, new CastRemoteDisplayOptions.Builder(castDevice, this.zzaak).build()).build();
    }

    private void zza(Display display) {
        this.zzaar = display;
        if (this.zzaao) {
            this.mNotification = zzT(true);
            startForeground(zzaag, this.mNotification);
        }
        if (this.zzaal != null) {
            this.zzaal.onRemoteDisplaySessionStarted(this);
            this.zzaal = null;
        }
        onCreatePresentation(this.zzaar);
    }

    private void zza(NotificationSettings notificationSettings) {
        zzx.zzcD("updateNotificationSettingsInternal must be called on the main thread");
        if (this.zzaan == null) {
            throw new IllegalStateException("No current notification settings to update");
        }
        if (!this.zzaao) {
            zzx.zzb(notificationSettings.mNotification, (Object) "notification is required.");
            this.mNotification = notificationSettings.mNotification;
            this.zzaan.mNotification = this.mNotification;
        } else if (notificationSettings.mNotification != null) {
            throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
        } else {
            if (notificationSettings.zzaaF != null) {
                this.zzaan.zzaaF = notificationSettings.zzaaF;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzaaG)) {
                this.zzaan.zzaaG = notificationSettings.zzaaG;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzaaH)) {
                this.zzaan.zzaaH = notificationSettings.zzaaH;
            }
            this.mNotification = zzT(true);
        }
        startForeground(zzaag, this.mNotification);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean zza(java.lang.String r8, com.google.android.gms.cast.CastDevice r9, com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings r10, android.content.Context r11, android.content.ServiceConnection r12, com.google.android.gms.cast.CastRemoteDisplayLocalService.Callbacks r13) {
        /*
        r7 = this;
        r6 = 0;
        r1 = 1;
        r0 = 0;
        r2 = "startRemoteDisplaySession";
        r7.zzbe(r2);
        r2 = "Starting the Cast Remote Display must be done on the main thread";
        com.google.android.gms.common.internal.zzx.zzcD(r2);
        r2 = zzaah;
        monitor-enter(r2);
        r3 = zzaax;	 Catch:{ all -> 0x00ac }
        if (r3 == 0) goto L_0x0020;
    L_0x0014:
        r1 = zzaaf;	 Catch:{ all -> 0x00ac }
        r3 = "An existing service had not been stopped before starting one";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ac }
        r1.zzf(r3, r4);	 Catch:{ all -> 0x00ac }
        monitor-exit(r2);	 Catch:{ all -> 0x00ac }
    L_0x001f:
        return r0;
    L_0x0020:
        zzaax = r7;	 Catch:{ all -> 0x00ac }
        monitor-exit(r2);	 Catch:{ all -> 0x00ac }
        r7.zzaal = r13;
        r7.zzZC = r8;
        r7.zzaaq = r9;
        r7.zzaas = r11;
        r7.zzaat = r12;
        r2 = r7.getApplicationContext();
        r2 = android.support.v7.media.MediaRouter.getInstance(r2);
        r7.zzaau = r2;
        r2 = new android.support.v7.media.MediaRouteSelector$Builder;
        r2.<init>();
        r3 = r7.zzZC;
        r3 = com.google.android.gms.cast.CastMediaControlIntent.categoryForCast(r3);
        r2 = r2.addControlCategory(r3);
        r2 = r2.build();
        r3 = "addMediaRouterCallback";
        r7.zzbe(r3);
        r3 = r7.zzaau;
        r4 = r7.zzaaw;
        r5 = 4;
        r3.addCallback(r2, r4, r5);
        r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService$7;
        r2.<init>(r7);
        r7.zzaak = r2;
        r2 = r10.mNotification;
        r7.mNotification = r2;
        r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService$zzb;
        r2.<init>();
        r7.zzaam = r2;
        r2 = r7.zzaam;
        r3 = new android.content.IntentFilter;
        r4 = "com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT";
        r3.<init>(r4);
        r7.registerReceiver(r2, r3);
        r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings;
        r2.<init>(r10);
        r7.zzaan = r2;
        r2 = r7.zzaan;
        r2 = r2.mNotification;
        if (r2 != 0) goto L_0x00af;
    L_0x0086:
        r7.zzaao = r1;
        r0 = r7.zzT(r0);
        r7.mNotification = r0;
    L_0x008e:
        r0 = zzaag;
        r2 = r7.mNotification;
        r7.startForeground(r0, r2);
        r0 = r7.zza(r9);
        r7.zzaaj = r0;
        r0 = r7.zzaaj;
        r0.connect();
        r0 = r7.zzaal;
        if (r0 == 0) goto L_0x00a9;
    L_0x00a4:
        r0 = r7.zzaal;
        r0.onServiceCreated(r7);
    L_0x00a9:
        r0 = r1;
        goto L_0x001f;
    L_0x00ac:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00ac }
        throw r0;
    L_0x00af:
        r7.zzaao = r0;
        r0 = r7.zzaan;
        r0 = r0.mNotification;
        r7.mNotification = r0;
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastRemoteDisplayLocalService.zza(java.lang.String, com.google.android.gms.cast.CastDevice, com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings, android.content.Context, android.content.ServiceConnection, com.google.android.gms.cast.CastRemoteDisplayLocalService$Callbacks):boolean");
    }

    private static void zzb(Context context, Class cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 128);
            if (serviceInfo != null && serviceInfo.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
    }

    private void zzbe(String str) {
        zzaaf.zzb("[Instance: %s] %s", this, str);
    }

    private void zzbh(String str) {
        zzaaf.zzc("[Instance: %s] %s", this, str);
    }

    private void zznB() {
        if (this.zzaau != null) {
            zzx.zzcD("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzbe("removeMediaRouterCallback");
            this.zzaau.removeCallback(this.zzaaw);
        }
    }

    private void zznC() {
        zzbe("startRemoteDisplay");
        if (this.zzaaj == null || !this.zzaaj.isConnected()) {
            zzaaf.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(this.zzaaj, this.zzZC).setResultCallback(new C06948(this));
        }
    }

    private void zznD() {
        zzbe("stopRemoteDisplay");
        if (this.zzaaj == null || !this.zzaaj.isConnected()) {
            zzaaf.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(this.zzaaj).setResultCallback(new C06959(this));
        }
    }

    private void zznE() {
        if (this.zzaal != null) {
            this.zzaal.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
            this.zzaal = null;
        }
        stopService();
    }

    private void zznF() {
        zzbe("stopRemoteDisplaySession");
        zznD();
        onDismissPresentation();
    }

    private void zznG() {
        zzbe("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
    }

    private PendingIntent zznH() {
        if (this.zzaap == null) {
            this.zzaap = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), DriveFile.MODE_READ_ONLY);
        }
        return this.zzaap;
    }

    protected Display getDisplay() {
        return this.zzaar;
    }

    public IBinder onBind(Intent intent) {
        zzbe("onBind");
        return this.zzaay;
    }

    public void onCreate() {
        zzbe("onCreate");
        super.onCreate();
        this.mHandler = new Handler(getMainLooper());
        this.mHandler.postDelayed(new C02733(this), 100);
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    public int onStartCommand(Intent intent, int flags, int startId) {
        zzbe("onStartCommand");
        this.zzaav = true;
        return 2;
    }

    public void updateNotificationSettings(final NotificationSettings notificationSettings) {
        zzx.zzb((Object) notificationSettings, (Object) "notificationSettings is required.");
        zzx.zzb(this.mHandler, (Object) "Service is not ready yet.");
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ CastRemoteDisplayLocalService zzaaz;

            public void run() {
                this.zzaaz.zza(notificationSettings);
            }
        });
    }
}
