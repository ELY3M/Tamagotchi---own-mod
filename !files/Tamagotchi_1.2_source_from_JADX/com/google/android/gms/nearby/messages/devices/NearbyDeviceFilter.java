package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class NearbyDeviceFilter implements SafeParcelable {
    public static final Creator<NearbyDeviceFilter> CREATOR = new zzg();
    final int mVersionCode;
    final int zzbci;
    final byte[] zzbcj;
    final boolean zzbck;

    NearbyDeviceFilter(int versionCode, int idPrefixType, byte[] idPrefix, boolean shouldMatchUrls) {
        this.mVersionCode = versionCode;
        this.zzbci = idPrefixType;
        this.zzbcj = idPrefix;
        this.zzbck = shouldMatchUrls;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }
}
