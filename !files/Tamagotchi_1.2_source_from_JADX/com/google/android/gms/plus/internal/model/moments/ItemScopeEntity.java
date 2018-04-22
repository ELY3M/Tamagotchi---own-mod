package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;

public final class ItemScopeEntity extends FastSafeParcelableJsonResponse implements ItemScope {
    public static final zza CREATOR = new zza();
    private static final HashMap<String, Field<?, ?>> zzbeM = new HashMap();
    String mName;
    final int mVersionCode;
    String zzF;
    String zzJN;
    double zzaNF;
    double zzaNG;
    String zzaxl;
    final Set<Integer> zzbeN;
    ItemScopeEntity zzbeO;
    List<String> zzbeP;
    ItemScopeEntity zzbeQ;
    String zzbeR;
    String zzbeS;
    String zzbeT;
    List<ItemScopeEntity> zzbeU;
    int zzbeV;
    List<ItemScopeEntity> zzbeW;
    ItemScopeEntity zzbeX;
    List<ItemScopeEntity> zzbeY;
    String zzbeZ;
    String zzbfA;
    String zzbfB;
    String zzbfC;
    ItemScopeEntity zzbfD;
    String zzbfE;
    String zzbfF;
    String zzbfG;
    String zzbfH;
    String zzbfa;
    ItemScopeEntity zzbfb;
    String zzbfc;
    String zzbfd;
    List<ItemScopeEntity> zzbfe;
    String zzbff;
    String zzbfg;
    String zzbfh;
    String zzbfi;
    String zzbfj;
    String zzbfk;
    String zzbfl;
    String zzbfm;
    ItemScopeEntity zzbfn;
    String zzbfo;
    String zzbfp;
    String zzbfq;
    ItemScopeEntity zzbfr;
    ItemScopeEntity zzbfs;
    ItemScopeEntity zzbft;
    List<ItemScopeEntity> zzbfu;
    String zzbfv;
    String zzbfw;
    String zzbfx;
    String zzbfy;
    ItemScopeEntity zzbfz;
    String zztZ;
    String zzyv;

    static {
        zzbeM.put("about", Field.zza("about", 2, ItemScopeEntity.class));
        zzbeM.put("additionalName", Field.zzm("additionalName", 3));
        zzbeM.put("address", Field.zza("address", 4, ItemScopeEntity.class));
        zzbeM.put("addressCountry", Field.zzl("addressCountry", 5));
        zzbeM.put("addressLocality", Field.zzl("addressLocality", 6));
        zzbeM.put("addressRegion", Field.zzl("addressRegion", 7));
        zzbeM.put("associated_media", Field.zzb("associated_media", 8, ItemScopeEntity.class));
        zzbeM.put("attendeeCount", Field.zzi("attendeeCount", 9));
        zzbeM.put("attendees", Field.zzb("attendees", 10, ItemScopeEntity.class));
        zzbeM.put("audio", Field.zza("audio", 11, ItemScopeEntity.class));
        zzbeM.put("author", Field.zzb("author", 12, ItemScopeEntity.class));
        zzbeM.put("bestRating", Field.zzl("bestRating", 13));
        zzbeM.put("birthDate", Field.zzl("birthDate", 14));
        zzbeM.put("byArtist", Field.zza("byArtist", 15, ItemScopeEntity.class));
        zzbeM.put("caption", Field.zzl("caption", 16));
        zzbeM.put("contentSize", Field.zzl("contentSize", 17));
        zzbeM.put("contentUrl", Field.zzl("contentUrl", 18));
        zzbeM.put("contributor", Field.zzb("contributor", 19, ItemScopeEntity.class));
        zzbeM.put("dateCreated", Field.zzl("dateCreated", 20));
        zzbeM.put("dateModified", Field.zzl("dateModified", 21));
        zzbeM.put("datePublished", Field.zzl("datePublished", 22));
        zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        zzbeM.put("duration", Field.zzl("duration", 24));
        zzbeM.put("embedUrl", Field.zzl("embedUrl", 25));
        zzbeM.put("endDate", Field.zzl("endDate", 26));
        zzbeM.put("familyName", Field.zzl("familyName", 27));
        zzbeM.put("gender", Field.zzl("gender", 28));
        zzbeM.put("geo", Field.zza("geo", 29, ItemScopeEntity.class));
        zzbeM.put("givenName", Field.zzl("givenName", 30));
        zzbeM.put("height", Field.zzl("height", 31));
        zzbeM.put("id", Field.zzl("id", 32));
        zzbeM.put(TMXConstants.TAG_IMAGE, Field.zzl(TMXConstants.TAG_IMAGE, 33));
        zzbeM.put("inAlbum", Field.zza("inAlbum", 34, ItemScopeEntity.class));
        zzbeM.put("latitude", Field.zzj("latitude", 36));
        zzbeM.put("location", Field.zza("location", 37, ItemScopeEntity.class));
        zzbeM.put("longitude", Field.zzj("longitude", 38));
        zzbeM.put("name", Field.zzl("name", 39));
        zzbeM.put("partOfTVSeries", Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
        zzbeM.put("performers", Field.zzb("performers", 41, ItemScopeEntity.class));
        zzbeM.put("playerType", Field.zzl("playerType", 42));
        zzbeM.put("postOfficeBoxNumber", Field.zzl("postOfficeBoxNumber", 43));
        zzbeM.put("postalCode", Field.zzl("postalCode", 44));
        zzbeM.put("ratingValue", Field.zzl("ratingValue", 45));
        zzbeM.put("reviewRating", Field.zza("reviewRating", 46, ItemScopeEntity.class));
        zzbeM.put("startDate", Field.zzl("startDate", 47));
        zzbeM.put("streetAddress", Field.zzl("streetAddress", 48));
        zzbeM.put("text", Field.zzl("text", 49));
        zzbeM.put("thumbnail", Field.zza("thumbnail", 50, ItemScopeEntity.class));
        zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        zzbeM.put("tickerSymbol", Field.zzl("tickerSymbol", 52));
        zzbeM.put(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE, Field.zzl(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE, 53));
        zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        zzbeM.put("width", Field.zzl("width", 55));
        zzbeM.put("worstRating", Field.zzl("worstRating", 56));
    }

    public ItemScopeEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    ItemScopeEntity(Set<Integer> indicatorSet, int versionCode, ItemScopeEntity about, List<String> additionalName, ItemScopeEntity address, String addressCountry, String addressLocality, String addressRegion, List<ItemScopeEntity> associated_media, int attendeeCount, List<ItemScopeEntity> attendees, ItemScopeEntity audio, List<ItemScopeEntity> author, String bestRating, String birthDate, ItemScopeEntity byArtist, String caption, String contentSize, String contentUrl, List<ItemScopeEntity> contributor, String dateCreated, String dateModified, String datePublished, String description, String duration, String embedUrl, String endDate, String familyName, String gender, ItemScopeEntity geo, String givenName, String height, String id, String image, ItemScopeEntity inAlbum, double latitude, ItemScopeEntity location, double longitude, String name, ItemScopeEntity partOfTVSeries, List<ItemScopeEntity> performers, String playerType, String postOfficeBoxNumber, String postalCode, String ratingValue, ItemScopeEntity reviewRating, String startDate, String streetAddress, String text, ItemScopeEntity thumbnail, String thumbnailUrl, String tickerSymbol, String type, String url, String width, String worstRating) {
        this.zzbeN = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzbeO = about;
        this.zzbeP = additionalName;
        this.zzbeQ = address;
        this.zzbeR = addressCountry;
        this.zzbeS = addressLocality;
        this.zzbeT = addressRegion;
        this.zzbeU = associated_media;
        this.zzbeV = attendeeCount;
        this.zzbeW = attendees;
        this.zzbeX = audio;
        this.zzbeY = author;
        this.zzbeZ = bestRating;
        this.zzbfa = birthDate;
        this.zzbfb = byArtist;
        this.zzbfc = caption;
        this.zzbfd = contentSize;
        this.zztZ = contentUrl;
        this.zzbfe = contributor;
        this.zzbff = dateCreated;
        this.zzbfg = dateModified;
        this.zzbfh = datePublished;
        this.zzaxl = description;
        this.zzbfi = duration;
        this.zzbfj = embedUrl;
        this.zzbfk = endDate;
        this.zzbfl = familyName;
        this.zzbfm = gender;
        this.zzbfn = geo;
        this.zzbfo = givenName;
        this.zzbfp = height;
        this.zzyv = id;
        this.zzbfq = image;
        this.zzbfr = inAlbum;
        this.zzaNF = latitude;
        this.zzbfs = location;
        this.zzaNG = longitude;
        this.mName = name;
        this.zzbft = partOfTVSeries;
        this.zzbfu = performers;
        this.zzbfv = playerType;
        this.zzbfw = postOfficeBoxNumber;
        this.zzbfx = postalCode;
        this.zzbfy = ratingValue;
        this.zzbfz = reviewRating;
        this.zzbfA = startDate;
        this.zzbfB = streetAddress;
        this.zzbfC = text;
        this.zzbfD = thumbnail;
        this.zzbfE = thumbnailUrl;
        this.zzbfF = tickerSymbol;
        this.zzJN = type;
        this.zzF = url;
        this.zzbfG = width;
        this.zzbfH = worstRating;
    }

    public ItemScopeEntity(Set<Integer> indicatorSet, ItemScopeEntity about, List<String> additionalName, ItemScopeEntity address, String addressCountry, String addressLocality, String addressRegion, List<ItemScopeEntity> associated_media, int attendeeCount, List<ItemScopeEntity> attendees, ItemScopeEntity audio, List<ItemScopeEntity> author, String bestRating, String birthDate, ItemScopeEntity byArtist, String caption, String contentSize, String contentUrl, List<ItemScopeEntity> contributor, String dateCreated, String dateModified, String datePublished, String description, String duration, String embedUrl, String endDate, String familyName, String gender, ItemScopeEntity geo, String givenName, String height, String id, String image, ItemScopeEntity inAlbum, double latitude, ItemScopeEntity location, double longitude, String name, ItemScopeEntity partOfTVSeries, List<ItemScopeEntity> performers, String playerType, String postOfficeBoxNumber, String postalCode, String ratingValue, ItemScopeEntity reviewRating, String startDate, String streetAddress, String text, ItemScopeEntity thumbnail, String thumbnailUrl, String tickerSymbol, String type, String url, String width, String worstRating) {
        this.zzbeN = indicatorSet;
        this.mVersionCode = 1;
        this.zzbeO = about;
        this.zzbeP = additionalName;
        this.zzbeQ = address;
        this.zzbeR = addressCountry;
        this.zzbeS = addressLocality;
        this.zzbeT = addressRegion;
        this.zzbeU = associated_media;
        this.zzbeV = attendeeCount;
        this.zzbeW = attendees;
        this.zzbeX = audio;
        this.zzbeY = author;
        this.zzbeZ = bestRating;
        this.zzbfa = birthDate;
        this.zzbfb = byArtist;
        this.zzbfc = caption;
        this.zzbfd = contentSize;
        this.zztZ = contentUrl;
        this.zzbfe = contributor;
        this.zzbff = dateCreated;
        this.zzbfg = dateModified;
        this.zzbfh = datePublished;
        this.zzaxl = description;
        this.zzbfi = duration;
        this.zzbfj = embedUrl;
        this.zzbfk = endDate;
        this.zzbfl = familyName;
        this.zzbfm = gender;
        this.zzbfn = geo;
        this.zzbfo = givenName;
        this.zzbfp = height;
        this.zzyv = id;
        this.zzbfq = image;
        this.zzbfr = inAlbum;
        this.zzaNF = latitude;
        this.zzbfs = location;
        this.zzaNG = longitude;
        this.mName = name;
        this.zzbft = partOfTVSeries;
        this.zzbfu = performers;
        this.zzbfv = playerType;
        this.zzbfw = postOfficeBoxNumber;
        this.zzbfx = postalCode;
        this.zzbfy = ratingValue;
        this.zzbfz = reviewRating;
        this.zzbfA = startDate;
        this.zzbfB = streetAddress;
        this.zzbfC = text;
        this.zzbfD = thumbnail;
        this.zzbfE = thumbnailUrl;
        this.zzbfF = tickerSymbol;
        this.zzJN = type;
        this.zzF = url;
        this.zzbfG = width;
        this.zzbfH = worstRating;
    }

    public int describeContents() {
        zza com_google_android_gms_plus_internal_model_moments_zza = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ItemScopeEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ItemScopeEntity itemScopeEntity = (ItemScopeEntity) obj;
        for (Field field : zzbeM.values()) {
            if (zza(field)) {
                if (!itemScopeEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(itemScopeEntity.zzb(field))) {
                    return false;
                }
            } else if (itemScopeEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzFm();
    }

    public ItemScope getAbout() {
        return this.zzbeO;
    }

    public List<String> getAdditionalName() {
        return this.zzbeP;
    }

    public ItemScope getAddress() {
        return this.zzbeQ;
    }

    public String getAddressCountry() {
        return this.zzbeR;
    }

    public String getAddressLocality() {
        return this.zzbeS;
    }

    public String getAddressRegion() {
        return this.zzbeT;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.zzbeU;
    }

    public int getAttendeeCount() {
        return this.zzbeV;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.zzbeW;
    }

    public ItemScope getAudio() {
        return this.zzbeX;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.zzbeY;
    }

    public String getBestRating() {
        return this.zzbeZ;
    }

    public String getBirthDate() {
        return this.zzbfa;
    }

    public ItemScope getByArtist() {
        return this.zzbfb;
    }

    public String getCaption() {
        return this.zzbfc;
    }

    public String getContentSize() {
        return this.zzbfd;
    }

    public String getContentUrl() {
        return this.zztZ;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.zzbfe;
    }

    public String getDateCreated() {
        return this.zzbff;
    }

    public String getDateModified() {
        return this.zzbfg;
    }

    public String getDatePublished() {
        return this.zzbfh;
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public String getDuration() {
        return this.zzbfi;
    }

    public String getEmbedUrl() {
        return this.zzbfj;
    }

    public String getEndDate() {
        return this.zzbfk;
    }

    public String getFamilyName() {
        return this.zzbfl;
    }

    public String getGender() {
        return this.zzbfm;
    }

    public ItemScope getGeo() {
        return this.zzbfn;
    }

    public String getGivenName() {
        return this.zzbfo;
    }

    public String getHeight() {
        return this.zzbfp;
    }

    public String getId() {
        return this.zzyv;
    }

    public String getImage() {
        return this.zzbfq;
    }

    public ItemScope getInAlbum() {
        return this.zzbfr;
    }

    public double getLatitude() {
        return this.zzaNF;
    }

    public ItemScope getLocation() {
        return this.zzbfs;
    }

    public double getLongitude() {
        return this.zzaNG;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.zzbft;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.zzbfu;
    }

    public String getPlayerType() {
        return this.zzbfv;
    }

    public String getPostOfficeBoxNumber() {
        return this.zzbfw;
    }

    public String getPostalCode() {
        return this.zzbfx;
    }

    public String getRatingValue() {
        return this.zzbfy;
    }

    public ItemScope getReviewRating() {
        return this.zzbfz;
    }

    public String getStartDate() {
        return this.zzbfA;
    }

    public String getStreetAddress() {
        return this.zzbfB;
    }

    public String getText() {
        return this.zzbfC;
    }

    public ItemScope getThumbnail() {
        return this.zzbfD;
    }

    public String getThumbnailUrl() {
        return this.zzbfE;
    }

    public String getTickerSymbol() {
        return this.zzbfF;
    }

    public String getType() {
        return this.zzJN;
    }

    public String getUrl() {
        return this.zzF;
    }

    public String getWidth() {
        return this.zzbfG;
    }

    public String getWorstRating() {
        return this.zzbfH;
    }

    public boolean hasAbout() {
        return this.zzbeN.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName() {
        return this.zzbeN.contains(Integer.valueOf(3));
    }

    public boolean hasAddress() {
        return this.zzbeN.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry() {
        return this.zzbeN.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality() {
        return this.zzbeN.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion() {
        return this.zzbeN.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media() {
        return this.zzbeN.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount() {
        return this.zzbeN.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees() {
        return this.zzbeN.contains(Integer.valueOf(10));
    }

    public boolean hasAudio() {
        return this.zzbeN.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor() {
        return this.zzbeN.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating() {
        return this.zzbeN.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate() {
        return this.zzbeN.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist() {
        return this.zzbeN.contains(Integer.valueOf(15));
    }

    public boolean hasCaption() {
        return this.zzbeN.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize() {
        return this.zzbeN.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl() {
        return this.zzbeN.contains(Integer.valueOf(18));
    }

    public boolean hasContributor() {
        return this.zzbeN.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated() {
        return this.zzbeN.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified() {
        return this.zzbeN.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished() {
        return this.zzbeN.contains(Integer.valueOf(22));
    }

    public boolean hasDescription() {
        return this.zzbeN.contains(Integer.valueOf(23));
    }

    public boolean hasDuration() {
        return this.zzbeN.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl() {
        return this.zzbeN.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate() {
        return this.zzbeN.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName() {
        return this.zzbeN.contains(Integer.valueOf(27));
    }

    public boolean hasGender() {
        return this.zzbeN.contains(Integer.valueOf(28));
    }

    public boolean hasGeo() {
        return this.zzbeN.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName() {
        return this.zzbeN.contains(Integer.valueOf(30));
    }

    public boolean hasHeight() {
        return this.zzbeN.contains(Integer.valueOf(31));
    }

    public boolean hasId() {
        return this.zzbeN.contains(Integer.valueOf(32));
    }

    public boolean hasImage() {
        return this.zzbeN.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum() {
        return this.zzbeN.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude() {
        return this.zzbeN.contains(Integer.valueOf(36));
    }

    public boolean hasLocation() {
        return this.zzbeN.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude() {
        return this.zzbeN.contains(Integer.valueOf(38));
    }

    public boolean hasName() {
        return this.zzbeN.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries() {
        return this.zzbeN.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers() {
        return this.zzbeN.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType() {
        return this.zzbeN.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.zzbeN.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode() {
        return this.zzbeN.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue() {
        return this.zzbeN.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating() {
        return this.zzbeN.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate() {
        return this.zzbeN.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress() {
        return this.zzbeN.contains(Integer.valueOf(48));
    }

    public boolean hasText() {
        return this.zzbeN.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail() {
        return this.zzbeN.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl() {
        return this.zzbeN.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol() {
        return this.zzbeN.contains(Integer.valueOf(52));
    }

    public boolean hasType() {
        return this.zzbeN.contains(Integer.valueOf(53));
    }

    public boolean hasUrl() {
        return this.zzbeN.contains(Integer.valueOf(54));
    }

    public boolean hasWidth() {
        return this.zzbeN.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating() {
        return this.zzbeN.contains(Integer.valueOf(56));
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
        zza com_google_android_gms_plus_internal_model_moments_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    public HashMap<String, Field<?, ?>> zzFl() {
        return zzbeM;
    }

    public ItemScopeEntity zzFm() {
        return this;
    }

    protected boolean zza(Field field) {
        return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
    }

    protected Object zzb(Field field) {
        switch (field.zzrs()) {
            case 2:
                return this.zzbeO;
            case 3:
                return this.zzbeP;
            case 4:
                return this.zzbeQ;
            case 5:
                return this.zzbeR;
            case 6:
                return this.zzbeS;
            case 7:
                return this.zzbeT;
            case 8:
                return this.zzbeU;
            case 9:
                return Integer.valueOf(this.zzbeV);
            case 10:
                return this.zzbeW;
            case 11:
                return this.zzbeX;
            case 12:
                return this.zzbeY;
            case 13:
                return this.zzbeZ;
            case 14:
                return this.zzbfa;
            case 15:
                return this.zzbfb;
            case 16:
                return this.zzbfc;
            case 17:
                return this.zzbfd;
            case 18:
                return this.zztZ;
            case 19:
                return this.zzbfe;
            case 20:
                return this.zzbff;
            case 21:
                return this.zzbfg;
            case 22:
                return this.zzbfh;
            case 23:
                return this.zzaxl;
            case 24:
                return this.zzbfi;
            case 25:
                return this.zzbfj;
            case 26:
                return this.zzbfk;
            case 27:
                return this.zzbfl;
            case 28:
                return this.zzbfm;
            case 29:
                return this.zzbfn;
            case 30:
                return this.zzbfo;
            case 31:
                return this.zzbfp;
            case 32:
                return this.zzyv;
            case 33:
                return this.zzbfq;
            case 34:
                return this.zzbfr;
            case 36:
                return Double.valueOf(this.zzaNF);
            case 37:
                return this.zzbfs;
            case 38:
                return Double.valueOf(this.zzaNG);
            case 39:
                return this.mName;
            case 40:
                return this.zzbft;
            case 41:
                return this.zzbfu;
            case 42:
                return this.zzbfv;
            case 43:
                return this.zzbfw;
            case 44:
                return this.zzbfx;
            case 45:
                return this.zzbfy;
            case 46:
                return this.zzbfz;
            case 47:
                return this.zzbfA;
            case 48:
                return this.zzbfB;
            case 49:
                return this.zzbfC;
            case 50:
                return this.zzbfD;
            case 51:
                return this.zzbfE;
            case 52:
                return this.zzbfF;
            case 53:
                return this.zzJN;
            case 54:
                return this.zzF;
            case 55:
                return this.zzbfG;
            case 56:
                return this.zzbfH;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
        }
    }

    public /* synthetic */ Map zzrl() {
        return zzFl();
    }
}
