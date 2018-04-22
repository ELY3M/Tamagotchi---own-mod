package org.anddev.andengine.extension.svg.util;

import android.graphics.Canvas;
import android.graphics.RectF;
import org.anddev.andengine.extension.svg.adt.SVGPaint;
import org.anddev.andengine.extension.svg.adt.SVGProperties;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public class SVGEllipseParser implements ISVGConstants {
    public static void parse(SVGProperties pSVGProperties, Canvas pCanvas, SVGPaint pSVGPaint, RectF pRect) {
        Float centerX = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_CENTER_X);
        Float centerY = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_CENTER_Y);
        Float radiusX = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_RADIUS_X);
        Float radiusY = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_RADIUS_Y);
        if (centerX != null && centerY != null && radiusX != null && radiusY != null) {
            pRect.set(centerX.floatValue() - radiusX.floatValue(), centerY.floatValue() - radiusY.floatValue(), centerX.floatValue() + radiusX.floatValue(), centerY.floatValue() + radiusY.floatValue());
            boolean fill = pSVGPaint.setFill(pSVGProperties);
            if (fill) {
                pCanvas.drawOval(pRect, pSVGPaint.getPaint());
            }
            boolean stroke = pSVGPaint.setStroke(pSVGProperties);
            if (stroke) {
                pCanvas.drawOval(pRect, pSVGPaint.getPaint());
            }
            if (fill || stroke) {
                pSVGPaint.ensureComputedBoundsInclude(centerX.floatValue() - radiusX.floatValue(), centerY.floatValue() - radiusY.floatValue());
                pSVGPaint.ensureComputedBoundsInclude(centerX.floatValue() + radiusX.floatValue(), centerY.floatValue() + radiusY.floatValue());
            }
        }
    }
}
