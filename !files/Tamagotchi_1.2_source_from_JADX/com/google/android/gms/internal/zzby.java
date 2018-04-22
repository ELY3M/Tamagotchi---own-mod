package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;

@zzhb
public abstract class zzby {
    @zzhb
    public static final zzby zzxs = new C07511();
    @zzhb
    public static final zzby zzxt = new C07522();
    @zzhb
    public static final zzby zzxu = new C07533();

    static class C07511 extends zzby {
        C07511() {
        }

        public String zzb(@Nullable String str, String str2) {
            return str2;
        }
    }

    static class C07522 extends zzby {
        C07522() {
        }

        public String zzb(@Nullable String str, String str2) {
            return str != null ? str : str2;
        }
    }

    static class C07533 extends zzby {
        C07533() {
        }

        @Nullable
        private String zzM(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String zzb(@Nullable String str, String str2) {
            String zzM = zzM(str);
            String zzM2 = zzM(str2);
            return TextUtils.isEmpty(zzM) ? zzM2 : TextUtils.isEmpty(zzM2) ? zzM : zzM + "," + zzM2;
        }
    }

    public final void zza(Map<String, String> map, String str, String str2) {
        map.put(str, zzb((String) map.get(str), str2));
    }

    public abstract String zzb(@Nullable String str, String str2);
}
