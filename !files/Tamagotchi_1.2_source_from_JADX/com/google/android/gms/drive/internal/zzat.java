package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import java.io.IOException;

public final class zzat extends zzso<zzat> {
    public int versionCode;
    public long zzarW;
    public String zzarY;
    public long zzarZ;
    public int zzasa;

    public zzat() {
        zztl();
    }

    public static zzat zzm(byte[] bArr) throws zzst {
        return (zzat) zzsu.mergeFrom(new zzat(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzat)) {
            return false;
        }
        zzat com_google_android_gms_drive_internal_zzat = (zzat) o;
        if (this.versionCode != com_google_android_gms_drive_internal_zzat.versionCode) {
            return false;
        }
        if (this.zzarY == null) {
            if (com_google_android_gms_drive_internal_zzat.zzarY != null) {
                return false;
            }
        } else if (!this.zzarY.equals(com_google_android_gms_drive_internal_zzat.zzarY)) {
            return false;
        }
        if (this.zzarZ != com_google_android_gms_drive_internal_zzat.zzarZ || this.zzarW != com_google_android_gms_drive_internal_zzat.zzarW || this.zzasa != com_google_android_gms_drive_internal_zzat.zzasa) {
            return false;
        }
        if (this.zzbuj == null || this.zzbuj.isEmpty()) {
            return com_google_android_gms_drive_internal_zzat.zzbuj == null || com_google_android_gms_drive_internal_zzat.zzbuj.isEmpty();
        } else {
            return this.zzbuj.equals(com_google_android_gms_drive_internal_zzat.zzbuj);
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((this.zzarY == null ? 0 : this.zzarY.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31)) * 31) + ((int) (this.zzarZ ^ (this.zzarZ >>> 32)))) * 31) + ((int) (this.zzarW ^ (this.zzarW >>> 32)))) * 31) + this.zzasa) * 31;
        if (!(this.zzbuj == null || this.zzbuj.isEmpty())) {
            i = this.zzbuj.hashCode();
        }
        return hashCode + i;
    }

    public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
        return zzm(com_google_android_gms_internal_zzsm);
    }

    public void writeTo(zzsn output) throws IOException {
        output.zzA(1, this.versionCode);
        output.zzn(2, this.zzarY);
        output.zzc(3, this.zzarZ);
        output.zzc(4, this.zzarW);
        if (this.zzasa != -1) {
            output.zzA(5, this.zzasa);
        }
        super.writeTo(output);
    }

    public zzat zzm(zzsm com_google_android_gms_internal_zzsm) throws IOException {
        while (true) {
            int zzIX = com_google_android_gms_internal_zzsm.zzIX();
            switch (zzIX) {
                case 0:
                    break;
                case 8:
                    this.versionCode = com_google_android_gms_internal_zzsm.zzJb();
                    continue;
                case 18:
                    this.zzarY = com_google_android_gms_internal_zzsm.readString();
                    continue;
                case 24:
                    this.zzarZ = com_google_android_gms_internal_zzsm.zzJe();
                    continue;
                case 32:
                    this.zzarW = com_google_android_gms_internal_zzsm.zzJe();
                    continue;
                case 40:
                    this.zzasa = com_google_android_gms_internal_zzsm.zzJb();
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

    public zzat zztl() {
        this.versionCode = 1;
        this.zzarY = "";
        this.zzarZ = -1;
        this.zzarW = -1;
        this.zzasa = -1;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    protected int zzz() {
        int zzz = (((super.zzz() + zzsn.zzC(1, this.versionCode)) + zzsn.zzo(2, this.zzarY)) + zzsn.zze(3, this.zzarZ)) + zzsn.zze(4, this.zzarW);
        return this.zzasa != -1 ? zzz + zzsn.zzC(5, this.zzasa) : zzz;
    }
}
