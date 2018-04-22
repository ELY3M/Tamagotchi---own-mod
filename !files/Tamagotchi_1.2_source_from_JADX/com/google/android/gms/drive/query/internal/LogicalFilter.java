package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public class LogicalFilter extends AbstractFilter {
    public static final Creator<LogicalFilter> CREATOR = new zzk();
    final int mVersionCode;
    private List<Filter> zzaua;
    final Operator zzaug;
    final List<FilterHolder> zzauv;

    LogicalFilter(int versionCode, Operator operator, List<FilterHolder> filterHolders) {
        this.mVersionCode = versionCode;
        this.zzaug = operator;
        this.zzauv = filterHolders;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... additionalFilters) {
        this.mVersionCode = 1;
        this.zzaug = operator;
        this.zzauv = new ArrayList(additionalFilters.length + 1);
        this.zzauv.add(new FilterHolder(filter));
        this.zzaua = new ArrayList(additionalFilters.length + 1);
        this.zzaua.add(filter);
        for (Filter filter2 : additionalFilters) {
            this.zzauv.add(new FilterHolder(filter2));
            this.zzaua.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable<Filter> filters) {
        this.mVersionCode = 1;
        this.zzaug = operator;
        this.zzaua = new ArrayList();
        this.zzauv = new ArrayList();
        for (Filter filter : filters) {
            this.zzaua.add(filter);
            this.zzauv.add(new FilterHolder(filter));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzk.zza(this, out, flags);
    }

    public <T> T zza(zzf<T> com_google_android_gms_drive_query_internal_zzf_T) {
        List arrayList = new ArrayList();
        for (FilterHolder filter : this.zzauv) {
            arrayList.add(filter.getFilter().zza(com_google_android_gms_drive_query_internal_zzf_T));
        }
        return com_google_android_gms_drive_query_internal_zzf_T.zzb(this.zzaug, arrayList);
    }
}
