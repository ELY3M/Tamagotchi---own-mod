package org.anddev.andengine.extension.svg.util;

import org.xml.sax.Attributes;

public class SAXHelper {
    public static String getStringAttribute(Attributes pAttributes, String pAttributeName) {
        int attributeCount = pAttributes.getLength();
        for (int i = 0; i < attributeCount; i++) {
            if (pAttributes.getLocalName(i).equals(pAttributeName)) {
                return pAttributes.getValue(i);
            }
        }
        return null;
    }

    public static String getStringAttribute(Attributes pAttributes, String pAttributeName, String pDefaultValue) {
        String s = getStringAttribute(pAttributes, pAttributeName);
        return s == null ? pDefaultValue : s;
    }

    public static Float getFloatAttribute(Attributes pAttributes, String pAttributeName) {
        return SVGParserUtils.extractFloatAttribute(getStringAttribute(pAttributes, pAttributeName));
    }

    public static float getFloatAttribute(Attributes pAttributes, String pAttributeName, float pDefaultValue) {
        Float f = getFloatAttribute(pAttributes, pAttributeName);
        return f == null ? pDefaultValue : f.floatValue();
    }
}
