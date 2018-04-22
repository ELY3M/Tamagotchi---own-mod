package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0196R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzsf;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    private boolean mCreated = false;
    private final Fragment zzalg = this;
    private zzb zzbpW;
    private final zzh zzbpX = zzh.zza(this);
    private final zzc zzbpY = new zzc();
    private zza zzbpZ = new zza(this);
    private WalletFragmentOptions zzbqa;
    private WalletFragmentInitParams zzbqb;
    private MaskedWalletRequest zzbqc;
    private MaskedWallet zzbqd;
    private Boolean zzbqe;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    private static class zzb implements LifecycleDelegate {
        private final zzrx zzbqh;

        private zzb(zzrx com_google_android_gms_internal_zzrx) {
            this.zzbqh = com_google_android_gms_internal_zzrx;
        }

        private int getState() {
            try {
                return this.zzbqh.getState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void initialize(WalletFragmentInitParams startParams) {
            try {
                this.zzbqh.initialize(startParams);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.zzbqh.onActivityResult(requestCode, resultCode, data);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void setEnabled(boolean enabled) {
            try {
                this.zzbqh.setEnabled(enabled);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzbqh.updateMaskedWallet(maskedWallet);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.zzbqh.updateMaskedWalletRequest(request);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzbqh.onCreate(savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzp(this.zzbqh.onCreateView(zze.zzC(inflater), zze.zzC(container), savedInstanceState));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzbqh.zza(zze.zzC(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.zzbqh.onPause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.zzbqh.onResume();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzbqh.onSaveInstanceState(outState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.zzbqh.onStart();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.zzbqh.onStop();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class zzc extends com.google.android.gms.dynamic.zza<zzb> implements OnClickListener {
        final /* synthetic */ SupportWalletFragment zzbqi;

        private zzc(SupportWalletFragment supportWalletFragment) {
            this.zzbqi = supportWalletFragment;
        }

        public void onClick(View view) {
            Context activity = this.zzbqi.zzalg.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        protected void zza(FrameLayout frameLayout) {
            View button = new Button(this.zzbqi.zzalg.getActivity());
            button.setText(C0196R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.zzbqi.zzbqa != null) {
                WalletFragmentStyle fragmentStyle = this.zzbqi.zzbqa.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.zzbqi.zzalg.getResources().getDisplayMetrics();
                    i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void zza(zzf<zzb> com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_SupportWalletFragment_zzb) {
            Activity activity = this.zzbqi.zzalg.getActivity();
            if (this.zzbqi.zzbpW == null && this.zzbqi.mCreated && activity != null) {
                try {
                    this.zzbqi.zzbpW = new zzb(zzsf.zza(activity, this.zzbqi.zzbpX, this.zzbqi.zzbqa, this.zzbqi.zzbpZ));
                    this.zzbqi.zzbqa = null;
                    com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_SupportWalletFragment_zzb.zza(this.zzbqi.zzbpW);
                    if (this.zzbqi.zzbqb != null) {
                        this.zzbqi.zzbpW.initialize(this.zzbqi.zzbqb);
                        this.zzbqi.zzbqb = null;
                    }
                    if (this.zzbqi.zzbqc != null) {
                        this.zzbqi.zzbpW.updateMaskedWalletRequest(this.zzbqi.zzbqc);
                        this.zzbqi.zzbqc = null;
                    }
                    if (this.zzbqi.zzbqd != null) {
                        this.zzbqi.zzbpW.updateMaskedWallet(this.zzbqi.zzbqd);
                        this.zzbqi.zzbqd = null;
                    }
                    if (this.zzbqi.zzbqe != null) {
                        this.zzbqi.zzbpW.setEnabled(this.zzbqi.zzbqe.booleanValue());
                        this.zzbqi.zzbqe = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    static class zza extends com.google.android.gms.internal.zzry.zza {
        private OnStateChangedListener zzbqf;
        private final SupportWalletFragment zzbqg;

        zza(SupportWalletFragment supportWalletFragment) {
            this.zzbqg = supportWalletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzbqf != null) {
                this.zzbqf.onStateChanged(this.zzbqg, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzbqf = onStateChangedListener;
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions options) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        supportWalletFragment.zzalg.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        return this.zzbpW != null ? this.zzbpW.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzbpW != null) {
            this.zzbpW.initialize(initParams);
            this.zzbqb = null;
        } else if (this.zzbqb == null) {
            this.zzbqb = initParams;
            if (this.zzbqc != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzbqd != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzbpW != null) {
            this.zzbpW.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzbqb != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzbqb = walletFragmentInitParams;
            }
            if (this.zzbqc == null) {
                this.zzbqc = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.zzbqd == null) {
                this.zzbqd = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.zzbqa = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.zzbqe = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (this.zzalg.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzalg.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzbc(this.zzalg.getActivity());
                this.zzbqa = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzbpY.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzbpY.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.zzbqa == null) {
            this.zzbqa = WalletFragmentOptions.zzb((Context) activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.zzbqa);
        this.zzbpY.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.zzbpY.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzbpY.onResume();
        FragmentManager supportFragmentManager = this.zzalg.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzalg.getActivity()), this.zzalg.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzbpY.onSaveInstanceState(outState);
        if (this.zzbqb != null) {
            outState.putParcelable("walletFragmentInitParams", this.zzbqb);
            this.zzbqb = null;
        }
        if (this.zzbqc != null) {
            outState.putParcelable("maskedWalletRequest", this.zzbqc);
            this.zzbqc = null;
        }
        if (this.zzbqd != null) {
            outState.putParcelable("maskedWallet", this.zzbqd);
            this.zzbqd = null;
        }
        if (this.zzbqa != null) {
            outState.putParcelable("walletFragmentOptions", this.zzbqa);
            this.zzbqa = null;
        }
        if (this.zzbqe != null) {
            outState.putBoolean("enabled", this.zzbqe.booleanValue());
            this.zzbqe = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.zzbpY.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzbpY.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzbpW != null) {
            this.zzbpW.setEnabled(enabled);
            this.zzbqe = null;
            return;
        }
        this.zzbqe = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzbpZ.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzbpW != null) {
            this.zzbpW.updateMaskedWallet(maskedWallet);
            this.zzbqd = null;
            return;
        }
        this.zzbqd = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzbpW != null) {
            this.zzbpW.updateMaskedWalletRequest(request);
            this.zzbqc = null;
            return;
        }
        this.zzbqc = request;
    }
}
