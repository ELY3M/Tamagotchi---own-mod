package org.anddev.andengine.ui.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import org.anddev.andengine.util.Callback;

public class StringInputDialogBuilder extends GenericInputDialogBuilder<String> {
    public StringInputDialogBuilder(Context pContext, int pTitleResID, int pMessageResID, int pErrorResID, int pIconResID, Callback<String> pSuccessCallback, OnCancelListener pOnCancelListener) {
        super(pContext, pTitleResID, pMessageResID, pErrorResID, pIconResID, pSuccessCallback, pOnCancelListener);
    }

    public StringInputDialogBuilder(Context pContext, int pTitleResID, int pMessageResID, int pErrorResID, int pIconResID, String pDefaultText, Callback<String> pSuccessCallback, OnCancelListener pOnCancelListener) {
        super(pContext, pTitleResID, pMessageResID, pErrorResID, pIconResID, pDefaultText, pSuccessCallback, pOnCancelListener);
    }

    protected String generateResult(String pInput) {
        return pInput;
    }
}
