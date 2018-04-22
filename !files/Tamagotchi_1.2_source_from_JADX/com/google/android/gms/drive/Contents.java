package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
    public static final Creator<Contents> CREATOR = new zzb();
    final int mVersionCode;
    final ParcelFileDescriptor zzajL;
    final boolean zzaoA;
    final int zzaox;
    final int zzaoy;
    final DriveId zzaoz;
    final String zzsU;

    Contents(int versionCode, ParcelFileDescriptor parcelFileDescriptor, int requestId, int mode, DriveId driveId, boolean validForConflictDetection, String signature) {
        this.mVersionCode = versionCode;
        this.zzajL = parcelFileDescriptor;
        this.zzaox = requestId;
        this.zzaoy = mode;
        this.zzaoz = driveId;
        this.zzaoA = validForConflictDetection;
        this.zzsU = signature;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzaoz;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.zzajL.getFileDescriptor());
    }

    public int getMode() {
        return this.zzaoy;
    }

    public OutputStream getOutputStream() {
        return new FileOutputStream(this.zzajL.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.zzajL;
    }

    public int getRequestId() {
        return this.zzaox;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public boolean zzsv() {
        return this.zzaoA;
    }
}
