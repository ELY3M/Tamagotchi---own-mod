package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

public class zzpg implements SessionsApi {

    private static class zza extends com.google.android.gms.internal.zzou.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<SessionReadResult> zzamC;

        private zza(com.google.android.gms.common.api.internal.zza.zzb<SessionReadResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_SessionReadResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_SessionReadResult;
        }

        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.zzamC.zzs(sessionReadResult);
        }
    }

    private static class zzb extends com.google.android.gms.internal.zzov.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<SessionStopResult> zzamC;

        private zzb(com.google.android.gms.common.api.internal.zza.zzb<SessionStopResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_SessionStopResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_SessionStopResult;
        }

        public void zza(SessionStopResult sessionStopResult) {
            this.zzamC.zzs(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new zza<SessionStopResult>(this, googleApiClient) {
            final /* synthetic */ zzpg zzaAs;

            protected SessionStopResult zzO(Status status) {
                return SessionStopResult.zzV(status);
            }

            protected void zza(zzof com_google_android_gms_internal_zzof) throws RemoteException {
                ((zzoq) com_google_android_gms_internal_zzof.zzqJ()).zza(new SessionStopRequest(str, str2, new zzb(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzO(status);
            }
        });
    }

    public PendingResult<Status> insertSession(GoogleApiClient client, final SessionInsertRequest request) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzpg zzaAs;

            protected void zza(zzof com_google_android_gms_internal_zzof) throws RemoteException {
                ((zzoq) com_google_android_gms_internal_zzof.zzqJ()).zza(new SessionInsertRequest(request, new zzph(this)));
            }
        });
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient client, final SessionReadRequest request) {
        return client.zza(new zza<SessionReadResult>(this, client) {
            final /* synthetic */ zzpg zzaAs;

            protected SessionReadResult zzP(Status status) {
                return SessionReadResult.zzU(status);
            }

            protected void zza(zzof com_google_android_gms_internal_zzof) throws RemoteException {
                ((zzoq) com_google_android_gms_internal_zzof.zzqJ()).zza(new SessionReadRequest(request, new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzP(status);
            }
        });
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient client, PendingIntent intent) {
        return zza(client, intent, 0);
    }

    public PendingResult<Status> startSession(GoogleApiClient client, final Session session) {
        zzx.zzb((Object) session, (Object) "Session cannot be null");
        zzx.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpg zzaAs;

            protected void zza(zzof com_google_android_gms_internal_zzof) throws RemoteException {
                ((zzoq) com_google_android_gms_internal_zzof.zzqJ()).zza(new SessionStartRequest(session, new zzph(this)));
            }
        });
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient client, String identifier) {
        return zza(client, null, identifier);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpg zzaAs;

            protected void zza(zzof com_google_android_gms_internal_zzof) throws RemoteException {
                ((zzoq) com_google_android_gms_internal_zzof.zzqJ()).zza(new SessionUnregistrationRequest(intent, new zzph(this)));
            }
        });
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final PendingIntent pendingIntent, final int i) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzpg zzaAs;

            protected void zza(zzof com_google_android_gms_internal_zzof) throws RemoteException {
                ((zzoq) com_google_android_gms_internal_zzof.zzqJ()).zza(new SessionRegistrationRequest(pendingIntent, new zzph(this), i));
            }
        });
    }
}
