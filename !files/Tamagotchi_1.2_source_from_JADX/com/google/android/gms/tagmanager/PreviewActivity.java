package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {

    class C05051 implements OnClickListener {
        final /* synthetic */ PreviewActivity zzbjP;

        C05051(PreviewActivity previewActivity) {
            this.zzbjP = previewActivity;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    private void zzm(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new C05051(this));
        create.show();
    }

    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            zzbg.zzaJ("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).zzp(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                zzbg.zzaK(str);
                zzm("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                zzbg.zzaJ("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            zzbg.zzaJ("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            zzbg.m11e("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
