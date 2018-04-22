package com.tamaproject.minigames;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.widget.Toast;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tamaproject.BaseAndEngineGame;
import com.tamaproject.util.TextureUtil;
import java.util.Hashtable;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.hud.controls.AnalogOnScreenControl;
import org.anddev.andengine.engine.camera.hud.controls.AnalogOnScreenControl.IAnalogOnScreenControlListener;
import org.anddev.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.modifier.IEntityModifier;
import org.anddev.andengine.entity.modifier.LoopEntityModifier;
import org.anddev.andengine.entity.modifier.ParallelEntityModifier;
import org.anddev.andengine.entity.modifier.RotationModifier;
import org.anddev.andengine.entity.modifier.ScaleModifier;
import org.anddev.andengine.entity.modifier.SequenceEntityModifier;
import org.anddev.andengine.entity.primitive.Line;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.RepeatingSpriteBackground;
import org.anddev.andengine.entity.shape.Shape;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.sprite.TiledSprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.extension.physics.box2d.FixedStepPhysicsWorld;
import org.anddev.andengine.extension.physics.box2d.PhysicsConnector;
import org.anddev.andengine.extension.physics.box2d.PhysicsFactory;
import org.anddev.andengine.extension.physics.box2d.PhysicsWorld;
import org.anddev.andengine.extension.physics.box2d.util.Vector2Pool;
import org.anddev.andengine.extension.physics.box2d.util.constants.PhysicsConstants;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.AssetBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.util.MathUtils;

public class MiniGame extends BaseAndEngineGame {
    private static final boolean FULLSCREEN = true;
    private static final int OBSTACLE_SIZE = 16;
    private static final int RACETRACK_WIDTH = 64;
    private static final int TAMA_SIZE = 24;
    private static final int cameraHeightMG = 192;
    private static final int cameraWidthMG = 320;
    public boolean checkpoint_flag = false;
    private int currentLap = 0;
    private long delayexit = 0;
    public boolean endgame_flag = false;
    private long finalTime = 0;
    private long finalminutes;
    private long finalseconds;
    public boolean finaltime_flag = false;
    private long lapTime = 0;
    private long laphours;
    private long lapmiliseconds = 0;
    private long lapminutes;
    private long lapseconds = 0;
    private Hashtable<String, TextureRegion> listTR;
    private BitmapTextureAtlas mBallTexture;
    private Camera mCameraMG;
    private Font mFont;
    private BitmapTextureAtlas mFontTexture;
    private RepeatingSpriteBackground mGrassBackgroundMG;
    private TextureRegion mOnScreenControlBaseTextureRegion;
    private TextureRegion mOnScreenControlKnobTextureRegion;
    private BitmapTextureAtlas mOnScreenControlTexture;
    private PhysicsWorld mPhysicsWorld;
    private boolean mPlaceOnScreenControlsAtDifferentVerticalLocations = false;
    private BitmapTextureAtlas mRacetrackTexture;
    private Scene mSceneMG;
    private Font mSmallFont;
    private BitmapTextureAtlas mSmallFontTexture;
    private TiledSprite mTama;
    private BitmapTextureAtlas mTamaBitmapTextureAtlas;
    private Body mTamaBody;
    private BitmapTextureAtlas mTamaTexture;
    private TiledTextureRegion mTamaTextureRegion;
    private long miliseconds;
    private long minutes;
    private long seconds;
    private long startTime = 0;
    public boolean startingline_flag = false;
    public Handler toaster = new C05765();
    private int totalLap = 3;
    private long totalTime = 0;
    private long totalminutes = 0;
    private long totalseconds = 0;

    class C05741 implements OnClickListener {
        C05741() {
        }

        public void onClick(DialogInterface dialog, int whichButton) {
        }
    }

    class C05752 implements OnClickListener {
        C05752() {
        }

        public void onClick(DialogInterface dialog, int whichButton) {
        }
    }

    class C05765 extends Handler {
        C05765() {
        }

        public void handleMessage(Message msg) {
            Toast.makeText(MiniGame.this.getBaseContext(), msg.getData().getString("msg"), 0).show();
        }
    }

    class C10334 implements IAnalogOnScreenControlListener {
        C10334() {
        }

        public void onControlChange(BaseOnScreenControl pBaseOnScreenControl, float pValueX, float pValueY) {
            Body TamaBody = MiniGame.this.mTamaBody;
            Vector2 velocity = Vector2Pool.obtain(pValueX * 1.0f, 1.0f * pValueY);
            TamaBody.setLinearVelocity(velocity);
            Vector2Pool.recycle(velocity);
            float rotationInRad = (float) Math.atan2((double) (-pValueX), (double) pValueY);
            TamaBody.setTransform(TamaBody.getWorldCenter(), rotationInRad);
            MiniGame.this.mTama.setRotation(MathUtils.radToDeg(rotationInRad));
        }

        public void onControlClick(AnalogOnScreenControl pAnalogOnScreenControl) {
        }
    }

    public Engine onLoadEngine() {
        Toast.makeText(this, "Changed Shape to Rectangle", 1).show();
        this.mCameraMG = new Camera(0.0f, 0.0f, 320.0f, 192.0f);
        return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(320.0f, 192.0f), this.mCameraMG));
    }

    public void onLoadResources() {
        this.listTR = TextureUtil.loadTextures(this, this.mEngine, new String[]{new String("gfx/")});
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("");
        this.mFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.mSmallFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.mFont = FontFactory.createFromAsset(this.mFontTexture, this, "ITCKRIST.TTF", 24.0f, true, SupportMenu.CATEGORY_MASK);
        this.mSmallFont = FontFactory.createFromAsset(this.mSmallFontTexture, this, "ITCKRIST.TTF", 18.0f, true, SupportMenu.CATEGORY_MASK);
        this.mEngine.getTextureManager().loadTexture(this.mFontTexture);
        this.mEngine.getTextureManager().loadTexture(this.mSmallFontTexture);
        this.mEngine.getFontManager().loadFont(this.mFont);
        this.mEngine.getFontManager().loadFont(this.mSmallFont);
        this.mGrassBackgroundMG = new RepeatingSpriteBackground(320.0f, 192.0f, this.mEngine.getTextureManager(), new AssetBitmapTextureAtlasSource(this, "gfx/background_grass.png"));
        this.mTamaBitmapTextureAtlas = new BitmapTextureAtlas(128, 1024, TextureOptions.BILINEAR);
        this.mTamaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mTamaBitmapTextureAtlas, this, "animated_gfx/snorlax.png", 0, 0, 1, 8);
        this.mRacetrackTexture = new BitmapTextureAtlas(128, 256, TextureOptions.REPEATING_BILINEAR_PREMULTIPLYALPHA);
        this.mOnScreenControlTexture = new BitmapTextureAtlas(256, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.mOnScreenControlBaseTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mOnScreenControlTexture, this, "gfx/onscreen_control_base.png", 0, 0);
        this.mOnScreenControlKnobTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mOnScreenControlTexture, this, "gfx/onscreen_control_knob.png", 128, 0);
        this.mEngine.getTextureManager().loadTextures(this.mTamaBitmapTextureAtlas, this.mOnScreenControlTexture);
    }

    public Scene onLoadScene() {
        this.mEngine.registerUpdateHandler(new FPSLogger());
        this.mSceneMG = new Scene();
        this.mSceneMG.setBackground(this.mGrassBackgroundMG);
        this.mPhysicsWorld = new FixedStepPhysicsWorld(30, new Vector2(0.0f, 0.0f), false, 8, 1);
        initRacetrack();
        initRacetrackBorders();
        initTama();
        initObstacles();
        initOnScreenControls();
        initClock();
        this.mSceneMG.registerUpdateHandler(this.mPhysicsWorld);
        final Line startingLine = new Line(0.0f, 64.0f, 64.0f, 64.0f);
        this.mSceneMG.attachChild(startingLine);
        final Line checkpoint = new Line(0.0f, 128.0f, 64.0f, 128.0f);
        this.mSceneMG.attachChild(checkpoint);
        Builder endgame = new Builder(this);
        endgame.setTitle("End Game");
        endgame.setMessage("Play Again?");
        endgame.setPositiveButton("Yes", new C05741());
        endgame.setNegativeButton("No", new C05752());
        final ChangeableText collisionText = new ChangeableText(0.0f, 0.0f, this.mFont, "blank");
        this.mSceneMG.attachChild(collisionText);
        this.mSceneMG.registerUpdateHandler(new IUpdateHandler() {
            public void reset() {
            }

            public void onUpdate(float pSecondsElapsed) {
                int i;
                int i2;
                MiniGame.this.miliseconds = (long) ((int) (MiniGame.this.totalTime / 1000));
                MiniGame.this.seconds = (long) (((int) (MiniGame.this.totalTime / 1000)) % 60);
                MiniGame.this.minutes = (long) ((int) ((MiniGame.this.totalTime / 60000) % 60));
                MiniGame.this.finalseconds = (long) (((int) (MiniGame.this.finalTime / 1000)) % 60);
                MiniGame.this.finalminutes = (long) ((int) ((MiniGame.this.finalTime / 60000) % 60));
                if (MiniGame.this.currentLap > -1) {
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i & (!MiniGame.this.endgame_flag ? 1 : 0)) != 0) {
                    MiniGame.this.totalTime = System.currentTimeMillis() - MiniGame.this.startTime;
                }
                int displayLap = MiniGame.this.currentLap + 1;
                collisionText.setText("" + MiniGame.this.minutes + ":" + MiniGame.this.seconds);
                if (MiniGame.this.currentLap >= MiniGame.this.totalLap) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (MiniGame.this.endgame_flag) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if ((i & i2) != 0) {
                    if (MiniGame.this.endgame_flag) {
                        MiniGame.this.finalTime = MiniGame.this.totalTime;
                        MiniGame.this.endgame_flag = false;
                    }
                    MiniGame.this.makeToast("Total Time: " + MiniGame.this.minutes + ":" + MiniGame.this.seconds);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                    MiniGame.this.endgame_flag = true;
                }
                if (startingLine.collidesWith(MiniGame.this.mTama)) {
                    startingLine.setColor(1.0f, 0.0f, 0.0f);
                    if (MiniGame.this.checkpoint_flag) {
                        MiniGame.this.currentLap = MiniGame.this.currentLap + 1;
                        MiniGame.this.lapseconds = MiniGame.this.seconds - MiniGame.this.totalseconds;
                        MiniGame.this.totalseconds = MiniGame.this.lapseconds + MiniGame.this.totalseconds;
                        MiniGame.this.lapminutes = MiniGame.this.minutes - MiniGame.this.totalminutes;
                        MiniGame.this.totalminutes = MiniGame.this.lapminutes + MiniGame.this.totalminutes;
                        MiniGame.this.finalTime = System.currentTimeMillis();
                        MiniGame.this.makeToast("Lap " + displayLap + ": " + MiniGame.this.lapminutes + ":" + MiniGame.this.lapseconds);
                        MiniGame.this.checkpoint_flag = false;
                    }
                } else {
                    startingLine.setColor(0.0f, 1.0f, 0.0f);
                }
                if (checkpoint.collidesWith(MiniGame.this.mTama)) {
                    MiniGame.this.checkpoint_flag = true;
                }
            }
        });
        return this.mSceneMG;
    }

    public void onLoadComplete() {
    }

    private void initOnScreenControls() {
        AnalogOnScreenControl analogOnScreenControl = new AnalogOnScreenControl(0.0f, (float) (192 - this.mOnScreenControlBaseTextureRegion.getHeight()), this.mCameraMG, this.mOnScreenControlBaseTextureRegion, this.mOnScreenControlKnobTextureRegion, 0.1f, new C10334());
        analogOnScreenControl.getControlBase().setBlendFunction(Shape.BLENDFUNCTION_SOURCE_DEFAULT, 771);
        analogOnScreenControl.getControlBase().setAlpha(0.5f);
        analogOnScreenControl.refreshControlKnobPosition();
        this.mSceneMG.setChildScene(analogOnScreenControl);
    }

    private void initTama() {
        this.mTama = new AnimatedSprite(20.0f, 44.0f, 24.0f, 24.0f, this.mTamaTextureRegion);
        this.mTama.setCurrentTileIndex(0);
        ((AnimatedSprite) this.mTama).animate(new long[]{300, 300}, 6, 7, true);
        this.mTamaBody = PhysicsFactory.createCircleBody(this.mPhysicsWorld, this.mTama, BodyType.DynamicBody, PhysicsFactory.createFixtureDef(1.0f, 0.5f, 0.5f));
        this.mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(this.mTama, this.mTamaBody, true, false));
        this.mSceneMG.attachChild(this.mTama);
    }

    private void initObstacles() {
        addObstacle(160.0f, PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
        addObstacle(160.0f, PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
        addObstacle(160.0f, 160.0f);
        addObstacle(160.0f, 160.0f);
    }

    private void addObstacle(float pX, float pY) {
        Sprite ball = new Sprite(pX, pY, 16.0f, 16.0f, (TextureRegion) this.listTR.get("red_ball.png"));
        Body ballBody = PhysicsFactory.createBoxBody(this.mPhysicsWorld, ball, BodyType.DynamicBody, PhysicsFactory.createFixtureDef(0.1f, 0.5f, 0.5f));
        ballBody.setLinearDamping(10.0f);
        ballBody.setAngularDamping(10.0f);
        this.mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(ball, ballBody, true, true));
        this.mSceneMG.attachChild(ball);
    }

    private void initRacetrack() {
        TextureRegion racetrackHorizontalStraightTextureRegion = ((TextureRegion) this.listTR.get("racetrack_straight.png")).deepCopy();
        racetrackHorizontalStraightTextureRegion.setWidth(((TextureRegion) this.listTR.get("racetrack_straight.png")).getWidth() * 3);
        TextureRegion racetrackVerticalStraightTextureRegion = (TextureRegion) this.listTR.get("racetrack_straight.png");
        this.mSceneMG.attachChild(new Sprite(64.0f, 0.0f, 192.0f, 64.0f, racetrackHorizontalStraightTextureRegion));
        this.mSceneMG.attachChild(new Sprite(64.0f, 128.0f, 192.0f, 64.0f, racetrackHorizontalStraightTextureRegion));
        Sprite leftVerticalStraight = new Sprite(0.0f, 64.0f, 64.0f, 64.0f, racetrackVerticalStraightTextureRegion);
        leftVerticalStraight.setRotation(90.0f);
        this.mSceneMG.attachChild(leftVerticalStraight);
        Sprite rightVerticalStraight = new Sprite(256.0f, 64.0f, 64.0f, 64.0f, racetrackVerticalStraightTextureRegion);
        rightVerticalStraight.setRotation(90.0f);
        this.mSceneMG.attachChild(rightVerticalStraight);
        TextureRegion racetrackCurveTextureRegion = (TextureRegion) this.listTR.get("racetrack_curve.png");
        Sprite upperLeftCurve = new Sprite(0.0f, 0.0f, 64.0f, 64.0f, racetrackCurveTextureRegion);
        upperLeftCurve.setRotation(90.0f);
        this.mSceneMG.attachChild(upperLeftCurve);
        Sprite upperRightCurve = new Sprite(256.0f, 0.0f, 64.0f, 64.0f, racetrackCurveTextureRegion);
        upperRightCurve.setRotation(BitmapDescriptorFactory.HUE_CYAN);
        this.mSceneMG.attachChild(upperRightCurve);
        Sprite lowerRightCurve = new Sprite(256.0f, 128.0f, 64.0f, 64.0f, racetrackCurveTextureRegion);
        lowerRightCurve.setRotation(BitmapDescriptorFactory.HUE_VIOLET);
        this.mSceneMG.attachChild(lowerRightCurve);
        this.mSceneMG.attachChild(new Sprite(0.0f, 128.0f, 64.0f, 64.0f, racetrackCurveTextureRegion));
    }

    private void initRacetrackBorders() {
        Shape bottomOuter = new Rectangle(0.0f, 190.0f, 320.0f, 2.0f);
        Shape topOuter = new Rectangle(0.0f, 0.0f, 320.0f, 2.0f);
        Shape leftOuter = new Rectangle(0.0f, 0.0f, 2.0f, 192.0f);
        Shape rightOuter = new Rectangle(318.0f, 0.0f, 2.0f, 192.0f);
        Shape bottomInner = new Rectangle(64.0f, 126.0f, 192.0f, 2.0f);
        Shape topInner = new Rectangle(64.0f, 64.0f, 192.0f, 2.0f);
        Shape leftInner = new Rectangle(64.0f, 64.0f, 2.0f, 64.0f);
        Shape rightInner = new Rectangle(254.0f, 64.0f, 2.0f, 64.0f);
        FixtureDef wallFixtureDef = PhysicsFactory.createFixtureDef(0.0f, 0.5f, 0.5f);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, bottomOuter, BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, topOuter, BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, leftOuter, BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, rightOuter, BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, bottomInner, BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, topInner, BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, leftInner, BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, rightInner, BodyType.StaticBody, wallFixtureDef);
        this.mSceneMG.attachChild(bottomOuter);
        this.mSceneMG.attachChild(topOuter);
        this.mSceneMG.attachChild(leftOuter);
        this.mSceneMG.attachChild(rightOuter);
        this.mSceneMG.attachChild(bottomInner);
        this.mSceneMG.attachChild(topInner);
        this.mSceneMG.attachChild(leftInner);
        this.mSceneMG.attachChild(rightInner);
    }

    private void initLap() {
        IEntityModifier[] iEntityModifierArr = new IEntityModifier[2];
        iEntityModifierArr[0] = new RotationModifier(6.0f, 0.0f, 360.0f);
        iEntityModifierArr[1] = new SequenceEntityModifier(new ScaleModifier(3.0f, 1.0f, 1.5f), new ScaleModifier(3.0f, 1.5f, 1.0f));
        LoopEntityModifier entityModifier = new LoopEntityModifier(new ParallelEntityModifier(iEntityModifierArr));
        Line startingLine = new Line(0.0f, 128.0f, 64.0f, 128.0f);
        startingLine.registerEntityModifier(entityModifier.deepCopy());
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, startingLine, BodyType.StaticBody, PhysicsFactory.createFixtureDef(0.0f, 0.0f, 0.0f));
        this.mSceneMG.attachChild(startingLine);
    }

    private void initClock() {
        this.startTime = System.currentTimeMillis();
    }

    private void endCondition() {
        if (this.currentLap == this.totalLap) {
            Toast.makeText(this, "GameOver", 0).show();
        }
    }

    public void makeToast(String str) {
        Message status = this.toaster.obtainMessage();
        Bundle datax = new Bundle();
        datax.putString("msg", str);
        status.setData(datax);
        this.toaster.sendMessage(status);
    }

    public static void wait(int delay) {
        do {
        } while (System.currentTimeMillis() - System.currentTimeMillis() < ((long) (delay * 1000)));
    }

    public void pauseSound() {
    }

    public void resumeSound() {
    }
}
