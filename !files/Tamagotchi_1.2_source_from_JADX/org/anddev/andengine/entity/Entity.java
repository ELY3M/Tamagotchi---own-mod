package org.anddev.andengine.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.IUpdateHandler.IUpdateHandlerMatcher;
import org.anddev.andengine.engine.handler.UpdateHandlerList;
import org.anddev.andengine.entity.IEntity.IEntityCallable;
import org.anddev.andengine.entity.IEntity.IEntityMatcher;
import org.anddev.andengine.entity.modifier.EntityModifierList;
import org.anddev.andengine.entity.modifier.IEntityModifier;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierMatcher;
import org.anddev.andengine.util.IMatcher;
import org.anddev.andengine.util.ParameterCallable;
import org.anddev.andengine.util.SmartList;
import org.anddev.andengine.util.Transformation;

public class Entity implements IEntity {
    private static final int CHILDREN_CAPACITY_DEFAULT = 4;
    private static final int ENTITYMODIFIERS_CAPACITY_DEFAULT = 4;
    private static final ParameterCallable<IEntity> PARAMETERCALLABLE_DETACHCHILD = new C09121();
    private static final int UPDATEHANDLERS_CAPACITY_DEFAULT = 4;
    private static final float[] VERTICES_LOCAL_TO_SCENE_TMP = new float[2];
    private static final float[] VERTICES_SCENE_TO_LOCAL_TMP = new float[2];
    protected float mAlpha;
    protected float mBlue;
    protected SmartList<IEntity> mChildren;
    protected boolean mChildrenIgnoreUpdate;
    protected boolean mChildrenVisible;
    private EntityModifierList mEntityModifiers;
    protected float mGreen;
    protected boolean mIgnoreUpdate;
    private final float mInitialX;
    private final float mInitialY;
    private final Transformation mLocalToParentTransformation;
    private boolean mLocalToParentTransformationDirty;
    private final Transformation mLocalToSceneTransformation;
    private IEntity mParent;
    private final Transformation mParentToLocalTransformation;
    private boolean mParentToLocalTransformationDirty;
    protected float mRed;
    protected float mRotation;
    protected float mRotationCenterX;
    protected float mRotationCenterY;
    protected float mScaleCenterX;
    protected float mScaleCenterY;
    protected float mScaleX;
    protected float mScaleY;
    private final Transformation mSceneToLocalTransformation;
    private UpdateHandlerList mUpdateHandlers;
    private Object mUserData;
    protected boolean mVisible;
    protected float mX;
    protected float mY;
    protected int mZIndex;

    class C09121 implements ParameterCallable<IEntity> {
        C09121() {
        }

        public void call(IEntity pEntity) {
            pEntity.setParent(null);
            pEntity.onDetached();
        }
    }

    public Entity() {
        this(0.0f, 0.0f);
    }

    public Entity(float pX, float pY) {
        this.mVisible = true;
        this.mIgnoreUpdate = false;
        this.mChildrenVisible = true;
        this.mChildrenIgnoreUpdate = false;
        this.mZIndex = 0;
        this.mRed = 1.0f;
        this.mGreen = 1.0f;
        this.mBlue = 1.0f;
        this.mAlpha = 1.0f;
        this.mRotation = 0.0f;
        this.mRotationCenterX = 0.0f;
        this.mRotationCenterY = 0.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mScaleCenterX = 0.0f;
        this.mScaleCenterY = 0.0f;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
        this.mLocalToParentTransformation = new Transformation();
        this.mParentToLocalTransformation = new Transformation();
        this.mLocalToSceneTransformation = new Transformation();
        this.mSceneToLocalTransformation = new Transformation();
        this.mInitialX = pX;
        this.mInitialY = pY;
        this.mX = pX;
        this.mY = pY;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public void setVisible(boolean pVisible) {
        this.mVisible = pVisible;
    }

    public boolean isChildrenVisible() {
        return this.mChildrenVisible;
    }

    public void setChildrenVisible(boolean pChildrenVisible) {
        this.mChildrenVisible = pChildrenVisible;
    }

    public boolean isIgnoreUpdate() {
        return this.mIgnoreUpdate;
    }

    public void setIgnoreUpdate(boolean pIgnoreUpdate) {
        this.mIgnoreUpdate = pIgnoreUpdate;
    }

    public boolean isChildrenIgnoreUpdate() {
        return this.mChildrenIgnoreUpdate;
    }

    public void setChildrenIgnoreUpdate(boolean pChildrenIgnoreUpdate) {
        this.mChildrenIgnoreUpdate = pChildrenIgnoreUpdate;
    }

    public boolean hasParent() {
        return this.mParent != null;
    }

    public IEntity getParent() {
        return this.mParent;
    }

    public void setParent(IEntity pEntity) {
        this.mParent = pEntity;
    }

    public int getZIndex() {
        return this.mZIndex;
    }

    public void setZIndex(int pZIndex) {
        this.mZIndex = pZIndex;
    }

    public float getX() {
        return this.mX;
    }

    public float getY() {
        return this.mY;
    }

    public float getInitialX() {
        return this.mInitialX;
    }

    public float getInitialY() {
        return this.mInitialY;
    }

    public void setPosition(IEntity pOtherEntity) {
        setPosition(pOtherEntity.getX(), pOtherEntity.getY());
    }

    public void setPosition(float pX, float pY) {
        this.mX = pX;
        this.mY = pY;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public void setInitialPosition() {
        this.mX = this.mInitialX;
        this.mY = this.mInitialY;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public float getRotation() {
        return this.mRotation;
    }

    public boolean isRotated() {
        return this.mRotation != 0.0f;
    }

    public void setRotation(float pRotation) {
        this.mRotation = pRotation;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public float getRotationCenterX() {
        return this.mRotationCenterX;
    }

    public float getRotationCenterY() {
        return this.mRotationCenterY;
    }

    public void setRotationCenterX(float pRotationCenterX) {
        this.mRotationCenterX = pRotationCenterX;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public void setRotationCenterY(float pRotationCenterY) {
        this.mRotationCenterY = pRotationCenterY;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public void setRotationCenter(float pRotationCenterX, float pRotationCenterY) {
        this.mRotationCenterX = pRotationCenterX;
        this.mRotationCenterY = pRotationCenterY;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public boolean isScaled() {
        return (this.mScaleX == 1.0f && this.mScaleY == 1.0f) ? false : true;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public void setScaleX(float pScaleX) {
        this.mScaleX = pScaleX;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public void setScaleY(float pScaleY) {
        this.mScaleY = pScaleY;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public void setScale(float pScale) {
        this.mScaleX = pScale;
        this.mScaleY = pScale;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public void setScale(float pScaleX, float pScaleY) {
        this.mScaleX = pScaleX;
        this.mScaleY = pScaleY;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public float getScaleCenterX() {
        return this.mScaleCenterX;
    }

    public float getScaleCenterY() {
        return this.mScaleCenterY;
    }

    public void setScaleCenterX(float pScaleCenterX) {
        this.mScaleCenterX = pScaleCenterX;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public void setScaleCenterY(float pScaleCenterY) {
        this.mScaleCenterY = pScaleCenterY;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public void setScaleCenter(float pScaleCenterX, float pScaleCenterY) {
        this.mScaleCenterX = pScaleCenterX;
        this.mScaleCenterY = pScaleCenterY;
        this.mLocalToParentTransformationDirty = true;
        this.mParentToLocalTransformationDirty = true;
    }

    public float getRed() {
        return this.mRed;
    }

    public float getGreen() {
        return this.mGreen;
    }

    public float getBlue() {
        return this.mBlue;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public void setAlpha(float pAlpha) {
        this.mAlpha = pAlpha;
    }

    public void setColor(float pRed, float pGreen, float pBlue) {
        this.mRed = pRed;
        this.mGreen = pGreen;
        this.mBlue = pBlue;
    }

    public void setColor(float pRed, float pGreen, float pBlue, float pAlpha) {
        this.mRed = pRed;
        this.mGreen = pGreen;
        this.mBlue = pBlue;
        this.mAlpha = pAlpha;
    }

    public int getChildCount() {
        if (this.mChildren == null) {
            return 0;
        }
        return this.mChildren.size();
    }

    public IEntity getChild(int pIndex) {
        if (this.mChildren == null) {
            return null;
        }
        return (IEntity) this.mChildren.get(pIndex);
    }

    public int getChildIndex(IEntity pEntity) {
        if (this.mChildren == null || pEntity.getParent() != this) {
            return -1;
        }
        return this.mChildren.indexOf(pEntity);
    }

    public boolean setChildIndex(IEntity pEntity, int pIndex) {
        if (this.mChildren == null || pEntity.getParent() != this) {
            return false;
        }
        try {
            this.mChildren.remove(pEntity);
            this.mChildren.add(pIndex, pEntity);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public IEntity getFirstChild() {
        if (this.mChildren == null) {
            return null;
        }
        return (IEntity) this.mChildren.get(0);
    }

    public IEntity getLastChild() {
        if (this.mChildren == null) {
            return null;
        }
        return (IEntity) this.mChildren.get(this.mChildren.size() - 1);
    }

    public boolean detachSelf() {
        IEntity parent = this.mParent;
        if (parent != null) {
            return parent.detachChild((IEntity) this);
        }
        return false;
    }

    public void detachChildren() {
        if (this.mChildren != null) {
            this.mChildren.clear(PARAMETERCALLABLE_DETACHCHILD);
        }
    }

    public void attachChild(IEntity pEntity) throws IllegalStateException {
        if (pEntity.hasParent()) {
            throw new IllegalStateException("pEntity already has a parent!");
        }
        if (this.mChildren == null) {
            allocateChildren();
        }
        this.mChildren.add(pEntity);
        pEntity.setParent(this);
        pEntity.onAttached();
    }

    public boolean attachChild(IEntity pEntity, int pIndex) throws IllegalStateException {
        if (pEntity.hasParent()) {
            throw new IllegalStateException("pEntity already has a parent!");
        }
        if (this.mChildren == null) {
            allocateChildren();
        }
        try {
            this.mChildren.add(pIndex, pEntity);
            pEntity.setParent(this);
            pEntity.onAttached();
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public IEntity findChild(IEntityMatcher pEntityMatcher) {
        if (this.mChildren == null) {
            return null;
        }
        return (IEntity) this.mChildren.find(pEntityMatcher);
    }

    public boolean swapChildren(IEntity pEntityA, IEntity pEntityB) {
        return swapChildren(getChildIndex(pEntityA), getChildIndex(pEntityB));
    }

    public boolean swapChildren(int pIndexA, int pIndexB) {
        try {
            Collections.swap(this.mChildren, pIndexA, pIndexB);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public void sortChildren() {
        if (this.mChildren != null) {
            ZIndexSorter.getInstance().sort(this.mChildren);
        }
    }

    public void sortChildren(Comparator<IEntity> pEntityComparator) {
        if (this.mChildren != null) {
            ZIndexSorter.getInstance().sort(this.mChildren, (Comparator) pEntityComparator);
        }
    }

    public boolean detachChild(IEntity pEntity) {
        if (this.mChildren == null) {
            return false;
        }
        return this.mChildren.remove((Object) pEntity, PARAMETERCALLABLE_DETACHCHILD);
    }

    public IEntity detachChild(IEntityMatcher pEntityMatcher) {
        if (this.mChildren == null) {
            return null;
        }
        return (IEntity) this.mChildren.remove((IMatcher) pEntityMatcher, PARAMETERCALLABLE_DETACHCHILD);
    }

    public boolean detachChildren(IEntityMatcher pEntityMatcher) {
        if (this.mChildren == null) {
            return false;
        }
        return this.mChildren.removeAll(pEntityMatcher, PARAMETERCALLABLE_DETACHCHILD);
    }

    public void callOnChildren(IEntityCallable pEntityCallable) {
        if (this.mChildren != null) {
            this.mChildren.call(pEntityCallable);
        }
    }

    public void callOnChildren(IEntityMatcher pEntityMatcher, IEntityCallable pEntityCallable) {
        if (this.mChildren != null) {
            this.mChildren.call(pEntityMatcher, pEntityCallable);
        }
    }

    public void registerUpdateHandler(IUpdateHandler pUpdateHandler) {
        if (this.mUpdateHandlers == null) {
            allocateUpdateHandlers();
        }
        this.mUpdateHandlers.add(pUpdateHandler);
    }

    public boolean unregisterUpdateHandler(IUpdateHandler pUpdateHandler) {
        if (this.mUpdateHandlers == null) {
            return false;
        }
        return this.mUpdateHandlers.remove(pUpdateHandler);
    }

    public boolean unregisterUpdateHandlers(IUpdateHandlerMatcher pUpdateHandlerMatcher) {
        if (this.mUpdateHandlers == null) {
            return false;
        }
        return this.mUpdateHandlers.removeAll(pUpdateHandlerMatcher);
    }

    public void clearUpdateHandlers() {
        if (this.mUpdateHandlers != null) {
            this.mUpdateHandlers.clear();
        }
    }

    public void registerEntityModifier(IEntityModifier pEntityModifier) {
        if (this.mEntityModifiers == null) {
            allocateEntityModifiers();
        }
        this.mEntityModifiers.add(pEntityModifier);
    }

    public boolean unregisterEntityModifier(IEntityModifier pEntityModifier) {
        if (this.mEntityModifiers == null) {
            return false;
        }
        return this.mEntityModifiers.remove(pEntityModifier);
    }

    public boolean unregisterEntityModifiers(IEntityModifierMatcher pEntityModifierMatcher) {
        if (this.mEntityModifiers == null) {
            return false;
        }
        return this.mEntityModifiers.removeAll(pEntityModifierMatcher);
    }

    public void clearEntityModifiers() {
        if (this.mEntityModifiers != null) {
            this.mEntityModifiers.clear();
        }
    }

    public float[] getSceneCenterCoordinates() {
        return convertLocalToSceneCoordinates(0.0f, 0.0f);
    }

    public Transformation getLocalToParentTransformation() {
        Transformation localToParentTransformation = this.mLocalToParentTransformation;
        if (this.mLocalToParentTransformationDirty) {
            localToParentTransformation.setToIdentity();
            float scaleX = this.mScaleX;
            float scaleY = this.mScaleY;
            if (!(scaleX == 1.0f && scaleY == 1.0f)) {
                float scaleCenterX = this.mScaleCenterX;
                float scaleCenterY = this.mScaleCenterY;
                localToParentTransformation.postTranslate(-scaleCenterX, -scaleCenterY);
                localToParentTransformation.postScale(scaleX, scaleY);
                localToParentTransformation.postTranslate(scaleCenterX, scaleCenterY);
            }
            float rotation = this.mRotation;
            if (rotation != 0.0f) {
                float rotationCenterX = this.mRotationCenterX;
                float rotationCenterY = this.mRotationCenterY;
                localToParentTransformation.postTranslate(-rotationCenterX, -rotationCenterY);
                localToParentTransformation.postRotate(rotation);
                localToParentTransformation.postTranslate(rotationCenterX, rotationCenterY);
            }
            localToParentTransformation.postTranslate(this.mX, this.mY);
            this.mLocalToParentTransformationDirty = false;
        }
        return localToParentTransformation;
    }

    public Transformation getParentToLocalTransformation() {
        Transformation parentToLocalTransformation = this.mParentToLocalTransformation;
        if (this.mParentToLocalTransformationDirty) {
            parentToLocalTransformation.setToIdentity();
            parentToLocalTransformation.postTranslate(-this.mX, -this.mY);
            float rotation = this.mRotation;
            if (rotation != 0.0f) {
                float rotationCenterX = this.mRotationCenterX;
                float rotationCenterY = this.mRotationCenterY;
                parentToLocalTransformation.postTranslate(-rotationCenterX, -rotationCenterY);
                parentToLocalTransformation.postRotate(-rotation);
                parentToLocalTransformation.postTranslate(rotationCenterX, rotationCenterY);
            }
            float scaleX = this.mScaleX;
            float scaleY = this.mScaleY;
            if (!(scaleX == 1.0f && scaleY == 1.0f)) {
                float scaleCenterX = this.mScaleCenterX;
                float scaleCenterY = this.mScaleCenterY;
                parentToLocalTransformation.postTranslate(-scaleCenterX, -scaleCenterY);
                parentToLocalTransformation.postScale(1.0f / scaleX, 1.0f / scaleY);
                parentToLocalTransformation.postTranslate(scaleCenterX, scaleCenterY);
            }
            this.mParentToLocalTransformationDirty = false;
        }
        return parentToLocalTransformation;
    }

    public Transformation getLocalToSceneTransformation() {
        Transformation localToSceneTransformation = this.mLocalToSceneTransformation;
        localToSceneTransformation.setTo(getLocalToParentTransformation());
        IEntity parent = this.mParent;
        if (parent != null) {
            localToSceneTransformation.postConcat(parent.getLocalToSceneTransformation());
        }
        return localToSceneTransformation;
    }

    public Transformation getSceneToLocalTransformation() {
        Transformation sceneToLocalTransformation = this.mSceneToLocalTransformation;
        sceneToLocalTransformation.setTo(getParentToLocalTransformation());
        IEntity parent = this.mParent;
        if (parent != null) {
            sceneToLocalTransformation.postConcat(parent.getSceneToLocalTransformation());
        }
        return sceneToLocalTransformation;
    }

    public float[] convertLocalToSceneCoordinates(float pX, float pY) {
        return convertLocalToSceneCoordinates(pX, pY, VERTICES_LOCAL_TO_SCENE_TMP);
    }

    public float[] convertLocalToSceneCoordinates(float pX, float pY, float[] pReuse) {
        pReuse[0] = pX;
        pReuse[1] = pY;
        getLocalToSceneTransformation().transform(pReuse);
        return pReuse;
    }

    public float[] convertLocalToSceneCoordinates(float[] pCoordinates) {
        return convertSceneToLocalCoordinates(pCoordinates, VERTICES_LOCAL_TO_SCENE_TMP);
    }

    public float[] convertLocalToSceneCoordinates(float[] pCoordinates, float[] pReuse) {
        pReuse[0] = pCoordinates[0];
        pReuse[1] = pCoordinates[1];
        getLocalToSceneTransformation().transform(pReuse);
        return pReuse;
    }

    public float[] convertSceneToLocalCoordinates(float pX, float pY) {
        return convertSceneToLocalCoordinates(pX, pY, VERTICES_SCENE_TO_LOCAL_TMP);
    }

    public float[] convertSceneToLocalCoordinates(float pX, float pY, float[] pReuse) {
        pReuse[0] = pX;
        pReuse[1] = pY;
        getSceneToLocalTransformation().transform(pReuse);
        return pReuse;
    }

    public float[] convertSceneToLocalCoordinates(float[] pCoordinates) {
        return convertSceneToLocalCoordinates(pCoordinates, VERTICES_SCENE_TO_LOCAL_TMP);
    }

    public float[] convertSceneToLocalCoordinates(float[] pCoordinates, float[] pReuse) {
        pReuse[0] = pCoordinates[0];
        pReuse[1] = pCoordinates[1];
        getSceneToLocalTransformation().transform(pReuse);
        return pReuse;
    }

    public void onAttached() {
    }

    public void onDetached() {
    }

    public Object getUserData() {
        return this.mUserData;
    }

    public void setUserData(Object pUserData) {
        this.mUserData = pUserData;
    }

    public final void onDraw(GL10 pGL, Camera pCamera) {
        if (this.mVisible) {
            onManagedDraw(pGL, pCamera);
        }
    }

    public final void onUpdate(float pSecondsElapsed) {
        if (!this.mIgnoreUpdate) {
            onManagedUpdate(pSecondsElapsed);
        }
    }

    public void reset() {
        this.mVisible = true;
        this.mIgnoreUpdate = false;
        this.mChildrenVisible = true;
        this.mChildrenIgnoreUpdate = false;
        this.mX = this.mInitialX;
        this.mY = this.mInitialY;
        this.mRotation = 0.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mRed = 1.0f;
        this.mGreen = 1.0f;
        this.mBlue = 1.0f;
        this.mAlpha = 1.0f;
        if (this.mEntityModifiers != null) {
            this.mEntityModifiers.reset();
        }
        if (this.mChildren != null) {
            ArrayList<IEntity> entities = this.mChildren;
            for (int i = entities.size() - 1; i >= 0; i--) {
                ((IEntity) entities.get(i)).reset();
            }
        }
    }

    protected void doDraw(GL10 pGL, Camera pCamera) {
    }

    private void allocateEntityModifiers() {
        this.mEntityModifiers = new EntityModifierList(this, 4);
    }

    private void allocateChildren() {
        this.mChildren = new SmartList(4);
    }

    private void allocateUpdateHandlers() {
        this.mUpdateHandlers = new UpdateHandlerList(4);
    }

    protected void onApplyTransformations(GL10 pGL) {
        applyTranslation(pGL);
        applyRotation(pGL);
        applyScale(pGL);
    }

    protected void applyTranslation(GL10 pGL) {
        pGL.glTranslatef(this.mX, this.mY, 0.0f);
    }

    protected void applyRotation(GL10 pGL) {
        float rotation = this.mRotation;
        if (rotation != 0.0f) {
            float rotationCenterX = this.mRotationCenterX;
            float rotationCenterY = this.mRotationCenterY;
            pGL.glTranslatef(rotationCenterX, rotationCenterY, 0.0f);
            pGL.glRotatef(rotation, 0.0f, 0.0f, 1.0f);
            pGL.glTranslatef(-rotationCenterX, -rotationCenterY, 0.0f);
        }
    }

    protected void applyScale(GL10 pGL) {
        float scaleX = this.mScaleX;
        float scaleY = this.mScaleY;
        if (scaleX != 1.0f || scaleY != 1.0f) {
            float scaleCenterX = this.mScaleCenterX;
            float scaleCenterY = this.mScaleCenterY;
            pGL.glTranslatef(scaleCenterX, scaleCenterY, 0.0f);
            pGL.glScalef(scaleX, scaleY, 1.0f);
            pGL.glTranslatef(-scaleCenterX, -scaleCenterY, 0.0f);
        }
    }

    protected void onManagedDraw(GL10 pGL, Camera pCamera) {
        pGL.glPushMatrix();
        onApplyTransformations(pGL);
        doDraw(pGL, pCamera);
        onDrawChildren(pGL, pCamera);
        pGL.glPopMatrix();
    }

    protected void onDrawChildren(GL10 pGL, Camera pCamera) {
        if (this.mChildren != null && this.mChildrenVisible) {
            onManagedDrawChildren(pGL, pCamera);
        }
    }

    public void onManagedDrawChildren(GL10 pGL, Camera pCamera) {
        ArrayList<IEntity> children = this.mChildren;
        int childCount = children.size();
        for (int i = 0; i < childCount; i++) {
            ((IEntity) children.get(i)).onDraw(pGL, pCamera);
        }
    }

    protected void onManagedUpdate(float pSecondsElapsed) {
        if (this.mEntityModifiers != null) {
            this.mEntityModifiers.onUpdate(pSecondsElapsed);
        }
        if (this.mUpdateHandlers != null) {
            this.mUpdateHandlers.onUpdate(pSecondsElapsed);
        }
        if (this.mChildren != null && !this.mChildrenIgnoreUpdate) {
            ArrayList<IEntity> entities = this.mChildren;
            int entityCount = entities.size();
            for (int i = 0; i < entityCount; i++) {
                ((IEntity) entities.get(i)).onUpdate(pSecondsElapsed);
            }
        }
    }
}
