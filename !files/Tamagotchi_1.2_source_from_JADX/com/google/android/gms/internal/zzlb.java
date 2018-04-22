package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

public interface zzlb extends IInterface {

    public static abstract class zza extends Binder implements zzlb {

        private static class zza implements zzlb {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzla com_google_android_gms_internal_zzla, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzla != null ? com_google_android_gms_internal_zzla.asBinder() : null);
                    if (proxyGrpcRequest != null) {
                        obtain.writeInt(1);
                        proxyGrpcRequest.writeToParcel(obtain, 0);
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

            public void zza(zzla com_google_android_gms_internal_zzla, ProxyRequest proxyRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzla != null ? com_google_android_gms_internal_zzla.asBinder() : null);
                    if (proxyRequest != null) {
                        obtain.writeInt(1);
                        proxyRequest.writeToParcel(obtain, 0);
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
        }

        public static zzlb zzaA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzlb)) ? new zza(iBinder) : (zzlb) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ProxyGrpcRequest proxyGrpcRequest = null;
            zzla zzaz;
            switch (code) {
                case 1:
                    ProxyRequest proxyRequest;
                    data.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                    zzaz = com.google.android.gms.internal.zzla.zza.zzaz(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        proxyRequest = (ProxyRequest) ProxyRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzaz, proxyRequest);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                    zzaz = com.google.android.gms.internal.zzla.zza.zzaz(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        proxyGrpcRequest = (ProxyGrpcRequest) ProxyGrpcRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzaz, proxyGrpcRequest);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.internal.IAuthService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzla com_google_android_gms_internal_zzla, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException;

    void zza(zzla com_google_android_gms_internal_zzla, ProxyRequest proxyRequest) throws RemoteException;
}
