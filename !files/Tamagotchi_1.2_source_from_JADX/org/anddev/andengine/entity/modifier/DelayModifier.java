package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;

public class DelayModifier extends DurationEntityModifier {
    public DelayModifier(float pDuration, IEntityModifierListener pEntityModifierListener) {
        super(pDuration, pEntityModifierListener);
    }

    public DelayModifier(float pDuration) {
        super(pDuration);
    }

    protected DelayModifier(DelayModifier pDelayModifier) {
        super((DurationEntityModifier) pDelayModifier);
    }

    public DelayModifier deepCopy() {
        return new DelayModifier(this);
    }

    protected void onManagedInitialize(IEntity pEntity) {
    }

    protected void onManagedUpdate(float pSecondsElapsed, IEntity pEntity) {
    }
}
