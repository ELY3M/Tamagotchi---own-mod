package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.PopupManager.PopupLocationInfo;

public final class PopupLocationInfoParcelable implements SafeParcelable {
    public static final PopupLocationInfoParcelableCreator CREATOR = new PopupLocationInfoParcelableCreator();
    private final int mVersionCode;
    private final Bundle zzaFH;
    private final IBinder zzaFI;

    PopupLocationInfoParcelable(int versionCode, Bundle infoBundle, IBinder windowToken) {
        this.mVersionCode = versionCode;
        this.zzaFH = infoBundle;
        this.zzaFI = windowToken;
    }

    public PopupLocationInfoParcelable(PopupLocationInfo popupLocationInfo) {
        this.mVersionCode = 1;
        this.zzaFH = popupLocationInfo.zzxg();
        this.zzaFI = popupLocationInfo.zzaFL;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public IBinder getWindowToken() {
        return this.zzaFI;
    }

    public void writeToParcel(Parcel out, int flags) {
        PopupLocationInfoParcelableCreator.zza(this, out, flags);
    }

    public Bundle zzxg() {
        return this.zzaFH;
    }
}
