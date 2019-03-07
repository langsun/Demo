package com.sun.demo.network.progress;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

import com.sun.demo.network.view.LoadingDialog;


/**
 * Created by sun on 18/1/22.
 */

public class ProgressDialogHandler extends Handler {
    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;
    private ProgressDialog pd;
    private Dialog dialog;
    private Context context;
    private boolean cancelable;
    private ProgressCancelListener mProgressCancelListener;
    private String message;
    private boolean isShow;

    /**
     *
     * @param context
     * @param mProgressCancelListener
     * @param cancelable
     * @param dialogMessage
     * @param isShow
     */
    public ProgressDialogHandler(Context context, ProgressCancelListener mProgressCancelListener,
                                 boolean cancelable, String dialogMessage, boolean isShow) {
        super();
        this.context = context;
        this.mProgressCancelListener = mProgressCancelListener;
        this.cancelable = cancelable;
        this.message = dialogMessage;
        this.isShow = isShow;
    }

    private void initProgressDialog() {
        if (pd == null) {
            pd = new ProgressDialog(context);

            pd.setCancelable(cancelable);

            if (cancelable) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        mProgressCancelListener.onCancelProgress();
                    }
                });
            }

            if (!pd.isShowing()) {
                pd.show();
            }
        }
    }

    private void dismissProgressDialog() {
        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
//                initProgressDialog();
                if (isShow) {
                    dialog = LoadingDialog.showDialog(context, true, message);
                    dialog.setCanceledOnTouchOutside(false);//设置点击屏幕加载框不会取消（返回键可以取消）
                    dialog.show();
                }

                break;
            case DISMISS_PROGRESS_DIALOG:
                if (dialog != null) {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                }
//                dismissProgressDialog();
                break;
        }
    }
}
