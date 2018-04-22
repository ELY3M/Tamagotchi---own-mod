package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzsu;
import java.io.IOException;

public final class zzas extends zzso<zzas> {
    public int versionCode;
    public long zzarV;
    public long zzarW;
    public long zzarX;

    public zzas() {
        zztk();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzas)) {
            return false;
        }
        zzas com_google_android_gms_drive_internal_zzas = (zzas) o;
        if (this.versionCode != com_google_android_gms_drive_internal_zzas.versionCode || this.zzarV != com_google_android_gms_drive_internal_zzas.zzarV || this.zzarW != com_google_android_gms_drive_internal_zzas.zzarW || this.zzarX != com_google_android_gms_drive_internal_zzas.zzarX) {
            return false;
        }
        if (this.zzbuj == null || this.zzbuj.isEmpty()) {
            return com_google_android_gms_drive_internal_zzas.zzbuj == null || com_google_android_gms_drive_internal_zzas.zzbuj.isEmpty();
        } else {
            return this.zzbuj.equals(com_google_android_gms_drive_internal_zzas.zzbuj);
        }
    }

    public int hashCode() {
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31) + ((int) (this.zzarV ^ (this.zzarV >>> 32)))) * 31) + ((int) (this.zzarW ^ (this.zzarW >>> 32)))) * 31) + ((int) (this.zzarX ^ (this.zzarX >>> 32)))) * 31;
        int hashCode2 = (this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode();
        return hashCode2 + hashCode;
    }

    public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
        return zzl(com_google_android_gms_internal_zzsm);
    }

    public void writeTo(zzsn output) throws IOException {
        output.zzA(1, this.versionCode);
        output.zzc(2, this.zzarV);
        output.zzc(3, this.zzarW);
        output.zzc(4, this.zzarX);
        super.writeTo(output);
    }

    public zzas zzl(zzsm com_google_android_gms_internal_zzsm) throws IOException {
        while (true) {
            int zzIX = com_google_android_gms_internal_zzsm.zzIX();
            switch (zzIX) {
                case 0:
                    break;
                case 8:
                    this.versionCode = com_google_android_gms_internal_zzsm.zzJb();
                    continue;
                case 16:
                    this.zzarV = com_google_android_gms_internal_zzsm.zzJe();
                    continue;
                case 24:
                    this.zzarW = com_google_android_gms_internal_zzsm.zzJe();
                    continue;
                case 32:
                    this.zzarX = com_google_android_gms_internal_zzsm.zzJe();
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

    public zzas zztk() {
        this.versionCode = 1;
        this.zzarV = -1;
        this.zzarW = -1;
        this.zzarX = -1;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    protected int zzz() {
        return (((super.zzz() + zzsn.zzC(1, this.versionCode)) + zzsn.zze(2, this.zzarV)) + zzsn.zze(3, this.zzarW)) + zzsn.zze(4, this.zzarX);
    }
}
