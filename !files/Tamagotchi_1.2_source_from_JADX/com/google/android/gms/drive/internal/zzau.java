package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzsu;
import java.io.IOException;

public final class zzau extends zzso<zzau> {
    public long zzarW;
    public long zzarZ;

    public zzau() {
        zztm();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzau)) {
            return false;
        }
        zzau com_google_android_gms_drive_internal_zzau = (zzau) o;
        if (this.zzarZ != com_google_android_gms_drive_internal_zzau.zzarZ || this.zzarW != com_google_android_gms_drive_internal_zzau.zzarW) {
            return false;
        }
        if (this.zzbuj == null || this.zzbuj.isEmpty()) {
            return com_google_android_gms_drive_internal_zzau.zzbuj == null || com_google_android_gms_drive_internal_zzau.zzbuj.isEmpty();
        } else {
            return this.zzbuj.equals(com_google_android_gms_drive_internal_zzau.zzbuj);
        }
    }

    public int hashCode() {
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzarZ ^ (this.zzarZ >>> 32)))) * 31) + ((int) (this.zzarW ^ (this.zzarW >>> 32)))) * 31;
        int hashCode2 = (this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode();
        return hashCode2 + hashCode;
    }

    public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
        return zzn(com_google_android_gms_internal_zzsm);
    }

    public void writeTo(zzsn output) throws IOException {
        output.zzc(1, this.zzarZ);
        output.zzc(2, this.zzarW);
        super.writeTo(output);
    }

    public zzau zzn(zzsm com_google_android_gms_internal_zzsm) throws IOException {
        while (true) {
            int zzIX = com_google_android_gms_internal_zzsm.zzIX();
            switch (zzIX) {
                case 0:
                    break;
                case 8:
                    this.zzarZ = com_google_android_gms_internal_zzsm.zzJe();
                    continue;
                case 16:
                    this.zzarW = com_google_android_gms_internal_zzsm.zzJe();
                    continue;
                default:
                    if (!zza(com_google_android_gms_internal_zzsm, zzIX)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public zzau zztm() {
        this.zzarZ = -1;
        this.zzarW = -1;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    protected int zzz() {
        return (super.zzz() + zzsn.zze(1, this.zzarZ)) + zzsn.zze(2, this.zzarW);
    }
}
