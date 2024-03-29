package com.tamaproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.microedition.khronos.opengles.GL10;

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
import org.anddev.andengine.entity.modifier.SequenceEntityModifier;
import org.anddev.andengine.entity.particle.ParticleSystem;
import org.anddev.andengine.entity.particle.emitter.CircleOutlineParticleEmitter;
import org.anddev.andengine.entity.particle.emitter.RectangleParticleEmitter;
import org.anddev.andengine.entity.particle.initializer.AccelerationInitializer;
import org.anddev.andengine.entity.particle.initializer.AlphaInitializer;
import org.anddev.andengine.entity.particle.initializer.RotationInitializer;
import org.anddev.andengine.entity.particle.initializer.VelocityInitializer;
import org.anddev.andengine.entity.particle.modifier.AlphaModifier;
import org.anddev.andengine.entity.particle.modifier.ColorModifier;
import org.anddev.andengine.entity.particle.modifier.ExpireModifier;
import org.anddev.andengine.entity.particle.modifier.ScaleModifier;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnAreaTouchListener;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.Scene.ITouchArea;
import org.anddev.andengine.entity.scene.background.RepeatingSpriteBackground;
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

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;


import com.tamaproject.database.DatabaseHelper;
import com.tamaproject.entity.Backpack;
import com.tamaproject.entity.Item;
import com.tamaproject.entity.Protection;
import com.tamaproject.entity.Tamagotchi;
import com.tamaproject.itemstore.ItemStore;
import com.tamaproject.minigames.MiniGameListActivity;
import com.tamaproject.multiplayer.TamaBattle;
import com.tamaproject.util.FileReaderUtil;
import com.tamaproject.util.MultiplayerConstants;
import com.tamaproject.util.TextUtil;
import com.tamaproject.util.TextureUtil;
import com.tamaproject.util.Weather;
import com.tamaproject.weather.CurrentConditions;
import com.tamaproject.weather.WeatherRetriever;

import android.location.Location;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import net.e175.klaus.solarpositioning.AzimuthZenithAngle;
import net.e175.klaus.solarpositioning.Grena3;
import net.e175.klaus.solarpositioning.PSA;
import net.e175.klaus.solarpositioning.SPA;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GestureDetectorCompat;

import static java.lang.Math.abs;

/**
 * Main game that controls Tamagotchi behavior, item interaction, etc.
 * 
 * @author Jonathan
 * 
 */
////public class MainGame extends BaseAndEngineGame implements IOnSceneTouchListener, IOnAreaTouchListener, OnInitListener
public class MainGame extends BaseAndEngineGame implements IOnSceneTouchListener, IOnAreaTouchListener, OnInitListener, ConnectionCallbacks, OnConnectionFailedListener, LocationListener, GestureDetector.OnGestureListener
{


	public static final int PERMISSIONS = 1;
    // ===========================================================
    // Constants
    // ===========================================================
	String TAG = "tama MainGame";
    private static int cameraWidth = 480;
    private static int cameraHeight = 800;
    private static final int pTopBound = 115;
    private static int pBottomBound = cameraHeight - 70; // top and bottom bounds of play area

    private static final int CONFIRM_APPLYITEM = 0;
    private static final int CONFIRM_QUITGAME = 1;
    private static final int CONFIRM_REMOVEITEM = 2, CONFIRM_RESTART = 3;
    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;
    private static final int TAMA_BATTLE_CODE = 1337, TAMA_ITEM_STORE_CODE = 1000;
    private static final boolean FULLSCREEN = true;
    private static final int MAX_NOTIFICATIONS = 5; // max notifications to display

    // Length of health bars, etc.
    private static final int barLength = 150;
    private static final int barHeight = 25;
    private static final int leftSpacing = 50;
    private static final int vSpacing = 15;
    private static final int iconSpacing = 30;

    private static final int numIcons = 6; // number of icons in the bottom bar
    private static final int iconSpacer = cameraWidth / (numIcons + 1);

    // ===========================================================
    // Fields
    // ===========================================================

    private Camera mCamera;
    private RepeatingSpriteBackground mGrassBackground;
    private Scene mScene;
    private Backpack bp;

    // Layers
    private Entity mainLayer = new Entity();
    private Entity backpackLayer = new Entity();
    private Entity weatherLayer = new Entity();
    private Entity statsLayer = new Entity();
    private Entity topLayer = new Entity();
    private Entity midLayer = new Entity();
    private Entity bottomLayer = new Entity();
    private List<Entity> subLayers = new ArrayList<Entity>(); // layers that are opened by icons in the bottom bar
    private List<Entity> mainLayers = new ArrayList<Entity>(); // layers that belong to the main gameplay
    private HashMap<Entity, Rectangle> selectBoxes = new HashMap<Entity, Rectangle>(); // mapping of layers to icon select boxes

    private Item takeOut; // item to take out of backpack
    private Item putBack; // item to put back into packpack
    private Item itemToApply; // item to apply to Tama
    private Item itemToRemove;

    private List<BaseSprite> inPlayObjects = new ArrayList<BaseSprite>(); // list of objects that are in the environment
    private Tamagotchi tama; // Tamagotchi
    private Sprite eggSprite;
	private Sprite emptytrashcan;
	private Sprite fulltrashcan;
    private ParticleSystem particleSystem;
    private int weather = Weather.NONE;
    private BitmapTextureAtlas mFontTexture, mSmallFontTexture;
    private BitmapTextureAtlas mTamaBitmapTextureAtlas;
    private TiledTextureRegion mTamaTextureRegion;
    private Font mFont, mSmallFont;

    // Status bars that need to be updated
    private Rectangle currHealthBar, currSicknessBar, currHungerBar;

    // List of in play objects to be removed at next update thread
    private List<BaseSprite> ipoToRemove = new ArrayList<BaseSprite>();

    // Selection boxes for bottom bar

    // TextureRegions
    public Hashtable<String, TextureRegion> listTR;


	static GoogleApiClient GoogleApiClient;
	public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 150000;
	public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 300000;
	public Location mCurrentLocation;
	public LocationRequest mLocationRequest;




	public double lat = 0.0;
	public double lon = 0.0;
	private CurrentConditions cc;
	private ChangeableText weatherText;

    private Rectangle topRect, bottomRect; // top and bottom bars

    private ChangeableText stats;

    private long startPlayTime;
    private long totalPlayTime = 0;

    private Rectangle itemDescriptionRect;
    private ChangeableText itemDesctiptionText;
    private Rectangle notificationRect;
    private ChangeableText notificationText;

    private boolean tamaDeadParticles = false;

    private Rectangle unequipItemButton;
	private Rectangle changebdayButton;
	private Rectangle saveTamaButton;
    private ChangeableText backpackLabel;
    private Rectangle backpackBackground;

    private List<String> notificationList = new LinkedList<String>();

	public double ZENITH = 0.0;



	private Rectangle civilOverlayRect;
	private Rectangle nauticalOverlayRect;
	private Rectangle astroOverlayRect;
	private Rectangle nightOverlayRect;

	private Sprite thoughtBubble;

    private boolean firstRun = true;

    private DatabaseHelper dbHelper;

    private float velocity = 100;
    private boolean manualMove = false;
    private boolean stayStill = false;
    private TextToSpeech talker;
    private String[] tamaResponses = { "Hello" };

    private boolean demoMode = true;


	private GestureDetectorCompat mDetector;

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public Engine onLoadEngine()
    {


	Display display = this.getWindowManager().getDefaultDisplay();
	int width = display.getWidth();
	int height = display.getHeight();
	float ratio = (float) width / height;
	this.cameraHeight = Math.round(MainGame.cameraWidth / ratio);
	this.pBottomBound = this.cameraHeight - 70;
	System.out.println("Height: " + this.cameraHeight + ", Width: " + this.cameraWidth);

	this.mCamera = new Camera(0, 0, cameraWidth, cameraHeight);
	this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
	return new Engine(new EngineOptions(FULLSCREEN, ScreenOrientation.PORTRAIT, new RatioResolutionPolicy(cameraWidth, cameraHeight), this.mCamera));
    }

	private  boolean checkAndRequestPermissions() {
		int internetPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
		int cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
		int locationPermission1 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
		int locationPermission2 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);


		List<String> listPermissionsNeeded = new ArrayList<>();

		if (internetPermission != PackageManager.PERMISSION_GRANTED) {
			listPermissionsNeeded.add(Manifest.permission.INTERNET);
		}

		if (locationPermission1 != PackageManager.PERMISSION_GRANTED) {
			listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION);
		}

		if (locationPermission2 != PackageManager.PERMISSION_GRANTED) {
			listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
		}

		if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
			listPermissionsNeeded.add(Manifest.permission.CAMERA);
		}

		if (!listPermissionsNeeded.isEmpty()) {
			ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), PERMISSIONS);
			return false;
		}

		return true;
	}


    //load up gps for weather/nightorday
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(this.TAG, "onCreate()");

		if(checkAndRequestPermissions()) {
			// carry on the normal flow, as the case of  permissions  granted.
		}

		initializeGoogleAPI();
		mDetector = new GestureDetectorCompat(this,this);
	}

	protected void onStart() {
		super.onStart();
		Log.i(this.TAG, "onStart()");
		GoogleApiClient.connect();
	}


    @Override
    public void onLoadResources()
    {
	// Load grass background
	this.mGrassBackground = new RepeatingSpriteBackground(cameraWidth, cameraHeight, this.mEngine.getTextureManager(), new AssetBitmapTextureAtlasSource(this, "gfx/background_grass.png"));

	// Load all the textures in the gfx folder

	this.listTR = TextureUtil.loadTextures(this, this.mEngine, new String[] { new String("gfx/") });

	// Load fonts
	this.mFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	this.mSmallFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	this.mFont = FontFactory.createFromAsset(mFontTexture, this, "ITCKRIST.TTF", 24, true, Color.WHITE);
	this.mSmallFont = FontFactory.createFromAsset(mSmallFontTexture, this, "ITCKRIST.TTF", 18, true, Color.WHITE);
	this.mEngine.getTextureManager().loadTexture(this.mFontTexture);
	this.mEngine.getTextureManager().loadTexture(this.mSmallFontTexture);
	this.mEngine.getFontManager().loadFont(this.mFont);
	this.mEngine.getFontManager().loadFont(this.mSmallFont);

	// Load animated textures
	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("animated_gfx/");
	this.mTamaBitmapTextureAtlas = new BitmapTextureAtlas(128, 1024, TextureOptions.BILINEAR);
	this.mTamaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mTamaBitmapTextureAtlas, this, "snorlax.png", 0, 0, 1, 8);
	this.mEngine.getTextureManager().loadTexture(this.mTamaBitmapTextureAtlas);
    }

    @Override
    public Scene onLoadScene()
    {
	try
	{
	    dbHelper = new DatabaseHelper(this);
	} catch (IOException e)
	{
	    e.printStackTrace();
	}

	try
	{
	    DatabaseHelper.createDatabaseIfNotExists(this);
	    Log.i(TAG, "createDatabase()");
	} catch (IOException e)
	{
	    e.printStackTrace();
	}

	try
	{
	    dbHelper.openDatabase();
		Log.i(TAG, "openDatabase()");
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	
	this.mEngine.registerUpdateHandler(new FPSLogger());

	// Enable vibration
	this.enableVibrator();

	this.talker = new TextToSpeech(this, this);

	this.mScene = new Scene();
	this.mScene.setBackground(this.mGrassBackground);

	final int centerX = (cameraWidth - this.listTR.get("tama.png").getWidth()) / 2;
	final int centerY = (cameraHeight - this.listTR.get("tama.png").getHeight()) / 2;

	this.loadTama(centerX, centerY, false);

	this.thoughtBubble = new Sprite(tama.getSprite().getWidth(), -tama.getSprite().getHeight(), listTR.get("thought_bubble.png"));
	this.tama.getSprite().attachChild(this.thoughtBubble);
	this.thoughtBubble.setVisible(false);

	this.mainLayers.add(mainLayer);
	this.mainLayers.add(weatherLayer);
	this.subLayers.add(backpackLayer);
	this.subLayers.add(statsLayer);

	// Attach layers in the correct order
	this.mScene.attachChild(bottomLayer);
	this.mScene.attachChild(mainLayer);
	this.mScene.attachChild(weatherLayer);
	this.mScene.attachChild(midLayer);
	this.mScene.attachChild(backpackLayer);
	this.mScene.attachChild(statsLayer);
	this.mScene.attachChild(topLayer);

	this.mainLayer.setVisible(true);
	this.backpackLayer.setVisible(false);
	this.statsLayer.setVisible(false);

	// Load interface
	this.loadInterface();

	this.loadItems();

	this.mScene.registerTouchArea(tama.getSprite());

	// Add trashcan to main layer
	//this.trashCan = new Sprite(cameraWidth - listTR.get("mac-trashcan-empty.png").getWidth(), pBottomBound - listTR.get("mac-trashcan-empty.png").getHeight(), listTR.get("mac-trashcan-empty.png"));
	//this.trashCan.setScale(3);
	//this.mainLayer.attachChild(trashCan);

	this.emptytrashcan = new Sprite((float) ((cameraWidth - ((TextureRegion) this.listTR.get("mac-trashcan-empty.png")).getWidth()) - 15), (float) ((pBottomBound - ((TextureRegion) this.listTR.get("mac-trashcan-empty.png")).getHeight()) - 20), (TextureRegion) this.listTR.get("mac-trashcan-empty.png"));
	this.emptytrashcan.setScale(2.0f);
	this.mainLayer.attachChild(this.emptytrashcan);
	this.fulltrashcan = new Sprite((float) ((cameraWidth - ((TextureRegion) this.listTR.get("mac-trashcan-full.png")).getWidth()) - 15), (float) ((pBottomBound - ((TextureRegion) this.listTR.get("mac-trashcan-full.png")).getHeight()) - 20), (TextureRegion) this.listTR.get("mac-trashcan-full.png"));
	this.fulltrashcan.setScale(2.0f);

	this.mScene.setTouchAreaBindingEnabled(true);
	this.mScene.setOnSceneTouchListener(this);
	this.mScene.setOnAreaTouchListener(this);
	this.mScene.registerUpdateHandler(new IUpdateHandler()
	{
	    @Override
	    public void reset()
	    {
	    }

	    @Override
	    public void onUpdate(final float pSecondsElapsed)
	    {
		try
		{
		    /**
		     * Remove queued in play objects
		     */

		    if (ipoToRemove.size() > 0)
		    {
				Log.i(TAG, "IPOs to remove: " + ipoToRemove.size());
			for (BaseSprite s : ipoToRemove)
			{
			    s.detachSelf();
			    mScene.unregisterTouchArea(s);
			    inPlayObjects.remove(s);
			}
			ipoToRemove.clear();
				Log.i(TAG, "IPOs to remove: " + ipoToRemove.size());
		    }

		    /**
		     * Update the stats page with current stats when stats page is opened
		     */
		    if (statsLayer.isVisible())
			stats.setText(TextUtil.getNormalizedText(mSmallFont, tama.getStats(), stats.getWidth()));
		    /**
		     * Update the status bars when main layer is visible
		     */
		    else if (mainLayer.isVisible())
			updateStatusBars();
		    /**
		     * Update the backpack label when backpack is visible
		     */
		    else if (backpackLayer.isVisible())
			backpackLabel.setText("Backpack (" + bp.numItems() + "/" + bp.maxSize() + ")");

		    /**
		     * Check if tamagotchi is dead
		     */
		    if (tama.checkStats() == Tamagotchi.DEAD)
		    {
			if (!tamaDeadParticles)
			{
			    showEffect(Tamagotchi.DEAD);
			}
				Log.i(TAG, "Tamagotchi is dead!");
		    }

		} catch (Exception e)
		{
			Log.i(TAG, "onUpdate EXCEPTION:" + e);
		} catch (Error e)
		{
			Log.i(TAG, "onUpdate ERROR:" + e);
		}
	    }
	});

	/**
	 * Timer to run GPS to check weather every 30 mins
	 */

/*
	this.mScene.registerUpdateHandler(new TimerHandler(0, true, new ITimerCallback()
	{
	    @Override
	    public void onTimePassed(final TimerHandler pTimerHandler)
	    {
		runOnUiThread(new Runnable()
		{
		    @Override
		    public void run()
		    {
			startGPS();
		    }
		});
		pTimerHandler.setTimerSeconds(90);
	    }
	}));
*/

/*
* this do check both sunrise/set and weather
* */

		this.mScene.registerUpdateHandler(new TimerHandler(0, true, new ITimerCallback()
		{
			@Override
			public void onTimePassed(final TimerHandler pTimerHandler) {

				runOnUiThread(new Runnable() {
				@Override
				public void run() {
				startGPS();

/*
				GregorianCalendar dateTime = new GregorianCalendar();


				AzimuthZenithAngle solarposition = Grena3.calculateSolarPosition(dateTime, lat, lon, 67);
				Log.i(TAG, "Grena3: " + solarposition.getZenithAngle());
				Log.i(TAG, "Grena3 lat: " + lat + " lon: " + lon);

				AzimuthZenithAngle solarposition2 = SPA.calculateSolarPosition(dateTime, lat, lon,
						190, // elevation
						67, // delta T
						1010, // avg. air pressure
						11); // avg. air temperature
				Log.i(TAG, "SPA (more acc but slow): " + solarposition2.getZenithAngle());
				Log.i(TAG, "SPA lat: " + lat + " lon: " + lon);

				ZENITH = solarposition.getZenithAngle();


				if (ZENITH < 90.8) {
					Log.i(TAG, "day");
					if (civilOverlayRect != null)
						civilOverlayRect.detachSelf();
					if (nauticalOverlayRect != null)
					    nauticalOverlayRect.detachSelf();
					if (astroOverlayRect != null)
						astroOverlayRect.detachSelf();
					if (nightOverlayRect != null)
						nightOverlayRect.detachSelf();
				}

				if (ZENITH >= 90.8 && ZENITH < 96) {
					Log.i(TAG, "civil");
					if (civilOverlayRect == null) {
						civilOverlayRect = new Rectangle(0, 0, cameraWidth, cameraHeight);
						civilOverlayRect.setColor(0, 0, 0, 0.35f);
					}
					if (!civilOverlayRect.hasParent())
						bottomLayer.attachChild(civilOverlayRect);
				}

				if (ZENITH >= 96 && ZENITH < 102) {
					Log.i(TAG, "nautical");
					if (nauticalOverlayRect == null) {
						nauticalOverlayRect = new Rectangle(0, 0, cameraWidth, cameraHeight);
						nauticalOverlayRect.setColor(0, 0, 0, 0.50f);
					}
					if (!nauticalOverlayRect.hasParent())
						bottomLayer.attachChild(nauticalOverlayRect);
				}

				if (ZENITH >= 102 && ZENITH < 108) {
					Log.i(TAG, "astronomical");
					if (astroOverlayRect == null) {
						astroOverlayRect = new Rectangle(0, 0, cameraWidth, cameraHeight);
						astroOverlayRect.setColor(0, 0, 0, 0.65f);
					}
					if (!astroOverlayRect.hasParent())
						bottomLayer.attachChild(astroOverlayRect);
				}

				if (ZENITH >= 108) {
					Log.i(TAG, "night");
					if (nightOverlayRect == null) {
						nightOverlayRect = new Rectangle(0, 0, cameraWidth, cameraHeight);
						nightOverlayRect.setColor(0, 0, 0, 0.75f);
					}
					if (!nightOverlayRect.hasParent())
						bottomLayer.attachChild(nightOverlayRect);
				}
*/



				/*
				////this is dumb way to do day and night///
				if (hour < 18 && hour > 6)
				{
					if (nightOverlayRect != null)
						nightOverlayRect.detachSelf();
				}
				else
				{
					if (nightOverlayRect == null)
					{
						nightOverlayRect = new Rectangle(0, 0, cameraWidth, cameraHeight);
						nightOverlayRect.setColor(0, 0, 0, 0.35f);
					}
					if (!nightOverlayRect.hasParent())
						bottomLayer.attachChild(nightOverlayRect);
				}

				*/
				///pTimerHandler.setTimerSeconds(60 * 60);


				}
				});

				pTimerHandler.setTimerSeconds(90);
			}
		}));




	/**
	 * Timer to check if it is night time every hour, and if it is, create a dark overlay
	 */


/*
	this.mScene.registerUpdateHandler(new TimerHandler(0, true, new ITimerCallback()
	{
	    @Override
	    public void onTimePassed(final TimerHandler pTimerHandler)
	    {
		GregorianCalendar todaysDate = new GregorianCalendar();
		int hour = todaysDate.get(Calendar.HOUR_OF_DAY);
		////this is dumb way to do day and night///
		if (hour < 18 && hour > 6)
		{
			if (nightOverlayRect != null)
				nightOverlayRect.detachSelf();
		}
		else
		{
			if (nightOverlayRect == null)
			{
				nightOverlayRect = new Rectangle(0, 0, cameraWidth, cameraHeight);
				nightOverlayRect.setColor(0, 0, 0, 0.35f);
			}
			if (!nightOverlayRect.hasParent())
				bottomLayer.attachChild(nightOverlayRect);
		}
		pTimerHandler.setTimerSeconds(60 * 60);
	}
}));


		*/

	this.loadTamaTimers();

	this.mScene.setOnAreaTouchTraversalFrontToBack();

	if (demoMode)
	    runDemo();

	return this.mScene;
    }

    @Override
    public void onLoadComplete()
    {
	loadOptions();
    }

    /**
     * Specify dialogs
     */
    @Override
    protected Dialog onCreateDialog(int id)
    {
	AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
	try
	{
	    switch (id)
	    {
	    case MainGame.CONFIRM_APPLYITEM:
		builder2.setTitle("Give Item");
		builder2.setIcon(android.R.drawable.btn_star);
		builder2.setMessage("Are you sure you want to give " + itemToApply.getName() + " to your Tamagotchi?");
		builder2.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener()
		{
		    @Override
		    public void onClick(DialogInterface dialog, int which)
		    {
			runOnUpdateThread(new Runnable()
			{
			    @Override
			    public void run()
			    {
					Log.i(TAG, "Applying item");
				applyItem(itemToApply);

					//mass clean up of poop with a showel hahahah//
					if (itemToApply.getName().contains("Shovel")) {
						Log.i(TAG, "cleaning up poop...");
						for (Entity e : inPlayObjects) {
							ipoToRemove.add((Sprite) e);
						}
					}


				showNotification(itemToApply.getName() + " has been given to your Tamagotchi!");
				itemToApply = null;
			    }
			}); // End runOnUpdateThread
			return;
		    }
		});

		builder2.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener()
		{
		    @Override
		    public void onClick(DialogInterface dialog, int which)
		    {
			runOnUpdateThread(new Runnable()
			{
			    @Override
			    public void run()
			    {
					Log.i(TAG, "Putting back item");
				itemToApply.detachSelf();
				backpackBackground.attachChild(itemToApply);
				itemToApply = null;
			    }
			}); // End runOnUpdateThread
			return;
		    }
		});

		return builder2.create();

	    case MainGame.CONFIRM_QUITGAME:
		builder2.setTitle("Quit Game");
		builder2.setIcon(android.R.drawable.btn_star);
		builder2.setMessage("Are you sure you want to quit the game?");
		builder2.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener()
		{
		    @Override
		    public void onClick(DialogInterface dialog, int which)
		    {
			finish();
			return;
		    }
		});

		builder2.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener()
		{
		    @Override
		    public void onClick(DialogInterface dialog, int which)
		    {
			return;
		    }
		});

		return builder2.create();

	    case MainGame.CONFIRM_RESTART:
		builder2.setTitle("Rehatch?");
		builder2.setIcon(android.R.drawable.btn_star);
		builder2.setMessage("Would you like to rehatch your Tamagotchi?");
		builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener()
		{
		    @Override
		    public void onClick(DialogInterface dialog, int which)
		    {
			if (eggSprite != null)
			{
			    loadTama(eggSprite.getX(), eggSprite.getY(), true);
			}
			else
			    loadTama(0, 0, true);
			tamaDeadParticles = false;
			showNotification("Tamagotchi has been reborn!");
		    }
		});

		builder2.setNegativeButton("No", new DialogInterface.OnClickListener()
		{
		    @Override
		    public void onClick(DialogInterface dialog, int which)
		    {
			finish();
		    }
		});

		return builder2.create();

	    case MainGame.CONFIRM_REMOVEITEM:
		builder2.setTitle("Throw Away Item");
		builder2.setIcon(android.R.drawable.btn_star);
		builder2.setMessage("Are you sure you want to throw away " + itemToRemove.getName() + "?");
		builder2.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener()
		{
		    @Override
		    public void onClick(DialogInterface dialog, int which)
		    {
			runOnUpdateThread(new Runnable()
			{
			    @Override
			    public void run()
			    {
				if (itemToRemove != null)
				{
				    itemToRemove.detachSelf();
				    bp.removeItem(itemToRemove);
				    showNotification(itemToRemove.getName() + " has been removed.");
				    itemToRemove = null;
				    bp.resetPositions(cameraWidth, cameraHeight);
				}
			    }
			});
			return;
		    }
		});

		builder2.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener()
		{
		    @Override
		    public void onClick(DialogInterface dialog, int which)
		    {
			runOnUpdateThread(new Runnable()
			{
			    @Override
			    public void run()
			    {
					Log.i(TAG, "Putting back item");
				itemToRemove.detachSelf();
				backpackBackground.attachChild(itemToRemove);
				itemToRemove = null;
			    }
			}); // End runOnUpdateThread
			return;
		    }
		});

		return builder2.create();

	    }
	} catch (Exception e)
	{
	    e.printStackTrace();
	}

	return null;
    }

    /**
     * Used to update the alert dialogs with the correct item names
     */
    @Override
    protected void onPrepareDialog(final int id, final Dialog dialog)
    {
	switch (id)
	{
	case MainGame.CONFIRM_APPLYITEM:
	    ((AlertDialog) dialog).setMessage("Are you sure you want to give " + itemToApply.getName() + " to your Tamagotchi?");
	    return;
	case MainGame.CONFIRM_REMOVEITEM:
	    ((AlertDialog) dialog).setMessage("Are you sure you want to throw away " + itemToRemove.getName() + "?");
	    return;
	default:
	    return;
	}
    }

    /**
     * Captures the back key and menu key presses
     */
    @Override
    public boolean onKeyDown(final int pKeyCode, final KeyEvent pEvent)
    {
	// if back key was pressed
	if (pKeyCode == KeyEvent.KEYCODE_BACK && pEvent.getAction() == KeyEvent.ACTION_DOWN)
	{
	    showDialog(MainGame.CONFIRM_QUITGAME);
	    return true;
	}
	return super.onKeyDown(pKeyCode, pEvent);
    }


    @Override
    public void onPause()
    {
	super.onPause();
	this.mEngine.stop();
	this.stopGPS();
	totalPlayTime += System.currentTimeMillis() - startPlayTime;

	long newplaytime = tama.addToPlaytime(totalPlayTime);

	Log.i(TAG, "First Time Run? "+firstRun);

	if (dbHelper != null)
	{

		long result;
		if (firstRun == true) {
			Log.i(TAG, "First Time Run - inserting");
			result = dbHelper.insertTama(tama);
		} else {
			Log.i(TAG, "saveTama");
			result = dbHelper.saveTama(tama);
		}
	    if (result < 0) {
			Log.i(TAG, "Save Tama failed! " + result);
		} else {
			Log.i(TAG, "Save Tama success! " + result);
		}



	    long resultBackpackSave = dbHelper.insertBackpack(bp.getItems());
	    if (resultBackpackSave < 0) {
			Log.i(TAG, "Save backpack failed! " + resultBackpackSave);
		} else {
			Log.i(TAG, "Save backpack success! " + resultBackpackSave);
		}

		//update total playtime
		long playtimeresult = dbHelper.saveplaytime(newplaytime, 1);
		if (playtimeresult < 0) {
			Log.i(TAG, "Save Playtime failed! " + playtimeresult);
		} else {
			Log.i(TAG, "Save Playtime success! " + playtimeresult);
		}


	}
    }

    @Override
    public void onResume()
    {
	super.onResume();
	this.mEngine.start();
	startPlayTime = System.currentTimeMillis();
    }

    @Override
    public void onDestroy()
    {
	super.onDestroy();

	if (talker != null)
	{
	    talker.stop();
	    talker.shutdown();
	}

	try
	{
	    int seconds = (int) (totalPlayTime / 1000) % 60;
	    int minutes = (int) ((totalPlayTime / (1000 * 60)) % 60);
	    int hours = (int) ((totalPlayTime / (1000 * 60 * 60)) % 24);
	    int days = (int) (totalPlayTime / (1000 * 60 * 60 * 24));

	    Toast.makeText(this, "Total Playtime: " + days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds", Toast.LENGTH_LONG).show();

		/*
	    if (tama != null) {
			tama.addToPlaytime(totalPlayTime);
		}
		*/


	    stopGPS();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

    @Override
    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final ITouchArea pTouchArea,
	    final float pTouchAreaLocalX, final float pTouchAreaLocalY)
    {
		Log.i(TAG, "onAreaTouched: " + pTouchAreaLocalX + ", " + pTouchAreaLocalY);
	if (pSceneTouchEvent.isActionDown())
	{

	}

	return false;
    }

    @Override
    public boolean onSceneTouchEvent(final Scene pScene, final TouchEvent pSceneTouchEvent)
    {
	if (pSceneTouchEvent.isActionDown())
	{
	    /**
	     * Move tama to place on screen that was touched.
	     */
	    if (mainLayer.isVisible() && !tama.isDead())
	    {
		float x = pSceneTouchEvent.getX();
		float y = pSceneTouchEvent.getY();
		if (y < pTopBound || y > pBottomBound)
		    return false;
		moveTama(x, y);
	    }
	}

	return false;
    }

    // ===========================================================
    // Methods
    // ===========================================================
    @Override
    public void pauseSound()
    {

    }

    @Override
    public void resumeSound()
    {

    }

    /**
     * Loads the tamagotchi at the given coordinates. If first run, an egg hatches, otherwise the existing tamagotchi is loaded from the database.
     * 
     * @param centerX
     *            x-coordinate
     * @param centerY
     *            y-coordinate
     */
    private void loadTama(final float centerX, final float centerY, final boolean reborn)
    {
	Tamagotchi tempTama = dbHelper.loadTama(1, listTR);
	if (!reborn)
	{
	    if (tempTama != null)
	    {
		if (tempTama.checkStats() != Tamagotchi.DEAD)
		{
			Log.i(TAG, "Tama loaded from database!");
		    firstRun = false;
		    this.tama = tempTama;
		    this.setTamaSprite(centerX, centerY);
		    if (this.tama.getEquippedItem() != null)
		    {
			this.tama.setEquippedItem(new GameItem(this.tama.getEquippedItem()));
			this.tama.getEquippedItem().setPosition(tama.getSprite().getBaseWidth() - 25, tama.getSprite().getBaseHeight() - 25);
			tama.getSprite().attachChild(this.tama.getEquippedItem());
		    }
		}
		else
		    firstRun = true;
	    }
	}

	if (firstRun || reborn)
	{
		Log.i(TAG, "[loadTama] First Run!");
	    this.tama = new Tamagotchi();
	    if (tempTama != null)
		this.tama.setMoney(tempTama.getMoney());
	    this.setTamaSprite(centerX, centerY);
	    topLayer.setVisible(false);
	    midLayer.setVisible(false);
	    if (eggSprite == null)
		eggSprite = new Sprite(centerX, centerY, listTR.get("wing-egg.png"));

	    IEntityModifierListener modListener = new IEntityModifierListener()
	    {
		@Override
		public void onModifierStarted(IModifier<IEntity> arg0, IEntity arg1)
		{

		}

		@Override
		public void onModifierFinished(IModifier<IEntity> arg0, IEntity arg1)
		{
		    topLayer.setVisible(true);
		    midLayer.setVisible(true);
		    eggSprite.detachSelf();
		    mainLayer.attachChild(tama.getSprite());
		}
	    };
	    float time = 0.25f;
	    float degree = 25;
	    final LoopEntityModifier loopEntityModifier = new LoopEntityModifier(new SequenceEntityModifier(new RotationModifier(time, 0, degree), new RotationModifier(time, degree, 0), new RotationModifier(time, 0, -degree), new RotationModifier(time, -degree, 0)), 5);
	    final SequenceEntityModifier seqEntityModifier = new SequenceEntityModifier(modListener, loopEntityModifier, new org.anddev.andengine.entity.modifier.ScaleModifier(0.1f, 1, 2));
	    eggSprite.registerEntityModifier(seqEntityModifier);
	    if (!eggSprite.hasParent())
		mainLayer.attachChild(eggSprite);
	}
	else
	{
	    this.mainLayer.attachChild(tama.getSprite());
	}
    }

    private void setTamaSprite(final float centerX, final float centerY)
    {
	this.tama.setSprite(new AnimatedSprite(centerX, centerY, this.mTamaTextureRegion)
	{
	    @Override
	    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
		    final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	    {
		if (!this.getParent().isVisible())
		    return false;

		if (pSceneTouchEvent.isActionDown())
		{
		    say(tamaResponses[MathUtils.random(0, tamaResponses.length - 1)]);
		}
		return true;
	    }
	});
	((AnimatedSprite) this.tama.getSprite()).animate(new long[] { 300, 300 }, 6, 7, true);
	mScene.registerTouchArea(tama.getSprite());
    }

    /**
     * Moves the tama to the specified xy-coordinates.
     * 
     * @param x
     *            x-coordinate of destination.
     * @param y
     *            y-coordinate of destination.
     */
    private void moveTama(final float x, final float y)
    {
	if (!tama.getSprite().hasParent() || stayStill || tama.getStatus() == Tamagotchi.DEAD)
	    return;

	final Path path = new Path(2).to(tama.getSprite().getX(), tama.getSprite().getY()).to(x - tama.getSprite().getWidth() / 2, y - tama.getSprite().getHeight() / 2);
	double distance = Math.sqrt(Math.pow(tama.getSprite().getX() - x, 2) + Math.pow(tama.getSprite().getY() - y, 2));

	this.tama.getSprite().clearEntityModifiers();
	this.tama.getSprite().registerEntityModifier(new PathModifier((float) distance / velocity, path, null, new IPathModifierListener() {
		@Override
		public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) {
			// Log.i(TAG, "onPathStarted");
			manualMove = true;
		}

		@Override
		public void onPathWaypointStarted(final PathModifier pPathModifier,
										  final IEntity pEntity, final int pWaypointIndex) {
			// Log.i(TAG, "onPathWaypointStarted:  " + pWaypointIndex);
			float[] xCoords = pPathModifier.getPath().getCoordinatesX();
			float[] yCoords = pPathModifier.getPath().getCoordinatesY();

			float deltaX = xCoords[0] - xCoords[1];
			float deltaY = yCoords[0] - yCoords[1];

			if (deltaX > 0 && Math.abs(deltaX) > Math.abs(deltaY)) // moving left
			{
				((AnimatedSprite) tama.getSprite()).animate(new long[]{200, 200}, 0, 1, true);
			} else if (deltaX < 0 && Math.abs(deltaX) > Math.abs(deltaY)) // moving right
			{
				((AnimatedSprite) tama.getSprite()).animate(new long[]{200, 200}, 2, 3, true);
			} else if (deltaY > 0 && Math.abs(deltaY) > Math.abs(deltaX)) // moving up
			{
				((AnimatedSprite) tama.getSprite()).animate(new long[]{200, 200}, 4, 5, true);
			} else if (deltaY < 0 && Math.abs(deltaY) > Math.abs(deltaX)) // moving down
			{
				((AnimatedSprite) tama.getSprite()).animate(new long[]{200, 200}, 6, 7, true);
			} else {
				((AnimatedSprite) tama.getSprite()).stopAnimation();
			}

		}

		@Override
		public void onPathWaypointFinished(final PathModifier pPathModifier,
										   final IEntity pEntity, final int pWaypointIndex) {
			// Log.i(TAG, "onPathWaypointFinished: " + pWaypointIndex);
		}

		@Override
		public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) {
			// Log.i(TAG, "onPathFinished");
			((AnimatedSprite) tama.getSprite()).stopAnimation();
			manualMove = false;
		}
	}));
    }

    /**
     * Loads everything related to the interface (icons, bars, menus)
     */
    private void loadInterface()
    {

	final float mid = (cameraHeight - pBottomBound) / 2;

	/**
	 * Load stats background
	 */
	final Rectangle statsBackground = new Rectangle(0, 0, cameraWidth, pBottomBound);
	statsBackground.setColor(88 / 255f, 143 / 255f, 39 / 255f);
	statsLayer.attachChild(statsBackground);

	final Text statsLabel = new Text(15, 15, mFont, "Tamagotchi Stats", HorizontalAlign.LEFT);
	statsBackground.attachChild(statsLabel);

	this.stats = new ChangeableText(25, statsLabel.getY() + 50, mSmallFont, tama.getStats(), HorizontalAlign.LEFT, 512);
	this.stats.setWidth(cameraWidth - 150);
	statsBackground.attachChild(stats);

	final AnimatedSprite statsSprite = new AnimatedSprite(0, 0, ((AnimatedSprite) tama.getSprite()).getTextureRegion());
	statsSprite.setPosition(cameraWidth - statsSprite.getWidth() - 50, statsSprite.getHeight() + 25);
	statsBackground.attachChild(statsSprite);

	final Text unequipItemText = new Text(10, 5, mSmallFont, "Unequip Item");
	unequipItemButton = new Rectangle(50, this.stats.getY() + this.stats.getHeight() + 50, unequipItemText.getWidth() + 20, unequipItemText.getHeight() + 10)
	{
	    @Override
	    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
		    final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	    {
		if (statsLayer.isVisible() && this.isVisible())
		{
		    if (pSceneTouchEvent.isActionDown())
			this.setColor(0, 0.659f, 0.698f);
		    else if (pSceneTouchEvent.isActionUp())
		    {
			this.setColor(1, 0.412f, 0.0196f);
			unequipItem();
		    }
		    return true;
		}
		else
		    return false;
	    }
	};
	unequipItemButton.setColor(1, 0.412f, 0.0196f);
	unequipItemButton.attachChild(unequipItemText);
	mScene.registerTouchArea(unequipItemButton);
	statsBackground.attachChild(unequipItemButton);




		final Text changebdayText = new Text(10, 5, mSmallFont, "Change my BDay");
		changebdayButton = new Rectangle(50, this.stats.getY() + this.stats.getHeight() + 50, changebdayText.getWidth() + 20, changebdayText.getHeight() + 10)
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
			{
				if (statsLayer.isVisible() && this.isVisible())
				{
					if (pSceneTouchEvent.isActionDown())
						this.setColor(0, 0.659f, 0.698f);
					else if (pSceneTouchEvent.isActionUp())
					{
						this.setColor(1, 0.412f, 0.0196f);
						Intent startdateact = new Intent(MainGame.this, ChangeDate.class);
						startActivity(startdateact);

					}
					return true;
				}
				else
					return false;
			}
		};
		changebdayButton.setColor(1, 0.412f, 0.0196f);
		changebdayButton.attachChild(changebdayText);
		mScene.registerTouchArea(changebdayButton);
		statsBackground.attachChild(changebdayButton);


		//save Tama manual
		final Text saveTamaText = new Text(10, 5, mSmallFont, "Save Tama");
		saveTamaButton = new Rectangle(50, this.stats.getY() + this.stats.getHeight() + 50, changebdayText.getWidth() + 20, changebdayText.getHeight() + 10)
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
			{
				if (statsLayer.isVisible() && this.isVisible())
				{
					if (pSceneTouchEvent.isActionDown())
						this.setColor(0, 0.659f, 0.698f);
					else if (pSceneTouchEvent.isActionUp())
					{
						this.setColor(1, 0.412f, 0.0196f);
						//TODO
						//totalPlayTime += System.currentTimeMillis() - startPlayTime;
						//long newplaytime = tama.addToPlaytime(totalPlayTime);

						Log.i(TAG, "First Time Run? "+firstRun);

						if (dbHelper != null)
						{

							long result;
							if (firstRun == true) {
								Log.i(TAG, "First Time Run - inserting");
								result = dbHelper.insertTama(tama);
							} else {
								Log.i(TAG, "saveTama");
								result = dbHelper.saveTama(tama);
							}
							if (result < 0) {
								Log.i(TAG, "Save Tama failed! " + result);
							} else {
								Log.i(TAG, "Save Tama success! " + result);
							}



							long resultBackpackSave = dbHelper.insertBackpack(bp.getItems());
							if (resultBackpackSave < 0) {
								Log.i(TAG, "Save backpack failed! " + resultBackpackSave);
							} else {
								Log.i(TAG, "Save backpack success! " + resultBackpackSave);
							}

							/*
							//update total playtime
							long playtimeresult = dbHelper.saveplaytime(newplaytime, 1);
							if (playtimeresult < 0) {
								Log.i(TAG, "Save Playtime failed! " + playtimeresult);
							} else {
								Log.i(TAG, "Save Playtime success! " + playtimeresult);
							}
							*/


						}

					}
					return true;
				}
				else
					return false;
			}
		};
		saveTamaButton.setColor(1, 0.412f, 0.0196f);
		saveTamaButton.attachChild(saveTamaText);
		mScene.registerTouchArea(saveTamaButton);
		statsBackground.attachChild(saveTamaButton);


	/**
	 * Draw bottom rectangle bar
	 */
	bottomRect = new Rectangle(0, pBottomBound, cameraWidth, cameraHeight);
	bottomRect.setColor(70 / 255f, 132 / 255f, 163 / 255f);
	this.midLayer.attachChild(bottomRect);

	/**
	 * Draw top rectangle bar
	 */
	topRect = new Rectangle(0, 0, cameraWidth, pTopBound);
	topRect.setColor(70 / 255f, 132 / 255f, 163 / 255f);
	this.midLayer.attachChild(topRect);

	/**
	 * Load the open backpack icon
	 */
	createSelectBox(backpackLayer, 1);
	final Sprite openBackpackIcon = new Sprite(iconSpacer * 1 - this.listTR.get("backpack.png").getWidth() / 2, mid - this.listTR.get("backpack.png").getHeight() / 2, this.listTR.get("backpack.png"))
	{
	    @Override
	    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
		    final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	    {
		if (!this.getParent().getParent().isVisible())
		    return false;

		if (pSceneTouchEvent.isActionDown())
		{
		    if (!backpackLayer.isVisible())
		    {
			backpackLabel.setText("Backpack (" + bp.numItems() + "/" + bp.maxSize() + ")");
			openBackpack();
		    }
		    else
			closeBackpack();
		    return true;
		}

		return false;
	    }
	};
	bottomRect.attachChild(openBackpackIcon);
	this.mScene.registerTouchArea(openBackpackIcon);

	/**
	 * Load microphone icon
	 */
	final Sprite micIcon = new Sprite(iconSpacer * 2 - this.listTR.get("mic.png").getWidth() / 2, mid - this.listTR.get("mic.png").getHeight() / 2, this.listTR.get("mic.png"))
	{
	    @Override
	    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
		    final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	    {
		if (!this.getParent().getParent().isVisible())
		    return false;

		if (pSceneTouchEvent.isActionDown())
		{
		    closeSubLayers();
		    startVoiceRecognitionActivity();
		    return true;
		}
		return false;
	    }
	};
	bottomRect.attachChild(micIcon);
	this.mScene.registerTouchArea(micIcon);

	/**
	 * Load stats icon
	 */
	createSelectBox(statsLayer, 3);
	final Sprite statsIcon = new Sprite(iconSpacer * 3 - this.listTR.get("statsicon.png").getWidth() / 2, mid - this.listTR.get("statsicon.png").getHeight() / 2, this.listTR.get("statsicon.png"))
	{
	    @Override
	    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
		    final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	    {
		if (!this.getParent().getParent().isVisible())
		    return false;

		if (pSceneTouchEvent.isActionDown())
		{
		    if (!statsLayer.isVisible())
		    {
			stats.setText(TextUtil.getNormalizedText(mSmallFont, tama.getStats(), stats.getWidth()));
			if (tama.getEquippedItem() != null)
			{
			    unequipItemButton.setPosition(stats.getX(), stats.getY() + stats.getHeight() + 25);
			    unequipItemButton.setVisible(true);
			}
			else
			{
			    unequipItemButton.setVisible(false);
			}

				changebdayButton.setPosition(stats.getX(), stats.getY() + stats.getHeight() + 75);
				changebdayButton.setVisible(true);

				saveTamaButton.setPosition(stats.getX(), stats.getY() + stats.getHeight() + 150);
				saveTamaButton.setVisible(true);

			openLayer(statsLayer);
		    }
		    else
			closeSubLayers();

		    return true;
		}
		return false;
	    }
	};
	bottomRect.attachChild(statsIcon);
	this.mScene.registerTouchArea(statsIcon);

	/**
	 * Load minigame icon
	 */
	final Sprite minigameIcon = new Sprite(iconSpacer * 4 - this.listTR.get("statsicon.png").getWidth() / 2, mid - this.listTR.get("toad-icon.png").getHeight() / 2, this.listTR.get("toad-icon.png"))
	{
	    @Override
	    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
		    final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	    {
		if (!this.getParent().getParent().isVisible())
		    return false;

		if (pSceneTouchEvent.isActionDown())
		{
		    // showNotification("Minigames are still in development!");
		    Intent intent = new Intent(MainGame.this.getApplicationContext(), MiniGameListActivity.class);
		    MainGame.this.startActivity(intent);
		    return true;
		}
		return false;
	    }
	};
	bottomRect.attachChild(minigameIcon);
	this.mScene.registerTouchArea(minigameIcon);

	/**
	 * Load multiplayer icon
	 */
	final Sprite multiplayerIcon = new Sprite(iconSpacer * 5 - this.listTR.get("controller.png").getWidth() / 2, mid - this.listTR.get("controller.png").getHeight() / 2, this.listTR.get("controller.png"))
	{
	    @Override
	    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
		    final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	    {
		if (!this.getParent().getParent().isVisible())
		    return false;

		if (pSceneTouchEvent.isActionDown())
		{
		    say("Let's battle!");
		    Intent intent = new Intent(MainGame.this.getApplicationContext(), TamaBattle.class);
		    intent.putExtra(MultiplayerConstants.BATTLE_LEVEL, tama.getBattleLevel());
		    intent.putExtra(MultiplayerConstants.HEALTH, tama.getCurrentHealth());
		    intent.putExtra(MultiplayerConstants.MAX_HEALTH, tama.getMaxHealth());
		    Toast.makeText(MainGame.this.getApplicationContext(), "Starting multiplayer!", Toast.LENGTH_SHORT).show();
		    MainGame.this.startActivityForResult(intent, TAMA_BATTLE_CODE);
		    return true;
		}
		return false;
	    }
	};
	bottomRect.attachChild(multiplayerIcon);
	this.mScene.registerTouchArea(multiplayerIcon);

	/**
	 * Load item store icon
	 */
	final Sprite storeIcon = new Sprite(iconSpacer * 6 - this.listTR.get("shop.png").getWidth() / 2, mid - this.listTR.get("shop.png").getHeight() / 2, this.listTR.get("shop.png"))
	{
	    @Override
	    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
		    final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	    {
		if (!this.getParent().getParent().isVisible())
		    return false;

		if (pSceneTouchEvent.isActionDown())
		{
		    say("Let's go shopping!");
		    Intent intent = new Intent(MainGame.this.getApplicationContext(), ItemStore.class);
		    intent.putExtra("money", tama.getMoney());
		    Toast.makeText(MainGame.this.getApplicationContext(), "Starting item store!", Toast.LENGTH_SHORT).show();
		    MainGame.this.startActivityForResult(intent, TAMA_ITEM_STORE_CODE);
		    return true;
		}
		return false;
	    }
	};
	bottomRect.attachChild(storeIcon);
	this.mScene.registerTouchArea(storeIcon);

	TextureRegion temp;
	/**
	 * Load status bars
	 */
	final Text titleText = new Text(leftSpacing - 15, vSpacing, mFont, "Tamagotchi");
	topRect.attachChild(titleText);

	final Rectangle healthBar = new Rectangle(leftSpacing, titleText.getY() + titleText.getHeight() + vSpacing, barLength, barHeight);
	healthBar.setColor(1, 1, 1);
	topRect.attachChild(healthBar);

	final Rectangle hungerBar = new Rectangle(cameraWidth - barLength - leftSpacing, vSpacing, barLength, barHeight);
	hungerBar.setColor(1, 1, 1);
	topRect.attachChild(hungerBar);

	final Rectangle sicknessBar = new Rectangle(hungerBar.getX(), healthBar.getY(), barLength, barHeight);
	sicknessBar.setColor(1, 1, 1);
	topRect.attachChild(sicknessBar);

	/**
	 * Load health bar
	 */
	float ratio = (float) tama.getCurrentHealth() / tama.getMaxHealth();
	// Log.i(TAG, "Tama health ratio: " + ratio);
	this.currHealthBar = new Rectangle(2, 2, ratio * (barLength - 4), barHeight - 4);
	currHealthBar.setColor(1, 0, 0);
	healthBar.attachChild(currHealthBar);

	/**
	 * Load health icon
	 */
	temp = listTR.get("heart.png");
	final Sprite healthIcon = new Sprite(healthBar.getX() - iconSpacing, healthBar.getY(), temp);
	topRect.attachChild(healthIcon);

	/**
	 * Load sickness bar
	 */
	ratio = (float) tama.getCurrentSickness() / tama.getMaxSickness();
	// Log.i(TAG, "Tama sick ratio: " + ratio);
	this.currSicknessBar = new Rectangle(2, 2, ratio * (barLength - 4), barHeight - 4);
	currSicknessBar.setColor(1, 0, 0);
	sicknessBar.attachChild(currSicknessBar);

	/**
	 * Load sickness icon
	 */
	temp = listTR.get("sick.png");
	final Sprite sickIcon = new Sprite(sicknessBar.getX() - iconSpacing, sicknessBar.getY(), temp);
	topRect.attachChild(sickIcon);

	/**
	 * Load hunger bar
	 */
	ratio = (float) tama.getCurrentHunger() / tama.getMaxHunger();
	// Log.i(TAG, "Tama hunger ratio: " + ratio);
	this.currHungerBar = new Rectangle(2, 2, ratio * (barLength - 4), barHeight - 4);
	currHungerBar.setColor(1, 0, 0);
	hungerBar.attachChild(currHungerBar);

	/**
	 * Load hunger icon
	 */
	temp = listTR.get("food.png");
	final Sprite hungerIcon = new Sprite(hungerBar.getX() - iconSpacing, hungerBar.getY(), temp);
	topRect.attachChild(hungerIcon);

	/**
	 * Load item description box
	 */
	this.itemDescriptionRect = new Rectangle(10, cameraHeight / 2, cameraWidth - 20, Math.round(cameraHeight / 2 - (cameraHeight - pBottomBound) - 10));
	this.itemDescriptionRect.setColor(0, 0, 0);
	this.itemDescriptionRect.setAlpha(.8f);
	this.itemDescriptionRect.setVisible(false);
	this.topLayer.attachChild(itemDescriptionRect);

	/**
	 * Add text to item description box
	 */
	this.itemDesctiptionText = new ChangeableText(10, 10, mSmallFont, "", 512);
	this.itemDescriptionRect.attachChild(this.itemDesctiptionText);

	/**
	 * Load notification box
	 */
	this.notificationRect = new Rectangle(0, pTopBound, cameraWidth, 50);
	this.notificationRect.setColor(0, 0, 0);
	this.notificationRect.setAlpha(.8f);
	this.notificationRect.setVisible(false);
	this.midLayer.attachChild(notificationRect);

	/**
	 * Add text to notification box
	 */
	this.notificationText = new ChangeableText(10, 10, mSmallFont, "", 512);
	this.notificationRect.attachChild(notificationText);

	/**
	 * Add close button
	 */
	final Sprite closeButton = new Sprite(this.itemDescriptionRect.getWidth() - listTR.get("close.png").getWidth(), 0, listTR.get("close.png"))
	{
	    @Override
	    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
		    final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	    {
		if (this.getParent().isVisible())
		{
		    hideItemDescription();
		    return true;
		}
		else
		    return false;
	    }
	};
	this.itemDescriptionRect.attachChild(closeButton);
	this.mScene.registerTouchArea(closeButton);

	/**
	 * Add close button for notification
	 */
	final Sprite notifyCloseButton = new Sprite(this.notificationRect.getWidth() - listTR.get("close.png").getWidth(), 0, listTR.get("close.png"))
	{
	    @Override
	    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
		    final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	    {
		if (this.getParent().isVisible())
		{
		    notificationRect.setVisible(false);
		    notificationText.setText("");
		    notificationList = new LinkedList<String>();
		    return true;
		}
		else
		    return false;
	    }
	};
	this.notificationRect.attachChild(notifyCloseButton);
	this.mScene.registerTouchArea(notifyCloseButton);

    }

    /**
     * Updates the status bars with Tama info
     */
    private void updateStatusBars()
    {
	float ratio = (float) tama.getCurrentHealth() / tama.getMaxHealth();
	// Log.i(TAG, "Tama health ratio: " + ratio);
	this.currHealthBar.setSize(ratio * (barLength - 4), barHeight - 4);

	ratio = (float) tama.getCurrentSickness() / tama.getMaxSickness();
	// Log.i(TAG, "Tama sick ratio: " + ratio);
	this.currSicknessBar.setSize(ratio * (barLength - 4), barHeight - 4);

	ratio = (float) tama.getCurrentHunger() / tama.getMaxHunger();
	// Log.i(TAG, "Tama hunger ratio: " + ratio);
	this.currHungerBar.setSize(ratio * (barLength - 4), barHeight - 4);
    }

    /**
     * Adds poop to scene at specified coordinates
     * 
     * @param pX
     * @param pY
     */
    public void addPoop(final float pX, final float pY)
    {
	final Sprite poop = new Sprite(pX, pY, this.listTR.get("poop.png"))
	{
	    private boolean touched = false;

	    @Override
	    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
		    final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	    {
		float x = pSceneTouchEvent.getX();
		float y = pSceneTouchEvent.getY();

		// don't respond to touch unless sprite's parent is visible
		if (this.getParent().isVisible())
		{
			Log.i(TAG, "Touched poop");
		    if (pSceneTouchEvent.isActionDown())
		    {
			touched = true;
		    }
		    else if (pSceneTouchEvent.isActionMove())
		    {
			if (touched)
			{
			    if (y < pTopBound)
				this.setPosition(x - this.getWidth() / 2, pTopBound - this.getHeight() / 2);
			    else if (y > pBottomBound)
				this.setPosition(x - this.getWidth() / 2, pBottomBound - this.getHeight() / 2);
			    else
				this.setPosition(x - this.getWidth() / 2, y - this.getHeight() / 2);



			    if (this.collidesWith(emptytrashcan)) {
					MainGame.this.mainLayer.detachChild(MainGame.this.emptytrashcan);
					if (!MainGame.this.fulltrashcan.hasParent()) {
						MainGame.this.mainLayer.attachChild(MainGame.this.fulltrashcan);
					}
				} else {
					MainGame.this.mainLayer.detachChild(MainGame.this.fulltrashcan);
					if (!MainGame.this.emptytrashcan.hasParent()) {
						MainGame.this.mainLayer.attachChild(MainGame.this.emptytrashcan);
					}
				}
			}
			else
			{
			    return false;
			}
		    }
		    else if (pSceneTouchEvent.isActionUp())
		    {
			touched = false;
			if (this.collidesWith(fulltrashcan))
			{
			    ipoToRemove.add(this);
				MainGame.this.mainLayer.detachChild(MainGame.this.fulltrashcan);
				if (!MainGame.this.emptytrashcan.hasParent()) {
					MainGame.this.mainLayer.attachChild(MainGame.this.emptytrashcan);
				}
			}
		    }
		    return true;
		}
		else
		{
		    return false;
		}
	    }
	};
	poop.setUserData("poop");
	float scale = MathUtils.random(0.75f, (2.0f - 0.75f));
	poop.setScale(scale);
	inPlayObjects.add(poop);

	this.mainLayer.attachChild(poop);
	this.mainLayer.swapChildren(poop, tama.getSprite());
	this.mScene.registerTouchArea(poop);
    }

    /**
     * This method just adds a bunch of dummy items to the backpack
     */
    private void loadItems()
    {

	bp = new Backpack();
	ArrayList<Item> backpackItems = dbHelper.getBackpack(listTR);
	if (backpackItems.isEmpty())
	{
		//super(x, y, textureRegion, name, description, health, hunger, sickness, xp);
	    final Item umbrella = new GameItem(0, 0, this.listTR.get("umbrella.png"), "Umbrella", "This item protects the Tamagotchi from the rain.", 0, 0, 0, 0);
	    umbrella.setType(Item.EQUIP);
	    umbrella.setProtection(Protection.RAIN);
	    this.bp.addItem(umbrella);

	    final Item newItem = new GameItem(0, 0, this.listTR.get("star-white-48.png"), "Level item", 7, 0, 0, 10000);
	    this.bp.addItem(newItem);

	    final Item cureAll = new GameItem(0, 0, this.listTR.get("bandaid.png"), "Cure All", 0, -10000, -10000, 0);
	    this.bp.addItem(cureAll);

	    final Item killTama = new GameItem(0, 0, this.listTR.get("skull.png"), "Kill Tama", "This item kills the Tamagotchi.", -10000, 0, 0, 0);
	    this.bp.addItem(killTama);

	    for (int i = 0; i < 9; i++)
		{
		Item item = new GameItem(0, 0, this.listTR.get("apple.png"), "Apple", 7, -100, -100, 10);
		this.bp.addItem(item);
	    }

	    bp.resetPositions(cameraWidth, cameraHeight);
	}
	else
	{
		Log.i(TAG, "Backpack loaded from database!");
	    for (Item item : backpackItems)
	    {
		bp.addItem(new GameItem(item));
	    }
	    bp.resetPositions(cameraWidth, cameraHeight);
	}

	/**
	 * Load backpack background
	 */
	backpackBackground = new Rectangle(0, 0, cameraWidth, pBottomBound);
	//backpackBackground.setColor(87 / 255f, 57 / 255f, 20 / 255f);
	//backpackBackground.setColor(103 / 255f, 130 / 255f, 163 / 255f); //blue+gray
	backpackBackground.setColor(30 / 255f, 73 / 255f, 93 / 255f);
	backpackLayer.attachChild(backpackBackground);

	backpackLabel = new ChangeableText(15, 15, mFont, "Backpack (" + bp.numItems() + "/" + bp.maxSize() + ")", HorizontalAlign.LEFT, 30);
	backpackBackground.attachChild(backpackLabel);

	for (Item item : bp.getItems())
	{
	    this.backpackBackground.attachChild(item);
	    this.mScene.registerTouchArea(item);
	}
    }

    /**
     * Applies an item to the Tamagotchi and removes the item from the backpack. It also detaches the item from the scene and unregisters its touch area.
     * 
     * @param item
     *            Item to be applied
     */
    private void applyItem(Item item)
    {
	showEffect(this.tama.applyItem(item));
	this.bp.removeItem(item);
	item.detachSelf();
	this.mScene.unregisterTouchArea(item);
    }

    private void openBackpack()
    {
	this.openLayer(backpackLayer);
	this.bp.resetPositions(cameraWidth, cameraHeight);
    }

    private void closeBackpack()
    {
	this.closeSubLayers();
	this.bp.resetPositions(cameraWidth, cameraHeight);
    }

    /**
     * Generates the pop up that shows the item description
     * 
     * @param i
     *            - the item that was selected
     */
    private void showItemDescription(Item i)
    {
	String normalizedText = TextUtil.getNormalizedText(mSmallFont, i.getInfo(), this.itemDescriptionRect.getWidth() - 20);
	this.itemDesctiptionText.setText(normalizedText);
	this.itemDescriptionRect.setHeight(this.itemDesctiptionText.getHeight());
	this.itemDescriptionRect.setPosition(this.itemDescriptionRect.getX(), pBottomBound - this.itemDescriptionRect.getHeight() - 10);
	this.itemDescriptionRect.setVisible(true);
    }

    private void hideItemDescription()
    {
	this.itemDescriptionRect.setVisible(false);
    }


	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnected()) {
			Log.i(TAG, "network state = true");
			return true;
		}
		return false;
	}


	//TODO: add more precip types//
    /**
     * Loads the selected weather into the environment.
     * 
     * @param type
     *            Specified by Weather class. (e.g. Weather.SNOW, Weather.RAIN, Weather.NONE)
     */
    private void loadWeather(int type)
    {
	if (particleSystem != null)
	{
	    particleSystem.detachSelf();
	    this.particleSystem = null;
	}

	if (type == Weather.SNOW)
	{
	    weather = type;
	    final RectangleParticleEmitter particleEmitter = new RectangleParticleEmitter(cameraWidth / 2, pTopBound, cameraWidth, 1);
	    this.particleSystem = new ParticleSystem(particleEmitter, 6, 10, 200, listTR.get("snowflake.png"));
	    particleSystem.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE);

	    particleSystem.addParticleInitializer(new VelocityInitializer(-10, 10, 60, 90));
	    particleSystem.addParticleInitializer(new AccelerationInitializer(5, 15));
	    particleSystem.addParticleInitializer(new RotationInitializer(0.0f, 360.0f));

	    particleSystem.addParticleModifier(new ExpireModifier(11.5f));
	    this.weatherLayer.attachChild(particleSystem);
	}
	else if (type == Weather.RAIN)
	{
	    weather = type;
	    final RectangleParticleEmitter particleEmitter = new RectangleParticleEmitter(cameraWidth / 2, pTopBound, cameraWidth, 1);
	    this.particleSystem = new ParticleSystem(particleEmitter, 6, 10, 200, listTR.get("raindrop.png"));
	    particleSystem.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE);

	    particleSystem.addParticleInitializer(new VelocityInitializer(0, 0, 60, 90));
	    particleSystem.addParticleInitializer(new AccelerationInitializer(0, 15));

	    particleSystem.addParticleModifier(new ExpireModifier(11.5f));
	    this.weatherLayer.attachChild(particleSystem);
	}
	else
	{
	    weather = Weather.NONE;
	}
    }

    /**
     * Voice recognition system, starts the Activity that shows the voice prompt
     */
    public void startVoiceRecognitionActivity()
    {
	if (isOnline())
	{
	    try
	    {
		this.mEngine.stop();
			Log.i(TAG, "Starting voice recognition");
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		// uses free form text input
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		// Puts a customized message to the prompt
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say a command");
		startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
	    } catch (Exception e)
	    {
		Toast.makeText(this, "Error! Cannot start voice command", Toast.LENGTH_SHORT).show();
	    }
	}
	else
	{
	    Toast.makeText(this, "Cannot start voice commands, there is no internet connection", Toast.LENGTH_SHORT).show();
	}
    }

    /**
     * Handles the results from the recognition activity.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
	if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK)
	{
		Log.i(TAG, "Interpret results");
	    // Fill the list view with the strings the recognizer thought it could have heard
	    ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
	    if (matches.contains("toggle snow"))
	    {
		if (weather == Weather.SNOW)
		{
		    loadWeather(Weather.NONE);
		}
		else
		{
		    loadWeather(Weather.SNOW);
		}
	    }
	    else if (matches.contains("toggle rain"))
	    {
		if (weather == Weather.RAIN)
		{
		    loadWeather(Weather.NONE);
		}
		else
		{
		    loadWeather(Weather.RAIN);
		}
	    }
	    else if (matches.contains("remove poop"))
	    {
		for (Entity e : inPlayObjects)
		{
		    ipoToRemove.add((Sprite) e);
		}
	    }
	    else if (matches.contains("hyper mode"))
	    {
		velocity = 1000;
		toast("Hyper mode activated.");
	    }
	    else if (matches.contains("normal mode"))
	    {
		velocity = 100;
		toast("Normal mode activated.");
	    }
	    else if (matches.contains("stay"))
	    {
		stayStill = true;
	    }
	    else if (matches.contains("move"))
	    {
		stayStill = false;
	    }
	    else if (matches.contains("die"))
	    {
		tama.setStatus(Tamagotchi.DEAD);
	    }
	    super.onActivityResult(requestCode, resultCode, data);
	    this.mEngine.start();
	}
	else if (requestCode == TAMA_BATTLE_CODE && resultCode == RESULT_OK)
	{
	    int xpGain = data.getIntExtra(MultiplayerConstants.XP_GAIN, 0);
	    boolean isDeathMatch = data.getBooleanExtra(MultiplayerConstants.DEATHMATCH, false);
	    if (isDeathMatch)
		xpGain *= 2;
		Log.i(TAG, "[TamaBattle] XP GAIN: " + xpGain);
	    if (xpGain != 0)
	    {
		tama.setCurrentXP(tama.getCurrentXP() + xpGain);
		showNotification("Your tama has gained " + xpGain + " XP!");
	    }
	    int health = data.getIntExtra(MultiplayerConstants.HEALTH, -1000);
	    if (health != -1000)
	    {
			Log.i(TAG, "Setting current health to " + health);
		tama.setCurrentHealth(health);
	    }
	    super.onActivityResult(requestCode, resultCode, data);
	}
	else if (requestCode == TAMA_ITEM_STORE_CODE && resultCode == RESULT_OK)
	{
	    int money = data.getIntExtra("money", -1);
	    if (money != -1)
	    {
		tama.setMoney(money);
	    }
	    this.loadItems();
	    super.onActivityResult(requestCode, resultCode, data);
	}
    }

    /**
     * Opens the specified sublayer and hides the other layers
     * 
     * @param layer
     *            subLayer to be opened
     * @return
     */
    private boolean openLayer(Entity layer)
    {
	try
	{
	    layer.setVisible(true);
	    layer.setChildrenVisible(true);
	    selectBoxes.get(layer).setVisible(true);
	    for (Entity e : subLayers)
	    {
		if (!e.equals(layer))
		{
		    e.setVisible(false);
		    e.setChildrenVisible(false);
		    selectBoxes.get(e).setVisible(false);
		}
	    }

	    for (Entity e : mainLayers)
	    {
		e.setVisible(false);
		e.setChildrenVisible(false);
	    }

	    hideItemDescription();

	    return true;
	} catch (Exception e)
	{
	    e.printStackTrace();
	    return false;
	}
    }

    /**
     * Closes all subLayers and sets the main layers to visible
     */
    private void closeSubLayers()
    {
	for (Entity e : subLayers)
	{
	    e.setVisible(false);
	    e.setChildrenVisible(false);
	    try
	    {
		selectBoxes.get(e).setVisible(false);
	    } catch (Exception ex)
	    {

	    }
	}

	for (Entity e : mainLayers)
	{
	    e.setVisible(true);
	    e.setChildrenVisible(true);
	}

	hideItemDescription();
    }

    /**
     * Creates a select box for an icon, which is mapped to the sublayer that the icon opens. Should be created before the icon is created.
     * 
     * @param entity
     *            The subLayer that the icon is meant to open
     * @param index
     *            The icon's placement in the bottom bar. (starting at 1)
     */
    private void createSelectBox(Entity entity, int index)
    {
	final float boxWidth = 75;
	final Rectangle selectBox = new Rectangle(iconSpacer * index - boxWidth / 2, 0, boxWidth, bottomRect.getHeight());
	selectBox.setColor(247 / 255f, 233 / 255f, 103 / 255f);
	selectBox.setVisible(false);
	selectBoxes.put(entity, selectBox);
	bottomRect.attachChild(selectBox);
    }

    /**
     * Equips item to tamagotchi.
     * 
     * @param item
     *            Item to be equipped
     * @return true if successfully equipped, false otherwise
     */
    private boolean equipItem(Item item, final boolean notify)
    {
	itemToApply = item;
	runOnUpdateThread(new Runnable()
	{
	    public void run()
	    {
		if (!unequipItem())
		{
			Log.i(TAG, "Could not unequip item!");
		    itemToApply.detachSelf();
		    backpackBackground.attachChild(itemToApply);
		    itemToApply = null;
		    return;
		}
		try
		{
		    itemToApply.detachSelf(); // detach item from any other entities
		    mScene.unregisterTouchArea(itemToApply); // try to unregister to touch area
		} catch (Exception e)
		{
		    // item was not previously registered with touch
		}

		try
		{
		    bp.removeItem(itemToApply); // try to remove from backpack
		} catch (Exception e)
		{
		    // item was not taken from backpack
		}

		tama.setEquippedItem(itemToApply);
		itemToApply.setPosition(tama.getSprite().getBaseWidth() - 25, tama.getSprite().getBaseHeight() - 25);
		tama.getSprite().attachChild(itemToApply);
		if (notify)
		    showNotification(itemToApply.getName() + " has been equipped!");
		itemToApply = null;
	    }

	});
	return true;
    }

    /**
     * Unequips item from tamagotchi.
     * 
     * @return true if unequipped, false otherwise
     */
    private boolean unequipItem()
    {
	try
	{
	    Item previousItem = tama.getEquippedItem();

	    if (previousItem == null)
		return true;

	    if (!bp.addItem(previousItem))
	    {
		showNotification("Backpack is full!");
		return false;
	    }
	    previousItem.detachSelf();
	    backpackBackground.attachChild(previousItem);
	    mScene.registerTouchArea(previousItem);
	    showNotification(previousItem.getName() + " has been unequipped!");
	    tama.setEquippedItem(null);
	} catch (Exception e)
	{
	    return false;
	}
	return true;
    }

    public void toast(final String pMessage)
    {
	this.runOnUiThread(new Runnable()
	{
	    @Override
	    public void run()
	    {
		Toast.makeText(MainGame.this, pMessage, Toast.LENGTH_SHORT).show();
	    }
	});
    }

    /**
     * Shows the particle effect for the given status of the Tamagotchi.
     * 
     * @param status
     *            Status of Tamagotchi. Defined by static variables in Tamagotchi class.
     */
    private void showEffect(int status)
    {
	if (status == Tamagotchi.LEVEL_UP)
	{
	    final CircleOutlineParticleEmitter particleEmitter = new CircleOutlineParticleEmitter(tama.getSprite().getWidth() / 2, tama.getSprite().getHeight() / 2, 60);
	    final ParticleSystem particleSystem = new ParticleSystem(particleEmitter, 25, 25, 360, listTR.get("particle_point.png"));
	    particleSystem.addParticleInitializer(new AlphaInitializer(0));
	    particleSystem.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE);
	    particleSystem.addParticleInitializer(new VelocityInitializer(-2, 2, -20, -10));
	    particleSystem.addParticleInitializer(new RotationInitializer(0.0f, 360.0f));

	    particleSystem.addParticleModifier(new ScaleModifier(1.0f, 2.0f, 0, 5));
	    particleSystem.addParticleModifier(new ColorModifier(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 2f));
	    particleSystem.addParticleModifier(new AlphaModifier(0, 1, 0, 1));
	    particleSystem.addParticleModifier(new AlphaModifier(1, 0, 5, 6));
	    particleSystem.addParticleModifier(new ExpireModifier(2, 2));
	    tama.getSprite().attachChild(particleSystem);
	    mScene.registerUpdateHandler(new TimerHandler(2f, new ITimerCallback()
	    {
		@Override
		public void onTimePassed(final TimerHandler pTimerHandler)
		{
		    particleSystem.setParticlesSpawnEnabled(false);
		    mScene.unregisterUpdateHandler(pTimerHandler);
		}

	    }));
	    mScene.registerUpdateHandler(new TimerHandler(5f, new ITimerCallback()
	    {
		@Override
		public void onTimePassed(final TimerHandler pTimerHandler)
		{
		    particleSystem.detachSelf();
		    mScene.unregisterUpdateHandler(pTimerHandler);
		}
	    }));
	    showNotification("Tamagotchi has leveled up!");
	}
	else if (status == Tamagotchi.DEAD)
	{
	    topLayer.setVisible(false);
	    midLayer.setVisible(false);

	    final RectangleParticleEmitter particleEmitter = new RectangleParticleEmitter(cameraWidth / 2, pBottomBound, cameraWidth, 1);
	    final ParticleSystem particleSystem = new ParticleSystem(particleEmitter, 1, 10, 100, listTR.get("particle_point.png"));
	    particleSystem.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE);

	    particleSystem.addParticleInitializer(new VelocityInitializer(-10, 10, -60, -90));
	    particleSystem.addParticleInitializer(new AccelerationInitializer(5, -15));
	    particleSystem.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE);
	    particleSystem.addParticleModifier(new ScaleModifier(1.0f, 2.0f, 0, 5));
	    particleSystem.addParticleModifier(new ColorModifier(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 2f));
	    particleSystem.addParticleModifier(new AlphaModifier(0, 1, 0, 1));
	    particleSystem.addParticleModifier(new AlphaModifier(1, 0, 5, 6));
	    particleSystem.addParticleModifier(new ExpireModifier(11.5f));
	    mainLayer.attachChild(particleSystem);

	    final CircleOutlineParticleEmitter tamaParticleEmitter = new CircleOutlineParticleEmitter(tama.getSprite().getWidth() / 2, tama.getSprite().getHeight() / 2, 60);
	    final ParticleSystem tamaParticleSystem = new ParticleSystem(tamaParticleEmitter, 5, 5, 100, listTR.get("particle_point.png"));
	    tamaParticleSystem.addParticleInitializer(new AlphaInitializer(0));
	    tamaParticleSystem.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE);
	    tamaParticleSystem.addParticleInitializer(new VelocityInitializer(-2, 2, -20, -10));
	    tamaParticleSystem.addParticleInitializer(new RotationInitializer(0.0f, 360.0f));

	    tamaParticleSystem.addParticleModifier(new ScaleModifier(1.0f, 2.0f, 0, 5));
	    tamaParticleSystem.addParticleModifier(new ColorModifier(1.0f, 0.0f, 1.0f, 0.5f, 0.0f, 0.0f, 0.0f, 2f));
	    tamaParticleSystem.addParticleModifier(new AlphaModifier(0, 1, 0, 1));
	    tamaParticleSystem.addParticleModifier(new AlphaModifier(1, 0, 5, 6));
	    tamaParticleSystem.addParticleModifier(new ExpireModifier(5f));
	    tama.getSprite().attachChild(tamaParticleSystem);

	    tama.getSprite().setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	    tama.getSprite().registerEntityModifier(new org.anddev.andengine.entity.modifier.AlphaModifier(10, 1, 0));
	    if (tama.getEquippedItem() != null)
		tama.getEquippedItem().setVisible(false);

	    tamaDeadParticles = true;

	    mScene.registerUpdateHandler(new TimerHandler(10f, new ITimerCallback()
	    {
		@Override
		public void onTimePassed(final TimerHandler pTimerHandler)
		{
		    tamaParticleSystem.setParticlesSpawnEnabled(false);
		    particleSystem.setParticlesSpawnEnabled(false);
		    eggSprite = new Sprite(tama.getSprite().getX(), tama.getSprite().getY(), listTR.get("wing-egg.png"));
		    eggSprite.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		    eggSprite.registerEntityModifier(new org.anddev.andengine.entity.modifier.AlphaModifier(5, 0, 1));
		    mainLayer.attachChild(eggSprite);
		    mainLayer.swapChildren(eggSprite, tama.getSprite());
		    mScene.unregisterUpdateHandler(pTimerHandler);
		}

	    }));
	    mScene.registerUpdateHandler(new TimerHandler(20f, new ITimerCallback()
	    {
		@Override
		public void onTimePassed(final TimerHandler pTimerHandler)
		{
		    tamaParticleSystem.detachSelf();
		    particleSystem.detachSelf();
		    tama.getSprite().detachSelf();
		    // tama.getSprite().detachSelf();
		    // showSplashScreen();
		    runOnUiThread(new Runnable()
		    {

			@Override
			public void run()
			{
			    showDialog(MainGame.CONFIRM_RESTART);
			}
		    });
		    mScene.unregisterUpdateHandler(pTimerHandler);
		}
	    }));

	    // showNotification("Tamagotchi has passed away!");
	}
    }

    /**
     * Shows notification on the main screen using the given text.
     * 
     * @param text
     *            Text to display in notification.
     */
    private void showNotification(String text)
    {
	notificationList.add(TextUtil.getNormalizedText(mSmallFont, text, this.notificationRect.getWidth()));

	while (notificationList.size() > MAX_NOTIFICATIONS)
	    notificationList.remove(0);

	StringBuilder n = new StringBuilder();

	for (String s : notificationList)
	{
	    n.append(s);
	}

	if (vibrateOn)
	    this.mEngine.vibrate(500l);

	this.notificationText.setText(n.toString());
	this.notificationRect.setHeight(this.notificationText.getHeight());
	this.notificationRect.setVisible(true);
	closeSubLayers();
    }

    /**
     * Loads the timers that control the tama's stats.
     */
    private void loadTamaTimers()
    {
	/**
	 * Random movement
	 */
	this.mScene.registerUpdateHandler(new TimerHandler(MathUtils.random(0, 10), true, new ITimerCallback()
	{
	    @Override
	    public void onTimePassed(final TimerHandler pTimerHandler)
	    {
		if (!manualMove)
		{
		    moveTama(MathUtils.random(30, cameraWidth - 30), MathUtils.random(pTopBound + 30, pBottomBound - 30));
		    pTimerHandler.setTimerSeconds(MathUtils.random(0, 10));
		}
	    }
	}));

	/**
	 * Timer to generate poop
	 */
	this.mScene.registerUpdateHandler(new TimerHandler(60, true, new ITimerCallback()
	{
	    @Override
	    public void onTimePassed(final TimerHandler pTimerHandler)
	    {
		if (tama.getStatus() != Tamagotchi.DEAD && tama.getSprite().hasParent())
		{
		    final float x = tama.getSprite().getX();
		    final float y = tama.getSprite().getY();
		    final float xPos = MathUtils.random(x - 10, x + 10);
		    final float yPos = MathUtils.random(y - 10, y + 10);
		    addPoop(xPos, yPos);
		}
	    }
	}));

	/**
	 * Checks to see if Tamagotchi is prepared for weather every 5 minutes, if it isn't, increase sickness
	 */
	this.mScene.registerUpdateHandler(new TimerHandler(5 * 60, true, new ITimerCallback()
	{
	    @Override
	    public void onTimePassed(final TimerHandler pTimerHandler)
	    {
		if (tama.getStatus() != Tamagotchi.DEAD && tama.getSprite().hasParent())
		{
		    if (tama.getEquippedItem() != null)
		    {
			// if equipped item doesn't protect tama from current weather and current weather is not clear
			if (tama.getEquippedItem().getProtection() != weather && weather != Weather.NONE)
			{
			    tama.setCurrentSickness(Math.round(tama.getCurrentSickness() + tama.getMaxSickness() * .05f));
			}
		    }
		    else
		    {
			if (weather != Weather.NONE)
			{
			    tama.setCurrentSickness(Math.round(tama.getCurrentSickness() + tama.getMaxSickness() * .05f));
			}
		    }
		}
	    }
	}));

	/**
	 * Handling health regeneration
	 */
	final float battleLevelRatio = 1 - (float) tama.getBattleLevel() / Tamagotchi.MAX_BATTLE_LEVEL;
	final float initialTime = battleLevelRatio * 60;
	this.mScene.registerUpdateHandler(new TimerHandler(initialTime, true, new ITimerCallback()
	{
	    @Override
	    public void onTimePassed(final TimerHandler pTimerHandler)
	    {
		if (tama.getStatus() != Tamagotchi.DEAD && tama.getSprite().hasParent())
		{
		    if (tama.getCurrentSickness() < 1 && tama.getCurrentHunger() < tama.getMaxHunger())
		    {
			if (tama.getCurrentHealth() < tama.getMaxHealth())
			{
			    final float battleLevelRatio = 1 - (float) tama.getBattleLevel() / Tamagotchi.MAX_BATTLE_LEVEL;
			    final float hungerRatio = 1 - tama.getCurrentHunger() / tama.getMaxHunger();
			    tama.setCurrentHealth(Math.round(tama.getCurrentHealth() + hungerRatio * .05f * tama.getMaxHealth()));
			    pTimerHandler.setTimerSeconds(battleLevelRatio * 60);
			}

		    }
		}
	    }
	}));

	/**
	 * Handling hunger
	 */
	this.mScene.registerUpdateHandler(new TimerHandler(5 * 60, true, new ITimerCallback()
	{
	    @Override
	    public void onTimePassed(final TimerHandler pTimerHandler)
	    {
		if (tama.getStatus() != Tamagotchi.DEAD && tama.getSprite().hasParent())
		{
		    if (tama.getCurrentHunger() >= tama.getMaxHunger() && tama.getCurrentHealth() > 0)
		    {
			tama.setCurrentHealth(Math.round(tama.getCurrentHealth() - 0.05f * tama.getMaxHealth()));
		    }
		    else
		    {
			tama.setCurrentHunger(Math.round(tama.getCurrentHunger() + 0.05f * tama.getMaxHunger()));
		    }
		}
	    }
	}));

		Log.i(TAG, "Tama timers loaded.");
    }

    private Scene mSplashScene;

    /**
     * Displays a splash screen
     */
    private void showSplashScreen()
    {
	this.mSplashScene = new Scene();
	final BitmapTextureAtlas mSplashTextureAtlas = new BitmapTextureAtlas(512, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("");
	final TextureRegion mSplashTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mSplashTextureAtlas, this, "splash.png", 0, 0);
	final Sprite splashSprite = new Sprite(0, 0, mSplashTextureRegion);
	this.mEngine.getTextureManager().loadTexture(mSplashTextureAtlas);
	this.mSplashScene.attachChild(splashSprite);
	this.mScene.setChildScene(mSplashScene);
	// this.tama.setDefault();
    }

    public void say(String text2say)
    {
	if (soundOn)
	    talker.speak(text2say, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status)
    {
	talker.setPitch(1000f);
	String[] loadedResponses = FileReaderUtil.readFile(this, "files/tamaResponses.txt");
	if (loadedResponses != null)
	    tamaResponses = loadedResponses;
	say("Tamagotchi!");
    }

    /**
     * Demos the weather
     */
    private void runDemo()
    {
	loadWeather(Weather.NONE);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    /**
     * Same as Item class but overrides the onAreaTouched() method to work with game
     * 
     * @author Jonathan
     * 
     */
    private class GameItem extends Item
    {
	public GameItem(Item item)
	{
	    super(item.getX(), item.getY(), item.getTextureRegion(), item.getName(), item.getDescription(), item.getHealth(), item.getHunger(), item.getSickness(), item.getXp(), item.getType(), item.getProtection(), item.getPrice());
	}

	public GameItem(float x, float y, TextureRegion textureRegion)
	{
	    super(x, y, textureRegion);
	}

	public GameItem(float x, float y, TextureRegion textureRegion, String name, int health,
		int hunger, int sickness, int xp)
	{
	    super(x, y, textureRegion, name, health, hunger, sickness, xp);
	}

	public GameItem(float x, float y, TextureRegion textureRegion, String name,
		String description, int health, int hunger, int sickness, int xp)
	{
	    super(x, y, textureRegion, name, description, health, hunger, sickness, xp);
	}

	private boolean touched = false;
	private boolean moved = false;

	@Override
	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
		final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	{
	    if (this.getParent().getParent().isVisible())
	    {
		if (pSceneTouchEvent.isActionDown())
		{
			Log.i(TAG, "Item action down");
		    touched = true;
		    this.setScale(1.5f);
		}
		else if (pSceneTouchEvent.isActionMove())
		{
			Log.i(TAG, "Item action move");
		    if (touched)
		    {
			if (this.getParent().equals(backpackBackground))
			{
			    takeOut = this;
			    runOnUpdateThread(new Runnable()
			    {
				@Override
				public void run()
				{
					Log.i(TAG, "Taking out item");
				    takeOut.detachSelf();
				    topLayer.attachChild(takeOut);
				    takeOut = null;
				}
			    });
			    closeBackpack();
			}
			this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);

			moved = true;
			return true;
		    }
		    else
		    {
			return false;
		    }
		}
		else if (pSceneTouchEvent.isActionUp())
		{
			Log.i(TAG, "Item action up");
		    touched = false;
		    this.setScale(1);
		    if (moved)
		    {
			moved = false;
			if (this.getParent().equals(topLayer))
			{
			    if (this.collidesWith(tama.getSprite()))
			    {
				if (this.getType() == Item.NORMAL)
				{
				    itemToApply = this;
				    showDialog(MainGame.CONFIRM_APPLYITEM);
				}
				else if (this.getType() == Item.EQUIP)
				{
				    equipItem(this, true);
				}
			    }
			    else if (this.collidesWith(emptytrashcan))
			    {
				itemToRemove = this;
				showDialog(MainGame.CONFIRM_REMOVEITEM);
			    }
			    else
			    {
				putBack = this;
				runOnUpdateThread(new Runnable()
				{
				    @Override
				    public void run()
				    {
						Log.i(TAG, "Putting back item");
					putBack.detachSelf();
					backpackBackground.attachChild(putBack);
					putBack = null;
				    }
				}); // End runOnUpdateThread
			    }
			}
		    }
		    else
		    {
			// show item description
			showItemDescription(this);
		    }
		}
		return true;
	    }

	    return false;
	}
    }



public void dayornight(double lat, double lon) {


	GregorianCalendar dateTime = new GregorianCalendar();


	AzimuthZenithAngle solarposition = Grena3.calculateSolarPosition(dateTime, lat, lon, 67);
	Log.i(TAG, "Grena3: " + solarposition.getZenithAngle());
	Log.i(TAG, "Grena3 lat: " + lat + " lon: " + lon);

	AzimuthZenithAngle solarposition2 = SPA.calculateSolarPosition(dateTime, lat, lon,
			190, // elevation
			67, // delta T
			1010, // avg. air pressure
			11); // avg. air temperature
	Log.i(TAG, "SPA (more acc but slow): " + solarposition2.getZenithAngle());
	Log.i(TAG, "SPA lat: " + lat + " lon: " + lon);

	ZENITH = solarposition.getZenithAngle();


	if (ZENITH < 90.8) {
		Log.i(TAG, "day");
		//make sure to unload all layers first
		if (civilOverlayRect != null) {
			civilOverlayRect.detachSelf();
		}
		if (nauticalOverlayRect != null) {
			nauticalOverlayRect.detachSelf();
		}
		if (astroOverlayRect != null) {
			astroOverlayRect.detachSelf();
		}
		if (nightOverlayRect != null) {
			nightOverlayRect.detachSelf();
		}
	}

	if (ZENITH >= 90.8 && ZENITH < 96) {
		Log.i(TAG, "civil");

		//make sure to unload all layers first
		if (civilOverlayRect != null) {
			civilOverlayRect.detachSelf();
		}
		if (nauticalOverlayRect != null) {
			nauticalOverlayRect.detachSelf();
		}
		if (astroOverlayRect != null) {
			astroOverlayRect.detachSelf();
		}
		if (nightOverlayRect != null) {
			nightOverlayRect.detachSelf();
		}

		if (civilOverlayRect == null) {
			civilOverlayRect = new Rectangle(0, 0, cameraWidth, cameraHeight);
			civilOverlayRect.setColor(0, 0, 0, 0.35f);
		}
		if (!civilOverlayRect.hasParent())
			bottomLayer.attachChild(civilOverlayRect);
	}

	if (ZENITH >= 96 && ZENITH < 102) {
		Log.i(TAG, "nautical");

		//make sure to unload all layers first
		if (civilOverlayRect != null) {
			civilOverlayRect.detachSelf();
		}
		if (nauticalOverlayRect != null) {
			nauticalOverlayRect.detachSelf();
		}
		if (astroOverlayRect != null) {
			astroOverlayRect.detachSelf();
		}
		if (nightOverlayRect != null) {
			nightOverlayRect.detachSelf();
		}

		if (nauticalOverlayRect == null) {
			nauticalOverlayRect = new Rectangle(0, 0, cameraWidth, cameraHeight);
			nauticalOverlayRect.setColor(0, 0, 0, 0.50f);
		}
		if (!nauticalOverlayRect.hasParent())
			bottomLayer.attachChild(nauticalOverlayRect);
	}

	if (ZENITH >= 102 && ZENITH < 108) {
		Log.i(TAG, "astronomical");

		//make sure to unload all layers first
		if (civilOverlayRect != null) {
			civilOverlayRect.detachSelf();
		}
		if (nauticalOverlayRect != null) {
			nauticalOverlayRect.detachSelf();
		}
		if (astroOverlayRect != null) {
			astroOverlayRect.detachSelf();
		}
		if (nightOverlayRect != null) {
			nightOverlayRect.detachSelf();
		}

		if (astroOverlayRect == null) {
			astroOverlayRect = new Rectangle(0, 0, cameraWidth, cameraHeight);
			astroOverlayRect.setColor(0, 0, 0, 0.65f);
		}
		if (!astroOverlayRect.hasParent())
			bottomLayer.attachChild(astroOverlayRect);
	}

	if (ZENITH >= 108) {
		Log.i(TAG, "night");

		//make sure to unload all layers first
		if (civilOverlayRect != null) {
			civilOverlayRect.detachSelf();
		}
		if (nauticalOverlayRect != null) {
			nauticalOverlayRect.detachSelf();
		}
		if (astroOverlayRect != null) {
			astroOverlayRect.detachSelf();
		}
		if (nightOverlayRect != null) {
			nightOverlayRect.detachSelf();
		}

		if (nightOverlayRect == null) {
			nightOverlayRect = new Rectangle(0, 0, cameraWidth, cameraHeight);
			nightOverlayRect.setColor(0, 0, 0, 0.75f);
		}
		if (!nightOverlayRect.hasParent())
			bottomLayer.attachChild(nightOverlayRect);
	}



}



	private void initializeGoogleAPI() {
		Log.i(TAG, "initializeGoogleAPI()");
		if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == 0) {
			GoogleApiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
			createLocationRequest();
		}
	}

	private void createLocationRequest() {
		mLocationRequest = new LocationRequest();
		mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
		mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
		mLocationRequest.setPriority(100);
	}

	private void startGPS() {
		Log.i(TAG, "startUpdates()");
		LocationServices.FusedLocationApi.requestLocationUpdates(GoogleApiClient, mLocationRequest, (LocationListener) this);
	}

	private void stopGPS() {
		Log.i(TAG, "stopUpdates()");
		LocationServices.FusedLocationApi.removeLocationUpdates(GoogleApiClient, (LocationListener) this);
	}

	public void onConnected(Bundle connectionHint) {
		Log.i(TAG, "Connected to GoogleApiClient");
		if (mCurrentLocation == null) {
			Log.i(TAG, "mCurrentLocation == null");
			mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(GoogleApiClient);
		} else {
			Log.i(TAG, "mCurrentLocation not null");
			mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(GoogleApiClient);
			lat = mCurrentLocation.getLatitude();
			lon = mCurrentLocation.getLongitude();
			Log.i(TAG, "onConnected lat: " + lat + " lon: " + lon);
			getweather();
		}
		startGPS();
	}

	public void onLocationChanged(Location location) {
		mCurrentLocation = location;
		lat = mCurrentLocation.getLatitude();
		lon = mCurrentLocation.getLongitude();
		Log.i(TAG, "onLocationChanged lat: " + lat + " lon: " + lon);
		getweather();
	}

	public void onConnectionSuspended(int cause) {
		Log.i(TAG, "Connection suspended");
		GoogleApiClient.connect();
	}

	public void onConnectionFailed(ConnectionResult result) {
		Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
	}

	/*
	*

	public static final int DRIZZLE = 0;
    public static final int HAIL = 6;
    public static final int HYRAIN = 3;
    public static final int HYSNOW = 9;
    public static final int ICEPELLETS = 5;
    public static final int LTRAIN = 1;
    public static final int LTSNOW = 7;
    public static final int NONE = -1;
    public static final int RAIN = 2;
    public static final int SNOW = 8;
    public static final int THUNDERSTORM = 4;
    public static final int UNKNOWN = 10;

	* */

	public void getweather() {
		Log.i(TAG, "My current location is: Latitude = " + lat + ", Longitude = " + lon);
		dayornight(lat, lon);
		if (weatherText != null) {
			Log.i(TAG, "weathertext is not null... should remove it.");
			runOnUpdateThread(new Runnable() {
				public void run() {
					MainGame.this.weatherText.detachSelf();
					MainGame.this.weatherText = null;
				}
			});
		}
		if(isOnline()) {
			cc = WeatherRetriever.getCurrentConditions(lat, lon);
			Log.i(TAG, "cc: "+cc);
		} else {
			cc = null;
		}
		if (cc != null) {
			Log.i(TAG, cc.toString());
			weatherText = new ChangeableText(15.0f, (float) (pBottomBound - 40), mFont, cc.getCondition() + ", " + cc.getTempF() + "°F");
			mainLayer.attachChild(weatherText);
			int weatherType = -1;
			String condition = cc.getCondition().toLowerCase();
			if (condition.contains("rain")) {
				weatherType = 2;
			} else if (condition.contains("drizzle")) {
				weatherType = 0;
			} else if (condition.contains("snow")) {
				weatherType = 8;
			}
			loadWeather(weatherType);
		} else {
			weatherText = new ChangeableText(15.0f, (float) (pBottomBound - 40), mFont, "Weather not available");
			mainLayer.attachChild(weatherText);
		}
	}


	///gesturelistener///
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		this.mDetector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

		final float scale = getResources().getDisplayMetrics().density;
		if (abs(e1.getY() - e2.getY()) > (40.0 * scale)) {
			//BaseAndEngineGame.openOptionsMenu();
			Log.i(TAG, "onFling - swiped!!!");
		}
		return true;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}



}


