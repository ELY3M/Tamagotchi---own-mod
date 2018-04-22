package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;
import java.util.List;

public final class zzql implements Connections {
    public static final com.google.android.gms.common.api.Api.zzc<zzqk> zzUI = new com.google.android.gms.common.api.Api.zzc();
    public static final com.google.android.gms.common.api.Api.zza<zzqk, NoOptions> zzUJ = new C08251();

    static class C08251 extends com.google.android.gms.common.api.Api.zza<zzqk, NoOptions> {
        C08251() {
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzp(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzqk zzp(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzqk(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    private static abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzqk> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzql.zzUI, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<StartAdvertisingResult> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public StartAdvertisingResult zzbc(final Status status) {
            return new StartAdvertisingResult(this) {
                final /* synthetic */ zzb zzbby;

                public String getLocalEndpointName() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbc(status);
        }
    }

    private static abstract class zzc extends zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public static zzqk zzd(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzqk zze(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza(Nearby.CONNECTIONS_API), (Object) "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (zzqk) googleApiClient.zza(zzUI) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
    }

    public PendingResult<Status> acceptConnectionRequest(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload, MessageListener messageListener) {
        final zzq zzr = apiClient.zzr(messageListener);
        final String str = remoteEndpointId;
        final byte[] bArr = payload;
        return apiClient.zzb(new zzc(this, apiClient) {
            final /* synthetic */ zzql zzbbu;

            protected void zza(zzqk com_google_android_gms_internal_zzqk) throws RemoteException {
                com_google_android_gms_internal_zzqk.zza((com.google.android.gms.common.api.internal.zza.zzb) this, str, bArr, zzr);
            }
        });
    }

    public void disconnectFromEndpoint(GoogleApiClient apiClient, String remoteEndpointId) {
        zzd(apiClient, false).zzfA(remoteEndpointId);
    }

    public String getLocalDeviceId(GoogleApiClient apiClient) {
        return zzd(apiClient, true).zzEk();
    }

    public String getLocalEndpointId(GoogleApiClient apiClient) {
        return zzd(apiClient, true).zzEj();
    }

    public PendingResult<Status> rejectConnectionRequest(GoogleApiClient apiClient, final String remoteEndpointId) {
        return apiClient.zzb(new zzc(this, apiClient) {
            final /* synthetic */ zzql zzbbu;

            protected void zza(zzqk com_google_android_gms_internal_zzqk) throws RemoteException {
                com_google_android_gms_internal_zzqk.zzp(this, remoteEndpointId);
            }
        });
    }

    public PendingResult<Status> sendConnectionRequest(GoogleApiClient apiClient, String name, String remoteEndpointId, byte[] payload, ConnectionResponseCallback connectionResponseCallback, MessageListener messageListener) {
        final zzq zzr = apiClient.zzr(connectionResponseCallback);
        final zzq zzr2 = apiClient.zzr(messageListener);
        final String str = name;
        final String str2 = remoteEndpointId;
        final byte[] bArr = payload;
        return apiClient.zzb(new zzc(this, apiClient) {
            final /* synthetic */ zzql zzbbu;

            protected void zza(zzqk com_google_android_gms_internal_zzqk) throws RemoteException {
                com_google_android_gms_internal_zzqk.zza(this, str, str2, bArr, zzr, zzr2);
            }
        });
    }

    public void sendReliableMessage(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload) {
        zzd(apiClient, false).zza(new String[]{remoteEndpointId}, payload);
    }

    public void sendReliableMessage(GoogleApiClient apiClient, List<String> remoteEndpointIds, byte[] payload) {
        zzd(apiClient, false).zza((String[]) remoteEndpointIds.toArray(new String[remoteEndpointIds.size()]), payload);
    }

    public void sendUnreliableMessage(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload) {
        zzd(apiClient, false).zzb(new String[]{remoteEndpointId}, payload);
    }

    public void sendUnreliableMessage(GoogleApiClient apiClient, List<String> remoteEndpointIds, byte[] payload) {
        zzd(apiClient, false).zzb((String[]) remoteEndpointIds.toArray(new String[remoteEndpointIds.size()]), payload);
    }

    public PendingResult<StartAdvertisingResult> startAdvertising(GoogleApiClient apiClient, String name, AppMetadata appMetadata, long durationMillis, ConnectionRequestListener connectionRequestListener) {
        final zzq zzr = apiClient.zzr(connectionRequestListener);
        final String str = name;
        final AppMetadata appMetadata2 = appMetadata;
        final long j = durationMillis;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ zzql zzbbu;

            protected void zza(zzqk com_google_android_gms_internal_zzqk) throws RemoteException {
                com_google_android_gms_internal_zzqk.zza(this, str, appMetadata2, j, zzr);
            }
        });
    }

    public PendingResult<Status> startDiscovery(GoogleApiClient apiClient, String serviceId, long durationMillis, EndpointDiscoveryListener listener) {
        final zzq zzr = apiClient.zzr(listener);
        final String str = serviceId;
        final long j = durationMillis;
        return apiClient.zzb(new zzc(this, apiClient) {
            final /* synthetic */ zzql zzbbu;

            protected void zza(zzqk com_google_android_gms_internal_zzqk) throws RemoteException {
                com_google_android_gms_internal_zzqk.zza((com.google.android.gms.common.api.internal.zza.zzb) this, str, j, zzr);
            }
        });
    }

    public void stopAdvertising(GoogleApiClient apiClient) {
        zzd(apiClient, false).zzEl();
    }

    public void stopAllEndpoints(GoogleApiClient apiClient) {
        zzd(apiClient, false).zzEm();
    }

    public void stopDiscovery(GoogleApiClient apiClient, String serviceId) {
        zzd(apiClient, false).zzfz(serviceId);
    }
}
