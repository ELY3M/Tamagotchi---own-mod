package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Creator<Cart> CREATOR = new zzb();
    private final int mVersionCode;
    String zzboh;
    String zzboi;
    ArrayList<LineItem> zzboj;

    public final class Builder {
        final /* synthetic */ Cart zzbok;

        private Builder(Cart cart) {
            this.zzbok = cart;
        }

        public Builder addLineItem(LineItem lineItem) {
            this.zzbok.zzboj.add(lineItem);
            return this;
        }

        public Cart build() {
            return this.zzbok;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzbok.zzboi = currencyCode;
            return this;
        }

        public Builder setLineItems(List<LineItem> lineItems) {
            this.zzbok.zzboj.clear();
            this.zzbok.zzboj.addAll(lineItems);
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.zzbok.zzboh = totalPrice;
            return this;
        }
    }

    Cart() {
        this.mVersionCode = 1;
        this.zzboj = new ArrayList();
    }

    Cart(int versionCode, String totalPrice, String currencyCode, ArrayList<LineItem> lineItems) {
        this.mVersionCode = versionCode;
        this.zzboh = totalPrice;
        this.zzboi = currencyCode;
        this.zzboj = lineItems;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzboi;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.zzboj;
    }

    public String getTotalPrice() {
        return this.zzboh;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
