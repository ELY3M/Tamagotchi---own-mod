package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
    public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzJN;
    private final ArrayList<AppContentConditionEntity> zzaDv;
    private final String zzaDw;
    private final AppContentAnnotationEntity zzaDx;
    private final String zzaDy;
    private final String zzyv;

    AppContentActionEntity(int versionCode, ArrayList<AppContentConditionEntity> conditions, String contentDescription, Bundle extras, String type, String id, AppContentAnnotationEntity annotation, String overflowText) {
        this.mVersionCode = versionCode;
        this.zzaDx = annotation;
        this.zzaDv = conditions;
        this.zzaDw = contentDescription;
        this.mExtras = extras;
        this.zzyv = id;
        this.zzaDy = overflowText;
        this.zzJN = type;
    }

    public AppContentActionEntity(AppContentAction action) {
        this.mVersionCode = 5;
        this.zzaDx = (AppContentAnnotationEntity) action.zzvO().freeze();
        this.zzaDw = action.zzvQ();
        this.mExtras = action.getExtras();
        this.zzyv = action.getId();
        this.zzaDy = action.zzvR();
        this.zzJN = action.getType();
        List zzvP = action.zzvP();
        int size = zzvP.size();
        this.zzaDv = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaDv.add((AppContentConditionEntity) ((AppContentCondition) zzvP.get(i)).freeze());
        }
    }

    static int zza(AppContentAction appContentAction) {
        return zzw.hashCode(appContentAction.zzvO(), appContentAction.zzvP(), appContentAction.zzvQ(), appContentAction.getExtras(), appContentAction.getId(), appContentAction.zzvR(), appContentAction.getType());
    }

    static boolean zza(AppContentAction appContentAction, Object obj) {
        if (!(obj instanceof AppContentAction)) {
            return false;
        }
        if (appContentAction == obj) {
            return true;
        }
        AppContentAction appContentAction2 = (AppContentAction) obj;
        return zzw.equal(appContentAction2.zzvO(), appContentAction.zzvO()) && zzw.equal(appContentAction2.zzvP(), appContentAction.zzvP()) && zzw.equal(appContentAction2.zzvQ(), appContentAction.zzvQ()) && zzw.equal(appContentAction2.getExtras(), appContentAction.getExtras()) && zzw.equal(appContentAction2.getId(), appContentAction.getId()) && zzw.equal(appContentAction2.zzvR(), appContentAction.zzvR()) && zzw.equal(appContentAction2.getType(), appContentAction.getType());
    }

    static String zzb(AppContentAction appContentAction) {
        return zzw.zzy(appContentAction).zzg("Annotation", appContentAction.zzvO()).zzg("Conditions", appContentAction.zzvP()).zzg("ContentDescription", appContentAction.zzvQ()).zzg("Extras", appContentAction.getExtras()).zzg("Id", appContentAction.getId()).zzg("OverflowText", appContentAction.zzvR()).zzg("Type", appContentAction.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvS();
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzyv;
    }

    public String getType() {
        return this.zzJN;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentActionEntityCreator.zza(this, out, flags);
    }

    public AppContentAnnotation zzvO() {
        return this.zzaDx;
    }

    public List<AppContentCondition> zzvP() {
        return new ArrayList(this.zzaDv);
    }

    public String zzvQ() {
        return this.zzaDw;
    }

    public String zzvR() {
        return this.zzaDy;
    }

    public AppContentAction zzvS() {
        return this;
    }
}
