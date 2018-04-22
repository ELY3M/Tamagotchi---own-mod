package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzp;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zznm;

public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzapb;

    private static class zza extends Metadata {
        private final DataHolder zzahi;
        private final int zzajf;
        private final int zzapc;

        public zza(DataHolder dataHolder, int i) {
            this.zzahi = dataHolder;
            this.zzapc = i;
            this.zzajf = dataHolder.zzbH(i);
        }

        public /* synthetic */ Object freeze() {
            return zzsK();
        }

        public boolean isDataValid() {
            return !this.zzahi.isClosed();
        }

        public <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzahi, this.zzapc, this.zzajf);
        }

        public Metadata zzsK() {
            MetadataBundle zztE = MetadataBundle.zztE();
            for (MetadataField metadataField : zze.zztC()) {
                if (metadataField != zznm.zzatz) {
                    metadataField.zza(this.zzahi, zztE, this.zzapc, this.zzajf);
                }
            }
            return new zzp(zztE);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.zzpZ().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        zza com_google_android_gms_drive_MetadataBuffer_zza = this.zzapb;
        if (com_google_android_gms_drive_MetadataBuffer_zza != null && com_google_android_gms_drive_MetadataBuffer_zza.zzapc == row) {
            return com_google_android_gms_drive_MetadataBuffer_zza;
        }
        Metadata com_google_android_gms_drive_MetadataBuffer_zza2 = new zza(this.zzahi, row);
        this.zzapb = com_google_android_gms_drive_MetadataBuffer_zza2;
        return com_google_android_gms_drive_MetadataBuffer_zza2;
    }

    @Deprecated
    public String getNextPageToken() {
        return null;
    }

    public void release() {
        if (this.zzahi != null) {
            zze.zza(this.zzahi);
        }
        super.release();
    }
}
