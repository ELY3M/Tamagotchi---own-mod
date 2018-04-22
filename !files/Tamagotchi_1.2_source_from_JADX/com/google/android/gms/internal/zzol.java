package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;

public interface zzol extends IInterface {

    public static abstract class zza extends Binder implements zzol {

        private static class zza implements zzol {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(DataTypeCreateRequest dataTypeCreateRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (dataTypeCreateRequest != null) {
                        obtain.writeInt(1);
                        dataTypeCreateRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataTypeReadRequest dataTypeReadRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (dataTypeReadRequest != null) {
                        obtain.writeInt(1);
                        dataTypeReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DisableFitRequest disableFitRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (disableFitRequest != null) {
                        obtain.writeInt(1);
                        disableFitRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzol zzbG(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzol)) ? new zza(iBinder) : (zzol) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DisableFitRequest disableFitRequest = null;
            switch (code) {
                case 1:
                    DataTypeCreateRequest dataTypeCreateRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (data.readInt() != 0) {
                        dataTypeCreateRequest = (DataTypeCreateRequest) DataTypeCreateRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataTypeCreateRequest);
                    reply.writeNoException();
                    return true;
                case 2:
                    DataTypeReadRequest dataTypeReadRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (data.readInt() != 0) {
                        dataTypeReadRequest = (DataTypeReadRequest) DataTypeReadRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataTypeReadRequest);
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (data.readInt() != 0) {
                        disableFitRequest = (DisableFitRequest) DisableFitRequest.CREATOR.createFromParcel(data);
                    }
                    zza(disableFitRequest);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(DataTypeCreateRequest dataTypeCreateRequest) throws RemoteException;

    void zza(DataTypeReadRequest dataTypeReadRequest) throws RemoteException;

    void zza(DisableFitRequest disableFitRequest) throws RemoteException;
}
