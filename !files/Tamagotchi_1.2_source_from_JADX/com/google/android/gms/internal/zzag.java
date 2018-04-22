package com.google.android.gms.internal;

import java.io.IOException;

public interface zzag {

    public static final class zza extends zzso<zza> {
        private static volatile zza[] zzjw;
        public int type;
        public zza[] zzjA;
        public String zzjB;
        public String zzjC;
        public long zzjD;
        public boolean zzjE;
        public zza[] zzjF;
        public int[] zzjG;
        public boolean zzjH;
        public String zzjx;
        public zza[] zzjy;
        public zza[] zzjz;

        public zza() {
            zzR();
        }

        public static zza[] zzQ() {
            if (zzjw == null) {
                synchronized (zzss.zzbut) {
                    if (zzjw == null) {
                        zzjw = new zza[0];
                    }
                }
            }
            return zzjw;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzag_zza = (zza) o;
            if (this.type != com_google_android_gms_internal_zzag_zza.type) {
                return false;
            }
            if (this.zzjx == null) {
                if (com_google_android_gms_internal_zzag_zza.zzjx != null) {
                    return false;
                }
            } else if (!this.zzjx.equals(com_google_android_gms_internal_zzag_zza.zzjx)) {
                return false;
            }
            if (!zzss.equals(this.zzjy, com_google_android_gms_internal_zzag_zza.zzjy) || !zzss.equals(this.zzjz, com_google_android_gms_internal_zzag_zza.zzjz) || !zzss.equals(this.zzjA, com_google_android_gms_internal_zzag_zza.zzjA)) {
                return false;
            }
            if (this.zzjB == null) {
                if (com_google_android_gms_internal_zzag_zza.zzjB != null) {
                    return false;
                }
            } else if (!this.zzjB.equals(com_google_android_gms_internal_zzag_zza.zzjB)) {
                return false;
            }
            if (this.zzjC == null) {
                if (com_google_android_gms_internal_zzag_zza.zzjC != null) {
                    return false;
                }
            } else if (!this.zzjC.equals(com_google_android_gms_internal_zzag_zza.zzjC)) {
                return false;
            }
            if (this.zzjD != com_google_android_gms_internal_zzag_zza.zzjD || this.zzjE != com_google_android_gms_internal_zzag_zza.zzjE || !zzss.equals(this.zzjF, com_google_android_gms_internal_zzag_zza.zzjF) || !zzss.equals(this.zzjG, com_google_android_gms_internal_zzag_zza.zzjG) || this.zzjH != com_google_android_gms_internal_zzag_zza.zzjH) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzag_zza.zzbuj == null || com_google_android_gms_internal_zzag_zza.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzag_zza.zzbuj);
            }
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.zzjE ? 1231 : 1237) + (((((this.zzjC == null ? 0 : this.zzjC.hashCode()) + (((this.zzjB == null ? 0 : this.zzjB.hashCode()) + (((((((((this.zzjx == null ? 0 : this.zzjx.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31) + zzss.hashCode(this.zzjy)) * 31) + zzss.hashCode(this.zzjz)) * 31) + zzss.hashCode(this.zzjA)) * 31)) * 31)) * 31) + ((int) (this.zzjD ^ (this.zzjD >>> 32)))) * 31)) * 31) + zzss.hashCode(this.zzjF)) * 31) + zzss.hashCode(this.zzjG)) * 31;
            if (!this.zzjH) {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (!(this.zzbuj == null || this.zzbuj.isEmpty())) {
                i2 = this.zzbuj.hashCode();
            }
            return hashCode + i2;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzk(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            int i = 0;
            output.zzA(1, this.type);
            if (!this.zzjx.equals("")) {
                output.zzn(2, this.zzjx);
            }
            if (this.zzjy != null && this.zzjy.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu : this.zzjy) {
                    if (com_google_android_gms_internal_zzsu != null) {
                        output.zza(3, com_google_android_gms_internal_zzsu);
                    }
                }
            }
            if (this.zzjz != null && this.zzjz.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu2 : this.zzjz) {
                    if (com_google_android_gms_internal_zzsu2 != null) {
                        output.zza(4, com_google_android_gms_internal_zzsu2);
                    }
                }
            }
            if (this.zzjA != null && this.zzjA.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu22 : this.zzjA) {
                    if (com_google_android_gms_internal_zzsu22 != null) {
                        output.zza(5, com_google_android_gms_internal_zzsu22);
                    }
                }
            }
            if (!this.zzjB.equals("")) {
                output.zzn(6, this.zzjB);
            }
            if (!this.zzjC.equals("")) {
                output.zzn(7, this.zzjC);
            }
            if (this.zzjD != 0) {
                output.zzb(8, this.zzjD);
            }
            if (this.zzjH) {
                output.zze(9, this.zzjH);
            }
            if (this.zzjG != null && this.zzjG.length > 0) {
                for (int zzA : this.zzjG) {
                    output.zzA(10, zzA);
                }
            }
            if (this.zzjF != null && this.zzjF.length > 0) {
                while (i < this.zzjF.length) {
                    zzsu com_google_android_gms_internal_zzsu3 = this.zzjF[i];
                    if (com_google_android_gms_internal_zzsu3 != null) {
                        output.zza(11, com_google_android_gms_internal_zzsu3);
                    }
                    i++;
                }
            }
            if (this.zzjE) {
                output.zze(12, this.zzjE);
            }
            super.writeTo(output);
        }

        public zza zzR() {
            this.type = 1;
            this.zzjx = "";
            this.zzjy = zzQ();
            this.zzjz = zzQ();
            this.zzjA = zzQ();
            this.zzjB = "";
            this.zzjC = "";
            this.zzjD = 0;
            this.zzjE = false;
            this.zzjF = zzQ();
            this.zzjG = zzsx.zzbuw;
            this.zzjH = false;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        public zza zzk(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                int zzc;
                Object obj;
                int i;
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        zzIX = com_google_android_gms_internal_zzsm.zzJb();
                        switch (zzIX) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = zzIX;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzjx = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 26:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 26);
                        zzIX = this.zzjy == null ? 0 : this.zzjy.length;
                        obj = new zza[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjy, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zza();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zza();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zzjy = obj;
                        continue;
                    case 34:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 34);
                        zzIX = this.zzjz == null ? 0 : this.zzjz.length;
                        obj = new zza[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjz, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zza();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zza();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zzjz = obj;
                        continue;
                    case 42:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 42);
                        zzIX = this.zzjA == null ? 0 : this.zzjA.length;
                        obj = new zza[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjA, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zza();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zza();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zzjA = obj;
                        continue;
                    case 50:
                        this.zzjB = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 58:
                        this.zzjC = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 64:
                        this.zzjD = com_google_android_gms_internal_zzsm.zzJa();
                        continue;
                    case 72:
                        this.zzjH = com_google_android_gms_internal_zzsm.zzJc();
                        continue;
                    case 80:
                        int zzc2 = zzsx.zzc(com_google_android_gms_internal_zzsm, 80);
                        Object obj2 = new int[zzc2];
                        i = 0;
                        zzc = 0;
                        while (i < zzc2) {
                            if (i != 0) {
                                com_google_android_gms_internal_zzsm.zzIX();
                            }
                            int zzJb = com_google_android_gms_internal_zzsm.zzJb();
                            switch (zzJb) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    zzIX = zzc + 1;
                                    obj2[zzc] = zzJb;
                                    break;
                                default:
                                    zzIX = zzc;
                                    break;
                            }
                            i++;
                            zzc = zzIX;
                        }
                        if (zzc != 0) {
                            zzIX = this.zzjG == null ? 0 : this.zzjG.length;
                            if (zzIX != 0 || zzc != obj2.length) {
                                Object obj3 = new int[(zzIX + zzc)];
                                if (zzIX != 0) {
                                    System.arraycopy(this.zzjG, 0, obj3, 0, zzIX);
                                }
                                System.arraycopy(obj2, 0, obj3, zzIX, zzc);
                                this.zzjG = obj3;
                                break;
                            }
                            this.zzjG = obj2;
                            break;
                        }
                        continue;
                    case 82:
                        i = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            switch (com_google_android_gms_internal_zzsm.zzJb()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    zzIX++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (zzIX != 0) {
                            com_google_android_gms_internal_zzsm.zzms(zzc);
                            zzc = this.zzjG == null ? 0 : this.zzjG.length;
                            Object obj4 = new int[(zzIX + zzc)];
                            if (zzc != 0) {
                                System.arraycopy(this.zzjG, 0, obj4, 0, zzc);
                            }
                            while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                                int zzJb2 = com_google_android_gms_internal_zzsm.zzJb();
                                switch (zzJb2) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        zzIX = zzc + 1;
                                        obj4[zzc] = zzJb2;
                                        zzc = zzIX;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.zzjG = obj4;
                        }
                        com_google_android_gms_internal_zzsm.zzmr(i);
                        continue;
                    case 90:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 90);
                        zzIX = this.zzjF == null ? 0 : this.zzjF.length;
                        obj = new zza[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjF, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zza();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zza();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zzjF = obj;
                        continue;
                    case 96:
                        this.zzjE = com_google_android_gms_internal_zzsm.zzJc();
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
            int i;
            int i2 = 0;
            int zzz = super.zzz() + zzsn.zzC(1, this.type);
            if (!this.zzjx.equals("")) {
                zzz += zzsn.zzo(2, this.zzjx);
            }
            if (this.zzjy != null && this.zzjy.length > 0) {
                i = zzz;
                for (zzsu com_google_android_gms_internal_zzsu : this.zzjy) {
                    if (com_google_android_gms_internal_zzsu != null) {
                        i += zzsn.zzc(3, com_google_android_gms_internal_zzsu);
                    }
                }
                zzz = i;
            }
            if (this.zzjz != null && this.zzjz.length > 0) {
                i = zzz;
                for (zzsu com_google_android_gms_internal_zzsu2 : this.zzjz) {
                    if (com_google_android_gms_internal_zzsu2 != null) {
                        i += zzsn.zzc(4, com_google_android_gms_internal_zzsu2);
                    }
                }
                zzz = i;
            }
            if (this.zzjA != null && this.zzjA.length > 0) {
                i = zzz;
                for (zzsu com_google_android_gms_internal_zzsu22 : this.zzjA) {
                    if (com_google_android_gms_internal_zzsu22 != null) {
                        i += zzsn.zzc(5, com_google_android_gms_internal_zzsu22);
                    }
                }
                zzz = i;
            }
            if (!this.zzjB.equals("")) {
                zzz += zzsn.zzo(6, this.zzjB);
            }
            if (!this.zzjC.equals("")) {
                zzz += zzsn.zzo(7, this.zzjC);
            }
            if (this.zzjD != 0) {
                zzz += zzsn.zzd(8, this.zzjD);
            }
            if (this.zzjH) {
                zzz += zzsn.zzf(9, this.zzjH);
            }
            if (this.zzjG != null && this.zzjG.length > 0) {
                int i3 = 0;
                for (int zzmx : this.zzjG) {
                    i3 += zzsn.zzmx(zzmx);
                }
                zzz = (zzz + i3) + (this.zzjG.length * 1);
            }
            if (this.zzjF != null && this.zzjF.length > 0) {
                while (i2 < this.zzjF.length) {
                    zzsu com_google_android_gms_internal_zzsu3 = this.zzjF[i2];
                    if (com_google_android_gms_internal_zzsu3 != null) {
                        zzz += zzsn.zzc(11, com_google_android_gms_internal_zzsu3);
                    }
                    i2++;
                }
            }
            return this.zzjE ? zzz + zzsn.zzf(12, this.zzjE) : zzz;
        }
    }
}
