package com.google.android.gms.vision.barcode.internal.client;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzd {
    private final Context mContext;
    private final BarcodeDetectorOptions zzbnv;
    private zzb zzbnx = null;
    private final Object zzpV = new Object();

    static class zza extends zzg<zzc> {
        private static zza zzbny;

        zza() {
            super("com.google.android.gms.vision.client.DynamiteNativeBarcodeDetectorCreator");
        }

        static zzb zza(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
            if (zzbny == null) {
                zzbny = new zza();
            }
            return zzbny.zzb(context, barcodeDetectorOptions);
        }

        private zzb zzb(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
            try {
                return ((zzc) zzaB(context)).zza(zze.zzC(context), barcodeDetectorOptions);
            } catch (Throwable e) {
                Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", e);
                return null;
            } catch (Throwable e2) {
                Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", e2);
                return null;
            }
        }

        protected /* synthetic */ Object zzd(IBinder iBinder) {
            return zzef(iBinder);
        }

        protected zzc zzef(IBinder iBinder) {
            return com.google.android.gms.vision.barcode.internal.client.zzc.zza.zzee(iBinder);
        }
    }

    public zzd(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
        this.mContext = context;
        this.zzbnv = barcodeDetectorOptions;
        zzIg();
    }

    private zzb zzIg() {
        zzb com_google_android_gms_vision_barcode_internal_client_zzb;
        synchronized (this.zzpV) {
            if (this.zzbnx == null) {
                this.zzbnx = zza.zza(this.mContext, this.zzbnv);
            }
            com_google_android_gms_vision_barcode_internal_client_zzb = this.zzbnx;
        }
        return com_google_android_gms_vision_barcode_internal_client_zzb;
    }

    public boolean isOperational() {
        return zzIg() != null;
    }

    public Barcode[] zza(Bitmap bitmap, FrameMetadataParcel frameMetadataParcel) {
        zzb zzIg = zzIg();
        if (zzIg == null) {
            return new Barcode[0];
        }
        try {
            return zzIg.zzb(zze.zzC(bitmap), frameMetadataParcel);
        } catch (Throwable e) {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    public Barcode[] zza(ByteBuffer byteBuffer, FrameMetadataParcel frameMetadataParcel) {
        zzb zzIg = zzIg();
        if (zzIg == null) {
            return new Barcode[0];
        }
        try {
            return zzIg.zza(zze.zzC(byteBuffer), frameMetadataParcel);
        } catch (Throwable e) {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }
}
