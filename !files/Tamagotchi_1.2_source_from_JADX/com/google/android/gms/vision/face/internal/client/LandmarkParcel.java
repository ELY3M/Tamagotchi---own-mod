package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LandmarkParcel implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final int type;
    public final int versionCode;
    public final float f19x;
    public final float f20y;

    public LandmarkParcel(int versionCode, float x, float y, int type) {
        this.versionCode = versionCode;
        this.f19x = x;
        this.f20y = y;
        this.type = type;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }
}
