package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;

public final class Cast {
    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final Api<CastOptions> API = new Api("Cast.API", zzUJ, zzk.zzUI);
    public static final CastApi CastApi = new zza();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    private static final com.google.android.gms.common.api.Api.zza<zze, CastOptions> zzUJ = new C06891();

    public interface CastApi {

        public static final class zza implements CastApi {
            public int getActiveInputState(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).zzol();
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).getApplicationStatus();
            }

            public int getStandbyState(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).zzom();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).zzok();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return zza(client, null, null, null);
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, String applicationId) {
                return zza(client, applicationId, null, null);
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, String applicationId, String sessionId) {
                return zza(client, applicationId, sessionId, null);
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId) {
                return client.zzb(new zza(this, client) {
                    final /* synthetic */ zza zzZH;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zza(applicationId, false, (zzb) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId, final LaunchOptions options) {
                return client.zzb(new zza(this, client) {
                    final /* synthetic */ zza zzZH;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zza(applicationId, options, (zzb) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return launchApplication(client, applicationId, new Builder().setRelaunchIfRunning(relaunchIfRunning).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.zzb(new zzh(this, client) {
                    final /* synthetic */ zza zzZH;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zzb((zzb) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zzcg(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zzoj();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, final String namespace, final String message) {
                return client.zzb(new zzh(this, client) {
                    final /* synthetic */ zza zzZH;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zza(namespace, message, (zzb) this);
                            return;
                        } catch (IllegalArgumentException e) {
                        } catch (IllegalStateException e2) {
                        }
                        zzbj(2001);
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zza(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zzX(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zzf(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.zzb(new zzh(this, client) {
                    final /* synthetic */ zza zzZH;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zza("", (zzb) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, final String sessionId) {
                return client.zzb(new zzh(this, client) {
                    final /* synthetic */ zza zzZH;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        if (TextUtils.isEmpty(sessionId)) {
                            zze(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            com_google_android_gms_cast_internal_zze.zza(sessionId, (zzb) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> zza(GoogleApiClient googleApiClient, String str, String str2, JoinOptions joinOptions) {
                final String str3 = str;
                final String str4 = str2;
                final JoinOptions joinOptions2 = joinOptions;
                return googleApiClient.zzb(new zza(this, googleApiClient) {
                    final /* synthetic */ zza zzZH;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zza(str3, str4, joinOptions2, (zzb) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }
        }

        int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException;

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static class Listener {
        public void onActiveInputStateChanged(int activeInputState) {
        }

        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onStandbyStateChanged(int standbyState) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    static class C06891 extends com.google.android.gms.common.api.Api.zza<zze, CastOptions> {
        C06891() {
        }

        public zze zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb((Object) castOptions, (Object) "Setting the API options is required.");
            return new zze(context, looper, com_google_android_gms_common_internal_zzf, castOptions.zzZL, (long) castOptions.zzZN, castOptions.zzZM, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public static final class CastOptions implements HasOptions {
        final CastDevice zzZL;
        final Listener zzZM;
        private final int zzZN;

        public static final class Builder {
            CastDevice zzZO;
            Listener zzZP;
            private int zzZQ = 0;

            public Builder(CastDevice castDevice, Listener castListener) {
                zzx.zzb((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                zzx.zzb((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.zzZO = castDevice;
                this.zzZP = castListener;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.zzZQ |= 1;
                } else {
                    this.zzZQ &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.zzZL = builder.zzZO;
            this.zzZM = builder.zzZP;
            this.zzZN = builder.zzZQ;
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener);
        }
    }

    private static abstract class zza extends com.google.android.gms.cast.internal.zzb<ApplicationConnectionResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzo(status);
        }

        public ApplicationConnectionResult zzo(final Status status) {
            return new ApplicationConnectionResult(this) {
                final /* synthetic */ zza zzZS;

                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
