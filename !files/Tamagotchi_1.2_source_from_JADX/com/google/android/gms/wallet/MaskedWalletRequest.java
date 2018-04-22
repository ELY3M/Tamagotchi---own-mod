package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Creator<MaskedWalletRequest> CREATOR = new zzm();
    private final int mVersionCode;
    String zzboi;
    String zzbop;
    Cart zzboz;
    boolean zzbpl;
    boolean zzbpm;
    boolean zzbpn;
    String zzbpo;
    String zzbpp;
    boolean zzbpq;
    boolean zzbpr;
    CountrySpecification[] zzbps;
    boolean zzbpt;
    boolean zzbpu;
    ArrayList<CountrySpecification> zzbpv;
    PaymentMethodTokenizationParameters zzbpw;
    ArrayList<Integer> zzbpx;

    public final class Builder {
        final /* synthetic */ MaskedWalletRequest zzbpy;

        private Builder(MaskedWalletRequest maskedWalletRequest) {
            this.zzbpy = maskedWalletRequest;
        }

        public Builder addAllowedCardNetwork(int allowedCardNetwork) {
            if (this.zzbpy.zzbpx == null) {
                this.zzbpy.zzbpx = new ArrayList();
            }
            this.zzbpy.zzbpx.add(Integer.valueOf(allowedCardNetwork));
            return this;
        }

        public Builder addAllowedCardNetworks(Collection<Integer> allowedCardNetworks) {
            if (allowedCardNetworks != null) {
                if (this.zzbpy.zzbpx == null) {
                    this.zzbpy.zzbpx = new ArrayList();
                }
                this.zzbpy.zzbpx.addAll(allowedCardNetworks);
            }
            return this;
        }

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (this.zzbpy.zzbpv == null) {
                this.zzbpy.zzbpv = new ArrayList();
            }
            this.zzbpy.zzbpv.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> countrySpecifications) {
            if (countrySpecifications != null) {
                if (this.zzbpy.zzbpv == null) {
                    this.zzbpy.zzbpv = new ArrayList();
                }
                this.zzbpy.zzbpv.addAll(countrySpecifications);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return this.zzbpy;
        }

        public Builder setAllowDebitCard(boolean allowDebitCard) {
            this.zzbpy.zzbpu = allowDebitCard;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean allowPrepaidCard) {
            this.zzbpy.zzbpt = allowPrepaidCard;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.zzbpy.zzboz = cart;
            return this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzbpy.zzboi = currencyCode;
            return this;
        }

        public Builder setEstimatedTotalPrice(String estimatedTotalPrice) {
            this.zzbpy.zzbpo = estimatedTotalPrice;
            return this;
        }

        @Deprecated
        public Builder setIsBillingAgreement(boolean isBillingAgreement) {
            this.zzbpy.zzbpr = isBillingAgreement;
            return this;
        }

        public Builder setMerchantName(String merchantName) {
            this.zzbpy.zzbpp = merchantName;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzbpy.zzbop = merchantTransactionId;
            return this;
        }

        public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters) {
            this.zzbpy.zzbpw = paymentMethodTokenizationParameters;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean phoneNumberRequired) {
            this.zzbpy.zzbpl = phoneNumberRequired;
            return this;
        }

        public Builder setShippingAddressRequired(boolean shippingAddressRequired) {
            this.zzbpy.zzbpm = shippingAddressRequired;
            return this;
        }

        @Deprecated
        public Builder setUseMinimalBillingAddress(boolean useMinimalBillingAddress) {
            this.zzbpy.zzbpn = useMinimalBillingAddress;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.mVersionCode = 3;
        this.zzbpt = true;
        this.zzbpu = true;
    }

    MaskedWalletRequest(int versionCode, String merchantTransactionId, boolean phoneNumberRequired, boolean shippingAddressRequired, boolean useMinimalBillingAddress, String estimatedTotalPrice, String currencyCode, String merchantName, Cart cart, boolean shouldRetrieveWalletObjects, boolean isBillingAgreement, CountrySpecification[] allowedShippingCountrySpecifications, boolean allowPrepaidCard, boolean allowDebitCard, ArrayList<CountrySpecification> allowedCountrySpecificationsForShipping, PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, ArrayList<Integer> allowedCardNetworks) {
        this.mVersionCode = versionCode;
        this.zzbop = merchantTransactionId;
        this.zzbpl = phoneNumberRequired;
        this.zzbpm = shippingAddressRequired;
        this.zzbpn = useMinimalBillingAddress;
        this.zzbpo = estimatedTotalPrice;
        this.zzboi = currencyCode;
        this.zzbpp = merchantName;
        this.zzboz = cart;
        this.zzbpq = shouldRetrieveWalletObjects;
        this.zzbpr = isBillingAgreement;
        this.zzbps = allowedShippingCountrySpecifications;
        this.zzbpt = allowPrepaidCard;
        this.zzbpu = allowDebitCard;
        this.zzbpv = allowedCountrySpecificationsForShipping;
        this.zzbpw = paymentMethodTokenizationParameters;
        this.zzbpx = allowedCardNetworks;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.zzbpu;
    }

    public boolean allowPrepaidCard() {
        return this.zzbpt;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<Integer> getAllowedCardNetworks() {
        return this.zzbpx;
    }

    public ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.zzbpv;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.zzbps;
    }

    public Cart getCart() {
        return this.zzboz;
    }

    public String getCurrencyCode() {
        return this.zzboi;
    }

    public String getEstimatedTotalPrice() {
        return this.zzbpo;
    }

    public String getMerchantName() {
        return this.zzbpp;
    }

    public String getMerchantTransactionId() {
        return this.zzbop;
    }

    public PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters() {
        return this.zzbpw;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Deprecated
    public boolean isBillingAgreement() {
        return this.zzbpr;
    }

    public boolean isPhoneNumberRequired() {
        return this.zzbpl;
    }

    public boolean isShippingAddressRequired() {
        return this.zzbpm;
    }

    @Deprecated
    public boolean useMinimalBillingAddress() {
        return this.zzbpn;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }
}
