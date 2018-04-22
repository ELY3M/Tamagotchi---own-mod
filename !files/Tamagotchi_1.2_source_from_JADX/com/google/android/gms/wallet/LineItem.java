package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem implements SafeParcelable {
    public static final Creator<LineItem> CREATOR = new zzj();
    String description;
    private final int mVersionCode;
    String zzboL;
    String zzboM;
    int zzboN;
    String zzboh;
    String zzboi;

    public final class Builder {
        final /* synthetic */ LineItem zzboO;

        private Builder(LineItem lineItem) {
            this.zzboO = lineItem;
        }

        public LineItem build() {
            return this.zzboO;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzboO.zzboi = currencyCode;
            return this;
        }

        public Builder setDescription(String description) {
            this.zzboO.description = description;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.zzboO.zzboL = quantity;
            return this;
        }

        public Builder setRole(int role) {
            this.zzboO.zzboN = role;
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.zzboO.zzboh = totalPrice;
            return this;
        }

        public Builder setUnitPrice(String unitPrice) {
            this.zzboO.zzboM = unitPrice;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.mVersionCode = 1;
        this.zzboN = 0;
    }

    LineItem(int versionCode, String description, String quantity, String unitPrice, String totalPrice, int role, String currencyCode) {
        this.mVersionCode = versionCode;
        this.description = description;
        this.zzboL = quantity;
        this.zzboM = unitPrice;
        this.zzboh = totalPrice;
        this.zzboN = role;
        this.zzboi = currencyCode;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzboi;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.zzboL;
    }

    public int getRole() {
        return this.zzboN;
    }

    public String getTotalPrice() {
        return this.zzboh;
    }

    public String getUnitPrice() {
        return this.zzboM;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
