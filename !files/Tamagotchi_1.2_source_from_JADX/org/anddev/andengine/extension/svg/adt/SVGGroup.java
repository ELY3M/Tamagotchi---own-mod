package org.anddev.andengine.extension.svg.adt;

import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public class SVGGroup implements ISVGConstants {
    private final boolean mHasTransform;
    private final boolean mHidden;
    private final SVGProperties mSVGProperties;
    private final SVGGroup mSVGroupParent;

    public SVGGroup(SVGGroup pSVGroupParent, SVGProperties pSVGProperties, boolean pHasTransform) {
        this.mSVGroupParent = pSVGroupParent;
        this.mSVGProperties = pSVGProperties;
        this.mHasTransform = pHasTransform;
        boolean z = (this.mSVGroupParent != null && this.mSVGroupParent.isHidden()) || isDisplayNone();
        this.mHidden = z;
    }

    public boolean hasTransform() {
        return this.mHasTransform;
    }

    public SVGProperties getSVGProperties() {
        return this.mSVGProperties;
    }

    public boolean isHidden() {
        return this.mHidden;
    }

    private boolean isDisplayNone() {
        return ISVGConstants.VALUE_NONE.equals(this.mSVGProperties.getStringProperty(ISVGConstants.ATTRIBUTE_DISPLAY, false));
    }
}
