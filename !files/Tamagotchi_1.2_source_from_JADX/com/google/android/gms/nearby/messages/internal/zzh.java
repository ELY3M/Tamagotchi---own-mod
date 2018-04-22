package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzh extends IInterface {

    public static abstract class zza extends Binder implements zzh {

        private static class zza implements zzh {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void onPermissionChanged(boolean permissionGranted) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IStatusCallback");
                    if (!permissionGranted) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.nearby.messages.internal.IStatusCallback");
        }

        public static zzh zzdC(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzh)) ? new zza(iBinder) : (zzh) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
                    onPermissionChanged(data.readInt() != 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.messages.internal.IStatusCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onPermissionChanged(boolean z) throws RemoteException;
}
