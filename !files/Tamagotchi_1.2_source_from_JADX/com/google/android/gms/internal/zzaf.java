package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;

public interface zzaf {

    public static final class zza extends zzso<zza> {
        public int level;
        public int zziq;
        public int zzir;

        public zza() {
            zzB();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzaf_zza = (zza) o;
            if (this.level != com_google_android_gms_internal_zzaf_zza.level || this.zziq != com_google_android_gms_internal_zzaf_zza.zziq || this.zzir != com_google_android_gms_internal_zzaf_zza.zzir) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zza.zzbuj == null || com_google_android_gms_internal_zzaf_zza.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzaf_zza.zzbuj);
            }
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zziq) * 31) + this.zzir) * 31;
            int hashCode2 = (this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zza(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            if (this.level != 1) {
                output.zzA(1, this.level);
            }
            if (this.zziq != 0) {
                output.zzA(2, this.zziq);
            }
            if (this.zzir != 0) {
                output.zzA(3, this.zzir);
            }
            super.writeTo(output);
        }

        public zza zzB() {
            this.level = 1;
            this.zziq = 0;
            this.zzir = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        public zza zza(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        zzIX = com_google_android_gms_internal_zzsm.zzJb();
                        switch (zzIX) {
                            case 1:
                            case 2:
                            case 3:
                                this.level = zzIX;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.zziq = com_google_android_gms_internal_zzsm.zzJb();
                        continue;
                    case 24:
                        this.zzir = com_google_android_gms_internal_zzsm.zzJb();
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
            int zzz = super.zzz();
            if (this.level != 1) {
                zzz += zzsn.zzC(1, this.level);
            }
            if (this.zziq != 0) {
                zzz += zzsn.zzC(2, this.zziq);
            }
            return this.zzir != 0 ? zzz + zzsn.zzC(3, this.zzir) : zzz;
        }
    }

    public static final class zzb extends zzso<zzb> {
        private static volatile zzb[] zzis;
        public int name;
        public int[] zzit;
        public int zziu;
        public boolean zziv;
        public boolean zziw;

        public zzb() {
            zzD();
        }

        public static zzb[] zzC() {
            if (zzis == null) {
                synchronized (zzss.zzbut) {
                    if (zzis == null) {
                        zzis = new zzb[0];
                    }
                }
            }
            return zzis;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzaf_zzb = (zzb) o;
            if (!zzss.equals(this.zzit, com_google_android_gms_internal_zzaf_zzb.zzit) || this.zziu != com_google_android_gms_internal_zzaf_zzb.zziu || this.name != com_google_android_gms_internal_zzaf_zzb.name || this.zziv != com_google_android_gms_internal_zzaf_zzb.zziv || this.zziw != com_google_android_gms_internal_zzaf_zzb.zziw) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzb.zzbuj == null || com_google_android_gms_internal_zzaf_zzb.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzaf_zzb.zzbuj);
            }
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zziv ? 1231 : 1237) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzit)) * 31) + this.zziu) * 31) + this.name) * 31)) * 31;
            if (!this.zziw) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            hashCode = (this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode();
            return hashCode + i;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzb(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            if (this.zziw) {
                output.zze(1, this.zziw);
            }
            output.zzA(2, this.zziu);
            if (this.zzit != null && this.zzit.length > 0) {
                for (int zzA : this.zzit) {
                    output.zzA(3, zzA);
                }
            }
            if (this.name != 0) {
                output.zzA(4, this.name);
            }
            if (this.zziv) {
                output.zze(6, this.zziv);
            }
            super.writeTo(output);
        }

        public zzb zzD() {
            this.zzit = zzsx.zzbuw;
            this.zziu = 0;
            this.name = 0;
            this.zziv = false;
            this.zziw = false;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        public zzb zzb(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                int zzc;
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zziw = com_google_android_gms_internal_zzsm.zzJc();
                        continue;
                    case 16:
                        this.zziu = com_google_android_gms_internal_zzsm.zzJb();
                        continue;
                    case 24:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 24);
                        zzIX = this.zzit == null ? 0 : this.zzit.length;
                        Object obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzit, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zzit = obj;
                        continue;
                    case 26:
                        int zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zzit == null ? 0 : this.zzit.length;
                        Object obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzit, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zzit = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 32:
                        this.name = com_google_android_gms_internal_zzsm.zzJb();
                        continue;
                    case 48:
                        this.zziv = com_google_android_gms_internal_zzsm.zzJc();
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
            int i = 0;
            int zzz = super.zzz();
            if (this.zziw) {
                zzz += zzsn.zzf(1, this.zziw);
            }
            int zzC = zzsn.zzC(2, this.zziu) + zzz;
            if (this.zzit == null || this.zzit.length <= 0) {
                zzz = zzC;
            } else {
                for (int zzmx : this.zzit) {
                    i += zzsn.zzmx(zzmx);
                }
                zzz = (zzC + i) + (this.zzit.length * 1);
            }
            if (this.name != 0) {
                zzz += zzsn.zzC(4, this.name);
            }
            return this.zziv ? zzz + zzsn.zzf(6, this.zziv) : zzz;
        }
    }

    public static final class zzc extends zzso<zzc> {
        private static volatile zzc[] zzix;
        public String key;
        public boolean zziA;
        public long zziB;
        public long zziy;
        public long zziz;

        public zzc() {
            zzF();
        }

        public static zzc[] zzE() {
            if (zzix == null) {
                synchronized (zzss.zzbut) {
                    if (zzix == null) {
                        zzix = new zzc[0];
                    }
                }
            }
            return zzix;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzaf_zzc = (zzc) o;
            if (this.key == null) {
                if (com_google_android_gms_internal_zzaf_zzc.key != null) {
                    return false;
                }
            } else if (!this.key.equals(com_google_android_gms_internal_zzaf_zzc.key)) {
                return false;
            }
            if (this.zziy != com_google_android_gms_internal_zzaf_zzc.zziy || this.zziz != com_google_android_gms_internal_zzaf_zzc.zziz || this.zziA != com_google_android_gms_internal_zzaf_zzc.zziA || this.zziB != com_google_android_gms_internal_zzaf_zzc.zziB) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzc.zzbuj == null || com_google_android_gms_internal_zzaf_zzc.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzaf_zzc.zzbuj);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zziA ? 1231 : 1237) + (((((((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + ((int) (this.zziy ^ (this.zziy >>> 32)))) * 31) + ((int) (this.zziz ^ (this.zziz >>> 32)))) * 31)) * 31) + ((int) (this.zziB ^ (this.zziB >>> 32)))) * 31;
            if (!(this.zzbuj == null || this.zzbuj.isEmpty())) {
                i = this.zzbuj.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzc(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            if (!this.key.equals("")) {
                output.zzn(1, this.key);
            }
            if (this.zziy != 0) {
                output.zzb(2, this.zziy);
            }
            if (this.zziz != 2147483647L) {
                output.zzb(3, this.zziz);
            }
            if (this.zziA) {
                output.zze(4, this.zziA);
            }
            if (this.zziB != 0) {
                output.zzb(5, this.zziB);
            }
            super.writeTo(output);
        }

        public zzc zzF() {
            this.key = "";
            this.zziy = 0;
            this.zziz = 2147483647L;
            this.zziA = false;
            this.zziB = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        public zzc zzc(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.key = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 16:
                        this.zziy = com_google_android_gms_internal_zzsm.zzJa();
                        continue;
                    case 24:
                        this.zziz = com_google_android_gms_internal_zzsm.zzJa();
                        continue;
                    case 32:
                        this.zziA = com_google_android_gms_internal_zzsm.zzJc();
                        continue;
                    case 40:
                        this.zziB = com_google_android_gms_internal_zzsm.zzJa();
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
            int zzz = super.zzz();
            if (!this.key.equals("")) {
                zzz += zzsn.zzo(1, this.key);
            }
            if (this.zziy != 0) {
                zzz += zzsn.zzd(2, this.zziy);
            }
            if (this.zziz != 2147483647L) {
                zzz += zzsn.zzd(3, this.zziz);
            }
            if (this.zziA) {
                zzz += zzsn.zzf(4, this.zziA);
            }
            return this.zziB != 0 ? zzz + zzsn.zzd(5, this.zziB) : zzz;
        }
    }

    public static final class zzd extends zzso<zzd> {
        public com.google.android.gms.internal.zzag.zza[] zziC;
        public com.google.android.gms.internal.zzag.zza[] zziD;
        public zzc[] zziE;

        public zzd() {
            zzG();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzaf_zzd = (zzd) o;
            if (!zzss.equals(this.zziC, com_google_android_gms_internal_zzaf_zzd.zziC) || !zzss.equals(this.zziD, com_google_android_gms_internal_zzaf_zzd.zziD) || !zzss.equals(this.zziE, com_google_android_gms_internal_zzaf_zzd.zziE)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzd.zzbuj == null || com_google_android_gms_internal_zzaf_zzd.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzaf_zzd.zzbuj);
            }
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zziC)) * 31) + zzss.hashCode(this.zziD)) * 31) + zzss.hashCode(this.zziE)) * 31;
            int hashCode2 = (this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzd(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            int i = 0;
            if (this.zziC != null && this.zziC.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu : this.zziC) {
                    if (com_google_android_gms_internal_zzsu != null) {
                        output.zza(1, com_google_android_gms_internal_zzsu);
                    }
                }
            }
            if (this.zziD != null && this.zziD.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu2 : this.zziD) {
                    if (com_google_android_gms_internal_zzsu2 != null) {
                        output.zza(2, com_google_android_gms_internal_zzsu2);
                    }
                }
            }
            if (this.zziE != null && this.zziE.length > 0) {
                while (i < this.zziE.length) {
                    zzsu com_google_android_gms_internal_zzsu3 = this.zziE[i];
                    if (com_google_android_gms_internal_zzsu3 != null) {
                        output.zza(3, com_google_android_gms_internal_zzsu3);
                    }
                    i++;
                }
            }
            super.writeTo(output);
        }

        public zzd zzG() {
            this.zziC = com.google.android.gms.internal.zzag.zza.zzQ();
            this.zziD = com.google.android.gms.internal.zzag.zza.zzQ();
            this.zziE = zzc.zzE();
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        public zzd zzd(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                int zzc;
                Object obj;
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 10);
                        zzIX = this.zziC == null ? 0 : this.zziC.length;
                        obj = new com.google.android.gms.internal.zzag.zza[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziC, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new com.google.android.gms.internal.zzag.zza();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new com.google.android.gms.internal.zzag.zza();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zziC = obj;
                        continue;
                    case 18:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 18);
                        zzIX = this.zziD == null ? 0 : this.zziD.length;
                        obj = new com.google.android.gms.internal.zzag.zza[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziD, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new com.google.android.gms.internal.zzag.zza();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new com.google.android.gms.internal.zzag.zza();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zziD = obj;
                        continue;
                    case 26:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 26);
                        zzIX = this.zziE == null ? 0 : this.zziE.length;
                        obj = new zzc[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziE, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zzc();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zzc();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zziE = obj;
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
            int zzz = super.zzz();
            if (this.zziC != null && this.zziC.length > 0) {
                i = zzz;
                for (zzsu com_google_android_gms_internal_zzsu : this.zziC) {
                    if (com_google_android_gms_internal_zzsu != null) {
                        i += zzsn.zzc(1, com_google_android_gms_internal_zzsu);
                    }
                }
                zzz = i;
            }
            if (this.zziD != null && this.zziD.length > 0) {
                i = zzz;
                for (zzsu com_google_android_gms_internal_zzsu2 : this.zziD) {
                    if (com_google_android_gms_internal_zzsu2 != null) {
                        i += zzsn.zzc(2, com_google_android_gms_internal_zzsu2);
                    }
                }
                zzz = i;
            }
            if (this.zziE != null && this.zziE.length > 0) {
                while (i2 < this.zziE.length) {
                    zzsu com_google_android_gms_internal_zzsu3 = this.zziE[i2];
                    if (com_google_android_gms_internal_zzsu3 != null) {
                        zzz += zzsn.zzc(3, com_google_android_gms_internal_zzsu3);
                    }
                    i2++;
                }
            }
            return zzz;
        }
    }

    public static final class zze extends zzso<zze> {
        private static volatile zze[] zziF;
        public int key;
        public int value;

        public zze() {
            zzI();
        }

        public static zze[] zzH() {
            if (zziF == null) {
                synchronized (zzss.zzbut) {
                    if (zziF == null) {
                        zziF = new zze[0];
                    }
                }
            }
            return zziF;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzaf_zze = (zze) o;
            if (this.key != com_google_android_gms_internal_zzaf_zze.key || this.value != com_google_android_gms_internal_zzaf_zze.value) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zze.zzbuj == null || com_google_android_gms_internal_zzaf_zze.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzaf_zze.zzbuj);
            }
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31;
            int hashCode2 = (this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zze(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            output.zzA(1, this.key);
            output.zzA(2, this.value);
            super.writeTo(output);
        }

        public zze zzI() {
            this.key = 0;
            this.value = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        public zze zze(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.key = com_google_android_gms_internal_zzsm.zzJb();
                        continue;
                    case 16:
                        this.value = com_google_android_gms_internal_zzsm.zzJb();
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
            return (super.zzz() + zzsn.zzC(1, this.key)) + zzsn.zzC(2, this.value);
        }
    }

    public static final class zzf extends zzso<zzf> {
        public String version;
        public String[] zziG;
        public String[] zziH;
        public com.google.android.gms.internal.zzag.zza[] zziI;
        public zze[] zziJ;
        public zzb[] zziK;
        public zzb[] zziL;
        public zzb[] zziM;
        public zzg[] zziN;
        public String zziO;
        public String zziP;
        public String zziQ;
        public zza zziR;
        public float zziS;
        public boolean zziT;
        public String[] zziU;
        public int zziV;

        public zzf() {
            zzJ();
        }

        public static zzf zzc(byte[] bArr) throws zzst {
            return (zzf) zzsu.mergeFrom(new zzf(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzf)) {
                return false;
            }
            zzf com_google_android_gms_internal_zzaf_zzf = (zzf) o;
            if (!zzss.equals(this.zziG, com_google_android_gms_internal_zzaf_zzf.zziG) || !zzss.equals(this.zziH, com_google_android_gms_internal_zzaf_zzf.zziH) || !zzss.equals(this.zziI, com_google_android_gms_internal_zzaf_zzf.zziI) || !zzss.equals(this.zziJ, com_google_android_gms_internal_zzaf_zzf.zziJ) || !zzss.equals(this.zziK, com_google_android_gms_internal_zzaf_zzf.zziK) || !zzss.equals(this.zziL, com_google_android_gms_internal_zzaf_zzf.zziL) || !zzss.equals(this.zziM, com_google_android_gms_internal_zzaf_zzf.zziM) || !zzss.equals(this.zziN, com_google_android_gms_internal_zzaf_zzf.zziN)) {
                return false;
            }
            if (this.zziO == null) {
                if (com_google_android_gms_internal_zzaf_zzf.zziO != null) {
                    return false;
                }
            } else if (!this.zziO.equals(com_google_android_gms_internal_zzaf_zzf.zziO)) {
                return false;
            }
            if (this.zziP == null) {
                if (com_google_android_gms_internal_zzaf_zzf.zziP != null) {
                    return false;
                }
            } else if (!this.zziP.equals(com_google_android_gms_internal_zzaf_zzf.zziP)) {
                return false;
            }
            if (this.zziQ == null) {
                if (com_google_android_gms_internal_zzaf_zzf.zziQ != null) {
                    return false;
                }
            } else if (!this.zziQ.equals(com_google_android_gms_internal_zzaf_zzf.zziQ)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zzaf_zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zzaf_zzf.version)) {
                return false;
            }
            if (this.zziR == null) {
                if (com_google_android_gms_internal_zzaf_zzf.zziR != null) {
                    return false;
                }
            } else if (!this.zziR.equals(com_google_android_gms_internal_zzaf_zzf.zziR)) {
                return false;
            }
            if (Float.floatToIntBits(this.zziS) != Float.floatToIntBits(com_google_android_gms_internal_zzaf_zzf.zziS) || this.zziT != com_google_android_gms_internal_zzaf_zzf.zziT || !zzss.equals(this.zziU, com_google_android_gms_internal_zzaf_zzf.zziU) || this.zziV != com_google_android_gms_internal_zzaf_zzf.zziV) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzf.zzbuj == null || com_google_android_gms_internal_zzaf_zzf.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzaf_zzf.zzbuj);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.zziT ? 1231 : 1237) + (((((this.zziR == null ? 0 : this.zziR.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zziQ == null ? 0 : this.zziQ.hashCode()) + (((this.zziP == null ? 0 : this.zziP.hashCode()) + (((this.zziO == null ? 0 : this.zziO.hashCode()) + ((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zziG)) * 31) + zzss.hashCode(this.zziH)) * 31) + zzss.hashCode(this.zziI)) * 31) + zzss.hashCode(this.zziJ)) * 31) + zzss.hashCode(this.zziK)) * 31) + zzss.hashCode(this.zziL)) * 31) + zzss.hashCode(this.zziM)) * 31) + zzss.hashCode(this.zziN)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.zziS)) * 31)) * 31) + zzss.hashCode(this.zziU)) * 31) + this.zziV) * 31;
            if (!(this.zzbuj == null || this.zzbuj.isEmpty())) {
                i = this.zzbuj.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzf(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            int i = 0;
            if (this.zziH != null && this.zziH.length > 0) {
                for (String str : this.zziH) {
                    if (str != null) {
                        output.zzn(1, str);
                    }
                }
            }
            if (this.zziI != null && this.zziI.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu : this.zziI) {
                    if (com_google_android_gms_internal_zzsu != null) {
                        output.zza(2, com_google_android_gms_internal_zzsu);
                    }
                }
            }
            if (this.zziJ != null && this.zziJ.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu2 : this.zziJ) {
                    if (com_google_android_gms_internal_zzsu2 != null) {
                        output.zza(3, com_google_android_gms_internal_zzsu2);
                    }
                }
            }
            if (this.zziK != null && this.zziK.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu22 : this.zziK) {
                    if (com_google_android_gms_internal_zzsu22 != null) {
                        output.zza(4, com_google_android_gms_internal_zzsu22);
                    }
                }
            }
            if (this.zziL != null && this.zziL.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu222 : this.zziL) {
                    if (com_google_android_gms_internal_zzsu222 != null) {
                        output.zza(5, com_google_android_gms_internal_zzsu222);
                    }
                }
            }
            if (this.zziM != null && this.zziM.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu2222 : this.zziM) {
                    if (com_google_android_gms_internal_zzsu2222 != null) {
                        output.zza(6, com_google_android_gms_internal_zzsu2222);
                    }
                }
            }
            if (this.zziN != null && this.zziN.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu22222 : this.zziN) {
                    if (com_google_android_gms_internal_zzsu22222 != null) {
                        output.zza(7, com_google_android_gms_internal_zzsu22222);
                    }
                }
            }
            if (!this.zziO.equals("")) {
                output.zzn(9, this.zziO);
            }
            if (!this.zziP.equals("")) {
                output.zzn(10, this.zziP);
            }
            if (!this.zziQ.equals("0")) {
                output.zzn(12, this.zziQ);
            }
            if (!this.version.equals("")) {
                output.zzn(13, this.version);
            }
            if (this.zziR != null) {
                output.zza(14, this.zziR);
            }
            if (Float.floatToIntBits(this.zziS) != Float.floatToIntBits(0.0f)) {
                output.zzb(15, this.zziS);
            }
            if (this.zziU != null && this.zziU.length > 0) {
                for (String str2 : this.zziU) {
                    if (str2 != null) {
                        output.zzn(16, str2);
                    }
                }
            }
            if (this.zziV != 0) {
                output.zzA(17, this.zziV);
            }
            if (this.zziT) {
                output.zze(18, this.zziT);
            }
            if (this.zziG != null && this.zziG.length > 0) {
                while (i < this.zziG.length) {
                    String str3 = this.zziG[i];
                    if (str3 != null) {
                        output.zzn(19, str3);
                    }
                    i++;
                }
            }
            super.writeTo(output);
        }

        public zzf zzJ() {
            this.zziG = zzsx.zzbuB;
            this.zziH = zzsx.zzbuB;
            this.zziI = com.google.android.gms.internal.zzag.zza.zzQ();
            this.zziJ = zze.zzH();
            this.zziK = zzb.zzC();
            this.zziL = zzb.zzC();
            this.zziM = zzb.zzC();
            this.zziN = zzg.zzK();
            this.zziO = "";
            this.zziP = "";
            this.zziQ = "0";
            this.version = "";
            this.zziR = null;
            this.zziS = 0.0f;
            this.zziT = false;
            this.zziU = zzsx.zzbuB;
            this.zziV = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        public zzf zzf(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                int zzc;
                Object obj;
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 10);
                        zzIX = this.zziH == null ? 0 : this.zziH.length;
                        obj = new String[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziH, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.readString();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.readString();
                        this.zziH = obj;
                        continue;
                    case 18:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 18);
                        zzIX = this.zziI == null ? 0 : this.zziI.length;
                        obj = new com.google.android.gms.internal.zzag.zza[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziI, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new com.google.android.gms.internal.zzag.zza();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new com.google.android.gms.internal.zzag.zza();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zziI = obj;
                        continue;
                    case 26:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 26);
                        zzIX = this.zziJ == null ? 0 : this.zziJ.length;
                        obj = new zze[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziJ, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zze();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zze();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zziJ = obj;
                        continue;
                    case 34:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 34);
                        zzIX = this.zziK == null ? 0 : this.zziK.length;
                        obj = new zzb[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziK, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zzb();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zzb();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zziK = obj;
                        continue;
                    case 42:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 42);
                        zzIX = this.zziL == null ? 0 : this.zziL.length;
                        obj = new zzb[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziL, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zzb();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zzb();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zziL = obj;
                        continue;
                    case 50:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 50);
                        zzIX = this.zziM == null ? 0 : this.zziM.length;
                        obj = new zzb[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziM, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zzb();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zzb();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zziM = obj;
                        continue;
                    case 58:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 58);
                        zzIX = this.zziN == null ? 0 : this.zziN.length;
                        obj = new zzg[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziN, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zzg();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zzg();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zziN = obj;
                        continue;
                    case 74:
                        this.zziO = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 82:
                        this.zziP = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 98:
                        this.zziQ = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 106:
                        this.version = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 114:
                        if (this.zziR == null) {
                            this.zziR = new zza();
                        }
                        com_google_android_gms_internal_zzsm.zza(this.zziR);
                        continue;
                    case 125:
                        this.zziS = com_google_android_gms_internal_zzsm.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, TransportMediator.KEYCODE_MEDIA_RECORD);
                        zzIX = this.zziU == null ? 0 : this.zziU.length;
                        obj = new String[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziU, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.readString();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.readString();
                        this.zziU = obj;
                        continue;
                    case 136:
                        this.zziV = com_google_android_gms_internal_zzsm.zzJb();
                        continue;
                    case 144:
                        this.zziT = com_google_android_gms_internal_zzsm.zzJc();
                        continue;
                    case 154:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 154);
                        zzIX = this.zziG == null ? 0 : this.zziG.length;
                        obj = new String[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziG, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.readString();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.readString();
                        this.zziG = obj;
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
            int i2;
            int i3;
            int i4 = 0;
            int zzz = super.zzz();
            if (this.zziH == null || this.zziH.length <= 0) {
                i = zzz;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zziH) {
                    if (str != null) {
                        i3++;
                        i2 += zzsn.zzgO(str);
                    }
                }
                i = (zzz + i2) + (i3 * 1);
            }
            if (this.zziI != null && this.zziI.length > 0) {
                i2 = i;
                for (zzsu com_google_android_gms_internal_zzsu : this.zziI) {
                    if (com_google_android_gms_internal_zzsu != null) {
                        i2 += zzsn.zzc(2, com_google_android_gms_internal_zzsu);
                    }
                }
                i = i2;
            }
            if (this.zziJ != null && this.zziJ.length > 0) {
                i2 = i;
                for (zzsu com_google_android_gms_internal_zzsu2 : this.zziJ) {
                    if (com_google_android_gms_internal_zzsu2 != null) {
                        i2 += zzsn.zzc(3, com_google_android_gms_internal_zzsu2);
                    }
                }
                i = i2;
            }
            if (this.zziK != null && this.zziK.length > 0) {
                i2 = i;
                for (zzsu com_google_android_gms_internal_zzsu22 : this.zziK) {
                    if (com_google_android_gms_internal_zzsu22 != null) {
                        i2 += zzsn.zzc(4, com_google_android_gms_internal_zzsu22);
                    }
                }
                i = i2;
            }
            if (this.zziL != null && this.zziL.length > 0) {
                i2 = i;
                for (zzsu com_google_android_gms_internal_zzsu222 : this.zziL) {
                    if (com_google_android_gms_internal_zzsu222 != null) {
                        i2 += zzsn.zzc(5, com_google_android_gms_internal_zzsu222);
                    }
                }
                i = i2;
            }
            if (this.zziM != null && this.zziM.length > 0) {
                i2 = i;
                for (zzsu com_google_android_gms_internal_zzsu2222 : this.zziM) {
                    if (com_google_android_gms_internal_zzsu2222 != null) {
                        i2 += zzsn.zzc(6, com_google_android_gms_internal_zzsu2222);
                    }
                }
                i = i2;
            }
            if (this.zziN != null && this.zziN.length > 0) {
                i2 = i;
                for (zzsu com_google_android_gms_internal_zzsu22222 : this.zziN) {
                    if (com_google_android_gms_internal_zzsu22222 != null) {
                        i2 += zzsn.zzc(7, com_google_android_gms_internal_zzsu22222);
                    }
                }
                i = i2;
            }
            if (!this.zziO.equals("")) {
                i += zzsn.zzo(9, this.zziO);
            }
            if (!this.zziP.equals("")) {
                i += zzsn.zzo(10, this.zziP);
            }
            if (!this.zziQ.equals("0")) {
                i += zzsn.zzo(12, this.zziQ);
            }
            if (!this.version.equals("")) {
                i += zzsn.zzo(13, this.version);
            }
            if (this.zziR != null) {
                i += zzsn.zzc(14, this.zziR);
            }
            if (Float.floatToIntBits(this.zziS) != Float.floatToIntBits(0.0f)) {
                i += zzsn.zzc(15, this.zziS);
            }
            if (this.zziU != null && this.zziU.length > 0) {
                i3 = 0;
                zzz = 0;
                for (String str2 : this.zziU) {
                    if (str2 != null) {
                        zzz++;
                        i3 += zzsn.zzgO(str2);
                    }
                }
                i = (i + i3) + (zzz * 2);
            }
            if (this.zziV != 0) {
                i += zzsn.zzC(17, this.zziV);
            }
            if (this.zziT) {
                i += zzsn.zzf(18, this.zziT);
            }
            if (this.zziG == null || this.zziG.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.zziG.length) {
                String str3 = this.zziG[i4];
                if (str3 != null) {
                    i3++;
                    i2 += zzsn.zzgO(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }
    }

    public static final class zzg extends zzso<zzg> {
        private static volatile zzg[] zziW;
        public int[] zziX;
        public int[] zziY;
        public int[] zziZ;
        public int[] zzja;
        public int[] zzjb;
        public int[] zzjc;
        public int[] zzjd;
        public int[] zzje;
        public int[] zzjf;
        public int[] zzjg;

        public zzg() {
            zzL();
        }

        public static zzg[] zzK() {
            if (zziW == null) {
                synchronized (zzss.zzbut) {
                    if (zziW == null) {
                        zziW = new zzg[0];
                    }
                }
            }
            return zziW;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzg)) {
                return false;
            }
            zzg com_google_android_gms_internal_zzaf_zzg = (zzg) o;
            if (!zzss.equals(this.zziX, com_google_android_gms_internal_zzaf_zzg.zziX) || !zzss.equals(this.zziY, com_google_android_gms_internal_zzaf_zzg.zziY) || !zzss.equals(this.zziZ, com_google_android_gms_internal_zzaf_zzg.zziZ) || !zzss.equals(this.zzja, com_google_android_gms_internal_zzaf_zzg.zzja) || !zzss.equals(this.zzjb, com_google_android_gms_internal_zzaf_zzg.zzjb) || !zzss.equals(this.zzjc, com_google_android_gms_internal_zzaf_zzg.zzjc) || !zzss.equals(this.zzjd, com_google_android_gms_internal_zzaf_zzg.zzjd) || !zzss.equals(this.zzje, com_google_android_gms_internal_zzaf_zzg.zzje) || !zzss.equals(this.zzjf, com_google_android_gms_internal_zzaf_zzg.zzjf) || !zzss.equals(this.zzjg, com_google_android_gms_internal_zzaf_zzg.zzjg)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzg.zzbuj == null || com_google_android_gms_internal_zzaf_zzg.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzaf_zzg.zzbuj);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zziX)) * 31) + zzss.hashCode(this.zziY)) * 31) + zzss.hashCode(this.zziZ)) * 31) + zzss.hashCode(this.zzja)) * 31) + zzss.hashCode(this.zzjb)) * 31) + zzss.hashCode(this.zzjc)) * 31) + zzss.hashCode(this.zzjd)) * 31) + zzss.hashCode(this.zzje)) * 31) + zzss.hashCode(this.zzjf)) * 31) + zzss.hashCode(this.zzjg)) * 31;
            int hashCode2 = (this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzg(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            int i = 0;
            if (this.zziX != null && this.zziX.length > 0) {
                for (int zzA : this.zziX) {
                    output.zzA(1, zzA);
                }
            }
            if (this.zziY != null && this.zziY.length > 0) {
                for (int zzA2 : this.zziY) {
                    output.zzA(2, zzA2);
                }
            }
            if (this.zziZ != null && this.zziZ.length > 0) {
                for (int zzA22 : this.zziZ) {
                    output.zzA(3, zzA22);
                }
            }
            if (this.zzja != null && this.zzja.length > 0) {
                for (int zzA222 : this.zzja) {
                    output.zzA(4, zzA222);
                }
            }
            if (this.zzjb != null && this.zzjb.length > 0) {
                for (int zzA2222 : this.zzjb) {
                    output.zzA(5, zzA2222);
                }
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                for (int zzA22222 : this.zzjc) {
                    output.zzA(6, zzA22222);
                }
            }
            if (this.zzjd != null && this.zzjd.length > 0) {
                for (int zzA222222 : this.zzjd) {
                    output.zzA(7, zzA222222);
                }
            }
            if (this.zzje != null && this.zzje.length > 0) {
                for (int zzA2222222 : this.zzje) {
                    output.zzA(8, zzA2222222);
                }
            }
            if (this.zzjf != null && this.zzjf.length > 0) {
                for (int zzA22222222 : this.zzjf) {
                    output.zzA(9, zzA22222222);
                }
            }
            if (this.zzjg != null && this.zzjg.length > 0) {
                while (i < this.zzjg.length) {
                    output.zzA(10, this.zzjg[i]);
                    i++;
                }
            }
            super.writeTo(output);
        }

        public zzg zzL() {
            this.zziX = zzsx.zzbuw;
            this.zziY = zzsx.zzbuw;
            this.zziZ = zzsx.zzbuw;
            this.zzja = zzsx.zzbuw;
            this.zzjb = zzsx.zzbuw;
            this.zzjc = zzsx.zzbuw;
            this.zzjd = zzsx.zzbuw;
            this.zzje = zzsx.zzbuw;
            this.zzjf = zzsx.zzbuw;
            this.zzjg = zzsx.zzbuw;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        public zzg zzg(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                int zzc;
                Object obj;
                int zzmq;
                Object obj2;
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 8);
                        zzIX = this.zziX == null ? 0 : this.zziX.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziX, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zziX = obj;
                        continue;
                    case 10:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zziX == null ? 0 : this.zziX.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziX, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zziX = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 16:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 16);
                        zzIX = this.zziY == null ? 0 : this.zziY.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziY, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zziY = obj;
                        continue;
                    case 18:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zziY == null ? 0 : this.zziY.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziY, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zziY = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 24:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 24);
                        zzIX = this.zziZ == null ? 0 : this.zziZ.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zziZ, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zziZ = obj;
                        continue;
                    case 26:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zziZ == null ? 0 : this.zziZ.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziZ, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zziZ = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 32:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 32);
                        zzIX = this.zzja == null ? 0 : this.zzja.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzja, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zzja = obj;
                        continue;
                    case 34:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zzja == null ? 0 : this.zzja.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzja, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zzja = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 40:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 40);
                        zzIX = this.zzjb == null ? 0 : this.zzjb.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjb, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zzjb = obj;
                        continue;
                    case 42:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zzjb == null ? 0 : this.zzjb.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzjb, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zzjb = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 48:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 48);
                        zzIX = this.zzjc == null ? 0 : this.zzjc.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjc, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zzjc = obj;
                        continue;
                    case 50:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zzjc == null ? 0 : this.zzjc.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzjc, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zzjc = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 56:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 56);
                        zzIX = this.zzjd == null ? 0 : this.zzjd.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjd, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zzjd = obj;
                        continue;
                    case 58:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zzjd == null ? 0 : this.zzjd.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzjd, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zzjd = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 64:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 64);
                        zzIX = this.zzje == null ? 0 : this.zzje.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzje, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zzje = obj;
                        continue;
                    case 66:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zzje == null ? 0 : this.zzje.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzje, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zzje = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 72:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 72);
                        zzIX = this.zzjf == null ? 0 : this.zzjf.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjf, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zzjf = obj;
                        continue;
                    case 74:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zzjf == null ? 0 : this.zzjf.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzjf, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zzjf = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 80:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 80);
                        zzIX = this.zzjg == null ? 0 : this.zzjg.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjg, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zzjg = obj;
                        continue;
                    case 82:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zzjg == null ? 0 : this.zzjg.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzjg, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zzjg = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
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
            int i2;
            int i3 = 0;
            int zzz = super.zzz();
            if (this.zziX == null || this.zziX.length <= 0) {
                i = zzz;
            } else {
                i2 = 0;
                for (int zzmx : this.zziX) {
                    i2 += zzsn.zzmx(zzmx);
                }
                i = (zzz + i2) + (this.zziX.length * 1);
            }
            if (this.zziY != null && this.zziY.length > 0) {
                zzz = 0;
                for (int zzmx2 : this.zziY) {
                    zzz += zzsn.zzmx(zzmx2);
                }
                i = (i + zzz) + (this.zziY.length * 1);
            }
            if (this.zziZ != null && this.zziZ.length > 0) {
                zzz = 0;
                for (int zzmx22 : this.zziZ) {
                    zzz += zzsn.zzmx(zzmx22);
                }
                i = (i + zzz) + (this.zziZ.length * 1);
            }
            if (this.zzja != null && this.zzja.length > 0) {
                zzz = 0;
                for (int zzmx222 : this.zzja) {
                    zzz += zzsn.zzmx(zzmx222);
                }
                i = (i + zzz) + (this.zzja.length * 1);
            }
            if (this.zzjb != null && this.zzjb.length > 0) {
                zzz = 0;
                for (int zzmx2222 : this.zzjb) {
                    zzz += zzsn.zzmx(zzmx2222);
                }
                i = (i + zzz) + (this.zzjb.length * 1);
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                zzz = 0;
                for (int zzmx22222 : this.zzjc) {
                    zzz += zzsn.zzmx(zzmx22222);
                }
                i = (i + zzz) + (this.zzjc.length * 1);
            }
            if (this.zzjd != null && this.zzjd.length > 0) {
                zzz = 0;
                for (int zzmx222222 : this.zzjd) {
                    zzz += zzsn.zzmx(zzmx222222);
                }
                i = (i + zzz) + (this.zzjd.length * 1);
            }
            if (this.zzje != null && this.zzje.length > 0) {
                zzz = 0;
                for (int zzmx2222222 : this.zzje) {
                    zzz += zzsn.zzmx(zzmx2222222);
                }
                i = (i + zzz) + (this.zzje.length * 1);
            }
            if (this.zzjf != null && this.zzjf.length > 0) {
                zzz = 0;
                for (int zzmx22222222 : this.zzjf) {
                    zzz += zzsn.zzmx(zzmx22222222);
                }
                i = (i + zzz) + (this.zzjf.length * 1);
            }
            if (this.zzjg == null || this.zzjg.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.zzjg.length) {
                i2 += zzsn.zzmx(this.zzjg[i3]);
                i3++;
            }
            return (i + i2) + (this.zzjg.length * 1);
        }
    }

    public static final class zzh extends zzso<zzh> {
        public static final zzsp<com.google.android.gms.internal.zzag.zza, zzh> zzjh = zzsp.zza(11, zzh.class, 810);
        private static final zzh[] zzji = new zzh[0];
        public int[] zzjj;
        public int[] zzjk;
        public int[] zzjl;
        public int zzjm;
        public int[] zzjn;
        public int zzjo;
        public int zzjp;

        public zzh() {
            zzM();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzh)) {
                return false;
            }
            zzh com_google_android_gms_internal_zzaf_zzh = (zzh) o;
            if (!zzss.equals(this.zzjj, com_google_android_gms_internal_zzaf_zzh.zzjj) || !zzss.equals(this.zzjk, com_google_android_gms_internal_zzaf_zzh.zzjk) || !zzss.equals(this.zzjl, com_google_android_gms_internal_zzaf_zzh.zzjl) || this.zzjm != com_google_android_gms_internal_zzaf_zzh.zzjm || !zzss.equals(this.zzjn, com_google_android_gms_internal_zzaf_zzh.zzjn) || this.zzjo != com_google_android_gms_internal_zzaf_zzh.zzjo || this.zzjp != com_google_android_gms_internal_zzaf_zzh.zzjp) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzh.zzbuj == null || com_google_android_gms_internal_zzaf_zzh.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzaf_zzh.zzbuj);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzjj)) * 31) + zzss.hashCode(this.zzjk)) * 31) + zzss.hashCode(this.zzjl)) * 31) + this.zzjm) * 31) + zzss.hashCode(this.zzjn)) * 31) + this.zzjo) * 31) + this.zzjp) * 31;
            int hashCode2 = (this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzh(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            int i = 0;
            if (this.zzjj != null && this.zzjj.length > 0) {
                for (int zzA : this.zzjj) {
                    output.zzA(1, zzA);
                }
            }
            if (this.zzjk != null && this.zzjk.length > 0) {
                for (int zzA2 : this.zzjk) {
                    output.zzA(2, zzA2);
                }
            }
            if (this.zzjl != null && this.zzjl.length > 0) {
                for (int zzA22 : this.zzjl) {
                    output.zzA(3, zzA22);
                }
            }
            if (this.zzjm != 0) {
                output.zzA(4, this.zzjm);
            }
            if (this.zzjn != null && this.zzjn.length > 0) {
                while (i < this.zzjn.length) {
                    output.zzA(5, this.zzjn[i]);
                    i++;
                }
            }
            if (this.zzjo != 0) {
                output.zzA(6, this.zzjo);
            }
            if (this.zzjp != 0) {
                output.zzA(7, this.zzjp);
            }
            super.writeTo(output);
        }

        public zzh zzM() {
            this.zzjj = zzsx.zzbuw;
            this.zzjk = zzsx.zzbuw;
            this.zzjl = zzsx.zzbuw;
            this.zzjm = 0;
            this.zzjn = zzsx.zzbuw;
            this.zzjo = 0;
            this.zzjp = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        public zzh zzh(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                int zzc;
                Object obj;
                int zzmq;
                Object obj2;
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 8);
                        zzIX = this.zzjj == null ? 0 : this.zzjj.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjj, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zzjj = obj;
                        continue;
                    case 10:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zzjj == null ? 0 : this.zzjj.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzjj, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zzjj = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 16:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 16);
                        zzIX = this.zzjk == null ? 0 : this.zzjk.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjk, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zzjk = obj;
                        continue;
                    case 18:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zzjk == null ? 0 : this.zzjk.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzjk, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zzjk = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 24:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 24);
                        zzIX = this.zzjl == null ? 0 : this.zzjl.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjl, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zzjl = obj;
                        continue;
                    case 26:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zzjl == null ? 0 : this.zzjl.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzjl, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zzjl = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 32:
                        this.zzjm = com_google_android_gms_internal_zzsm.zzJb();
                        continue;
                    case 40:
                        zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 40);
                        zzIX = this.zzjn == null ? 0 : this.zzjn.length;
                        obj = new int[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjn, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = com_google_android_gms_internal_zzsm.zzJb();
                        this.zzjn = obj;
                        continue;
                    case 42:
                        zzmq = com_google_android_gms_internal_zzsm.zzmq(com_google_android_gms_internal_zzsm.zzJf());
                        zzc = com_google_android_gms_internal_zzsm.getPosition();
                        zzIX = 0;
                        while (com_google_android_gms_internal_zzsm.zzJk() > 0) {
                            com_google_android_gms_internal_zzsm.zzJb();
                            zzIX++;
                        }
                        com_google_android_gms_internal_zzsm.zzms(zzc);
                        zzc = this.zzjn == null ? 0 : this.zzjn.length;
                        obj2 = new int[(zzIX + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzjn, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzsm.zzJb();
                            zzc++;
                        }
                        this.zzjn = obj2;
                        com_google_android_gms_internal_zzsm.zzmr(zzmq);
                        continue;
                    case 48:
                        this.zzjo = com_google_android_gms_internal_zzsm.zzJb();
                        continue;
                    case 56:
                        this.zzjp = com_google_android_gms_internal_zzsm.zzJb();
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
            int i2;
            int i3 = 0;
            int zzz = super.zzz();
            if (this.zzjj == null || this.zzjj.length <= 0) {
                i = zzz;
            } else {
                i2 = 0;
                for (int zzmx : this.zzjj) {
                    i2 += zzsn.zzmx(zzmx);
                }
                i = (zzz + i2) + (this.zzjj.length * 1);
            }
            if (this.zzjk != null && this.zzjk.length > 0) {
                zzz = 0;
                for (int zzmx2 : this.zzjk) {
                    zzz += zzsn.zzmx(zzmx2);
                }
                i = (i + zzz) + (this.zzjk.length * 1);
            }
            if (this.zzjl != null && this.zzjl.length > 0) {
                zzz = 0;
                for (int zzmx22 : this.zzjl) {
                    zzz += zzsn.zzmx(zzmx22);
                }
                i = (i + zzz) + (this.zzjl.length * 1);
            }
            if (this.zzjm != 0) {
                i += zzsn.zzC(4, this.zzjm);
            }
            if (this.zzjn != null && this.zzjn.length > 0) {
                i2 = 0;
                while (i3 < this.zzjn.length) {
                    i2 += zzsn.zzmx(this.zzjn[i3]);
                    i3++;
                }
                i = (i + i2) + (this.zzjn.length * 1);
            }
            if (this.zzjo != 0) {
                i += zzsn.zzC(6, this.zzjo);
            }
            return this.zzjp != 0 ? i + zzsn.zzC(7, this.zzjp) : i;
        }
    }

    public static final class zzi extends zzso<zzi> {
        private static volatile zzi[] zzjq;
        public String name;
        public com.google.android.gms.internal.zzag.zza zzjr;
        public zzd zzjs;

        public zzi() {
            zzO();
        }

        public static zzi[] zzN() {
            if (zzjq == null) {
                synchronized (zzss.zzbut) {
                    if (zzjq == null) {
                        zzjq = new zzi[0];
                    }
                }
            }
            return zzjq;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzi)) {
                return false;
            }
            zzi com_google_android_gms_internal_zzaf_zzi = (zzi) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzaf_zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzaf_zzi.name)) {
                return false;
            }
            if (this.zzjr == null) {
                if (com_google_android_gms_internal_zzaf_zzi.zzjr != null) {
                    return false;
                }
            } else if (!this.zzjr.equals(com_google_android_gms_internal_zzaf_zzi.zzjr)) {
                return false;
            }
            if (this.zzjs == null) {
                if (com_google_android_gms_internal_zzaf_zzi.zzjs != null) {
                    return false;
                }
            } else if (!this.zzjs.equals(com_google_android_gms_internal_zzaf_zzi.zzjs)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzi.zzbuj == null || com_google_android_gms_internal_zzaf_zzi.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzaf_zzi.zzbuj);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzjs == null ? 0 : this.zzjs.hashCode()) + (((this.zzjr == null ? 0 : this.zzjr.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (!(this.zzbuj == null || this.zzbuj.isEmpty())) {
                i = this.zzbuj.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzi(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            if (!this.name.equals("")) {
                output.zzn(1, this.name);
            }
            if (this.zzjr != null) {
                output.zza(2, this.zzjr);
            }
            if (this.zzjs != null) {
                output.zza(3, this.zzjs);
            }
            super.writeTo(output);
        }

        public zzi zzO() {
            this.name = "";
            this.zzjr = null;
            this.zzjs = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        public zzi zzi(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 18:
                        if (this.zzjr == null) {
                            this.zzjr = new com.google.android.gms.internal.zzag.zza();
                        }
                        com_google_android_gms_internal_zzsm.zza(this.zzjr);
                        continue;
                    case 26:
                        if (this.zzjs == null) {
                            this.zzjs = new zzd();
                        }
                        com_google_android_gms_internal_zzsm.zza(this.zzjs);
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
            int zzz = super.zzz();
            if (!this.name.equals("")) {
                zzz += zzsn.zzo(1, this.name);
            }
            if (this.zzjr != null) {
                zzz += zzsn.zzc(2, this.zzjr);
            }
            return this.zzjs != null ? zzz + zzsn.zzc(3, this.zzjs) : zzz;
        }
    }

    public static final class zzj extends zzso<zzj> {
        public zzi[] zzjt;
        public zzf zzju;
        public String zzjv;

        public zzj() {
            zzP();
        }

        public static zzj zzd(byte[] bArr) throws zzst {
            return (zzj) zzsu.mergeFrom(new zzj(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzj)) {
                return false;
            }
            zzj com_google_android_gms_internal_zzaf_zzj = (zzj) o;
            if (!zzss.equals(this.zzjt, com_google_android_gms_internal_zzaf_zzj.zzjt)) {
                return false;
            }
            if (this.zzju == null) {
                if (com_google_android_gms_internal_zzaf_zzj.zzju != null) {
                    return false;
                }
            } else if (!this.zzju.equals(com_google_android_gms_internal_zzaf_zzj.zzju)) {
                return false;
            }
            if (this.zzjv == null) {
                if (com_google_android_gms_internal_zzaf_zzj.zzjv != null) {
                    return false;
                }
            } else if (!this.zzjv.equals(com_google_android_gms_internal_zzaf_zzj.zzjv)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzj.zzbuj == null || com_google_android_gms_internal_zzaf_zzj.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzaf_zzj.zzbuj);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzjv == null ? 0 : this.zzjv.hashCode()) + (((this.zzju == null ? 0 : this.zzju.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzjt)) * 31)) * 31)) * 31;
            if (!(this.zzbuj == null || this.zzbuj.isEmpty())) {
                i = this.zzbuj.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzj(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            if (this.zzjt != null && this.zzjt.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu : this.zzjt) {
                    if (com_google_android_gms_internal_zzsu != null) {
                        output.zza(1, com_google_android_gms_internal_zzsu);
                    }
                }
            }
            if (this.zzju != null) {
                output.zza(2, this.zzju);
            }
            if (!this.zzjv.equals("")) {
                output.zzn(3, this.zzjv);
            }
            super.writeTo(output);
        }

        public zzj zzP() {
            this.zzjt = zzi.zzN();
            this.zzju = null;
            this.zzjv = "";
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        public zzj zzj(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 10);
                        zzIX = this.zzjt == null ? 0 : this.zzjt.length;
                        Object obj = new zzi[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzjt, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zzi();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zzi();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zzjt = obj;
                        continue;
                    case 18:
                        if (this.zzju == null) {
                            this.zzju = new zzf();
                        }
                        com_google_android_gms_internal_zzsm.zza(this.zzju);
                        continue;
                    case 26:
                        this.zzjv = com_google_android_gms_internal_zzsm.readString();
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
            int zzz = super.zzz();
            if (this.zzjt != null && this.zzjt.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu : this.zzjt) {
                    if (com_google_android_gms_internal_zzsu != null) {
                        zzz += zzsn.zzc(1, com_google_android_gms_internal_zzsu);
                    }
                }
            }
            if (this.zzju != null) {
                zzz += zzsn.zzc(2, this.zzju);
            }
            return !this.zzjv.equals("") ? zzz + zzsn.zzo(3, this.zzjv) : zzz;
        }
    }
}
