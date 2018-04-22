package com.google.android.gms.wallet.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzsf;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

@TargetApi(12)
public final class WalletFragment extends Fragment {
    private boolean mCreated = false;
    private final Fragment zzavH = this;
    private WalletFragmentOptions zzbqa;
    private WalletFragmentInitParams zzbqb;
    private MaskedWalletRequest zzbqc;
    private MaskedWallet zzbqd;
    private Boolean zzbqe;
    private zzb zzbqj;
    private final com.google.android.gms.dynamic.zzb zzbqk = com.google.android.gms.dynamic.zzb.zza(this);
    private final zzc zzbql = new zzc();
    private zza zzbqm = new zza(this);

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
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
        final /* synthetic */ WalletFragment zzbqp;

        private zzc(WalletFragment walletFragment) {
            this.zzbqp = walletFragment;
        }

        public void onClick(View view) {
            Context activity = this.zzbqp.zzavH.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        protected void zza(FrameLayout frameLayout) {
            View button = new Button(this.zzbqp.zzavH.getActivity());
            button.setText(C0196R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.zzbqp.zzbqa != null) {
                WalletFragmentStyle fragmentStyle = this.zzbqp.zzbqa.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.zzbqp.zzavH.getResources().getDisplayMetrics();
                    i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void zza(zzf<zzb> com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_WalletFragment_zzb) {
            Activity activity = this.zzbqp.zzavH.getActivity();
            if (this.zzbqp.zzbqj == null && this.zzbqp.mCreated && activity != null) {
                try {
                    this.zzbqp.zzbqj = new zzb(zzsf.zza(activity, this.zzbqp.zzbqk, this.zzbqp.zzbqa, this.zzbqp.zzbqm));
                    this.zzbqp.zzbqa = null;
                    com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_WalletFragment_zzb.zza(this.zzbqp.zzbqj);
                    if (this.zzbqp.zzbqb != null) {
                        this.zzbqp.zzbqj.initialize(this.zzbqp.zzbqb);
                        this.zzbqp.zzbqb = null;
                    }
                    if (this.zzbqp.zzbqc != null) {
                        this.zzbqp.zzbqj.updateMaskedWalletRequest(this.zzbqp.zzbqc);
                        this.zzbqp.zzbqc = null;
                    }
                    if (this.zzbqp.zzbqd != null) {
                        this.zzbqp.zzbqj.updateMaskedWallet(this.zzbqp.zzbqd);
                        this.zzbqp.zzbqd = null;
                    }
                    if (this.zzbqp.zzbqe != null) {
                        this.zzbqp.zzbqj.setEnabled(this.zzbqp.zzbqe.booleanValue());
                        this.zzbqp.zzbqe = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    static class zza extends com.google.android.gms.internal.zzry.zza {
        private OnStateChangedListener zzbqn;
        private final WalletFragment zzbqo;

        zza(WalletFragment walletFragment) {
            this.zzbqo = walletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzbqn != null) {
                this.zzbqn.onStateChanged(this.zzbqo, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzbqn = onStateChangedListener;
        }
    }

    public static WalletFragment newInstance(WalletFragmentOptions options) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        walletFragment.zzavH.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        return this.zzbqj != null ? this.zzbqj.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzbqj != null) {
            this.zzbqj.initialize(initParams);
            this.zzbqb = null;
        } else if (this.zzbqb == null) {
            this.zzbqb = initParams;
            if (this.zzbqc != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzbqd != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzbqj != null) {
            this.zzbqj.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzbqb != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        } else if (this.zzavH.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzavH.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzbc(this.zzavH.getActivity());
                this.zzbqa = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzbql.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzbql.onCreateView(inflater, container, savedInstanceState);
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
        this.zzbql.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.zzbql.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzbql.onResume();
        FragmentManager fragmentManager = this.zzavH.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzavH.getActivity()), this.zzavH.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzbql.onSaveInstanceState(outState);
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
        this.zzbql.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzbql.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzbqj != null) {
            this.zzbqj.setEnabled(enabled);
            this.zzbqe = null;
            return;
        }
        this.zzbqe = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzbqm.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzbqj != null) {
            this.zzbqj.updateMaskedWallet(maskedWallet);
            this.zzbqd = null;
            return;
        }
        this.zzbqd = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzbqj != null) {
            this.zzbqj.updateMaskedWalletRequest(request);
            this.zzbqc = null;
            return;
        }
        this.zzbqc = request;
    }
}
