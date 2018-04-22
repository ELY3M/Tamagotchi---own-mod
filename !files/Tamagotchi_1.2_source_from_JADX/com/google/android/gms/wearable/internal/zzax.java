package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;

public interface zzax extends IInterface {

    public static abstract class zza extends Binder implements zzax {

        private static class zza implements zzax {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, byte b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeByte(b);
                    this.zzoz.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzoz.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, Asset asset) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, PutDataRequest putDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
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

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, AddListenerRequest addListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (addListenerRequest != null) {
                        obtain.writeInt(1);
                        addListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, RemoveListenerRequest removeListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (removeListenerRequest != null) {
                        obtain.writeInt(1);
                        removeListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzau != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzau.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zzoz.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zzoz.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_wearable_internal_zzav, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav com_google_android_gms_wearable_internal_zzav, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzoz.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav com_google_android_gms_wearable_internal_zzav, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav com_google_android_gms_wearable_internal_zzav, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav com_google_android_gms_wearable_internal_zzav, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
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

            public void zzb(zzav com_google_android_gms_wearable_internal_zzav, zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzau != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzau.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zzoz.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav com_google_android_gms_wearable_internal_zzav, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav com_google_android_gms_wearable_internal_zzav, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav com_google_android_gms_wearable_internal_zzav, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzav com_google_android_gms_wearable_internal_zzav, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzoz.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzav com_google_android_gms_wearable_internal_zzav, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzav com_google_android_gms_wearable_internal_zzav, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzav com_google_android_gms_wearable_internal_zzav, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzav com_google_android_gms_wearable_internal_zzav, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzav com_google_android_gms_wearable_internal_zzav, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzp(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzav != null ? com_google_android_gms_wearable_internal_zzav.asBinder() : null);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzax zzeu(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzax)) ? new zza(iBinder) : (zzax) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            ConnectionConfiguration connectionConfiguration = null;
            zzav zzes;
            Uri uri;
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(data);
                    }
                    zzb(zzes, connectionConfiguration);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzn(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzo(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzp(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    PutDataRequest putDataRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        putDataRequest = (PutDataRequest) PutDataRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzes, putDataRequest);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zza(zzes, uri);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzb(zzes, uri);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzc(zzes, uri);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readString(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 13:
                    Asset asset;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        asset = (Asset) Asset.CREATOR.createFromParcel(data);
                    }
                    zza(zzes, asset);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    AddListenerRequest addListenerRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        addListenerRequest = (AddListenerRequest) AddListenerRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzes, addListenerRequest);
                    reply.writeNoException();
                    return true;
                case 17:
                    RemoveListenerRequest removeListenerRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        removeListenerRequest = (RemoveListenerRequest) RemoveListenerRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzes, removeListenerRequest);
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(data);
                    }
                    zza(zzes, connectionConfiguration);
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzg(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzh(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 27:
                    AncsNotificationParcelable ancsNotificationParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        ancsNotificationParcelable = (AncsNotificationParcelable) AncsNotificationParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(zzes, ancsNotificationParcelable);
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 29:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 30:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzi(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 31:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 33:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), com.google.android.gms.wearable.internal.zzau.zza.zzer(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 35:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), com.google.android.gms.wearable.internal.zzau.zza.zzer(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 37:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzj(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 38:
                    ParcelFileDescriptor parcelFileDescriptor;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data);
                    }
                    zza(zzes, readString, parcelFileDescriptor);
                    reply.writeNoException();
                    return true;
                case 39:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readString(), data.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data) : null, data.readLong(), data.readLong());
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zza(zzes, uri, data.readInt());
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzes = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzb(zzes, uri, data.readInt());
                    reply.writeNoException();
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 43:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 46:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 47:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 48:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 49:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzk(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 50:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzav zzes2 = com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzb(zzes2, z);
                    reply.writeNoException();
                    return true;
                case 51:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzl(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 52:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzm(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 53:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzav.zza.zzes(data.readStrongBinder()), data.readByte());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, byte b) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, int i) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, Uri uri) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, Uri uri, int i) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, Asset asset) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, PutDataRequest putDataRequest) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, AddListenerRequest addListenerRequest) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, RemoveListenerRequest removeListenerRequest) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, String str) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, String str, int i) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, String str, String str2) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, String str, String str2, byte[] bArr) throws RemoteException;

    void zza(zzav com_google_android_gms_wearable_internal_zzav, boolean z) throws RemoteException;

    void zzb(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzb(zzav com_google_android_gms_wearable_internal_zzav, int i) throws RemoteException;

    void zzb(zzav com_google_android_gms_wearable_internal_zzav, Uri uri) throws RemoteException;

    void zzb(zzav com_google_android_gms_wearable_internal_zzav, Uri uri, int i) throws RemoteException;

    void zzb(zzav com_google_android_gms_wearable_internal_zzav, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zzb(zzav com_google_android_gms_wearable_internal_zzav, zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zzb(zzav com_google_android_gms_wearable_internal_zzav, String str) throws RemoteException;

    void zzb(zzav com_google_android_gms_wearable_internal_zzav, String str, int i) throws RemoteException;

    void zzb(zzav com_google_android_gms_wearable_internal_zzav, boolean z) throws RemoteException;

    void zzc(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzc(zzav com_google_android_gms_wearable_internal_zzav, int i) throws RemoteException;

    void zzc(zzav com_google_android_gms_wearable_internal_zzav, Uri uri) throws RemoteException;

    void zzc(zzav com_google_android_gms_wearable_internal_zzav, String str) throws RemoteException;

    void zzd(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzd(zzav com_google_android_gms_wearable_internal_zzav, String str) throws RemoteException;

    void zze(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zze(zzav com_google_android_gms_wearable_internal_zzav, String str) throws RemoteException;

    void zzf(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzf(zzav com_google_android_gms_wearable_internal_zzav, String str) throws RemoteException;

    void zzg(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzh(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzi(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzj(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzk(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzl(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzm(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzn(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzo(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;

    void zzp(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException;
}
