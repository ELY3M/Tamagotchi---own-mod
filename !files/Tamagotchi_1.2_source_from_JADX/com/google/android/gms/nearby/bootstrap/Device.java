package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class Device implements SafeParcelable {
    public static final Creator<Device> CREATOR = new zzb();
    private final String description;
    private final String name;
    final int versionCode;
    private final String zzbaQ;
    private final byte zzbaR;

    Device(int versionCode, String name, String description, String deviceId, byte deviceType) {
        this.versionCode = versionCode;
        this.name = zzx.zzcM(name);
        this.description = (String) zzx.zzz(description);
        this.zzbaQ = (String) zzx.zzz(deviceId);
        zzx.zzb(deviceType <= (byte) 4, (Object) "Unknown device type");
        this.zzbaR = deviceType;
    }

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceId() {
        return this.zzbaQ;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + ": " + this.description + "[" + this.zzbaR + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public byte zzEb() {
        return this.zzbaR;
    }
}
