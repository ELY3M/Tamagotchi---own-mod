package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzqm.zza;
import com.google.android.gms.nearby.connection.AppMetadata;

public abstract class zzqj extends zza {
    public void onConnectionRequest(String remoteEndpointId, String remoteDeviceId, String remoteEndpointName, byte[] payload) throws RemoteException {
    }

    public void onDisconnected(String remoteEndpointId) throws RemoteException {
    }

    public void onEndpointFound(String endpointId, String deviceId, String applicationId, String name) throws RemoteException {
    }

    public void onEndpointLost(String endpointId) throws RemoteException {
    }

    public void onMessageReceived(String remoteEndpointId, byte[] payload, boolean isReliable) throws RemoteException {
    }

    public void zza(String str, int i, byte[] bArr) throws RemoteException {
    }

    public void zza(String str, String str2, String str3, String str4, AppMetadata appMetadata) throws RemoteException {
    }

    public void zzfy(String str) throws RemoteException {
    }

    public void zziW(int i) throws RemoteException {
    }

    public void zziX(int i) throws RemoteException {
    }

    public void zziY(int i) throws RemoteException {
    }

    public void zziZ(int i) throws RemoteException {
    }

    public void zzja(int i) throws RemoteException {
    }

    public void zzm(int i, String str) throws RemoteException {
    }
}
