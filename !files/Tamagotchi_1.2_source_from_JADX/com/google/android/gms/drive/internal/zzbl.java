package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;

class zzbl extends zzd {
    private final zzb<DriveContentsResult> zzamC;
    private final DownloadProgressListener zzasy;

    zzbl(zzb<DriveContentsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult, DownloadProgressListener downloadProgressListener) {
        this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult;
        this.zzasy = downloadProgressListener;
    }

    public void onError(Status status) throws RemoteException {
        this.zzamC.zzs(new zzb(status, null));
    }

    public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
        this.zzamC.zzs(new zzb(onContentsResponse.zzto() ? new Status(-1) : Status.zzagC, new zzv(onContentsResponse.zztn())));
    }

    public void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
        if (this.zzasy != null) {
            this.zzasy.onProgress(onDownloadProgressResponse.zztq(), onDownloadProgressResponse.zztr());
        }
    }
}
