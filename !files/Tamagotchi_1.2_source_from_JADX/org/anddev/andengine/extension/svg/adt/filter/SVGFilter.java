package org.anddev.andengine.extension.svg.adt.filter;

import android.graphics.Paint;
import java.util.ArrayList;
import java.util.HashMap;
import org.anddev.andengine.extension.svg.adt.SVGAttributes;
import org.anddev.andengine.extension.svg.adt.filter.element.ISVGFilterElement;
import org.anddev.andengine.extension.svg.exception.SVGParseException;
import org.anddev.andengine.extension.svg.util.SVGParserUtils;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;
import org.xml.sax.Attributes;

public class SVGFilter implements ISVGConstants {
    private final String mHref;
    private final String mID;
    private SVGFilter mParent;
    private final SVGAttributes mSVGAttributes;
    private final ArrayList<ISVGFilterElement> mSVGFilterElements = new ArrayList();

    public SVGFilter(String pID, Attributes pAttributes) {
        this.mID = pID;
        this.mHref = SVGParserUtils.parseHref(pAttributes);
        this.mSVGAttributes = new SVGAttributes(pAttributes, true);
    }

    public String getID() {
        return this.mID;
    }

    public String getHref() {
        return this.mHref;
    }

    public boolean hasHref() {
        return this.mHref != null;
    }

    public boolean hasHrefResolved() {
        return this.mHref == null || this.mParent != null;
    }

    public void ensureHrefResolved(HashMap<String, SVGFilter> pSVGFilterMap) {
        if (!hasHrefResolved()) {
            resolveHref(pSVGFilterMap);
        }
    }

    private void resolveHref(HashMap<String, SVGFilter> pSVGFilterMap) {
        SVGFilter parent = (SVGFilter) pSVGFilterMap.get(this.mHref);
        if (parent == null) {
            throw new SVGParseException("Could not resolve href: '" + this.mHref + "' of SVGGradient: '" + this.mID + "'.");
        }
        parent.ensureHrefResolved(pSVGFilterMap);
        this.mParent = parent;
        this.mSVGAttributes.setParentSVGAttributes(this.mParent.mSVGAttributes);
    }

    public void applyFilterElements(Paint pPaint) {
        this.mSVGAttributes.getFloatAttribute("x", true);
        ArrayList<ISVGFilterElement> svgFilterElements = this.mSVGFilterElements;
        for (int i = 0; i < svgFilterElements.size(); i++) {
            ((ISVGFilterElement) svgFilterElements.get(i)).apply(pPaint);
        }
    }

    public void addFilterElement(ISVGFilterElement pSVGFilterElement) {
        this.mSVGFilterElements.add(pSVGFilterElement);
    }
}
