package com.google.android.gms.drive.internal;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public class zzs implements DriveApi {

    static class zzb implements Releasable, DriveContentsResult {
        private final Status zzUX;
        private final DriveContents zzaoC;

        public zzb(Status status, DriveContents driveContents) {
            this.zzUX = status;
            this.zzaoC = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.zzaoC;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzaoC != null) {
                this.zzaoC.zzsy();
            }
        }
    }

    private static class zze implements DriveIdResult {
        private final Status zzUX;
        private final DriveId zzaoz;

        public zze(Status status, DriveId driveId) {
            this.zzUX = status;
            this.zzaoz = driveId;
        }

        public DriveId getDriveId() {
            return this.zzaoz;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    static class zzg implements MetadataBufferResult {
        private final Status zzUX;
        private final MetadataBuffer zzaqI;
        private final boolean zzaqJ;

        public zzg(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.zzUX = status;
            this.zzaqI = metadataBuffer;
            this.zzaqJ = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.zzaqI;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzaqI != null) {
                this.zzaqI.release();
            }
        }
    }

    private static class zza extends zzd {
        private final com.google.android.gms.common.api.internal.zza.zzb<DriveContentsResult> zzamC;

        public zza(com.google.android.gms.common.api.internal.zza.zzb<DriveContentsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzb(status, null));
        }

        public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
            this.zzamC.zzs(new zzb(Status.zzagC, new zzv(onContentsResponse.zztn())));
        }
    }

    static class zzd extends zzd {
        private final com.google.android.gms.common.api.internal.zza.zzb<DriveIdResult> zzamC;

        public zzd(com.google.android.gms.common.api.internal.zza.zzb<DriveIdResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveApi_DriveIdResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveApi_DriveIdResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zze(status, null));
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzamC.zzs(new zze(Status.zzagC, onDriveIdResponse.getDriveId()));
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzamC.zzs(new zze(Status.zzagC, new zzp(onMetadataResponse.zztw()).getDriveId()));
        }
    }

    private static class zzi extends zzd {
        private final com.google.android.gms.common.api.internal.zza.zzb<MetadataBufferResult> zzamC;

        public zzi(com.google.android.gms.common.api.internal.zza.zzb<MetadataBufferResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzg(status, null, false));
        }

        public void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.zzamC.zzs(new zzg(Status.zzagC, new MetadataBuffer(onListEntriesResponse.zztt()), onListEntriesResponse.zztu()));
        }
    }

    static abstract class zzc extends zzt<DriveContentsResult> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveContentsResult zzB(Status status) {
            return new zzb(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzB(status);
        }
    }

    static abstract class zzf extends zzt<DriveIdResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveIdResult zzC(Status status) {
            return new zze(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzC(status);
        }
    }

    static abstract class zzh extends zzt<MetadataBufferResult> {
        zzh(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public MetadataBufferResult zzD(Status status) {
            return new zzg(status, null, false);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzD(status);
        }
    }

    @SuppressLint({"MissingRemoteException"})
    static class zzj extends com.google.android.gms.drive.internal.zzt.zza {
        zzj(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            zza((Result) status);
        }

        protected void zza(zzu com_google_android_gms_drive_internal_zzu) {
        }
    }

    public PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, List<String> trackingTags) {
        return ((zzu) apiClient.zza(Drive.zzUI)).cancelPendingActions(apiClient, trackingTags);
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, final String resourceId) {
        return apiClient.zza(new zzf(this, apiClient) {
            final /* synthetic */ zzs zzaqD;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzte().zza(new GetMetadataRequest(DriveId.zzcW(resourceId), false), new zzd(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        zzu com_google_android_gms_drive_internal_zzu = (zzu) apiClient.zza(Drive.zzUI);
        if (com_google_android_gms_drive_internal_zzu.zzth()) {
            DriveId zztg = com_google_android_gms_drive_internal_zzu.zztg();
            return zztg != null ? new zzy(zztg) : null;
        } else {
            throw new IllegalStateException("Client is not yet connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new zzw(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new zzy(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        zzu com_google_android_gms_drive_internal_zzu = (zzu) apiClient.zza(Drive.zzUI);
        if (com_google_android_gms_drive_internal_zzu.zzth()) {
            DriveId zztf = com_google_android_gms_drive_internal_zzu.zztf();
            return zztf != null ? new zzy(zztf) : null;
        } else {
            throw new IllegalStateException("Client is not yet connected");
        }
    }

    public PendingResult<BooleanResult> isAutobackupEnabled(GoogleApiClient apiClient) {
        return apiClient.zza(new zzt<BooleanResult>(this, apiClient) {
            final /* synthetic */ zzs zzaqD;

            protected BooleanResult zzA(Status status) {
                return new BooleanResult(status, false);
            }

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzte().zze(new zzd(this) {
                    final /* synthetic */ C10885 zzaqH;

                    public void zzaf(boolean z) {
                        this.zza(new BooleanResult(Status.zzagC, z));
                    }
                });
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzA(status);
            }
        });
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveContentsResult> newDriveContents(GoogleApiClient apiClient) {
        return zza(apiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, final Query query) {
        if (query != null) {
            return apiClient.zza(new zzh(this, apiClient) {
                final /* synthetic */ zzs zzaqD;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    com_google_android_gms_drive_internal_zzu.zzte().zza(new QueryRequest(query), new zzi(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
            final /* synthetic */ zzs zzaqD;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzte().zza(new zzbu(this));
            }
        });
    }

    public PendingResult<DriveContentsResult> zza(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzs zzaqD;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzte().zza(new CreateContentsRequest(i), new zza(this));
            }
        });
    }
}
