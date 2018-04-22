package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzlu.zza;

public class zzlr extends zzj<zzlt> implements DeathRecipient {
    private static final zzl zzaaf = new zzl("CastRemoteDisplayClientImpl");
    private CastDevice zzZO;
    private CastRemoteDisplaySessionCallbacks zzaeL;

    public zzlr(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastDevice castDevice, CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 83, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        zzaaf.zzb("instance created", new Object[0]);
        this.zzaeL = castRemoteDisplaySessionCallbacks;
        this.zzZO = castDevice;
    }

    public void binderDied() {
    }

    public void disconnect() {
        zzaaf.zzb("disconnect", new Object[0]);
        this.zzaeL = null;
        this.zzZO = null;
        try {
            ((zzlt) zzqJ()).disconnect();
            super.disconnect();
        } catch (RemoteException e) {
            super.disconnect();
        } catch (IllegalStateException e2) {
            super.disconnect();
        } catch (Throwable th) {
            super.disconnect();
        }
    }

    public /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaG(iBinder);
    }

    public void zza(zzls com_google_android_gms_internal_zzls) throws RemoteException {
        zzaaf.zzb("stopRemoteDisplay", new Object[0]);
        ((zzlt) zzqJ()).zza(com_google_android_gms_internal_zzls);
    }

    public void zza(zzls com_google_android_gms_internal_zzls, int i) throws RemoteException {
        ((zzlt) zzqJ()).zza(com_google_android_gms_internal_zzls, i);
    }

    public void zza(zzls com_google_android_gms_internal_zzls, final zzlu com_google_android_gms_internal_zzlu, String str) throws RemoteException {
        zzaaf.zzb("startRemoteDisplay", new Object[0]);
        ((zzlt) zzqJ()).zza(com_google_android_gms_internal_zzls, new zza(this) {
            final /* synthetic */ zzlr zzaeN;

            public void zzbp(int i) throws RemoteException {
                zzlr.zzaaf.zzb("onRemoteDisplayEnded", new Object[0]);
                if (com_google_android_gms_internal_zzlu != null) {
                    com_google_android_gms_internal_zzlu.zzbp(i);
                }
                if (this.zzaeN.zzaeL != null) {
                    this.zzaeN.zzaeL.onRemoteDisplayEnded(new Status(i));
                }
            }
        }, this.zzZO.getDeviceId(), str);
    }

    public zzlt zzaG(IBinder iBinder) {
        return zzlt.zza.zzaI(iBinder);
    }

    protected String zzgu() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    protected String zzgv() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }
}
