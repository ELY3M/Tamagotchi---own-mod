package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzg {
    private final Context mContext;
    private final FaceSettingsParcel zzbob;
    private zzc zzboc = null;
    private boolean zzbod = false;
    private final Object zzpV = new Object();

    public zzg(Context context, FaceSettingsParcel faceSettingsParcel) {
        this.mContext = context;
        this.zzbob = faceSettingsParcel;
        zzIi();
    }

    private zzc zzIi() {
        zzc com_google_android_gms_vision_face_internal_client_zzc;
        synchronized (this.zzpV) {
            if (this.zzboc != null) {
                com_google_android_gms_vision_face_internal_client_zzc = this.zzboc;
            } else {
                this.zzboc = zzf.zza(this.mContext, this.zzbob);
                if (!this.zzbod && this.zzboc == null) {
                    Log.w("FaceDetectorHandle", "Native face detector not yet available.  Reverting to no-op detection.");
                    this.zzbod = true;
                } else if (this.zzbod && this.zzboc != null) {
                    Log.w("FaceDetectorHandle", "Native face detector is now available.");
                }
                com_google_android_gms_vision_face_internal_client_zzc = this.zzboc;
            }
        }
        return com_google_android_gms_vision_face_internal_client_zzc;
    }

    private Face zza(FaceParcel faceParcel) {
        return new Face(faceParcel.id, new PointF(faceParcel.centerX, faceParcel.centerY), faceParcel.width, faceParcel.height, faceParcel.zzbnP, faceParcel.zzbnQ, zzb(faceParcel), faceParcel.zzbnS, faceParcel.zzbnT, faceParcel.zzbnU);
    }

    private Landmark zza(LandmarkParcel landmarkParcel) {
        return new Landmark(new PointF(landmarkParcel.f19x, landmarkParcel.f20y), landmarkParcel.type);
    }

    private Landmark[] zzb(FaceParcel faceParcel) {
        int i = 0;
        LandmarkParcel[] landmarkParcelArr = faceParcel.zzbnR;
        if (landmarkParcelArr == null) {
            return new Landmark[0];
        }
        Landmark[] landmarkArr = new Landmark[landmarkParcelArr.length];
        while (i < landmarkParcelArr.length) {
            landmarkArr[i] = zza(landmarkParcelArr[i]);
            i++;
        }
        return landmarkArr;
    }

    public boolean isOperational() {
        return zzIi() != null;
    }

    public void zzIh() {
        synchronized (this.zzpV) {
            if (this.zzboc == null) {
                return;
            }
            try {
                this.zzboc.zzIh();
            } catch (Throwable e) {
                Log.e("FaceDetectorHandle", "Could not finalize native face detector", e);
            }
        }
    }

    public Face[] zzb(ByteBuffer byteBuffer, FrameMetadataParcel frameMetadataParcel) {
        int i = 0;
        zzc zzIi = zzIi();
        if (zzIi == null) {
            return new Face[0];
        }
        try {
            FaceParcel[] zzc = zzIi.zzc(zze.zzC(byteBuffer), frameMetadataParcel);
            Face[] faceArr = new Face[zzc.length];
            while (i < zzc.length) {
                faceArr[i] = zza(zzc[i]);
                i++;
            }
            return faceArr;
        } catch (Throwable e) {
            Log.e("FaceDetectorHandle", "Could not call native face detector", e);
            return new Face[0];
        }
    }

    public boolean zzkJ(int i) {
        boolean z = false;
        zzc zzIi = zzIi();
        if (zzIi != null) {
            try {
                z = zzIi.zzkJ(i);
            } catch (Throwable e) {
                Log.e("FaceDetectorHandle", "Could not call native face detector", e);
            }
        }
        return z;
    }
}
