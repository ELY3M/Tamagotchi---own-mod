package org.anddev.andengine.entity.scene.background.modifier;

import org.anddev.andengine.entity.scene.background.IBackground;
import org.anddev.andengine.util.modifier.IModifier;
import org.anddev.andengine.util.modifier.IModifier.DeepCopyNotSupportedException;
import org.anddev.andengine.util.modifier.IModifier.IModifierListener;

public interface IBackgroundModifier extends IModifier<IBackground> {

    public interface IBackgroundModifierListener extends IModifierListener<IBackground> {
    }

    IBackgroundModifier deepCopy() throws DeepCopyNotSupportedException;
}
