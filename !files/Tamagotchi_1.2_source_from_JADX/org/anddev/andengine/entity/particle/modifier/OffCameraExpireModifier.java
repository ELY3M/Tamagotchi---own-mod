package org.anddev.andengine.entity.particle.modifier;

import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.particle.Particle;

public class OffCameraExpireModifier implements IParticleModifier {
    private final Camera mCamera;

    public OffCameraExpireModifier(Camera pCamera) {
        this.mCamera = pCamera;
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public void onInitializeParticle(Particle pParticle) {
    }

    public void onUpdateParticle(Particle pParticle) {
        if (!this.mCamera.isRectangularShapeVisible(pParticle)) {
            pParticle.setDead(true);
        }
    }
}
