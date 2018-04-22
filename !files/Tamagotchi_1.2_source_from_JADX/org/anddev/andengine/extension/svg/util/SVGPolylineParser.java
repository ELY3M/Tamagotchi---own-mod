package org.anddev.andengine.extension.svg.util;

import android.graphics.Canvas;
import android.graphics.Path;
import org.anddev.andengine.extension.svg.adt.SVGPaint;
import org.anddev.andengine.extension.svg.adt.SVGProperties;
import org.anddev.andengine.extension.svg.util.SVGNumberParser.SVGNumberParserFloatResult;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public class SVGPolylineParser implements ISVGConstants {
    public static void parse(SVGProperties pSVGProperties, Canvas pCanvas, SVGPaint pSVGPaint) {
        SVGNumberParserFloatResult svgNumberParserFloatResult = SVGNumberParser.parseFloats(pSVGProperties.getStringAttribute(ISVGConstants.ATTRIBUTE_POINTS));
        if (svgNumberParserFloatResult != null) {
            float[] points = svgNumberParserFloatResult.getNumbers();
            if (points.length >= 2) {
                Path path = parse(points);
                boolean fill = pSVGPaint.setFill(pSVGProperties);
                if (fill) {
                    pCanvas.drawPath(path, pSVGPaint.getPaint());
                }
                boolean stroke = pSVGPaint.setStroke(pSVGProperties);
                if (stroke) {
                    pCanvas.drawPath(path, pSVGPaint.getPaint());
                }
                if (fill || stroke) {
                    pSVGPaint.ensureComputedBoundsInclude(path);
                }
            }
        }
    }

    static Path parse(float[] pPoints) {
        Path path = new Path();
        path.moveTo(pPoints[0], pPoints[1]);
        for (int i = 2; i < pPoints.length; i += 2) {
            path.lineTo(pPoints[i], pPoints[i + 1]);
        }
        return path;
    }
}
