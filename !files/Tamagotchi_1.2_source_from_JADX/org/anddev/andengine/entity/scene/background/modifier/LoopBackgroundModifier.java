package org.anddev.andengine.entity.scene.background.modifier;

import org.anddev.andengine.entity.scene.background.IBackground;
import org.anddev.andengine.entity.scene.background.modifier.IBackgroundModifier.IBackgroundModifierListener;
import org.anddev.andengine.util.modifier.IModifier;
import org.anddev.andengine.util.modifier.IModifier.DeepCopyNotSupportedException;
import org.anddev.andengine.util.modifier.IModifier.IModifierListener;
import org.anddev.andengine.util.modifier.LoopModifier;
import org.anddev.andengine.util.modifier.LoopModifier.ILoopModifierListener;

public class LoopBackgroundModifier extends LoopModifier<IBackground> implements IBackgroundModifier {

    public interface ILoopBackgroundModifierListener extends ILoopModifierListener<IBackground> {
    }

    public LoopBackgroundModifier(IBackgroundModifier pBackgroundModifier) {
        super((IModifier) pBackgroundModifier);
    }

    public LoopBackgroundModifier(IBackgroundModifier pBackgroundModifier, int pLoopCount) {
        super(pBackgroundModifier, pLoopCount);
    }

    public LoopBackgroundModifier(IBackgroundModifier pBackgroundModifier, int pLoopCount, ILoopBackgroundModifierListener pLoopModifierListener) {
        super(pBackgroundModifier, pLoopCount, pLoopModifierListener, null);
    }

    public LoopBackgroundModifier(IBackgroundModifier pBackgroundModifier, int pLoopCount, IBackgroundModifierListener pBackgroundModifierListener) {
        super((IModifier) pBackgroundModifier, pLoopCount, (IModifierListener) pBackgroundModifierListener);
    }

    public LoopBackgroundModifier(IBackgroundModifier pBackgroundModifier, int pLoopCount, ILoopBackgroundModifierListener pLoopModifierListener, IBackgroundModifierListener pBackgroundModifierListener) {
        super(pBackgroundModifier, pLoopCount, pLoopModifierListener, pBackgroundModifierListener);
    }

    protected LoopBackgroundModifier(LoopBackgroundModifier pLoopBackgroundModifier) throws DeepCopyNotSupportedException {
        super((LoopModifier) pLoopBackgroundModifier);
    }

    public LoopBackgroundModifier deepCopy() throws DeepCopyNotSupportedException {
        return new LoopBackgroundModifier(this);
    }
}
