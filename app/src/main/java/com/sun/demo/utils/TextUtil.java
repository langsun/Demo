package com.sun.demo.utils;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * Created by sun on 18/10/15.
 */

public class TextUtil {
    public static void setForegroundColor(Context context, TextView textView, String str, int startIndex, int endIndex, int colorRes) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }

    public static void setForegroundColor(Context context, TextView textView, String str, int startIndex, int endIndex, int startIndex1, int endIndex1, int startIndex2, int endIndex2, int colorRes) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex1, endIndex1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex2, endIndex2, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }

    public static void setForegroundColor(Context context, TextView textView, String str, int startIndex, int endIndex, int startIndex1, int endIndex1, int startIndex2, int endIndex2, int startIndex3, int endIndex3, int startIndex4, int endIndex4, int startIndex5, int endIndex5, int colorRes) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex1, endIndex1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex2, endIndex2, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex3, endIndex3, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex4, endIndex4, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex5, endIndex5, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }
    public static void setForegroundColor(Context context, TextView textView, String str, int startIndex, int endIndex, int startIndex1, int endIndex1, int startIndex2, int endIndex2, int startIndex3, int endIndex3, int startIndex4, int endIndex4, int startIndex5, int endIndex5, int startIndex6, int endIndex6, int startIndex7, int endIndex7, int startIndex8, int endIndex8, int colorRes) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex1, endIndex1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex2, endIndex2, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex3, endIndex3, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex4, endIndex4, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex5, endIndex5, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex6, endIndex6, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex7, endIndex7, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex8, endIndex8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }
}
