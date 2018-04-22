package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGamesClient extends IInterface {

    public static abstract class Stub extends Binder implements IGamesClient {

        private static class Proxy implements IGamesClient {
            private IBinder zzoz;

            Proxy(IBinder remote) {
                this.zzoz = remote;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public PopupLocationInfoParcelable zzws() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesClient");
                    this.zzoz.transact(1001, obtain, obtain2, 0);
                    obtain2.readException();
                    PopupLocationInfoParcelable zzem = obtain2.readInt() != 0 ? PopupLocationInfoParcelable.CREATOR.zzem(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return zzem;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesClient");
        }

        public static IGamesClient zzbX(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesClient");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesClient)) ? new Proxy(iBinder) : (IGamesClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesClient");
                    PopupLocationInfoParcelable zzws = zzws();
                    reply.writeNoException();
                    if (zzws != null) {
                        reply.writeInt(1);
                        zzws.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesClient");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    PopupLocationInfoParcelable zzws() throws RemoteException;
}
