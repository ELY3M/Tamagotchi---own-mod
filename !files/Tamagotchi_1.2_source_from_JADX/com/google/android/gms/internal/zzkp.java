package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzkp extends IInterface {

    public static abstract class zza extends Binder implements zzkp {

        private static class zza implements zzkp {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzko com_google_android_gms_internal_zzko) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzko != null ? com_google_android_gms_internal_zzko.asBinder() : null);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzko com_google_android_gms_internal_zzko, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzko != null ? com_google_android_gms_internal_zzko.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzko com_google_android_gms_internal_zzko, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzko != null ? com_google_android_gms_internal_zzko.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzkp zzal(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzkp)) ? new zza(iBinder) : (zzkp) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
                    zzb(com.google.android.gms.internal.zzko.zza.zzak(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
                    zza(com.google.android.gms.internal.zzko.zza.zzak(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
                    zza(com.google.android.gms.internal.zzko.zza.zzak(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appinvite.internal.IAppInviteService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzko com_google_android_gms_internal_zzko) throws RemoteException;

    void zza(zzko com_google_android_gms_internal_zzko, String str) throws RemoteException;

    void zzb(zzko com_google_android_gms_internal_zzko, String str) throws RemoteException;
}
