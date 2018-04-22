package org.anddev.andengine.ui.activity;

import android.app.Activity;
import android.content.Intent;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.IResolutionPolicy;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.SplashScene;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasFactory;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.bitmap.BitmapTexture.BitmapTextureFormat;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public abstract class BaseSplashActivity extends BaseGameActivity {
    private Camera mCamera;
    private TextureRegion mLoadingScreenTextureRegion;
    private IBitmapTextureAtlasSource mSplashTextureAtlasSource;

    class C09291 implements ITimerCallback {
        C09291() {
        }

        public void onTimePassed(TimerHandler pTimerHandler) {
            BaseSplashActivity.this.startActivity(new Intent(BaseSplashActivity.this, BaseSplashActivity.this.getFollowUpActivity()));
            BaseSplashActivity.this.finish();
        }
    }

    protected abstract Class<? extends Activity> getFollowUpActivity();

    protected abstract ScreenOrientation getScreenOrientation();

    protected abstract float getSplashDuration();

    protected abstract IBitmapTextureAtlasSource onGetSplashTextureAtlasSource();

    protected float getSplashScaleFrom() {
        return 1.0f;
    }

    protected float getSplashScaleTo() {
        return 1.0f;
    }

    public void onLoadComplete() {
    }

    public Engine onLoadEngine() {
        this.mSplashTextureAtlasSource = onGetSplashTextureAtlasSource();
        int width = this.mSplashTextureAtlasSource.getWidth();
        int height = this.mSplashTextureAtlasSource.getHeight();
        this.mCamera = getSplashCamera(width, height);
        return new Engine(new EngineOptions(true, getScreenOrientation(), getSplashResolutionPolicy(width, height), this.mCamera));
    }

    public void onLoadResources() {
        BitmapTextureAtlas loadingScreenBitmapTextureAtlas = BitmapTextureAtlasFactory.createForTextureAtlasSourceSize(BitmapTextureFormat.RGBA_8888, this.mSplashTextureAtlasSource, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.mLoadingScreenTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromSource(loadingScreenBitmapTextureAtlas, this.mSplashTextureAtlasSource, 0, 0);
        getEngine().getTextureManager().loadTexture(loadingScreenBitmapTextureAtlas);
    }

    public Scene onLoadScene() {
        float splashDuration = getSplashDuration();
        SplashScene splashScene = new SplashScene(this.mCamera, this.mLoadingScreenTextureRegion, splashDuration, getSplashScaleFrom(), getSplashScaleTo());
        splashScene.registerUpdateHandler(new TimerHandler(splashDuration, new C09291()));
        return splashScene;
    }

    protected Camera getSplashCamera(int pSplashwidth, int pSplashHeight) {
        return new Camera(0.0f, 0.0f, (float) pSplashwidth, (float) pSplashHeight);
    }

    protected IResolutionPolicy getSplashResolutionPolicy(int pSplashwidth, int pSplashHeight) {
        return new RatioResolutionPolicy((float) pSplashwidth, (float) pSplashHeight);
    }
}
