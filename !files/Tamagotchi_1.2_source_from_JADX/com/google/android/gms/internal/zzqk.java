package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

public final class zzqk extends zzj<zzqn> {
    private final long zzaEg = ((long) hashCode());

    private static final class zzf implements StartAdvertisingResult {
        private final Status zzUX;
        private final String zzbbm;

        zzf(Status status, String str) {
            this.zzUX = status;
            this.zzbbm = str;
        }

        public String getLocalEndpointName() {
            return this.zzbbm;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static class zzb extends zzqj {
        private final zzq<MessageListener> zzbbb;

        zzb(zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            this.zzbbb = com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_MessageListener;
        }

        public void onDisconnected(final String remoteEndpointId) throws RemoteException {
            this.zzbbb.zza(new com.google.android.gms.common.api.internal.zzq.zzb<MessageListener>(this) {
                final /* synthetic */ zzb zzbbe;

                public void zza(MessageListener messageListener) {
                    messageListener.onDisconnected(remoteEndpointId);
                }

                public void zzpr() {
                }

                public /* synthetic */ void zzt(Object obj) {
                    zza((MessageListener) obj);
                }
            });
        }

        public void onMessageReceived(final String remoteEndpointId, final byte[] payload, final boolean isReliable) throws RemoteException {
            this.zzbbb.zza(new com.google.android.gms.common.api.internal.zzq.zzb<MessageListener>(this) {
                final /* synthetic */ zzb zzbbe;

                public void zza(MessageListener messageListener) {
                    messageListener.onMessageReceived(remoteEndpointId, payload, isReliable);
                }

                public void zzpr() {
                }

                public /* synthetic */ void zzt(Object obj) {
                    zza((MessageListener) obj);
                }
            });
        }
    }

    private static class zzc extends zzqj {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzbbf;

        zzc(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzbbf = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzja(int i) throws RemoteException {
            this.zzbbf.zzs(new Status(i));
        }
    }

    private static final class zze extends zzqj {
        private final com.google.android.gms.common.api.internal.zza.zzb<StartAdvertisingResult> zzamC;
        private final zzq<ConnectionRequestListener> zzbbi;

        zze(com.google.android.gms.common.api.internal.zza.zzb<StartAdvertisingResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, zzq<ConnectionRequestListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) {
            this.zzamC = (com.google.android.gms.common.api.internal.zza.zzb) zzx.zzz(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult);
            this.zzbbi = (zzq) zzx.zzz(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener);
        }

        public void onConnectionRequest(String remoteEndpointId, String remoteDeviceId, String remoteEndpointName, byte[] payload) throws RemoteException {
            final String str = remoteEndpointId;
            final String str2 = remoteDeviceId;
            final String str3 = remoteEndpointName;
            final byte[] bArr = payload;
            this.zzbbi.zza(new com.google.android.gms.common.api.internal.zzq.zzb<ConnectionRequestListener>(this) {
                final /* synthetic */ zze zzbbl;

                public void zza(ConnectionRequestListener connectionRequestListener) {
                    connectionRequestListener.onConnectionRequest(str, str2, str3, bArr);
                }

                public void zzpr() {
                }

                public /* synthetic */ void zzt(Object obj) {
                    zza((ConnectionRequestListener) obj);
                }
            });
        }

        public void zzm(int i, String str) throws RemoteException {
            this.zzamC.zzs(new zzf(new Status(i), str));
        }
    }

    private static final class zzg extends zzqj {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;
        private final zzq<EndpointDiscoveryListener> zzbbi;

        zzg(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, zzq<EndpointDiscoveryListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) {
            this.zzamC = (com.google.android.gms.common.api.internal.zza.zzb) zzx.zzz(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzbbi = (zzq) zzx.zzz(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener);
        }

        public void onEndpointFound(String endpointId, String deviceId, String serviceId, String name) throws RemoteException {
            final String str = endpointId;
            final String str2 = deviceId;
            final String str3 = serviceId;
            final String str4 = name;
            this.zzbbi.zza(new com.google.android.gms.common.api.internal.zzq.zzb<EndpointDiscoveryListener>(this) {
                final /* synthetic */ zzg zzbbq;

                public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointFound(str, str2, str3, str4);
                }

                public void zzpr() {
                }

                public /* synthetic */ void zzt(Object obj) {
                    zza((EndpointDiscoveryListener) obj);
                }
            });
        }

        public void onEndpointLost(final String endpointId) throws RemoteException {
            this.zzbbi.zza(new com.google.android.gms.common.api.internal.zzq.zzb<EndpointDiscoveryListener>(this) {
                final /* synthetic */ zzg zzbbq;

                public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointLost(endpointId);
                }

                public void zzpr() {
                }

                public /* synthetic */ void zzt(Object obj) {
                    zza((EndpointDiscoveryListener) obj);
                }
            });
        }

        public void zziW(int i) throws RemoteException {
            this.zzamC.zzs(new Status(i));
        }
    }

    private static final class zza extends zzb {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;

        public zza(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzamC = (com.google.android.gms.common.api.internal.zza.zzb) zzx.zzz(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zziZ(int i) throws RemoteException {
            this.zzamC.zzs(new Status(i));
        }
    }

    private static final class zzd extends zzb {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;
        private final zzq<ConnectionResponseCallback> zzbbg;

        public zzd(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, zzq<ConnectionResponseCallback> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzamC = (com.google.android.gms.common.api.internal.zza.zzb) zzx.zzz(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzbbg = (zzq) zzx.zzz(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback);
        }

        public void zza(final String str, final int i, final byte[] bArr) throws RemoteException {
            this.zzbbg.zza(new com.google.android.gms.common.api.internal.zzq.zzb<ConnectionResponseCallback>(this) {
                final /* synthetic */ zzd zzbbh;

                public void zza(ConnectionResponseCallback connectionResponseCallback) {
                    connectionResponseCallback.onConnectionResponse(str, new Status(i), bArr);
                }

                public void zzpr() {
                }

                public /* synthetic */ void zzt(Object obj) {
                    zza((ConnectionResponseCallback) obj);
                }
            });
        }

        public void zziY(int i) throws RemoteException {
            this.zzamC.zzs(new Status(i));
        }
    }

    public zzqk(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzqn) zzqJ()).zzF(this.zzaEg);
            } catch (Throwable e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    public String zzEj() {
        try {
            return ((zzqn) zzqJ()).zzaj(this.zzaEg);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String zzEk() {
        try {
            return ((zzqn) zzqJ()).zzEk();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void zzEl() {
        try {
            ((zzqn) zzqJ()).zzag(this.zzaEg);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public void zzEm() {
        try {
            ((zzqn) zzqJ()).zzai(this.zzaEg);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdv(iBinder);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, String str, long j, zzq<EndpointDiscoveryListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) throws RemoteException {
        ((zzqn) zzqJ()).zza(new zzg(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener), str, j, this.zzaEg);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<StartAdvertisingResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, String str, AppMetadata appMetadata, long j, zzq<ConnectionRequestListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) throws RemoteException {
        ((zzqn) zzqJ()).zza(new zze(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener), str, appMetadata, j, this.zzaEg);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, String str, String str2, byte[] bArr, zzq<ConnectionResponseCallback> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_MessageListener) throws RemoteException {
        ((zzqn) zzqJ()).zza(new zzd(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_MessageListener), str, str2, bArr, this.zzaEg);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, String str, byte[] bArr, zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_MessageListener) throws RemoteException {
        ((zzqn) zzqJ()).zza(new zza(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_common_api_internal_zzq_com_google_android_gms_nearby_connection_Connections_MessageListener), str, bArr, this.zzaEg);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            ((zzqn) zzqJ()).zza(strArr, bArr, this.zzaEg);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            ((zzqn) zzqJ()).zzb(strArr, bArr, this.zzaEg);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    protected zzqn zzdv(IBinder iBinder) {
        return com.google.android.gms.internal.zzqn.zza.zzdx(iBinder);
    }

    public void zzfA(String str) {
        try {
            ((zzqn) zzqJ()).zzi(str, this.zzaEg);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    public void zzfz(String str) {
        try {
            ((zzqn) zzqJ()).zzh(str, this.zzaEg);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    protected String zzgu() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    protected String zzgv() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    public void zzp(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, String str) throws RemoteException {
        ((zzqn) zzqJ()).zza(new zzc(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), str, this.zzaEg);
    }
}
