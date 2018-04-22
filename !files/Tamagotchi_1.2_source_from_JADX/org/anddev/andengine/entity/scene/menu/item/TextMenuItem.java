package org.anddev.andengine.entity.scene.menu.item;

import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.opengl.font.Font;

public class TextMenuItem extends Text implements IMenuItem {
    private final int mID;

    public TextMenuItem(int pID, Font pFont, String pText) {
        super(0.0f, 0.0f, pFont, pText);
        this.mID = pID;
    }

    public int getID() {
        return this.mID;
    }

    public void onSelected() {
    }

    public void onUnselected() {
    }
}
