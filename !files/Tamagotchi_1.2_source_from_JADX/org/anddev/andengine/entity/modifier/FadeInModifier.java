package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public class FadeInModifier extends AlphaModifier {
    public FadeInModifier(float pDuration) {
        super(pDuration, 0.0f, 1.0f, IEaseFunction.DEFAULT);
    }

    public FadeInModifier(float pDuration, IEaseFunction pEaseFunction) {
        super(pDuration, 0.0f, 1.0f, pEaseFunction);
    }

    public FadeInModifier(float pDuration, IEntityModifierListener pEntityModifierListener) {
        super(pDuration, 0.0f, 1.0f, pEntityModifierListener, IEaseFunction.DEFAULT);
    }

    public FadeInModifier(float pDuration, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        super(pDuration, 0.0f, 1.0f, pEntityModifierListener, pEaseFunction);
    }

    protected FadeInModifier(FadeInModifier pFadeInModifier) {
        super(pFadeInModifier);
    }

    public FadeInModifier deepCopy() {
        return new FadeInModifier(this);
    }
}
