package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzd;

public class AncsNotificationParcelable implements SafeParcelable, zzd {
    public static final Creator<AncsNotificationParcelable> CREATOR = new zzh();
    private int mId;
    final int mVersionCode;
    private String zzTJ;
    private String zzWQ;
    private final String zzaDH;
    private final String zzaUa;
    private final String zzaaH;
    private final String zzapg;
    private final String zzbrH;
    private byte zzbrI;
    private byte zzbrJ;
    private byte zzbrK;
    private byte zzbrL;

    AncsNotificationParcelable(int versionCode, int id, String appId, String dateTime, String notificationText, String title, String subtitle, String displayName, byte eventId, byte eventFlags, byte categoryId, byte categoryCount, String packageName) {
        this.mId = id;
        this.mVersionCode = versionCode;
        this.zzaUa = appId;
        this.zzbrH = dateTime;
        this.zzaaH = notificationText;
        this.zzapg = title;
        this.zzaDH = subtitle;
        this.zzWQ = displayName;
        this.zzbrI = eventId;
        this.zzbrJ = eventFlags;
        this.zzbrK = categoryId;
        this.zzbrL = categoryCount;
        this.zzTJ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AncsNotificationParcelable ancsNotificationParcelable = (AncsNotificationParcelable) o;
        if (this.zzbrL != ancsNotificationParcelable.zzbrL) {
            return false;
        }
        if (this.zzbrK != ancsNotificationParcelable.zzbrK) {
            return false;
        }
        if (this.zzbrJ != ancsNotificationParcelable.zzbrJ) {
            return false;
        }
        if (this.zzbrI != ancsNotificationParcelable.zzbrI) {
            return false;
        }
        if (this.mId != ancsNotificationParcelable.mId) {
            return false;
        }
        if (this.mVersionCode != ancsNotificationParcelable.mVersionCode) {
            return false;
        }
        if (!this.zzaUa.equals(ancsNotificationParcelable.zzaUa)) {
            return false;
        }
        if (this.zzbrH == null ? ancsNotificationParcelable.zzbrH != null : !this.zzbrH.equals(ancsNotificationParcelable.zzbrH)) {
            return false;
        }
        if (!this.zzWQ.equals(ancsNotificationParcelable.zzWQ)) {
            return false;
        }
        if (!this.zzaaH.equals(ancsNotificationParcelable.zzaaH)) {
            return false;
        }
        if (this.zzaDH.equals(ancsNotificationParcelable.zzaDH)) {
            return this.zzapg.equals(ancsNotificationParcelable.zzapg);
        } else {
            return false;
        }
    }

    public String getDisplayName() {
        return this.zzWQ == null ? this.zzaUa : this.zzWQ;
    }

    public int getId() {
        return this.mId;
    }

    public String getPackageName() {
        return this.zzTJ;
    }

    public String getTitle() {
        return this.zzapg;
    }

    public int hashCode() {
        return (((((((((((((((((this.zzbrH != null ? this.zzbrH.hashCode() : 0) + (((((this.mVersionCode * 31) + this.mId) * 31) + this.zzaUa.hashCode()) * 31)) * 31) + this.zzaaH.hashCode()) * 31) + this.zzapg.hashCode()) * 31) + this.zzaDH.hashCode()) * 31) + this.zzWQ.hashCode()) * 31) + this.zzbrI) * 31) + this.zzbrJ) * 31) + this.zzbrK) * 31) + this.zzbrL;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.mVersionCode + ", mId=" + this.mId + ", mAppId='" + this.zzaUa + '\'' + ", mDateTime='" + this.zzbrH + '\'' + ", mNotificationText='" + this.zzaaH + '\'' + ", mTitle='" + this.zzapg + '\'' + ", mSubtitle='" + this.zzaDH + '\'' + ", mDisplayName='" + this.zzWQ + '\'' + ", mEventId=" + this.zzbrI + ", mEventFlags=" + this.zzbrJ + ", mCategoryId=" + this.zzbrK + ", mCategoryCount=" + this.zzbrL + '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public String zzIB() {
        return this.zzbrH;
    }

    public String zzIC() {
        return this.zzaaH;
    }

    public byte zzID() {
        return this.zzbrI;
    }

    public byte zzIE() {
        return this.zzbrJ;
    }

    public byte zzIF() {
        return this.zzbrK;
    }

    public byte zzIG() {
        return this.zzbrL;
    }

    public String zzwK() {
        return this.zzaUa;
    }

    public String zzwc() {
        return this.zzaDH;
    }
}
