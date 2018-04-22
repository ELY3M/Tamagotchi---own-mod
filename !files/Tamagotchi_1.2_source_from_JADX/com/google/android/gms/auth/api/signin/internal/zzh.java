package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;

public interface zzh extends IInterface {

    public static abstract class zza extends Binder implements zzh {

        private static class zza implements zzh {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzg com_google_android_gms_auth_api_signin_internal_zzg, GoogleSignInOptions googleSignInOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zzg != null ? com_google_android_gms_auth_api_signin_internal_zzg.asBinder() : null);
                    if (googleSignInOptions != null) {
                        obtain.writeInt(1);
                        googleSignInOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(101, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzg com_google_android_gms_auth_api_signin_internal_zzg, SignInConfiguration signInConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zzg != null ? com_google_android_gms_auth_api_signin_internal_zzg.asBinder() : null);
                    if (signInConfiguration != null) {
                        obtain.writeInt(1);
                        signInConfiguration.writeToParcel(obtain, 0);
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

            public void zza(zzg com_google_android_gms_auth_api_signin_internal_zzg, SignInConfiguration signInConfiguration, SignInAccount signInAccount, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zzg != null ? com_google_android_gms_auth_api_signin_internal_zzg.asBinder() : null);
                    if (signInConfiguration != null) {
                        obtain.writeInt(1);
                        signInConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (signInAccount != null) {
                        obtain.writeInt(1);
                        signInAccount.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzg com_google_android_gms_auth_api_signin_internal_zzg, GoogleSignInOptions googleSignInOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zzg != null ? com_google_android_gms_auth_api_signin_internal_zzg.asBinder() : null);
                    if (googleSignInOptions != null) {
                        obtain.writeInt(1);
                        googleSignInOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(102, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzg com_google_android_gms_auth_api_signin_internal_zzg, SignInConfiguration signInConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zzg != null ? com_google_android_gms_auth_api_signin_internal_zzg.asBinder() : null);
                    if (signInConfiguration != null) {
                        obtain.writeInt(1);
                        signInConfiguration.writeToParcel(obtain, 0);
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

            public void zzc(zzg com_google_android_gms_auth_api_signin_internal_zzg, GoogleSignInOptions googleSignInOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zzg != null ? com_google_android_gms_auth_api_signin_internal_zzg.asBinder() : null);
                    if (googleSignInOptions != null) {
                        obtain.writeInt(1);
                        googleSignInOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(103, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzh zzaD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzh)) ? new zza(iBinder) : (zzh) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zza(com.google.android.gms.auth.api.signin.internal.zzg.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzb(com.google.android.gms.auth.api.signin.internal.zzg.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zza(com.google.android.gms.auth.api.signin.internal.zzg.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (SignInAccount) SignInAccount.CREATOR.createFromParcel(data) : null, data.readString());
                    reply.writeNoException();
                    return true;
                case 101:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zza(com.google.android.gms.auth.api.signin.internal.zzg.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 102:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzb(com.google.android.gms.auth.api.signin.internal.zzg.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 103:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzc(com.google.android.gms.auth.api.signin.internal.zzg.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzg com_google_android_gms_auth_api_signin_internal_zzg, GoogleSignInOptions googleSignInOptions) throws RemoteException;

    void zza(zzg com_google_android_gms_auth_api_signin_internal_zzg, SignInConfiguration signInConfiguration) throws RemoteException;

    void zza(zzg com_google_android_gms_auth_api_signin_internal_zzg, SignInConfiguration signInConfiguration, SignInAccount signInAccount, String str) throws RemoteException;

    void zzb(zzg com_google_android_gms_auth_api_signin_internal_zzg, GoogleSignInOptions googleSignInOptions) throws RemoteException;

    void zzb(zzg com_google_android_gms_auth_api_signin_internal_zzg, SignInConfiguration signInConfiguration) throws RemoteException;

    void zzc(zzg com_google_android_gms_auth_api_signin_internal_zzg, GoogleSignInOptions googleSignInOptions) throws RemoteException;
}
