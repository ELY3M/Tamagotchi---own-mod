package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzku extends IInterface {

    public static abstract class zza extends Binder implements zzku {

        private static class zza implements zzku {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(Account account, int i, zzkt com_google_android_gms_internal_zzkt) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzkt != null ? com_google_android_gms_internal_zzkt.asBinder() : null);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzku zzas(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzku)) ? new zza(iBinder) : (zzku) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
                    zza(data.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(data) : null, data.readInt(), com.google.android.gms.internal.zzkt.zza.zzar(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(Account account, int i, zzkt com_google_android_gms_internal_zzkt) throws RemoteException;
}
