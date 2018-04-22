package org.anddev.andengine.entity.layer.tiled.tmx;

import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;
import org.xml.sax.Attributes;

public class TMXProperty implements TMXConstants {
    private final String mName;
    private final String mValue;

    public TMXProperty(Attributes pAttributes) {
        this.mName = pAttributes.getValue("", "name");
        this.mValue = pAttributes.getValue("", TMXConstants.TAG_PROPERTY_ATTRIBUTE_VALUE);
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    public String toString() {
        return this.mName + "='" + this.mValue + "'";
    }
}
