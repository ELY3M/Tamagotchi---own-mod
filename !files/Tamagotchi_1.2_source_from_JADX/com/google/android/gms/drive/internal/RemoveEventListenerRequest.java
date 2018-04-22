package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.TransferProgressOptions;

public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Creator<RemoveEventListenerRequest> CREATOR = new zzbp();
    final int mVersionCode;
    final int zzanf;
    final DriveId zzaoz;
    final TransferProgressOptions zzapZ;

    RemoveEventListenerRequest(int versionCode, DriveId driveId, int eventType, TransferProgressOptions transferProgressOptions) {
        this.mVersionCode = versionCode;
        this.zzaoz = driveId;
        this.zzanf = eventType;
        this.zzapZ = transferProgressOptions;
    }

    public RemoveEventListenerRequest(DriveId id, int eventType) {
        this(id, eventType, null);
    }

    RemoveEventListenerRequest(DriveId id, int eventType, TransferProgressOptions transferProgressOptions) {
        this(1, id, eventType, transferProgressOptions);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbp.zza(this, dest, flags);
    }
}
