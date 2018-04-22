package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzlt extends IInterface {

    public static abstract class zza extends Binder implements zzlt {

        private static class zza implements zzlt {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    this.zzoz.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void disconnect() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    this.zzoz.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzls com_google_android_gms_internal_zzls) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    if (com_google_android_gms_internal_zzls != null) {
                        iBinder = com_google_android_gms_internal_zzls.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzls com_google_android_gms_internal_zzls, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    if (com_google_android_gms_internal_zzls != null) {
                        iBinder = com_google_android_gms_internal_zzls.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.zzoz.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzls com_google_android_gms_internal_zzls, zzlu com_google_android_gms_internal_zzlu, String str, String str2) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzls != null ? com_google_android_gms_internal_zzls.asBinder() : null);
                    if (com_google_android_gms_internal_zzlu != null) {
                        iBinder = com_google_android_gms_internal_zzlu.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzlt zzaI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzlt)) ? new zza(iBinder) : (zzlt) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    destroy();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    disconnect();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    zza(com.google.android.gms.internal.zzls.zza.zzaH(data.readStrongBinder()), com.google.android.gms.internal.zzlu.zza.zzaJ(data.readStrongBinder()), data.readString(), data.readString());
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    zza(com.google.android.gms.internal.zzls.zza.zzaH(data.readStrongBinder()), data.readInt());
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    zza(com.google.android.gms.internal.zzls.zza.zzaH(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void destroy() throws RemoteException;

    void disconnect() throws RemoteException;

    void zza(zzls com_google_android_gms_internal_zzls) throws RemoteException;

    void zza(zzls com_google_android_gms_internal_zzls, int i) throws RemoteException;

    void zza(zzls com_google_android_gms_internal_zzls, zzlu com_google_android_gms_internal_zzlu, String str, String str2) throws RemoteException;
}
