package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.Device;

public interface zzqi extends IInterface {

    public static abstract class zza extends Binder implements zzqi {

        private static class zza implements zzqi {
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
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
                    obtain.writeInt(errorCode);
                    this.zzoz.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onScanStopped() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
                    this.zzoz.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Device device) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzqi zzdu(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzqi)) ? new zza(iBinder) : (zzqi) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
                    zza(data.readInt() != 0 ? (Device) Device.CREATOR.createFromParcel(data) : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
                    onScanStopped();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
                    onError(data.readInt());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onError(int i) throws RemoteException;

    void onScanStopped() throws RemoteException;

    void zza(Device device) throws RemoteException;
}
