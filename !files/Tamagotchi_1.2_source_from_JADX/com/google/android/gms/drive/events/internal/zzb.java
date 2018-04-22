package com.google.android.gms.drive.events.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zzj;

public class zzb implements zzj {
    private final int zzBc;
    private final DriveId zzaoz;
    private final int zzapT;

    public zzb(TransferProgressData transferProgressData) {
        this.zzaoz = transferProgressData.getDriveId();
        this.zzapT = transferProgressData.zztb();
        this.zzBc = transferProgressData.getStatus();
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        zzb com_google_android_gms_drive_events_internal_zzb = (zzb) o;
        return zzw.equal(this.zzaoz, com_google_android_gms_drive_events_internal_zzb.zzaoz) && this.zzapT == com_google_android_gms_drive_events_internal_zzb.zzapT && this.zzBc == com_google_android_gms_drive_events_internal_zzb.zzBc;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaoz, Integer.valueOf(this.zzapT), Integer.valueOf(this.zzBc));
    }

    public String toString() {
        return String.format("FileTransferState[TransferType: %d, DriveId: %s, status: %d]", new Object[]{Integer.valueOf(this.zzapT), this.zzaoz, Integer.valueOf(this.zzBc)});
    }
}
