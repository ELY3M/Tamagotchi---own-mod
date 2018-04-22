package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.zze;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.zzz;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener, zzc, zzq {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private final String mName;
    int zzakz;
    private CountDownLatch zzapL;
    zza zzapM;
    boolean zzapN;

    final class zza extends Handler {
        final /* synthetic */ DriveEventService zzapP;

        zza(DriveEventService driveEventService) {
            this.zzapP = driveEventService;
        }

        private Message zzb(OnEventResponse onEventResponse) {
            return obtainMessage(1, onEventResponse);
        }

        private Message zzsW() {
            return obtainMessage(2);
        }

        public void handleMessage(Message msg) {
            zzz.zzy("DriveEventService", "handleMessage message type:" + msg.what);
            switch (msg.what) {
                case 1:
                    this.zzapP.zza((OnEventResponse) msg.obj);
                    return;
                case 2:
                    getLooper().quit();
                    return;
                default:
                    zzz.zzz("DriveEventService", "Unexpected message type:" + msg.what);
                    return;
            }
        }
    }

    final class zzb extends com.google.android.gms.drive.internal.zzao.zza {
        final /* synthetic */ DriveEventService zzapP;

        zzb(DriveEventService driveEventService) {
            this.zzapP = driveEventService;
        }

        public void zzc(OnEventResponse onEventResponse) throws RemoteException {
            synchronized (this.zzapP) {
                zzz.zzy("DriveEventService", "onEvent: " + onEventResponse);
                this.zzapP.zzsV();
                if (this.zzapP.zzapM != null) {
                    this.zzapP.zzapM.sendMessage(this.zzapP.zzapM.zzb(onEventResponse));
                } else {
                    zzz.zzA("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String name) {
        this.zzapN = false;
        this.zzakz = -1;
        this.mName = name;
    }

    private void zza(OnEventResponse onEventResponse) {
        DriveEvent zzts = onEventResponse.zzts();
        zzz.zzy("DriveEventService", "handleEventMessage: " + zzts);
        try {
            switch (zzts.getType()) {
                case 1:
                    onChange((ChangeEvent) zzts);
                    return;
                case 2:
                    onCompletion((CompletionEvent) zzts);
                    return;
                case 4:
                    zza((ChangesAvailableEvent) zzts);
                    return;
                case 7:
                    zza((TransferStateEvent) zzts);
                    return;
                default:
                    zzz.zzz(this.mName, "Unhandled event: " + zzts);
                    return;
            }
        } catch (Throwable e) {
            zzz.zza(this.mName, e, "Error handling event: " + zzts);
        }
        zzz.zza(this.mName, e, "Error handling event: " + zzts);
    }

    private void zzsV() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.zzakz) {
            if (zze.zzf(this, callingUid)) {
                this.zzakz = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final synchronized IBinder onBind(Intent intent) {
        IBinder asBinder;
        if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            if (this.zzapM == null && !this.zzapN) {
                this.zzapN = true;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                this.zzapL = new CountDownLatch(1);
                new Thread(this) {
                    final /* synthetic */ DriveEventService zzapP;

                    public void run() {
                        try {
                            Looper.prepare();
                            this.zzapP.zzapM = new zza(this.zzapP);
                            this.zzapP.zzapN = false;
                            countDownLatch.countDown();
                            zzz.zzy("DriveEventService", "Bound and starting loop");
                            Looper.loop();
                            zzz.zzy("DriveEventService", "Finished loop");
                        } finally {
                            if (this.zzapP.zzapL != null) {
                                this.zzapP.zzapL.countDown();
                            }
                        }
                    }
                }.start();
                try {
                    if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                        zzz.zzA("DriveEventService", "Failed to synchronously initialize event handler.");
                    }
                } catch (Throwable e) {
                    throw new RuntimeException("Unable to start event handler", e);
                }
            }
            asBinder = new zzb(this).asBinder();
        } else {
            asBinder = null;
        }
        return asBinder;
    }

    public void onChange(ChangeEvent event) {
        zzz.zzz(this.mName, "Unhandled change event: " + event);
    }

    public void onCompletion(CompletionEvent event) {
        zzz.zzz(this.mName, "Unhandled completion event: " + event);
    }

    public synchronized void onDestroy() {
        zzz.zzy("DriveEventService", "onDestroy");
        if (this.zzapM != null) {
            this.zzapM.sendMessage(this.zzapM.zzsW());
            this.zzapM = null;
            try {
                if (!this.zzapL.await(5000, TimeUnit.MILLISECONDS)) {
                    zzz.zzz("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException e) {
            }
            this.zzapL = null;
        }
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }

    public void zza(ChangesAvailableEvent changesAvailableEvent) {
        zzz.zzz(this.mName, "Unhandled changes available event: " + changesAvailableEvent);
    }

    public void zza(TransferStateEvent transferStateEvent) {
        zzz.zzz(this.mName, "Unhandled transfer state event: " + transferStateEvent);
    }
}
