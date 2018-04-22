package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.lang.Thread.State;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.anddev.andengine.util.constants.TimeConstants;

public class CameraSource {
    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_BACK = 0;
    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_FRONT = 1;
    private Context mContext;
    private int zzDE;
    private Camera zzbmA;
    private int zzbmB;
    private Size zzbmC;
    private float zzbmD;
    private int zzbmE;
    private int zzbmF;
    private boolean zzbmG;
    private SurfaceView zzbmH;
    private SurfaceTexture zzbmI;
    private boolean zzbmJ;
    private Thread zzbmK;
    private zzb zzbmL;
    private Map<byte[], ByteBuffer> zzbmM;
    private final Object zzbmz;

    public static class Builder {
        private final Detector<?> zzbmN;
        private CameraSource zzbmO = new CameraSource();

        public Builder(Context context, Detector<?> detector) {
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (detector == null) {
                throw new IllegalArgumentException("No detector supplied.");
            } else {
                this.zzbmN = detector;
                this.zzbmO.mContext = context;
            }
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzbmO;
            CameraSource cameraSource2 = this.zzbmO;
            cameraSource2.getClass();
            cameraSource.zzbmL = new zzb(cameraSource2, this.zzbmN);
            return this.zzbmO;
        }

        public Builder setAutoFocusEnabled(boolean autoFocusEnabled) {
            this.zzbmO.zzbmG = autoFocusEnabled;
            return this;
        }

        public Builder setFacing(int facing) {
            if (facing == 0 || facing == 1) {
                this.zzbmO.zzbmB = facing;
                return this;
            }
            throw new IllegalArgumentException("Invalid camera: " + facing);
        }

        public Builder setRequestedFps(float fps) {
            if (fps <= 0.0f) {
                throw new IllegalArgumentException("Invalid fps: " + fps);
            }
            this.zzbmO.zzbmD = fps;
            return this;
        }

        public Builder setRequestedPreviewSize(int width, int height) {
            if (width <= 0 || width > TimeConstants.MICROSECONDSPERSECOND || height <= 0 || height > TimeConstants.MICROSECONDSPERSECOND) {
                throw new IllegalArgumentException("Invalid preview size: " + width + "x" + height);
            }
            this.zzbmO.zzbmE = width;
            this.zzbmO.zzbmF = height;
            return this;
        }
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    private class zza implements PreviewCallback {
        final /* synthetic */ CameraSource zzbmP;

        private zza(CameraSource cameraSource) {
            this.zzbmP = cameraSource;
        }

        public void onPreviewFrame(byte[] data, Camera camera) {
            this.zzbmP.zzbmL.zza(data, camera);
        }
    }

    private class zzb implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = (!CameraSource.class.desiredAssertionStatus());
        private long zzRD = SystemClock.elapsedRealtime();
        private Detector<?> zzbmN;
        final /* synthetic */ CameraSource zzbmP;
        private boolean zzbmQ = true;
        private long zzbmR;
        private int zzbmS = 0;
        private ByteBuffer zzbmT;
        private final Object zzpV = new Object();

        zzb(CameraSource cameraSource, Detector<?> detector) {
            this.zzbmP = cameraSource;
            this.zzbmN = detector;
        }

        @SuppressLint({"Assert"})
        void release() {
            if ($assertionsDisabled || this.zzbmP.zzbmK.getState() == State.TERMINATED) {
                this.zzbmN.release();
                this.zzbmN = null;
                return;
            }
            throw new AssertionError();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        @android.annotation.SuppressLint({"InlinedApi"})
        public void run() {
            /*
            r6 = this;
        L_0x0000:
            r1 = r6.zzpV;
            monitor-enter(r1);
            r0 = r6.zzbmQ;	 Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0010;
        L_0x0007:
            r0 = r6.zzbmT;	 Catch:{ all -> 0x0020 }
            if (r0 != 0) goto L_0x0010;
        L_0x000b:
            r0 = r6.zzpV;	 Catch:{ InterruptedException -> 0x0016 }
            r0.wait();	 Catch:{ InterruptedException -> 0x0016 }
        L_0x0010:
            r0 = r6.zzbmQ;	 Catch:{ all -> 0x0020 }
            if (r0 != 0) goto L_0x0023;
        L_0x0014:
            monitor-exit(r1);	 Catch:{ all -> 0x0020 }
        L_0x0015:
            return;
        L_0x0016:
            r0 = move-exception;
            r2 = "CameraSource";
            r3 = "Frame processing loop terminated.";
            android.util.Log.d(r2, r3, r0);	 Catch:{ all -> 0x0020 }
            monitor-exit(r1);	 Catch:{ all -> 0x0020 }
            goto L_0x0015;
        L_0x0020:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0020 }
            throw r0;
        L_0x0023:
            r0 = new com.google.android.gms.vision.Frame$Builder;	 Catch:{ all -> 0x0020 }
            r0.<init>();	 Catch:{ all -> 0x0020 }
            r2 = r6.zzbmT;	 Catch:{ all -> 0x0020 }
            r3 = r6.zzbmP;	 Catch:{ all -> 0x0020 }
            r3 = r3.zzbmC;	 Catch:{ all -> 0x0020 }
            r3 = r3.getWidth();	 Catch:{ all -> 0x0020 }
            r4 = r6.zzbmP;	 Catch:{ all -> 0x0020 }
            r4 = r4.zzbmC;	 Catch:{ all -> 0x0020 }
            r4 = r4.getHeight();	 Catch:{ all -> 0x0020 }
            r5 = 17;
            r0 = r0.setImageData(r2, r3, r4, r5);	 Catch:{ all -> 0x0020 }
            r2 = r6.zzbmS;	 Catch:{ all -> 0x0020 }
            r0 = r0.setId(r2);	 Catch:{ all -> 0x0020 }
            r2 = r6.zzbmR;	 Catch:{ all -> 0x0020 }
            r0 = r0.setTimestampMillis(r2);	 Catch:{ all -> 0x0020 }
            r2 = r6.zzbmP;	 Catch:{ all -> 0x0020 }
            r2 = r2.zzDE;	 Catch:{ all -> 0x0020 }
            r0 = r0.setRotation(r2);	 Catch:{ all -> 0x0020 }
            r0 = r0.build();	 Catch:{ all -> 0x0020 }
            r2 = r6.zzbmT;	 Catch:{ all -> 0x0020 }
            r3 = 0;
            r6.zzbmT = r3;	 Catch:{ all -> 0x0020 }
            monitor-exit(r1);	 Catch:{ all -> 0x0020 }
            r1 = r6.zzbmN;	 Catch:{ Throwable -> 0x0077 }
            r1.receiveFrame(r0);	 Catch:{ Throwable -> 0x0077 }
            r0 = r6.zzbmP;
            r0 = r0.zzbmA;
            r1 = r2.array();
            r0.addCallbackBuffer(r1);
            goto L_0x0000;
        L_0x0077:
            r0 = move-exception;
            r1 = "CameraSource";
            r3 = "Exception thrown from receiver.";
            android.util.Log.e(r1, r3, r0);	 Catch:{ all -> 0x008e }
            r0 = r6.zzbmP;
            r0 = r0.zzbmA;
            r1 = r2.array();
            r0.addCallbackBuffer(r1);
            goto L_0x0000;
        L_0x008e:
            r0 = move-exception;
            r1 = r6.zzbmP;
            r1 = r1.zzbmA;
            r2 = r2.array();
            r1.addCallbackBuffer(r2);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.zzb.run():void");
        }

        void setActive(boolean active) {
            synchronized (this.zzpV) {
                this.zzbmQ = active;
                this.zzpV.notifyAll();
            }
        }

        void zza(byte[] bArr, Camera camera) {
            synchronized (this.zzpV) {
                if (this.zzbmT != null) {
                    camera.addCallbackBuffer(this.zzbmT.array());
                    this.zzbmT = null;
                }
                this.zzbmR = SystemClock.elapsedRealtime() - this.zzRD;
                this.zzbmS++;
                this.zzbmT = (ByteBuffer) this.zzbmP.zzbmM.get(bArr);
                this.zzpV.notifyAll();
            }
        }
    }

    private class zzc implements android.hardware.Camera.PictureCallback {
        final /* synthetic */ CameraSource zzbmP;
        private PictureCallback zzbmU;

        private zzc(CameraSource cameraSource) {
            this.zzbmP = cameraSource;
        }

        public void onPictureTaken(byte[] data, Camera camera) {
            if (this.zzbmU != null) {
                this.zzbmU.onPictureTaken(data);
            }
            synchronized (this.zzbmP.zzbmz) {
                if (this.zzbmP.zzbmA != null) {
                    this.zzbmP.zzbmA.startPreview();
                }
            }
        }
    }

    private class zzd implements android.hardware.Camera.ShutterCallback {
        final /* synthetic */ CameraSource zzbmP;
        private ShutterCallback zzbmV;

        private zzd(CameraSource cameraSource) {
            this.zzbmP = cameraSource;
        }

        public void onShutter() {
            if (this.zzbmV != null) {
                this.zzbmV.onShutter();
            }
        }
    }

    private static class zze {
        private Size zzbmW;
        private Size zzbmX;

        public zze(Camera.Size size, Camera.Size size2) {
            this.zzbmW = new Size(size.width, size.height);
            this.zzbmX = new Size(size2.width, size2.height);
        }

        public Size zzIc() {
            return this.zzbmW;
        }

        public Size zzId() {
            return this.zzbmX;
        }
    }

    private CameraSource() {
        this.zzbmz = new Object();
        this.zzbmB = 0;
        this.zzbmD = BitmapDescriptorFactory.HUE_ORANGE;
        this.zzbmE = 1024;
        this.zzbmF = 768;
        this.zzbmG = false;
        this.zzbmM = new HashMap();
    }

    @SuppressLint({"InlinedApi"})
    private Camera zzIb() {
        int zzkp = zzkp(this.zzbmB);
        if (zzkp == -1) {
            throw new RuntimeException("Could not find requested camera.");
        }
        Camera open = Camera.open(zzkp);
        zze zza = zza(open, this.zzbmE, this.zzbmF);
        if (zza == null) {
            throw new RuntimeException("Could not find suitable preview size.");
        }
        Size zzId = zza.zzId();
        this.zzbmC = zza.zzIc();
        int[] zza2 = zza(open, this.zzbmD);
        if (zza2 == null) {
            throw new RuntimeException("Could not find suitable preview frames per second range.");
        }
        Parameters parameters = open.getParameters();
        parameters.setPictureSize(zzId.getWidth(), zzId.getHeight());
        parameters.setPreviewSize(this.zzbmC.getWidth(), this.zzbmC.getHeight());
        parameters.setPreviewFpsRange(zza2[0], zza2[1]);
        parameters.setPreviewFormat(17);
        zza(open, parameters, zzkp);
        if (this.zzbmG) {
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            } else {
                Log.i("CameraSource", "Camera auto focus is not supported on this device.");
            }
        }
        open.setParameters(parameters);
        open.setPreviewCallbackWithBuffer(new zza());
        open.addCallbackBuffer(zza(this.zzbmC));
        open.addCallbackBuffer(zza(this.zzbmC));
        open.addCallbackBuffer(zza(this.zzbmC));
        open.addCallbackBuffer(zza(this.zzbmC));
        return open;
    }

    private static zze zza(Camera camera, int i, int i2) {
        zze com_google_android_gms_vision_CameraSource_zze = null;
        int i3 = Integer.MAX_VALUE;
        for (zze com_google_android_gms_vision_CameraSource_zze2 : zza(camera)) {
            zze com_google_android_gms_vision_CameraSource_zze3;
            int i4;
            Size zzIc = com_google_android_gms_vision_CameraSource_zze2.zzIc();
            int abs = Math.abs(zzIc.getHeight() - i2) + Math.abs(zzIc.getWidth() - i);
            if (abs < i3) {
                int i5 = abs;
                com_google_android_gms_vision_CameraSource_zze3 = com_google_android_gms_vision_CameraSource_zze2;
                i4 = i5;
            } else {
                i4 = i3;
                com_google_android_gms_vision_CameraSource_zze3 = com_google_android_gms_vision_CameraSource_zze;
            }
            i3 = i4;
            com_google_android_gms_vision_CameraSource_zze = com_google_android_gms_vision_CameraSource_zze3;
        }
        return com_google_android_gms_vision_CameraSource_zze;
    }

    private static List<zze> zza(Camera camera) {
        Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        List<zze> arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f = ((float) size.width) / ((float) size.height);
            for (Camera.Size size2 : supportedPictureSizes) {
                if (Math.abs(f - (((float) size2.width) / ((float) size2.height))) < 0.01f) {
                    arrayList.add(new zze(size, size2));
                    break;
                }
            }
        }
        if (arrayList.size() == 0) {
            Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
            for (Camera.Size size3 : supportedPreviewSizes) {
                arrayList.add(new zze(size3, null));
            }
        }
        return arrayList;
    }

    private void zza(Camera camera, Parameters parameters, int i) {
        int i2;
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        switch (rotation) {
            case 0:
                rotation = 0;
                break;
            case 1:
                rotation = 90;
                break;
            case 2:
                rotation = 180;
                break;
            case 3:
                rotation = 270;
                break;
            default:
                Log.e("CameraSource", "Bad rotation value: " + rotation);
                rotation = 0;
                break;
        }
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            i2 = (rotation + cameraInfo.orientation) % 360;
            rotation = (360 - i2) % 360;
        } else {
            rotation = ((cameraInfo.orientation - rotation) + 360) % 360;
            i2 = rotation;
        }
        this.zzDE = i2 / 90;
        camera.setDisplayOrientation(rotation);
        parameters.setRotation(i2);
    }

    @SuppressLint({"InlinedApi"})
    private byte[] zza(Size size) {
        Object obj = new byte[(((int) Math.ceil(((double) ((long) (ImageFormat.getBitsPerPixel(17) * (size.getHeight() * size.getWidth())))) / 8.0d)) + 1)];
        ByteBuffer wrap = ByteBuffer.wrap(obj);
        if (wrap.hasArray() && wrap.array() == obj) {
            this.zzbmM.put(obj, wrap);
            return obj;
        }
        throw new IllegalStateException("Failed to create valid buffer for camera source.");
    }

    @SuppressLint({"InlinedApi"})
    private int[] zza(Camera camera, float f) {
        int i = (int) (1000.0f * f);
        int[] iArr = null;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int[] iArr3;
            int i3;
            int abs = Math.abs(i - iArr2[0]) + Math.abs(i - iArr2[1]);
            if (abs < i2) {
                int i4 = abs;
                iArr3 = iArr2;
                i3 = i4;
            } else {
                i3 = i2;
                iArr3 = iArr;
            }
            i2 = i3;
            iArr = iArr3;
        }
        return iArr;
    }

    private static int zzkp(int i) {
        CameraInfo cameraInfo = new CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    public int getCameraFacing() {
        return this.zzbmB;
    }

    public Size getPreviewSize() {
        return this.zzbmC;
    }

    public void release() {
        synchronized (this.zzbmz) {
            stop();
            this.zzbmL.release();
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start() throws IOException {
        synchronized (this.zzbmz) {
            if (this.zzbmA != null) {
            } else {
                this.zzbmA = zzIb();
                if (VERSION.SDK_INT >= 11) {
                    this.zzbmI = new SurfaceTexture(100);
                    this.zzbmA.setPreviewTexture(this.zzbmI);
                    this.zzbmJ = true;
                } else {
                    this.zzbmH = new SurfaceView(this.mContext);
                    this.zzbmA.setPreviewDisplay(this.zzbmH.getHolder());
                    this.zzbmJ = false;
                }
                this.zzbmA.startPreview();
                this.zzbmK = new Thread(this.zzbmL);
                this.zzbmL.setActive(true);
                this.zzbmK.start();
            }
        }
        return this;
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.zzbmz) {
            if (this.zzbmA != null) {
            } else {
                this.zzbmA = zzIb();
                this.zzbmA.setPreviewDisplay(surfaceHolder);
                this.zzbmA.startPreview();
                this.zzbmK = new Thread(this.zzbmL);
                this.zzbmL.setActive(true);
                this.zzbmK.start();
                this.zzbmJ = false;
            }
        }
        return this;
    }

    public void stop() {
        synchronized (this.zzbmz) {
            this.zzbmL.setActive(false);
            if (this.zzbmK != null) {
                try {
                    this.zzbmK.join();
                } catch (InterruptedException e) {
                    Log.d("CameraSource", "Frame processing thread interrupted on release.");
                }
                this.zzbmK = null;
            }
            if (this.zzbmA != null) {
                this.zzbmA.stopPreview();
                this.zzbmA.setPreviewCallbackWithBuffer(null);
                try {
                    if (this.zzbmJ) {
                        this.zzbmA.setPreviewTexture(null);
                    } else {
                        this.zzbmA.setPreviewDisplay(null);
                    }
                } catch (Exception e2) {
                    Log.e("CameraSource", "Failed to clear camera preview: " + e2);
                }
                this.zzbmA.release();
                this.zzbmA = null;
            }
            this.zzbmM.clear();
        }
    }

    public void takePicture(ShutterCallback shutter, PictureCallback jpeg) {
        synchronized (this.zzbmz) {
            if (this.zzbmA != null) {
                android.hardware.Camera.ShutterCallback com_google_android_gms_vision_CameraSource_zzd = new zzd();
                com_google_android_gms_vision_CameraSource_zzd.zzbmV = shutter;
                android.hardware.Camera.PictureCallback com_google_android_gms_vision_CameraSource_zzc = new zzc();
                com_google_android_gms_vision_CameraSource_zzc.zzbmU = jpeg;
                this.zzbmA.takePicture(com_google_android_gms_vision_CameraSource_zzd, null, null, com_google_android_gms_vision_CameraSource_zzc);
            }
        }
    }
}
