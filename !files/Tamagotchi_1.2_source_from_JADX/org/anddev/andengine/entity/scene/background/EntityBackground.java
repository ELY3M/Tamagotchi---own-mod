package org.anddev.andengine.entity.scene.background;

import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.IEntity;

public class EntityBackground extends ColorBackground {
    protected IEntity mEntity;

    public EntityBackground(IEntity pEntity) {
        this.mEntity = pEntity;
    }

    public EntityBackground(float pRed, float pGreen, float pBlue, IEntity pEntity) {
        super(pRed, pGreen, pBlue);
        this.mEntity = pEntity;
    }

    public void onDraw(GL10 pGL, Camera pCamera) {
        super.onDraw(pGL, pCamera);
        this.mEntity.onDraw(pGL, pCamera);
    }
}
