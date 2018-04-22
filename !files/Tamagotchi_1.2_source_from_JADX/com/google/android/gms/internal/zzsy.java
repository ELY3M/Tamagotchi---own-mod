package com.google.android.gms.internal;

import java.io.IOException;

public interface zzsy {

    public static final class zza extends zzsu {
        public String name;
        public zzb[] zzbuE;

        public zza() {
            zzJz();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzsy_zza = (zza) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzsy_zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzsy_zza.name)) {
                return false;
            }
            return zzss.equals(this.zzbuE, com_google_android_gms_internal_zzsy_zza.zzbuE);
        }

        public int hashCode() {
            return (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzss.hashCode(this.zzbuE);
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzQ(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            if (this.name != null) {
                output.zzn(1, this.name);
            }
            if (this.zzbuE != null && this.zzbuE.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu : this.zzbuE) {
                    if (com_google_android_gms_internal_zzsu != null) {
                        output.zza(2, com_google_android_gms_internal_zzsu);
                    }
                }
            }
            super.writeTo(output);
        }

        public zza zzJz() {
            this.name = null;
            this.zzbuE = zzb.zzJA();
            this.zzbuu = -1;
            return this;
        }

        public zza zzQ(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 18:
                        int zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 18);
                        zzIX = this.zzbuE == null ? 0 : this.zzbuE.length;
                        Object obj = new zzb[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzbuE, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zzb();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zzb();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zzbuE = obj;
                        continue;
                    default:
                        if (!zzsx.zzb(com_google_android_gms_internal_zzsm, zzIX)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (this.name != null) {
                zzz += zzsn.zzo(1, this.name);
            }
            if (this.zzbuE == null || this.zzbuE.length <= 0) {
                return zzz;
            }
            int i = zzz;
            for (zzsu com_google_android_gms_internal_zzsu : this.zzbuE) {
                if (com_google_android_gms_internal_zzsu != null) {
                    i += zzsn.zzc(2, com_google_android_gms_internal_zzsu);
                }
            }
            return i;
        }
    }

    public static final class zzb extends zzsu {
        private static volatile zzb[] zzbuF;
        public String name;
        public Integer zzbuG;
        public Boolean zzbuH;

        public zzb() {
            zzJB();
        }

        public static zzb[] zzJA() {
            if (zzbuF == null) {
                synchronized (zzss.zzbut) {
                    if (zzbuF == null) {
                        zzbuF = new zzb[0];
                    }
                }
            }
            return zzbuF;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzsy_zzb = (zzb) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzsy_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzsy_zzb.name)) {
                return false;
            }
            if (this.zzbuG == null) {
                if (com_google_android_gms_internal_zzsy_zzb.zzbuG != null) {
                    return false;
                }
            } else if (!this.zzbuG.equals(com_google_android_gms_internal_zzsy_zzb.zzbuG)) {
                return false;
            }
            return this.zzbuH == null ? com_google_android_gms_internal_zzsy_zzb.zzbuH == null : this.zzbuH.equals(com_google_android_gms_internal_zzsy_zzb.zzbuH);
        }

        public int hashCode() {
            int i = 0;
            int intValue = ((this.zzbuG == null ? 0 : this.zzbuG.intValue()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.zzbuH != null) {
                i = this.zzbuH.hashCode();
            }
            return intValue + i;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzR(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            if (this.name != null) {
                output.zzn(1, this.name);
            }
            if (this.zzbuG != null) {
                output.zzA(3, this.zzbuG.intValue());
            }
            if (this.zzbuH != null) {
                output.zze(4, this.zzbuH.booleanValue());
            }
            super.writeTo(output);
        }

        public zzb zzJB() {
            this.name = null;
            this.zzbuG = null;
            this.zzbuH = null;
            this.zzbuu = -1;
            return this;
        }

        public zzb zzR(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 24:
                        zzIX = com_google_android_gms_internal_zzsm.zzJb();
                        switch (zzIX) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                this.zzbuG = Integer.valueOf(zzIX);
                                break;
                            default:
                                continue;
                        }
                    case 32:
                        this.zzbuH = Boolean.valueOf(com_google_android_gms_internal_zzsm.zzJc());
                        continue;
                    default:
                        if (!zzsx.zzb(com_google_android_gms_internal_zzsm, zzIX)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (this.name != null) {
                zzz += zzsn.zzo(1, this.name);
            }
            if (this.zzbuG != null) {
                zzz += zzsn.zzC(3, this.zzbuG.intValue());
            }
            return this.zzbuH != null ? zzz + zzsn.zzf(4, this.zzbuH.booleanValue()) : zzz;
        }
    }
}
