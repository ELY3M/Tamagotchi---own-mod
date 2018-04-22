package org.anddev.andengine.extension.svg.util;

import android.graphics.Matrix;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.anddev.andengine.extension.svg.exception.SVGParseException;
import org.anddev.andengine.extension.svg.util.SVGNumberParser.SVGNumberParserFloatResult;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public class SVGTransformParser implements ISVGConstants {
    private static final Pattern MULTITRANSFORM_PATTERN = Pattern.compile("(\\w+\\([\\d\\s\\-eE,]*\\))");

    public static Matrix parseTransform(String pString) {
        if (pString == null) {
            return null;
        }
        if (pString.indexOf(41) == pString.lastIndexOf(41)) {
            return parseSingleTransform(pString);
        }
        return parseMultiTransform(pString);
    }

    private static Matrix parseMultiTransform(String pString) {
        Matcher matcher = MULTITRANSFORM_PATTERN.matcher(pString);
        Matrix matrix = new Matrix();
        while (matcher.find()) {
            matrix.preConcat(parseSingleTransform(matcher.group(1)));
        }
        return matrix;
    }

    private static Matrix parseSingleTransform(String pString) {
        try {
            if (pString.startsWith(ISVGConstants.ATTRIBUTE_TRANSFORM_VALUE_MATRIX)) {
                return parseTransformMatrix(pString);
            }
            if (pString.startsWith(ISVGConstants.ATTRIBUTE_TRANSFORM_VALUE_TRANSLATE)) {
                return parseTransformTranslate(pString);
            }
            if (pString.startsWith(ISVGConstants.ATTRIBUTE_TRANSFORM_VALUE_SCALE)) {
                return parseTransformScale(pString);
            }
            if (pString.startsWith(ISVGConstants.ATTRIBUTE_TRANSFORM_VALUE_SKEW_X)) {
                return parseTransformSkewX(pString);
            }
            if (pString.startsWith(ISVGConstants.ATTRIBUTE_TRANSFORM_VALUE_SKEW_Y)) {
                return parseTransformSkewY(pString);
            }
            if (pString.startsWith(ISVGConstants.ATTRIBUTE_TRANSFORM_VALUE_ROTATE)) {
                return parseTransformRotate(pString);
            }
            throw new SVGParseException("Unexpected transform type: '" + pString + "'.");
        } catch (SVGParseException e) {
            throw new SVGParseException("Could not parse transform: '" + pString + "'.", e);
        }
    }

    public static Matrix parseTransformRotate(String pString) {
        SVGNumberParserFloatResult svgNumberParserFloatResult = SVGNumberParser.parseFloats(pString.substring(ISVGConstants.ATTRIBUTE_TRANSFORM_VALUE_ROTATE.length() + 1, pString.indexOf(41)));
        assertNumberParserResultNumberCountMinimum(svgNumberParserFloatResult, 1);
        float angle = svgNumberParserFloatResult.getNumber(0);
        float cx = 0.0f;
        float cy = 0.0f;
        if (svgNumberParserFloatResult.getNumberCount() > 2) {
            cx = svgNumberParserFloatResult.getNumber(1);
            cy = svgNumberParserFloatResult.getNumber(2);
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate(cx, cy);
        matrix.postRotate(angle);
        matrix.postTranslate(-cx, -cy);
        return matrix;
    }

    private static Matrix parseTransformSkewY(String pString) {
        SVGNumberParserFloatResult svgNumberParserFloatResult = SVGNumberParser.parseFloats(pString.substring(ISVGConstants.ATTRIBUTE_TRANSFORM_VALUE_SKEW_Y.length() + 1, pString.indexOf(41)));
        assertNumberParserResultNumberCountMinimum(svgNumberParserFloatResult, 1);
        float angle = svgNumberParserFloatResult.getNumber(0);
        Matrix matrix = new Matrix();
        matrix.postSkew(0.0f, (float) Math.tan((double) angle));
        return matrix;
    }

    private static Matrix parseTransformSkewX(String pString) {
        SVGNumberParserFloatResult svgNumberParserFloatResult = SVGNumberParser.parseFloats(pString.substring(ISVGConstants.ATTRIBUTE_TRANSFORM_VALUE_SKEW_X.length() + 1, pString.indexOf(41)));
        assertNumberParserResultNumberCountMinimum(svgNumberParserFloatResult, 1);
        float angle = svgNumberParserFloatResult.getNumber(0);
        Matrix matrix = new Matrix();
        matrix.postSkew((float) Math.tan((double) angle), 0.0f);
        return matrix;
    }

    private static Matrix parseTransformScale(String pString) {
        SVGNumberParserFloatResult svgNumberParserFloatResult = SVGNumberParser.parseFloats(pString.substring(ISVGConstants.ATTRIBUTE_TRANSFORM_VALUE_SCALE.length() + 1, pString.indexOf(41)));
        assertNumberParserResultNumberCountMinimum(svgNumberParserFloatResult, 1);
        float sx = svgNumberParserFloatResult.getNumber(0);
        float sy = 0.0f;
        if (svgNumberParserFloatResult.getNumberCount() > 1) {
            sy = svgNumberParserFloatResult.getNumber(1);
        }
        Matrix matrix = new Matrix();
        matrix.postScale(sx, sy);
        return matrix;
    }

    private static Matrix parseTransformTranslate(String pString) {
        SVGNumberParserFloatResult svgNumberParserFloatResult = SVGNumberParser.parseFloats(pString.substring(ISVGConstants.ATTRIBUTE_TRANSFORM_VALUE_TRANSLATE.length() + 1, pString.indexOf(41)));
        assertNumberParserResultNumberCountMinimum(svgNumberParserFloatResult, 1);
        float tx = svgNumberParserFloatResult.getNumber(0);
        float ty = 0.0f;
        if (svgNumberParserFloatResult.getNumberCount() > 1) {
            ty = svgNumberParserFloatResult.getNumber(1);
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate(tx, ty);
        return matrix;
    }

    private static Matrix parseTransformMatrix(String pString) {
        assertNumberParserResultNumberCount(SVGNumberParser.parseFloats(pString.substring(ISVGConstants.ATTRIBUTE_TRANSFORM_VALUE_MATRIX.length() + 1, pString.indexOf(41))), 6);
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{svgNumberParserFloatResult.getNumber(0), svgNumberParserFloatResult.getNumber(2), svgNumberParserFloatResult.getNumber(4), svgNumberParserFloatResult.getNumber(1), svgNumberParserFloatResult.getNumber(3), svgNumberParserFloatResult.getNumber(5), 0.0f, 0.0f, 1.0f});
        return matrix;
    }

    private static void assertNumberParserResultNumberCountMinimum(SVGNumberParserFloatResult pSVGNumberParserFloatResult, int pNumberParserResultNumberCountMinimum) {
        int svgNumberParserFloatResultNumberCount = pSVGNumberParserFloatResult.getNumberCount();
        if (svgNumberParserFloatResultNumberCount < pNumberParserResultNumberCountMinimum) {
            throw new SVGParseException("Not enough data. Minimum Expected: '" + pNumberParserResultNumberCountMinimum + "'. Actual: '" + svgNumberParserFloatResultNumberCount + "'.");
        }
    }

    private static void assertNumberParserResultNumberCount(SVGNumberParserFloatResult pSVGNumberParserFloatResult, int pNumberParserResultNumberCount) {
        int svgNumberParserFloatResultNumberCount = pSVGNumberParserFloatResult.getNumberCount();
        if (svgNumberParserFloatResultNumberCount != pNumberParserResultNumberCount) {
            throw new SVGParseException("Unexpected number count. Expected: '" + pNumberParserResultNumberCount + "'. Actual: '" + svgNumberParserFloatResultNumberCount + "'.");
        }
    }
}
