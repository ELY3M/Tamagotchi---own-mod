package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Request;
import com.google.android.gms.appdatasearch.UsageInfo;

public interface zzkf extends IInterface {

    public static abstract class zza extends Binder implements zzkf {

        private static class zza implements zzkf {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(Request request, zzkg com_google_android_gms_internal_zzkg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzkg != null ? com_google_android_gms_internal_zzkg.asBinder() : null);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzkg com_google_android_gms_internal_zzkg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzkg != null ? com_google_android_gms_internal_zzkg.asBinder() : null);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzkg com_google_android_gms_internal_zzkg, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzkg != null ? com_google_android_gms_internal_zzkg.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzkg com_google_android_gms_internal_zzkg, String str, UsageInfo[] usageInfoArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzkg != null ? com_google_android_gms_internal_zzkg.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeTypedArray(usageInfoArr, 0);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzkg com_google_android_gms_internal_zzkg, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzkg != null ? com_google_android_gms_internal_zzkg.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzkg com_google_android_gms_internal_zzkg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzkg != null ? com_google_android_gms_internal_zzkg.asBinder() : null);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzkf zzag(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzkf)) ? new zza(iBinder) : (zzkf) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzkg.zza.zzah(data.readStrongBinder()), data.readString(), (UsageInfo[]) data.createTypedArray(UsageInfo.CREATOR));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzkg.zza.zzah(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zzb(com.google.android.gms.internal.zzkg.zza.zzah(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzkg.zza.zzah(data.readStrongBinder()), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(data.readInt() != 0 ? Request.CREATOR.zzv(data) : null, com.google.android.gms.internal.zzkg.zza.zzah(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzkg.zza.zzah(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(Request request, zzkg com_google_android_gms_internal_zzkg) throws RemoteException;

    void zza(zzkg com_google_android_gms_internal_zzkg) throws RemoteException;

    void zza(zzkg com_google_android_gms_internal_zzkg, String str, String str2) throws RemoteException;

    void zza(zzkg com_google_android_gms_internal_zzkg, String str, UsageInfo[] usageInfoArr) throws RemoteException;

    void zza(zzkg com_google_android_gms_internal_zzkg, boolean z) throws RemoteException;

    void zzb(zzkg com_google_android_gms_internal_zzkg) throws RemoteException;
}
