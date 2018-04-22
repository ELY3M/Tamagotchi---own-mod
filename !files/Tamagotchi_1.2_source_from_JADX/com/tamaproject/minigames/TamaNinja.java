package com.tamaproject.minigames;

import android.graphics.Typeface;
import android.view.Display;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tamaproject.BaseAndEngineGame;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import org.anddev.andengine.audio.music.Music;
import org.anddev.andengine.audio.music.MusicFactory;
import org.anddev.andengine.audio.sound.Sound;
import org.anddev.andengine.audio.sound.SoundFactory;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.modifier.MoveModifier;
import org.anddev.andengine.entity.modifier.MoveXModifier;
import org.anddev.andengine.entity.scene.CameraScene;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class TamaNinja extends BaseAndEngineGame implements IOnSceneTouchListener {
    private LinkedList<Sprite> TargetsToBeAdded;
    private Music backgroundMusic;
    IUpdateHandler detect = new C08921();
    private Sprite failSprite;
    private int hitCount;
    private BitmapTextureAtlas mBitmapTextureAtlas;
    private Camera mCamera;
    private TextureRegion mFailTextureRegion;
    private Font mFont;
    private BitmapTextureAtlas mFontTexture;
    private Scene mMainScene;
    private CameraScene mPauseScene;
    private TextureRegion mPausedTextureRegion;
    private TextureRegion mPlayerTextureRegion;
    private TextureRegion mProjectileTextureRegion;
    private CameraScene mResultScene;
    private TextureRegion mTargetTextureRegion;
    private TextureRegion mWinTextureRegion;
    private final int maxScore = 2;
    private boolean pauseFlag = false;
    private Sprite player;
    private LinkedList<Sprite> projectileLL;
    private LinkedList<Sprite> projectilesToBeAdded;
    private boolean runningFlag = false;
    private ChangeableText score;
    private Sound shootingSound;
    private LinkedList<Sprite> targetLL;
    private Sprite winSprite;

    class C05794 implements Runnable {
        C05794() {
        }

        public void run() {
            TamaNinja.this.mMainScene.detachChildren();
            TamaNinja.this.mMainScene.attachChild(TamaNinja.this.player, 0);
            TamaNinja.this.mMainScene.attachChild(TamaNinja.this.score);
        }
    }

    class C08921 implements IUpdateHandler {
        C08921() {
        }

        public void reset() {
        }

        public void onUpdate(float pSecondsElapsed) {
            Iterator<Sprite> targets = TamaNinja.this.targetLL.iterator();
            boolean hit = false;
            while (targets.hasNext()) {
                Sprite _target = (Sprite) targets.next();
                if (_target.getX() <= (-_target.getWidth())) {
                    TamaNinja.this.removeSprite(_target, targets);
                    TamaNinja.this.fail();
                    break;
                }
                Iterator<Sprite> projectiles = TamaNinja.this.projectileLL.iterator();
                while (projectiles.hasNext()) {
                    Sprite _projectile = (Sprite) projectiles.next();
                    if (_projectile.getX() >= TamaNinja.this.mCamera.getWidth() || _projectile.getY() >= TamaNinja.this.mCamera.getHeight() + _projectile.getHeight() || _projectile.getY() <= (-_projectile.getHeight())) {
                        TamaNinja.this.removeSprite(_projectile, projectiles);
                    } else if (_target.collidesWith(_projectile)) {
                        TamaNinja.this.removeSprite(_projectile, projectiles);
                        hit = true;
                        break;
                    }
                }
                if (hit) {
                    TamaNinja.this.removeSprite(_target, targets);
                    hit = false;
                    TamaNinja.this.hitCount = TamaNinja.this.hitCount + 1;
                    TamaNinja.this.score.setText(String.valueOf(TamaNinja.this.hitCount));
                }
            }
            if (TamaNinja.this.hitCount >= 2) {
                TamaNinja.this.win();
            }
            TamaNinja.this.projectileLL.addAll(TamaNinja.this.projectilesToBeAdded);
            TamaNinja.this.projectilesToBeAdded.clear();
            TamaNinja.this.targetLL.addAll(TamaNinja.this.TargetsToBeAdded);
            TamaNinja.this.TargetsToBeAdded.clear();
        }
    }

    class C08933 implements ITimerCallback {
        C08933() {
        }

        public void onTimePassed(TimerHandler pTimerHandler) {
            TamaNinja.this.addTarget();
        }
    }

    public Engine onLoadEngine() {
        Display display = getWindowManager().getDefaultDisplay();
        int cameraWidth = display.getWidth();
        int cameraHeight = display.getHeight();
        this.mCamera = new Camera(0.0f, 0.0f, (float) cameraWidth, (float) cameraHeight);
        return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy((float) cameraWidth, (float) cameraHeight), this.mCamera).setNeedsSound(true).setNeedsMusic(true));
    }

    public void onLoadResources() {
        this.mBitmapTextureAtlas = new BitmapTextureAtlas(512, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.mFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        this.mPlayerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "player.png", 0, 0);
        this.mProjectileTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "Projectile.png", 64, 0);
        this.mTargetTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "Target.png", 128, 0);
        this.mPausedTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "paused.png", 0, 64);
        this.mWinTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "win.png", 0, 128);
        this.mFailTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "fail.png", 0, 256);
        this.mFont = new Font(this.mFontTexture, Typeface.create(Typeface.DEFAULT, 1), 40.0f, true, -16777216);
        this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
        this.mEngine.getTextureManager().loadTexture(this.mFontTexture);
        this.mEngine.getFontManager().loadFont(this.mFont);
        SoundFactory.setAssetBasePath("mfx/");
        try {
            this.shootingSound = SoundFactory.createSoundFromAsset(this.mEngine.getSoundManager(), this, "pew.mp3");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        MusicFactory.setAssetBasePath("mfx/");
        try {
            this.backgroundMusic = MusicFactory.createMusicFromAsset(this.mEngine.getMusicManager(), this, "playing_with_power.mp3");
            this.backgroundMusic.setLooping(true);
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
        } catch (IOException e22) {
            e22.printStackTrace();
        }
    }

    public Scene onLoadScene() {
        this.mEngine.registerUpdateHandler(new FPSLogger());
        this.mPauseScene = new CameraScene(this.mCamera);
        int x = (int) ((this.mCamera.getWidth() / 2.0f) - ((float) (this.mPausedTextureRegion.getWidth() / 2)));
        int y = (int) ((this.mCamera.getHeight() / 2.0f) - ((float) (this.mPausedTextureRegion.getHeight() / 2)));
        this.mPauseScene.attachChild(new Sprite((float) x, (float) y, this.mPausedTextureRegion));
        this.mPauseScene.setBackgroundEnabled(false);
        this.mResultScene = new CameraScene(this.mCamera);
        this.winSprite = new Sprite((float) x, (float) y, this.mWinTextureRegion);
        this.failSprite = new Sprite((float) x, (float) y, this.mFailTextureRegion);
        this.mResultScene.attachChild(this.winSprite);
        this.mResultScene.attachChild(this.failSprite);
        this.mResultScene.setBackgroundEnabled(false);
        this.winSprite.setVisible(false);
        this.failSprite.setVisible(false);
        this.mMainScene = new Scene();
        this.mMainScene.setBackground(new ColorBackground(0.96862745f, 0.9137255f, 0.40392157f));
        this.mMainScene.setOnSceneTouchListener(this);
        this.player = new Sprite((float) (this.mPlayerTextureRegion.getWidth() / 2), (float) ((int) ((this.mCamera.getHeight() - ((float) this.mPlayerTextureRegion.getHeight())) / 2.0f)), this.mPlayerTextureRegion);
        this.player.setScale(2.0f);
        this.projectileLL = new LinkedList();
        this.targetLL = new LinkedList();
        this.projectilesToBeAdded = new LinkedList();
        this.TargetsToBeAdded = new LinkedList();
        this.score = new ChangeableText(0.0f, 0.0f, this.mFont, String.valueOf(2));
        this.score.setPosition((this.mCamera.getWidth() - this.score.getWidth()) - 5.0f, 5.0f);
        createSpriteSpawnTimeHandler();
        this.mMainScene.registerUpdateHandler(this.detect);
        this.backgroundMusic.play();
        restart();
        return this.mMainScene;
    }

    public void onLoadComplete() {
    }

    public void removeSprite(final Sprite _sprite, Iterator<Sprite> it) {
        runOnUpdateThread(new Runnable() {
            public void run() {
                TamaNinja.this.mMainScene.detachChild(_sprite);
            }
        });
        it.remove();
    }

    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        if (pSceneTouchEvent.getAction() != 0) {
            return false;
        }
        shootProjectile(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
        return true;
    }

    private void shootProjectile(float pX, float pY) {
        int offX = (int) (pX - this.player.getX());
        int offY = (int) (pY - this.player.getY());
        if (offX > 0) {
            Sprite projectile = new Sprite(this.player.getX(), this.player.getY(), this.mProjectileTextureRegion.deepCopy());
            this.mMainScene.attachChild(projectile, 1);
            int realX = (int) (this.mCamera.getWidth() + (projectile.getWidth() / 2.0f));
            int realY = (int) ((((float) realX) * (((float) offY) / ((float) offX))) + projectile.getY());
            int offRealX = (int) (((float) realX) - projectile.getX());
            int offRealY = (int) (((float) realY) - projectile.getY());
            projectile.registerEntityModifier(new MoveModifier(((float) Math.sqrt((double) ((offRealX * offRealX) + (offRealY * offRealY)))) / 480.0f, projectile.getX(), (float) realX, projectile.getY(), (float) realY).deepCopy());
            this.projectilesToBeAdded.add(projectile);
            this.shootingSound.play();
        }
    }

    public void addTarget() {
        Random rand = new Random();
        int x = ((int) this.mCamera.getWidth()) + this.mTargetTextureRegion.getWidth();
        int minY = this.mTargetTextureRegion.getHeight();
        Sprite target = new Sprite((float) x, (float) (rand.nextInt(((int) (this.mCamera.getHeight() - ((float) this.mTargetTextureRegion.getHeight()))) - minY) + minY), this.mTargetTextureRegion.deepCopy());
        this.mMainScene.attachChild(target);
        target.registerEntityModifier(new MoveXModifier((float) (rand.nextInt(10 - 5) + 5), target.getX(), -target.getWidth()).deepCopy());
        this.TargetsToBeAdded.add(target);
    }

    private void createSpriteSpawnTimeHandler() {
        getEngine().registerUpdateHandler(new TimerHandler(5.0f, true, new C08933()));
    }

    public void restart() {
        runOnUpdateThread(new C05794());
        this.hitCount = 0;
        this.score.setText(String.valueOf(this.hitCount));
        this.projectileLL.clear();
        this.projectilesToBeAdded.clear();
        this.targetLL.clear();
    }

    protected void onPause() {
        if (this.runningFlag) {
            pauseMusic();
            if (this.mEngine.isRunning()) {
                pauseGame();
                this.pauseFlag = true;
            }
        }
        super.onPause();
    }

    public void onResumeGame() {
        super.onResumeGame();
        if (!this.runningFlag) {
            this.runningFlag = true;
        } else if (this.pauseFlag) {
            this.pauseFlag = false;
            Toast.makeText(this, "Menu button to resume", 0).show();
        } else {
            resumeMusic();
            this.mEngine.stop();
        }
    }

    public void pauseMusic() {
        if (this.runningFlag && this.backgroundMusic.isPlaying()) {
            this.backgroundMusic.pause();
        }
    }

    public void resumeMusic() {
        if (this.runningFlag && !this.backgroundMusic.isPlaying()) {
            this.backgroundMusic.resume();
        }
    }

    public void fail() {
        if (this.mEngine.isRunning()) {
            this.winSprite.setVisible(false);
            this.failSprite.setVisible(true);
            this.mMainScene.setChildScene(this.mResultScene, false, true, true);
            this.mEngine.stop();
        }
    }

    public void win() {
        if (this.mEngine.isRunning()) {
            this.failSprite.setVisible(false);
            this.winSprite.setVisible(true);
            this.mMainScene.setChildScene(this.mResultScene, false, true, true);
            this.mEngine.stop();
        }
    }

    public void pauseGame() {
        if (this.runningFlag) {
            this.mMainScene.setChildScene(this.mPauseScene, false, true, true);
            this.mEngine.stop();
        }
    }

    public void unPauseGame() {
        this.mMainScene.clearChildScene();
    }

    public boolean onKeyDown(int pKeyCode, KeyEvent pEvent) {
        if (pKeyCode == 82 && pEvent.getAction() == 0) {
            if (this.mEngine.isRunning() && this.backgroundMusic.isPlaying()) {
                pauseMusic();
                this.pauseFlag = true;
                pauseGame();
                Toast.makeText(this, "Menu Button to reume", 0).show();
            } else if (this.backgroundMusic.isPlaying()) {
                return true;
            } else {
                unPauseGame();
                this.pauseFlag = false;
                resumeMusic();
                this.mEngine.start();
                return true;
            }
        } else if (pKeyCode == 4 && pEvent.getAction() == 0) {
            if (this.mEngine.isRunning() || !this.backgroundMusic.isPlaying()) {
                return super.onKeyDown(pKeyCode, pEvent);
            }
            this.mMainScene.clearChildScene();
            this.mEngine.start();
            restart();
            return true;
        }
        return super.onKeyDown(pKeyCode, pEvent);
    }

    public void pauseSound() {
    }

    public void resumeSound() {
    }
}
