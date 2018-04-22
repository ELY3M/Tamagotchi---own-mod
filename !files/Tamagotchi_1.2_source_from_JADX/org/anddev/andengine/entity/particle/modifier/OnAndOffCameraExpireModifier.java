package org.anddev.andengine.entity.particle.modifier;

import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.particle.Particle;

public class OnAndOffCameraExpireModifier extends OffCameraExpireModifier {
    private boolean mHasBeenOnCamera = false;

    public OnAndOffCameraExpireModifier(Camera pCamera) {
        super(pCamera);
    }

    public void onUpdateParticle(Particle pParticle) {
        if (!this.mHasBeenOnCamera && getCamera().isRectangularShapeVisible(pParticle)) {
            this.mHasBeenOnCamera = true;
        }
        if (this.mHasBeenOnCamera) {
            super.onUpdateParticle(pParticle);
        }
    }
}
