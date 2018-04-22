package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetRecentContextCall {

    public static class Request implements SafeParcelable {
        public static final zzf CREATOR = new zzf();
        final int mVersionCode;
        public final Account zzTT;
        public final boolean zzTU;
        public final boolean zzTV;
        public final boolean zzTW;
        public final String zzTX;

        public Request() {
            this(null, false, false, false, null);
        }

        Request(int versionCode, Account filterAccount, boolean includeDeviceOnlyData, boolean includeThirdPartyContext, boolean includeUsageEnded, String filterPackageName) {
            this.mVersionCode = versionCode;
            this.zzTT = filterAccount;
            this.zzTU = includeDeviceOnlyData;
            this.zzTV = includeThirdPartyContext;
            this.zzTW = includeUsageEnded;
            this.zzTX = filterPackageName;
        }

        public Request(Account filterAccount, boolean includeDeviceOnlyData, boolean includeThirdPartyContext, boolean includeUsageEnded, String filterPackageName) {
            this(1, filterAccount, includeDeviceOnlyData, includeThirdPartyContext, includeUsageEnded, filterPackageName);
        }

        public int describeContents() {
            zzf com_google_android_gms_appdatasearch_zzf = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzf com_google_android_gms_appdatasearch_zzf = CREATOR;
            zzf.zza(this, out, flags);
        }
    }

    public static class Response implements Result, SafeParcelable {
        public static final zzg CREATOR = new zzg();
        final int mVersionCode;
        public Status zzTY;
        public List<UsageInfo> zzTZ;
        @Deprecated
        public String[] zzUa;

        public Response() {
            this.mVersionCode = 1;
        }

        Response(int versionCode, Status status, List<UsageInfo> usageInfo, String[] topRunningPackages) {
            this.mVersionCode = versionCode;
            this.zzTY = status;
            this.zzTZ = usageInfo;
            this.zzUa = topRunningPackages;
        }

        public int describeContents() {
            zzg com_google_android_gms_appdatasearch_zzg = CREATOR;
            return 0;
        }

        public Status getStatus() {
            return this.zzTY;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzg com_google_android_gms_appdatasearch_zzg = CREATOR;
            zzg.zza(this, out, flags);
        }
    }
}
