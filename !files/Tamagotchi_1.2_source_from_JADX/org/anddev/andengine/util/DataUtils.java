package org.anddev.andengine.util;

import org.anddev.andengine.util.constants.DataConstants;

public class DataUtils implements DataConstants {
    public static int unsignedByteToInt(byte bByte) {
        return bByte & 255;
    }
}
