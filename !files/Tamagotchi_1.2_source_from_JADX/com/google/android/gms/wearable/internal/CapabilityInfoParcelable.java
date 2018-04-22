package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable implements SafeParcelable, CapabilityInfo {
    public static final Creator<CapabilityInfoParcelable> CREATOR = new zzk();
    private final String mName;
    final int mVersionCode;
    private Set<Node> zzbrS;
    private final List<NodeParcelable> zzbrV;
    private final Object zzpV = new Object();

    CapabilityInfoParcelable(int versionCode, String name, List<NodeParcelable> nodeList) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzbrV = nodeList;
        this.zzbrS = null;
        zzIH();
    }

    private void zzIH() {
        zzx.zzz(this.mName);
        zzx.zzz(this.zzbrV);
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
        CapabilityInfoParcelable capabilityInfoParcelable = (CapabilityInfoParcelable) o;
        if (this.mVersionCode != capabilityInfoParcelable.mVersionCode) {
            return false;
        }
        if (this.mName == null ? capabilityInfoParcelable.mName != null : !this.mName.equals(capabilityInfoParcelable.mName)) {
            return false;
        }
        if (this.zzbrV != null) {
            if (this.zzbrV.equals(capabilityInfoParcelable.zzbrV)) {
                return true;
            }
        } else if (capabilityInfoParcelable.zzbrV == null) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.mName;
    }

    public Set<Node> getNodes() {
        Set<Node> set;
        synchronized (this.zzpV) {
            if (this.zzbrS == null) {
                this.zzbrS = new HashSet(this.zzbrV);
            }
            set = this.zzbrS;
        }
        return set;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.mName != null ? this.mName.hashCode() : 0) + (this.mVersionCode * 31)) * 31;
        if (this.zzbrV != null) {
            i = this.zzbrV.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CapabilityInfo{" + this.mName + ", " + this.zzbrV + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    public List<NodeParcelable> zzII() {
        return this.zzbrV;
    }
}
