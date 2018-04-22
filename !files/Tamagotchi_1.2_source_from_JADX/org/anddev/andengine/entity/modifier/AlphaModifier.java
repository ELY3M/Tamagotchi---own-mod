package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public class AlphaModifier extends SingleValueSpanEntityModifier {
    public AlphaModifier(float pDuration, float pFromAlpha, float pToAlpha) {
        this(pDuration, pFromAlpha, pToAlpha, null, IEaseFunction.DEFAULT);
    }

    public AlphaModifier(float pDuration, float pFromAlpha, float pToAlpha, IEaseFunction pEaseFunction) {
        this(pDuration, pFromAlpha, pToAlpha, null, pEaseFunction);
    }

    public AlphaModifier(float pDuration, float pFromAlpha, float pToAlpha, IEntityModifierListener pEntityModifierListener) {
        super(pDuration, pFromAlpha, pToAlpha, pEntityModifierListener, IEaseFunction.DEFAULT);
    }

    public AlphaModifier(float pDuration, float pFromAlpha, float pToAlpha, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        super(pDuration, pFromAlpha, pToAlpha, pEntityModifierListener, pEaseFunction);
    }

    protected AlphaModifier(AlphaModifier pAlphaModifier) {
        super(pAlphaModifier);
    }

    public AlphaModifier deepCopy() {
        return new AlphaModifier(this);
    }

    protected void onSetInitialValue(IEntity pEntity, float pAlpha) {
        pEntity.setAlpha(pAlpha);
    }

    protected void onSetValue(IEntity pEntity, float pPercentageDone, float pAlpha) {
        pEntity.setAlpha(pAlpha);
    }
}
