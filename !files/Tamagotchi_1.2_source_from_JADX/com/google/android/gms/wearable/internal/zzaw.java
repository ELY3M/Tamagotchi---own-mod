package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import java.util.List;

public interface zzaw extends IInterface {

    public static abstract class zza extends Binder implements zzaw {

        private static class zza implements zzaw {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void onConnectedNodes(List<NodeParcelable> connectedNodes) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    obtain.writeTypedList(connectedNodes);
                    this.zzoz.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (amsEntityUpdateParcelable != null) {
                        obtain.writeInt(1);
                        amsEntityUpdateParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(CapabilityInfoParcelable capabilityInfoParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (capabilityInfoParcelable != null) {
                        obtain.writeInt(1);
                        capabilityInfoParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ChannelEventParcelable channelEventParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (channelEventParcelable != null) {
                        obtain.writeInt(1);
                        channelEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(MessageEventParcelable messageEventParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (messageEventParcelable != null) {
                        obtain.writeInt(1);
                        messageEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(NodeParcelable nodeParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (nodeParcelable != null) {
                        obtain.writeInt(1);
                        nodeParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzag(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(NodeParcelable nodeParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (nodeParcelable != null) {
                        obtain.writeInt(1);
                        nodeParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
        }

        public static zzaw zzet(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaw)) ? new zza(iBinder) : (zzaw) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            AmsEntityUpdateParcelable amsEntityUpdateParcelable = null;
            NodeParcelable nodeParcelable;
            switch (code) {
                case 1:
                    DataHolder zzak;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        zzak = DataHolder.CREATOR.zzak(data);
                    }
                    zzag(zzak);
                    return true;
                case 2:
                    MessageEventParcelable messageEventParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        messageEventParcelable = (MessageEventParcelable) MessageEventParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(messageEventParcelable);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        nodeParcelable = (NodeParcelable) NodeParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(nodeParcelable);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        nodeParcelable = (NodeParcelable) NodeParcelable.CREATOR.createFromParcel(data);
                    }
                    zzb(nodeParcelable);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    onConnectedNodes(data.createTypedArrayList(NodeParcelable.CREATOR));
                    return true;
                case 6:
                    AncsNotificationParcelable ancsNotificationParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        ancsNotificationParcelable = (AncsNotificationParcelable) AncsNotificationParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(ancsNotificationParcelable);
                    return true;
                case 7:
                    ChannelEventParcelable channelEventParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        channelEventParcelable = (ChannelEventParcelable) ChannelEventParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(channelEventParcelable);
                    return true;
                case 8:
                    CapabilityInfoParcelable capabilityInfoParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        capabilityInfoParcelable = (CapabilityInfoParcelable) CapabilityInfoParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(capabilityInfoParcelable);
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) AmsEntityUpdateParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(amsEntityUpdateParcelable);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onConnectedNodes(List<NodeParcelable> list) throws RemoteException;

    void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) throws RemoteException;

    void zza(AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException;

    void zza(CapabilityInfoParcelable capabilityInfoParcelable) throws RemoteException;

    void zza(ChannelEventParcelable channelEventParcelable) throws RemoteException;

    void zza(MessageEventParcelable messageEventParcelable) throws RemoteException;

    void zza(NodeParcelable nodeParcelable) throws RemoteException;

    void zzag(DataHolder dataHolder) throws RemoteException;

    void zzb(NodeParcelable nodeParcelable) throws RemoteException;
}
