package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.BaseModifier;

public abstract class EntityModifier extends BaseModifier<IEntity> implements IEntityModifier {
    public EntityModifier(IEntityModifierListener pEntityModifierListener) {
        super(pEntityModifierListener);
    }
}
