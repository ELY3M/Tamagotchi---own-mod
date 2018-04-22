package org.anddev.andengine.entity.layer.tiled.tmx;

import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;
import org.anddev.andengine.util.SAXUtils;
import org.xml.sax.Attributes;

public class TMXObject implements TMXConstants {
    private final int mHeight;
    private final String mName;
    private final TMXProperties<TMXObjectProperty> mTMXObjectProperties = new TMXProperties();
    private final String mType;
    private final int mWidth;
    private final int mX;
    private final int mY;

    public TMXObject(Attributes pAttributes) {
        this.mName = pAttributes.getValue("", "name");
        this.mType = pAttributes.getValue("", TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE);
        this.mX = SAXUtils.getIntAttributeOrThrow(pAttributes, "x");
        this.mY = SAXUtils.getIntAttributeOrThrow(pAttributes, "y");
        this.mWidth = SAXUtils.getIntAttribute(pAttributes, "width", 0);
        this.mHeight = SAXUtils.getIntAttribute(pAttributes, "height", 0);
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void addTMXObjectProperty(TMXObjectProperty pTMXObjectProperty) {
        this.mTMXObjectProperties.add(pTMXObjectProperty);
    }

    public TMXProperties<TMXObjectProperty> getTMXObjectProperties() {
        return this.mTMXObjectProperties;
    }
}
