package org.anddev.andengine.entity.particle.emitter;

import org.anddev.andengine.engine.handler.IUpdateHandler;

public interface IParticleEmitter extends IUpdateHandler {
    void getPositionOffset(float[] fArr);
}
