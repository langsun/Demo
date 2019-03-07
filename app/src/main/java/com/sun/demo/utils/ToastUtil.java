package com.sun.demo.utils;

import android.widget.Toast;

import com.sun.demo.base.MyApplication;


/**
 * Created by sun on 18/6/14.
 */

public class ToastUtil {
    public static void showToast(String str) {
        Toast.makeText(MyApplication.mContext, str, Toast.LENGTH_LONG).show();
    }

    public static void showToast(int res) {
        Toast.makeText(MyApplication.mContext, res, Toast.LENGTH_LONG).show();
    }
}
