package org.anddev.andengine.extension.svg.adt;

import org.anddev.andengine.extension.svg.util.SAXHelper;
import org.anddev.andengine.extension.svg.util.SVGParserUtils;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

public class SVGProperties implements ISVGConstants {
    private final Attributes mAttributes;
    private final SVGProperties mParentSVGProperties;
    private final SVGStyleSet mSVGStyleSet;

    public SVGProperties(SVGProperties pParentSVGProperties, Attributes pAttributes, boolean pAttributesDeepCopy) {
        Attributes attributesImpl;
        if (pAttributesDeepCopy) {
            attributesImpl = new AttributesImpl(pAttributes);
        } else {
            attributesImpl = pAttributes;
        }
        this.mAttributes = attributesImpl;
        this.mParentSVGProperties = pParentSVGProperties;
        String styleAttr = SAXHelper.getStringAttribute(pAttributes, ISVGConstants.ATTRIBUTE_STYLE);
        if (styleAttr != null) {
            this.mSVGStyleSet = new SVGStyleSet(styleAttr);
        } else {
            this.mSVGStyleSet = null;
        }
    }

    public String getStringProperty(String pPropertyName, String pDefaultValue) {
        String s = getStringProperty(pPropertyName);
        return s == null ? pDefaultValue : s;
    }

    public String getStringProperty(String pPropertyName) {
        return getStringProperty(pPropertyName, true);
    }

    public String getStringProperty(String pPropertyName, boolean pAllowParentSVGProperties) {
        String s = null;
        if (this.mSVGStyleSet != null) {
            s = this.mSVGStyleSet.getStyle(pPropertyName);
        }
        if (s == null) {
            s = SAXHelper.getStringAttribute(this.mAttributes, pPropertyName);
        }
        if (s != null || !pAllowParentSVGProperties) {
            return s;
        }
        if (this.mParentSVGProperties == null) {
            return null;
        }
        return this.mParentSVGProperties.getStringProperty(pPropertyName);
    }

    public Float getFloatProperty(String pPropertyName) {
        return SVGParserUtils.extractFloatAttribute(getStringProperty(pPropertyName));
    }

    public Float getFloatProperty(String pPropertyName, float pDefaultValue) {
        Float f = getFloatProperty(pPropertyName);
        if (f == null) {
            return Float.valueOf(pDefaultValue);
        }
        return f;
    }

    public String getStringAttribute(String pAttributeName) {
        return SAXHelper.getStringAttribute(this.mAttributes, pAttributeName);
    }

    public String getStringAttribute(String pAttributeName, String pDefaultValue) {
        return SAXHelper.getStringAttribute(this.mAttributes, pAttributeName, pDefaultValue);
    }

    public Float getFloatAttribute(String pAttributeName) {
        return SAXHelper.getFloatAttribute(this.mAttributes, pAttributeName);
    }

    public float getFloatAttribute(String pAttributeName, float pDefaultValue) {
        return SAXHelper.getFloatAttribute(this.mAttributes, pAttributeName, pDefaultValue);
    }

    public static boolean isURLProperty(String pProperty) {
        return pProperty.startsWith("url(#");
    }

    public static boolean isRGBProperty(String pProperty) {
        return pProperty.startsWith("rgb(");
    }

    public static boolean isHexProperty(String pProperty) {
        return pProperty.startsWith("#");
    }
}
