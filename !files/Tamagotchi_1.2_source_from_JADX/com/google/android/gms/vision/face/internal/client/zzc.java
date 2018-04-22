package com.google.android.gms.vision.face.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {

        private static class zza implements zzc {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zzIh() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public FaceParcel[] zzc(zzd com_google_android_gms_dynamic_zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (frameMetadataParcel != null) {
                        obtain.writeInt(1);
                        frameMetadataParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    FaceParcel[] faceParcelArr = (FaceParcel[]) obtain2.createTypedArray(FaceParcel.CREATOR);
                    return faceParcelArr;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzkJ(int i) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    obtain.writeInt(i);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzc zzeg(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new zza(iBinder) : (zzc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    Parcelable[] zzc = zzc(com.google.android.gms.dynamic.zzd.zza.zzbs(data.readStrongBinder()), data.readInt() != 0 ? FrameMetadataParcel.CREATOR.zzhn(data) : null);
                    reply.writeNoException();
                    reply.writeTypedArray(zzc, 1);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    boolean zzkJ = zzkJ(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(zzkJ ? 1 : 0);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    zzIh();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzIh() throws RemoteException;

    FaceParcel[] zzc(zzd com_google_android_gms_dynamic_zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException;

    boolean zzkJ(int i) throws RemoteException;
}
