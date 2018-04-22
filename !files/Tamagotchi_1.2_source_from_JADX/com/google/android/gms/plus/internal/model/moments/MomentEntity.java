package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;

public final class MomentEntity extends FastSafeParcelableJsonResponse implements Moment {
    public static final zzb CREATOR = new zzb();
    private static final HashMap<String, Field<?, ?>> zzbeM = new HashMap();
    final int mVersionCode;
    String zzJN;
    final Set<Integer> zzbeN;
    String zzbfA;
    ItemScopeEntity zzbfI;
    ItemScopeEntity zzbfJ;
    String zzyv;

    static {
        zzbeM.put("id", Field.zzl("id", 2));
        zzbeM.put("result", Field.zza("result", 4, ItemScopeEntity.class));
        zzbeM.put("startDate", Field.zzl("startDate", 5));
        zzbeM.put("target", Field.zza("target", 6, ItemScopeEntity.class));
        zzbeM.put(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE, Field.zzl(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE, 7));
    }

    public MomentEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    MomentEntity(Set<Integer> indicatorSet, int versionCode, String id, ItemScopeEntity result, String startDate, ItemScopeEntity target, String type) {
        this.zzbeN = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzyv = id;
        this.zzbfI = result;
        this.zzbfA = startDate;
        this.zzbfJ = target;
        this.zzJN = type;
    }

    public MomentEntity(Set<Integer> indicatorSet, String id, ItemScopeEntity result, String startDate, ItemScopeEntity target, String type) {
        this.zzbeN = indicatorSet;
        this.mVersionCode = 1;
        this.zzyv = id;
        this.zzbfI = result;
        this.zzbfA = startDate;
        this.zzbfJ = target;
        this.zzJN = type;
    }

    public int describeContents() {
        zzb com_google_android_gms_plus_internal_model_moments_zzb = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MomentEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MomentEntity momentEntity = (MomentEntity) obj;
        for (Field field : zzbeM.values()) {
            if (zza(field)) {
                if (!momentEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(momentEntity.zzb(field))) {
                    return false;
                }
            } else if (momentEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzFn();
    }

    public String getId() {
        return this.zzyv;
    }

    public ItemScope getResult() {
        return this.zzbfI;
    }

    public String getStartDate() {
        return this.zzbfA;
    }

    public ItemScope getTarget() {
        return this.zzbfJ;
    }

    public String getType() {
        return this.zzJN;
    }

    public boolean hasId() {
        return this.zzbeN.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.zzbeN.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.zzbeN.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.zzbeN.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.zzbeN.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        for (Field field : zzbeM.values()) {
            int hashCode;
            if (zza(field)) {
                hashCode = zzb(field).hashCode() + (i + field.zzrs());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb com_google_android_gms_plus_internal_model_moments_zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    public HashMap<String, Field<?, ?>> zzFl() {
        return zzbeM;
    }

    public MomentEntity zzFn() {
        return this;
    }

    protected boolean zza(Field field) {
        return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
    }

    protected Object zzb(Field field) {
        switch (field.zzrs()) {
            case 2:
                return this.zzyv;
            case 4:
                return this.zzbfI;
            case 5:
                return this.zzbfA;
            case 6:
                return this.zzbfJ;
            case 7:
                return this.zzJN;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
        }
    }

    public /* synthetic */ Map zzrl() {
        return zzFl();
    }
}
