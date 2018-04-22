package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.SharedContent;
import com.google.android.gms.nearby.sharing.internal.zzb.zza;
import java.util.List;

public final class ProvideContentRequest implements SafeParcelable {
    public static final Creator<ProvideContentRequest> CREATOR = new zzf();
    final int versionCode;
    public IBinder zzbdk;
    public zzb zzbdl;
    @Deprecated
    public List<SharedContent> zzbdm;
    public long zzbdn;
    public zzc zzbdo;

    ProvideContentRequest() {
        this.versionCode = 1;
    }

    ProvideContentRequest(int versionCode, IBinder clientBinder, IBinder contentProviderAsBinder, List<SharedContent> content, long activityId, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzbdk = clientBinder;
        this.zzbdl = zza.zzdG(contentProviderAsBinder);
        this.zzbdm = content;
        this.zzbdn = activityId;
        this.zzbdo = zzc.zza.zzdH(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbdo.asBinder();
    }

    IBinder zzEP() {
        return this.zzbdl == null ? null : this.zzbdl.asBinder();
    }
}
