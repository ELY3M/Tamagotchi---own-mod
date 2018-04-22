package org.anddev.andengine.extension.svg.adt;

import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import java.util.ArrayList;
import java.util.HashMap;
import org.anddev.andengine.extension.svg.exception.SVGParseException;
import org.anddev.andengine.extension.svg.util.SVGParserUtils;
import org.anddev.andengine.extension.svg.util.SVGTransformParser;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;
import org.xml.sax.Attributes;

public class SVGGradient implements ISVGConstants {
    private final String mHref;
    private final String mID;
    private final boolean mLinear;
    private Matrix mMatrix;
    private SVGGradient mParent;
    private final SVGAttributes mSVGAttributes;
    private ArrayList<SVGGradientStop> mSVGGradientStops;
    private boolean mSVGGradientStopsBuilt;
    private int[] mSVGGradientStopsColors;
    private float[] mSVGGradientStopsPositions;
    private Shader mShader;

    public static class SVGGradientStop {
        private final int mColor;
        private final float mOffset;

        public SVGGradientStop(float pOffset, int pColor) {
            this.mOffset = pOffset;
            this.mColor = pColor;
        }
    }

    public SVGGradient(String pID, boolean pLinear, Attributes pAttributes) {
        this.mID = pID;
        this.mHref = SVGParserUtils.parseHref(pAttributes);
        this.mLinear = pLinear;
        this.mSVGAttributes = new SVGAttributes(pAttributes, true);
    }

    public boolean hasHref() {
        return this.mHref != null;
    }

    public String getHref() {
        return this.mHref;
    }

    public String getID() {
        return this.mID;
    }

    public boolean hasHrefResolved() {
        return this.mHref == null || this.mParent != null;
    }

    public Shader getShader() {
        return this.mShader;
    }

    public Shader createShader() {
        if (this.mShader != null) {
            return this.mShader;
        }
        if (!this.mSVGGradientStopsBuilt) {
            buildSVGGradientStopsArrays();
        }
        TileMode tileMode = getTileMode();
        if (this.mLinear) {
            this.mShader = new LinearGradient(this.mSVGAttributes.getFloatAttribute(ISVGConstants.ATTRIBUTE_X1, true, 0.0f).floatValue(), this.mSVGAttributes.getFloatAttribute(ISVGConstants.ATTRIBUTE_Y1, true, 0.0f).floatValue(), this.mSVGAttributes.getFloatAttribute(ISVGConstants.ATTRIBUTE_X2, true, 0.0f).floatValue(), this.mSVGAttributes.getFloatAttribute(ISVGConstants.ATTRIBUTE_Y2, true, 0.0f).floatValue(), this.mSVGGradientStopsColors, this.mSVGGradientStopsPositions, tileMode);
        } else {
            this.mShader = new RadialGradient(this.mSVGAttributes.getFloatAttribute(ISVGConstants.ATTRIBUTE_CENTER_X, true, 0.0f).floatValue(), this.mSVGAttributes.getFloatAttribute(ISVGConstants.ATTRIBUTE_CENTER_Y, true, 0.0f).floatValue(), this.mSVGAttributes.getFloatAttribute(ISVGConstants.ATTRIBUTE_RADIUS, true, 0.0f).floatValue(), this.mSVGGradientStopsColors, this.mSVGGradientStopsPositions, tileMode);
        }
        this.mMatrix = getTransform();
        if (this.mMatrix != null) {
            this.mShader.setLocalMatrix(this.mMatrix);
        }
        return this.mShader;
    }

    private TileMode getTileMode() {
        String spreadMethod = this.mSVGAttributes.getStringAttribute(ISVGConstants.ATTRIBUTE_SPREADMETHOD, true);
        if (spreadMethod == null || ISVGConstants.ATTRIBUTE_SPREADMETHOD_VALUE_PAD.equals(spreadMethod)) {
            return TileMode.CLAMP;
        }
        if (ISVGConstants.ATTRIBUTE_SPREADMETHOD_VALUE_REFLECT.equals(spreadMethod)) {
            return TileMode.MIRROR;
        }
        if (ISVGConstants.ATTRIBUTE_SPREADMETHOD_VALUE_REPEAT.equals(spreadMethod)) {
            return TileMode.REPEAT;
        }
        throw new SVGParseException("Unexpected spreadmethod: '" + spreadMethod + "'.");
    }

    private Matrix getTransform() {
        if (this.mMatrix != null) {
            return this.mMatrix;
        }
        String transfromString = this.mSVGAttributes.getStringAttribute(ISVGConstants.ATTRIBUTE_GRADIENT_TRANSFORM, false);
        if (transfromString != null) {
            this.mMatrix = SVGTransformParser.parseTransform(transfromString);
            return this.mMatrix;
        } else if (this.mParent != null) {
            return this.mParent.getTransform();
        } else {
            return null;
        }
    }

    public void ensureHrefResolved(HashMap<String, SVGGradient> pSVGGradientMap) {
        if (!hasHrefResolved()) {
            resolveHref(pSVGGradientMap);
        }
    }

    private void resolveHref(HashMap<String, SVGGradient> pSVGGradientMap) {
        SVGGradient parent = (SVGGradient) pSVGGradientMap.get(this.mHref);
        if (parent == null) {
            throw new SVGParseException("Could not resolve href: '" + this.mHref + "' of SVGGradient: '" + this.mID + "'.");
        }
        parent.ensureHrefResolved(pSVGGradientMap);
        this.mParent = parent;
        this.mSVGAttributes.setParentSVGAttributes(this.mParent.mSVGAttributes);
        if (this.mSVGGradientStops == null) {
            this.mSVGGradientStops = this.mParent.mSVGGradientStops;
            this.mSVGGradientStopsColors = this.mParent.mSVGGradientStopsColors;
            this.mSVGGradientStopsPositions = this.mParent.mSVGGradientStopsPositions;
        }
    }

    private void buildSVGGradientStopsArrays() {
        this.mSVGGradientStopsBuilt = true;
        ArrayList<SVGGradientStop> svgGradientStops = this.mSVGGradientStops;
        int svgGradientStopCount = svgGradientStops.size();
        this.mSVGGradientStopsColors = new int[svgGradientStopCount];
        this.mSVGGradientStopsPositions = new float[svgGradientStopCount];
        for (int i = 0; i < svgGradientStopCount; i++) {
            SVGGradientStop svgGradientStop = (SVGGradientStop) svgGradientStops.get(i);
            this.mSVGGradientStopsColors[i] = svgGradientStop.mColor;
            this.mSVGGradientStopsPositions[i] = svgGradientStop.mOffset;
        }
    }

    public void addSVGGradientStop(SVGGradientStop pSVGGradientStop) {
        if (this.mSVGGradientStops == null) {
            this.mSVGGradientStops = new ArrayList();
        }
        this.mSVGGradientStops.add(pSVGGradientStop);
    }
}
