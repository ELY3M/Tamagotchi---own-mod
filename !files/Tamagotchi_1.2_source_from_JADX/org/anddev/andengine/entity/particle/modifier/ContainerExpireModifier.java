package org.anddev.andengine.entity.particle.modifier;

import java.util.ArrayList;
import java.util.List;
import org.anddev.andengine.entity.particle.Particle;

public class ContainerExpireModifier extends ExpireModifier {
    private final List<BaseSingleValueSpanModifier> mModifiers = new ArrayList();

    public ContainerExpireModifier(float pLifeTime) {
        super(pLifeTime);
    }

    public ContainerExpireModifier(float pMinLifeTime, float pMaxLifeTime) {
        super(pMinLifeTime, pMaxLifeTime);
    }

    public void onUpdateParticle(Particle pParticle) {
        for (BaseSingleValueSpanModifier modifier : this.mModifiers) {
            modifier.onUpdateParticle(pParticle, pParticle.getDeathTime());
        }
    }

    public void addParticleModifier(BaseSingleValueSpanModifier pModifier) {
        this.mModifiers.add(pModifier);
    }

    public boolean removeParticleModifier(BaseSingleValueSpanModifier pModifier) {
        return this.mModifiers.remove(pModifier);
    }
}
