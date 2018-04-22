package com.google.android.gms.drive;

import com.google.android.gms.drive.ExecutionOptions.Builder;

public class zzh extends ExecutionOptions {
    private String zzaoY;
    private String zzaoZ;

    public static class zza extends Builder {
        private String zzaoY;
        private String zzaoZ;

        public /* synthetic */ ExecutionOptions build() {
            return zzsH();
        }

        public /* synthetic */ Builder setConflictStrategy(int i) {
            return zzcx(i);
        }

        public /* synthetic */ Builder setNotifyOnCompletion(boolean z) {
            return zzad(z);
        }

        public /* synthetic */ Builder setTrackingTag(String str) {
            return zzcY(str);
        }

        public zza zzad(boolean z) {
            super.setNotifyOnCompletion(z);
            return this;
        }

        public zza zzcY(String str) {
            super.setTrackingTag(str);
            return this;
        }

        public zza zzcx(int i) {
            throw new UnsupportedOperationException();
        }

        public zzh zzsH() {
            zzsE();
            return new zzh(this.zzaoV, this.zzaoW, this.zzaoY, this.zzaoZ, this.zzaoX);
        }
    }

    private zzh(String str, boolean z, String str2, String str3, int i) {
        super(str, z, i);
        this.zzaoY = str2;
        this.zzaoZ = str3;
    }

    public static zzh zza(ExecutionOptions executionOptions) {
        zza com_google_android_gms_drive_zzh_zza = new zza();
        if (executionOptions != null) {
            if (executionOptions.zzsD() != 0) {
                throw new IllegalStateException("May not set a conflict strategy for new file creation.");
            }
            String zzsB = executionOptions.zzsB();
            if (zzsB != null) {
                com_google_android_gms_drive_zzh_zza.zzcY(zzsB);
            }
            com_google_android_gms_drive_zzh_zza.zzad(executionOptions.zzsC());
        }
        return com_google_android_gms_drive_zzh_zza.zzsH();
    }

    public String zzsF() {
        return this.zzaoY;
    }

    public String zzsG() {
        return this.zzaoZ;
    }
}
