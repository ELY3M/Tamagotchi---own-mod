package org.anddev.andengine.extension.svg.adt;

import java.util.HashMap;

public class SVGDirectColorMapper implements ISVGColorMapper {
    private final HashMap<Integer, Integer> mColorMappings = new HashMap();

    public SVGDirectColorMapper(Integer pColorFrom, Integer pColorTo) {
        addColorMapping(pColorFrom, pColorTo);
    }

    public void addColorMapping(Integer pColorFrom, Integer pColorTo) {
        this.mColorMappings.put(pColorFrom, pColorTo);
    }

    public Integer mapColor(Integer pColor) {
        Integer mappedColor = (Integer) this.mColorMappings.get(pColor);
        return mappedColor == null ? pColor : mappedColor;
    }
}
