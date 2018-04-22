package org.anddev.andengine.engine.options;

import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.resolutionpolicy.IResolutionPolicy;

public class EngineOptions {
    private final Camera mCamera;
    private final boolean mFullscreen;
    private boolean mNeedsMusic;
    private boolean mNeedsSound;
    private final RenderOptions mRenderOptions = new RenderOptions();
    private final IResolutionPolicy mResolutionPolicy;
    private final ScreenOrientation mScreenOrientation;
    private final TouchOptions mTouchOptions = new TouchOptions();
    private int mUpdateThreadPriority = 0;
    private WakeLockOptions mWakeLockOptions = WakeLockOptions.SCREEN_BRIGHT;

    public enum ScreenOrientation {
        LANDSCAPE,
        PORTRAIT
    }

    public EngineOptions(boolean pFullscreen, ScreenOrientation pScreenOrientation, IResolutionPolicy pResolutionPolicy, Camera pCamera) {
        this.mFullscreen = pFullscreen;
        this.mScreenOrientation = pScreenOrientation;
        this.mResolutionPolicy = pResolutionPolicy;
        this.mCamera = pCamera;
    }

    public TouchOptions getTouchOptions() {
        return this.mTouchOptions;
    }

    public RenderOptions getRenderOptions() {
        return this.mRenderOptions;
    }

    public boolean isFullscreen() {
        return this.mFullscreen;
    }

    public ScreenOrientation getScreenOrientation() {
        return this.mScreenOrientation;
    }

    public IResolutionPolicy getResolutionPolicy() {
        return this.mResolutionPolicy;
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public int getUpdateThreadPriority() {
        return this.mUpdateThreadPriority;
    }

    public void setUpdateThreadPriority(int pUpdateThreadPriority) {
        this.mUpdateThreadPriority = pUpdateThreadPriority;
    }

    public boolean needsSound() {
        return this.mNeedsSound;
    }

    public EngineOptions setNeedsSound(boolean pNeedsSound) {
        this.mNeedsSound = pNeedsSound;
        return this;
    }

    public boolean needsMusic() {
        return this.mNeedsMusic;
    }

    public EngineOptions setNeedsMusic(boolean pNeedsMusic) {
        this.mNeedsMusic = pNeedsMusic;
        return this;
    }

    public WakeLockOptions getWakeLockOptions() {
        return this.mWakeLockOptions;
    }

    public EngineOptions setWakeLockOptions(WakeLockOptions pWakeLockOptions) {
        this.mWakeLockOptions = pWakeLockOptions;
        return this;
    }
}
