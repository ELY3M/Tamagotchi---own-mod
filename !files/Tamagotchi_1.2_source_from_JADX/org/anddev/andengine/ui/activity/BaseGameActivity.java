package org.anddev.andengine.ui.activity;

import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.drive.DriveFile;
import org.anddev.andengine.audio.music.MusicManager;
import org.anddev.andengine.audio.sound.SoundManager;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.WakeLockOptions;
import org.anddev.andengine.opengl.font.FontManager;
import org.anddev.andengine.opengl.texture.TextureManager;
import org.anddev.andengine.opengl.view.RenderSurfaceView;
import org.anddev.andengine.sensor.accelerometer.AccelerometerSensorOptions;
import org.anddev.andengine.sensor.accelerometer.IAccelerometerListener;
import org.anddev.andengine.sensor.location.ILocationListener;
import org.anddev.andengine.sensor.location.LocationSensorOptions;
import org.anddev.andengine.sensor.orientation.IOrientationListener;
import org.anddev.andengine.sensor.orientation.OrientationSensorOptions;
import org.anddev.andengine.ui.IGameInterface;
import org.anddev.andengine.util.ActivityUtils;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.constants.Constants;

public abstract class BaseGameActivity extends BaseActivity implements IGameInterface {
    private static /* synthetic */ int[] f21x1e79e3c8;
    protected Engine mEngine;
    private boolean mGameLoaded;
    protected boolean mHasWindowFocused;
    private boolean mPaused;
    protected RenderSurfaceView mRenderSurfaceView;
    private WakeLock mWakeLock;

    static /* synthetic */ int[] m58x1e79e3c8() {
        int[] iArr = f21x1e79e3c8;
        if (iArr == null) {
            iArr = new int[ScreenOrientation.values().length];
            try {
                iArr[ScreenOrientation.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ScreenOrientation.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f21x1e79e3c8 = iArr;
        }
        return iArr;
    }

    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        this.mPaused = true;
        this.mEngine = onLoadEngine();
        applyEngineOptions(this.mEngine.getEngineOptions());
        onSetContentView();
    }

    protected void onResume() {
        super.onResume();
        if (this.mPaused && this.mHasWindowFocused) {
            doResume();
        }
    }

    public void onWindowFocusChanged(boolean pHasWindowFocus) {
        super.onWindowFocusChanged(pHasWindowFocus);
        if (pHasWindowFocus) {
            if (this.mPaused) {
                doResume();
            }
            this.mHasWindowFocused = true;
            return;
        }
        if (!this.mPaused) {
            doPause();
        }
        this.mHasWindowFocused = false;
    }

    protected void onPause() {
        super.onPause();
        if (!this.mPaused) {
            doPause();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mEngine.interruptUpdateThread();
        onUnloadResources();
    }

    public void onUnloadResources() {
        if (this.mEngine.getEngineOptions().needsMusic()) {
            getMusicManager().releaseAll();
        }
        if (this.mEngine.getEngineOptions().needsSound()) {
            getSoundManager().releaseAll();
        }
    }

    public Engine getEngine() {
        return this.mEngine;
    }

    public TextureManager getTextureManager() {
        return this.mEngine.getTextureManager();
    }

    public FontManager getFontManager() {
        return getFontManager();
    }

    public SoundManager getSoundManager() {
        return this.mEngine.getSoundManager();
    }

    public MusicManager getMusicManager() {
        return this.mEngine.getMusicManager();
    }

    public void onResumeGame() {
    }

    public void onPauseGame() {
    }

    private void doResume() {
        if (!this.mGameLoaded) {
            onLoadResources();
            this.mEngine.onLoadComplete(onLoadScene());
            onLoadComplete();
            this.mGameLoaded = true;
        }
        this.mPaused = false;
        acquireWakeLock(this.mEngine.getEngineOptions().getWakeLockOptions());
        this.mEngine.onResume();
        this.mRenderSurfaceView.onResume();
        this.mEngine.start();
        onResumeGame();
    }

    private void doPause() {
        this.mPaused = true;
        releaseWakeLock();
        this.mEngine.onPause();
        this.mEngine.stop();
        this.mRenderSurfaceView.onPause();
        onPauseGame();
    }

    public void runOnUpdateThread(Runnable pRunnable) {
        this.mEngine.runOnUpdateThread(pRunnable);
    }

    protected void onSetContentView() {
        this.mRenderSurfaceView = new RenderSurfaceView(this);
        this.mRenderSurfaceView.setEGLConfigChooser(false);
        this.mRenderSurfaceView.setRenderer(this.mEngine);
        setContentView(this.mRenderSurfaceView, createSurfaceViewLayoutParams());
    }

    private void acquireWakeLock(WakeLockOptions pWakeLockOptions) {
        if (pWakeLockOptions == WakeLockOptions.SCREEN_ON) {
            ActivityUtils.keepScreenOn(this);
            return;
        }
        this.mWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(pWakeLockOptions.getFlag() | DriveFile.MODE_WRITE_ONLY, Constants.DEBUGTAG);
        try {
            this.mWakeLock.acquire();
        } catch (SecurityException e) {
            Debug.m62e("You have to add\n\t<uses-permission android:name=\"android.permission.WAKE_LOCK\"/>\nto your AndroidManifest.xml !", e);
        }
    }

    private void releaseWakeLock() {
        if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
            this.mWakeLock.release();
        }
    }

    private void applyEngineOptions(EngineOptions pEngineOptions) {
        if (pEngineOptions.isFullscreen()) {
            ActivityUtils.requestFullscreen(this);
        }
        if (pEngineOptions.needsMusic() || pEngineOptions.needsSound()) {
            setVolumeControlStream(3);
        }
        switch (m58x1e79e3c8()[pEngineOptions.getScreenOrientation().ordinal()]) {
            case 1:
                setRequestedOrientation(0);
                return;
            case 2:
                setRequestedOrientation(1);
                return;
            default:
                return;
        }
    }

    protected LayoutParams createSurfaceViewLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    protected void enableVibrator() {
        this.mEngine.enableVibrator(this);
    }

    protected void enableLocationSensor(ILocationListener pLocationListener, LocationSensorOptions pLocationSensorOptions) {
        this.mEngine.enableLocationSensor(this, pLocationListener, pLocationSensorOptions);
    }

    protected void disableLocationSensor() {
        this.mEngine.disableLocationSensor(this);
    }

    protected boolean enableAccelerometerSensor(IAccelerometerListener pAccelerometerListener) {
        return this.mEngine.enableAccelerometerSensor(this, pAccelerometerListener);
    }

    protected boolean enableAccelerometerSensor(IAccelerometerListener pAccelerometerListener, AccelerometerSensorOptions pAccelerometerSensorOptions) {
        return this.mEngine.enableAccelerometerSensor(this, pAccelerometerListener, pAccelerometerSensorOptions);
    }

    protected boolean disableAccelerometerSensor() {
        return this.mEngine.disableAccelerometerSensor(this);
    }

    protected boolean enableOrientationSensor(IOrientationListener pOrientationListener) {
        return this.mEngine.enableOrientationSensor(this, pOrientationListener);
    }

    protected boolean enableOrientationSensor(IOrientationListener pOrientationListener, OrientationSensorOptions pLocationSensorOptions) {
        return this.mEngine.enableOrientationSensor(this, pOrientationListener, pLocationSensorOptions);
    }

    protected boolean disableOrientationSensor() {
        return this.mEngine.disableOrientationSensor(this);
    }
}
