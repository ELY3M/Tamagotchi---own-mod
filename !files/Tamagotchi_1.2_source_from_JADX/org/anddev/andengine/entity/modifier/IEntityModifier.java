package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.util.IMatcher;
import org.anddev.andengine.util.modifier.IModifier;
import org.anddev.andengine.util.modifier.IModifier.DeepCopyNotSupportedException;
import org.anddev.andengine.util.modifier.IModifier.IModifierListener;

public interface IEntityModifier extends IModifier<IEntity> {

    public interface IEntityModifierListener extends IModifierListener<IEntity> {
    }

    public interface IEntityModifierMatcher extends IMatcher<IModifier<IEntity>> {
    }

    IEntityModifier deepCopy() throws DeepCopyNotSupportedException;
}
