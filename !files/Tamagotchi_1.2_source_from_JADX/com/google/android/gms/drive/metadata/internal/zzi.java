package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFolder;

public class zzi {
    private String zzasR;

    private zzi(String str) {
        this.zzasR = str.toLowerCase();
    }

    public static zzi zzdd(String str) {
        boolean z = str == null || !str.isEmpty();
        zzx.zzac(z);
        return str == null ? null : new zzi(str);
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o.getClass() != getClass()) {
            return false;
        }
        return this.zzasR.equals(((zzi) o).zzasR);
    }

    public int hashCode() {
        return this.zzasR.hashCode();
    }

    public boolean isFolder() {
        return this.zzasR.equals(DriveFolder.MIME_TYPE);
    }

    public String toString() {
        return this.zzasR;
    }

    public boolean zztH() {
        return (zztI() || isFolder()) ? false : true;
    }

    public boolean zztI() {
        return this.zzasR.startsWith("application/vnd.google-apps");
    }
}
