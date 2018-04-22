package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
    public static final Creator<UserAddressRequest> CREATOR = new zza();
    private final int mVersionCode;
    List<CountrySpecification> zzaMA;

    public final class Builder {
        final /* synthetic */ UserAddressRequest zzaMB;

        private Builder(UserAddressRequest userAddressRequest) {
            this.zzaMB = userAddressRequest;
        }

        public Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (this.zzaMB.zzaMA == null) {
                this.zzaMB.zzaMA = new ArrayList();
            }
            this.zzaMB.zzaMA.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> countrySpecifications) {
            if (this.zzaMB.zzaMA == null) {
                this.zzaMB.zzaMA = new ArrayList();
            }
            this.zzaMB.zzaMA.addAll(countrySpecifications);
            return this;
        }

        public UserAddressRequest build() {
            if (this.zzaMB.zzaMA != null) {
                this.zzaMB.zzaMA = Collections.unmodifiableList(this.zzaMB.zzaMA);
            }
            return this.zzaMB;
        }
    }

    UserAddressRequest() {
        this.mVersionCode = 1;
    }

    UserAddressRequest(int versionCode, List<CountrySpecification> allowedCountrySpecifications) {
        this.mVersionCode = versionCode;
        this.zzaMA = allowedCountrySpecifications;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
