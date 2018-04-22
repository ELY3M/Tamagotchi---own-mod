package org.anddev.andengine.entity.scene.menu.item.decorator;

import java.util.Comparator;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.IUpdateHandler.IUpdateHandlerMatcher;
import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.IEntity.IEntityCallable;
import org.anddev.andengine.entity.IEntity.IEntityMatcher;
import org.anddev.andengine.entity.modifier.IEntityModifier;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierMatcher;
import org.anddev.andengine.entity.scene.menu.item.IMenuItem;
import org.anddev.andengine.entity.shape.IShape;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.util.Transformation;

public abstract class BaseMenuItemDecorator implements IMenuItem {
    private final IMenuItem mMenuItem;

    protected abstract void onMenuItemReset(IMenuItem iMenuItem);

    protected abstract void onMenuItemSelected(IMenuItem iMenuItem);

    protected abstract void onMenuItemUnselected(IMenuItem iMenuItem);

    public BaseMenuItemDecorator(IMenuItem pMenuItem) {
        this.mMenuItem = pMenuItem;
    }

    public int getID() {
        return this.mMenuItem.getID();
    }

    public final void onSelected() {
        this.mMenuItem.onSelected();
        onMenuItemSelected(this.mMenuItem);
    }

    public final void onUnselected() {
        this.mMenuItem.onUnselected();
        onMenuItemUnselected(this.mMenuItem);
    }

    public float getX() {
        return this.mMenuItem.getX();
    }

    public float getY() {
        return this.mMenuItem.getY();
    }

    public void setPosition(IEntity pOtherEntity) {
        this.mMenuItem.setPosition(pOtherEntity);
    }

    public void setPosition(float pX, float pY) {
        this.mMenuItem.setPosition(pX, pY);
    }

    public float getBaseWidth() {
        return this.mMenuItem.getBaseWidth();
    }

    public float getBaseHeight() {
        return this.mMenuItem.getBaseHeight();
    }

    public float getWidth() {
        return this.mMenuItem.getWidth();
    }

    public float getWidthScaled() {
        return this.mMenuItem.getWidthScaled();
    }

    public float getHeight() {
        return this.mMenuItem.getHeight();
    }

    public float getHeightScaled() {
        return this.mMenuItem.getHeightScaled();
    }

    public float getInitialX() {
        return this.mMenuItem.getInitialX();
    }

    public float getInitialY() {
        return this.mMenuItem.getInitialY();
    }

    public float getRed() {
        return this.mMenuItem.getRed();
    }

    public float getGreen() {
        return this.mMenuItem.getGreen();
    }

    public float getBlue() {
        return this.mMenuItem.getBlue();
    }

    public float getAlpha() {
        return this.mMenuItem.getAlpha();
    }

    public void setAlpha(float pAlpha) {
        this.mMenuItem.setAlpha(pAlpha);
    }

    public void setColor(float pRed, float pGreen, float pBlue) {
        this.mMenuItem.setColor(pRed, pGreen, pBlue);
    }

    public void setColor(float pRed, float pGreen, float pBlue, float pAlpha) {
        this.mMenuItem.setColor(pRed, pGreen, pBlue, pAlpha);
    }

    public boolean isRotated() {
        return this.mMenuItem.isRotated();
    }

    public float getRotation() {
        return this.mMenuItem.getRotation();
    }

    public void setRotation(float pRotation) {
        this.mMenuItem.setRotation(pRotation);
    }

    public float getRotationCenterX() {
        return this.mMenuItem.getRotationCenterX();
    }

    public float getRotationCenterY() {
        return this.mMenuItem.getRotationCenterY();
    }

    public void setRotationCenterX(float pRotationCenterX) {
        this.mMenuItem.setRotationCenterX(pRotationCenterX);
    }

    public void setRotationCenterY(float pRotationCenterY) {
        this.mMenuItem.setRotationCenterY(pRotationCenterY);
    }

    public void setRotationCenter(float pRotationCenterX, float pRotationCenterY) {
        this.mMenuItem.setRotationCenter(pRotationCenterX, pRotationCenterY);
    }

    public boolean isScaled() {
        return this.mMenuItem.isScaled();
    }

    public float getScaleX() {
        return this.mMenuItem.getScaleX();
    }

    public float getScaleY() {
        return this.mMenuItem.getScaleY();
    }

    public void setScale(float pScale) {
        this.mMenuItem.setScale(pScale);
    }

    public void setScale(float pScaleX, float pScaleY) {
        this.mMenuItem.setScale(pScaleX, pScaleY);
    }

    public void setScaleX(float pScaleX) {
        this.mMenuItem.setScaleX(pScaleX);
    }

    public void setScaleY(float pScaleY) {
        this.mMenuItem.setScaleY(pScaleY);
    }

    public float getScaleCenterX() {
        return this.mMenuItem.getScaleCenterX();
    }

    public float getScaleCenterY() {
        return this.mMenuItem.getScaleCenterY();
    }

    public void setScaleCenterX(float pScaleCenterX) {
        this.mMenuItem.setScaleCenterX(pScaleCenterX);
    }

    public void setScaleCenterY(float pScaleCenterY) {
        this.mMenuItem.setScaleCenterY(pScaleCenterY);
    }

    public void setScaleCenter(float pScaleCenterX, float pScaleCenterY) {
        this.mMenuItem.setScaleCenter(pScaleCenterX, pScaleCenterY);
    }

    public boolean collidesWith(IShape pOtherShape) {
        return this.mMenuItem.collidesWith(pOtherShape);
    }

    public float[] getSceneCenterCoordinates() {
        return this.mMenuItem.getSceneCenterCoordinates();
    }

    public boolean isCullingEnabled() {
        return this.mMenuItem.isCullingEnabled();
    }

    public void registerEntityModifier(IEntityModifier pEntityModifier) {
        this.mMenuItem.registerEntityModifier(pEntityModifier);
    }

    public boolean unregisterEntityModifier(IEntityModifier pEntityModifier) {
        return this.mMenuItem.unregisterEntityModifier(pEntityModifier);
    }

    public boolean unregisterEntityModifiers(IEntityModifierMatcher pEntityModifierMatcher) {
        return this.mMenuItem.unregisterEntityModifiers(pEntityModifierMatcher);
    }

    public void clearEntityModifiers() {
        this.mMenuItem.clearEntityModifiers();
    }

    public void setInitialPosition() {
        this.mMenuItem.setInitialPosition();
    }

    public void setBlendFunction(int pSourceBlendFunction, int pDestinationBlendFunction) {
        this.mMenuItem.setBlendFunction(pSourceBlendFunction, pDestinationBlendFunction);
    }

    public void setCullingEnabled(boolean pCullingEnabled) {
        this.mMenuItem.setCullingEnabled(pCullingEnabled);
    }

    public int getZIndex() {
        return this.mMenuItem.getZIndex();
    }

    public void setZIndex(int pZIndex) {
        this.mMenuItem.setZIndex(pZIndex);
    }

    public void onDraw(GL10 pGL, Camera pCamera) {
        this.mMenuItem.onDraw(pGL, pCamera);
    }

    public void onUpdate(float pSecondsElapsed) {
        this.mMenuItem.onUpdate(pSecondsElapsed);
    }

    public void reset() {
        this.mMenuItem.reset();
        onMenuItemReset(this.mMenuItem);
    }

    public boolean contains(float pX, float pY) {
        return this.mMenuItem.contains(pX, pY);
    }

    public float[] convertLocalToSceneCoordinates(float pX, float pY) {
        return this.mMenuItem.convertLocalToSceneCoordinates(pX, pY);
    }

    public float[] convertLocalToSceneCoordinates(float pX, float pY, float[] pReuse) {
        return this.mMenuItem.convertLocalToSceneCoordinates(pX, pY, pReuse);
    }

    public float[] convertLocalToSceneCoordinates(float[] pCoordinates) {
        return this.mMenuItem.convertLocalToSceneCoordinates(pCoordinates);
    }

    public float[] convertLocalToSceneCoordinates(float[] pCoordinates, float[] pReuse) {
        return this.mMenuItem.convertLocalToSceneCoordinates(pCoordinates, pReuse);
    }

    public float[] convertSceneToLocalCoordinates(float pX, float pY) {
        return this.mMenuItem.convertSceneToLocalCoordinates(pX, pY);
    }

    public float[] convertSceneToLocalCoordinates(float pX, float pY, float[] pReuse) {
        return this.mMenuItem.convertSceneToLocalCoordinates(pX, pY, pReuse);
    }

    public float[] convertSceneToLocalCoordinates(float[] pCoordinates) {
        return this.mMenuItem.convertSceneToLocalCoordinates(pCoordinates);
    }

    public float[] convertSceneToLocalCoordinates(float[] pCoordinates, float[] pReuse) {
        return this.mMenuItem.convertSceneToLocalCoordinates(pCoordinates, pReuse);
    }

    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
        return this.mMenuItem.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
    }

    public int getChildCount() {
        return this.mMenuItem.getChildCount();
    }

    public void attachChild(IEntity pEntity) {
        this.mMenuItem.attachChild(pEntity);
    }

    public boolean attachChild(IEntity pEntity, int pIndex) {
        return this.mMenuItem.attachChild(pEntity, pIndex);
    }

    public IEntity getFirstChild() {
        return this.mMenuItem.getFirstChild();
    }

    public IEntity getLastChild() {
        return this.mMenuItem.getLastChild();
    }

    public IEntity getChild(int pIndex) {
        return this.mMenuItem.getChild(pIndex);
    }

    public int getChildIndex(IEntity pEntity) {
        return this.mMenuItem.getChildIndex(pEntity);
    }

    public boolean setChildIndex(IEntity pEntity, int pIndex) {
        return this.mMenuItem.setChildIndex(pEntity, pIndex);
    }

    public IEntity findChild(IEntityMatcher pEntityMatcher) {
        return this.mMenuItem.findChild(pEntityMatcher);
    }

    public boolean swapChildren(IEntity pEntityA, IEntity pEntityB) {
        return this.mMenuItem.swapChildren(pEntityA, pEntityB);
    }

    public boolean swapChildren(int pIndexA, int pIndexB) {
        return this.mMenuItem.swapChildren(pIndexA, pIndexB);
    }

    public void sortChildren() {
        this.mMenuItem.sortChildren();
    }

    public void sortChildren(Comparator<IEntity> pEntityComparator) {
        this.mMenuItem.sortChildren(pEntityComparator);
    }

    public boolean detachSelf() {
        return this.mMenuItem.detachSelf();
    }

    public boolean detachChild(IEntity pEntity) {
        return this.mMenuItem.detachChild(pEntity);
    }

    public IEntity detachChild(IEntityMatcher pEntityMatcher) {
        return this.mMenuItem.detachChild(pEntityMatcher);
    }

    public boolean detachChildren(IEntityMatcher pEntityMatcher) {
        return this.mMenuItem.detachChildren(pEntityMatcher);
    }

    public void detachChildren() {
        this.mMenuItem.detachChildren();
    }

    public void callOnChildren(IEntityCallable pEntityCallable) {
        callOnChildren(pEntityCallable);
    }

    public void callOnChildren(IEntityMatcher pEntityMatcher, IEntityCallable pEntityCallable) {
        this.mMenuItem.callOnChildren(pEntityMatcher, pEntityCallable);
    }

    public Transformation getLocalToSceneTransformation() {
        return this.mMenuItem.getLocalToSceneTransformation();
    }

    public Transformation getSceneToLocalTransformation() {
        return this.mMenuItem.getSceneToLocalTransformation();
    }

    public boolean hasParent() {
        return this.mMenuItem.hasParent();
    }

    public IEntity getParent() {
        return this.mMenuItem.getParent();
    }

    public void setParent(IEntity pEntity) {
        this.mMenuItem.setParent(pEntity);
    }

    public boolean isVisible() {
        return this.mMenuItem.isVisible();
    }

    public void setVisible(boolean pVisible) {
        this.mMenuItem.setVisible(pVisible);
    }

    public boolean isChildrenVisible() {
        return this.mMenuItem.isChildrenVisible();
    }

    public void setChildrenVisible(boolean pChildrenVisible) {
        this.mMenuItem.setChildrenVisible(pChildrenVisible);
    }

    public boolean isIgnoreUpdate() {
        return this.mMenuItem.isIgnoreUpdate();
    }

    public void setIgnoreUpdate(boolean pIgnoreUpdate) {
        this.mMenuItem.setIgnoreUpdate(pIgnoreUpdate);
    }

    public boolean isChildrenIgnoreUpdate() {
        return this.mMenuItem.isChildrenIgnoreUpdate();
    }

    public void setChildrenIgnoreUpdate(boolean pChildrenIgnoreUpdate) {
        this.mMenuItem.setChildrenIgnoreUpdate(pChildrenIgnoreUpdate);
    }

    public void setUserData(Object pUserData) {
        this.mMenuItem.setUserData(pUserData);
    }

    public Object getUserData() {
        return this.mMenuItem.getUserData();
    }

    public void onAttached() {
        this.mMenuItem.onAttached();
    }

    public void onDetached() {
        this.mMenuItem.onDetached();
    }

    public void registerUpdateHandler(IUpdateHandler pUpdateHandler) {
        this.mMenuItem.registerUpdateHandler(pUpdateHandler);
    }

    public boolean unregisterUpdateHandler(IUpdateHandler pUpdateHandler) {
        return this.mMenuItem.unregisterUpdateHandler(pUpdateHandler);
    }

    public void clearUpdateHandlers() {
        this.mMenuItem.clearUpdateHandlers();
    }

    public boolean unregisterUpdateHandlers(IUpdateHandlerMatcher pUpdateHandlerMatcher) {
        return this.mMenuItem.unregisterUpdateHandlers(pUpdateHandlerMatcher);
    }
}
