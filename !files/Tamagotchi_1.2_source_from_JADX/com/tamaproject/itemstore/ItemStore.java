package com.tamaproject.itemstore;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Display;
import android.widget.Toast;
import com.tamaproject.BaseAndEngineGame;
import com.tamaproject.database.DatabaseHelper;
import com.tamaproject.entity.Backpack;
import com.tamaproject.entity.Item;
import com.tamaproject.util.TextUtil;
import com.tamaproject.util.TextureUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import org.acra.ACRAConstants;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.modifier.LoopEntityModifier;
import org.anddev.andengine.entity.modifier.ScaleModifier;
import org.anddev.andengine.entity.modifier.SequenceEntityModifier;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.util.Debug;

public class ItemStore extends BaseAndEngineGame {
    private static final int CONFIRM_PURCHASE = 0;
    private static final boolean FULLSCREEN = true;
    private static int cameraHeight = 800;
    private static int cameraWidth = 480;
    private static int pBottomBound = (cameraHeight - 70);
    private static int pTopBound = 115;
    private Backpack backpack;
    private Entity bottomLayer;
    private int currentPage = 0;
    private DatabaseHelper dbHelper;
    private Rectangle itemDescriptionRect;
    private ChangeableText itemDesctiptionText;
    private ArrayList<Entity> itemPages = new ArrayList();
    private Item itemToPurchase;
    private Hashtable<String, TextureRegion> listTR;
    private Camera mCamera;
    private Font mFont;
    private BitmapTextureAtlas mFontTexture;
    private Scene mScene;
    private Font mSmallFont;
    private BitmapTextureAtlas mSmallFontTexture;
    private int money = 0;
    private int tamaId = 1;
    private ChangeableText titleText;
    private Entity topLayer;

    class C08908 implements IUpdateHandler {
        C08908() {
        }

        public void reset() {
        }

        public void onUpdate(float arg0) {
            ItemStore.this.titleText.setText("Item Store  (" + (ItemStore.this.currentPage + 1) + "/" + ItemStore.this.itemPages.size() + ")");
        }
    }

    static /* synthetic */ int access$104(ItemStore x0) {
        int i = x0.currentPage + 1;
        x0.currentPage = i;
        return i;
    }

    static /* synthetic */ int access$106(ItemStore x0) {
        int i = x0.currentPage - 1;
        x0.currentPage = i;
        return i;
    }

    public void onLoadComplete() {
    }

    public void onPause() {
        super.onPause();
        this.mEngine.stop();
        if (this.dbHelper != null) {
            long resultBackpackSave = this.dbHelper.insertBackpack(this.backpack.getItems());
            if (resultBackpackSave < 0) {
                Debug.m59d("Save backpack failed! " + resultBackpackSave);
            } else {
                Debug.m59d("Save backpack success! " + resultBackpackSave);
            }
            long saveMoneyResult = (long) this.dbHelper.saveMoney(this.money, this.tamaId);
            if (saveMoneyResult < 0) {
                Debug.m59d("Save money failed! " + saveMoneyResult);
            }
        }
    }

    public void onResume() {
        super.onResume();
        this.mEngine.start();
    }

    public void finish() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("money", this.money);
        setResult(-1, returnIntent);
        super.finish();
    }

    public Engine onLoadEngine() {
        Display display = getWindowManager().getDefaultDisplay();
        cameraHeight = Math.round(((float) cameraWidth) / (((float) display.getWidth()) / ((float) display.getHeight())));
        pBottomBound = cameraHeight - 70;
        this.mCamera = new Camera(0.0f, 0.0f, (float) cameraWidth, (float) cameraHeight);
        return new Engine(new EngineOptions(true, ScreenOrientation.PORTRAIT, new RatioResolutionPolicy((float) cameraWidth, (float) cameraHeight), this.mCamera));
    }

    public void onLoadResources() {
        this.listTR = TextureUtil.loadTextures(this, this.mEngine, new String[]{new String("gfx/")});
        this.mFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.mSmallFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.mFont = FontFactory.createFromAsset(this.mFontTexture, this, "ITCKRIST.TTF", 24.0f, true, -1);
        this.mSmallFont = FontFactory.createFromAsset(this.mSmallFontTexture, this, "ITCKRIST.TTF", 18.0f, true, -1);
        this.mEngine.getTextureManager().loadTexture(this.mFontTexture);
        this.mEngine.getTextureManager().loadTexture(this.mSmallFontTexture);
        this.mEngine.getFontManager().loadFont(this.mFont);
        this.mEngine.getFontManager().loadFont(this.mSmallFont);
    }

    public Scene onLoadScene() {
        try {
            this.dbHelper = new DatabaseHelper(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            DatabaseHelper.createDatabaseIfNotExists(this);
            Debug.m59d("createDatabase()");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            this.dbHelper.openDatabase();
            Debug.m59d("openDatabase()");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        Intent intent = getIntent();
        this.money = intent.getIntExtra("money", 0);
        this.tamaId = intent.getIntExtra("tamaId", 1);
        this.mScene = new Scene();
        this.mScene.setBackground(new ColorBackground(0.96862745f, 0.9137255f, 0.40392157f));
        this.topLayer = new Entity();
        this.bottomLayer = new Entity();
        this.mScene.attachChild(this.bottomLayer);
        this.mScene.attachChild(this.topLayer);
        loadBackpack();
        loadStoreItems();
        loadItemDescriptionBox();
        loadTopBar();
        loadBottomBar();
        this.mScene.setTouchAreaBindingEnabled(true);
        this.mScene.setOnAreaTouchTraversalFrontToBack();
        return this.mScene;
    }

    public void pauseSound() {
    }

    public void resumeSound() {
    }

    private void loadTopBar() {
        Rectangle topRect = new Rectangle(0.0f, 0.0f, (float) cameraWidth, (float) pTopBound);
        topRect.setColor(0.6627451f, 0.8117647f, 0.32941177f);
        this.topLayer.attachChild(topRect);
        this.titleText = new ChangeableText(0.0f, 0.0f, this.mFont, "Item Store", 25);
        this.titleText.setPosition(40.0f, (topRect.getHeight() / 2.0f) - (this.titleText.getHeight() / 2.0f));
        topRect.attachChild(this.titleText);
        Sprite shopIcon = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("shop_big.png"));
        shopIcon.setPosition((((float) cameraWidth) - shopIcon.getWidth()) - 40.0f, ((float) (pTopBound / 2)) - (shopIcon.getHeight() / 2.0f));
        shopIcon.registerEntityModifier(new LoopEntityModifier(new SequenceEntityModifier(new ScaleModifier(1.0f, 1.0f, 1.1f), new ScaleModifier(1.0f, 1.1f, 1.0f))));
        topRect.attachChild(shopIcon);
    }

    private void loadBottomBar() {
        Rectangle bottomRect = new Rectangle(0.0f, (float) pBottomBound, (float) cameraWidth, (float) (cameraHeight - pBottomBound));
        bottomRect.setColor(0.6627451f, 0.8117647f, 0.32941177f);
        this.topLayer.attachChild(bottomRect);
        final ChangeableText moneyText = new ChangeableText(0.0f, 0.0f, this.mFont, "Money: $" + this.money, 40);
        moneyText.setPosition(40.0f, (bottomRect.getHeight() / 2.0f) - (moneyText.getHeight() / 2.0f));
        bottomRect.attachChild(moneyText);
        moneyText.registerUpdateHandler(new IUpdateHandler() {
            public void reset() {
            }

            public void onUpdate(float arg0) {
                moneyText.setText("Money: $" + ItemStore.this.money);
            }
        });
        final Sprite rightArrowSprite = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("right_icon.png")) {
            private boolean moved = false;
            private boolean touched = false;

            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!getParent().isVisible()) {
                    return false;
                }
                if (pSceneTouchEvent.isActionDown()) {
                    this.touched = true;
                } else if (pSceneTouchEvent.isActionMove()) {
                    this.moved = true;
                } else if (pSceneTouchEvent.isActionUp()) {
                    if (this.touched && ItemStore.this.currentPage < ItemStore.this.itemPages.size() - 1) {
                        ((Entity) ItemStore.this.itemPages.get(ItemStore.this.currentPage)).setVisible(false);
                        ((Entity) ItemStore.this.itemPages.get(ItemStore.access$104(ItemStore.this))).setVisible(true);
                    }
                    this.touched = false;
                }
                return true;
            }
        };
        rightArrowSprite.setPosition((bottomRect.getWidth() - rightArrowSprite.getWidth()) - 20.0f, (bottomRect.getHeight() / 2.0f) - (rightArrowSprite.getHeight() / 2.0f));
        rightArrowSprite.registerUpdateHandler(new IUpdateHandler() {
            public void reset() {
            }

            public void onUpdate(float arg0) {
                if (ItemStore.this.currentPage < ItemStore.this.itemPages.size() - 1) {
                    rightArrowSprite.setVisible(true);
                } else {
                    rightArrowSprite.setVisible(false);
                }
            }
        });
        this.mScene.registerTouchArea(rightArrowSprite);
        rightArrowSprite.setVisible(false);
        bottomRect.attachChild(rightArrowSprite);
        final Sprite leftArrowSprite = new Sprite(0.0f, 0.0f, (TextureRegion) this.listTR.get("left_icon.png")) {
            private boolean moved = false;
            private boolean touched = false;

            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!getParent().isVisible()) {
                    return false;
                }
                if (pSceneTouchEvent.isActionDown()) {
                    this.touched = true;
                } else if (pSceneTouchEvent.isActionMove()) {
                    this.moved = true;
                } else if (pSceneTouchEvent.isActionUp()) {
                    if (this.touched && ItemStore.this.currentPage > 0) {
                        ((Entity) ItemStore.this.itemPages.get(ItemStore.this.currentPage)).setVisible(false);
                        ((Entity) ItemStore.this.itemPages.get(ItemStore.access$106(ItemStore.this))).setVisible(true);
                    }
                    this.touched = false;
                }
                return true;
            }
        };
        leftArrowSprite.setPosition((rightArrowSprite.getX() - leftArrowSprite.getWidth()) - 20.0f, rightArrowSprite.getY());
        leftArrowSprite.registerUpdateHandler(new IUpdateHandler() {
            public void reset() {
            }

            public void onUpdate(float arg0) {
                if (ItemStore.this.currentPage > 0) {
                    leftArrowSprite.setVisible(true);
                } else {
                    leftArrowSprite.setVisible(false);
                }
            }
        });
        this.mScene.registerTouchArea(leftArrowSprite);
        leftArrowSprite.setVisible(false);
        bottomRect.attachChild(leftArrowSprite);
    }

    private void loadStoreItems() {
        ArrayList<Item> allItems = this.dbHelper.getAllItems(this.listTR);
        float boxHeight = (float) ((pBottomBound - pTopBound) / 10);
        int counter = 0;
        Entity currentLayer = new Entity();
        Iterator it = allItems.iterator();
        while (it.hasNext()) {
            final Item item = (Item) it.next();
            counter++;
            Rectangle itemBox = new Rectangle((float) 5, (float) (pTopBound + 5), (float) (cameraWidth - 10), boxHeight - ((float) 5)) {
                private boolean moved = false;
                private boolean touched = false;

                public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                    if (!getParent().isVisible()) {
                        return false;
                    }
                    if (pSceneTouchEvent.isActionDown()) {
                        this.touched = true;
                    } else if (pSceneTouchEvent.isActionMove()) {
                        this.moved = true;
                    } else if (pSceneTouchEvent.isActionUp()) {
                        if (this.touched) {
                            ItemStore.this.showItemDescription(item);
                        }
                        this.touched = false;
                    }
                    return true;
                }
            };
            this.mScene.registerTouchArea(itemBox);
            item.setPosition(2.0f, 2.0f);
            itemBox.attachChild(item);
            itemBox.setColor(0.015686275f, 0.7490196f, 0.7490196f);
            Text text = new Text(0.0f, 0.0f, this.mSmallFont, item.getName() + ": $" + item.getPrice());
            text.setPosition(item.getWidth() + 5.0f, (item.getHeight() / 2.0f) - (text.getHeight() / 2.0f));
            item.attachChild(text);
            text = new Text(0.0f, 0.0f, this.mSmallFont, "Buy");
            final Rectangle rectangle = itemBox;
            final Item item2 = item;
            Rectangle buyButton = new Rectangle(0.0f, 0.0f, text.getWidth() + 50.0f, itemBox.getHeight()) {
                private boolean moved = false;
                private boolean touched = false;

                public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                    if (!rectangle.getParent().isVisible()) {
                        return false;
                    }
                    if (pSceneTouchEvent.isActionDown()) {
                        this.touched = true;
                    } else if (pSceneTouchEvent.isActionMove()) {
                        this.moved = true;
                    } else if (pSceneTouchEvent.isActionUp()) {
                        if (this.touched) {
                            ItemStore.this.itemToPurchase = item2;
                            ItemStore.this.showDialog(0);
                        }
                        this.touched = false;
                    }
                    return true;
                }
            };
            this.mScene.registerTouchArea(buyButton);
            buyButton.setColor(0.34509805f, 0.56078434f, 0.15294118f);
            text.setPosition(25.0f, (buyButton.getHeight() / 2.0f) - (text.getHeight() / 2.0f));
            buyButton.attachChild(text);
            itemBox.setWidth((((float) cameraWidth) - buyButton.getWidth()) - 10.0f);
            buyButton.setPosition(itemBox.getWidth(), 0.0f);
            itemBox.attachChild(buyButton);
            if (currentLayer.getChildCount() > 0) {
                itemBox.setPosition(5.0f, (((Rectangle) currentLayer.getLastChild()).getHeight() + currentLayer.getLastChild().getY()) + 5.0f);
            }
            currentLayer.attachChild(itemBox);
            if (counter >= 10) {
                currentLayer.setVisible(false);
                this.itemPages.add(currentLayer);
                this.bottomLayer.attachChild(currentLayer);
                currentLayer = new Entity();
                counter = 0;
            }
        }
        if (counter > 0 && counter < 10) {
            currentLayer.setVisible(false);
            this.itemPages.add(currentLayer);
            this.bottomLayer.attachChild(currentLayer);
        }
        ((Entity) this.itemPages.get(0)).setVisible(true);
        this.currentPage = 0;
        this.mScene.registerUpdateHandler(new C08908());
    }

    private void loadItemDescriptionBox() {
        this.itemDescriptionRect = new Rectangle(10.0f, (float) (cameraHeight / 2), (float) (cameraWidth - 20), (float) Math.round((float) (((cameraHeight / 2) - (cameraHeight - pBottomBound)) - 10))) {
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!isVisible()) {
                    return false;
                }
                Debug.m59d("Touched item description box");
                return true;
            }
        };
        this.itemDescriptionRect.setColor(0.0f, 0.0f, 0.0f);
        this.itemDescriptionRect.setAlpha(0.8f);
        this.itemDescriptionRect.setVisible(false);
        this.mScene.registerTouchArea(this.itemDescriptionRect);
        this.topLayer.attachChild(this.itemDescriptionRect);
        Sprite closeButton = new Sprite(this.itemDescriptionRect.getWidth() - ((float) ((TextureRegion) this.listTR.get("close.png")).getWidth()), 0.0f, (TextureRegion) this.listTR.get("close.png")) {
            private boolean touched = false;

            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (!getParent().isVisible()) {
                    return false;
                }
                if (pSceneTouchEvent.isActionDown()) {
                    Debug.m59d("Touched close button");
                    ItemStore.this.hideItemDescription();
                } else if (!pSceneTouchEvent.isActionMove() && pSceneTouchEvent.isActionUp()) {
                }
                return true;
            }
        };
        this.itemDescriptionRect.attachChild(closeButton);
        this.mScene.registerTouchArea(closeButton);
        this.itemDesctiptionText = new ChangeableText(10.0f, 10.0f, this.mSmallFont, "", 512);
        this.itemDescriptionRect.attachChild(this.itemDesctiptionText);
    }

    private void showItemDescription(Item i) {
        this.itemDescriptionRect.setVisible(false);
        this.itemDesctiptionText.setText(TextUtil.getNormalizedText(this.mSmallFont, i.getInfoWithPrice(), this.itemDescriptionRect.getWidth() - 20.0f));
        this.itemDescriptionRect.setHeight(this.itemDesctiptionText.getHeight());
        this.itemDescriptionRect.setPosition(this.itemDescriptionRect.getX(), (((float) pBottomBound) - this.itemDescriptionRect.getHeight()) - 10.0f);
        this.itemDescriptionRect.setVisible(true);
    }

    private void hideItemDescription() {
        this.itemDescriptionRect.setVisible(false);
    }

    private void loadBackpack() {
        Debug.m59d("Loading backpack...");
        ArrayList<Item> backpackItems = this.dbHelper.getBackpack(this.listTR);
        if (backpackItems != null) {
            this.backpack = new Backpack(backpackItems);
        } else {
            this.backpack = new Backpack();
        }
    }

    protected Dialog onCreateDialog(int id) {
        Builder builder2 = new Builder(this);
        switch (id) {
            case 0:
                try {
                    builder2.setTitle("Confirm Purchase");
                    builder2.setIcon(17301514);
                    builder2.setMessage("Are you sure you want to buy " + this.itemToPurchase.getName());
                    builder2.setPositiveButton(ACRAConstants.DEFAULT_DIALOG_POSITIVE_BUTTON_TEXT, new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (ItemStore.this.money < ItemStore.this.itemToPurchase.getPrice()) {
                                ItemStore.this.toast("Not enough money!");
                                return;
                            }
                            Debug.m59d("Purchased " + ItemStore.this.itemToPurchase.getName());
                            if (ItemStore.this.backpack.addItem(ItemStore.this.itemToPurchase)) {
                                ItemStore.this.money = ItemStore.this.money - ItemStore.this.itemToPurchase.getPrice();
                                ItemStore.this.toast(ItemStore.this.itemToPurchase.getName() + " has been added to your backpack!");
                                return;
                            }
                            ItemStore.this.toast("Backpack is full!");
                        }
                    });
                    builder2.setNegativeButton(ACRAConstants.DEFAULT_DIALOG_NEGATIVE_BUTTON_TEXT, new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    return builder2.create();
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
        }
        return null;
    }

    protected void onPrepareDialog(int id, Dialog dialog) {
        switch (id) {
            case 0:
                ((AlertDialog) dialog).setMessage("Are you sure you want to buy " + this.itemToPurchase.getName() + "?");
                return;
            default:
                return;
        }
    }

    public void toast(final String pMessage) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(ItemStore.this, pMessage, 0).show();
            }
        });
    }
}
