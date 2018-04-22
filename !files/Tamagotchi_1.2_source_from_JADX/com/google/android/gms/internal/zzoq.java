package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;

public interface zzoq extends IInterface {

    public static abstract class zza extends Binder implements zzoq {

        private static class zza implements zzoq {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(SessionInsertRequest sessionInsertRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionInsertRequest != null) {
                        obtain.writeInt(1);
                        sessionInsertRequest.writeToParcel(obtain, 0);
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

            public void zza(SessionReadRequest sessionReadRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionReadRequest != null) {
                        obtain.writeInt(1);
                        sessionReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SessionRegistrationRequest sessionRegistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionRegistrationRequest != null) {
                        obtain.writeInt(1);
                        sessionRegistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SessionStartRequest sessionStartRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionStartRequest != null) {
                        obtain.writeInt(1);
                        sessionStartRequest.writeToParcel(obtain, 0);
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

            public void zza(SessionStopRequest sessionStopRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionStopRequest != null) {
                        obtain.writeInt(1);
                        sessionStopRequest.writeToParcel(obtain, 0);
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

            public void zza(SessionUnregistrationRequest sessionUnregistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionUnregistrationRequest != null) {
                        obtain.writeInt(1);
                        sessionUnregistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzoq zzbL(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzoq)) ? new zza(iBinder) : (zzoq) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            SessionUnregistrationRequest sessionUnregistrationRequest = null;
            switch (code) {
                case 1:
                    SessionStartRequest sessionStartRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionStartRequest = (SessionStartRequest) SessionStartRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionStartRequest);
                    reply.writeNoException();
                    return true;
                case 2:
                    SessionStopRequest sessionStopRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionStopRequest = (SessionStopRequest) SessionStopRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionStopRequest);
                    reply.writeNoException();
                    return true;
                case 3:
                    SessionInsertRequest sessionInsertRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionInsertRequest = (SessionInsertRequest) SessionInsertRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionInsertRequest);
                    reply.writeNoException();
                    return true;
                case 4:
                    SessionReadRequest sessionReadRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionReadRequest = (SessionReadRequest) SessionReadRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionReadRequest);
                    reply.writeNoException();
                    return true;
                case 5:
                    SessionRegistrationRequest sessionRegistrationRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionRegistrationRequest = (SessionRegistrationRequest) SessionRegistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionRegistrationRequest);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionUnregistrationRequest = (SessionUnregistrationRequest) SessionUnregistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionUnregistrationRequest);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(SessionInsertRequest sessionInsertRequest) throws RemoteException;

    void zza(SessionReadRequest sessionReadRequest) throws RemoteException;

    void zza(SessionRegistrationRequest sessionRegistrationRequest) throws RemoteException;

    void zza(SessionStartRequest sessionStartRequest) throws RemoteException;

    void zza(SessionStopRequest sessionStopRequest) throws RemoteException;

    void zza(SessionUnregistrationRequest sessionUnregistrationRequest) throws RemoteException;
}
