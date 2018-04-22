package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
    public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzJN;
    private final ArrayList<AppContentAnnotationEntity> zzaDF;
    private final String zzaDH;
    private final ArrayList<AppContentCardEntity> zzaDO;
    private final String zzaDP;
    private final String zzaDw;
    private final String zzapg;
    private final String zzyv;

    AppContentSectionEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentCardEntity> cards, String contentDescription, Bundle extras, String subtitle, String title, String type, String id, String cardType, ArrayList<AppContentAnnotationEntity> annotations) {
        this.mVersionCode = versionCode;
        this.mActions = actions;
        this.zzaDF = annotations;
        this.zzaDO = cards;
        this.zzaDP = cardType;
        this.zzaDw = contentDescription;
        this.mExtras = extras;
        this.zzyv = id;
        this.zzaDH = subtitle;
        this.zzapg = title;
        this.zzJN = type;
    }

    public AppContentSectionEntity(AppContentSection section) {
        int i;
        int i2 = 0;
        this.mVersionCode = 5;
        this.zzaDP = section.zzwl();
        this.zzaDw = section.zzvQ();
        this.mExtras = section.getExtras();
        this.zzyv = section.getId();
        this.zzaDH = section.zzwc();
        this.zzapg = section.getTitle();
        this.zzJN = section.getType();
        List actions = section.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = section.zzwk();
        size = actions.size();
        this.zzaDO = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzaDO.add((AppContentCardEntity) ((AppContentCard) actions.get(i)).freeze());
        }
        List zzwa = section.zzwa();
        int size2 = zzwa.size();
        this.zzaDF = new ArrayList(size2);
        while (i2 < size2) {
            this.zzaDF.add((AppContentAnnotationEntity) ((AppContentAnnotation) zzwa.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentSection appContentSection) {
        return zzw.hashCode(appContentSection.getActions(), appContentSection.zzwa(), appContentSection.zzwk(), appContentSection.zzwl(), appContentSection.zzvQ(), appContentSection.getExtras(), appContentSection.getId(), appContentSection.zzwc(), appContentSection.getTitle(), appContentSection.getType());
    }

    static boolean zza(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return zzw.equal(appContentSection2.getActions(), appContentSection.getActions()) && zzw.equal(appContentSection2.zzwa(), appContentSection.zzwa()) && zzw.equal(appContentSection2.zzwk(), appContentSection.zzwk()) && zzw.equal(appContentSection2.zzwl(), appContentSection.zzwl()) && zzw.equal(appContentSection2.zzvQ(), appContentSection.zzvQ()) && zzw.equal(appContentSection2.getExtras(), appContentSection.getExtras()) && zzw.equal(appContentSection2.getId(), appContentSection.getId()) && zzw.equal(appContentSection2.zzwc(), appContentSection.zzwc()) && zzw.equal(appContentSection2.getTitle(), appContentSection.getTitle()) && zzw.equal(appContentSection2.getType(), appContentSection.getType());
    }

    static String zzb(AppContentSection appContentSection) {
        return zzw.zzy(appContentSection).zzg("Actions", appContentSection.getActions()).zzg("Annotations", appContentSection.zzwa()).zzg("Cards", appContentSection.zzwk()).zzg("CardType", appContentSection.zzwl()).zzg("ContentDescription", appContentSection.zzvQ()).zzg("Extras", appContentSection.getExtras()).zzg("Id", appContentSection.getId()).zzg("Subtitle", appContentSection.zzwc()).zzg("Title", appContentSection.getTitle()).zzg("Type", appContentSection.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzwm();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzyv;
    }

    public String getTitle() {
        return this.zzapg;
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
        AppContentSectionEntityCreator.zza(this, out, flags);
    }

    public String zzvQ() {
        return this.zzaDw;
    }

    public List<AppContentAnnotation> zzwa() {
        return new ArrayList(this.zzaDF);
    }

    public String zzwc() {
        return this.zzaDH;
    }

    public List<AppContentCard> zzwk() {
        return new ArrayList(this.zzaDO);
    }

    public String zzwl() {
        return this.zzaDP;
    }

    public AppContentSection zzwm() {
        return this;
    }
}
