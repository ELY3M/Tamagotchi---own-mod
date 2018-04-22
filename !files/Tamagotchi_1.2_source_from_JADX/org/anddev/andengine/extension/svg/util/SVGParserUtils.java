package org.anddev.andengine.extension.svg.util;

import android.graphics.Color;
import org.anddev.andengine.extension.svg.util.SVGNumberParser.SVGNumberParserIntegerResult;
import org.anddev.andengine.extension.svg.util.constants.ColorUtils;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;
import org.xml.sax.Attributes;

public class SVGParserUtils implements ISVGConstants {
    public static Float extractFloatAttribute(String pString) {
        if (pString == null) {
            return null;
        }
        try {
            if (pString.endsWith(ISVGConstants.UNIT_PX)) {
                return Float.valueOf(Float.parseFloat(pString.substring(0, pString.length() - 2)));
            }
            return Float.valueOf(Float.parseFloat(pString));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String extractIDFromURLProperty(String pProperty) {
        return pProperty.substring("url(#".length(), pProperty.length() - 1);
    }

    public static Integer extractColorFromRGBProperty(String pProperty) {
        SVGNumberParserIntegerResult svgNumberParserIntegerResult = SVGNumberParser.parseInts(pProperty.substring("rgb(".length(), pProperty.indexOf(41)));
        if (svgNumberParserIntegerResult.getNumberCount() == 3) {
            return Integer.valueOf(Color.argb(0, svgNumberParserIntegerResult.getNumber(0), svgNumberParserIntegerResult.getNumber(1), svgNumberParserIntegerResult.getNumber(2)));
        }
        return null;
    }

    public static Integer extraColorIntegerProperty(String pProperty) {
        return Integer.valueOf(Integer.parseInt(pProperty, 16));
    }

    public static Integer extractColorFromHexProperty(String pProperty) {
        String hexColorString = pProperty.substring(1).trim();
        if (hexColorString.length() == 3) {
            int parsedInt = Integer.parseInt(hexColorString, 16);
            int red = (parsedInt & ColorUtils.COLOR_MASK_12BIT_RGB_R) >> 8;
            int green = (parsedInt & ColorUtils.COLOR_MASK_12BIT_RGB_G) >> 4;
            int blue = (parsedInt & 15) >> 0;
            return Integer.valueOf(Color.argb(0, (red << 4) | red, (green << 4) | green, (blue << 4) | blue));
        } else if (hexColorString.length() == 6) {
            return Integer.valueOf(Integer.parseInt(hexColorString, 16));
        } else {
            return null;
        }
    }

    public static String parseHref(Attributes pAttributes) {
        String href = SAXHelper.getStringAttribute(pAttributes, ISVGConstants.ATTRIBUTE_HREF);
        if (href == null || !href.startsWith("#")) {
            return href;
        }
        return href.substring(1);
    }
}
