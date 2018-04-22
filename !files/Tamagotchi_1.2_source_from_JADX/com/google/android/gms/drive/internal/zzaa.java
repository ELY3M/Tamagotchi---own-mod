package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;

public class zzaa implements DrivePreferencesApi {

    private class zzb implements FileUploadPreferencesResult {
        private final Status zzUX;
        final /* synthetic */ zzaa zzaru;
        private final FileUploadPreferences zzarw;

        private zzb(zzaa com_google_android_gms_drive_internal_zzaa, Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzaru = com_google_android_gms_drive_internal_zzaa;
            this.zzUX = status;
            this.zzarw = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzarw;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private class zza extends zzd {
        private final com.google.android.gms.common.api.internal.zza.zzb<FileUploadPreferencesResult> zzamC;
        final /* synthetic */ zzaa zzaru;

        private zza(zzaa com_google_android_gms_drive_internal_zzaa, com.google.android.gms.common.api.internal.zza.zzb<FileUploadPreferencesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult) {
            this.zzaru = com_google_android_gms_drive_internal_zzaa;
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzb(status, null));
        }

        public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.zzamC.zzs(new zzb(Status.zzagC, onDeviceUsagePreferenceResponse.zztp()));
        }
    }

    private abstract class zzc extends zzt<FileUploadPreferencesResult> {
        final /* synthetic */ zzaa zzaru;

        public zzc(zzaa com_google_android_gms_drive_internal_zzaa, GoogleApiClient googleApiClient) {
            this.zzaru = com_google_android_gms_drive_internal_zzaa;
            super(googleApiClient);
        }

        protected FileUploadPreferencesResult zzG(Status status) {
            return new zzb(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzG(status);
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient apiClient) {
        return apiClient.zza(new zzc(this, apiClient) {
            final /* synthetic */ zzaa zzaru;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzte().zzd(new zza(this));
            }
        });
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient apiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof FileUploadPreferencesImpl) {
            final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
            return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
                final /* synthetic */ zzaa zzaru;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    com_google_android_gms_drive_internal_zzu.zzte().zza(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), new zzbu(this));
                }
            });
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}
