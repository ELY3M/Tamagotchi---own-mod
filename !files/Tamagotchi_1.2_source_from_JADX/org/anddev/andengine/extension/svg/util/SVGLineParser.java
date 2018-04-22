package org.anddev.andengine.extension.svg.util;

import android.graphics.Canvas;
import org.anddev.andengine.extension.svg.adt.SVGPaint;
import org.anddev.andengine.extension.svg.adt.SVGProperties;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public class SVGLineParser implements ISVGConstants {
    public static void parse(SVGProperties pSVGProperties, Canvas pCanvas, SVGPaint pSVGPaint) {
        float x1 = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_X1, 0.0f);
        float x2 = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_X2, 0.0f);
        float y1 = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_Y1, 0.0f);
        float y2 = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_Y2, 0.0f);
        if (pSVGPaint.setStroke(pSVGProperties)) {
            pSVGPaint.ensureComputedBoundsInclude(x1, y1);
            pSVGPaint.ensureComputedBoundsInclude(x2, y2);
            pCanvas.drawLine(x1, y1, x2, y2, pSVGPaint.getPaint());
        }
    }
}
