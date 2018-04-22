package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        private static class zza implements zzd {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(MessageWrapper messageWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (messageWrapper != null) {
                        obtain.writeInt(1);
                        messageWrapper.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(MessageWrapper[] messageWrapperArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    obtain.writeTypedArray(messageWrapperArr, 0);
                    this.zzoz.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(MessageWrapper messageWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (messageWrapper != null) {
                        obtain.writeInt(1);
                        messageWrapper.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.nearby.messages.internal.IMessageListener");
        }

        public static zzd zzdy(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new zza(iBinder) : (zzd) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            MessageWrapper messageWrapper = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (data.readInt() != 0) {
                        messageWrapper = MessageWrapper.CREATOR.zzgk(data);
                    }
                    zza(messageWrapper);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (data.readInt() != 0) {
                        messageWrapper = MessageWrapper.CREATOR.zzgk(data);
                    }
                    zzb(messageWrapper);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    zza((MessageWrapper[]) data.createTypedArray(MessageWrapper.CREATOR));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(MessageWrapper messageWrapper) throws RemoteException;

    void zza(MessageWrapper[] messageWrapperArr) throws RemoteException;

    void zzb(MessageWrapper messageWrapper) throws RemoteException;
}
