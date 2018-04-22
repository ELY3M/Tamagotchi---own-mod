package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.zzi;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;
import com.google.android.gms.drive.zzh;
import com.google.android.gms.internal.zznm;

public class zzy extends zzab implements DriveFolder {

    private static class zzc implements DriveFileResult {
        private final Status zzUX;
        private final DriveFile zzarr;

        public zzc(Status status, DriveFile driveFile) {
            this.zzUX = status;
            this.zzarr = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.zzarr;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static class zze implements DriveFolderResult {
        private final Status zzUX;
        private final DriveFolder zzars;

        public zze(Status status, DriveFolder driveFolder) {
            this.zzUX = status;
            this.zzars = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.zzars;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static class zza extends zzd {
        private final com.google.android.gms.common.api.internal.zza.zzb<DriveFileResult> zzamC;

        public zza(com.google.android.gms.common.api.internal.zza.zzb<DriveFileResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveFolder_DriveFileResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveFolder_DriveFileResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzc(status, null));
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzamC.zzs(new zzc(Status.zzagC, new zzw(onDriveIdResponse.getDriveId())));
        }
    }

    private static class zzb extends zzd {
        private final com.google.android.gms.common.api.internal.zza.zzb<DriveFolderResult> zzamC;

        public zzb(com.google.android.gms.common.api.internal.zza.zzb<DriveFolderResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveFolder_DriveFolderResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveFolder_DriveFolderResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zze(status, null));
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzamC.zzs(new zze(Status.zzagC, new zzy(onDriveIdResponse.getDriveId())));
        }
    }

    static abstract class zzd extends zzt<DriveFileResult> {
        zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveFileResult zzE(Status status) {
            return new zzc(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzE(status);
        }
    }

    static abstract class zzf extends zzt<DriveFolderResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveFolderResult zzF(Status status) {
            return new zze(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzF(status);
        }
    }

    public zzy(DriveId driveId) {
        super(driveId);
    }

    private int zza(DriveContents driveContents, zzi com_google_android_gms_drive_metadata_internal_zzi) {
        if (driveContents == null) {
            return (com_google_android_gms_drive_metadata_internal_zzi == null || !com_google_android_gms_drive_metadata_internal_zzi.zztI()) ? 1 : 0;
        } else {
            int requestId = driveContents.zzsx().getRequestId();
            driveContents.zzsy();
            return requestId;
        }
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, zzh com_google_android_gms_drive_zzh) {
        zzi zzdd = zzi.zzdd(metadataChangeSet.getMimeType());
        final int i2 = (zzdd == null || !zzdd.zztI()) ? 0 : 1;
        final MetadataChangeSet metadataChangeSet2 = metadataChangeSet;
        final int i3 = i;
        final zzh com_google_android_gms_drive_zzh2 = com_google_android_gms_drive_zzh;
        return googleApiClient.zzb(new zzd(this, googleApiClient) {
            final /* synthetic */ zzy zzarq;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                metadataChangeSet2.zzsL().setContext(com_google_android_gms_drive_internal_zzu.getContext());
                com_google_android_gms_drive_internal_zzu.zzte().zza(new CreateFileRequest(this.zzarq.getDriveId(), metadataChangeSet2.zzsL(), i3, i2, com_google_android_gms_drive_zzh2), new zza(this));
            }
        });
    }

    private MetadataChangeSet zza(MetadataChangeSet metadataChangeSet, String str) {
        return metadataChangeSet.zza(zznm.zzatE, str);
    }

    private Query zza(Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return addFilter.build();
    }

    private void zzb(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, zzh com_google_android_gms_drive_zzh) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        zzi zzdd = zzi.zzdd(metadataChangeSet.getMimeType());
        if (zzdd == null || !zzdd.isFolder()) {
            com_google_android_gms_drive_zzh.zzg(googleApiClient);
            if (driveContents != null) {
                if (!(driveContents instanceof zzv)) {
                    throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
                } else if (driveContents.getDriveId() != null) {
                    throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
                } else if (driveContents.zzsz()) {
                    throw new IllegalArgumentException("DriveContents are already closed.");
                } else {
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("May not create folders using this method. Use DriveFolder.createFolder() instead of mime type application/vnd.google-apps.folder");
    }

    private void zzb(MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        zzi zzdd = zzi.zzdd(metadataChangeSet.getMimeType());
        if (zzdd != null && !zzdd.zztH()) {
            throw new IllegalArgumentException("May not create shortcut files using this method. Use DriveFolder.createShortcutFile() instead.");
        }
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents) {
        zzb(changeSet);
        return zza(apiClient, changeSet, driveContents, null);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        zzb(changeSet);
        return zza(apiClient, changeSet, driveContents, zzh.zza(executionOptions));
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.zzb(new zzf(this, apiClient) {
                final /* synthetic */ zzy zzarq;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    changeSet.zzsL().setContext(com_google_android_gms_drive_internal_zzu.getContext());
                    com_google_android_gms_drive_internal_zzu.zzte().zza(new CreateFolderRequest(this.zzarq.getDriveId(), changeSet.zzsL()), new zzb(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        return new zzs().query(apiClient, zza(query));
    }

    public PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, zzh com_google_android_gms_drive_zzh) {
        if (com_google_android_gms_drive_zzh == null) {
            com_google_android_gms_drive_zzh = new com.google.android.gms.drive.zzh.zza().zzsH();
        }
        zzb(googleApiClient, metadataChangeSet, driveContents, com_google_android_gms_drive_zzh);
        int zza = zza(driveContents, zzi.zzdd(metadataChangeSet.getMimeType()));
        String zzsG = com_google_android_gms_drive_zzh.zzsG();
        if (zzsG != null) {
            metadataChangeSet = zza(metadataChangeSet, zzsG);
        }
        return zza(googleApiClient, metadataChangeSet, zza, com_google_android_gms_drive_zzh);
    }
}
