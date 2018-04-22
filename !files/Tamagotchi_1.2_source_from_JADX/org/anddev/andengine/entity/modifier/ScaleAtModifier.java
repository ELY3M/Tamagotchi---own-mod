package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public class ScaleAtModifier extends ScaleModifier {
    private final float mScaleCenterX;
    private final float mScaleCenterY;

    public ScaleAtModifier(float pDuration, float pFromScale, float pToScale, float pScaleCenterX, float pScaleCenterY) {
        this(pDuration, pFromScale, pToScale, pScaleCenterX, pScaleCenterY, IEaseFunction.DEFAULT);
    }

    public ScaleAtModifier(float pDuration, float pFromScale, float pToScale, float pScaleCenterX, float pScaleCenterY, IEaseFunction pEaseFunction) {
        this(pDuration, pFromScale, pToScale, pScaleCenterX, pScaleCenterY, null, pEaseFunction);
    }

    public ScaleAtModifier(float pDuration, float pFromScale, float pToScale, float pScaleCenterX, float pScaleCenterY, IEntityModifierListener pEntityModifierListener) {
        this(pDuration, pFromScale, pToScale, pScaleCenterX, pScaleCenterY, pEntityModifierListener, IEaseFunction.DEFAULT);
    }

    public ScaleAtModifier(float pDuration, float pFromScale, float pToScale, float pScaleCenterX, float pScaleCenterY, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        this(pDuration, pFromScale, pToScale, pFromScale, pToScale, pScaleCenterX, pScaleCenterY, pEntityModifierListener, pEaseFunction);
    }

    public ScaleAtModifier(float pDuration, float pFromScaleX, float pToScaleX, float pFromScaleY, float pToScaleY, float pScaleCenterX, float pScaleCenterY) {
        this(pDuration, pFromScaleX, pToScaleX, pFromScaleY, pToScaleY, pScaleCenterX, pScaleCenterY, IEaseFunction.DEFAULT);
    }

    public ScaleAtModifier(float pDuration, float pFromScaleX, float pToScaleX, float pFromScaleY, float pToScaleY, float pScaleCenterX, float pScaleCenterY, IEaseFunction pEaseFunction) {
        this(pDuration, pFromScaleX, pToScaleX, pFromScaleY, pToScaleY, pScaleCenterX, pScaleCenterY, null, pEaseFunction);
    }

    public ScaleAtModifier(float pDuration, float pFromScaleX, float pToScaleX, float pFromScaleY, float pToScaleY, float pScaleCenterX, float pScaleCenterY, IEntityModifierListener pEntityModifierListener) {
        this(pDuration, pFromScaleX, pToScaleX, pFromScaleY, pToScaleY, pScaleCenterX, pScaleCenterY, pEntityModifierListener, IEaseFunction.DEFAULT);
    }

    public ScaleAtModifier(float pDuration, float pFromScaleX, float pToScaleX, float pFromScaleY, float pToScaleY, float pScaleCenterX, float pScaleCenterY, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        super(pDuration, pFromScaleX, pToScaleX, pFromScaleY, pToScaleY, pEntityModifierListener, pEaseFunction);
        this.mScaleCenterX = pScaleCenterX;
        this.mScaleCenterY = pScaleCenterY;
    }

    protected ScaleAtModifier(ScaleAtModifier pScaleAtModifier) {
        super(pScaleAtModifier);
        this.mScaleCenterX = pScaleAtModifier.mScaleCenterX;
        this.mScaleCenterY = pScaleAtModifier.mScaleCenterY;
    }

    public ScaleAtModifier deepCopy() {
        return new ScaleAtModifier(this);
    }

    protected void onManagedInitialize(IEntity pEntity) {
        super.onManagedInitialize(pEntity);
        pEntity.setScaleCenter(this.mScaleCenterX, this.mScaleCenterY);
    }
}
