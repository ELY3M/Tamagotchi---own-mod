package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.api.internal.zzq.zzb;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;

public class zzw extends zzab implements DriveFile {

    private static class zza implements DownloadProgressListener {
        private final zzq<DownloadProgressListener> zzari;

        public zza(zzq<DownloadProgressListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_drive_DriveFile_DownloadProgressListener) {
            this.zzari = com_google_android_gms_common_api_internal_zzq_com_google_android_gms_drive_DriveFile_DownloadProgressListener;
        }

        public void onProgress(long bytesDownloaded, long bytesExpected) {
            final long j = bytesDownloaded;
            final long j2 = bytesExpected;
            this.zzari.zza(new zzb<DownloadProgressListener>(this) {
                final /* synthetic */ zza zzarl;

                public void zza(DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j, j2);
                }

                public void zzpr() {
                }

                public /* synthetic */ void zzt(Object obj) {
                    zza((DownloadProgressListener) obj);
                }
            });
        }
    }

    public zzw(DriveId driveId) {
        super(driveId);
    }

    private static DownloadProgressListener zza(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        return downloadProgressListener == null ? null : new zza(googleApiClient.zzr(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient apiClient, final int mode, DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            final DownloadProgressListener zza = zza(apiClient, listener);
            return apiClient.zza(new zzc(this, apiClient) {
                final /* synthetic */ zzw zzarh;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    zza(com_google_android_gms_drive_internal_zzu.zzte().zza(new OpenContentsRequest(this.zzarh.getDriveId(), mode, 0), new zzbl(this, zza)).zztj());
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
