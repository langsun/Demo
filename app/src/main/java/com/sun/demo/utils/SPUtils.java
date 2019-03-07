package com.sun.demo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.sun.demo.base.MyApplication;


/**
 * SharePreference封装
 *
 * @author Adminstor
 */
public class SPUtils {

    public static final String PREF_NAME = "config";

    public static boolean getBoolean(String key, boolean defaultValue) {
        SharedPreferences sp = MyApplication.mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defaultValue);
    }

    public static void setBoolean(String key, boolean value) {
        SharedPreferences sp = MyApplication.mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    public static String getString(String key, String defaultValue) {
        SharedPreferences sp = MyApplication.mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defaultValue);
    }

    public static void setString(String key, String value) {
        SharedPreferences sp = MyApplication.mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    public static int getInt(String key, int defaultValue) {
        SharedPreferences sp = MyApplication.mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defaultValue);
    }

    public static void setInt(String key, int value) {
        SharedPreferences sp = MyApplication.mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    public static long getLong(String key, long defaultValue) {
        SharedPreferences sp = MyApplication.mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.getLong(key, defaultValue);
    }

    public static void setLong(String key, long value) {
        SharedPreferences sp = MyApplication.mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        sp.edit().putLong(key, value).commit();
    }

    public static boolean keyExist(String key) {
        SharedPreferences sp = MyApplication.mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.contains(key);
    }
}
