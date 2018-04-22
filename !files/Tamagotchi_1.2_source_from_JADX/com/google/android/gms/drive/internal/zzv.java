package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzt.zza;
import com.google.android.gms.drive.zzi;
import com.google.android.gms.internal.zzna;
import java.io.InputStream;
import java.io.OutputStream;

public class zzv implements DriveContents {
    private boolean mClosed = false;
    private final Contents zzara;
    private boolean zzarb = false;
    private boolean zzarc = false;

    class C07223 implements ResultCallback<Status> {
        final /* synthetic */ zzv zzard;

        C07223(zzv com_google_android_gms_drive_internal_zzv) {
            this.zzard = com_google_android_gms_drive_internal_zzv;
        }

        public /* synthetic */ void onResult(Result result) {
            zzp((Status) result);
        }

        public void zzp(Status status) {
            if (status.isSuccess()) {
                zzz.zzy("DriveContentsImpl", "Contents discarded");
            } else {
                zzz.zzA("DriveContentsImpl", "Error discarding contents");
            }
        }
    }

    public zzv(Contents contents) {
        this.zzara = (Contents) zzx.zzz(contents);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        return zza(apiClient, changeSet, null);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet, ExecutionOptions executionOptions) {
        return zza(apiClient, changeSet, executionOptions == null ? null : zzi.zzb(executionOptions));
    }

    public void discard(GoogleApiClient apiClient) {
        if (zzsz()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        zzsy();
        ((C11794) apiClient.zzb(new zza(this, apiClient) {
            final /* synthetic */ zzv zzard;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzte().zza(new CloseContentsRequest(this.zzard.zzara.getRequestId(), false), new zzbu(this));
            }
        })).setResultCallback(new C07223(this));
    }

    public DriveId getDriveId() {
        return this.zzara.getDriveId();
    }

    public InputStream getInputStream() {
        if (zzsz()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.zzara.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.zzarb) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.zzarb = true;
            return this.zzara.getInputStream();
        }
    }

    public int getMode() {
        return this.zzara.getMode();
    }

    public OutputStream getOutputStream() {
        if (zzsz()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.zzara.getMode() != DriveFile.MODE_WRITE_ONLY) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.zzarc) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.zzarc = true;
            return this.zzara.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!zzsz()) {
            return this.zzara.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public PendingResult<DriveContentsResult> reopenForWrite(GoogleApiClient apiClient) {
        if (zzsz()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.zzara.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            zzsy();
            return apiClient.zza(new zzc(this, apiClient) {
                final /* synthetic */ zzv zzard;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    com_google_android_gms_drive_internal_zzu.zzte().zza(new OpenContentsRequest(this.zzard.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.zzard.zzara.getRequestId()), new zzbl(this, null));
                }
            });
        }
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, zzi com_google_android_gms_drive_zzi) {
        if (com_google_android_gms_drive_zzi == null) {
            com_google_android_gms_drive_zzi = new zzi.zza().zzsJ();
        }
        if (this.zzara.getMode() == DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.zzcv(com_google_android_gms_drive_zzi.zzsD()) || this.zzara.zzsv()) {
            com_google_android_gms_drive_zzi.zzg(googleApiClient);
            if (zzsz()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if (metadataChangeSet == null) {
                    metadataChangeSet = MetadataChangeSet.zzapd;
                }
                zzsy();
                return googleApiClient.zzb(new zza(this, googleApiClient) {
                    final /* synthetic */ zzv zzard;

                    protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                        metadataChangeSet.zzsL().setContext(com_google_android_gms_drive_internal_zzu.getContext());
                        com_google_android_gms_drive_internal_zzu.zzte().zza(new CloseContentsAndUpdateMetadataRequest(this.zzard.zzara.getDriveId(), metadataChangeSet.zzsL(), this.zzard.zzara.getRequestId(), this.zzard.zzara.zzsv(), com_google_android_gms_drive_zzi), new zzbu(this));
                    }
                });
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public Contents zzsx() {
        return this.zzara;
    }

    public void zzsy() {
        zzna.zza(this.zzara.getParcelFileDescriptor());
        this.mClosed = true;
    }

    public boolean zzsz() {
        return this.mClosed;
    }
}
