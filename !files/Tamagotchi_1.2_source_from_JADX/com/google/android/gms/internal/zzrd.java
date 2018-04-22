package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzrd extends IInterface {

    public static abstract class zza extends Binder implements zzrd {

        private static class zza implements zzrd {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzrc com_google_android_gms_internal_zzrc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzrc != null ? com_google_android_gms_internal_zzrc.asBinder() : null);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzrc com_google_android_gms_internal_zzrc, String str, int[] iArr, int i, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzrc != null ? com_google_android_gms_internal_zzrc.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzrc com_google_android_gms_internal_zzrc, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzrc != null ? com_google_android_gms_internal_zzrc.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzrd zzdV(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzrd)) ? new zza(iBinder) : (zzrd) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzrc.zza.zzdU(data.readStrongBinder()), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzrc.zza.zzdU(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzrc.zza.zzdU(data.readStrongBinder()), data.readString(), data.createIntArray(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzrc com_google_android_gms_internal_zzrc) throws RemoteException;

    void zza(zzrc com_google_android_gms_internal_zzrc, String str, int[] iArr, int i, String str2) throws RemoteException;

    void zza(zzrc com_google_android_gms_internal_zzrc, byte[] bArr) throws RemoteException;
}
