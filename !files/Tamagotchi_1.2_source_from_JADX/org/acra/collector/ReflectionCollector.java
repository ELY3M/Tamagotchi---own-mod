package org.acra.collector;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

final class ReflectionCollector {
    private ReflectionCollector() {
    }

    @NonNull
    public static String collectConstants(@NonNull Class<?> someClass, @Nullable String prefix) {
        StringBuilder result = new StringBuilder();
        for (Field field : someClass.getFields()) {
            if (prefix != null && prefix.length() > 0) {
                result.append(prefix).append('.');
            }
            result.append(field.getName()).append("=");
            try {
                Object value = field.get(null);
                if (value != null) {
                    if (field.getType().isArray()) {
                        result.append(Arrays.toString((Object[]) value));
                    } else {
                        result.append(value.toString());
                    }
                }
            } catch (IllegalArgumentException e) {
                result.append("N/A");
            } catch (IllegalAccessException e2) {
                result.append("N/A");
            }
            result.append("\n");
        }
        return result.toString();
    }

    @NonNull
    public static String collectStaticGettersResults(@NonNull Class<?> someClass) {
        StringBuilder result = new StringBuilder();
        for (Method method : someClass.getMethods()) {
            if (method.getParameterTypes().length == 0 && ((method.getName().startsWith("get") || method.getName().startsWith("is")) && !method.getName().equals("getClass"))) {
                try {
                    result.append(method.getName());
                    result.append('=');
                    result.append(method.invoke(null, (Object[]) null));
                    result.append("\n");
                } catch (IllegalArgumentException e) {
                } catch (InvocationTargetException e2) {
                } catch (IllegalAccessException e3) {
                }
            }
        }
        return result.toString();
    }

    @NonNull
    public static String collectConstants(@NonNull Class<?> someClass) {
        return collectConstants(someClass, "");
    }
}
