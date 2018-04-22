package org.anddev.andengine.ui.dialog;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import org.acra.ACRAConstants;
import org.anddev.andengine.util.Callback;
import org.anddev.andengine.util.Debug;

public abstract class GenericInputDialogBuilder<T> {
    protected final Context mContext;
    private final String mDefaultText;
    private final int mErrorResID;
    protected final int mIconResID;
    protected final int mMessageResID;
    protected final OnCancelListener mOnCancelListener;
    protected final Callback<T> mSuccessCallback;
    protected final int mTitleResID;

    class C05972 implements OnClickListener {
        C05972() {
        }

        public void onClick(DialogInterface pDialog, int pWhich) {
            GenericInputDialogBuilder.this.mOnCancelListener.onCancel(pDialog);
            pDialog.dismiss();
        }
    }

    protected abstract T generateResult(String str);

    public GenericInputDialogBuilder(Context pContext, int pTitleResID, int pMessageResID, int pErrorResID, int pIconResID, Callback<T> pSuccessCallback, OnCancelListener pOnCancelListener) {
        this(pContext, pTitleResID, pMessageResID, pErrorResID, pIconResID, "", pSuccessCallback, pOnCancelListener);
    }

    public GenericInputDialogBuilder(Context pContext, int pTitleResID, int pMessageResID, int pErrorResID, int pIconResID, String pDefaultText, Callback<T> pSuccessCallback, OnCancelListener pOnCancelListener) {
        this.mContext = pContext;
        this.mTitleResID = pTitleResID;
        this.mMessageResID = pMessageResID;
        this.mErrorResID = pErrorResID;
        this.mIconResID = pIconResID;
        this.mDefaultText = pDefaultText;
        this.mSuccessCallback = pSuccessCallback;
        this.mOnCancelListener = pOnCancelListener;
    }

    public Dialog create() {
        final EditText etInput = new EditText(this.mContext);
        etInput.setText(this.mDefaultText);
        Builder ab = new Builder(this.mContext);
        if (this.mTitleResID != 0) {
            ab.setTitle(this.mTitleResID);
        }
        if (this.mMessageResID != 0) {
            ab.setMessage(this.mMessageResID);
        }
        if (this.mIconResID != 0) {
            ab.setIcon(this.mIconResID);
        }
        setView(ab, etInput);
        ab.setOnCancelListener(this.mOnCancelListener).setPositiveButton(ACRAConstants.DEFAULT_DIALOG_POSITIVE_BUTTON_TEXT, new OnClickListener() {
            public void onClick(DialogInterface pDialog, int pWhich) {
                try {
                    GenericInputDialogBuilder.this.mSuccessCallback.onCallback(GenericInputDialogBuilder.this.generateResult(etInput.getText().toString()));
                    pDialog.dismiss();
                } catch (IllegalArgumentException e) {
                    Debug.m62e("Error in GenericInputDialogBuilder.generateResult()", e);
                    Toast.makeText(GenericInputDialogBuilder.this.mContext, GenericInputDialogBuilder.this.mErrorResID, 0).show();
                }
            }
        }).setNegativeButton(ACRAConstants.DEFAULT_DIALOG_NEGATIVE_BUTTON_TEXT, new C05972());
        return ab.create();
    }

    protected void setView(Builder pBuilder, EditText pInputEditText) {
        pBuilder.setView(pInputEditText);
    }
}
