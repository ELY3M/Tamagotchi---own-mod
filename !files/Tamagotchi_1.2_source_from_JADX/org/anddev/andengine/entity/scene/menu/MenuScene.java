package org.anddev.andengine.entity.scene.menu;

import java.util.ArrayList;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.scene.CameraScene;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnAreaTouchListener;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.Scene.ITouchArea;
import org.anddev.andengine.entity.scene.menu.animator.IMenuAnimator;
import org.anddev.andengine.entity.scene.menu.item.IMenuItem;
import org.anddev.andengine.input.touch.TouchEvent;

public class MenuScene extends CameraScene implements IOnAreaTouchListener, IOnSceneTouchListener {
    private IMenuAnimator mMenuAnimator;
    private final ArrayList<IMenuItem> mMenuItems;
    private IOnMenuItemClickListener mOnMenuItemClickListener;
    private IMenuItem mSelectedMenuItem;

    public interface IOnMenuItemClickListener {
        boolean onMenuItemClicked(MenuScene menuScene, IMenuItem iMenuItem, float f, float f2);
    }

    public MenuScene() {
        this(null, null);
    }

    public MenuScene(IOnMenuItemClickListener pOnMenuItemClickListener) {
        this(null, pOnMenuItemClickListener);
    }

    public MenuScene(Camera pCamera) {
        this(pCamera, null);
    }

    public MenuScene(Camera pCamera, IOnMenuItemClickListener pOnMenuItemClickListener) {
        super(pCamera);
        this.mMenuItems = new ArrayList();
        this.mMenuAnimator = IMenuAnimator.DEFAULT;
        this.mOnMenuItemClickListener = pOnMenuItemClickListener;
        setOnSceneTouchListener(this);
        setOnAreaTouchListener(this);
    }

    public IOnMenuItemClickListener getOnMenuItemClickListener() {
        return this.mOnMenuItemClickListener;
    }

    public void setOnMenuItemClickListener(IOnMenuItemClickListener pOnMenuItemClickListener) {
        this.mOnMenuItemClickListener = pOnMenuItemClickListener;
    }

    public int getMenuItemCount() {
        return this.mMenuItems.size();
    }

    public void addMenuItem(IMenuItem pMenuItem) {
        this.mMenuItems.add(pMenuItem);
        attachChild(pMenuItem);
        registerTouchArea(pMenuItem);
    }

    public MenuScene getChildScene() {
        return (MenuScene) super.getChildScene();
    }

    public void setChildScene(Scene pChildScene, boolean pModalDraw, boolean pModalUpdate, boolean pModalTouch) throws IllegalArgumentException {
        if (pChildScene instanceof MenuScene) {
            super.setChildScene(pChildScene, pModalDraw, pModalUpdate, pModalTouch);
            return;
        }
        throw new IllegalArgumentException("MenuScene accepts only MenuScenes as a ChildScene.");
    }

    public void clearChildScene() {
        if (getChildScene() != null) {
            getChildScene().reset();
            super.clearChildScene();
        }
    }

    public void setMenuAnimator(IMenuAnimator pMenuAnimator) {
        this.mMenuAnimator = pMenuAnimator;
    }

    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, ITouchArea pTouchArea, float pTouchAreaLocalX, float pTouchAreaLocalY) {
        IMenuItem menuItem = (IMenuItem) pTouchArea;
        switch (pSceneTouchEvent.getAction()) {
            case 0:
            case 2:
                if (!(this.mSelectedMenuItem == null || this.mSelectedMenuItem == menuItem)) {
                    this.mSelectedMenuItem.onUnselected();
                }
                this.mSelectedMenuItem = menuItem;
                this.mSelectedMenuItem.onSelected();
                break;
            case 1:
                if (this.mOnMenuItemClickListener != null) {
                    boolean handled = this.mOnMenuItemClickListener.onMenuItemClicked(this, menuItem, pTouchAreaLocalX, pTouchAreaLocalY);
                    menuItem.onUnselected();
                    this.mSelectedMenuItem = null;
                    return handled;
                }
                break;
            case 3:
                menuItem.onUnselected();
                this.mSelectedMenuItem = null;
                break;
        }
        return true;
    }

    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        if (this.mSelectedMenuItem != null) {
            this.mSelectedMenuItem.onUnselected();
            this.mSelectedMenuItem = null;
        }
        return false;
    }

    public void back() {
        super.back();
        reset();
    }

    public void reset() {
        super.reset();
        ArrayList<IMenuItem> menuItems = this.mMenuItems;
        for (int i = menuItems.size() - 1; i >= 0; i--) {
            ((IMenuItem) menuItems.get(i)).reset();
        }
        prepareAnimations();
    }

    public void closeMenuScene() {
        back();
    }

    public void buildAnimations() {
        prepareAnimations();
        this.mMenuAnimator.buildAnimations(this.mMenuItems, this.mCamera.getWidthRaw(), this.mCamera.getHeightRaw());
    }

    public void prepareAnimations() {
        this.mMenuAnimator.prepareAnimations(this.mMenuItems, this.mCamera.getWidthRaw(), this.mCamera.getHeightRaw());
    }
}
