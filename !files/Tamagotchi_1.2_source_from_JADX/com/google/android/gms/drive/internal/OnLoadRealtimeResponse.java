package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnLoadRealtimeResponse implements SafeParcelable {
    public static final Creator<OnLoadRealtimeResponse> CREATOR = new zzbg();
    final int mVersionCode;
    final boolean zzqA;

    OnLoadRealtimeResponse(int versionCode, boolean isInitialized) {
        this.mVersionCode = versionCode;
        this.zzqA = isInitialized;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbg.zza(this, dest, flags);
    }
}
