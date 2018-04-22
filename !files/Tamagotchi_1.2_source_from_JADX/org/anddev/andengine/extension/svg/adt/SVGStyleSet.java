package org.anddev.andengine.extension.svg.adt;

import java.util.HashMap;

public class SVGStyleSet {
    private final HashMap<String, String> mStyleMap = new HashMap();

    public SVGStyleSet(String pString) {
        for (String s : pString.split(";")) {
            String[] style = s.split(":");
            if (style.length == 2) {
                this.mStyleMap.put(style[0], style[1]);
            }
        }
    }

    public String getStyle(String pStyleName) {
        return (String) this.mStyleMap.get(pStyleName);
    }
}
