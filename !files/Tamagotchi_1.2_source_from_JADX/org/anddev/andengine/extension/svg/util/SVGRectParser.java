package org.anddev.andengine.extension.svg.util;

import android.graphics.Canvas;
import android.graphics.RectF;
import org.anddev.andengine.extension.svg.adt.SVGPaint;
import org.anddev.andengine.extension.svg.adt.SVGProperties;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public class SVGRectParser implements ISVGConstants {
    public static void parse(SVGProperties pSVGProperties, Canvas pCanvas, SVGPaint pSVGPaint, RectF pRect) {
        float rx;
        float ry;
        float x = pSVGProperties.getFloatAttribute("x", 0.0f);
        float y = pSVGProperties.getFloatAttribute("y", 0.0f);
        float width = pSVGProperties.getFloatAttribute("width", 0.0f);
        float height = pSVGProperties.getFloatAttribute("height", 0.0f);
        pRect.set(x, y, x + width, y + height);
        Float rX = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_RADIUS_X);
        Float rY = pSVGProperties.getFloatAttribute(ISVGConstants.ATTRIBUTE_RADIUS_Y);
        boolean rXSpecified = rX != null && rX.floatValue() >= 0.0f;
        boolean rYSpecified = rY != null && rY.floatValue() >= 0.0f;
        boolean rounded = rXSpecified || rYSpecified;
        if (rXSpecified && rYSpecified) {
            rx = Math.min(rX.floatValue(), 0.5f * width);
            ry = Math.min(rY.floatValue(), 0.5f * height);
        } else if (rXSpecified) {
            rx = Math.min(rX.floatValue(), 0.5f * width);
            ry = rx;
        } else if (rYSpecified) {
            ry = Math.min(rY.floatValue(), 0.5f * height);
            rx = ry;
        } else {
            rx = 0.0f;
            ry = 0.0f;
        }
        boolean fill = pSVGPaint.setFill(pSVGProperties);
        if (fill) {
            if (rounded) {
                pCanvas.drawRoundRect(pRect, rx, ry, pSVGPaint.getPaint());
            } else {
                pCanvas.drawRect(pRect, pSVGPaint.getPaint());
            }
        }
        boolean stroke = pSVGPaint.setStroke(pSVGProperties);
        if (stroke) {
            if (rounded) {
                pCanvas.drawRoundRect(pRect, rx, ry, pSVGPaint.getPaint());
            } else {
                pCanvas.drawRect(pRect, pSVGPaint.getPaint());
            }
        }
        if (fill || stroke) {
            pSVGPaint.ensureComputedBoundsInclude(x, y, width, height);
        }
    }
}
