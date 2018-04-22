package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlf;
import com.google.android.gms.internal.zzlh;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@KeepName
public class SignInHubActivity extends FragmentActivity {
    private zzq zzXP;
    private zzk zzXQ;
    private SignInConfiguration zzXR;
    private boolean zzXS;
    private String zzXT;
    private String zzXU;
    private boolean zzXV;
    private int zzXW;
    private Intent zzXX;

    private class zza implements LoaderCallbacks<Void> {
        final /* synthetic */ SignInHubActivity zzXZ;

        private zza(SignInHubActivity signInHubActivity) {
            this.zzXZ = signInHubActivity;
        }

        public Loader<Void> onCreateLoader(int i, Bundle bundle) {
            return new zzb(this.zzXZ, GoogleApiClient.zzoV());
        }

        public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
            zza(loader, (Void) obj);
        }

        public void onLoaderReset(Loader<Void> loader) {
        }

        public void zza(Loader<Void> loader, Void voidR) {
            this.zzXZ.setResult(this.zzXZ.zzXW, this.zzXZ.zzXX);
            this.zzXZ.finish();
        }
    }

    private void zza(int i, int i2, Intent intent) {
        for (zzlf zza : this.zzXQ.zznh()) {
            if (zza.zza(i, i2, intent, zzbO(this.zzXU))) {
                break;
            }
        }
        if (i2 == 0) {
            finish();
        }
    }

    private void zza(int i, Intent intent) {
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.zzmV() != null) {
                GoogleSignInAccount zzmV = signInAccount.zzmV();
                this.zzXP.zzb(zzmV, this.zzXR.zznm());
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", zzmV);
                this.zzXV = true;
                this.zzXW = i;
                this.zzXX = intent;
                zzd(i, intent);
                return;
            } else if (intent.hasExtra("errorCode")) {
                zzaS(intent.getIntExtra("errorCode", 8));
                return;
            }
        }
        zzaS(8);
    }

    private void zzaR(int i) {
        Intent intent = new Intent();
        intent.putExtra("errorCode", i);
        setResult(0, intent);
        finish();
    }

    private void zzaS(int i) {
        Parcelable status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
    }

    private void zzb(int i, Intent intent) {
        if (i == -1) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null) {
                this.zzXP.zzb(signInAccount, this.zzXR);
                Object stringExtra = intent.getStringExtra("accessToken");
                if (!(TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(this.zzXU))) {
                    zzm.zzbN(signInAccount.getUserId()).zza(new HashSet(Arrays.asList(TextUtils.split(this.zzXU, " "))), new com.google.android.gms.auth.api.signin.internal.zzm.zza(stringExtra, intent.getLongExtra("accessTokenExpiresAtSecs", 0)));
                    intent.removeExtra("accessTokenExpiresAtSecs");
                }
                setResult(-1, intent);
                finish();
                return;
            }
            Log.w("AuthSignInClient", "[SignInHubActivity] SignInAccount is null.");
            zzaR(2);
        } else if (intent == null) {
            finish();
        } else {
            Object stringExtra2 = intent.getStringExtra("email");
            zzd zzbL = zzd.zzbL(intent.getStringExtra("idProvider"));
            if (zzbL == null) {
                setResult(i, intent);
                finish();
                return;
            }
            this.zzXT = intent.getStringExtra("pendingToken");
            zzlf zza = this.zzXQ.zza(zzbL);
            if (zza == null) {
                Log.w("AuthSignInClient", zzbL.zzae(this) + " is not supported. Please check your configuration");
                zzaR(1);
                return;
            }
            int intExtra = intent.getIntExtra("idpAction", -1);
            if (intExtra == 0) {
                if (TextUtils.isEmpty(stringExtra2)) {
                    zza.zza(zzbO(this.zzXU));
                } else {
                    zza.zza(stringExtra2, zzbO(this.zzXU));
                }
            } else if (intExtra != 1 || TextUtils.isEmpty(this.zzXT) || TextUtils.isEmpty(stringExtra2)) {
                Log.w("AuthSignInClient", "Internal error!");
                zzaR(2);
            } else {
                zza.zza(stringExtra2, this.zzXT, zzbO(this.zzXU));
            }
        }
    }

    private com.google.android.gms.internal.zzlf.zza zzbO(final String str) {
        return new com.google.android.gms.internal.zzlf.zza(this) {
            final /* synthetic */ SignInHubActivity zzXZ;

            public void zzk(Intent intent) {
                if (intent != null) {
                    if (!TextUtils.isEmpty(str)) {
                        intent.putExtra("scopes", str);
                    }
                    this.zzXZ.zzj(intent);
                    return;
                }
                Log.w("AuthSignInClient", "Idp signin failed!");
                this.zzXZ.zzaR(4);
            }
        };
    }

    private void zzc(int i, Intent intent) {
        if (i == 0) {
            setResult(0, intent);
            finish();
            return;
        }
        Intent intent2 = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent2.putExtra("idpTokenType", IdpTokenType.zzXA);
        intent2.putExtra("idpToken", intent.getStringExtra("idpToken"));
        intent2.putExtra("pendingToken", this.zzXT);
        intent2.putExtra("idProvider", zzd.FACEBOOK.zzmT());
        zzj(intent2);
    }

    private void zzd(int i, Intent intent) {
        getSupportLoaderManager().initLoader(0, null, new zza());
    }

    private void zzj(Intent intent) {
        intent.setPackage("com.google.android.gms");
        intent.putExtra("config", this.zzXR);
        try {
            startActivityForResult(intent, this.zzXS ? 40962 : 40961);
        } catch (ActivityNotFoundException e) {
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            if (this.zzXS) {
                zzaS(8);
            } else {
                zzaR(2);
            }
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        setResult(0);
        switch (requestCode) {
            case 40961:
                zzb(resultCode, data);
                return;
            case 40962:
                zza(resultCode, data);
                return;
            case 45057:
                zzc(resultCode, data);
                return;
            default:
                zza(requestCode, resultCode, data);
                return;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        zzlh com_google_android_gms_internal_zzlh = null;
        super.onCreate(savedInstanceState);
        this.zzXP = zzq.zzaf(this);
        Intent intent = getIntent();
        this.zzXR = (SignInConfiguration) intent.getParcelableExtra("config");
        this.zzXS = "com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(intent.getAction());
        this.zzXU = intent.getStringExtra("scopes");
        if (this.zzXR == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        List linkedList = new LinkedList();
        Map hashMap = new HashMap();
        zzi.zza(this.zzXR, linkedList, hashMap);
        this.zzXQ = new zzk(this, linkedList, hashMap);
        if (savedInstanceState == null) {
            Intent intent2;
            SignInAccount signInAccount;
            if (this.zzXS) {
                intent2 = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
                signInAccount = com_google_android_gms_internal_zzlh;
            } else {
                intent2 = new Intent("com.google.android.gms.auth.LOGIN_PICKER");
                if ("com.google.android.gms.auth.RESOLVE_CREDENTIAL".equals(intent.getAction())) {
                    intent2.fillIn(intent, 3);
                    signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                } else {
                    this.zzXP.zznq();
                    Object obj;
                    if (com_google_android_gms_internal_zzlh != null) {
                        try {
                            zzlh.zzag(this);
                            obj = com_google_android_gms_internal_zzlh;
                        } catch (IllegalStateException e) {
                            obj = com_google_android_gms_internal_zzlh;
                        }
                    } else {
                        obj = com_google_android_gms_internal_zzlh;
                    }
                }
            }
            if (signInAccount == null || signInAccount.zzmU() != zzd.FACEBOOK) {
                zzj(intent2);
                return;
            } else {
                com_google_android_gms_internal_zzlh.zza(zzbO(this.zzXU));
                return;
            }
        }
        this.zzXT = savedInstanceState.getString("pendingToken");
        this.zzXV = savedInstanceState.getBoolean("signingInGoogleApiClients");
        if (this.zzXV) {
            this.zzXW = savedInstanceState.getInt("signInResultCode");
            this.zzXX = (Intent) savedInstanceState.getParcelable("signInResultData");
            zzd(this.zzXW, this.zzXX);
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("pendingToken", this.zzXT);
        outState.putBoolean("signingInGoogleApiClients", this.zzXV);
        if (this.zzXV) {
            outState.putInt("signInResultCode", this.zzXW);
            outState.putParcelable("signInResultData", this.zzXX);
        }
    }
}
