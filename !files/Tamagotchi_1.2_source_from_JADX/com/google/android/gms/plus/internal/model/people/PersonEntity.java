package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;

public final class PersonEntity extends FastSafeParcelableJsonResponse implements Person {
    public static final zza CREATOR = new zza();
    private static final HashMap<String, Field<?, ?>> zzbeM = new HashMap();
    final int mVersionCode;
    String zzF;
    String zzWQ;
    String zzaaL;
    final Set<Integer> zzbeN;
    String zzbfL;
    AgeRangeEntity zzbfM;
    String zzbfN;
    String zzbfO;
    int zzbfP;
    CoverEntity zzbfQ;
    String zzbfR;
    ImageEntity zzbfS;
    boolean zzbfT;
    NameEntity zzbfU;
    String zzbfV;
    int zzbfW;
    List<OrganizationsEntity> zzbfX;
    List<PlacesLivedEntity> zzbfY;
    int zzbfZ;
    int zzbga;
    String zzbgb;
    List<UrlsEntity> zzbgc;
    boolean zzbgd;
    int zztT;
    String zzyv;

    public static class zza {
        public static int zzfH(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    public static final class AgeRangeEntity extends FastSafeParcelableJsonResponse implements AgeRange {
        public static final zzb CREATOR = new zzb();
        private static final HashMap<String, Field<?, ?>> zzbeM = new HashMap();
        final int mVersionCode;
        final Set<Integer> zzbeN;
        int zzbge;
        int zzbgf;

        static {
            zzbeM.put("max", Field.zzi("max", 2));
            zzbeM.put("min", Field.zzi("min", 3));
        }

        public AgeRangeEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        AgeRangeEntity(Set<Integer> indicatorSet, int versionCode, int max, int min) {
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbge = max;
            this.zzbgf = min;
        }

        public int describeContents() {
            zzb com_google_android_gms_plus_internal_model_people_zzb = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AgeRangeEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            AgeRangeEntity ageRangeEntity = (AgeRangeEntity) obj;
            for (Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (!ageRangeEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(ageRangeEntity.zzb(field))) {
                        return false;
                    }
                } else if (ageRangeEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzFq();
        }

        public int getMax() {
            return this.zzbge;
        }

        public int getMin() {
            return this.zzbgf;
        }

        public boolean hasMax() {
            return this.zzbeN.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.zzbeN.contains(Integer.valueOf(3));
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
            zzb com_google_android_gms_plus_internal_model_people_zzb = CREATOR;
            zzb.zza(this, out, flags);
        }

        public HashMap<String, Field<?, ?>> zzFl() {
            return zzbeM;
        }

        public AgeRangeEntity zzFq() {
            return this;
        }

        protected boolean zza(Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrs()) {
                case 2:
                    return Integer.valueOf(this.zzbge);
                case 3:
                    return Integer.valueOf(this.zzbgf);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }

        public /* synthetic */ Map zzrl() {
            return zzFl();
        }
    }

    public static final class CoverEntity extends FastSafeParcelableJsonResponse implements Cover {
        public static final zzc CREATOR = new zzc();
        private static final HashMap<String, Field<?, ?>> zzbeM = new HashMap();
        final int mVersionCode;
        final Set<Integer> zzbeN;
        CoverInfoEntity zzbgg;
        CoverPhotoEntity zzbgh;
        int zzbgi;

        public static final class CoverInfoEntity extends FastSafeParcelableJsonResponse implements CoverInfo {
            public static final zzd CREATOR = new zzd();
            private static final HashMap<String, Field<?, ?>> zzbeM = new HashMap();
            final int mVersionCode;
            final Set<Integer> zzbeN;
            int zzbgj;
            int zzbgk;

            static {
                zzbeM.put("leftImageOffset", Field.zzi("leftImageOffset", 2));
                zzbeM.put("topImageOffset", Field.zzi("topImageOffset", 3));
            }

            public CoverInfoEntity() {
                this.mVersionCode = 1;
                this.zzbeN = new HashSet();
            }

            CoverInfoEntity(Set<Integer> indicatorSet, int versionCode, int leftImageOffset, int topImageOffset) {
                this.zzbeN = indicatorSet;
                this.mVersionCode = versionCode;
                this.zzbgj = leftImageOffset;
                this.zzbgk = topImageOffset;
            }

            public int describeContents() {
                zzd com_google_android_gms_plus_internal_model_people_zzd = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverInfoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) obj;
                for (Field field : zzbeM.values()) {
                    if (zza(field)) {
                        if (!coverInfoEntity.zza(field)) {
                            return false;
                        }
                        if (!zzb(field).equals(coverInfoEntity.zzb(field))) {
                            return false;
                        }
                    } else if (coverInfoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return zzFs();
            }

            public int getLeftImageOffset() {
                return this.zzbgj;
            }

            public int getTopImageOffset() {
                return this.zzbgk;
            }

            public boolean hasLeftImageOffset() {
                return this.zzbeN.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.zzbeN.contains(Integer.valueOf(3));
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
                zzd com_google_android_gms_plus_internal_model_people_zzd = CREATOR;
                zzd.zza(this, out, flags);
            }

            public HashMap<String, Field<?, ?>> zzFl() {
                return zzbeM;
            }

            public CoverInfoEntity zzFs() {
                return this;
            }

            protected boolean zza(Field field) {
                return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
            }

            protected Object zzb(Field field) {
                switch (field.zzrs()) {
                    case 2:
                        return Integer.valueOf(this.zzbgj);
                    case 3:
                        return Integer.valueOf(this.zzbgk);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
                }
            }

            public /* synthetic */ Map zzrl() {
                return zzFl();
            }
        }

        public static final class CoverPhotoEntity extends FastSafeParcelableJsonResponse implements CoverPhoto {
            public static final zze CREATOR = new zze();
            private static final HashMap<String, Field<?, ?>> zzbeM = new HashMap();
            final int mVersionCode;
            String zzF;
            final Set<Integer> zzbeN;
            int zzoG;
            int zzoH;

            static {
                zzbeM.put("height", Field.zzi("height", 2));
                zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                zzbeM.put("width", Field.zzi("width", 4));
            }

            public CoverPhotoEntity() {
                this.mVersionCode = 1;
                this.zzbeN = new HashSet();
            }

            CoverPhotoEntity(Set<Integer> indicatorSet, int versionCode, int height, String url, int width) {
                this.zzbeN = indicatorSet;
                this.mVersionCode = versionCode;
                this.zzoH = height;
                this.zzF = url;
                this.zzoG = width;
            }

            public int describeContents() {
                zze com_google_android_gms_plus_internal_model_people_zze = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverPhotoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverPhotoEntity coverPhotoEntity = (CoverPhotoEntity) obj;
                for (Field field : zzbeM.values()) {
                    if (zza(field)) {
                        if (!coverPhotoEntity.zza(field)) {
                            return false;
                        }
                        if (!zzb(field).equals(coverPhotoEntity.zzb(field))) {
                            return false;
                        }
                    } else if (coverPhotoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return zzFt();
            }

            public int getHeight() {
                return this.zzoH;
            }

            public String getUrl() {
                return this.zzF;
            }

            public int getWidth() {
                return this.zzoG;
            }

            public boolean hasHeight() {
                return this.zzbeN.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.zzbeN.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.zzbeN.contains(Integer.valueOf(4));
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
                zze com_google_android_gms_plus_internal_model_people_zze = CREATOR;
                zze.zza(this, out, flags);
            }

            public HashMap<String, Field<?, ?>> zzFl() {
                return zzbeM;
            }

            public CoverPhotoEntity zzFt() {
                return this;
            }

            protected boolean zza(Field field) {
                return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
            }

            protected Object zzb(Field field) {
                switch (field.zzrs()) {
                    case 2:
                        return Integer.valueOf(this.zzoH);
                    case 3:
                        return this.zzF;
                    case 4:
                        return Integer.valueOf(this.zzoG);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
                }
            }

            public /* synthetic */ Map zzrl() {
                return zzFl();
            }
        }

        static {
            zzbeM.put("coverInfo", Field.zza("coverInfo", 2, CoverInfoEntity.class));
            zzbeM.put("coverPhoto", Field.zza("coverPhoto", 3, CoverPhotoEntity.class));
            zzbeM.put("layout", Field.zza("layout", 4, new StringToIntConverter().zzh("banner", 0), false));
        }

        public CoverEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        CoverEntity(Set<Integer> indicatorSet, int versionCode, CoverInfoEntity coverInfo, CoverPhotoEntity coverPhoto, int layout) {
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbgg = coverInfo;
            this.zzbgh = coverPhoto;
            this.zzbgi = layout;
        }

        public int describeContents() {
            zzc com_google_android_gms_plus_internal_model_people_zzc = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CoverEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CoverEntity coverEntity = (CoverEntity) obj;
            for (Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (!coverEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(coverEntity.zzb(field))) {
                        return false;
                    }
                } else if (coverEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzFr();
        }

        public CoverInfo getCoverInfo() {
            return this.zzbgg;
        }

        public CoverPhoto getCoverPhoto() {
            return this.zzbgh;
        }

        public int getLayout() {
            return this.zzbgi;
        }

        public boolean hasCoverInfo() {
            return this.zzbeN.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.zzbeN.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.zzbeN.contains(Integer.valueOf(4));
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
            zzc com_google_android_gms_plus_internal_model_people_zzc = CREATOR;
            zzc.zza(this, out, flags);
        }

        public HashMap<String, Field<?, ?>> zzFl() {
            return zzbeM;
        }

        public CoverEntity zzFr() {
            return this;
        }

        protected boolean zza(Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrs()) {
                case 2:
                    return this.zzbgg;
                case 3:
                    return this.zzbgh;
                case 4:
                    return Integer.valueOf(this.zzbgi);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }

        public /* synthetic */ Map zzrl() {
            return zzFl();
        }
    }

    public static final class ImageEntity extends FastSafeParcelableJsonResponse implements Image {
        public static final zzf CREATOR = new zzf();
        private static final HashMap<String, Field<?, ?>> zzbeM = new HashMap();
        final int mVersionCode;
        String zzF;
        final Set<Integer> zzbeN;

        static {
            zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public ImageEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        public ImageEntity(String url) {
            this.zzbeN = new HashSet();
            this.mVersionCode = 1;
            this.zzF = url;
            this.zzbeN.add(Integer.valueOf(2));
        }

        ImageEntity(Set<Integer> indicatorSet, int versionCode, String url) {
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzF = url;
        }

        public int describeContents() {
            zzf com_google_android_gms_plus_internal_model_people_zzf = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ImageEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageEntity imageEntity = (ImageEntity) obj;
            for (Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (!imageEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(imageEntity.zzb(field))) {
                        return false;
                    }
                } else if (imageEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzFu();
        }

        public String getUrl() {
            return this.zzF;
        }

        public boolean hasUrl() {
            return this.zzbeN.contains(Integer.valueOf(2));
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
            zzf com_google_android_gms_plus_internal_model_people_zzf = CREATOR;
            zzf.zza(this, out, flags);
        }

        public HashMap<String, Field<?, ?>> zzFl() {
            return zzbeM;
        }

        public ImageEntity zzFu() {
            return this;
        }

        protected boolean zza(Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrs()) {
                case 2:
                    return this.zzF;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }

        public /* synthetic */ Map zzrl() {
            return zzFl();
        }
    }

    public static final class NameEntity extends FastSafeParcelableJsonResponse implements Name {
        public static final zzg CREATOR = new zzg();
        private static final HashMap<String, Field<?, ?>> zzbeM = new HashMap();
        final int mVersionCode;
        final Set<Integer> zzbeN;
        String zzbfl;
        String zzbfo;
        String zzbgl;
        String zzbgm;
        String zzbgn;
        String zzbgo;

        static {
            zzbeM.put("familyName", Field.zzl("familyName", 2));
            zzbeM.put("formatted", Field.zzl("formatted", 3));
            zzbeM.put("givenName", Field.zzl("givenName", 4));
            zzbeM.put("honorificPrefix", Field.zzl("honorificPrefix", 5));
            zzbeM.put("honorificSuffix", Field.zzl("honorificSuffix", 6));
            zzbeM.put("middleName", Field.zzl("middleName", 7));
        }

        public NameEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        NameEntity(Set<Integer> indicatorSet, int versionCode, String familyName, String formatted, String givenName, String honorificPrefix, String honorificSuffix, String middleName) {
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbfl = familyName;
            this.zzbgl = formatted;
            this.zzbfo = givenName;
            this.zzbgm = honorificPrefix;
            this.zzbgn = honorificSuffix;
            this.zzbgo = middleName;
        }

        public int describeContents() {
            zzg com_google_android_gms_plus_internal_model_people_zzg = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NameEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            NameEntity nameEntity = (NameEntity) obj;
            for (Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (!nameEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(nameEntity.zzb(field))) {
                        return false;
                    }
                } else if (nameEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzFv();
        }

        public String getFamilyName() {
            return this.zzbfl;
        }

        public String getFormatted() {
            return this.zzbgl;
        }

        public String getGivenName() {
            return this.zzbfo;
        }

        public String getHonorificPrefix() {
            return this.zzbgm;
        }

        public String getHonorificSuffix() {
            return this.zzbgn;
        }

        public String getMiddleName() {
            return this.zzbgo;
        }

        public boolean hasFamilyName() {
            return this.zzbeN.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.zzbeN.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.zzbeN.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.zzbeN.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.zzbeN.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
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
            zzg com_google_android_gms_plus_internal_model_people_zzg = CREATOR;
            zzg.zza(this, out, flags);
        }

        public HashMap<String, Field<?, ?>> zzFl() {
            return zzbeM;
        }

        public NameEntity zzFv() {
            return this;
        }

        protected boolean zza(Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrs()) {
                case 2:
                    return this.zzbfl;
                case 3:
                    return this.zzbgl;
                case 4:
                    return this.zzbfo;
                case 5:
                    return this.zzbgm;
                case 6:
                    return this.zzbgn;
                case 7:
                    return this.zzbgo;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }

        public /* synthetic */ Map zzrl() {
            return zzFl();
        }
    }

    public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse implements Organizations {
        public static final zzh CREATOR = new zzh();
        private static final HashMap<String, Field<?, ?>> zzbeM = new HashMap();
        String mName;
        final int mVersionCode;
        int zzabB;
        String zzapg;
        String zzaxl;
        final Set<Integer> zzbeN;
        String zzbfA;
        String zzbfk;
        String zzbgp;
        String zzbgq;
        boolean zzbgr;

        static {
            zzbeM.put("department", Field.zzl("department", 2));
            zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            zzbeM.put("endDate", Field.zzl("endDate", 4));
            zzbeM.put("location", Field.zzl("location", 5));
            zzbeM.put("name", Field.zzl("name", 6));
            zzbeM.put("primary", Field.zzk("primary", 7));
            zzbeM.put("startDate", Field.zzl("startDate", 8));
            zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            zzbeM.put(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE, Field.zza(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE, 10, new StringToIntConverter().zzh("work", 0).zzh("school", 1), false));
        }

        public OrganizationsEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        OrganizationsEntity(Set<Integer> indicatorSet, int versionCode, String department, String description, String endDate, String location, String name, boolean primary, String startDate, String title, int type) {
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbgp = department;
            this.zzaxl = description;
            this.zzbfk = endDate;
            this.zzbgq = location;
            this.mName = name;
            this.zzbgr = primary;
            this.zzbfA = startDate;
            this.zzapg = title;
            this.zzabB = type;
        }

        public int describeContents() {
            zzh com_google_android_gms_plus_internal_model_people_zzh = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OrganizationsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            OrganizationsEntity organizationsEntity = (OrganizationsEntity) obj;
            for (Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (!organizationsEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(organizationsEntity.zzb(field))) {
                        return false;
                    }
                } else if (organizationsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzFw();
        }

        public String getDepartment() {
            return this.zzbgp;
        }

        public String getDescription() {
            return this.zzaxl;
        }

        public String getEndDate() {
            return this.zzbfk;
        }

        public String getLocation() {
            return this.zzbgq;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.zzbfA;
        }

        public String getTitle() {
            return this.zzapg;
        }

        public int getType() {
            return this.zzabB;
        }

        public boolean hasDepartment() {
            return this.zzbeN.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.zzbeN.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.zzbeN.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.zzbeN.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.zzbeN.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.zzbeN.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.zzbeN.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.zzbeN.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.zzbeN.contains(Integer.valueOf(10));
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

        public boolean isPrimary() {
            return this.zzbgr;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzh com_google_android_gms_plus_internal_model_people_zzh = CREATOR;
            zzh.zza(this, out, flags);
        }

        public HashMap<String, Field<?, ?>> zzFl() {
            return zzbeM;
        }

        public OrganizationsEntity zzFw() {
            return this;
        }

        protected boolean zza(Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrs()) {
                case 2:
                    return this.zzbgp;
                case 3:
                    return this.zzaxl;
                case 4:
                    return this.zzbfk;
                case 5:
                    return this.zzbgq;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.zzbgr);
                case 8:
                    return this.zzbfA;
                case 9:
                    return this.zzapg;
                case 10:
                    return Integer.valueOf(this.zzabB);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }

        public /* synthetic */ Map zzrl() {
            return zzFl();
        }
    }

    public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse implements PlacesLived {
        public static final zzi CREATOR = new zzi();
        private static final HashMap<String, Field<?, ?>> zzbeM = new HashMap();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzbeN;
        boolean zzbgr;

        static {
            zzbeM.put("primary", Field.zzk("primary", 2));
            zzbeM.put(TMXConstants.TAG_PROPERTY_ATTRIBUTE_VALUE, Field.zzl(TMXConstants.TAG_PROPERTY_ATTRIBUTE_VALUE, 3));
        }

        public PlacesLivedEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        PlacesLivedEntity(Set<Integer> indicatorSet, int versionCode, boolean primary, String value) {
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbgr = primary;
            this.mValue = value;
        }

        public int describeContents() {
            zzi com_google_android_gms_plus_internal_model_people_zzi = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlacesLivedEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PlacesLivedEntity placesLivedEntity = (PlacesLivedEntity) obj;
            for (Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (!placesLivedEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(placesLivedEntity.zzb(field))) {
                        return false;
                    }
                } else if (placesLivedEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzFx();
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasPrimary() {
            return this.zzbeN.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.zzbeN.contains(Integer.valueOf(3));
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

        public boolean isPrimary() {
            return this.zzbgr;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzi com_google_android_gms_plus_internal_model_people_zzi = CREATOR;
            zzi.zza(this, out, flags);
        }

        public HashMap<String, Field<?, ?>> zzFl() {
            return zzbeM;
        }

        public PlacesLivedEntity zzFx() {
            return this;
        }

        protected boolean zza(Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrs()) {
                case 2:
                    return Boolean.valueOf(this.zzbgr);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }

        public /* synthetic */ Map zzrl() {
            return zzFl();
        }
    }

    public static final class UrlsEntity extends FastSafeParcelableJsonResponse implements Urls {
        public static final zzj CREATOR = new zzj();
        private static final HashMap<String, Field<?, ?>> zzbeM = new HashMap();
        String mValue;
        final int mVersionCode;
        String zzaUO;
        int zzabB;
        final Set<Integer> zzbeN;
        private final int zzbgs;

        static {
            zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, Field.zzl(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            zzbeM.put(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE, Field.zza(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE, 6, new StringToIntConverter().zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh(Scopes.PROFILE, 3).zzh(FitnessActivities.OTHER, 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
            zzbeM.put(TMXConstants.TAG_PROPERTY_ATTRIBUTE_VALUE, Field.zzl(TMXConstants.TAG_PROPERTY_ATTRIBUTE_VALUE, 4));
        }

        public UrlsEntity() {
            this.zzbgs = 4;
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        UrlsEntity(Set<Integer> indicatorSet, int versionCode, String label, int type, String value, int type_DEPRECATED_FENACHO) {
            this.zzbgs = 4;
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzaUO = label;
            this.zzabB = type;
            this.mValue = value;
        }

        public int describeContents() {
            zzj com_google_android_gms_plus_internal_model_people_zzj = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UrlsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            UrlsEntity urlsEntity = (UrlsEntity) obj;
            for (Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (!urlsEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(urlsEntity.zzb(field))) {
                        return false;
                    }
                } else if (urlsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzFz();
        }

        public String getLabel() {
            return this.zzaUO;
        }

        public int getType() {
            return this.zzabB;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasLabel() {
            return this.zzbeN.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.zzbeN.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.zzbeN.contains(Integer.valueOf(4));
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
            zzj com_google_android_gms_plus_internal_model_people_zzj = CREATOR;
            zzj.zza(this, out, flags);
        }

        public HashMap<String, Field<?, ?>> zzFl() {
            return zzbeM;
        }

        @Deprecated
        public int zzFy() {
            return 4;
        }

        public UrlsEntity zzFz() {
            return this;
        }

        protected boolean zza(Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrs()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.zzaUO;
                case 6:
                    return Integer.valueOf(this.zzabB);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }

        public /* synthetic */ Map zzrl() {
            return zzFl();
        }
    }

    static {
        zzbeM.put("aboutMe", Field.zzl("aboutMe", 2));
        zzbeM.put("ageRange", Field.zza("ageRange", 3, AgeRangeEntity.class));
        zzbeM.put("birthday", Field.zzl("birthday", 4));
        zzbeM.put("braggingRights", Field.zzl("braggingRights", 5));
        zzbeM.put("circledByCount", Field.zzi("circledByCount", 6));
        zzbeM.put("cover", Field.zza("cover", 7, CoverEntity.class));
        zzbeM.put("currentLocation", Field.zzl("currentLocation", 8));
        zzbeM.put("displayName", Field.zzl("displayName", 9));
        zzbeM.put("gender", Field.zza("gender", 12, new StringToIntConverter().zzh("male", 0).zzh("female", 1).zzh(FitnessActivities.OTHER, 2), false));
        zzbeM.put("id", Field.zzl("id", 14));
        zzbeM.put(TMXConstants.TAG_IMAGE, Field.zza(TMXConstants.TAG_IMAGE, 15, ImageEntity.class));
        zzbeM.put("isPlusUser", Field.zzk("isPlusUser", 16));
        zzbeM.put("language", Field.zzl("language", 18));
        zzbeM.put("name", Field.zza("name", 19, NameEntity.class));
        zzbeM.put("nickname", Field.zzl("nickname", 20));
        zzbeM.put("objectType", Field.zza("objectType", 21, new StringToIntConverter().zzh("person", 0).zzh("page", 1), false));
        zzbeM.put("organizations", Field.zzb("organizations", 22, OrganizationsEntity.class));
        zzbeM.put("placesLived", Field.zzb("placesLived", 23, PlacesLivedEntity.class));
        zzbeM.put("plusOneCount", Field.zzi("plusOneCount", 24));
        zzbeM.put("relationshipStatus", Field.zza("relationshipStatus", 25, new StringToIntConverter().zzh("single", 0).zzh("in_a_relationship", 1).zzh("engaged", 2).zzh("married", 3).zzh("its_complicated", 4).zzh("open_relationship", 5).zzh("widowed", 6).zzh("in_domestic_partnership", 7).zzh("in_civil_union", 8), false));
        zzbeM.put("tagline", Field.zzl("tagline", 26));
        zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        zzbeM.put("urls", Field.zzb("urls", 28, UrlsEntity.class));
        zzbeM.put("verified", Field.zzk("verified", 29));
    }

    public PersonEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    public PersonEntity(String displayName, String id, ImageEntity image, int objectType, String url) {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
        this.zzWQ = displayName;
        this.zzbeN.add(Integer.valueOf(9));
        this.zzyv = id;
        this.zzbeN.add(Integer.valueOf(14));
        this.zzbfS = image;
        this.zzbeN.add(Integer.valueOf(15));
        this.zzbfW = objectType;
        this.zzbeN.add(Integer.valueOf(21));
        this.zzF = url;
        this.zzbeN.add(Integer.valueOf(27));
    }

    PersonEntity(Set<Integer> indicatorSet, int versionCode, String aboutMe, AgeRangeEntity ageRange, String birthday, String braggingRights, int circledByCount, CoverEntity cover, String currentLocation, String displayName, int gender, String id, ImageEntity image, boolean isPlusUser, String language, NameEntity name, String nickname, int objectType, List<OrganizationsEntity> organizations, List<PlacesLivedEntity> placesLived, int plusOneCount, int relationshipStatus, String tagline, String url, List<UrlsEntity> urls, boolean verified) {
        this.zzbeN = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzbfL = aboutMe;
        this.zzbfM = ageRange;
        this.zzbfN = birthday;
        this.zzbfO = braggingRights;
        this.zzbfP = circledByCount;
        this.zzbfQ = cover;
        this.zzbfR = currentLocation;
        this.zzWQ = displayName;
        this.zztT = gender;
        this.zzyv = id;
        this.zzbfS = image;
        this.zzbfT = isPlusUser;
        this.zzaaL = language;
        this.zzbfU = name;
        this.zzbfV = nickname;
        this.zzbfW = objectType;
        this.zzbfX = organizations;
        this.zzbfY = placesLived;
        this.zzbfZ = plusOneCount;
        this.zzbga = relationshipStatus;
        this.zzbgb = tagline;
        this.zzF = url;
        this.zzbgc = urls;
        this.zzbgd = verified;
    }

    public static PersonEntity zzv(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        PersonEntity zzgE = CREATOR.zzgE(obtain);
        obtain.recycle();
        return zzgE;
    }

    public int describeContents() {
        zza com_google_android_gms_plus_internal_model_people_zza = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PersonEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PersonEntity personEntity = (PersonEntity) obj;
        for (Field field : zzbeM.values()) {
            if (zza(field)) {
                if (!personEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(personEntity.zzb(field))) {
                    return false;
                }
            } else if (personEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzFp();
    }

    public String getAboutMe() {
        return this.zzbfL;
    }

    public AgeRange getAgeRange() {
        return this.zzbfM;
    }

    public String getBirthday() {
        return this.zzbfN;
    }

    public String getBraggingRights() {
        return this.zzbfO;
    }

    public int getCircledByCount() {
        return this.zzbfP;
    }

    public Cover getCover() {
        return this.zzbfQ;
    }

    public String getCurrentLocation() {
        return this.zzbfR;
    }

    public String getDisplayName() {
        return this.zzWQ;
    }

    public int getGender() {
        return this.zztT;
    }

    public String getId() {
        return this.zzyv;
    }

    public Image getImage() {
        return this.zzbfS;
    }

    public String getLanguage() {
        return this.zzaaL;
    }

    public Name getName() {
        return this.zzbfU;
    }

    public String getNickname() {
        return this.zzbfV;
    }

    public int getObjectType() {
        return this.zzbfW;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.zzbfX;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.zzbfY;
    }

    public int getPlusOneCount() {
        return this.zzbfZ;
    }

    public int getRelationshipStatus() {
        return this.zzbga;
    }

    public String getTagline() {
        return this.zzbgb;
    }

    public String getUrl() {
        return this.zzF;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.zzbgc;
    }

    public boolean hasAboutMe() {
        return this.zzbeN.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.zzbeN.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.zzbeN.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.zzbeN.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.zzbeN.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.zzbeN.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.zzbeN.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.zzbeN.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.zzbeN.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.zzbeN.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.zzbeN.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.zzbeN.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.zzbeN.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.zzbeN.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.zzbeN.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.zzbeN.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.zzbeN.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.zzbeN.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.zzbeN.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.zzbeN.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.zzbeN.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.zzbeN.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.zzbeN.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.zzbeN.contains(Integer.valueOf(29));
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

    public boolean isPlusUser() {
        return this.zzbfT;
    }

    public boolean isVerified() {
        return this.zzbgd;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_plus_internal_model_people_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    public HashMap<String, Field<?, ?>> zzFl() {
        return zzbeM;
    }

    public PersonEntity zzFp() {
        return this;
    }

    protected boolean zza(Field field) {
        return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
    }

    protected Object zzb(Field field) {
        switch (field.zzrs()) {
            case 2:
                return this.zzbfL;
            case 3:
                return this.zzbfM;
            case 4:
                return this.zzbfN;
            case 5:
                return this.zzbfO;
            case 6:
                return Integer.valueOf(this.zzbfP);
            case 7:
                return this.zzbfQ;
            case 8:
                return this.zzbfR;
            case 9:
                return this.zzWQ;
            case 12:
                return Integer.valueOf(this.zztT);
            case 14:
                return this.zzyv;
            case 15:
                return this.zzbfS;
            case 16:
                return Boolean.valueOf(this.zzbfT);
            case 18:
                return this.zzaaL;
            case 19:
                return this.zzbfU;
            case 20:
                return this.zzbfV;
            case 21:
                return Integer.valueOf(this.zzbfW);
            case 22:
                return this.zzbfX;
            case 23:
                return this.zzbfY;
            case 24:
                return Integer.valueOf(this.zzbfZ);
            case 25:
                return Integer.valueOf(this.zzbga);
            case 26:
                return this.zzbgb;
            case 27:
                return this.zzF;
            case 28:
                return this.zzbgc;
            case 29:
                return Boolean.valueOf(this.zzbgd);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
        }
    }

    public /* synthetic */ Map zzrl() {
        return zzFl();
    }
}
