package org.anddev.andengine.entity;

import java.util.Comparator;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.IUpdateHandler.IUpdateHandlerMatcher;
import org.anddev.andengine.entity.modifier.IEntityModifier;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierMatcher;
import org.anddev.andengine.opengl.IDrawable;
import org.anddev.andengine.util.IMatcher;
import org.anddev.andengine.util.ParameterCallable;
import org.anddev.andengine.util.Transformation;

public interface IEntity extends IDrawable, IUpdateHandler {

    public interface IEntityCallable extends ParameterCallable<IEntity> {
        void call(IEntity iEntity);
    }

    public interface IEntityMatcher extends IMatcher<IEntity> {
        boolean matches(IEntity iEntity);
    }

    void attachChild(IEntity iEntity);

    boolean attachChild(IEntity iEntity, int i);

    void callOnChildren(IEntityCallable iEntityCallable);

    void callOnChildren(IEntityMatcher iEntityMatcher, IEntityCallable iEntityCallable);

    void clearEntityModifiers();

    void clearUpdateHandlers();

    float[] convertLocalToSceneCoordinates(float f, float f2);

    float[] convertLocalToSceneCoordinates(float f, float f2, float[] fArr);

    float[] convertLocalToSceneCoordinates(float[] fArr);

    float[] convertLocalToSceneCoordinates(float[] fArr, float[] fArr2);

    float[] convertSceneToLocalCoordinates(float f, float f2);

    float[] convertSceneToLocalCoordinates(float f, float f2, float[] fArr);

    float[] convertSceneToLocalCoordinates(float[] fArr);

    float[] convertSceneToLocalCoordinates(float[] fArr, float[] fArr2);

    IEntity detachChild(IEntityMatcher iEntityMatcher);

    boolean detachChild(IEntity iEntity);

    void detachChildren();

    boolean detachChildren(IEntityMatcher iEntityMatcher);

    boolean detachSelf();

    IEntity findChild(IEntityMatcher iEntityMatcher);

    float getAlpha();

    float getBlue();

    IEntity getChild(int i);

    int getChildCount();

    int getChildIndex(IEntity iEntity);

    IEntity getFirstChild();

    float getGreen();

    float getInitialX();

    float getInitialY();

    IEntity getLastChild();

    Transformation getLocalToSceneTransformation();

    IEntity getParent();

    float getRed();

    float getRotation();

    float getRotationCenterX();

    float getRotationCenterY();

    float getScaleCenterX();

    float getScaleCenterY();

    float getScaleX();

    float getScaleY();

    float[] getSceneCenterCoordinates();

    Transformation getSceneToLocalTransformation();

    Object getUserData();

    float getX();

    float getY();

    int getZIndex();

    boolean hasParent();

    boolean isChildrenIgnoreUpdate();

    boolean isChildrenVisible();

    boolean isIgnoreUpdate();

    boolean isRotated();

    boolean isScaled();

    boolean isVisible();

    void onAttached();

    void onDetached();

    void registerEntityModifier(IEntityModifier iEntityModifier);

    void registerUpdateHandler(IUpdateHandler iUpdateHandler);

    void setAlpha(float f);

    boolean setChildIndex(IEntity iEntity, int i);

    void setChildrenIgnoreUpdate(boolean z);

    void setChildrenVisible(boolean z);

    void setColor(float f, float f2, float f3);

    void setColor(float f, float f2, float f3, float f4);

    void setIgnoreUpdate(boolean z);

    void setInitialPosition();

    void setParent(IEntity iEntity);

    void setPosition(float f, float f2);

    void setPosition(IEntity iEntity);

    void setRotation(float f);

    void setRotationCenter(float f, float f2);

    void setRotationCenterX(float f);

    void setRotationCenterY(float f);

    void setScale(float f);

    void setScale(float f, float f2);

    void setScaleCenter(float f, float f2);

    void setScaleCenterX(float f);

    void setScaleCenterY(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setUserData(Object obj);

    void setVisible(boolean z);

    void setZIndex(int i);

    void sortChildren();

    void sortChildren(Comparator<IEntity> comparator);

    boolean swapChildren(int i, int i2);

    boolean swapChildren(IEntity iEntity, IEntity iEntity2);

    boolean unregisterEntityModifier(IEntityModifier iEntityModifier);

    boolean unregisterEntityModifiers(IEntityModifierMatcher iEntityModifierMatcher);

    boolean unregisterUpdateHandler(IUpdateHandler iUpdateHandler);

    boolean unregisterUpdateHandlers(IUpdateHandlerMatcher iUpdateHandlerMatcher);
}
