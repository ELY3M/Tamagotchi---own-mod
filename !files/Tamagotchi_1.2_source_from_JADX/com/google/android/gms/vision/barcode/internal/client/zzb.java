package com.google.android.gms.vision.barcode.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

public interface zzb extends IInterface {

    public static abstract class zza extends Binder implements zzb {

        private static class zza implements zzb {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public Barcode[] zza(zzd com_google_android_gms_dynamic_zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (frameMetadataParcel != null) {
                        obtain.writeInt(1);
                        frameMetadataParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    Barcode[] barcodeArr = (Barcode[]) obtain2.createTypedArray(Barcode.CREATOR);
                    return barcodeArr;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Barcode[] zzb(zzd com_google_android_gms_dynamic_zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (frameMetadataParcel != null) {
                        obtain.writeInt(1);
                        frameMetadataParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    Barcode[] barcodeArr = (Barcode[]) obtain2.createTypedArray(Barcode.CREATOR);
                    return barcodeArr;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzb zzed(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzb)) ? new zza(iBinder) : (zzb) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            FrameMetadataParcel frameMetadataParcel = null;
            zzd zzbs;
            Parcelable[] zza;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    zzbs = com.google.android.gms.dynamic.zzd.zza.zzbs(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        frameMetadataParcel = FrameMetadataParcel.CREATOR.zzhn(data);
                    }
                    zza = zza(zzbs, frameMetadataParcel);
                    reply.writeNoException();
                    reply.writeTypedArray(zza, 1);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    zzbs = com.google.android.gms.dynamic.zzd.zza.zzbs(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        frameMetadataParcel = FrameMetadataParcel.CREATOR.zzhn(data);
                    }
                    zza = zzb(zzbs, frameMetadataParcel);
                    reply.writeNoException();
                    reply.writeTypedArray(zza, 1);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    Barcode[] zza(zzd com_google_android_gms_dynamic_zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException;

    Barcode[] zzb(zzd com_google_android_gms_dynamic_zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException;
}
