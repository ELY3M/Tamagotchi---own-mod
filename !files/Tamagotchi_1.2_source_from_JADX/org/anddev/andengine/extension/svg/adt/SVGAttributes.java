package org.anddev.andengine.extension.svg.adt;

import org.anddev.andengine.extension.svg.util.SAXHelper;
import org.anddev.andengine.extension.svg.util.SVGParserUtils;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

public class SVGAttributes implements ISVGConstants {
    private final Attributes mAttributes;
    private SVGAttributes mParentSVGAttributes;

    public SVGAttributes(Attributes pAttributes, boolean pAttributesDeepCopy) {
        if (pAttributesDeepCopy) {
            pAttributes = new AttributesImpl(pAttributes);
        }
        this.mAttributes = pAttributes;
    }

    public SVGAttributes(SVGAttributes pParentSVGAttributes, Attributes pAttributes, boolean pAttributesDeepCopy) {
        if (pAttributesDeepCopy) {
            pAttributes = new AttributesImpl(pAttributes);
        }
        this.mAttributes = pAttributes;
        this.mParentSVGAttributes = pParentSVGAttributes;
    }

    public void setParentSVGAttributes(SVGAttributes pParentSVGAttributes) {
        this.mParentSVGAttributes = pParentSVGAttributes;
    }

    public String getStringAttribute(String pAttributeName, boolean pAllowParentSVGAttributes, String pDefaultValue) {
        String s = getStringAttribute(pAttributeName, pAllowParentSVGAttributes);
        return s == null ? pDefaultValue : s;
    }

    public String getStringAttribute(String pAttributeName, boolean pAllowParentSVGAttributes) {
        String s = SAXHelper.getStringAttribute(this.mAttributes, pAttributeName);
        if (s != null || !pAllowParentSVGAttributes) {
            return s;
        }
        if (this.mParentSVGAttributes == null) {
            return null;
        }
        return this.mParentSVGAttributes.getStringAttribute(pAttributeName, pAllowParentSVGAttributes);
    }

    public Float getFloatAttribute(String pAttributeName, boolean pAllowParentSVGAttributes) {
        return SVGParserUtils.extractFloatAttribute(getStringAttribute(pAttributeName, pAllowParentSVGAttributes));
    }

    public Float getFloatAttribute(String pAttributeName, boolean pAllowParentSVGAttributes, float pDefaultValue) {
        Float f = getFloatAttribute(pAttributeName, pAllowParentSVGAttributes);
        if (f == null) {
            return Float.valueOf(pDefaultValue);
        }
        return f;
    }
}
