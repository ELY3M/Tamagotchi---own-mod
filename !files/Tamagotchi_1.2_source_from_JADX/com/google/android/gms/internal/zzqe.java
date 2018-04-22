package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.Device;

public interface zzqe extends IInterface {

    public static abstract class zza extends Binder implements zzqe {

        private static class zza implements zzqe {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void onDisconnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    this.zzoz.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onError(int errorCode) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    obtain.writeInt(errorCode);
                    this.zzoz.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzEc() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    this.zzoz.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Device device, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.zzoz.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzfw(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    obtain.writeString(str);
                    this.zzoz.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzfx(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    obtain.writeString(str);
                    this.zzoz.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzqe zzdq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzqe)) ? new zza(iBinder) : (zzqe) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    zza(data.readInt() != 0 ? (Device) Device.CREATOR.createFromParcel(data) : null, data.createByteArray());
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    onDisconnected();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    onError(data.readInt());
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    zzfw(data.readString());
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    zzEc();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    zzfx(data.readString());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onDisconnected() throws RemoteException;

    void onError(int i) throws RemoteException;

    void zzEc() throws RemoteException;

    void zza(Device device, byte[] bArr) throws RemoteException;

    void zzfw(String str) throws RemoteException;

    void zzfx(String str) throws RemoteException;
}
