package org.anddev.andengine.entity.scene.popup;

import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.modifier.IEntityModifier;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.util.HorizontalAlign;

public class TextPopupScene extends PopupScene {
    private final Text mText;

    public TextPopupScene(Camera pCamera, Scene pParentScene, Font pFont, String pText, float pDurationSeconds) {
        this(pCamera, pParentScene, pFont, pText, pDurationSeconds, null, null);
    }

    public TextPopupScene(Camera pCamera, Scene pParentScene, Font pFont, String pText, float pDurationSeconds, IEntityModifier pShapeModifier) {
        this(pCamera, pParentScene, pFont, pText, pDurationSeconds, pShapeModifier, null);
    }

    public TextPopupScene(Camera pCamera, Scene pParentScene, Font pFont, String pText, float pDurationSeconds, Runnable pRunnable) {
        this(pCamera, pParentScene, pFont, pText, pDurationSeconds, null, pRunnable);
    }

    public TextPopupScene(Camera pCamera, Scene pParentScene, Font pFont, String pText, float pDurationSeconds, IEntityModifier pShapeModifier, Runnable pRunnable) {
        super(pCamera, pParentScene, pDurationSeconds, pRunnable);
        this.mText = new Text(0.0f, 0.0f, pFont, pText, HorizontalAlign.CENTER);
        centerShapeInCamera(this.mText);
        if (pShapeModifier != null) {
            this.mText.registerEntityModifier(pShapeModifier);
        }
        attachChild(this.mText);
    }

    public Text getText() {
        return this.mText;
    }
}
