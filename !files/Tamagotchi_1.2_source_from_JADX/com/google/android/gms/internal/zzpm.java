package com.google.android.gms.internal;

import java.io.IOException;

public interface zzpm {

    public static final class zza extends zzso<zza> {
        public zza[] zzaMo;

        public static final class zza extends zzso<zza> {
            private static volatile zza[] zzaMp;
            public int viewId;
            public String zzaMq;
            public String zzaMr;

            public zza() {
                zzyr();
            }

            public static zza[] zzyq() {
                if (zzaMp == null) {
                    synchronized (zzss.zzbut) {
                        if (zzaMp == null) {
                            zzaMp = new zza[0];
                        }
                    }
                }
                return zzaMp;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof zza)) {
                    return false;
                }
                zza com_google_android_gms_internal_zzpm_zza_zza = (zza) o;
                if (this.zzaMq == null) {
                    if (com_google_android_gms_internal_zzpm_zza_zza.zzaMq != null) {
                        return false;
                    }
                } else if (!this.zzaMq.equals(com_google_android_gms_internal_zzpm_zza_zza.zzaMq)) {
                    return false;
                }
                if (this.zzaMr == null) {
                    if (com_google_android_gms_internal_zzpm_zza_zza.zzaMr != null) {
                        return false;
                    }
                } else if (!this.zzaMr.equals(com_google_android_gms_internal_zzpm_zza_zza.zzaMr)) {
                    return false;
                }
                if (this.viewId != com_google_android_gms_internal_zzpm_zza_zza.viewId) {
                    return false;
                }
                if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                    return com_google_android_gms_internal_zzpm_zza_zza.zzbuj == null || com_google_android_gms_internal_zzpm_zza_zza.zzbuj.isEmpty();
                } else {
                    return this.zzbuj.equals(com_google_android_gms_internal_zzpm_zza_zza.zzbuj);
                }
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((((this.zzaMr == null ? 0 : this.zzaMr.hashCode()) + (((this.zzaMq == null ? 0 : this.zzaMq.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + this.viewId) * 31;
                if (!(this.zzbuj == null || this.zzbuj.isEmpty())) {
                    i = this.zzbuj.hashCode();
                }
                return hashCode + i;
            }

            public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
                return zzp(com_google_android_gms_internal_zzsm);
            }

            public void writeTo(zzsn output) throws IOException {
                if (!this.zzaMq.equals("")) {
                    output.zzn(1, this.zzaMq);
                }
                if (!this.zzaMr.equals("")) {
                    output.zzn(2, this.zzaMr);
                }
                if (this.viewId != 0) {
                    output.zzA(3, this.viewId);
                }
                super.writeTo(output);
            }

            public zza zzp(zzsm com_google_android_gms_internal_zzsm) throws IOException {
                while (true) {
                    int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                    switch (zzIX) {
                        case 0:
                            break;
                        case 10:
                            this.zzaMq = com_google_android_gms_internal_zzsm.readString();
                            continue;
                        case 18:
                            this.zzaMr = com_google_android_gms_internal_zzsm.readString();
                            continue;
                        case 24:
                            this.viewId = com_google_android_gms_internal_zzsm.zzJb();
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

            public zza zzyr() {
                this.zzaMq = "";
                this.zzaMr = "";
                this.viewId = 0;
                this.zzbuj = null;
                this.zzbuu = -1;
                return this;
            }

            protected int zzz() {
                int zzz = super.zzz();
                if (!this.zzaMq.equals("")) {
                    zzz += zzsn.zzo(1, this.zzaMq);
                }
                if (!this.zzaMr.equals("")) {
                    zzz += zzsn.zzo(2, this.zzaMr);
                }
                return this.viewId != 0 ? zzz + zzsn.zzC(3, this.viewId) : zzz;
            }
        }

        public zza() {
            zzyp();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzpm_zza = (zza) o;
            if (!zzss.equals(this.zzaMo, com_google_android_gms_internal_zzpm_zza.zzaMo)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzpm_zza.zzbuj == null || com_google_android_gms_internal_zzpm_zza.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzpm_zza.zzbuj);
            }
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzaMo)) * 31;
            int hashCode2 = (this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzo(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            if (this.zzaMo != null && this.zzaMo.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu : this.zzaMo) {
                    if (com_google_android_gms_internal_zzsu != null) {
                        output.zza(1, com_google_android_gms_internal_zzsu);
                    }
                }
            }
            super.writeTo(output);
        }

        public zza zzo(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 10);
                        zzIX = this.zzaMo == null ? 0 : this.zzaMo.length;
                        Object obj = new zza[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzaMo, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zza();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zza();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zzaMo = obj;
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

        public zza zzyp() {
            this.zzaMo = zza.zzyq();
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (this.zzaMo != null && this.zzaMo.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu : this.zzaMo) {
                    if (com_google_android_gms_internal_zzsu != null) {
                        zzz += zzsn.zzc(1, com_google_android_gms_internal_zzsu);
                    }
                }
            }
            return zzz;
        }
    }

    public static final class zzb extends zzso<zzb> {
        private static volatile zzb[] zzaMs;
        public String name;
        public zzd zzaMt;

        public zzb() {
            zzyt();
        }

        public static zzb[] zzys() {
            if (zzaMs == null) {
                synchronized (zzss.zzbut) {
                    if (zzaMs == null) {
                        zzaMs = new zzb[0];
                    }
                }
            }
            return zzaMs;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzpm_zzb = (zzb) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzpm_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzpm_zzb.name)) {
                return false;
            }
            if (this.zzaMt == null) {
                if (com_google_android_gms_internal_zzpm_zzb.zzaMt != null) {
                    return false;
                }
            } else if (!this.zzaMt.equals(com_google_android_gms_internal_zzpm_zzb.zzaMt)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzpm_zzb.zzbuj == null || com_google_android_gms_internal_zzpm_zzb.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzpm_zzb.zzbuj);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaMt == null ? 0 : this.zzaMt.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.zzbuj == null || this.zzbuj.isEmpty())) {
                i = this.zzbuj.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzq(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            if (!this.name.equals("")) {
                output.zzn(1, this.name);
            }
            if (this.zzaMt != null) {
                output.zza(2, this.zzaMt);
            }
            super.writeTo(output);
        }

        public zzb zzq(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 18:
                        if (this.zzaMt == null) {
                            this.zzaMt = new zzd();
                        }
                        com_google_android_gms_internal_zzsm.zza(this.zzaMt);
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

        public zzb zzyt() {
            this.name = "";
            this.zzaMt = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (!this.name.equals("")) {
                zzz += zzsn.zzo(1, this.name);
            }
            return this.zzaMt != null ? zzz + zzsn.zzc(2, this.zzaMt) : zzz;
        }
    }

    public static final class zzc extends zzso<zzc> {
        public String type;
        public zzb[] zzaMu;

        public zzc() {
            zzyu();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzpm_zzc = (zzc) o;
            if (this.type == null) {
                if (com_google_android_gms_internal_zzpm_zzc.type != null) {
                    return false;
                }
            } else if (!this.type.equals(com_google_android_gms_internal_zzpm_zzc.type)) {
                return false;
            }
            if (!zzss.equals(this.zzaMu, com_google_android_gms_internal_zzpm_zzc.zzaMu)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzpm_zzc.zzbuj == null || com_google_android_gms_internal_zzpm_zzc.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzpm_zzc.zzbuj);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.type == null ? 0 : this.type.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzss.hashCode(this.zzaMu)) * 31;
            if (!(this.zzbuj == null || this.zzbuj.isEmpty())) {
                i = this.zzbuj.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzr(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            if (!this.type.equals("")) {
                output.zzn(1, this.type);
            }
            if (this.zzaMu != null && this.zzaMu.length > 0) {
                for (zzsu com_google_android_gms_internal_zzsu : this.zzaMu) {
                    if (com_google_android_gms_internal_zzsu != null) {
                        output.zza(2, com_google_android_gms_internal_zzsu);
                    }
                }
            }
            super.writeTo(output);
        }

        public zzc zzr(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.type = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 18:
                        int zzc = zzsx.zzc(com_google_android_gms_internal_zzsm, 18);
                        zzIX = this.zzaMu == null ? 0 : this.zzaMu.length;
                        Object obj = new zzb[(zzc + zzIX)];
                        if (zzIX != 0) {
                            System.arraycopy(this.zzaMu, 0, obj, 0, zzIX);
                        }
                        while (zzIX < obj.length - 1) {
                            obj[zzIX] = new zzb();
                            com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                            com_google_android_gms_internal_zzsm.zzIX();
                            zzIX++;
                        }
                        obj[zzIX] = new zzb();
                        com_google_android_gms_internal_zzsm.zza(obj[zzIX]);
                        this.zzaMu = obj;
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

        public zzc zzyu() {
            this.type = "";
            this.zzaMu = zzb.zzys();
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (!this.type.equals("")) {
                zzz += zzsn.zzo(1, this.type);
            }
            if (this.zzaMu == null || this.zzaMu.length <= 0) {
                return zzz;
            }
            int i = zzz;
            for (zzsu com_google_android_gms_internal_zzsu : this.zzaMu) {
                if (com_google_android_gms_internal_zzsu != null) {
                    i += zzsn.zzc(2, com_google_android_gms_internal_zzsu);
                }
            }
            return i;
        }
    }

    public static final class zzd extends zzso<zzd> {
        public boolean zzaMv;
        public long zzaMw;
        public double zzaMx;
        public zzc zzaMy;
        public String zzamJ;

        public zzd() {
            zzyv();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzpm_zzd = (zzd) o;
            if (this.zzaMv != com_google_android_gms_internal_zzpm_zzd.zzaMv) {
                return false;
            }
            if (this.zzamJ == null) {
                if (com_google_android_gms_internal_zzpm_zzd.zzamJ != null) {
                    return false;
                }
            } else if (!this.zzamJ.equals(com_google_android_gms_internal_zzpm_zzd.zzamJ)) {
                return false;
            }
            if (this.zzaMw != com_google_android_gms_internal_zzpm_zzd.zzaMw || Double.doubleToLongBits(this.zzaMx) != Double.doubleToLongBits(com_google_android_gms_internal_zzpm_zzd.zzaMx)) {
                return false;
            }
            if (this.zzaMy == null) {
                if (com_google_android_gms_internal_zzpm_zzd.zzaMy != null) {
                    return false;
                }
            } else if (!this.zzaMy.equals(com_google_android_gms_internal_zzpm_zzd.zzaMy)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return com_google_android_gms_internal_zzpm_zzd.zzbuj == null || com_google_android_gms_internal_zzpm_zzd.zzbuj.isEmpty();
            } else {
                return this.zzbuj.equals(com_google_android_gms_internal_zzpm_zzd.zzbuj);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.zzamJ == null ? 0 : this.zzamJ.hashCode()) + (((this.zzaMv ? 1231 : 1237) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + ((int) (this.zzaMw ^ (this.zzaMw >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.zzaMx);
            hashCode = ((this.zzaMy == null ? 0 : this.zzaMy.hashCode()) + (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31)) * 31;
            if (!(this.zzbuj == null || this.zzbuj.isEmpty())) {
                i = this.zzbuj.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzsu mergeFrom(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            return zzs(com_google_android_gms_internal_zzsm);
        }

        public void writeTo(zzsn output) throws IOException {
            if (this.zzaMv) {
                output.zze(1, this.zzaMv);
            }
            if (!this.zzamJ.equals("")) {
                output.zzn(2, this.zzamJ);
            }
            if (this.zzaMw != 0) {
                output.zzb(3, this.zzaMw);
            }
            if (Double.doubleToLongBits(this.zzaMx) != Double.doubleToLongBits(0.0d)) {
                output.zza(4, this.zzaMx);
            }
            if (this.zzaMy != null) {
                output.zza(5, this.zzaMy);
            }
            super.writeTo(output);
        }

        public zzd zzs(zzsm com_google_android_gms_internal_zzsm) throws IOException {
            while (true) {
                int zzIX = com_google_android_gms_internal_zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaMv = com_google_android_gms_internal_zzsm.zzJc();
                        continue;
                    case 18:
                        this.zzamJ = com_google_android_gms_internal_zzsm.readString();
                        continue;
                    case 24:
                        this.zzaMw = com_google_android_gms_internal_zzsm.zzJa();
                        continue;
                    case 33:
                        this.zzaMx = com_google_android_gms_internal_zzsm.readDouble();
                        continue;
                    case 42:
                        if (this.zzaMy == null) {
                            this.zzaMy = new zzc();
                        }
                        com_google_android_gms_internal_zzsm.zza(this.zzaMy);
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

        public zzd zzyv() {
            this.zzaMv = false;
            this.zzamJ = "";
            this.zzaMw = 0;
            this.zzaMx = 0.0d;
            this.zzaMy = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (this.zzaMv) {
                zzz += zzsn.zzf(1, this.zzaMv);
            }
            if (!this.zzamJ.equals("")) {
                zzz += zzsn.zzo(2, this.zzamJ);
            }
            if (this.zzaMw != 0) {
                zzz += zzsn.zzd(3, this.zzaMw);
            }
            if (Double.doubleToLongBits(this.zzaMx) != Double.doubleToLongBits(0.0d)) {
                zzz += zzsn.zzb(4, this.zzaMx);
            }
            return this.zzaMy != null ? zzz + zzsn.zzc(5, this.zzaMy) : zzz;
        }
    }
}
