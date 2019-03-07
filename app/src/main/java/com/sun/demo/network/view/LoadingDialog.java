package com.sun.demo.network.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sun.demo.R;


/**
 * Created by sun on 18/1/23.
 */

public class LoadingDialog {
    public static Dialog showDialog(Context context, boolean isAlpha, String message) {

        Dialog progressDialog = new Dialog(context);

        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (isAlpha) {
            WindowManager.LayoutParams lp = progressDialog.getWindow().getAttributes();
            lp.alpha = 0.8f;
            progressDialog.getWindow().setAttributes(lp);
        }
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.progress_bar, null);
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.ll_dialog);

        TextView tv = (TextView) v.findViewById(R.id.tv_loading);

        if (message == null || message.equals("")) {
            tv.setVisibility(View.GONE);
        } else {
            tv.setText(message);
            //R.color.colorAccent 我是拿的主题控件颜色，可以根据需要给
            tv.setTextColor(context.getResources().getColor(R.color.color_b2b2b2));
        }
        progressDialog.setContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        return progressDialog;


    }
}
