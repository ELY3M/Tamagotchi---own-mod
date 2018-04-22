package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzqf extends IInterface {

    public static abstract class zza extends Binder implements zzqf {

        private static class zza implements zzqf {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void onError(int errorCode) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
                    obtain.writeInt(errorCode);
                    this.zzoz.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzs(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
                    obtain.writeByteArray(bArr);
                    this.zzoz.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzqf zzdr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzqf)) ? new zza(iBinder) : (zzqf) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
                    zzs(data.createByteArray());
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
                    onError(data.readInt());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onError(int i) throws RemoteException;

    void zzs(byte[] bArr) throws RemoteException;
}
