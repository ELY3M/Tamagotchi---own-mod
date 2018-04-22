package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.JoinOptions;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zze extends zzj<zzi> {
    private static final zzl zzaaf = new zzl("CastClientImpl");
    private static final Object zzadP = new Object();
    private static final Object zzadQ = new Object();
    private final Listener zzZP;
    private double zzabs;
    private boolean zzabt;
    private final long zzadA;
    private zzb zzadB;
    private String zzadC;
    private boolean zzadD;
    private boolean zzadE;
    private boolean zzadF;
    private int zzadG;
    private int zzadH;
    private final AtomicLong zzadI = new AtomicLong(0);
    private String zzadJ;
    private String zzadK;
    private Bundle zzadL;
    private final Map<Long, com.google.android.gms.common.api.internal.zza.zzb<Status>> zzadM = new HashMap();
    private com.google.android.gms.common.api.internal.zza.zzb<ApplicationConnectionResult> zzadN;
    private com.google.android.gms.common.api.internal.zza.zzb<Status> zzadO;
    private ApplicationMetadata zzadx;
    private final CastDevice zzady;
    private final Map<String, MessageReceivedCallback> zzadz = new HashMap();

    private static final class zza implements ApplicationConnectionResult {
        private final String zzLq;
        private final Status zzUX;
        private final ApplicationMetadata zzadR;
        private final String zzadS;
        private final boolean zzadT;

        public zza(Status status) {
            this(status, null, null, null, false);
        }

        public zza(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.zzUX = status;
            this.zzadR = applicationMetadata;
            this.zzadS = str;
            this.zzLq = str2;
            this.zzadT = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.zzadR;
        }

        public String getApplicationStatus() {
            return this.zzadS;
        }

        public String getSessionId() {
            return this.zzLq;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public boolean getWasLaunched() {
            return this.zzadT;
        }
    }

    private static class zzb extends com.google.android.gms.cast.internal.zzj.zza {
        private final Handler mHandler;
        private final AtomicReference<zze> zzadU;

        public zzb(zze com_google_android_gms_cast_internal_zze) {
            this.zzadU = new AtomicReference(com_google_android_gms_cast_internal_zze);
            this.mHandler = new Handler(com_google_android_gms_cast_internal_zze.getLooper());
        }

        private void zza(zze com_google_android_gms_cast_internal_zze, long j, int i) {
            synchronized (com_google_android_gms_cast_internal_zze.zzadM) {
                com.google.android.gms.common.api.internal.zza.zzb com_google_android_gms_common_api_internal_zza_zzb = (com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_cast_internal_zze.zzadM.remove(Long.valueOf(j));
            }
            if (com_google_android_gms_common_api_internal_zza_zzb != null) {
                com_google_android_gms_common_api_internal_zza_zzb.zzs(new Status(i));
            }
        }

        private boolean zza(zze com_google_android_gms_cast_internal_zze, int i) {
            synchronized (zze.zzadQ) {
                if (com_google_android_gms_cast_internal_zze.zzadO != null) {
                    com_google_android_gms_cast_internal_zze.zzadO.zzs(new Status(i));
                    com_google_android_gms_cast_internal_zze.zzadO = null;
                    return true;
                }
                return false;
            }
        }

        public boolean isDisposed() {
            return this.zzadU.get() == null;
        }

        public void onApplicationDisconnected(final int statusCode) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.zzadU.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                com_google_android_gms_cast_internal_zze.zzadJ = null;
                com_google_android_gms_cast_internal_zze.zzadK = null;
                zza(com_google_android_gms_cast_internal_zze, statusCode);
                if (com_google_android_gms_cast_internal_zze.zzZP != null) {
                    this.mHandler.post(new Runnable(this) {
                        final /* synthetic */ zzb zzadX;

                        public void run() {
                            com_google_android_gms_cast_internal_zze.zzZP.onApplicationDisconnected(statusCode);
                        }
                    });
                }
            }
        }

        public void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzadU.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                com_google_android_gms_cast_internal_zze.zzadx = applicationMetadata;
                com_google_android_gms_cast_internal_zze.zzadJ = applicationMetadata.getApplicationId();
                com_google_android_gms_cast_internal_zze.zzadK = str2;
                synchronized (zze.zzadP) {
                    if (com_google_android_gms_cast_internal_zze.zzadN != null) {
                        com_google_android_gms_cast_internal_zze.zzadN.zzs(new zza(new Status(0), applicationMetadata, str, str2, z));
                        com_google_android_gms_cast_internal_zze.zzadN = null;
                    }
                }
            }
        }

        public void zza(String str, double d, boolean z) {
            zze.zzaaf.zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void zza(String str, long j, int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzadU.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, j, i);
            }
        }

        public void zzb(final ApplicationStatus applicationStatus) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.zzadU.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.zzaaf.zzb("onApplicationStatusChanged", new Object[0]);
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ zzb zzadX;

                    public void run() {
                        com_google_android_gms_cast_internal_zze.zza(applicationStatus);
                    }
                });
            }
        }

        public void zzb(final DeviceStatus deviceStatus) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.zzadU.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.zzaaf.zzb("onDeviceStatusChanged", new Object[0]);
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ zzb zzadX;

                    public void run() {
                        com_google_android_gms_cast_internal_zze.zza(deviceStatus);
                    }
                });
            }
        }

        public void zzb(String str, byte[] bArr) {
            if (((zze) this.zzadU.get()) != null) {
                zze.zzaaf.zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
            }
        }

        public void zzbk(int i) {
            zze zzos = zzos();
            if (zzos != null) {
                zze.zzaaf.zzb("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
                if (i != 0) {
                    zzos.zzbS(2);
                }
            }
        }

        public void zzbl(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzadU.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                synchronized (zze.zzadP) {
                    if (com_google_android_gms_cast_internal_zze.zzadN != null) {
                        com_google_android_gms_cast_internal_zze.zzadN.zzs(new zza(new Status(i)));
                        com_google_android_gms_cast_internal_zze.zzadN = null;
                    }
                }
            }
        }

        public void zzbm(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzadU.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, i);
            }
        }

        public void zzbn(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzadU.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, i);
            }
        }

        public void zzc(String str, long j) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzadU.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, j, 0);
            }
        }

        public zze zzos() {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzadU.getAndSet(null);
            if (com_google_android_gms_cast_internal_zze == null) {
                return null;
            }
            com_google_android_gms_cast_internal_zze.zzoh();
            return com_google_android_gms_cast_internal_zze;
        }

        public void zzt(final String str, final String str2) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.zzadU.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.zzaaf.zzb("Receive (type=text, ns=%s) %s", str, str2);
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ zzb zzadX;

                    public void run() {
                        synchronized (com_google_android_gms_cast_internal_zze.zzadz) {
                            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) com_google_android_gms_cast_internal_zze.zzadz.get(str);
                        }
                        if (messageReceivedCallback != null) {
                            messageReceivedCallback.onMessageReceived(com_google_android_gms_cast_internal_zze.zzady, str, str2);
                            return;
                        }
                        zze.zzaaf.zzb("Discarded message for unknown namespace '%s'", str);
                    }
                });
            }
        }
    }

    public zze(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzady = castDevice;
        this.zzZP = listener;
        this.zzadA = j;
        zzoh();
    }

    private void zza(ApplicationStatus applicationStatus) {
        boolean z;
        String zzoe = applicationStatus.zzoe();
        if (zzf.zza(zzoe, this.zzadC)) {
            z = false;
        } else {
            this.zzadC = zzoe;
            z = true;
        }
        zzaaf.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzadD));
        if (this.zzZP != null && (z || this.zzadD)) {
            this.zzZP.onApplicationStatusChanged();
        }
        this.zzadD = false;
    }

    private void zza(DeviceStatus deviceStatus) {
        boolean z;
        ApplicationMetadata applicationMetadata = deviceStatus.getApplicationMetadata();
        if (!zzf.zza(applicationMetadata, this.zzadx)) {
            this.zzadx = applicationMetadata;
            this.zzZP.onApplicationMetadataChanged(this.zzadx);
        }
        double zzok = deviceStatus.zzok();
        if (zzok == Double.NaN || Math.abs(zzok - this.zzabs) <= 1.0E-7d) {
            z = false;
        } else {
            this.zzabs = zzok;
            z = true;
        }
        boolean zzot = deviceStatus.zzot();
        if (zzot != this.zzabt) {
            this.zzabt = zzot;
            z = true;
        }
        zzaaf.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzadE));
        if (this.zzZP != null && (z || this.zzadE)) {
            this.zzZP.onVolumeChanged();
        }
        int zzol = deviceStatus.zzol();
        if (zzol != this.zzadG) {
            this.zzadG = zzol;
            z = true;
        } else {
            z = false;
        }
        zzaaf.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzadE));
        if (this.zzZP != null && (z || this.zzadE)) {
            this.zzZP.onActiveInputStateChanged(this.zzadG);
        }
        zzol = deviceStatus.zzom();
        if (zzol != this.zzadH) {
            this.zzadH = zzol;
            z = true;
        } else {
            z = false;
        }
        zzaaf.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzadE));
        if (this.zzZP != null && (z || this.zzadE)) {
            this.zzZP.onStandbyStateChanged(this.zzadH);
        }
        this.zzadE = false;
    }

    private void zza(com.google.android.gms.common.api.internal.zza.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) {
        synchronized (zzadP) {
            if (this.zzadN != null) {
                this.zzadN.zzs(new zza(new Status(2002)));
            }
            this.zzadN = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult;
        }
    }

    private void zzc(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
        synchronized (zzadQ) {
            if (this.zzadO != null) {
                com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status.zzs(new Status(2001));
                return;
            }
            this.zzadO = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
        }
    }

    private void zzoh() {
        this.zzadF = false;
        this.zzadG = -1;
        this.zzadH = -1;
        this.zzadx = null;
        this.zzadC = null;
        this.zzabs = 0.0d;
        this.zzabt = false;
    }

    private void zzon() {
        zzaaf.zzb("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zzadz) {
            this.zzadz.clear();
        }
    }

    private void zzoo() throws IllegalStateException {
        if (!this.zzadF || this.zzadB == null || this.zzadB.isDisposed()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    public void disconnect() {
        Throwable e;
        zzaaf.zzb("disconnect(); ServiceListener=%s, isConnected=%b", this.zzadB, Boolean.valueOf(isConnected()));
        zzb com_google_android_gms_cast_internal_zze_zzb = this.zzadB;
        this.zzadB = null;
        if (com_google_android_gms_cast_internal_zze_zzb == null || com_google_android_gms_cast_internal_zze_zzb.zzos() == null) {
            zzaaf.zzb("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zzon();
        try {
            ((zzi) zzqJ()).disconnect();
            super.disconnect();
        } catch (RemoteException e2) {
            e = e2;
            try {
                zzaaf.zzb(e, "Error while disconnecting the controller interface: %s", e.getMessage());
            } finally {
                super.disconnect();
            }
        } catch (IllegalStateException e3) {
            e = e3;
            zzaaf.zzb(e, "Error while disconnecting the controller interface: %s", e.getMessage());
        }
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        zzoo();
        return this.zzadx;
    }

    public String getApplicationStatus() throws IllegalStateException {
        zzoo();
        return this.zzadC;
    }

    public boolean isMute() throws IllegalStateException {
        zzoo();
        return this.zzabt;
    }

    public void onConnectionFailed(ConnectionResult result) {
        super.onConnectionFailed(result);
        zzon();
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaE(iBinder);
    }

    public void zzX(boolean z) throws IllegalStateException, RemoteException {
        ((zzi) zzqJ()).zza(z, this.zzabs, this.zzabt);
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        zzaaf.zzb("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.zzadF = true;
            this.zzadD = true;
            this.zzadE = true;
        } else {
            this.zzadF = false;
        }
        if (i == 1001) {
            this.zzadL = new Bundle();
            this.zzadL.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        zzf.zzch(str);
        zzcg(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zzadz) {
                this.zzadz.put(str, messageReceivedCallback);
            }
            ((zzi) zzqJ()).zzcl(str);
        }
    }

    public void zza(String str, LaunchOptions launchOptions, com.google.android.gms.common.api.internal.zza.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zza((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzi) zzqJ()).zza(str, launchOptions);
    }

    public void zza(String str, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
        ((zzi) zzqJ()).zzck(str);
    }

    public void zza(String str, String str2, JoinOptions joinOptions, com.google.android.gms.common.api.internal.zza.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zza((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        if (joinOptions == null) {
            joinOptions = new JoinOptions();
        }
        ((zzi) zzqJ()).zza(str, str2, joinOptions);
    }

    public void zza(String str, String str2, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            zzf.zzch(str);
            zzoo();
            long incrementAndGet = this.zzadI.incrementAndGet();
            try {
                this.zzadM.put(Long.valueOf(incrementAndGet), com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
                ((zzi) zzqJ()).zzb(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.zzadM.remove(Long.valueOf(incrementAndGet));
            }
        }
    }

    public void zza(String str, boolean z, com.google.android.gms.common.api.internal.zza.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        LaunchOptions launchOptions = new LaunchOptions();
        launchOptions.setRelaunchIfRunning(z);
        zza(str, launchOptions, (com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
    }

    protected zzi zzaE(IBinder iBinder) {
        return com.google.android.gms.cast.internal.zzi.zza.zzaF(iBinder);
    }

    public void zzb(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
        ((zzi) zzqJ()).zzou();
    }

    public void zzcg(String str) throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zzadz) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.zzadz.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((zzi) zzqJ()).zzcm(str);
            } catch (Throwable e) {
                zzaaf.zzb(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void zzf(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((zzi) zzqJ()).zza(d, this.zzabs, this.zzabt);
    }

    protected String zzgu() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String zzgv() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    protected Bundle zzml() {
        Bundle bundle = new Bundle();
        zzaaf.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzadJ, this.zzadK);
        this.zzady.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzadA);
        this.zzadB = new zzb(this);
        bundle.putParcelable("listener", new BinderWrapper(this.zzadB.asBinder()));
        if (this.zzadJ != null) {
            bundle.putString("last_application_id", this.zzadJ);
            if (this.zzadK != null) {
                bundle.putString("last_session_id", this.zzadK);
            }
        }
        return bundle;
    }

    public Bundle zzoi() {
        if (this.zzadL == null) {
            return super.zzoi();
        }
        Bundle bundle = this.zzadL;
        this.zzadL = null;
        return bundle;
    }

    public void zzoj() throws IllegalStateException, RemoteException {
        ((zzi) zzqJ()).zzoj();
    }

    public double zzok() throws IllegalStateException {
        zzoo();
        return this.zzabs;
    }

    public int zzol() throws IllegalStateException {
        zzoo();
        return this.zzadG;
    }

    public int zzom() throws IllegalStateException {
        zzoo();
        return this.zzadH;
    }
}
