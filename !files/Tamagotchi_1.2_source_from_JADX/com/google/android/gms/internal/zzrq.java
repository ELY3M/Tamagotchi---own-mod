package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zzf;
import com.google.android.gms.internal.zzaf.zzj;
import java.io.IOException;

public interface zzrq {

    public static final class zza extends zzso<zza> {
        public long zzbmd;
        public zzj zzbme;
        public zzf zzju;

        public zza() {
            zzHG();
        }

        public static zza zzy(byte[] bArr) throws zzst {
            return (zza) zzsu.mergeFrom(new zza(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzrq_zza = (zza) o;
            if (this.zzbmd != com_google_android_gms_internal_zzrq_zza.zzbmd) {
                return false;
            }
            if (this.zzju == null) {
                if (com_google_android_gms_internal_zzrq_zza.zzju != null) {
                    return false;
                }
            } else if (!this.zzju.equals(com_google_android_gms_internal_zzrq_zza.zzju)) {
                return false;
            }
            if (this.zzbme == null) {
                if (com_google_android_gms_internal_zzrq_zza.zzbme != null) {
                    return false;
                }
            } else if (!this.zzbme.equals(com_google_android_gms_internal_zzrq_zza.zzbme)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzrq_zza.zzbuj == null || com_google_android_gms_internal_zzrq_zza.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzrq_zza.zzbuj);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbme == null ? 0 : this.zzbme.hashCode()) + (((this.zzju == null ? 0 : this.zzju.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzbmd ^ (this.zzbmd >>> 32)))) * 31)) * 31)) * 31;
            if (!(this.zzbuj == null || this.zzbuj.isEmpty())) {
                i = this.zzbuj.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzJ(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            output.zzb(1, this.zzbmd);
            if (this.zzju != null) {
                output.zza(2, this.zzju);
            }
            if (this.zzbme != null) {
                output.zza(3, this.zzbme);
            }
            super.writeTo(output);
        }

        public zza zzHG() {
            this.zzbmd = 0;
            this.zzju = null;
            this.zzbme = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        public zza zzJ(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzbmd = com_google_android_gms_internal_zzsm.zzJa();
                        continue;
                    case 18:
                        if (this.zzju == null) {
                            this.zzju = new zzf();
                        }
                        com_google_android_gms_internal_zzsm.zza(this.zzju);
                        continue;
                    case 26:
                        if (this.zzbme == null) {
                            this.zzbme = new zzj();
                        }
                        com_google_android_gms_internal_zzsm.zza(this.zzbme);
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

        protected int zzz() {
            int zzz = super.zzz() + zzsn.zzd(1, this.zzbmd);
            if (this.zzju != null) {
                zzz += zzsn.zzc(2, this.zzju);
            }
            return this.zzbme != null ? zzz + zzsn.zzc(3, this.zzbme) : zzz;
        }
    }
}
