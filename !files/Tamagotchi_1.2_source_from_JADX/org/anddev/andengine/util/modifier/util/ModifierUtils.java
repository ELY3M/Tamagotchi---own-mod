package org.anddev.andengine.util.modifier.util;

import org.anddev.andengine.util.modifier.IModifier;

public class ModifierUtils {
    public static float getSequenceDurationOfModifier(IModifier<?>[] pModifiers) {
        float duration = Float.MIN_VALUE;
        for (int i = pModifiers.length - 1; i >= 0; i--) {
            duration += pModifiers[i].getDuration();
        }
        return duration;
    }
}
