package org.anddev.andengine.util;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import java.util.GregorianCalendar;
import org.acra.ACRAConstants;
import org.anddev.andengine.util.constants.Constants;

public class BetaUtils implements Constants {
    private static final String PREFERENCES_BETAUTILS_ID = "preferences.betautils.lastuse";

    class C06011 implements OnClickListener {
        private final /* synthetic */ Activity val$pActivity;
        private final /* synthetic */ Intent val$pOkIntent;

        C06011(Intent intent, Activity activity) {
            this.val$pOkIntent = intent;
            this.val$pActivity = activity;
        }

        public void onClick(DialogInterface pDialog, int pWhich) {
            if (this.val$pOkIntent != null) {
                this.val$pActivity.startActivity(this.val$pOkIntent);
            }
            this.val$pActivity.finish();
        }
    }

    class C06022 implements OnClickListener {
        private final /* synthetic */ Activity val$pActivity;
        private final /* synthetic */ Intent val$pCancelIntent;

        C06022(Intent intent, Activity activity) {
            this.val$pCancelIntent = intent;
            this.val$pActivity = activity;
        }

        public void onClick(DialogInterface pDialog, int pWhich) {
            if (this.val$pCancelIntent != null) {
                this.val$pActivity.startActivity(this.val$pCancelIntent);
            }
            this.val$pActivity.finish();
        }
    }

    public static boolean finishWhenExpired(Activity pActivity, GregorianCalendar pExpirationDate, int pTitleResourceID, int pMessageResourceID) {
        return finishWhenExpired(pActivity, pExpirationDate, pTitleResourceID, pMessageResourceID, null, null);
    }

    public static boolean finishWhenExpired(Activity pActivity, GregorianCalendar pExpirationDate, int pTitleResourceID, int pMessageResourceID, Intent pOkIntent, Intent pCancelIntent) {
        SharedPreferences spref = SimplePreferences.getInstance(pActivity);
        long lastuse = Math.max(System.currentTimeMillis(), spref.getLong(PREFERENCES_BETAUTILS_ID, -1));
        spref.edit().putLong(PREFERENCES_BETAUTILS_ID, lastuse).commit();
        GregorianCalendar lastuseDate = new GregorianCalendar();
        lastuseDate.setTimeInMillis(lastuse);
        if (!lastuseDate.after(pExpirationDate)) {
            return false;
        }
        Builder alertDialogBuilder = new Builder(pActivity).setTitle(pTitleResourceID).setIcon(ACRAConstants.DEFAULT_DIALOG_ICON).setMessage(pMessageResourceID);
        alertDialogBuilder.setPositiveButton(ACRAConstants.DEFAULT_DIALOG_POSITIVE_BUTTON_TEXT, new C06011(pOkIntent, pActivity));
        alertDialogBuilder.setNegativeButton(ACRAConstants.DEFAULT_DIALOG_NEGATIVE_BUTTON_TEXT, new C06022(pCancelIntent, pActivity)).create().show();
        return true;
    }
}
