package org.anddev.andengine.entity.scene.menu.item.decorator;

import org.anddev.andengine.entity.scene.menu.item.IMenuItem;

public class ScaleMenuItemDecorator extends BaseMenuItemDecorator {
    private final float mSelectedScale;
    private final float mUnselectedScale;

    public ScaleMenuItemDecorator(IMenuItem pMenuItem, float pSelectedScale, float pUnselectedScale) {
        super(pMenuItem);
        this.mSelectedScale = pSelectedScale;
        this.mUnselectedScale = pUnselectedScale;
        pMenuItem.setScale(pUnselectedScale);
    }

    public void onMenuItemSelected(IMenuItem pMenuItem) {
        setScale(this.mSelectedScale);
    }

    public void onMenuItemUnselected(IMenuItem pMenuItem) {
        setScale(this.mUnselectedScale);
    }

    public void onMenuItemReset(IMenuItem pMenuItem) {
        setScale(this.mUnselectedScale);
    }
}
