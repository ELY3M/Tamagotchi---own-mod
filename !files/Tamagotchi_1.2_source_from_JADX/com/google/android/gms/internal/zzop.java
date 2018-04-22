package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;

public interface zzop extends IInterface {

    public static abstract class zza extends Binder implements zzop {

        private static class zza implements zzop {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(DataSourcesRequest dataSourcesRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (dataSourcesRequest != null) {
                        obtain.writeInt(1);
                        dataSourcesRequest.writeToParcel(obtain, 0);
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

            public void zza(SensorRegistrationRequest sensorRegistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (sensorRegistrationRequest != null) {
                        obtain.writeInt(1);
                        sensorRegistrationRequest.writeToParcel(obtain, 0);
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

            public void zza(SensorUnregistrationRequest sensorUnregistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (sensorUnregistrationRequest != null) {
                        obtain.writeInt(1);
                        sensorUnregistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzop zzbK(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzop)) ? new zza(iBinder) : (zzop) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            SensorUnregistrationRequest sensorUnregistrationRequest = null;
            switch (code) {
                case 1:
                    DataSourcesRequest dataSourcesRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (data.readInt() != 0) {
                        dataSourcesRequest = (DataSourcesRequest) DataSourcesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataSourcesRequest);
                    reply.writeNoException();
                    return true;
                case 2:
                    SensorRegistrationRequest sensorRegistrationRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (data.readInt() != 0) {
                        sensorRegistrationRequest = (SensorRegistrationRequest) SensorRegistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sensorRegistrationRequest);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (data.readInt() != 0) {
                        sensorUnregistrationRequest = (SensorUnregistrationRequest) SensorUnregistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sensorUnregistrationRequest);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(DataSourcesRequest dataSourcesRequest) throws RemoteException;

    void zza(SensorRegistrationRequest sensorRegistrationRequest) throws RemoteException;

    void zza(SensorUnregistrationRequest sensorUnregistrationRequest) throws RemoteException;
}
