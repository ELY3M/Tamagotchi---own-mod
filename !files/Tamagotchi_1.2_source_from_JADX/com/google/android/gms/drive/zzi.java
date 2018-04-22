package com.google.android.gms.drive;

import com.google.android.gms.drive.ExecutionOptions.Builder;

public class zzi extends ExecutionOptions {
    private boolean zzapa;

    public static class zza extends Builder {
        private boolean zzapa = true;

        public /* synthetic */ ExecutionOptions build() {
            return zzsJ();
        }

        public /* synthetic */ Builder setConflictStrategy(int i) {
            return zzcy(i);
        }

        public /* synthetic */ Builder setNotifyOnCompletion(boolean z) {
            return zzae(z);
        }

        public /* synthetic */ Builder setTrackingTag(String str) {
            return zzcZ(str);
        }

        public zza zzae(boolean z) {
            super.setNotifyOnCompletion(z);
            return this;
        }

        public zza zzcZ(String str) {
            super.setTrackingTag(str);
            return this;
        }

        public zza zzcy(int i) {
            super.setConflictStrategy(i);
            return this;
        }

        public zzi zzsJ() {
            zzsE();
            return new zzi(this.zzaoV, this.zzaoW, this.zzaoX, this.zzapa);
        }
    }

    private zzi(String str, boolean z, int i, boolean z2) {
        super(str, z, i);
        this.zzapa = z2;
    }

    public static zzi zzb(ExecutionOptions executionOptions) {
        zza com_google_android_gms_drive_zzi_zza = new zza();
        if (executionOptions != null) {
            com_google_android_gms_drive_zzi_zza.zzcy(executionOptions.zzsD());
            com_google_android_gms_drive_zzi_zza.zzae(executionOptions.zzsC());
            String zzsB = executionOptions.zzsB();
            if (zzsB != null) {
                com_google_android_gms_drive_zzi_zza.zzcZ(zzsB);
            }
        }
        return com_google_android_gms_drive_zzi_zza.zzsJ();
    }

    public boolean zzsI() {
        return this.zzapa;
    }
}
