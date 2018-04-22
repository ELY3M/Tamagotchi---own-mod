package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public class FadeOutModifier extends AlphaModifier {
    public FadeOutModifier(float pDuration) {
        super(pDuration, 1.0f, 0.0f, IEaseFunction.DEFAULT);
    }

    public FadeOutModifier(float pDuration, IEaseFunction pEaseFunction) {
        super(pDuration, 1.0f, 0.0f, pEaseFunction);
    }

    public FadeOutModifier(float pDuration, IEntityModifierListener pEntityModifierListener) {
        super(pDuration, 1.0f, 0.0f, pEntityModifierListener, IEaseFunction.DEFAULT);
    }

    public FadeOutModifier(float pDuration, IEntityModifierListener pEntityModifierListener, IEaseFunction pEaseFunction) {
        super(pDuration, 1.0f, 0.0f, pEntityModifierListener, pEaseFunction);
    }

    protected FadeOutModifier(FadeOutModifier pFadeOutModifier) {
        super(pFadeOutModifier);
    }

    public FadeOutModifier deepCopy() {
        return new FadeOutModifier(this);
    }
}
