package com.sun.demo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.sun.demo.R;
import com.sun.demo.intf.ClickListener;

/**
 * Created by sun on 18/6/26.
 * <p>
 * 注意：如果默认颜色：textColorNormal不是color_333333，textColorSelected不是color_ffffff，那在xml布局中就一定要设置默认颜色
 * 注意：如果bg默认颜色：bgNormal,bgSelected默认背景transparent_shape
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {
    private boolean mIsSelected = false;
    private CustomTextView mCustomTextView;
    private ClickListener mClickListener;
    private ClickListener1 mClickListener1;
    private int bgNormal;
    private int bgSelected;
    private int textColorNormal;
    private int textColorSelected;

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mCustomTextView = this;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        bgNormal = typedArray.getResourceId(R.styleable.CustomTextView_bg_normal, R.drawable.transparent_shape);
        bgSelected = typedArray.getResourceId(R.styleable.CustomTextView_bg_selected, R.drawable.transparent_shape);
        textColorNormal = typedArray.getResourceId(R.styleable.CustomTextView_text_color_normal, R.color.color_333333);
        textColorSelected = typedArray.getResourceId(R.styleable.CustomTextView_text_color_selected, R.color.color_ffffff);
        mCustomTextView.setBackground(getResources().getDrawable(bgNormal));
        mCustomTextView.setTextColor(getResources().getColor(textColorNormal));
        mCustomTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mIsSelected) {
                    mCustomTextView.setBackground(getResources().getDrawable(bgSelected));
                    mCustomTextView.setTextColor(getResources().getColor(textColorSelected));
                } else {
                    mCustomTextView.setBackground(getResources().getDrawable(bgNormal));
                    mCustomTextView.setTextColor(getResources().getColor(textColorNormal));
                }
                mIsSelected = !mIsSelected;
                if (mClickListener != null)
                    mClickListener.click();
                if (mClickListener1 != null)
                    mClickListener1.click(Integer.parseInt(mCustomTextView.getText().toString().trim()));

            }
        });
    }

    public void setClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    public void setClickListener1(ClickListener1 clickListener1) {
        mClickListener1 = clickListener1;
    }

    public void setSelected() {
        mCustomTextView.setBackground(getResources().getDrawable(bgSelected));
        mCustomTextView.setTextColor(getResources().getColor(textColorSelected));
        mIsSelected = true;
    }

    public void setUnselected() {
        mCustomTextView.setBackground(getResources().getDrawable(bgNormal));
        mCustomTextView.setTextColor(getResources().getColor(textColorNormal));
        mIsSelected = false;
    }

    public boolean getIsSelected() {
        return mIsSelected;
    }

    public interface ClickListener1 {
        void click(int viewNum);
    }
}
