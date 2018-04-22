package org.anddev.andengine.entity.layer.tiled.tmx;

import java.util.ArrayList;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;

public class TMXProperties<T extends TMXProperty> extends ArrayList<T> implements TMXConstants {
    private static final long serialVersionUID = 8912773556975105201L;

    public boolean containsTMXProperty(String pName, String pValue) {
        for (int i = size() - 1; i >= 0; i--) {
            TMXProperty tmxProperty = (TMXProperty) get(i);
            if (tmxProperty.getName().equals(pName) && tmxProperty.getValue().equals(pValue)) {
                return true;
            }
        }
        return false;
    }
}
