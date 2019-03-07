package com.sun.demo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


import com.sun.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sun on 18/6/14.
 * 解决底部虚拟按键
 * https://blog.csdn.net/c15522627353/article/details/52452490
 */

public abstract class BaseActivity extends AppCompatActivity implements ActivityPageSetting {
    protected Context mContext;

    @Nullable
    @BindView(R.id.left_icon)
    ImageView mLeftIcon;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContent();
        ButterKnife.bind(this);
        setModel();
        setUpView();
    }

    @Nullable
    @OnClick(R.id.left_icon)
    public void back() {
        onBackPressed();
    }



}
