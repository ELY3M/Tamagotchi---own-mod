package org.anddev.andengine.extension.svg.util;

import android.graphics.Canvas;
import org.anddev.andengine.extension.svg.adt.SVGPaint;
import org.anddev.andengine.extension.svg.adt.SVGProperties;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public class SVGCircleParser implements ISVGConstants {
    public static void parse(SVGProperties pSVGProperties, Canvas pCanvas, SVGPaint pSVGPaint) {
        Float centerX = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_CENTER_X);
        Float centerY = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_CENTER_Y);
        Float radius = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_RADIUS);
        if (centerX != null && centerY != null && radius != null) {
            boolean fill = pSVGPaint.setFill(pSVGProperties);
            if (fill) {
                pCanvas.drawCircle(centerX.floatValue(), centerY.floatValue(), radius.floatValue(), pSVGPaint.getPaint());
            }
            boolean stroke = pSVGPaint.setStroke(pSVGProperties);
            if (stroke) {
                pCanvas.drawCircle(centerX.floatValue(), centerY.floatValue(), radius.floatValue(), pSVGPaint.getPaint());
            }
            if (fill || stroke) {
                pSVGPaint.ensureComputedBoundsInclude(centerX.floatValue() - radius.floatValue(), centerY.floatValue() - radius.floatValue());
                pSVGPaint.ensureComputedBoundsInclude(centerX.floatValue() + radius.floatValue(), centerY.floatValue() + radius.floatValue());
            }
        }
    }
}
