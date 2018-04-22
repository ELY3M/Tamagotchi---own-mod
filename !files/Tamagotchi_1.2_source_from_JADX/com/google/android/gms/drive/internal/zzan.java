package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.realtime.internal.zzm;

public interface zzan extends IInterface {

    public static abstract class zza extends Binder implements zzan {

        private static class zza implements zzan {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void onError(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
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

            public void onSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ChangeSequenceNumber changeSequenceNumber) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (changeSequenceNumber != null) {
                        obtain.writeInt(1);
                        changeSequenceNumber.writeToParcel(obtain, 0);
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

            public void zza(GetPermissionsResponse getPermissionsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (getPermissionsResponse != null) {
                        obtain.writeInt(1);
                        getPermissionsResponse.writeToParcel(obtain, 0);
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

            public void zza(OnChangesResponse onChangesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onChangesResponse != null) {
                        obtain.writeInt(1);
                        onChangesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onContentsResponse != null) {
                        obtain.writeInt(1);
                        onContentsResponse.writeToParcel(obtain, 0);
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

            public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDeviceUsagePreferenceResponse != null) {
                        obtain.writeInt(1);
                        onDeviceUsagePreferenceResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDownloadProgressResponse != null) {
                        obtain.writeInt(1);
                        onDownloadProgressResponse.writeToParcel(obtain, 0);
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

            public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDriveIdResponse != null) {
                        obtain.writeInt(1);
                        onDriveIdResponse.writeToParcel(obtain, 0);
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

            public void zza(OnFetchThumbnailResponse onFetchThumbnailResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onFetchThumbnailResponse != null) {
                        obtain.writeInt(1);
                        onFetchThumbnailResponse.writeToParcel(obtain, 0);
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

            public void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onListEntriesResponse != null) {
                        obtain.writeInt(1);
                        onListEntriesResponse.writeToParcel(obtain, 0);
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

            public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onListParentsResponse != null) {
                        obtain.writeInt(1);
                        onListParentsResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnLoadRealtimeResponse onLoadRealtimeResponse, zzm com_google_android_gms_drive_realtime_internal_zzm) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onLoadRealtimeResponse != null) {
                        obtain.writeInt(1);
                        onLoadRealtimeResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzm != null ? com_google_android_gms_drive_realtime_internal_zzm.asBinder() : null);
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onMetadataResponse != null) {
                        obtain.writeInt(1);
                        onMetadataResponse.writeToParcel(obtain, 0);
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

            public void zza(OnPinnedDownloadPreferencesResponse onPinnedDownloadPreferencesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onPinnedDownloadPreferencesResponse != null) {
                        obtain.writeInt(1);
                        onPinnedDownloadPreferencesResponse.writeToParcel(obtain, 0);
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

            public void zza(OnResourceIdSetResponse onResourceIdSetResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onResourceIdSetResponse != null) {
                        obtain.writeInt(1);
                        onResourceIdSetResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnStartStreamSession onStartStreamSession) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onStartStreamSession != null) {
                        obtain.writeInt(1);
                        onStartStreamSession.writeToParcel(obtain, 0);
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

            public void zza(OnSyncMoreResponse onSyncMoreResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onSyncMoreResponse != null) {
                        obtain.writeInt(1);
                        onSyncMoreResponse.writeToParcel(obtain, 0);
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

            public void zza(StringListResponse stringListResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (stringListResponse != null) {
                        obtain.writeInt(1);
                        stringListResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaf(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        }

        public static zzan zzbb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzan)) ? new zza(iBinder) : (zzan) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            OnStartStreamSession onStartStreamSession = null;
            switch (code) {
                case 1:
                    OnDownloadProgressResponse onDownloadProgressResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onDownloadProgressResponse = (OnDownloadProgressResponse) OnDownloadProgressResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onDownloadProgressResponse);
                    reply.writeNoException();
                    return true;
                case 2:
                    OnListEntriesResponse onListEntriesResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onListEntriesResponse = (OnListEntriesResponse) OnListEntriesResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onListEntriesResponse);
                    reply.writeNoException();
                    return true;
                case 3:
                    OnDriveIdResponse onDriveIdResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onDriveIdResponse = (OnDriveIdResponse) OnDriveIdResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onDriveIdResponse);
                    reply.writeNoException();
                    return true;
                case 4:
                    OnMetadataResponse onMetadataResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onMetadataResponse = (OnMetadataResponse) OnMetadataResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onMetadataResponse);
                    reply.writeNoException();
                    return true;
                case 5:
                    OnContentsResponse onContentsResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onContentsResponse = (OnContentsResponse) OnContentsResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onContentsResponse);
                    reply.writeNoException();
                    return true;
                case 6:
                    Status status;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        status = (Status) Status.CREATOR.createFromParcel(data);
                    }
                    onError(status);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    onSuccess();
                    reply.writeNoException();
                    return true;
                case 8:
                    OnListParentsResponse onListParentsResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onListParentsResponse = (OnListParentsResponse) OnListParentsResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onListParentsResponse);
                    reply.writeNoException();
                    return true;
                case 9:
                    OnSyncMoreResponse onSyncMoreResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onSyncMoreResponse = (OnSyncMoreResponse) OnSyncMoreResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onSyncMoreResponse);
                    reply.writeNoException();
                    return true;
                case 11:
                    OnLoadRealtimeResponse onLoadRealtimeResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onLoadRealtimeResponse = (OnLoadRealtimeResponse) OnLoadRealtimeResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onLoadRealtimeResponse, com.google.android.gms.drive.realtime.internal.zzm.zza.zzbo(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 12:
                    OnResourceIdSetResponse onResourceIdSetResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onResourceIdSetResponse = (OnResourceIdSetResponse) OnResourceIdSetResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onResourceIdSetResponse);
                    reply.writeNoException();
                    return true;
                case 13:
                    OnPinnedDownloadPreferencesResponse onPinnedDownloadPreferencesResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onPinnedDownloadPreferencesResponse = (OnPinnedDownloadPreferencesResponse) OnPinnedDownloadPreferencesResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onPinnedDownloadPreferencesResponse);
                    reply.writeNoException();
                    return true;
                case 14:
                    OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onDeviceUsagePreferenceResponse = (OnDeviceUsagePreferenceResponse) OnDeviceUsagePreferenceResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onDeviceUsagePreferenceResponse);
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    zzaf(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 16:
                    OnFetchThumbnailResponse onFetchThumbnailResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onFetchThumbnailResponse = (OnFetchThumbnailResponse) OnFetchThumbnailResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onFetchThumbnailResponse);
                    reply.writeNoException();
                    return true;
                case 17:
                    ChangeSequenceNumber changeSequenceNumber;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        changeSequenceNumber = (ChangeSequenceNumber) ChangeSequenceNumber.CREATOR.createFromParcel(data);
                    }
                    zza(changeSequenceNumber);
                    reply.writeNoException();
                    return true;
                case 18:
                    OnChangesResponse onChangesResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onChangesResponse = (OnChangesResponse) OnChangesResponse.CREATOR.createFromParcel(data);
                    }
                    zza(onChangesResponse);
                    reply.writeNoException();
                    return true;
                case 20:
                    GetPermissionsResponse getPermissionsResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        getPermissionsResponse = (GetPermissionsResponse) GetPermissionsResponse.CREATOR.createFromParcel(data);
                    }
                    zza(getPermissionsResponse);
                    reply.writeNoException();
                    return true;
                case 21:
                    StringListResponse stringListResponse;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        stringListResponse = (StringListResponse) StringListResponse.CREATOR.createFromParcel(data);
                    }
                    zza(stringListResponse);
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (data.readInt() != 0) {
                        onStartStreamSession = (OnStartStreamSession) OnStartStreamSession.CREATOR.createFromParcel(data);
                    }
                    zza(onStartStreamSession);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onError(Status status) throws RemoteException;

    void onSuccess() throws RemoteException;

    void zza(ChangeSequenceNumber changeSequenceNumber) throws RemoteException;

    void zza(GetPermissionsResponse getPermissionsResponse) throws RemoteException;

    void zza(OnChangesResponse onChangesResponse) throws RemoteException;

    void zza(OnContentsResponse onContentsResponse) throws RemoteException;

    void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException;

    void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException;

    void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException;

    void zza(OnFetchThumbnailResponse onFetchThumbnailResponse) throws RemoteException;

    void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException;

    void zza(OnListParentsResponse onListParentsResponse) throws RemoteException;

    void zza(OnLoadRealtimeResponse onLoadRealtimeResponse, zzm com_google_android_gms_drive_realtime_internal_zzm) throws RemoteException;

    void zza(OnMetadataResponse onMetadataResponse) throws RemoteException;

    void zza(OnPinnedDownloadPreferencesResponse onPinnedDownloadPreferencesResponse) throws RemoteException;

    void zza(OnResourceIdSetResponse onResourceIdSetResponse) throws RemoteException;

    void zza(OnStartStreamSession onStartStreamSession) throws RemoteException;

    void zza(OnSyncMoreResponse onSyncMoreResponse) throws RemoteException;

    void zza(StringListResponse stringListResponse) throws RemoteException;

    void zzaf(boolean z) throws RemoteException;
}
