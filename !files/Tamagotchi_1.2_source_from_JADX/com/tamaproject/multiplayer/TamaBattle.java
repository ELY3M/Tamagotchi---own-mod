package com.tamaproject.multiplayer;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tamaproject.BaseAndEngineGame;
import com.tamaproject.adt.messages.client.ClientMessageFlags;
import com.tamaproject.adt.messages.server.ConnectionCloseServerMessage;
import com.tamaproject.adt.messages.server.ServerMessageFlags;
import com.tamaproject.multiplayer.BattleMessages.RequestPlayerIdClientMessage;
import com.tamaproject.multiplayer.BattleServer.IBattleServerListener;
import com.tamaproject.multiplayer.BattleServerConnector.IBattleServerConnectorListener;
import com.tamaproject.util.MultiplayerConstants;
import com.tamaproject.util.TamaBattleConstants;
import com.tamaproject.util.TextUtil;
import com.tamaproject.util.TextureUtil;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import org.acra.ACRAConstants;
import org.anddev.andengine.audio.music.Music;
import org.anddev.andengine.audio.music.MusicFactory;
import org.anddev.andengine.audio.sound.Sound;
import org.anddev.andengine.audio.sound.SoundFactory;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.hud.controls.AnalogOnScreenControl;
import org.anddev.andengine.engine.camera.hud.controls.AnalogOnScreenControl.IAnalogOnScreenControlListener;
import org.anddev.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.ColorModifier;
import org.anddev.andengine.entity.modifier.LoopEntityModifier;
import org.anddev.andengine.entity.modifier.RotationModifier;
import org.anddev.andengine.entity.modifier.ScaleModifier;
import org.anddev.andengine.entity.modifier.SequenceEntityModifier;
import org.anddev.andengine.entity.primitive.Line;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.background.RepeatingSpriteBackground;
import org.anddev.andengine.entity.scene.background.SpriteBackground;
import org.anddev.andengine.entity.shape.IShape;
import org.anddev.andengine.entity.shape.Shape;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.BaseSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.extension.input.touch.controller.MultiTouch;
import org.anddev.andengine.extension.input.touch.controller.MultiTouchController;
import org.anddev.andengine.extension.input.touch.exception.MultiTouchException;
import org.anddev.andengine.extension.multiplayer.protocol.client.connector.ServerConnector;
import org.anddev.andengine.extension.multiplayer.protocol.client.connector.SocketConnectionServerConnector.ISocketConnectionServerConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.server.SocketServer;
import org.anddev.andengine.extension.multiplayer.protocol.server.SocketServer.ISocketServerListener;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.SocketConnectionClientConnector;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.SocketConnectionClientConnector.ISocketConnectionClientConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.shared.SocketConnection;
import org.anddev.andengine.extension.multiplayer.protocol.util.WifiUtils;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.AssetBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.HorizontalAlign;

public class TamaBattle extends BaseAndEngineGame implements ClientMessageFlags, ServerMessageFlags, TamaBattleConstants, IBattleServerConnectorListener, IBattleServerListener, BattleMessages {
    private static BulletPool BULLET_POOL = null;
    private static int CAMERA_HEIGHT = 480;
    private static int CAMERA_WIDTH = 800;
    private static final String LOCALHOST_IP = "127.0.0.1";
    private String IP;
    private Music backgroundMusic;
    private int battleLevel = 0;
    private Entity bottomLayer;
    private final List<Sprite> bulletsToRemove = new ArrayList();
    private Sprite crosshairSprite;
    private Scene deathMatchWarningScene;
    private Scene endScene;
    private Sound fightSound;
    private int health = 0;
    private Sound hitSound;
    private final HashMap<String, Integer> ipArray = new HashMap();
    private Text ipText;
    private boolean isDeathMatch = false;
    private boolean isServer = false;
    public Hashtable<String, TextureRegion> listTR;
    private boolean loadComplete = false;
    private Music lobbyMusic;
    private Scene lobbyScene;
    private Text loseText;
    private int lowestBattleLevel = 1;
    private RepeatingSpriteBackground mBackground;
    private BattleServer mBattleServer;
    private Camera mCamera;
    private Font mFont;
    private BitmapTextureAtlas mFontTexture;
    private TextureRegion mOnScreenControlBaseTextureRegion;
    private TextureRegion mOnScreenControlKnobTextureRegion;
    private BitmapTextureAtlas mOnScreenControlTexture;
    private final SparseArray<AnimatedSprite> mPlayerSprites = new SparseArray();
    private BattleServerConnector mServerConnector;
    private String mServerIP = "127.0.0.1";
    private final SparseArray<Sprite> mSprites = new SparseArray();
    private BitmapTextureAtlas mTamaBitmapTextureAtlas;
    private TiledTextureRegion mTamaTextureRegion;
    private int maxHealth = 0;
    private AnimatedSprite me;
    private int numPlayers = 0;
    private SpriteBackground orangeBackground;
    private Sound pewSound;
    int playerNumber = -1;
    private Scene scene;
    private int team1 = 0;
    private int team2 = 0;
    private final HashMap<String, Text> textIpArray = new HashMap();
    private Entity topLayer;
    private boolean voteDeathMatch = false;
    private Scene waitingScene;
    private Text winText;

    class C05808 implements OnClickListener {
        C05808() {
        }

        public void onClick(DialogInterface pDialog, int pWhich) {
            TamaBattle.this.finish();
        }
    }

    class C05819 implements OnClickListener {
        C05819() {
        }

        public void onClick(DialogInterface pDialog, int pWhich) {
            TamaBattle.this.finish();
        }
    }

    class C08966 implements IUpdateHandler {
        C08966() {
        }

        public void reset() {
        }

        public void onUpdate(float arg0) {
            synchronized (TamaBattle.this.bulletsToRemove) {
                for (Sprite s : TamaBattle.this.bulletsToRemove) {
                    TamaBattle.this.mSprites.remove(((BulletInfo) s.getUserData()).getID());
                    TamaBattle.this.sendBulletToBulletPool(s);
                }
                TamaBattle.this.bulletsToRemove.clear();
            }
            if (TamaBattle.this.team1 <= 0) {
                if (TamaBattle.this.playerNumber % 2 == 0) {
                    TamaBattle.this.showWinScreen(true);
                } else {
                    TamaBattle.this.showWinScreen(false);
                }
            } else if (TamaBattle.this.team2 > 0) {
            } else {
                if (TamaBattle.this.playerNumber % 2 != 0) {
                    TamaBattle.this.showWinScreen(true);
                } else {
                    TamaBattle.this.showWinScreen(false);
                }
            }
        }
    }

    class C08977 implements IOnSceneTouchListener {
        C08977() {
        }

        public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
            if (pSceneTouchEvent.isActionDown()) {
                try {
                    AnimatedSprite p = (AnimatedSprite) TamaBattle.this.mPlayerSprites.get(TamaBattle.this.playerNumber);
                    if ((pSceneTouchEvent.getX() > (p.getX() + p.getWidth()) + 20.0f && TamaBattle.this.playerNumber % 2 != 0) || (pSceneTouchEvent.getX() < ((AnimatedSprite) TamaBattle.this.mPlayerSprites.get(TamaBattle.this.playerNumber)).getX() - 20.0f && TamaBattle.this.playerNumber % 2 == 0)) {
                        Debug.m59d("Fire bullet!");
                        TamaBattle.this.crosshairSprite.setPosition(pSceneTouchEvent.getX() - (TamaBattle.this.crosshairSprite.getWidth() * 0.5f), pSceneTouchEvent.getY() - (TamaBattle.this.crosshairSprite.getHeight() * 0.5f));
                        TamaBattle.this.crosshairSprite.setVisible(true);
                        TamaBattle.this.mServerConnector.sendFireBulletMessage(TamaBattle.this.playerNumber, pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
    }

    private class ServerStateListener implements ISocketServerListener<SocketConnectionClientConnector> {
        private ServerStateListener() {
        }

        public void onStarted(SocketServer<SocketConnectionClientConnector> socketServer) {
        }

        public void onTerminated(SocketServer<SocketConnectionClientConnector> socketServer) {
        }

        public void onException(SocketServer<SocketConnectionClientConnector> socketServer, Throwable pThrowable) {
            Debug.m63e(pThrowable);
        }
    }

    private class ClientConnectorListener implements ISocketConnectionClientConnectorListener {
        private ClientConnectorListener() {
        }

        public void onStarted(ClientConnector<SocketConnection> pConnector) {
            Debug.m59d("SERVER: Client connected: " + TextUtil.getIpAndPort(pConnector));
        }

        public void onTerminated(ClientConnector<SocketConnection> pConnector) {
            final String ip = TextUtil.getIpAndPort(pConnector);
            Debug.m59d("SERVER: Client disconnected: " + ip);
            TamaBattle.this.mBattleServer.sendRemovePlayerMessage(((Integer) TamaBattle.this.ipArray.get(ip)).intValue());
            TamaBattle.this.runOnUpdateThread(new Runnable() {
                public void run() {
                    try {
                        ((Text) TamaBattle.this.textIpArray.get(ip)).detachSelf();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private class ServerConnectorListener implements ISocketConnectionServerConnectorListener {
        private ServerConnectorListener() {
        }

        public void onStarted(ServerConnector<SocketConnection> serverConnector) {
        }

        public void onTerminated(ServerConnector<SocketConnection> serverConnector) {
            TamaBattle.this.finish();
        }
    }

    public Engine onLoadEngine() {
        setVolumeControlStream(3);
        showDialog(0);
        this.mCamera = new Camera(0.0f, 0.0f, (float) CAMERA_WIDTH, (float) CAMERA_HEIGHT);
        Engine engine = new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy((float) CAMERA_WIDTH, (float) CAMERA_HEIGHT), this.mCamera).setNeedsMusic(true).setNeedsSound(true));
        try {
            if (MultiTouch.isSupported(this)) {
                engine.setTouchController(new MultiTouchController());
                if (!MultiTouch.isSupportedDistinct(this)) {
                    Toast.makeText(this, "MultiTouch detected, but your device has problems distinguishing between fingers.\n\nControls are placed at different vertical locations.", 1).show();
                }
                loadOptions();
                return engine;
            }
            Toast.makeText(this, "Sorry your device does NOT support MultiTouch!\n\n(Falling back to SingleTouch.)", 1).show();
            loadOptions();
            return engine;
        } catch (MultiTouchException e) {
            Toast.makeText(this, "Sorry your Android Version does NOT support MultiTouch!\n\n(Falling back to SingleTouch.)", 1).show();
        }
    }

    public void onLoadResources() {
        this.listTR = TextureUtil.loadTextures(this, this.mEngine, new String[]{new String("gfx/")});
        BULLET_POOL = new BulletPool((TextureRegion) this.listTR.get("particle_point.png"));
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("animated_gfx/");
        this.mTamaBitmapTextureAtlas = new BitmapTextureAtlas(128, 1024, TextureOptions.BILINEAR);
        this.mTamaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mTamaBitmapTextureAtlas, this, "snorlax.png", 0, 0, 1, 8);
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        this.mOnScreenControlTexture = new BitmapTextureAtlas(256, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.mOnScreenControlBaseTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mOnScreenControlTexture, this, "onscreen_control_base.png", 0, 0);
        this.mOnScreenControlKnobTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mOnScreenControlTexture, this, "onscreen_control_knob.png", 128, 0);
        this.mFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.mFont = FontFactory.createFromAsset(this.mFontTexture, this, "ITCKRIST.TTF", 24.0f, true, -1);
        this.mEngine.getTextureManager().loadTexture(this.mFontTexture);
        this.mEngine.getFontManager().loadFont(this.mFont);
        this.mEngine.getTextureManager().loadTextures(this.mTamaBitmapTextureAtlas, this.mOnScreenControlTexture);
        this.mBackground = new RepeatingSpriteBackground((float) CAMERA_WIDTH, (float) CAMERA_HEIGHT, this.mEngine.getTextureManager(), new AssetBitmapTextureAtlasSource(this, "gfx/background_grass_inverted.png"));
        Sprite orange = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("orange.png"));
        orange.setSize((float) CAMERA_WIDTH, (float) CAMERA_HEIGHT);
        this.orangeBackground = new SpriteBackground(orange);
        SoundFactory.setAssetBasePath("mfx/");
        try {
            this.pewSound = SoundFactory.createSoundFromAsset(this.mEngine.getSoundManager(), this, "laser.ogg");
            this.hitSound = SoundFactory.createSoundFromAsset(this.mEngine.getSoundManager(), this, "hit.ogg");
            this.fightSound = SoundFactory.createSoundFromAsset(this.mEngine.getSoundManager(), this, "fight.mp3");
        } catch (Throwable e) {
            Debug.m63e(e);
        }
        MusicFactory.setAssetBasePath("mfx/");
        try {
            this.backgroundMusic = MusicFactory.createMusicFromAsset(this.mEngine.getMusicManager(), this, "bionic_belly_button.mp3");
            this.backgroundMusic.setLooping(true);
        } catch (Throwable e2) {
            Debug.m63e(e2);
        }
        try {
            this.lobbyMusic = MusicFactory.createMusicFromAsset(this.mEngine.getMusicManager(), this, "playing_with_power.mp3");
            this.lobbyMusic.setLooping(true);
        } catch (Throwable e22) {
            Debug.m63e(e22);
        }
    }

    public void pauseSound() {
        if (this.lobbyMusic.isPlaying()) {
            this.lobbyMusic.pause();
        }
        if (this.backgroundMusic.isPlaying()) {
            this.backgroundMusic.pause();
        }
    }

    public void resumeSound() {
        if (this.mEngine.getScene().equals(this.lobbyScene)) {
            this.lobbyMusic.resume();
        } else {
            this.backgroundMusic.resume();
        }
    }

    private void waitTime(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void loadDeathMatchWarningScene() {
        this.deathMatchWarningScene = new Scene();
        this.deathMatchWarningScene.setBackground(this.orangeBackground);
        Text warningText = new Text(0.0f, 0.0f, this.mFont, "Warning, death match is enabled!\nIf your Tamagotchi dies the matrix, it dies in real life.", HorizontalAlign.CENTER);
        warningText.setPosition(((float) (CAMERA_WIDTH / 2)) - (warningText.getWidth() / 2.0f), ((float) (CAMERA_HEIGHT / 2)) - (warningText.getHeight() / 2.0f));
        Sprite dmIcon = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("skull.png"));
        dmIcon.setPosition(((float) (CAMERA_WIDTH / 2)) - (dmIcon.getWidth() / 2.0f), (warningText.getY() + warningText.getHeight()) + BitmapDescriptorFactory.HUE_ORANGE);
        this.deathMatchWarningScene.attachChild(dmIcon);
        this.deathMatchWarningScene.attachChild(warningText);
    }

    private void loadLobbyScene() {
        Debug.m59d("Creating lobby...");
        this.lobbyScene = new Scene();
        this.lobbyScene.setBackground(this.orangeBackground);
        this.lobbyScene.setBackgroundEnabled(true);
        this.ipText = new Text(15.0f, 15.0f, this.mFont, "Multiplayer Battle Mode - Server IP: " + this.IP);
        if (!this.isServer) {
            try {
                this.lobbyScene.attachChild(new Text(this.ipText.getX(), (this.ipText.getY() + this.ipText.getHeight()) + 10.0f, this.mFont, "My IP: " + WifiUtils.getWifiIPv4Address(this)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.lobbyScene.attachChild(this.ipText);
        final Sprite noSprite = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("not_allowed.png"));
        if (this.voteDeathMatch) {
            noSprite.setVisible(false);
        } else {
            noSprite.setVisible(true);
        }
        Sprite voteDeathMatchButton = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("skull.png")) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown()) {
                    if (TamaBattle.this.voteDeathMatch) {
                        TamaBattle.this.voteDeathMatch = false;
                        noSprite.setVisible(true);
                    } else {
                        TamaBattle.this.voteDeathMatch = true;
                        noSprite.setVisible(false);
                    }
                    TamaBattle.this.mServerConnector.sendVoteDeathMatch(TamaBattle.this.voteDeathMatch);
                } else if (pSceneTouchEvent.isActionUp()) {
                }
                return true;
            }
        };
        voteDeathMatchButton.attachChild(noSprite);
        voteDeathMatchButton.setPosition(40.0f, (((float) CAMERA_HEIGHT) - voteDeathMatchButton.getHeight()) - 40.0f);
        this.lobbyScene.attachChild(voteDeathMatchButton);
        this.lobbyScene.registerTouchArea(voteDeathMatchButton);
        Text text;
        Sprite sprite;
        if (this.isServer) {
            text = new Text(0.0f, 0.0f, this.mFont, "Waiting for players to join...");
            text.setPosition((((float) CAMERA_WIDTH) - text.getWidth()) - 20.0f, (((float) CAMERA_HEIGHT) - text.getHeight()) - 20.0f);
            text = new Text(20.0f, 20.0f, this.mFont, "Start Game");
            final Rectangle startButton = new Rectangle(0.0f, 0.0f, text.getWidth() + 40.0f, text.getHeight() + 40.0f) {
                public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                    if (!isVisible()) {
                        return false;
                    }
                    if (pSceneTouchEvent.isActionDown()) {
                        Debug.m59d("Touched start button...");
                        setColor(0.0f, 1.0f, 0.0f);
                        return true;
                    } else if (!pSceneTouchEvent.isActionUp()) {
                        return true;
                    } else {
                        if (TamaBattle.this.mBattleServer.getNumPlayers() == TamaBattle.this.mBattleServer.getDeathMatchVotes()) {
                            TamaBattle.this.mBattleServer.sendDeathMatchMessage(true);
                        }
                        TamaBattle.this.mBattleServer.sendStartMessage();
                        return true;
                    }
                }
            };
            startButton.setVisible(false);
            final Text text2 = text;
            startButton.registerUpdateHandler(new IUpdateHandler() {
                public void reset() {
                }

                public void onUpdate(float arg0) {
                    if (!startButton.isVisible() && TamaBattle.this.mBattleServer.getLowestTeamCount() >= 1) {
                        startButton.setVisible(true);
                        text2.setVisible(false);
                    } else if (startButton.isVisible() && TamaBattle.this.mBattleServer.getLowestTeamCount() < 1) {
                        startButton.setVisible(false);
                        text2.setVisible(true);
                    }
                }
            });
            startButton.setColor(1.0f, 0.0f, 0.0f);
            startButton.setPosition((((float) CAMERA_WIDTH) - startButton.getWidth()) - 20.0f, (((float) CAMERA_HEIGHT) - startButton.getHeight()) - 20.0f);
            startButton.attachChild(text);
            this.lobbyScene.attachChild(text);
            this.lobbyScene.registerTouchArea(startButton);
            this.lobbyScene.attachChild(startButton);
            sprite = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("tama.png"));
            sprite.setPosition((((float) CAMERA_WIDTH) - sprite.getWidth()) - BitmapDescriptorFactory.HUE_YELLOW, BitmapDescriptorFactory.HUE_YELLOW);
            sprite.registerEntityModifier(new LoopEntityModifier(new SequenceEntityModifier(new RotationModifier(4.0f, 0.0f, -360.0f))));
            this.lobbyScene.attachChild(sprite);
        } else {
            text = new Text(0.0f, 0.0f, this.mFont, "You are player " + this.playerNumber + ", Team " + (this.playerNumber % 2 == 0 ? 2 : 1) + "\nWaiting for host to start game...");
            text.setPosition((((float) CAMERA_WIDTH) * 0.5f) - (text.getWidth() * 0.5f), ((float) (CAMERA_HEIGHT / 2)) - (text.getHeight() / 2.0f));
            sprite = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("tama.png"));
            sprite.setPosition(((float) (CAMERA_WIDTH / 2)) - (sprite.getWidth() / 2.0f), (text.getY() + text.getHeight()) + 50.0f);
            sprite.registerEntityModifier(new LoopEntityModifier(new SequenceEntityModifier(new RotationModifier(4.0f, 0.0f, -360.0f))));
            this.lobbyScene.attachChild(sprite);
            this.lobbyScene.attachChild(text);
        }
        this.lobbyScene.setTouchAreaBindingEnabled(true);
    }

    private void loadEndScene() {
        this.endScene = new Scene();
        this.endScene.setBackground(this.orangeBackground);
        this.winText = new Text(0.0f, 0.0f, this.mFont, "You win!");
        this.winText.setScale(1.5f);
        this.winText.setVisible(false);
        this.winText.setPosition(((float) (CAMERA_WIDTH / 2)) - (this.winText.getWidth() / 2.0f), ((float) (CAMERA_HEIGHT / 2)) - this.winText.getHeight());
        this.loseText = new Text(0.0f, 0.0f, this.mFont, "You lose!");
        this.loseText.setScale(1.5f);
        this.loseText.setVisible(false);
        this.loseText.setPosition(((float) (CAMERA_WIDTH / 2)) - (this.winText.getWidth() / 2.0f), ((float) (CAMERA_HEIGHT / 2)) - this.loseText.getHeight());
        Text continueText = new Text(15.0f, 10.0f, this.mFont, "Continue");
        final Rectangle continueButton = new Rectangle(0.0f, 0.0f, continueText.getWidth() + BitmapDescriptorFactory.HUE_ORANGE, continueText.getHeight() + 20.0f) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown()) {
                    Debug.m59d("Touched continue button...");
                    setColor(0.0f, 1.0f, 0.0f);
                } else if (pSceneTouchEvent.isActionUp()) {
                    TamaBattle.this.finish();
                }
                return true;
            }
        };
        continueButton.setColor(1.0f, 0.0f, 0.0f);
        continueButton.setPosition(((float) (CAMERA_WIDTH / 2)) - (continueButton.getWidth() / 2.0f), (this.winText.getY() + this.winText.getHeight()) + BitmapDescriptorFactory.HUE_ORANGE);
        continueButton.attachChild(continueText);
        if (this.isServer) {
            this.endScene.registerUpdateHandler(new IUpdateHandler() {
                public void reset() {
                }

                public void onUpdate(float arg0) {
                    if (TamaBattle.this.team1 <= 0 || TamaBattle.this.team2 <= 0) {
                        TamaBattle.this.endScene.attachChild(continueButton);
                        TamaBattle.this.endScene.unregisterUpdateHandler(this);
                    }
                }
            });
        }
        this.endScene.attachChild(this.winText);
        this.endScene.attachChild(this.loseText);
        if (!this.isServer) {
            this.endScene.attachChild(continueButton);
        }
        this.endScene.registerTouchArea(continueButton);
        this.endScene.setTouchAreaBindingEnabled(true);
    }

    private void loadWaitingScene() {
        this.waitingScene = new Scene();
        this.waitingScene.setBackground(this.orangeBackground);
        Text waitingText = new Text(0.0f, 0.0f, this.mFont, "Waiting for connection...");
        waitingText.setPosition(((float) (CAMERA_WIDTH / 2)) - (waitingText.getWidth() / 2.0f), ((float) (CAMERA_HEIGHT / 2)) - waitingText.getHeight());
        this.waitingScene.attachChild(waitingText);
    }

    public Scene onLoadScene() {
        this.mEngine.registerUpdateHandler(new FPSLogger());
        enableVibrator();
        loadLobbyScene();
        loadDeathMatchWarningScene();
        loadEndScene();
        loadWaitingScene();
        this.scene = new Scene();
        this.scene.setBackground(this.mBackground);
        this.topLayer = new Entity();
        this.bottomLayer = new Entity();
        this.scene.attachChild(this.bottomLayer);
        this.scene.attachChild(this.topLayer);
        this.ipText = new Text(15.0f, 15.0f, this.mFont, "Server IP: " + this.IP);
        this.topLayer.attachChild(this.ipText);
        this.crosshairSprite = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("crosshair.png"));
        this.crosshairSprite.setVisible(false);
        this.topLayer.attachChild(this.crosshairSprite);
        this.bottomLayer.attachChild(new Line((float) (CAMERA_WIDTH / 2), 0.0f, (float) (CAMERA_WIDTH / 2), (float) CAMERA_HEIGHT));
        this.scene.registerUpdateHandler(new C08966());
        this.scene.setOnSceneTouchListener(new C08977());
        this.scene.setTouchAreaBindingEnabled(true);
        return this.scene;
    }

    public void onLoadComplete() {
        this.loadComplete = true;
        if (this.playerNumber < 0) {
            this.mEngine.setScene(this.waitingScene);
        } else {
            this.mEngine.setScene(this.lobbyScene);
        }
        if (this.soundOn) {
            this.lobbyMusic.play();
        }
    }

    protected Dialog onCreateDialog(int pID) {
        switch (pID) {
            case 0:
                return new Builder(this).setIcon(17301659).setTitle("Start new multiplayer battle").setCancelable(false).setPositiveButton("Join", new OnClickListener() {
                    public void onClick(DialogInterface pDialog, int pWhich) {
                        TamaBattle.this.showDialog(1);
                    }
                }).setNegativeButton("Host", new OnClickListener() {
                    public void onClick(DialogInterface pDialog, int pWhich) {
                        TamaBattle.this.initServerAndClient();
                    }
                }).create();
            case 1:
                String savedIP = getPreferences(0).getString("BATTLEIP", "");
                final EditText ipEditText = new EditText(this);
                ipEditText.setText(savedIP);
                return new Builder(this).setIcon(17301659).setTitle("Enter Server-IP ...").setCancelable(false).setView(ipEditText).setPositiveButton("Connect", new OnClickListener() {
                    public void onClick(DialogInterface pDialog, int pWhich) {
                        TamaBattle.this.mServerIP = ipEditText.getText().toString();
                        TamaBattle.this.savePreferences("BATTLEIP", ipEditText.getText().toString());
                        TamaBattle.this.IP = ipEditText.getText().toString();
                        if (ipEditText.getText().length() == 0) {
                            TamaBattle.this.showDialog(0);
                        } else {
                            TamaBattle.this.initClient();
                        }
                    }
                }).setNegativeButton(ACRAConstants.DEFAULT_DIALOG_NEGATIVE_BUTTON_TEXT, new C05819()).create();
            case 2:
                try {
                    this.IP = WifiUtils.getWifiIPv4Address(this);
                    return new Builder(this).setIcon(17301659).setTitle("Your Server-IP ...").setCancelable(false).setMessage("The IP of your Server is:\n" + WifiUtils.getWifiIPv4Address(this)).setPositiveButton(ACRAConstants.DEFAULT_DIALOG_POSITIVE_BUTTON_TEXT, null).create();
                } catch (UnknownHostException e) {
                    return new Builder(this).setIcon(ACRAConstants.DEFAULT_DIALOG_ICON).setTitle("Your Server-IP ...").setCancelable(false).setMessage("Error retrieving IP of your Server: " + e).setPositiveButton(ACRAConstants.DEFAULT_DIALOG_POSITIVE_BUTTON_TEXT, new C05808()).create();
                }
            default:
                return super.onCreateDialog(pID);
        }
    }

    protected void onDestroy() {
        Debug.m59d("Running onDestroy()...");
        if (this.mBattleServer != null) {
            try {
                this.mBattleServer.sendBroadcastServerMessage(new ConnectionCloseServerMessage());
            } catch (Throwable e) {
                Debug.m63e(e);
            }
            this.mBattleServer.terminate();
        }
        if (this.mServerConnector != null) {
            this.mServerConnector.terminate();
        }
        super.onDestroy();
        Debug.m59d("Finished onDestroy()...");
    }

    public void finish() {
        Debug.m59d("Running finish()...");
        try {
            Intent returnIntent = new Intent();
            if (this.winText.isVisible() && this.numPlayers > 1) {
                Debug.m59d("Winner rewarded xp");
                returnIntent.putExtra(MultiplayerConstants.XP_GAIN, this.lowestBattleLevel * 10);
            } else if (this.loseText.isVisible() && this.numPlayers > 1) {
                Debug.m59d("Loser rewarded xp");
                returnIntent.putExtra(MultiplayerConstants.XP_GAIN, this.lowestBattleLevel * 1);
            }
            if (this.isDeathMatch) {
                Debug.m59d("Deathmatch enabled, setting health to " + this.health + "...");
                returnIntent.putExtra(MultiplayerConstants.HEALTH, this.health);
                returnIntent.putExtra(MultiplayerConstants.DEATHMATCH, true);
            }
            setResult(-1, returnIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.finish();
    }

    private void initServerAndClient() {
        initServer();
        try {
            Thread.sleep(500);
        } catch (Throwable t) {
            Debug.m63e(t);
        }
        try {
            this.IP = WifiUtils.getWifiIPv4Address(this);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        initClient();
    }

    private void initServer() {
        this.mBattleServer = new BattleServer(new ClientConnectorListener(), new ServerStateListener(), this);
        this.mBattleServer.start();
        this.isServer = true;
    }

    private void initClient() {
        try {
            this.mServerConnector = new BattleServerConnector(this.mServerIP, new ServerConnectorListener(), this);
            ((SocketConnection) this.mServerConnector.getConnection()).start();
            Intent intent = getIntent();
            this.health = intent.getIntExtra(MultiplayerConstants.HEALTH, 0);
            this.maxHealth = intent.getIntExtra(MultiplayerConstants.MAX_HEALTH, 0);
            this.battleLevel = intent.getIntExtra(MultiplayerConstants.BATTLE_LEVEL, 0);
            this.mServerConnector.sendClientMessage(new RequestPlayerIdClientMessage());
        } catch (Throwable t) {
            Debug.m63e(t);
        }
    }

    private void sendBulletToBulletPool(Sprite pBulletSprite) {
        synchronized (BULLET_POOL) {
            pBulletSprite.clearUpdateHandlers();
            BULLET_POOL.recyclePoolItem(pBulletSprite);
        }
    }

    private Sprite getBulletFromBulletPool() {
        Sprite sprite;
        synchronized (BULLET_POOL) {
            sprite = (Sprite) BULLET_POOL.obtainPoolItem();
        }
        return sprite;
    }

    public void showWinScreen(boolean win) {
        if (!this.mEngine.getScene().equals(this.endScene)) {
            if (win) {
                this.winText.setVisible(true);
            } else {
                this.loseText.setVisible(true);
            }
            this.mEngine.setScene(this.endScene);
        }
    }

    private void log(String pMessage) {
        Debug.m59d(pMessage);
    }

    public void toast(final String pMessage) {
        log(pMessage);
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(TamaBattle.this, pMessage, 0).show();
            }
        });
    }

    private void savePreferences(String key, String value) {
        Editor editor = getPreferences(0).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void setPlayerData(int playerID, int health, int maxHealth, int battleLevel) {
        try {
            if (this.playerNumber == playerID) {
                this.health = health;
            }
            Debug.m59d("Waiting for sprite to be ready...");
            while (this.mPlayerSprites.get(playerID) == null) {
                waitTime(500);
            }
            Debug.m59d("Sprite ready!");
            AnimatedSprite sprite = (AnimatedSprite) this.mPlayerSprites.get(playerID);
            float ratio = ((float) health) / ((float) maxHealth);
            if (sprite.getChildCount() == 0) {
                Rectangle healthBar = new Rectangle((sprite.getWidth() * 0.5f) - 50.0f, sprite.getHeight() + 5.0f, 100.0f, 15.0f);
                healthBar.setColor(1.0f, 1.0f, 1.0f);
                Rectangle currHealthBar = new Rectangle(2.0f, 2.0f, 96.0f * ratio, 11.0f);
                currHealthBar.setColor(1.0f, 0.0f, 0.0f);
                healthBar.attachChild(currHealthBar);
                sprite.attachChild(healthBar);
                if (playerID == this.playerNumber) {
                    Sprite arrowSprite = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("down_arrow.png"));
                    arrowSprite.setPosition((sprite.getWidth() * 0.5f) - (arrowSprite.getWidth() * 0.5f), (-arrowSprite.getHeight()) - 5.0f);
                    arrowSprite.registerEntityModifier(new LoopEntityModifier(new SequenceEntityModifier(new ScaleModifier(0.2f, 1.0f, 1.2f), new ScaleModifier(0.2f, 1.2f, 1.0f))));
                    sprite.attachChild(arrowSprite);
                }
            } else {
                ((Rectangle) ((Rectangle) sprite.getFirstChild()).getFirstChild()).setSize(96.0f * ratio, 11.0f);
            }
            sprite.setUserData(new PlayerInfo(health, maxHealth, battleLevel, playerID));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void client_fireBullet(int playerID, final int pID, float pX, float pY) {
        final Sprite bullet = getBulletFromBulletPool();
        AnimatedSprite player = (AnimatedSprite) this.mPlayerSprites.get(playerID);
        if (playerID % 2 == 0) {
            bullet.setPosition(player.getX() - bullet.getWidth(), player.getY() + (player.getHeight() / 2.0f));
            bullet.setColor(1.0f, 1.0f, 0.0f);
        } else {
            bullet.setPosition((player.getX() + player.getWidth()) + bullet.getWidth(), player.getY() + (player.getHeight() / 2.0f));
            bullet.setColor(0.0f, 1.0f, 1.0f);
        }
        bullet.setUserData(new BulletInfo(playerID, pID));
        if (this.isServer) {
            float xDim = pX - bullet.getX();
            float nY = (pY - bullet.getY()) / Math.abs(xDim);
            float nX = xDim / Math.abs(xDim);
            PhysicsHandler physicsHandler = new PhysicsHandler(bullet);
            physicsHandler.setVelocity(((float) 200) * nX, ((float) 200) * nY);
            bullet.registerUpdateHandler(physicsHandler);
            bullet.registerUpdateHandler(new IUpdateHandler() {
                public void reset() {
                }

                public void onUpdate(float arg0) {
                    int bulletOwner = ((BulletInfo) bullet.getUserData()).getPlayerID();
                    int i = 0;
                    while (i < TamaBattle.this.mPlayerSprites.size()) {
                        int key = TamaBattle.this.mPlayerSprites.keyAt(i);
                        if (!bullet.collidesWith((IShape) TamaBattle.this.mPlayerSprites.get(key)) || bulletOwner == key) {
                            i++;
                        } else if (bulletOwner % 2 != 0 || key % 2 != 0) {
                            if (bulletOwner % 2 == 0 || key % 2 == 0) {
                                Debug.m59d("Collision!");
                                PlayerInfo info = (PlayerInfo) ((AnimatedSprite) TamaBattle.this.mPlayerSprites.get(key)).getUserData();
                                info.setHealth(info.getHealth() - 10);
                                ((AnimatedSprite) TamaBattle.this.mPlayerSprites.get(key)).setUserData(info);
                                Debug.m59d("Player " + key + "'s health: " + info.getHealth());
                                TamaBattle.this.mServerConnector.sendMoveSpriteMessage(((BulletInfo) bullet.getUserData()).getPlayerID(), ((BulletInfo) bullet.getUserData()).getID(), -1.0f, -1.0f, false);
                                TamaBattle.this.bulletsToRemove.add(TamaBattle.this.mSprites.get(pID));
                                TamaBattle.this.mBattleServer.sendPlayerStatsMessage(info.getHealth(), info.getMaxHealth(), info.getBattleLevel(), info.getPlayerID());
                                if (info.getHealth() <= 0) {
                                    Debug.m59d("Player " + key + " has lost!");
                                    TamaBattle.this.mBattleServer.sendAddPlayerSpriteMessage(key, -1.0f, -1.0f);
                                }
                                TamaBattle.this.mBattleServer.sendDamageMessage(key);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    TamaBattle.this.mServerConnector.sendMoveSpriteMessage(((BulletInfo) bullet.getUserData()).getPlayerID(), ((BulletInfo) bullet.getUserData()).getID(), bullet.getX(), bullet.getY(), false);
                }
            });
        }
        bullet.registerUpdateHandler(new IUpdateHandler() {
            public void reset() {
            }

            public void onUpdate(float arg0) {
                if (bullet.getX() > ((float) (TamaBattle.CAMERA_WIDTH + 100)) || bullet.getY() > ((float) (TamaBattle.CAMERA_HEIGHT + 100)) || bullet.getX() < -100.0f || bullet.getY() < -100.0f) {
                    Debug.m59d("Recycled bullet!");
                    TamaBattle.this.bulletsToRemove.add(bullet);
                }
            }
        });
        if (this.soundOn) {
            this.pewSound.play();
        }
        this.mSprites.put(pID, bullet);
        if (!bullet.hasParent()) {
            this.bottomLayer.attachChild(bullet);
        }
    }

    public void client_setPlayerNumber(final int playerNumber) {
        this.playerNumber = playerNumber;
        Debug.m59d("I am player " + playerNumber);
        runOnUpdateThread(new Runnable() {
            public void run() {
                Text playerNumText = new Text(0.0f, 0.0f, TamaBattle.this.mFont, "Player " + playerNumber);
                playerNumText.setPosition((((float) TamaBattle.CAMERA_WIDTH) - playerNumText.getWidth()) - 15.0f, 15.0f);
                TamaBattle.this.topLayer.attachChild(playerNumText);
                TamaBattle.this.mEngine.setScene(TamaBattle.this.lobbyScene);
            }
        });
    }

    public void client_removePlayer(final int pID) {
        if (this.mPlayerSprites.get(pID) != null) {
            Debug.m59d("Removing player " + pID + "...");
            if (pID % 2 == 0) {
                this.team2--;
            } else {
                this.team1--;
            }
            if (pID == this.playerNumber && !this.isServer) {
                this.loseText.setVisible(true);
                this.mEngine.setScene(this.endScene);
            } else if (pID == this.playerNumber && this.isServer) {
                Debug.m59d("Disabled touch listener...");
                this.scene.setOnSceneTouchListenerBindingEnabled(false);
                this.scene.clearChildScene();
            }
            runOnUpdateThread(new Runnable() {
                public void run() {
                    try {
                        if (!TamaBattle.this.mEngine.getScene().equals(TamaBattle.this.lobbyScene)) {
                            IEntity tombSprite = new Sprite(((AnimatedSprite) TamaBattle.this.mPlayerSprites.get(pID)).getX(), ((AnimatedSprite) TamaBattle.this.mPlayerSprites.get(pID)).getY(), (TextureRegion) TamaBattle.this.listTR.get("tombstone.png"));
                            TamaBattle.this.bottomLayer.attachChild(tombSprite);
                            TamaBattle.this.bottomLayer.swapChildren(tombSprite, (IEntity) TamaBattle.this.mPlayerSprites.get(pID));
                        }
                        ((AnimatedSprite) TamaBattle.this.mPlayerSprites.get(pID)).detachSelf();
                        TamaBattle.this.mPlayerSprites.remove(pID);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void client_addPlayerSprite(int pID, float pX, float pY) {
        while (!this.loadComplete) {
            waitTime(500);
        }
        if (this.mPlayerSprites.get(pID) == null) {
            this.numPlayers++;
            Debug.m59d("[PLAYER " + this.playerNumber + "] Adding player " + pID + "... ");
            if (pID % 2 == 0) {
                this.team2++;
            } else {
                this.team1++;
            }
            final IEntity player = new AnimatedSprite(0.0f, 0.0f, this.mTamaTextureRegion.deepCopy());
            if (pX == 0.0f || pY == 0.0f) {
                float x;
                float y;
                int offset = pID * 10;
                if (pID % 2 == 0) {
                    offset = (pID - 1) * 10;
                    x = ((((float) CAMERA_WIDTH) - player.getWidth()) - 25.0f) - ((float) offset);
                    y = (float) ((CAMERA_HEIGHT / 2) + offset);
                } else {
                    x = (player.getWidth() + 25.0f) + ((float) offset);
                    y = (float) ((CAMERA_HEIGHT / 2) + offset);
                }
                player.setPosition(x - (player.getWidth() * 0.5f), y - (player.getHeight() * 0.5f));
            } else {
                player.setPosition(pX, pY);
            }
            if (pID % 2 == 0) {
                player.animate(new long[]{300, 300}, 0, 1, true);
            } else {
                player.animate(new long[]{300, 300}, 2, 3, true);
            }
            synchronized (this.mPlayerSprites) {
                this.mPlayerSprites.put(pID, player);
            }
            if (pID == this.playerNumber) {
                int x1;
                int y1;
                this.me = player;
                final PhysicsHandler physicsHandler = new PhysicsHandler(player);
                player.registerUpdateHandler(physicsHandler);
                if (this.playerNumber % 2 != 0) {
                    x1 = 40;
                    y1 = (CAMERA_HEIGHT - this.mOnScreenControlBaseTextureRegion.getHeight()) - 40;
                } else {
                    x1 = (CAMERA_WIDTH - this.mOnScreenControlBaseTextureRegion.getWidth()) - 40;
                    y1 = (CAMERA_HEIGHT - this.mOnScreenControlBaseTextureRegion.getHeight()) - 40;
                }
                AnalogOnScreenControl velocityOnScreenControl = new AnalogOnScreenControl((float) x1, (float) y1, this.mCamera, this.mOnScreenControlBaseTextureRegion, this.mOnScreenControlKnobTextureRegion, 0.1f, new IAnalogOnScreenControlListener() {
                    public void onControlChange(BaseOnScreenControl pBaseOnScreenControl, float pValueX, float pValueY) {
                        physicsHandler.setVelocity(pValueX * 100.0f, 100.0f * pValueY);
                    }

                    public void onControlClick(AnalogOnScreenControl pAnalogOnScreenControl) {
                    }
                });
                velocityOnScreenControl.getControlBase().setBlendFunction(Shape.BLENDFUNCTION_SOURCE_DEFAULT, 771);
                velocityOnScreenControl.getControlBase().setAlpha(0.5f);
                this.scene.setChildScene(velocityOnScreenControl);
                player.registerUpdateHandler(new IUpdateHandler() {
                    public void reset() {
                    }

                    public void onUpdate(float arg0) {
                        float x = player.getX();
                        float y = player.getY();
                        if (x < 0.0f || player.getWidth() + x > ((float) TamaBattle.CAMERA_WIDTH)) {
                            if (x < 0.0f) {
                                player.setPosition(0.0f, y);
                            } else {
                                player.setPosition(((float) TamaBattle.CAMERA_WIDTH) - player.getWidth(), y);
                            }
                        }
                        x = player.getX();
                        if (y < 0.0f || player.getHeight() + y > ((float) TamaBattle.CAMERA_HEIGHT)) {
                            if (y < 0.0f) {
                                player.setPosition(x, 0.0f);
                            } else {
                                player.setPosition(x, ((float) TamaBattle.CAMERA_HEIGHT) - player.getHeight());
                            }
                        }
                        if (TamaBattle.this.playerNumber % 2 == 0) {
                            if (player.getX() < ((float) (TamaBattle.CAMERA_WIDTH / 2))) {
                                player.setPosition((float) (TamaBattle.CAMERA_WIDTH / 2), player.getY());
                            }
                        } else if (player.getX() + player.getWidth() > ((float) (TamaBattle.CAMERA_WIDTH / 2))) {
                            player.setPosition(((float) (TamaBattle.CAMERA_WIDTH / 2)) - player.getWidth(), player.getY());
                        }
                        TamaBattle.this.mServerConnector.sendMoveSpriteMessage(TamaBattle.this.playerNumber, TamaBattle.this.playerNumber, player.getX(), player.getY(), true);
                    }
                });
            }
            this.bottomLayer.attachChild(player);
            try {
                if (pID != this.playerNumber) {
                    this.bottomLayer.swapChildren(player, this.me);
                }
            } catch (NullPointerException e) {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void client_moveSprite(int pID, float pX, float pY, boolean isPlayer) {
        BaseSprite sprite;
        if (this.isServer) {
            if (!isPlayer) {
                return;
            }
            if (isPlayer && pID == this.playerNumber) {
                return;
            }
        } else if (!isPlayer || pID != this.playerNumber) {
            if (pX == -1.0f && pY == -1.0f) {
                this.bulletsToRemove.add(this.mSprites.get(pID));
                return;
            }
        } else {
            return;
        }
        if (isPlayer) {
            sprite = (BaseSprite) this.mPlayerSprites.get(pID);
        } else {
            sprite = (BaseSprite) this.mSprites.get(pID);
        }
        if (sprite != null) {
            sprite.setPosition(pX, pY);
        }
    }

    public void client_sendPlayerInfoToServer() {
        Debug.m59d("Sending player info to server...");
        this.mServerConnector.sendPlayerStatsMessage(this.health, this.maxHealth, this.battleLevel, this.playerNumber);
    }

    public void client_endGame() {
        Debug.m59d("Ending game...");
        finish();
    }

    public void client_handleReceivedDamage(int id) {
        if (id == this.playerNumber) {
            if (this.vibrateOn) {
                this.mEngine.vibrate(100);
            }
            if (this.soundOn) {
                this.hitSound.play();
            }
        }
        ((AnimatedSprite) this.mPlayerSprites.get(id)).registerEntityModifier(new SequenceEntityModifier(new ColorModifier(0.2f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f), new ColorModifier(0.2f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f)));
    }

    public void client_setDeathMatch(boolean isDeathMatch) {
        this.isDeathMatch = isDeathMatch;
        Sprite dmIcon = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("skull.png"));
        dmIcon.setPosition(this.ipText.getWidth(), (this.ipText.getHeight() / 2.0f) - (dmIcon.getWidth() / 2.0f));
        dmIcon.setAlpha(0.7f);
        this.ipText.attachChild(dmIcon);
    }

    public void client_startGame() {
        if (this.isDeathMatch) {
            this.mEngine.setScene(this.deathMatchWarningScene);
            waitTime(2000);
        }
        this.mEngine.setScene(this.scene);
        if (this.soundOn) {
            if (this.lobbyMusic.isPlaying()) {
                this.lobbyMusic.pause();
            }
            this.fightSound.play();
            this.backgroundMusic.play();
        }
    }

    public void server_updateAllPlayerInfo() {
        Debug.m59d("Sending updated player info to clients...");
        synchronized (this.mPlayerSprites) {
            for (int i = 0; i < this.mPlayerSprites.size(); i++) {
                int key = this.mPlayerSprites.keyAt(i);
                Debug.m59d("Waiting for sprite to be ready for player " + key + "...");
                while (this.mPlayerSprites.get(key) == null) {
                    waitTime(500);
                }
                Debug.m59d("Sprite Ready!");
                AnimatedSprite aSprite = (AnimatedSprite) this.mPlayerSprites.get(key);
                try {
                    Debug.m59d("Waiting for info to be ready for player " + key + "...");
                    while (aSprite.getUserData() == null) {
                        waitTime(500);
                    }
                    Debug.m59d("Info Ready!");
                    PlayerInfo info = (PlayerInfo) aSprite.getUserData();
                    this.mBattleServer.sendPlayerStatsMessage(info.getHealth(), info.getMaxHealth(), info.getBattleLevel(), info.getPlayerID());
                    if (info.getBattleLevel() < this.lowestBattleLevel) {
                        this.lowestBattleLevel = info.getBattleLevel();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void server_updateSkull(String ip, boolean vote) {
        Text text = (Text) this.textIpArray.get(ip);
        if (text == null) {
            Debug.m59d("IP " + ip + " not found!");
        } else if (text.getChildCount() != 0) {
            text.getLastChild().setVisible(vote);
        } else if (vote) {
            Sprite skull = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("skull.png"));
            skull.setPosition(text.getWidth() + 20.0f, (text.getHeight() / 2.0f) - (skull.getHeight() / 2.0f));
            text.attachChild(skull);
        }
    }

    public void server_addPlayerToLobby(final String ip, final int playerId, final int battleLevel) {
        runOnUpdateThread(new Runnable() {
            public void run() {
                String team;
                if (playerId % 2 == 0) {
                    team = "[2] ";
                } else {
                    team = "[1] ";
                }
                Text pText = new Text(50.0f, (float) ((playerId * 50) + 50), TamaBattle.this.mFont, team + "Player " + playerId + ", Battle Level: " + battleLevel + ", " + ip);
                TamaBattle.this.ipArray.put(ip, Integer.valueOf(playerId));
                TamaBattle.this.textIpArray.put(ip, pText);
                if (TamaBattle.this.lobbyScene != null) {
                    TamaBattle.this.lobbyScene.attachChild(pText);
                }
            }
        });
    }

    public void server_addPlayerSpriteToServer(int playerID) {
        client_addPlayerSprite(playerID, 0.0f, 0.0f);
    }

    public void server_updateAllPlayerSprites() {
        synchronized (this.mPlayerSprites) {
            for (int i = 0; i < this.mPlayerSprites.size(); i++) {
                int key = this.mPlayerSprites.keyAt(i);
                AnimatedSprite aSprite = (AnimatedSprite) this.mPlayerSprites.get(key);
                this.mBattleServer.sendAddPlayerSpriteMessage(key, aSprite.getX(), aSprite.getY());
            }
        }
    }
}
