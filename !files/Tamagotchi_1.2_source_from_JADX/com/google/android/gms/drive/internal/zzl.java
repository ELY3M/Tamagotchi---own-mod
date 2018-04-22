package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

public class zzl {
    private String zzapg;
    private DriveId zzapj;
    protected MetadataChangeSet zzaqt;
    private Integer zzaqu;
    private final int zzaqv;

    public zzl(int i) {
        this.zzaqv = i;
    }

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zzb(this.zzaqt, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        zzx.zza(apiClient.isConnected(), (Object) "Client must be connected");
        zzu com_google_android_gms_drive_internal_zzu = (zzu) apiClient.zza(Drive.zzUI);
        this.zzaqt.zzsL().setContext(com_google_android_gms_drive_internal_zzu.getContext());
        try {
            return com_google_android_gms_drive_internal_zzu.zzte().zza(new CreateFileIntentSenderRequest(this.zzaqt.zzsL(), this.zzaqu == null ? 0 : this.zzaqu.intValue(), this.zzapg, this.zzapj, this.zzaqv));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public void zza(DriveId driveId) {
        this.zzapj = (DriveId) zzx.zzz(driveId);
    }

    public void zza(MetadataChangeSet metadataChangeSet) {
        this.zzaqt = (MetadataChangeSet) zzx.zzz(metadataChangeSet);
    }

    public void zzcZ(int i) {
        this.zzaqu = Integer.valueOf(i);
    }

    public void zzdb(String str) {
        this.zzapg = (String) zzx.zzz(str);
    }
}
