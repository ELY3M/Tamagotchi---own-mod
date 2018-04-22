package com.tamaproject;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import com.tamaproject.database.DatabaseHelper;
import com.tamaproject.entity.Backpack;
import com.tamaproject.entity.Item;
import com.tamaproject.entity.Tamagotchi;
import com.tamaproject.itemstore.ItemStore;
import com.tamaproject.minigames.MiniGameListActivity;
import com.tamaproject.multiplayer.TamaBattle;
import com.tamaproject.util.FileReaderUtil;
import com.tamaproject.util.MultiplayerConstants;
import com.tamaproject.util.TextUtil;
import com.tamaproject.util.TextureUtil;
import com.tamaproject.weather.CurrentConditions;
import com.tamaproject.weather.WeatherRetriever;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.e175.klaus.solarpositioning.AzimuthZenithAngle;
import net.e175.klaus.solarpositioning.Grena3;
import net.e175.klaus.solarpositioning.SPA;
import org.acra.ACRAConstants;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.entity.modifier.LoopEntityModifier;
import org.anddev.andengine.entity.modifier.PathModifier;
import org.anddev.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.anddev.andengine.entity.modifier.PathModifier.Path;
import org.anddev.andengine.entity.modifier.RotationModifier;
import org.anddev.andengine.entity.modifier.ScaleModifier;
import org.anddev.andengine.entity.modifier.SequenceEntityModifier;
import org.anddev.andengine.entity.particle.ParticleSystem;
import org.anddev.andengine.entity.particle.emitter.CircleOutlineParticleEmitter;
import org.anddev.andengine.entity.particle.emitter.RectangleParticleEmitter;
import org.anddev.andengine.entity.particle.initializer.AccelerationInitializer;
import org.anddev.andengine.entity.particle.initializer.AlphaInitializer;
import org.anddev.andengine.entity.particle.initializer.RotationInitializer;
import org.anddev.andengine.entity.particle.initializer.ScaleInitializer;
import org.anddev.andengine.entity.particle.initializer.VelocityInitializer;
import org.anddev.andengine.entity.particle.modifier.AlphaModifier;
import org.anddev.andengine.entity.particle.modifier.ColorModifier;
import org.anddev.andengine.entity.particle.modifier.ExpireModifier;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnAreaTouchListener;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.Scene.ITouchArea;
import org.anddev.andengine.entity.scene.background.RepeatingSpriteBackground;
import org.anddev.andengine.entity.shape.Shape;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.BaseSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.AssetBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.util.HorizontalAlign;
import org.anddev.andengine.util.MathUtils;
import org.anddev.andengine.util.modifier.IModifier;

public class MainGame extends BaseAndEngineGame implements IOnSceneTouchListener, IOnAreaTouchListener, OnInitListener, ConnectionCallbacks, OnConnectionFailedListener, LocationListener {
    private static final int CONFIRM_APPLYITEM = 0;
    private static final int CONFIRM_QUITGAME = 1;
    private static final int CONFIRM_REMOVEITEM = 2;
    private static final int CONFIRM_RESTART = 3;
    public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 150000;
    private static final boolean FULLSCREEN = true;
    static GoogleApiClient GoogleApiClient = null;
    private static final int MAX_NOTIFICATIONS = 5;
    private static final int TAMA_BATTLE_CODE = 1337;
    private static final int TAMA_ITEM_STORE_CODE = 1000;
    public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 300000;
    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;
    private static final int barHeight = 25;
    private static final int barLength = 150;
    private static int cameraHeight = 800;
    private static int cameraWidth = 480;
    private static final int iconSpacer = (cameraWidth / 7);
    private static final int iconSpacing = 30;
    private static final int leftSpacing = 50;
    private static final int numIcons = 6;
    private static int pBottomBound = (cameraHeight - 70);
    private static final int pTopBound = 115;
    private static final int vSpacing = 15;
    String TAG = "tama MainGame";
    public double ZENITH = 0.0d;
    private Rectangle astroOverlayRect;
    private Rectangle backpackBackground;
    private ChangeableText backpackLabel;
    private Entity backpackLayer = new Entity();
    private Entity bottomLayer = new Entity();
    private Rectangle bottomRect;
    private Backpack bp;
    private CurrentConditions cc;
    private Rectangle civilOverlayRect;
    private Rectangle currHealthBar;
    private Rectangle currHungerBar;
    private Rectangle currSicknessBar;
    private DatabaseHelper dbHelper;
    private boolean demoMode = true;
    private Sprite eggSprite;
    private Sprite emptytrashcan;
    private boolean firstRun = true;
    private Sprite fulltrashcan;
    private List<BaseSprite> inPlayObjects = new ArrayList();
    private List<BaseSprite> ipoToRemove = new ArrayList();
    private Rectangle itemDescriptionRect;
    private ChangeableText itemDesctiptionText;
    private Item itemToApply;
    private Item itemToRemove;
    public double lat = 0.0d;
    public Hashtable<String, TextureRegion> listTR;
    public double lon = 0.0d;
    private Camera mCamera;
    public Location mCurrentLocation;
    private Font mFont;
    private BitmapTextureAtlas mFontTexture;
    private RepeatingSpriteBackground mGrassBackground;
    public LocationRequest mLocationRequest;
    private Scene mScene;
    private Font mSmallFont;
    private BitmapTextureAtlas mSmallFontTexture;
    private Scene mSplashScene;
    private BitmapTextureAtlas mTamaBitmapTextureAtlas;
    private TiledTextureRegion mTamaTextureRegion;
    private Entity mainLayer = new Entity();
    private List<Entity> mainLayers = new ArrayList();
    private boolean manualMove = false;
    private Entity midLayer = new Entity();
    private Rectangle nauticalOverlayRect;
    private Rectangle nightOverlayRect;
    private List<String> notificationList = new LinkedList();
    private Rectangle notificationRect;
    private ChangeableText notificationText;
    private ParticleSystem particleSystem;
    private Item putBack;
    private HashMap<Entity, Rectangle> selectBoxes = new HashMap();
    private long startPlayTime;
    private ChangeableText stats;
    private Entity statsLayer = new Entity();
    private boolean stayStill = false;
    private List<Entity> subLayers = new ArrayList();
    private Item takeOut;
    private TextToSpeech talker;
    private Tamagotchi tama;
    private boolean tamaDeadParticles = false;
    private String[] tamaResponses = new String[]{"Hello"};
    private Sprite thoughtBubble;
    private Entity topLayer = new Entity();
    private Rectangle topRect;
    private long totalPlayTime = 0;
    private Rectangle unequipItemButton;
    private float velocity = 100.0f;
    private int weather = -1;
    private Entity weatherLayer = new Entity();
    private ChangeableText weatherText;

    class C05602 implements OnClickListener {

        class C05561 implements Runnable {
            C05561() {
            }

            public void run() {
                Log.i(MainGame.this.TAG, "Applying item");
                MainGame.this.applyItem(MainGame.this.itemToApply);
                if (MainGame.this.itemToApply.getName().contains("Shovel")) {
                    Log.i(MainGame.this.TAG, "cleaning up poop...");
                    for (Entity e : MainGame.this.inPlayObjects) {
                        MainGame.this.ipoToRemove.add((Sprite) e);
                    }
                }
                MainGame.this.showNotification(MainGame.this.itemToApply.getName() + " has been given to your Tamagotchi!");
                MainGame.this.itemToApply = null;
            }
        }

        C05602() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MainGame.this.runOnUpdateThread(new C05561());
        }
    }

    class C05623 implements OnClickListener {

        class C05611 implements Runnable {
            C05611() {
            }

            public void run() {
                Log.i(MainGame.this.TAG, "Putting back item");
                MainGame.this.itemToApply.detachSelf();
                MainGame.this.backpackBackground.attachChild(MainGame.this.itemToApply);
                MainGame.this.itemToApply = null;
            }
        }

        C05623() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MainGame.this.runOnUpdateThread(new C05611());
        }
    }

    class C05634 implements OnClickListener {
        C05634() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MainGame.this.finish();
        }
    }

    class C05645 implements OnClickListener {
        C05645() {
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    class C05656 implements OnClickListener {
        C05656() {
        }

        public void onClick(DialogInterface dialog, int which) {
            if (MainGame.this.eggSprite != null) {
                MainGame.this.loadTama(MainGame.this.eggSprite.getX(), MainGame.this.eggSprite.getY(), true);
            } else {
                MainGame.this.loadTama(0.0f, 0.0f, true);
            }
            MainGame.this.tamaDeadParticles = false;
            MainGame.this.showNotification("Tamagotchi has been reborn!");
        }
    }

    class C05667 implements OnClickListener {
        C05667() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MainGame.this.finish();
        }
    }

    class C05688 implements OnClickListener {

        class C05671 implements Runnable {
            C05671() {
            }

            public void run() {
                if (MainGame.this.itemToRemove != null) {
                    MainGame.this.itemToRemove.detachSelf();
                    MainGame.this.bp.removeItem(MainGame.this.itemToRemove);
                    MainGame.this.showNotification(MainGame.this.itemToRemove.getName() + " has been removed.");
                    MainGame.this.itemToRemove = null;
                    MainGame.this.bp.resetPositions((float) MainGame.cameraWidth, (float) MainGame.cameraHeight);
                }
            }
        }

        C05688() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MainGame.this.runOnUpdateThread(new C05671());
        }
    }

    class C05709 implements OnClickListener {

        class C05691 implements Runnable {
            C05691() {
            }

            public void run() {
                Log.i(MainGame.this.TAG, "Putting back item");
                MainGame.this.itemToRemove.detachSelf();
                MainGame.this.backpackBackground.attachChild(MainGame.this.itemToRemove);
                MainGame.this.itemToRemove = null;
            }
        }

        C05709() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MainGame.this.runOnUpdateThread(new C05691());
        }
    }

    class C08861 implements IUpdateHandler {
        C08861() {
        }

        public void reset() {
        }

        public void onUpdate(float pSecondsElapsed) {
            try {
                if (MainGame.this.ipoToRemove.size() > 0) {
                    Log.i(MainGame.this.TAG, "IPOs to remove: " + MainGame.this.ipoToRemove.size());
                    for (BaseSprite s : MainGame.this.ipoToRemove) {
                        s.detachSelf();
                        MainGame.this.mScene.unregisterTouchArea(s);
                        MainGame.this.inPlayObjects.remove(s);
                    }
                    MainGame.this.ipoToRemove.clear();
                    Log.i(MainGame.this.TAG, "IPOs to remove: " + MainGame.this.ipoToRemove.size());
                }
                if (MainGame.this.statsLayer.isVisible()) {
                    MainGame.this.stats.setText(TextUtil.getNormalizedText(MainGame.this.mSmallFont, MainGame.this.tama.getStats(), MainGame.this.stats.getWidth()));
                } else if (MainGame.this.mainLayer.isVisible()) {
                    MainGame.this.updateStatusBars();
                } else if (MainGame.this.backpackLayer.isVisible()) {
                    MainGame.this.backpackLabel.setText("Backpack (" + MainGame.this.bp.numItems() + "/" + MainGame.this.bp.maxSize() + ")");
                }
                if (MainGame.this.tama.checkStats() == 0) {
                    if (!MainGame.this.tamaDeadParticles) {
                        MainGame.this.showEffect(0);
                    }
                    Log.i(MainGame.this.TAG, "Tamagotchi is dead!");
                }
            } catch (Exception e) {
                Log.i(MainGame.this.TAG, "onUpdate EXCEPTION:" + e);
            } catch (Error e2) {
                Log.i(MainGame.this.TAG, "onUpdate ERROR:" + e2);
            }
        }
    }

    private class GameItem extends Item {
        private boolean moved = false;
        private boolean touched = false;

        class C05711 implements Runnable {
            C05711() {
            }

            public void run() {
                Log.i(MainGame.this.TAG, "Taking out item");
                MainGame.this.takeOut.detachSelf();
                MainGame.this.topLayer.attachChild(MainGame.this.takeOut);
                MainGame.this.takeOut = null;
            }
        }

        class C05722 implements Runnable {
            C05722() {
            }

            public void run() {
                Log.i(MainGame.this.TAG, "Putting back item");
                MainGame.this.putBack.detachSelf();
                MainGame.this.backpackBackground.attachChild(MainGame.this.putBack);
                MainGame.this.putBack = null;
            }
        }

        public GameItem(Item item) {
            super(item.getX(), item.getY(), item.getTextureRegion(), item.getName(), item.getDescription(), item.getHealth(), item.getHunger(), item.getSickness(), item.getXp(), item.getType(), item.getProtection(), item.getPrice());
        }

        public GameItem(float x, float y, TextureRegion textureRegion) {
            super(x, y, textureRegion);
        }

        public GameItem(float x, float y, TextureRegion textureRegion, String name, int health, int hunger, int sickness, int xp) {
            super(x, y, textureRegion, name, health, hunger, sickness, xp);
        }

        public GameItem(float x, float y, TextureRegion textureRegion, String name, String description, int health, int hunger, int sickness, int xp) {
            super(x, y, textureRegion, name, description, health, hunger, sickness, xp);
        }

        public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
            if (!getParent().getParent().isVisible()) {
                return false;
            }
            if (pSceneTouchEvent.isActionDown()) {
                Log.i(MainGame.this.TAG, "Item action down");
                this.touched = true;
                setScale(1.5f);
                return true;
            } else if (pSceneTouchEvent.isActionMove()) {
                Log.i(MainGame.this.TAG, "Item action move");
                if (!this.touched) {
                    return false;
                }
                if (getParent().equals(MainGame.this.backpackBackground)) {
                    MainGame.this.takeOut = this;
                    MainGame.this.runOnUpdateThread(new C05711());
                    MainGame.this.closeBackpack();
                }
                setPosition(pSceneTouchEvent.getX() - (getWidth() / 2.0f), pSceneTouchEvent.getY() - (getHeight() / 2.0f));
                this.moved = true;
                return true;
            } else if (!pSceneTouchEvent.isActionUp()) {
                return true;
            } else {
                Log.i(MainGame.this.TAG, "Item action up");
                this.touched = false;
                setScale(1.0f);
                if (this.moved) {
                    this.moved = false;
                    if (!getParent().equals(MainGame.this.topLayer)) {
                        return true;
                    }
                    if (collidesWith(MainGame.this.tama.getSprite())) {
                        if (getType() == 0) {
                            MainGame.this.itemToApply = this;
                            MainGame.this.showDialog(0);
                            return true;
                        } else if (getType() != 1) {
                            return true;
                        } else {
                            MainGame.this.equipItem(this, true);
                            return true;
                        }
                    } else if (collidesWith(MainGame.this.emptytrashcan)) {
                        MainGame.this.itemToRemove = this;
                        MainGame.this.showDialog(2);
                        return true;
                    } else {
                        MainGame.this.putBack = this;
                        MainGame.this.runOnUpdateThread(new C05722());
                        return true;
                    }
                }
                MainGame.this.showItemDescription(this);
                return true;
            }
        }
    }

    public Engine onLoadEngine() {
        Display display = getWindowManager().getDefaultDisplay();
        cameraHeight = Math.round(((float) cameraWidth) / (((float) display.getWidth()) / ((float) display.getHeight())));
        pBottomBound = cameraHeight - 70;
        System.out.println("Height: " + cameraHeight + ", Width: " + cameraWidth);
        this.mCamera = new Camera(0.0f, 0.0f, (float) cameraWidth, (float) cameraHeight);
        setVolumeControlStream(3);
        return new Engine(new EngineOptions(true, ScreenOrientation.PORTRAIT, new RatioResolutionPolicy((float) cameraWidth, (float) cameraHeight), this.mCamera));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(this.TAG, "onCreate()");
        initializeGoogleAPI();
    }

    protected void onStart() {
        super.onStart();
        Log.i(this.TAG, "onStart()");
        GoogleApiClient.connect();
    }

    public void onLoadResources() {
        this.mGrassBackground = new RepeatingSpriteBackground((float) cameraWidth, (float) cameraHeight, this.mEngine.getTextureManager(), new AssetBitmapTextureAtlasSource(this, "gfx/background_grass.png"));
        this.listTR = TextureUtil.loadTextures(this, this.mEngine, new String[]{new String("gfx/")});
        this.mFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.mSmallFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.mFont = FontFactory.createFromAsset(this.mFontTexture, this, "ITCKRIST.TTF", 24.0f, true, -1);
        this.mSmallFont = FontFactory.createFromAsset(this.mSmallFontTexture, this, "ITCKRIST.TTF", 18.0f, true, -1);
        this.mEngine.getTextureManager().loadTexture(this.mFontTexture);
        this.mEngine.getTextureManager().loadTexture(this.mSmallFontTexture);
        this.mEngine.getFontManager().loadFont(this.mFont);
        this.mEngine.getFontManager().loadFont(this.mSmallFont);
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("animated_gfx/");
        this.mTamaBitmapTextureAtlas = new BitmapTextureAtlas(128, 1024, TextureOptions.BILINEAR);
        this.mTamaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mTamaBitmapTextureAtlas, this, "snorlax.png", 0, 0, 1, 8);
        this.mEngine.getTextureManager().loadTexture(this.mTamaBitmapTextureAtlas);
    }

    public Scene onLoadScene() {
        try {
            this.dbHelper = new DatabaseHelper(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            DatabaseHelper.createDatabaseIfNotExists(this);
            Log.i(this.TAG, "createDatabase()");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            this.dbHelper.openDatabase();
            Log.i(this.TAG, "openDatabase()");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.mEngine.registerUpdateHandler(new FPSLogger());
        enableVibrator();
        this.talker = new TextToSpeech(this, this);
        this.mScene = new Scene();
        this.mScene.setBackground(this.mGrassBackground);
        loadTama((float) ((cameraWidth - ((TextureRegion) this.listTR.get("tama.png")).getWidth()) / 2), (float) ((cameraHeight - ((TextureRegion) this.listTR.get("tama.png")).getHeight()) / 2), false);
        this.thoughtBubble = new Sprite(this.tama.getSprite().getWidth(), -this.tama.getSprite().getHeight(), (TextureRegion) this.listTR.get("thought_bubble.png"));
        this.tama.getSprite().attachChild(this.thoughtBubble);
        this.thoughtBubble.setVisible(false);
        this.mainLayers.add(this.mainLayer);
        this.mainLayers.add(this.weatherLayer);
        this.subLayers.add(this.backpackLayer);
        this.subLayers.add(this.statsLayer);
        this.mScene.attachChild(this.bottomLayer);
        this.mScene.attachChild(this.mainLayer);
        this.mScene.attachChild(this.weatherLayer);
        this.mScene.attachChild(this.midLayer);
        this.mScene.attachChild(this.backpackLayer);
        this.mScene.attachChild(this.statsLayer);
        this.mScene.attachChild(this.topLayer);
        this.mainLayer.setVisible(true);
        this.backpackLayer.setVisible(false);
        this.statsLayer.setVisible(false);
        loadInterface();
        loadItems();
        this.mScene.registerTouchArea(this.tama.getSprite());
        this.emptytrashcan = new Sprite((float) ((cameraWidth - ((TextureRegion) this.listTR.get("mac-trashcan-empty.png")).getWidth()) - 15), (float) ((pBottomBound - ((TextureRegion) this.listTR.get("mac-trashcan-empty.png")).getHeight()) - 20), (TextureRegion) this.listTR.get("mac-trashcan-empty.png"));
        this.emptytrashcan.setScale(2.0f);
        this.mainLayer.attachChild(this.emptytrashcan);
        this.fulltrashcan = new Sprite((float) ((cameraWidth - ((TextureRegion) this.listTR.get("mac-trashcan-full.png")).getWidth()) - 15), (float) ((pBottomBound - ((TextureRegion) this.listTR.get("mac-trashcan-full.png")).getHeight()) - 20), (TextureRegion) this.listTR.get("mac-trashcan-full.png"));
        this.fulltrashcan.setScale(2.0f);
        this.mScene.setTouchAreaBindingEnabled(true);
        this.mScene.setOnSceneTouchListener(this);
        this.mScene.setOnAreaTouchListener(this);
        this.mScene.registerUpdateHandler(new C08861());
        loadTamaTimers();
        this.mScene.setOnAreaTouchTraversalFrontToBack();
        if (this.demoMode) {
            runDemo();
        }
        return this.mScene;
    }

    public void onLoadComplete() {
        loadOptions();
    }

    protected Dialog onCreateDialog(int id) {
        Builder builder2 = new Builder(this);
        switch (id) {
            case 0:
                try {
                    builder2.setTitle("Give Item");
                    builder2.setIcon(17301514);
                    builder2.setMessage("Are you sure you want to give " + this.itemToApply.getName() + " to your Tamagotchi?");
                    builder2.setPositiveButton(ACRAConstants.DEFAULT_DIALOG_POSITIVE_BUTTON_TEXT, new C05602());
                    builder2.setNegativeButton(ACRAConstants.DEFAULT_DIALOG_NEGATIVE_BUTTON_TEXT, new C05623());
                    return builder2.create();
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case 1:
                builder2.setTitle("Quit Game");
                builder2.setIcon(17301514);
                builder2.setMessage("Are you sure you want to quit the game?");
                builder2.setPositiveButton(ACRAConstants.DEFAULT_DIALOG_POSITIVE_BUTTON_TEXT, new C05634());
                builder2.setNegativeButton(ACRAConstants.DEFAULT_DIALOG_NEGATIVE_BUTTON_TEXT, new C05645());
                return builder2.create();
            case 2:
                builder2.setTitle("Throw Away Item");
                builder2.setIcon(17301514);
                builder2.setMessage("Are you sure you want to throw away " + this.itemToRemove.getName() + "?");
                builder2.setPositiveButton(ACRAConstants.DEFAULT_DIALOG_POSITIVE_BUTTON_TEXT, new C05688());
                builder2.setNegativeButton(ACRAConstants.DEFAULT_DIALOG_NEGATIVE_BUTTON_TEXT, new C05709());
                return builder2.create();
            case 3:
                builder2.setTitle("Rehatch?");
                builder2.setIcon(17301514);
                builder2.setMessage("Would you like to rehatch your Tamagotchi?");
                builder2.setPositiveButton("Yes", new C05656());
                builder2.setNegativeButton("No", new C05667());
                return builder2.create();
        }
        return null;
    }

    protected void onPrepareDialog(int id, Dialog dialog) {
        switch (id) {
            case 0:
                ((AlertDialog) dialog).setMessage("Are you sure you want to give " + this.itemToApply.getName() + " to your Tamagotchi?");
                return;
            case 2:
                ((AlertDialog) dialog).setMessage("Are you sure you want to throw away " + this.itemToRemove.getName() + "?");
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int pKeyCode, KeyEvent pEvent) {
        if (pKeyCode != 4 || pEvent.getAction() != 0) {
            return super.onKeyDown(pKeyCode, pEvent);
        }
        showDialog(1);
        return true;
    }

    public void onPause() {
        super.onPause();
        this.mEngine.stop();
        this.totalPlayTime += System.currentTimeMillis() - this.startPlayTime;
        this.tama.addToAge(this.totalPlayTime);
        if (this.dbHelper != null) {
            long result = this.dbHelper.insertTama(this.tama);
            if (result < 0) {
                Log.i(this.TAG, "Save Tama failed! " + result);
            } else {
                Log.i(this.TAG, "Save Tama success! " + result);
            }
            long resultBackpackSave = this.dbHelper.insertBackpack(this.bp.getItems());
            if (resultBackpackSave < 0) {
                Log.i(this.TAG, "Save backpack failed! " + resultBackpackSave);
            } else {
                Log.i(this.TAG, "Save backpack success! " + resultBackpackSave);
            }
        }
    }

    public void onResume() {
        super.onResume();
        this.mEngine.start();
        this.startPlayTime = System.currentTimeMillis();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.talker != null) {
            this.talker.stop();
            this.talker.shutdown();
        }
        try {
            Toast.makeText(this, "Total Playtime: " + ((int) (this.totalPlayTime / 86400000)) + " days, " + ((int) ((this.totalPlayTime / 3600000) % 24)) + " hours, " + ((int) ((this.totalPlayTime / 60000) % 60)) + " minutes, " + (((int) (this.totalPlayTime / 1000)) % 60) + " seconds", 0).show();
            if (this.tama != null) {
                this.tama.addToAge(this.totalPlayTime);
            }
            stopUpdates();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, ITouchArea pTouchArea, float pTouchAreaLocalX, float pTouchAreaLocalY) {
        Log.i(this.TAG, "onAreaTouched: " + pTouchAreaLocalX + ", " + pTouchAreaLocalY);
        if (pSceneTouchEvent.isActionDown()) {
        }
        return false;
    }

    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        if (pSceneTouchEvent.isActionDown() && this.mainLayer.isVisible() && !this.tama.isDead()) {
            float x = pSceneTouchEvent.getX();
            float y = pSceneTouchEvent.getY();
            if (y >= 115.0f && y <= ((float) pBottomBound)) {
                moveTama(x, y);
            }
        }
        return false;
    }

    public void pauseSound() {
    }

    public void resumeSound() {
    }

    private void loadTama(float centerX, float centerY, boolean reborn) {
        Tamagotchi tempTama = this.dbHelper.loadTama(1, this.listTR);
        if (!(reborn || tempTama == null)) {
            if (tempTama.checkStats() != 0) {
                Log.i(this.TAG, "Tama loaded from database!");
                this.firstRun = false;
                this.tama = tempTama;
                setTamaSprite(centerX, centerY);
                if (this.tama.getEquippedItem() != null) {
                    this.tama.setEquippedItem(new GameItem(this.tama.getEquippedItem()));
                    this.tama.getEquippedItem().setPosition(this.tama.getSprite().getBaseWidth() - 25.0f, this.tama.getSprite().getBaseHeight() - 25.0f);
                    this.tama.getSprite().attachChild(this.tama.getEquippedItem());
                }
            } else {
                this.firstRun = true;
            }
        }
        if (this.firstRun || reborn) {
            Log.i(this.TAG, "[loadTama] First Run!");
            this.tama = new Tamagotchi();
            if (tempTama != null) {
                this.tama.setMoney(tempTama.getMoney());
            }
            setTamaSprite(centerX, centerY);
            this.topLayer.setVisible(false);
            this.midLayer.setVisible(false);
            if (this.eggSprite == null) {
                this.eggSprite = new Sprite(centerX, centerY, (TextureRegion) this.listTR.get("wing-egg.png"));
            }
            IEntityModifierListener modListener = new IEntityModifierListener() {
                public void onModifierStarted(IModifier<IEntity> iModifier, IEntity arg1) {
                }

                public void onModifierFinished(IModifier<IEntity> iModifier, IEntity arg1) {
                    MainGame.this.topLayer.setVisible(true);
                    MainGame.this.midLayer.setVisible(true);
                    MainGame.this.eggSprite.detachSelf();
                    MainGame.this.mainLayer.attachChild(MainGame.this.tama.getSprite());
                }
            };
            LoopEntityModifier loopEntityModifier = new LoopEntityModifier(new SequenceEntityModifier(new RotationModifier(0.25f, 0.0f, 25.0f), new RotationModifier(0.25f, 25.0f, 0.0f), new RotationModifier(0.25f, 0.0f, -1103626240), new RotationModifier(0.25f, -1103626240, 0.0f)), 5);
            this.eggSprite.registerEntityModifier(new SequenceEntityModifier(modListener, loopEntityModifier, new ScaleModifier(0.1f, 1.0f, 2.0f)));
            if (!this.eggSprite.hasParent()) {
                this.mainLayer.attachChild(this.eggSprite);
                return;
            }
            return;
        }
        this.mainLayer.attachChild(this.tama.getSprite());
    }

    private void setTamaSprite(float centerX, float centerY) {
        this.tama.setSprite(new AnimatedSprite(centerX, centerY, this.mTamaTextureRegion) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!getParent().isVisible()) {
                    return false;
                }
                if (pSceneTouchEvent.isActionDown()) {
                    MainGame.this.say(MainGame.this.tamaResponses[MathUtils.random(0, MainGame.this.tamaResponses.length - 1)]);
                }
                return true;
            }
        });
        ((AnimatedSprite) this.tama.getSprite()).animate(new long[]{300, 300}, 6, 7, true);
        this.mScene.registerTouchArea(this.tama.getSprite());
    }

    private void moveTama(float x, float y) {
        if (this.tama.getSprite().hasParent() && !this.stayStill && this.tama.getStatus() != 0) {
            Path path = new Path(2).to(this.tama.getSprite().getX(), this.tama.getSprite().getY()).to(x - (this.tama.getSprite().getWidth() / 2.0f), y - (this.tama.getSprite().getHeight() / 2.0f));
            double distance = Math.sqrt(Math.pow((double) (this.tama.getSprite().getX() - x), 2.0d) + Math.pow((double) (this.tama.getSprite().getY() - y), 2.0d));
            this.tama.getSprite().clearEntityModifiers();
            this.tama.getSprite().registerEntityModifier(new PathModifier(((float) distance) / this.velocity, path, null, new IPathModifierListener() {
                public void onPathStarted(PathModifier pPathModifier, IEntity pEntity) {
                    MainGame.this.manualMove = true;
                }

                public void onPathWaypointStarted(PathModifier pPathModifier, IEntity pEntity, int pWaypointIndex) {
                    float[] xCoords = pPathModifier.getPath().getCoordinatesX();
                    float[] yCoords = pPathModifier.getPath().getCoordinatesY();
                    float deltaX = xCoords[0] - xCoords[1];
                    float deltaY = yCoords[0] - yCoords[1];
                    if (deltaX > 0.0f && Math.abs(deltaX) > Math.abs(deltaY)) {
                        ((AnimatedSprite) MainGame.this.tama.getSprite()).animate(new long[]{200, 200}, 0, 1, true);
                    } else if (deltaX < 0.0f && Math.abs(deltaX) > Math.abs(deltaY)) {
                        ((AnimatedSprite) MainGame.this.tama.getSprite()).animate(new long[]{200, 200}, 2, 3, true);
                    } else if (deltaY > 0.0f && Math.abs(deltaY) > Math.abs(deltaX)) {
                        ((AnimatedSprite) MainGame.this.tama.getSprite()).animate(new long[]{200, 200}, 4, 5, true);
                    } else if (deltaY >= 0.0f || Math.abs(deltaY) <= Math.abs(deltaX)) {
                        ((AnimatedSprite) MainGame.this.tama.getSprite()).stopAnimation();
                    } else {
                        ((AnimatedSprite) MainGame.this.tama.getSprite()).animate(new long[]{200, 200}, 6, 7, true);
                    }
                }

                public void onPathWaypointFinished(PathModifier pPathModifier, IEntity pEntity, int pWaypointIndex) {
                }

                public void onPathFinished(PathModifier pPathModifier, IEntity pEntity) {
                    ((AnimatedSprite) MainGame.this.tama.getSprite()).stopAnimation();
                    MainGame.this.manualMove = false;
                }
            }));
        }
    }

    private void loadInterface() {
        float mid = (float) ((cameraHeight - pBottomBound) / 2);
        Rectangle rectangle = new Rectangle(0.0f, 0.0f, (float) cameraWidth, (float) pBottomBound);
        rectangle.setColor(0.34509805f, 0.56078434f, 0.15294118f);
        this.statsLayer.attachChild(rectangle);
        Text statsLabel = new Text(15.0f, 15.0f, this.mFont, "Tamagotchi Stats", HorizontalAlign.LEFT);
        rectangle.attachChild(statsLabel);
        this.stats = new ChangeableText(25.0f, statsLabel.getY() + 50.0f, this.mSmallFont, this.tama.getStats(), HorizontalAlign.LEFT, 512);
        this.stats.setWidth((float) (cameraWidth - 150));
        rectangle.attachChild(this.stats);
        AnimatedSprite animatedSprite = new AnimatedSprite(0.0f, 0.0f, ((AnimatedSprite) this.tama.getSprite()).getTextureRegion());
        animatedSprite.setPosition((((float) cameraWidth) - animatedSprite.getWidth()) - 50.0f, animatedSprite.getHeight() + 25.0f);
        rectangle.attachChild(animatedSprite);
        Text text = new Text(10.0f, 5.0f, this.mSmallFont, "Unequip Item");
        this.unequipItemButton = new Rectangle(50.0f, 50.0f + (this.stats.getY() + this.stats.getHeight()), 20.0f + text.getWidth(), 10.0f + text.getHeight()) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!MainGame.this.statsLayer.isVisible() || !isVisible()) {
                    return false;
                }
                if (pSceneTouchEvent.isActionDown()) {
                    setColor(0.0f, 0.659f, 0.698f);
                } else if (pSceneTouchEvent.isActionUp()) {
                    setColor(1.0f, 0.412f, 0.0196f);
                    MainGame.this.unequipItem();
                }
                return true;
            }
        };
        this.unequipItemButton.setColor(1.0f, 0.412f, 0.0196f);
        this.unequipItemButton.attachChild(text);
        this.mScene.registerTouchArea(this.unequipItemButton);
        rectangle.attachChild(this.unequipItemButton);
        this.bottomRect = new Rectangle(0.0f, (float) pBottomBound, (float) cameraWidth, (float) cameraHeight);
        this.bottomRect.setColor(0.27450982f, 0.5176471f, 0.6392157f);
        this.midLayer.attachChild(this.bottomRect);
        this.topRect = new Rectangle(0.0f, 0.0f, (float) cameraWidth, 115.0f);
        this.topRect.setColor(0.27450982f, 0.5176471f, 0.6392157f);
        this.midLayer.attachChild(this.topRect);
        createSelectBox(this.backpackLayer, 1);
        Sprite anonymousClass14 = new Sprite((float) ((iconSpacer * 1) - (((TextureRegion) this.listTR.get("backpack.png")).getWidth() / 2)), mid - ((float) (((TextureRegion) this.listTR.get("backpack.png")).getHeight() / 2)), (TextureRegion) this.listTR.get("backpack.png")) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!getParent().getParent().isVisible() || !pSceneTouchEvent.isActionDown()) {
                    return false;
                }
                if (MainGame.this.backpackLayer.isVisible()) {
                    MainGame.this.closeBackpack();
                } else {
                    MainGame.this.backpackLabel.setText("Backpack (" + MainGame.this.bp.numItems() + "/" + MainGame.this.bp.maxSize() + ")");
                    MainGame.this.openBackpack();
                }
                return true;
            }
        };
        this.bottomRect.attachChild(anonymousClass14);
        this.mScene.registerTouchArea(anonymousClass14);
        Sprite micIcon = new Sprite((float) ((iconSpacer * 2) - (((TextureRegion) this.listTR.get("mic.png")).getWidth() / 2)), mid - ((float) (((TextureRegion) this.listTR.get("mic.png")).getHeight() / 2)), (TextureRegion) this.listTR.get("mic.png")) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!getParent().getParent().isVisible() || !pSceneTouchEvent.isActionDown()) {
                    return false;
                }
                MainGame.this.closeSubLayers();
                MainGame.this.startVoiceRecognitionActivity();
                return true;
            }
        };
        this.bottomRect.attachChild(micIcon);
        this.mScene.registerTouchArea(micIcon);
        createSelectBox(this.statsLayer, 3);
        anonymousClass14 = new Sprite((float) ((iconSpacer * 3) - (((TextureRegion) this.listTR.get("statsicon.png")).getWidth() / 2)), mid - ((float) (((TextureRegion) this.listTR.get("statsicon.png")).getHeight() / 2)), (TextureRegion) this.listTR.get("statsicon.png")) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!getParent().getParent().isVisible() || !pSceneTouchEvent.isActionDown()) {
                    return false;
                }
                if (MainGame.this.statsLayer.isVisible()) {
                    MainGame.this.closeSubLayers();
                } else {
                    MainGame.this.stats.setText(TextUtil.getNormalizedText(MainGame.this.mSmallFont, MainGame.this.tama.getStats(), MainGame.this.stats.getWidth()));
                    if (MainGame.this.tama.getEquippedItem() != null) {
                        MainGame.this.unequipItemButton.setPosition(MainGame.this.stats.getX(), (MainGame.this.stats.getY() + MainGame.this.stats.getHeight()) + 25.0f);
                        MainGame.this.unequipItemButton.setVisible(true);
                    } else {
                        MainGame.this.unequipItemButton.setVisible(false);
                    }
                    MainGame.this.openLayer(MainGame.this.statsLayer);
                }
                return true;
            }
        };
        this.bottomRect.attachChild(anonymousClass14);
        this.mScene.registerTouchArea(anonymousClass14);
        anonymousClass14 = new Sprite((float) ((iconSpacer * 4) - (((TextureRegion) this.listTR.get("statsicon.png")).getWidth() / 2)), mid - ((float) (((TextureRegion) this.listTR.get("toad-icon.png")).getHeight() / 2)), (TextureRegion) this.listTR.get("toad-icon.png")) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!getParent().getParent().isVisible() || !pSceneTouchEvent.isActionDown()) {
                    return false;
                }
                MainGame.this.startActivity(new Intent(MainGame.this.getApplicationContext(), MiniGameListActivity.class));
                return true;
            }
        };
        this.bottomRect.attachChild(anonymousClass14);
        this.mScene.registerTouchArea(anonymousClass14);
        anonymousClass14 = new Sprite((float) ((iconSpacer * 5) - (((TextureRegion) this.listTR.get("controller.png")).getWidth() / 2)), mid - ((float) (((TextureRegion) this.listTR.get("controller.png")).getHeight() / 2)), (TextureRegion) this.listTR.get("controller.png")) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!getParent().getParent().isVisible() || !pSceneTouchEvent.isActionDown()) {
                    return false;
                }
                MainGame.this.say("Let's battle!");
                Intent intent = new Intent(MainGame.this.getApplicationContext(), TamaBattle.class);
                intent.putExtra(MultiplayerConstants.BATTLE_LEVEL, MainGame.this.tama.getBattleLevel());
                intent.putExtra(MultiplayerConstants.HEALTH, MainGame.this.tama.getCurrentHealth());
                intent.putExtra(MultiplayerConstants.MAX_HEALTH, MainGame.this.tama.getMaxHealth());
                Toast.makeText(MainGame.this.getApplicationContext(), "Starting multiplayer!", 0).show();
                MainGame.this.startActivityForResult(intent, MainGame.TAMA_BATTLE_CODE);
                return true;
            }
        };
        this.bottomRect.attachChild(anonymousClass14);
        this.mScene.registerTouchArea(anonymousClass14);
        anonymousClass14 = new Sprite((float) ((iconSpacer * 6) - (((TextureRegion) this.listTR.get("shop.png")).getWidth() / 2)), mid - ((float) (((TextureRegion) this.listTR.get("shop.png")).getHeight() / 2)), (TextureRegion) this.listTR.get("shop.png")) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!getParent().getParent().isVisible() || !pSceneTouchEvent.isActionDown()) {
                    return false;
                }
                MainGame.this.say("Let's go shopping!");
                Intent intent = new Intent(MainGame.this.getApplicationContext(), ItemStore.class);
                intent.putExtra("money", MainGame.this.tama.getMoney());
                Toast.makeText(MainGame.this.getApplicationContext(), "Starting item store!", 0).show();
                MainGame.this.startActivityForResult(intent, 1000);
                return true;
            }
        };
        this.bottomRect.attachChild(anonymousClass14);
        this.mScene.registerTouchArea(anonymousClass14);
        text = new Text(35.0f, 15.0f, this.mFont, "Tamagotchi");
        this.topRect.attachChild(text);
        Rectangle healthBar = new Rectangle(50.0f, (text.getY() + text.getHeight()) + 15.0f, 150.0f, 25.0f);
        healthBar.setColor(1.0f, 1.0f, 1.0f);
        this.topRect.attachChild(healthBar);
        Rectangle hungerBar = new Rectangle((float) ((cameraWidth - 150) - 50), 15.0f, 150.0f, 25.0f);
        hungerBar.setColor(1.0f, 1.0f, 1.0f);
        this.topRect.attachChild(hungerBar);
        rectangle = new Rectangle(hungerBar.getX(), healthBar.getY(), 150.0f, 25.0f);
        rectangle.setColor(1.0f, 1.0f, 1.0f);
        this.topRect.attachChild(rectangle);
        this.currHealthBar = new Rectangle(2.0f, 2.0f, 146.0f * (((float) this.tama.getCurrentHealth()) / ((float) this.tama.getMaxHealth())), 21.0f);
        this.currHealthBar.setColor(1.0f, 0.0f, 0.0f);
        healthBar.attachChild(this.currHealthBar);
        this.topRect.attachChild(new Sprite(healthBar.getX() - BitmapDescriptorFactory.HUE_ORANGE, healthBar.getY(), (TextureRegion) this.listTR.get("heart.png")));
        this.currSicknessBar = new Rectangle(2.0f, 2.0f, 146.0f * (((float) this.tama.getCurrentSickness()) / ((float) this.tama.getMaxSickness())), 21.0f);
        this.currSicknessBar.setColor(1.0f, 0.0f, 0.0f);
        rectangle.attachChild(this.currSicknessBar);
        this.topRect.attachChild(new Sprite(rectangle.getX() - BitmapDescriptorFactory.HUE_ORANGE, rectangle.getY(), (TextureRegion) this.listTR.get("sick.png")));
        this.currHungerBar = new Rectangle(2.0f, 2.0f, 146.0f * (((float) this.tama.getCurrentHunger()) / ((float) this.tama.getMaxHunger())), 21.0f);
        this.currHungerBar.setColor(1.0f, 0.0f, 0.0f);
        hungerBar.attachChild(this.currHungerBar);
        this.topRect.attachChild(new Sprite(hungerBar.getX() - BitmapDescriptorFactory.HUE_ORANGE, hungerBar.getY(), (TextureRegion) this.listTR.get("food.png")));
        this.itemDescriptionRect = new Rectangle(10.0f, (float) (cameraHeight / 2), (float) (cameraWidth - 20), (float) Math.round((float) (((cameraHeight / 2) - (cameraHeight - pBottomBound)) - 10)));
        this.itemDescriptionRect.setColor(0.0f, 0.0f, 0.0f);
        this.itemDescriptionRect.setAlpha(0.8f);
        this.itemDescriptionRect.setVisible(false);
        this.topLayer.attachChild(this.itemDescriptionRect);
        this.itemDesctiptionText = new ChangeableText(10.0f, 10.0f, this.mSmallFont, "", 512);
        this.itemDescriptionRect.attachChild(this.itemDesctiptionText);
        this.notificationRect = new Rectangle(0.0f, 115.0f, (float) cameraWidth, 50.0f);
        this.notificationRect.setColor(0.0f, 0.0f, 0.0f);
        this.notificationRect.setAlpha(0.8f);
        this.notificationRect.setVisible(false);
        this.midLayer.attachChild(this.notificationRect);
        this.notificationText = new ChangeableText(10.0f, 10.0f, this.mSmallFont, "", 512);
        this.notificationRect.attachChild(this.notificationText);
        Sprite closeButton = new Sprite(this.itemDescriptionRect.getWidth() - ((float) ((TextureRegion) this.listTR.get("close.png")).getWidth()), 0.0f, (TextureRegion) this.listTR.get("close.png")) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!getParent().isVisible()) {
                    return false;
                }
                MainGame.this.hideItemDescription();
                return true;
            }
        };
        this.itemDescriptionRect.attachChild(closeButton);
        this.mScene.registerTouchArea(closeButton);
        anonymousClass14 = new Sprite(this.notificationRect.getWidth() - ((float) ((TextureRegion) this.listTR.get("close.png")).getWidth()), 0.0f, (TextureRegion) this.listTR.get("close.png")) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!getParent().isVisible()) {
                    return false;
                }
                MainGame.this.notificationRect.setVisible(false);
                MainGame.this.notificationText.setText("");
                MainGame.this.notificationList = new LinkedList();
                return true;
            }
        };
        this.notificationRect.attachChild(anonymousClass14);
        this.mScene.registerTouchArea(anonymousClass14);
    }

    private void updateStatusBars() {
        this.currHealthBar.setSize((((float) this.tama.getCurrentHealth()) / ((float) this.tama.getMaxHealth())) * 146.0f, 21.0f);
        this.currSicknessBar.setSize((((float) this.tama.getCurrentSickness()) / ((float) this.tama.getMaxSickness())) * 146.0f, 21.0f);
        this.currHungerBar.setSize((((float) this.tama.getCurrentHunger()) / ((float) this.tama.getMaxHunger())) * 146.0f, 21.0f);
    }

    public void addPoop(float pX, float pY) {
        IEntity poop = new Sprite(pX, pY, (TextureRegion) this.listTR.get("poop.png")) {
            private boolean touched = false;

            class C05571 implements Runnable {
                C05571() {
                }

                public void run() {
                    MainGame.this.mainLayer.detachChild(MainGame.this.emptytrashcan);
                    if (!MainGame.this.fulltrashcan.hasParent()) {
                        MainGame.this.mainLayer.attachChild(MainGame.this.fulltrashcan);
                    }
                }
            }

            class C05582 implements Runnable {
                C05582() {
                }

                public void run() {
                    MainGame.this.mainLayer.detachChild(MainGame.this.fulltrashcan);
                    if (!MainGame.this.emptytrashcan.hasParent()) {
                        MainGame.this.mainLayer.attachChild(MainGame.this.emptytrashcan);
                    }
                }
            }

            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                float x = pSceneTouchEvent.getX();
                float y = pSceneTouchEvent.getY();
                if (!getParent().isVisible()) {
                    return false;
                }
                Log.i(MainGame.this.TAG, "Touched poop");
                if (pSceneTouchEvent.isActionDown()) {
                    this.touched = true;
                } else if (pSceneTouchEvent.isActionMove()) {
                    if (!this.touched) {
                        return false;
                    }
                    if (y < 115.0f) {
                        setPosition(x - (getWidth() / 2.0f), 115.0f - (getHeight() / 2.0f));
                    } else if (y > ((float) MainGame.pBottomBound)) {
                        setPosition(x - (getWidth() / 2.0f), ((float) MainGame.pBottomBound) - (getHeight() / 2.0f));
                    } else {
                        setPosition(x - (getWidth() / 2.0f), y - (getHeight() / 2.0f));
                    }
                    if (collidesWith(MainGame.this.emptytrashcan)) {
                        MainGame.this.runOnUpdateThread(new C05571());
                    } else {
                        MainGame.this.emptytrashcan.setScale(2.0f);
                    }
                } else if (pSceneTouchEvent.isActionUp()) {
                    this.touched = false;
                    if (collidesWith(MainGame.this.emptytrashcan)) {
                        MainGame.this.ipoToRemove.add(this);
                        MainGame.this.runOnUpdateThread(new C05582());
                    }
                }
                return true;
            }
        };
        poop.setUserData("poop");
        poop.setScale(MathUtils.random(0.75f, 1.25f));
        this.inPlayObjects.add(poop);
        this.mainLayer.attachChild(poop);
        this.mainLayer.swapChildren(poop, this.tama.getSprite());
        this.mScene.registerTouchArea(poop);
    }

    private void loadItems() {
        Iterator it;
        this.bp = new Backpack();
        ArrayList<Item> backpackItems = this.dbHelper.getBackpack(this.listTR);
        if (backpackItems.isEmpty()) {
            Item umbrella = new GameItem(0.0f, 0.0f, (TextureRegion) this.listTR.get("umbrella.png"), "Umbrella", "This item protects the Tamagotchi from the rain.", 0, 0, 0, 0);
            umbrella.setType(1);
            umbrella.setProtection(2);
            this.bp.addItem(umbrella);
            this.bp.addItem(new GameItem(0.0f, 0.0f, (TextureRegion) this.listTR.get("star-white-48.png"), "Level item", 10, 100, -100, StatusCodes.AUTH_DISABLED));
            this.bp.addItem(new GameItem(0.0f, 0.0f, (TextureRegion) this.listTR.get("syringe.png"), "Cure All", StatusCodes.AUTH_DISABLED, StatusCodes.AUTH_DISABLED, -10000, 0));
            this.bp.addItem(new GameItem(0.0f, 0.0f, (TextureRegion) this.listTR.get("skull.png"), "Kill Tama", "This item kills the Tamagotchi.", -10000, 0, 0, 0));
            for (int i = 0; i < 26; i++) {
                this.bp.addItem(new GameItem(0.0f, 0.0f, (TextureRegion) this.listTR.get("apple.png"), "Apple", 10, 100, -100, 10));
            }
            this.bp.resetPositions((float) cameraWidth, (float) cameraHeight);
        } else {
            Log.i(this.TAG, "Backpack loaded from database!");
            it = backpackItems.iterator();
            while (it.hasNext()) {
                this.bp.addItem(new GameItem((Item) it.next()));
            }
            this.bp.resetPositions((float) cameraWidth, (float) cameraHeight);
        }
        this.backpackBackground = new Rectangle(0.0f, 0.0f, (float) cameraWidth, (float) pBottomBound);
        this.backpackBackground.setColor(0.34117648f, 0.22352941f, 0.078431375f);
        this.backpackLayer.attachChild(this.backpackBackground);
        this.backpackLabel = new ChangeableText(15.0f, 15.0f, this.mFont, "Backpack (" + this.bp.numItems() + "/" + this.bp.maxSize() + ")", HorizontalAlign.LEFT, 30);
        this.backpackBackground.attachChild(this.backpackLabel);
        it = this.bp.getItems().iterator();
        while (it.hasNext()) {
            Item item = (Item) it.next();
            this.backpackBackground.attachChild(item);
            this.mScene.registerTouchArea(item);
        }
    }

    private void applyItem(Item item) {
        showEffect(this.tama.applyItem(item));
        this.bp.removeItem(item);
        item.detachSelf();
        this.mScene.unregisterTouchArea(item);
    }

    private void openBackpack() {
        openLayer(this.backpackLayer);
        this.bp.resetPositions((float) cameraWidth, (float) cameraHeight);
    }

    private void closeBackpack() {
        closeSubLayers();
        this.bp.resetPositions((float) cameraWidth, (float) cameraHeight);
    }

    private void showItemDescription(Item i) {
        this.itemDesctiptionText.setText(TextUtil.getNormalizedText(this.mSmallFont, i.getInfo(), this.itemDescriptionRect.getWidth() - 20.0f));
        this.itemDescriptionRect.setHeight(this.itemDesctiptionText.getHeight());
        this.itemDescriptionRect.setPosition(this.itemDescriptionRect.getX(), (((float) pBottomBound) - this.itemDescriptionRect.getHeight()) - 10.0f);
        this.itemDescriptionRect.setVisible(true);
    }

    private void hideItemDescription() {
        this.itemDescriptionRect.setVisible(false);
    }

    public boolean isOnline() {
        NetworkInfo netInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (netInfo == null || !netInfo.isConnected()) {
            return false;
        }
        Log.i(this.TAG, "network state = true");
        return true;
    }

    private void loadWeather(int type) {
        if (this.particleSystem != null) {
            this.particleSystem.detachSelf();
            this.particleSystem = null;
        }
        if (type == 8) {
            this.weather = type;
            this.particleSystem = new ParticleSystem(new RectangleParticleEmitter((float) (cameraWidth / 2), 115.0f, (float) cameraWidth, 1.0f), 6.0f, 10.0f, 200, (TextureRegion) this.listTR.get("snowflake.png"));
            this.particleSystem.setBlendFunction(Shape.BLENDFUNCTION_SOURCE_DEFAULT, 1);
            this.particleSystem.addParticleInitializer(new VelocityInitializer(-10.0f, 10.0f, BitmapDescriptorFactory.HUE_YELLOW, 90.0f));
            this.particleSystem.addParticleInitializer(new AccelerationInitializer(5.0f, 15.0f));
            this.particleSystem.addParticleInitializer(new RotationInitializer(0.0f, 360.0f));
            this.particleSystem.addParticleModifier(new ExpireModifier(11.5f));
            this.weatherLayer.attachChild(this.particleSystem);
        } else if (type == 2) {
            this.weather = type;
            this.particleSystem = new ParticleSystem(new RectangleParticleEmitter((float) (cameraWidth / 2), 115.0f, (float) cameraWidth, 1.0f), 6.0f, 10.0f, 200, (TextureRegion) this.listTR.get("raindrop.png"));
            this.particleSystem.addParticleInitializer(new VelocityInitializer(0.0f, 0.0f, BitmapDescriptorFactory.HUE_YELLOW, 90.0f));
            this.particleSystem.addParticleInitializer(new AccelerationInitializer(0.0f, 15.0f));
            this.particleSystem.addParticleModifier(new ExpireModifier(11.5f));
            this.weatherLayer.attachChild(this.particleSystem);
        } else if (type == 0) {
            this.weather = type;
            this.particleSystem = new ParticleSystem(new RectangleParticleEmitter((float) (cameraWidth / 2), 115.0f, (float) cameraWidth, 1.0f), 6.0f, 10.0f, 200, (TextureRegion) this.listTR.get("drizzle.png"));
            this.particleSystem.addParticleInitializer(new VelocityInitializer(0.0f, 0.0f, BitmapDescriptorFactory.HUE_YELLOW, 90.0f));
            this.particleSystem.addParticleInitializer(new AccelerationInitializer(0.0f, 10.0f));
            this.particleSystem.addParticleInitializer(new ScaleInitializer(2.0f));
            this.particleSystem.addParticleModifier(new ExpireModifier(11.5f));
            this.weatherLayer.attachChild(this.particleSystem);
        } else {
            this.weather = -1;
        }
    }

    public void startVoiceRecognitionActivity() {
        if (isOnline()) {
            try {
                this.mEngine.stop();
                Log.i(this.TAG, "Starting voice recognition");
                Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
                intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
                intent.putExtra("android.speech.extra.PROMPT", "Say a command");
                startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
                return;
            } catch (Exception e) {
                Toast.makeText(this, "Error! Cannot start voice command", 0).show();
                return;
            }
        }
        Toast.makeText(this, "Cannot start voice commands, there is no internet connection", 0).show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == -1) {
            Log.i(this.TAG, "Interpret results");
            ArrayList<String> matches = data.getStringArrayListExtra("android.speech.extra.RESULTS");
            if (matches.contains("toggle snow")) {
                if (this.weather == 8) {
                    loadWeather(-1);
                } else {
                    loadWeather(8);
                }
            } else if (matches.contains("toggle rain")) {
                if (this.weather == 2) {
                    loadWeather(-1);
                } else {
                    loadWeather(2);
                }
            } else if (matches.contains("remove poop")) {
                for (Entity e : this.inPlayObjects) {
                    this.ipoToRemove.add((Sprite) e);
                }
            } else if (matches.contains("hyper mode")) {
                this.velocity = 1000.0f;
                toast("Hyper mode activated.");
            } else if (matches.contains("normal mode")) {
                this.velocity = 100.0f;
                toast("Normal mode activated.");
            } else if (matches.contains("stay")) {
                this.stayStill = true;
            } else if (matches.contains("move")) {
                this.stayStill = false;
            } else if (matches.contains("die")) {
                this.tama.setStatus(0);
            }
            super.onActivityResult(requestCode, resultCode, data);
            this.mEngine.start();
        } else if (requestCode == TAMA_BATTLE_CODE && resultCode == -1) {
            int xpGain = data.getIntExtra(MultiplayerConstants.XP_GAIN, 0);
            if (data.getBooleanExtra(MultiplayerConstants.DEATHMATCH, false)) {
                xpGain *= 2;
            }
            Log.i(this.TAG, "[TamaBattle] XP GAIN: " + xpGain);
            if (xpGain != 0) {
                this.tama.setCurrentXP(this.tama.getCurrentXP() + xpGain);
                showNotification("Your tama has gained " + xpGain + " XP!");
            }
            int health = data.getIntExtra(MultiplayerConstants.HEALTH, -1000);
            if (health != -1000) {
                Log.i(this.TAG, "Setting current health to " + health);
                this.tama.setCurrentHealth(health);
            }
            super.onActivityResult(requestCode, resultCode, data);
        } else if (requestCode == 1000 && resultCode == -1) {
            int money = data.getIntExtra("money", -1);
            if (money != -1) {
                this.tama.setMoney(money);
            }
            loadItems();
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private boolean openLayer(Entity layer) {
        try {
            layer.setVisible(true);
            layer.setChildrenVisible(true);
            ((Rectangle) this.selectBoxes.get(layer)).setVisible(true);
            for (Entity e : this.subLayers) {
                if (!e.equals(layer)) {
                    e.setVisible(false);
                    e.setChildrenVisible(false);
                    ((Rectangle) this.selectBoxes.get(e)).setVisible(false);
                }
            }
            for (Entity e2 : this.mainLayers) {
                e2.setVisible(false);
                e2.setChildrenVisible(false);
            }
            hideItemDescription();
            return true;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    private void closeSubLayers() {
        for (Entity e : this.subLayers) {
            e.setVisible(false);
            e.setChildrenVisible(false);
            try {
                ((Rectangle) this.selectBoxes.get(e)).setVisible(false);
            } catch (Exception e2) {
            }
        }
        for (Entity e3 : this.mainLayers) {
            e3.setVisible(true);
            e3.setChildrenVisible(true);
        }
        hideItemDescription();
    }

    private void createSelectBox(Entity entity, int index) {
        Rectangle selectBox = new Rectangle(((float) (iconSpacer * index)) - 37.5f, 0.0f, 75.0f, this.bottomRect.getHeight());
        selectBox.setColor(0.96862745f, 0.9137255f, 0.40392157f);
        selectBox.setVisible(false);
        this.selectBoxes.put(entity, selectBox);
        this.bottomRect.attachChild(selectBox);
    }

    private boolean equipItem(Item item, final boolean notify) {
        this.itemToApply = item;
        runOnUpdateThread(new Runnable() {
            public void run() {
                if (MainGame.this.unequipItem()) {
                    try {
                        MainGame.this.itemToApply.detachSelf();
                        MainGame.this.mScene.unregisterTouchArea(MainGame.this.itemToApply);
                    } catch (Exception e) {
                    }
                    try {
                        MainGame.this.bp.removeItem(MainGame.this.itemToApply);
                    } catch (Exception e2) {
                    }
                    MainGame.this.tama.setEquippedItem(MainGame.this.itemToApply);
                    MainGame.this.itemToApply.setPosition(MainGame.this.tama.getSprite().getBaseWidth() - 25.0f, MainGame.this.tama.getSprite().getBaseHeight() - 25.0f);
                    MainGame.this.tama.getSprite().attachChild(MainGame.this.itemToApply);
                    if (notify) {
                        MainGame.this.showNotification(MainGame.this.itemToApply.getName() + " has been equipped!");
                    }
                    MainGame.this.itemToApply = null;
                    return;
                }
                Log.i(MainGame.this.TAG, "Could not unequip item!");
                MainGame.this.itemToApply.detachSelf();
                MainGame.this.backpackBackground.attachChild(MainGame.this.itemToApply);
                MainGame.this.itemToApply = null;
            }
        });
        return true;
    }

    private boolean unequipItem() {
        try {
            Item previousItem = this.tama.getEquippedItem();
            if (previousItem == null) {
                return true;
            }
            if (this.bp.addItem(previousItem)) {
                previousItem.detachSelf();
                this.backpackBackground.attachChild(previousItem);
                this.mScene.registerTouchArea(previousItem);
                showNotification(previousItem.getName() + " has been unequipped!");
                this.tama.setEquippedItem(null);
                return true;
            }
            showNotification("Backpack is full!");
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void toast(final String pMessage) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(MainGame.this, pMessage, 0).show();
            }
        });
    }

    private void showEffect(int status) {
        final ParticleSystem particleSystem;
        if (status == 2) {
            particleSystem = new ParticleSystem(new CircleOutlineParticleEmitter(this.tama.getSprite().getWidth() / 2.0f, this.tama.getSprite().getHeight() / 2.0f, BitmapDescriptorFactory.HUE_YELLOW), 25.0f, 25.0f, 360, (TextureRegion) this.listTR.get("particle_point.png"));
            particleSystem.addParticleInitializer(new AlphaInitializer(0.0f));
            particleSystem.setBlendFunction(Shape.BLENDFUNCTION_SOURCE_DEFAULT, 1);
            particleSystem.addParticleInitializer(new VelocityInitializer(-2.0f, 2.0f, -20.0f, -10.0f));
            particleSystem.addParticleInitializer(new RotationInitializer(0.0f, 360.0f));
            particleSystem.addParticleModifier(new org.anddev.andengine.entity.particle.modifier.ScaleModifier(1.0f, 2.0f, 0.0f, 5.0f));
            particleSystem.addParticleModifier(new ColorModifier(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 2.0f));
            particleSystem.addParticleModifier(new AlphaModifier(0.0f, 1.0f, 0.0f, 1.0f));
            particleSystem.addParticleModifier(new AlphaModifier(1.0f, 0.0f, 5.0f, 6.0f));
            particleSystem.addParticleModifier(new ExpireModifier(2.0f, 2.0f));
            this.tama.getSprite().attachChild(particleSystem);
            this.mScene.registerUpdateHandler(new TimerHandler(2.0f, new ITimerCallback() {
                public void onTimePassed(TimerHandler pTimerHandler) {
                    particleSystem.setParticlesSpawnEnabled(false);
                    MainGame.this.mScene.unregisterUpdateHandler(pTimerHandler);
                }
            }));
            this.mScene.registerUpdateHandler(new TimerHandler(5.0f, new ITimerCallback() {
                public void onTimePassed(TimerHandler pTimerHandler) {
                    particleSystem.detachSelf();
                    MainGame.this.mScene.unregisterUpdateHandler(pTimerHandler);
                }
            }));
            showNotification("Tamagotchi has leveled up!");
        } else if (status == 0) {
            this.topLayer.setVisible(false);
            this.midLayer.setVisible(false);
            particleSystem = new ParticleSystem(new RectangleParticleEmitter((float) (cameraWidth / 2), (float) pBottomBound, (float) cameraWidth, 1.0f), 1.0f, 10.0f, 100, (TextureRegion) this.listTR.get("particle_point.png"));
            particleSystem.setBlendFunction(Shape.BLENDFUNCTION_SOURCE_DEFAULT, 1);
            particleSystem.addParticleInitializer(new VelocityInitializer(-10.0f, 10.0f, -60.0f, -90.0f));
            particleSystem.addParticleInitializer(new AccelerationInitializer(5.0f, -15.0f));
            particleSystem.setBlendFunction(Shape.BLENDFUNCTION_SOURCE_DEFAULT, 1);
            particleSystem.addParticleModifier(new org.anddev.andengine.entity.particle.modifier.ScaleModifier(1.0f, 2.0f, 0.0f, 5.0f));
            particleSystem.addParticleModifier(new ColorModifier(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 2.0f));
            particleSystem.addParticleModifier(new AlphaModifier(0.0f, 1.0f, 0.0f, 1.0f));
            particleSystem.addParticleModifier(new AlphaModifier(1.0f, 0.0f, 5.0f, 6.0f));
            particleSystem.addParticleModifier(new ExpireModifier(11.5f));
            this.mainLayer.attachChild(particleSystem);
            final ParticleSystem tamaParticleSystem = new ParticleSystem(new CircleOutlineParticleEmitter(this.tama.getSprite().getWidth() / 2.0f, this.tama.getSprite().getHeight() / 2.0f, BitmapDescriptorFactory.HUE_YELLOW), 5.0f, 5.0f, 100, (TextureRegion) this.listTR.get("particle_point.png"));
            tamaParticleSystem.addParticleInitializer(new AlphaInitializer(0.0f));
            tamaParticleSystem.setBlendFunction(Shape.BLENDFUNCTION_SOURCE_DEFAULT, 1);
            tamaParticleSystem.addParticleInitializer(new VelocityInitializer(-2.0f, 2.0f, -20.0f, -10.0f));
            tamaParticleSystem.addParticleInitializer(new RotationInitializer(0.0f, 360.0f));
            tamaParticleSystem.addParticleModifier(new org.anddev.andengine.entity.particle.modifier.ScaleModifier(1.0f, 2.0f, 0.0f, 5.0f));
            tamaParticleSystem.addParticleModifier(new ColorModifier(1.0f, 0.0f, 1.0f, 0.5f, 0.0f, 0.0f, 0.0f, 2.0f));
            tamaParticleSystem.addParticleModifier(new AlphaModifier(0.0f, 1.0f, 0.0f, 1.0f));
            tamaParticleSystem.addParticleModifier(new AlphaModifier(1.0f, 0.0f, 5.0f, 6.0f));
            tamaParticleSystem.addParticleModifier(new ExpireModifier(5.0f));
            this.tama.getSprite().attachChild(tamaParticleSystem);
            this.tama.getSprite().setBlendFunction(Shape.BLENDFUNCTION_SOURCE_DEFAULT, 771);
            this.tama.getSprite().registerEntityModifier(new org.anddev.andengine.entity.modifier.AlphaModifier(10.0f, 1.0f, 0.0f));
            if (this.tama.getEquippedItem() != null) {
                this.tama.getEquippedItem().setVisible(false);
            }
            this.tamaDeadParticles = true;
            this.mScene.registerUpdateHandler(new TimerHandler(10.0f, new ITimerCallback() {
                public void onTimePassed(TimerHandler pTimerHandler) {
                    tamaParticleSystem.setParticlesSpawnEnabled(false);
                    particleSystem.setParticlesSpawnEnabled(false);
                    MainGame.this.eggSprite = new Sprite(MainGame.this.tama.getSprite().getX(), MainGame.this.tama.getSprite().getY(), (TextureRegion) MainGame.this.listTR.get("wing-egg.png"));
                    MainGame.this.eggSprite.setBlendFunction(Shape.BLENDFUNCTION_SOURCE_DEFAULT, 771);
                    MainGame.this.eggSprite.registerEntityModifier(new org.anddev.andengine.entity.modifier.AlphaModifier(5.0f, 0.0f, 1.0f));
                    MainGame.this.mainLayer.attachChild(MainGame.this.eggSprite);
                    MainGame.this.mainLayer.swapChildren(MainGame.this.eggSprite, MainGame.this.tama.getSprite());
                    MainGame.this.mScene.unregisterUpdateHandler(pTimerHandler);
                }
            }));
            this.mScene.registerUpdateHandler(new TimerHandler(20.0f, new ITimerCallback() {

                class C05591 implements Runnable {
                    C05591() {
                    }

                    public void run() {
                        MainGame.this.showDialog(3);
                    }
                }

                public void onTimePassed(TimerHandler pTimerHandler) {
                    tamaParticleSystem.detachSelf();
                    particleSystem.detachSelf();
                    MainGame.this.tama.getSprite().detachSelf();
                    MainGame.this.runOnUiThread(new C05591());
                    MainGame.this.mScene.unregisterUpdateHandler(pTimerHandler);
                }
            }));
        }
    }

    private void showNotification(String text) {
        this.notificationList.add(TextUtil.getNormalizedText(this.mSmallFont, text, this.notificationRect.getWidth()));
        while (this.notificationList.size() > 5) {
            this.notificationList.remove(0);
        }
        StringBuilder n = new StringBuilder();
        for (String s : this.notificationList) {
            n.append(s);
        }
        if (this.vibrateOn) {
            this.mEngine.vibrate(500);
        }
        this.notificationText.setText(n.toString());
        this.notificationRect.setHeight(this.notificationText.getHeight());
        this.notificationRect.setVisible(true);
        closeSubLayers();
    }

    private void loadTamaTimers() {
        this.mScene.registerUpdateHandler(new TimerHandler((float) MathUtils.random(0, 10), true, new ITimerCallback() {
            public void onTimePassed(TimerHandler pTimerHandler) {
                if (!MainGame.this.manualMove) {
                    MainGame.this.moveTama((float) MathUtils.random(30, MainGame.cameraWidth - 30), (float) MathUtils.random(145, MainGame.pBottomBound - 30));
                    pTimerHandler.setTimerSeconds((float) MathUtils.random(0, 10));
                }
            }
        }));
        this.mScene.registerUpdateHandler(new TimerHandler(BitmapDescriptorFactory.HUE_YELLOW, true, new ITimerCallback() {
            public void onTimePassed(TimerHandler pTimerHandler) {
                if (MainGame.this.tama.getStatus() != 0 && MainGame.this.tama.getSprite().hasParent()) {
                    float x = MainGame.this.tama.getSprite().getX();
                    float y = MainGame.this.tama.getSprite().getY();
                    MainGame.this.addPoop(MathUtils.random(x - 10.0f, x + 10.0f), MathUtils.random(y - 10.0f, y + 10.0f));
                }
            }
        }));
        this.mScene.registerUpdateHandler(new TimerHandler(BitmapDescriptorFactory.HUE_MAGENTA, true, new ITimerCallback() {
            public void onTimePassed(TimerHandler pTimerHandler) {
                if (MainGame.this.tama.getStatus() != 0 && MainGame.this.tama.getSprite().hasParent()) {
                    if (MainGame.this.tama.getEquippedItem() != null) {
                        if (MainGame.this.tama.getEquippedItem().getProtection() != MainGame.this.weather && MainGame.this.weather != -1) {
                            MainGame.this.tama.setCurrentSickness(Math.round(((float) MainGame.this.tama.getCurrentSickness()) + (((float) MainGame.this.tama.getMaxSickness()) * 0.05f)));
                        }
                    } else if (MainGame.this.weather != -1) {
                        MainGame.this.tama.setCurrentSickness(Math.round(((float) MainGame.this.tama.getCurrentSickness()) + (((float) MainGame.this.tama.getMaxSickness()) * 0.05f)));
                    }
                }
            }
        }));
        this.mScene.registerUpdateHandler(new TimerHandler((1.0f - (((float) this.tama.getBattleLevel()) / 100.0f)) * BitmapDescriptorFactory.HUE_YELLOW, true, new ITimerCallback() {
            public void onTimePassed(TimerHandler pTimerHandler) {
                if (MainGame.this.tama.getStatus() != 0 && MainGame.this.tama.getSprite().hasParent() && MainGame.this.tama.getCurrentSickness() < 1 && MainGame.this.tama.getCurrentHunger() >= MainGame.this.tama.getMaxHunger()) {
                    Log.i(MainGame.this.TAG, "health regeneration.");
                    if (MainGame.this.tama.getCurrentHealth() < MainGame.this.tama.getMaxHealth()) {
                        Log.i(MainGame.this.TAG, "health regeneration...");
                        float battleLevelRatio = 1.0f - (((float) MainGame.this.tama.getBattleLevel()) / 100.0f);
                        MainGame.this.tama.setCurrentHealth(Math.round(((float) MainGame.this.tama.getCurrentHealth()) + ((0.05f * ((float) ((MainGame.this.tama.getCurrentHunger() / MainGame.this.tama.getMaxHunger()) + 1))) * ((float) MainGame.this.tama.getMaxHealth()))));
                        pTimerHandler.setTimerSeconds(BitmapDescriptorFactory.HUE_YELLOW * battleLevelRatio);
                    }
                }
            }
        }));
        this.mScene.registerUpdateHandler(new TimerHandler(BitmapDescriptorFactory.HUE_CYAN, true, new ITimerCallback() {
            public void onTimePassed(TimerHandler pTimerHandler) {
                if (MainGame.this.tama.getStatus() != 0 && MainGame.this.tama.getSprite().hasParent()) {
                    if (MainGame.this.tama.getCurrentHunger() > 0 || MainGame.this.tama.getCurrentHealth() <= 0) {
                        Log.i(MainGame.this.TAG, "going hungery...");
                        MainGame.this.tama.setCurrentHunger(Math.round((float) (MainGame.this.tama.getCurrentHunger() - 10)));
                        return;
                    }
                    Log.i(MainGame.this.TAG, "losing health...");
                    MainGame.this.tama.setCurrentHealth(Math.round((float) (MainGame.this.tama.getCurrentHealth() - 10)));
                }
            }
        }));
        Log.i(this.TAG, "Tama timers loaded.");
    }

    private void showSplashScreen() {
        this.mSplashScene = new Scene();
        BitmapTextureAtlas mSplashTextureAtlas = new BitmapTextureAtlas(512, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("");
        Sprite splashSprite = new Sprite(0.0f, 0.0f, BitmapTextureAtlasTextureRegionFactory.createFromAsset(mSplashTextureAtlas, this, "splash.png", 0, 0));
        this.mEngine.getTextureManager().loadTexture(mSplashTextureAtlas);
        this.mSplashScene.attachChild(splashSprite);
        this.mScene.setChildScene(this.mSplashScene);
    }

    public void say(String text2say) {
        if (this.soundOn) {
            this.talker.speak(text2say, 0, null);
        }
    }

    public void onInit(int status) {
        this.talker.setPitch(1000.0f);
        String[] loadedResponses = FileReaderUtil.readFile(this, "files/tamaResponses.txt");
        if (loadedResponses != null) {
            this.tamaResponses = loadedResponses;
        }
        say("Tamagotchi!");
    }

    private void runDemo() {
        loadWeather(-1);
    }

    public void dayornight(double lat, double lon) {
        GregorianCalendar dateTime = new GregorianCalendar();
        AzimuthZenithAngle solarposition = Grena3.calculateSolarPosition(dateTime, lat, lon, 67.0d);
        Log.i(this.TAG, "Grena3: " + solarposition.getZenithAngle());
        Log.i(this.TAG, "Grena3 lat: " + lat + " lon: " + lon);
        Log.i(this.TAG, "SPA (more acc but slow): " + SPA.calculateSolarPosition(dateTime, lat, lon, 190.0d, 67.0d, 1010.0d, 11.0d).getZenithAngle());
        Log.i(this.TAG, "SPA lat: " + lat + " lon: " + lon);
        this.ZENITH = solarposition.getZenithAngle();
        if (this.civilOverlayRect != null) {
            this.civilOverlayRect.detachSelf();
        }
        if (this.nauticalOverlayRect != null) {
            this.nauticalOverlayRect.detachSelf();
        }
        if (this.astroOverlayRect != null) {
            this.astroOverlayRect.detachSelf();
        }
        if (this.nightOverlayRect != null) {
            this.nightOverlayRect.detachSelf();
        }
        if (this.ZENITH < 90.8d) {
            Log.i(this.TAG, "day");
            if (this.civilOverlayRect != null) {
                this.civilOverlayRect.detachSelf();
            }
            if (this.nauticalOverlayRect != null) {
                this.nauticalOverlayRect.detachSelf();
            }
            if (this.astroOverlayRect != null) {
                this.astroOverlayRect.detachSelf();
            }
            if (this.nightOverlayRect != null) {
                this.nightOverlayRect.detachSelf();
            }
        }
        if (this.ZENITH >= 90.8d && this.ZENITH < 96.0d) {
            Log.i(this.TAG, "civil");
            if (this.civilOverlayRect == null) {
                this.civilOverlayRect = new Rectangle(0.0f, 0.0f, (float) cameraWidth, (float) cameraHeight);
                this.civilOverlayRect.setColor(0.0f, 0.0f, 0.0f, 0.35f);
            }
            if (!this.civilOverlayRect.hasParent()) {
                this.bottomLayer.attachChild(this.civilOverlayRect);
            }
        }
        if (this.ZENITH >= 96.0d && this.ZENITH < 102.0d) {
            Log.i(this.TAG, "nautical");
            if (this.nauticalOverlayRect == null) {
                this.nauticalOverlayRect = new Rectangle(0.0f, 0.0f, (float) cameraWidth, (float) cameraHeight);
                this.nauticalOverlayRect.setColor(0.0f, 0.0f, 0.0f, 0.5f);
            }
            if (!this.nauticalOverlayRect.hasParent()) {
                this.bottomLayer.attachChild(this.nauticalOverlayRect);
            }
        }
        if (this.ZENITH >= 102.0d && this.ZENITH < 108.0d) {
            Log.i(this.TAG, "astronomical");
            if (this.astroOverlayRect == null) {
                this.astroOverlayRect = new Rectangle(0.0f, 0.0f, (float) cameraWidth, (float) cameraHeight);
                this.astroOverlayRect.setColor(0.0f, 0.0f, 0.0f, 0.75f);
            }
            if (!this.astroOverlayRect.hasParent()) {
                this.bottomLayer.attachChild(this.astroOverlayRect);
            }
        }
        if (this.ZENITH >= 108.0d) {
            Log.i(this.TAG, "night");
            if (this.nightOverlayRect == null) {
                this.nightOverlayRect = new Rectangle(0.0f, 0.0f, (float) cameraWidth, (float) cameraHeight);
                this.nightOverlayRect.setColor(0.0f, 0.0f, 0.0f, 0.8f);
            }
            if (!this.nightOverlayRect.hasParent()) {
                this.bottomLayer.attachChild(this.nightOverlayRect);
            }
        }
    }

    private void initializeGoogleAPI() {
        Log.i(this.TAG, "initializeGoogleAPI()");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == 0) {
            GoogleApiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
            createLocationRequest();
        }
    }

    private void createLocationRequest() {
        this.mLocationRequest = new LocationRequest();
        this.mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        this.mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        this.mLocationRequest.setPriority(100);
    }

    private void startUpdates() {
        Log.i(this.TAG, "startUpdates()");
        LocationServices.FusedLocationApi.requestLocationUpdates(GoogleApiClient, this.mLocationRequest, (LocationListener) this);
    }

    private void stopUpdates() {
        Log.i(this.TAG, "stopUpdates()");
        LocationServices.FusedLocationApi.removeLocationUpdates(GoogleApiClient, (LocationListener) this);
    }

    public void onConnected(Bundle connectionHint) {
        Log.i(this.TAG, "Connected to GoogleApiClient");
        if (this.mCurrentLocation == null) {
            Log.i(this.TAG, "mCurrentLocation == null");
            this.mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(GoogleApiClient);
        } else {
            Log.i(this.TAG, "mCurrentLocation not null");
            this.mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(GoogleApiClient);
            this.lat = this.mCurrentLocation.getLatitude();
            this.lon = this.mCurrentLocation.getLongitude();
            Log.i(this.TAG, "onConnected lat: " + this.lat + " lon: " + this.lon);
            getweather();
        }
        startUpdates();
    }

    public void onLocationChanged(Location location) {
        this.mCurrentLocation = location;
        this.lat = this.mCurrentLocation.getLatitude();
        this.lon = this.mCurrentLocation.getLongitude();
        Log.i(this.TAG, "onLocationChanged lat: " + this.lat + " lon: " + this.lon);
        getweather();
    }

    public void onConnectionSuspended(int cause) {
        Log.i(this.TAG, "Connection suspended");
        GoogleApiClient.connect();
    }

    public void onConnectionFailed(ConnectionResult result) {
        Log.i(this.TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }

    public void getweather() {
        Log.i(this.TAG, "My current location is: Latitude = " + this.lat + ", Longitude = " + this.lon);
        dayornight(this.lat, this.lon);
        if (this.weatherText != null) {
            Log.i(this.TAG, "weathertext is not null... should remove it.");
            runOnUpdateThread(new Runnable() {
                public void run() {
                    MainGame.this.weatherText.detachSelf();
                    MainGame.this.weatherText = null;
                }
            });
        }
        this.cc = WeatherRetriever.getCurrentConditions(this.lat, this.lon);
        if (this.cc != null) {
            Log.i(this.TAG, this.cc.toString());
            this.weatherText = new ChangeableText(15.0f, (float) (pBottomBound - 40), this.mFont, this.cc.getCondition() + ", " + this.cc.getTempF() + "°F");
            this.mainLayer.attachChild(this.weatherText);
            int weatherType = -1;
            String condition = this.cc.getCondition().toLowerCase();
            if (condition.contains("rain")) {
                weatherType = 2;
            } else if (condition.contains("drizzle")) {
                weatherType = 0;
            } else if (condition.contains("snow")) {
                weatherType = 8;
            }
            loadWeather(weatherType);
        }
    }
}
