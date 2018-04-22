package org.acra.dialog;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import org.acra.ACRA;
import org.acra.prefs.SharedPreferencesFactory;

public class CrashReportDialog extends BaseCrashReportDialog implements OnClickListener, OnDismissListener {
    private static final int PADDING = 10;
    private static final String STATE_COMMENT = "comment";
    private static final String STATE_EMAIL = "email";
    private AlertDialog mDialog;
    private LinearLayout scrollable;
    private SharedPreferencesFactory sharedPreferencesFactory;
    private EditText userCommentView;
    private EditText userEmailView;

    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.scrollable = new LinearLayout(this);
        this.scrollable.setOrientation(1);
        this.sharedPreferencesFactory = new SharedPreferencesFactory(getApplicationContext(), getConfig());
        buildAndShowDialog(savedInstanceState);
    }

    protected void buildAndShowDialog(@Nullable Bundle savedInstanceState) {
        Builder dialogBuilder = new Builder(this);
        int titleResourceId = getConfig().resDialogTitle();
        if (titleResourceId != 0) {
            dialogBuilder.setTitle(titleResourceId);
        }
        int iconResourceId = getConfig().resDialogIcon();
        if (iconResourceId != 0) {
            dialogBuilder.setIcon(iconResourceId);
        }
        dialogBuilder.setView(buildCustomView(savedInstanceState));
        dialogBuilder.setPositiveButton(getText(getConfig().resDialogPositiveButtonText()), this);
        dialogBuilder.setNegativeButton(getText(getConfig().resDialogNegativeButtonText()), this);
        this.mDialog = dialogBuilder.create();
        this.mDialog.setCanceledOnTouchOutside(false);
        this.mDialog.setOnDismissListener(this);
        this.mDialog.show();
    }

    @NonNull
    protected View buildCustomView(@Nullable Bundle savedInstanceState) {
        ScrollView root = new ScrollView(this);
        root.setPadding(10, 10, 10, 10);
        root.setLayoutParams(new LayoutParams(-1, -1));
        root.setFocusable(true);
        root.setFocusableInTouchMode(true);
        root.addView(this.scrollable);
        addViewToDialog(getMainView());
        View comment = getCommentLabel();
        if (comment != null) {
            comment.setPadding(comment.getPaddingLeft(), 10, comment.getPaddingRight(), comment.getPaddingBottom());
            addViewToDialog(comment);
            String savedComment = null;
            if (savedInstanceState != null) {
                savedComment = savedInstanceState.getString(STATE_COMMENT);
            }
            this.userCommentView = getCommentPrompt(savedComment);
            addViewToDialog(this.userCommentView);
        }
        View email = getEmailLabel();
        if (email != null) {
            email.setPadding(email.getPaddingLeft(), 10, email.getPaddingRight(), email.getPaddingBottom());
            addViewToDialog(email);
            String savedEmail = null;
            if (savedInstanceState != null) {
                savedEmail = savedInstanceState.getString("email");
            }
            this.userEmailView = getEmailPrompt(savedEmail);
            addViewToDialog(this.userEmailView);
        }
        return root;
    }

    protected final void addViewToDialog(@NonNull View v) {
        this.scrollable.addView(v);
    }

    @NonNull
    protected View getMainView() {
        TextView text = new TextView(this);
        int dialogTextId = getConfig().resDialogText();
        if (dialogTextId != 0) {
            text.setText(getText(dialogTextId));
        }
        return text;
    }

    @Nullable
    protected View getCommentLabel() {
        int commentPromptId = getConfig().resDialogCommentPrompt();
        if (commentPromptId == 0) {
            return null;
        }
        TextView labelView = new TextView(this);
        labelView.setText(getText(commentPromptId));
        return labelView;
    }

    @NonNull
    protected EditText getCommentPrompt(@Nullable CharSequence savedComment) {
        EditText userCommentView = new EditText(this);
        userCommentView.setLines(2);
        if (savedComment != null) {
            userCommentView.setText(savedComment);
        }
        return userCommentView;
    }

    @Nullable
    protected View getEmailLabel() {
        int emailPromptId = getConfig().resDialogEmailPrompt();
        if (emailPromptId == 0) {
            return null;
        }
        TextView labelView = new TextView(this);
        labelView.setText(getText(emailPromptId));
        return labelView;
    }

    @NonNull
    protected EditText getEmailPrompt(@Nullable CharSequence savedEmail) {
        EditText userEmailView = new EditText(this);
        userEmailView.setSingleLine();
        userEmailView.setInputType(33);
        if (savedEmail != null) {
            userEmailView.setText(savedEmail);
        } else {
            userEmailView.setText(this.sharedPreferencesFactory.create().getString(ACRA.PREF_USER_EMAIL_ADDRESS, ""));
        }
        return userEmailView;
    }

    public void onClick(DialogInterface dialog, int which) {
        if (which == -1) {
            String userEmail;
            String comment = this.userCommentView != null ? this.userCommentView.getText().toString() : "";
            SharedPreferences prefs = this.sharedPreferencesFactory.create();
            if (this.userEmailView != null) {
                userEmail = this.userEmailView.getText().toString();
                Editor prefEditor = prefs.edit();
                prefEditor.putString(ACRA.PREF_USER_EMAIL_ADDRESS, userEmail);
                prefEditor.commit();
            } else {
                userEmail = prefs.getString(ACRA.PREF_USER_EMAIL_ADDRESS, "");
            }
            sendCrash(comment, userEmail);
        } else {
            cancelReports();
        }
        finish();
    }

    public void onDismiss(DialogInterface dialog) {
        finish();
    }

    @CallSuper
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!(this.userCommentView == null || this.userCommentView.getText() == null)) {
            outState.putString(STATE_COMMENT, this.userCommentView.getText().toString());
        }
        if (this.userEmailView != null && this.userEmailView.getText() != null) {
            outState.putString("email", this.userEmailView.getText().toString());
        }
    }

    protected AlertDialog getDialog() {
        return this.mDialog;
    }
}
