package org.anddev.andengine.extension.ui.livewallpaper;

import android.os.Bundle;
import android.os.SystemClock;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import net.rbgrn.opengl.GLWallpaperService;
import net.rbgrn.opengl.GLWallpaperService.GLEngine;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.opengl.view.GLSurfaceView.Renderer;
import org.anddev.andengine.opengl.view.RenderSurfaceView;
import org.anddev.andengine.sensor.accelerometer.IAccelerometerListener;
import org.anddev.andengine.sensor.orientation.IOrientationListener;
import org.anddev.andengine.ui.IGameInterface;

public abstract class BaseLiveWallpaperService extends GLWallpaperService implements IGameInterface {
    private Engine mEngine;

    protected class BaseWallpaperGLEngine extends GLEngine {
        private Renderer mRenderer;

        public BaseWallpaperGLEngine() {
            super();
            setEGLConfigChooser(false);
            this.mRenderer = new RenderSurfaceView.Renderer(BaseLiveWallpaperService.this.mEngine);
            setRenderer(this.mRenderer);
            setRenderMode(1);
        }

        public Bundle onCommand(String pAction, int pX, int pY, int pZ, Bundle pExtras, boolean pResultRequested) {
            if (pAction.equals("android.wallpaper.tap")) {
                BaseLiveWallpaperService.this.onTap(pX, pY);
            } else if (pAction.equals("android.home.drop")) {
                BaseLiveWallpaperService.this.onDrop(pX, pY);
            }
            return super.onCommand(pAction, pX, pY, pZ, pExtras, pResultRequested);
        }

        public void onResume() {
            super.onResume();
            BaseLiveWallpaperService.this.getEngine().onResume();
            BaseLiveWallpaperService.this.onResume();
        }

        public void onPause() {
            super.onPause();
            BaseLiveWallpaperService.this.getEngine().onPause();
            BaseLiveWallpaperService.this.onPause();
        }

        public void onDestroy() {
            super.onDestroy();
            this.mRenderer = null;
        }
    }

    public void onCreate() {
        super.onCreate();
        this.mEngine = onLoadEngine();
        applyEngineOptions(this.mEngine.getEngineOptions());
        onLoadResources();
        this.mEngine.onLoadComplete(onLoadScene());
        onLoadComplete();
        this.mEngine.start();
    }

    public Engine getEngine() {
        return this.mEngine;
    }

    protected void onPause() {
        this.mEngine.stop();
    }

    protected void onResume() {
        this.mEngine.start();
    }

    public WallpaperService.Engine onCreateEngine() {
        return new BaseWallpaperGLEngine();
    }

    protected void onTap(int pX, int pY) {
        this.mEngine.onTouch(null, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, (float) pX, (float) pY, 0));
    }

    protected void onDrop(int pX, int pY) {
    }

    protected void applyEngineOptions(EngineOptions pEngineOptions) {
    }

    protected boolean enableVibrator() {
        return this.mEngine.enableVibrator(this);
    }

    protected boolean enableAccelerometerSensor(IAccelerometerListener pAccelerometerListener) {
        return this.mEngine.enableAccelerometerSensor(this, pAccelerometerListener);
    }

    protected boolean enableOrientationSensor(IOrientationListener pOrientationListener) {
        return this.mEngine.enableOrientationSensor(this, pOrientationListener);
    }
}
