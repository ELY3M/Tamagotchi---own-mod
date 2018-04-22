package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.measurement.zze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzpt extends zze<zzpt> {
    private ProductAction zzPn;
    private final Map<String, List<Product>> zzPo = new HashMap();
    private final List<Promotion> zzPp = new ArrayList();
    private final List<Product> zzPq = new ArrayList();

    public String toString() {
        Map hashMap = new HashMap();
        if (!this.zzPq.isEmpty()) {
            hashMap.put("products", this.zzPq);
        }
        if (!this.zzPp.isEmpty()) {
            hashMap.put("promotions", this.zzPp);
        }
        if (!this.zzPo.isEmpty()) {
            hashMap.put("impressions", this.zzPo);
        }
        hashMap.put("productAction", this.zzPn);
        return zze.zzF(hashMap);
    }

    public ProductAction zzAV() {
        return this.zzPn;
    }

    public List<Product> zzAW() {
        return Collections.unmodifiableList(this.zzPq);
    }

    public Map<String, List<Product>> zzAX() {
        return this.zzPo;
    }

    public List<Promotion> zzAY() {
        return Collections.unmodifiableList(this.zzPp);
    }

    public void zza(Product product, String str) {
        if (product != null) {
            Object obj;
            if (str == null) {
                obj = "";
            }
            if (!this.zzPo.containsKey(obj)) {
                this.zzPo.put(obj, new ArrayList());
            }
            ((List) this.zzPo.get(obj)).add(product);
        }
    }

    public void zza(zzpt com_google_android_gms_internal_zzpt) {
        com_google_android_gms_internal_zzpt.zzPq.addAll(this.zzPq);
        com_google_android_gms_internal_zzpt.zzPp.addAll(this.zzPp);
        for (Entry entry : this.zzPo.entrySet()) {
            String str = (String) entry.getKey();
            for (Product zza : (List) entry.getValue()) {
                com_google_android_gms_internal_zzpt.zza(zza, str);
            }
        }
        if (this.zzPn != null) {
            com_google_android_gms_internal_zzpt.zzPn = this.zzPn;
        }
    }
}
