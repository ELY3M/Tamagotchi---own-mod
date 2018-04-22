package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.AppMetadata;

public interface zzqn extends IInterface {

    public static abstract class zza extends Binder implements zzqn {

        private static class zza implements zzqn {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public String zzEk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    this.zzoz.transact(Place.TYPE_POSTAL_CODE_PREFIX, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzF(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_POST_BOX, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzqm com_google_android_gms_internal_zzqm, int i, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzqm != null ? com_google_android_gms_internal_zzqm.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zzoz.transact(Place.TYPE_COUNTRY, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzqm com_google_android_gms_internal_zzqm, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzqm != null ? com_google_android_gms_internal_zzqm.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_LOCALITY, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzqm com_google_android_gms_internal_zzqm, String str, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzqm != null ? com_google_android_gms_internal_zzqm.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zzoz.transact(Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzqm com_google_android_gms_internal_zzqm, String str, AppMetadata appMetadata, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzqm != null ? com_google_android_gms_internal_zzqm.asBinder() : null);
                    obtain.writeString(str);
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zzoz.transact(1001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzqm com_google_android_gms_internal_zzqm, String str, String str2, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzqm != null ? com_google_android_gms_internal_zzqm.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zzoz.transact(1007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzqm com_google_android_gms_internal_zzqm, String str, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzqm != null ? com_google_android_gms_internal_zzqm.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_INTERSECTION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String[] strArr, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStringArray(strArr);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_NATURAL_FEATURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzag(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zzoz.transact(1002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzah(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_FLOOR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzai(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_POINT_OF_INTEREST, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzaj(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_POSTAL_CODE, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String[] strArr, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStringArray(strArr);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_NEIGHBORHOOD, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_COLLOQUIAL_AREA, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_POLITICAL, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzqn zzdx(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzqn)) ? new zza(iBinder) : (zzqn) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String zzaj;
            switch (code) {
                case 1001:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzqm.zza.zzdw(data.readStrongBinder()), data.readString(), data.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(data) : null, data.readLong(), data.readLong());
                    reply.writeNoException();
                    return true;
                case 1002:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzag(data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3 /*1003*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzqm.zza.zzdw(data.readStrongBinder()), data.readString(), data.readLong(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_COLLOQUIAL_AREA /*1004*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzh(data.readString(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_COUNTRY /*1005*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzqm.zza.zzdw(data.readStrongBinder()), data.readInt(), data.readLong(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FLOOR /*1006*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzah(data.readLong());
                    reply.writeNoException();
                    return true;
                case 1007:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzqm.zza.zzdw(data.readStrongBinder()), data.readString(), data.readString(), data.createByteArray(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_INTERSECTION /*1008*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzqm.zza.zzdw(data.readStrongBinder()), data.readString(), data.createByteArray(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_LOCALITY /*1009*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzqm.zza.zzdw(data.readStrongBinder()), data.readString(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_NATURAL_FEATURE /*1010*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(data.createStringArray(), data.createByteArray(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_NEIGHBORHOOD /*1011*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzb(data.createStringArray(), data.createByteArray(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POLITICAL /*1012*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzi(data.readString(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POINT_OF_INTEREST /*1013*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzai(data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POST_BOX /*1014*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzF(data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POSTAL_CODE /*1015*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzaj = zzaj(data.readLong());
                    reply.writeNoException();
                    reply.writeString(zzaj);
                    return true;
                case Place.TYPE_POSTAL_CODE_PREFIX /*1016*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzaj = zzEk();
                    reply.writeNoException();
                    reply.writeString(zzaj);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    String zzEk() throws RemoteException;

    void zzF(long j) throws RemoteException;

    void zza(zzqm com_google_android_gms_internal_zzqm, int i, long j, long j2) throws RemoteException;

    void zza(zzqm com_google_android_gms_internal_zzqm, String str, long j) throws RemoteException;

    void zza(zzqm com_google_android_gms_internal_zzqm, String str, long j, long j2) throws RemoteException;

    void zza(zzqm com_google_android_gms_internal_zzqm, String str, AppMetadata appMetadata, long j, long j2) throws RemoteException;

    void zza(zzqm com_google_android_gms_internal_zzqm, String str, String str2, byte[] bArr, long j) throws RemoteException;

    void zza(zzqm com_google_android_gms_internal_zzqm, String str, byte[] bArr, long j) throws RemoteException;

    void zza(String[] strArr, byte[] bArr, long j) throws RemoteException;

    void zzag(long j) throws RemoteException;

    void zzah(long j) throws RemoteException;

    void zzai(long j) throws RemoteException;

    String zzaj(long j) throws RemoteException;

    void zzb(String[] strArr, byte[] bArr, long j) throws RemoteException;

    void zzh(String str, long j) throws RemoteException;

    void zzi(String str, long j) throws RemoteException;
}
