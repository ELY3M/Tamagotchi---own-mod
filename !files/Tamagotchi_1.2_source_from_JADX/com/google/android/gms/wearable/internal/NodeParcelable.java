package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class NodeParcelable implements SafeParcelable, Node {
    public static final Creator<NodeParcelable> CREATOR = new zzbc();
    final int mVersionCode;
    private final String zzWQ;
    private final int zzbsY;
    private final boolean zzbsZ;
    private final String zzyv;

    NodeParcelable(int versionCode, String id, String displayName, int hopCount, boolean isNearby) {
        this.mVersionCode = versionCode;
        this.zzyv = id;
        this.zzWQ = displayName;
        this.zzbsY = hopCount;
        this.zzbsZ = isNearby;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return !(o instanceof NodeParcelable) ? false : ((NodeParcelable) o).zzyv.equals(this.zzyv);
    }

    public String getDisplayName() {
        return this.zzWQ;
    }

    public int getHopCount() {
        return this.zzbsY;
    }

    public String getId() {
        return this.zzyv;
    }

    public int hashCode() {
        return this.zzyv.hashCode();
    }

    public boolean isNearby() {
        return this.zzbsZ;
    }

    public String toString() {
        return "Node{" + this.zzWQ + ", id=" + this.zzyv + ", hops=" + this.zzbsY + ", isNearby=" + this.zzbsZ + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbc.zza(this, dest, flags);
    }
}
