package com.sun.demo.home;

import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.sun.demo.R;
import com.sun.demo.base.BaseActivity;
import com.sun.demo.view.CustomTextView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sun on 18/6/20.
 */

public class StocksActivity extends BaseActivity {
    @BindView(R.id.center_title)
    TextView mCenterTitle;
    @BindView(R.id.ctv_tab1)
    CustomTextView mTab1;
    @BindView(R.id.ctv_tab2)
    CustomTextView mTab2;

    private StocksFragment1 mFragment1;
    private StocksFragment1 mFragment2;


    @Override
    public void setContent() {
        setContentView(R.layout.activity_stocks);
    }

    @Override
    public void setModel() {
        mContext = this;

    }

    @Override
    public void setUpView() {
        mCenterTitle.setText("StocksActivity");
        if (mFragment1 == null) {
            mFragment1 = new StocksFragment1();
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_frame, mFragment1);
        fragmentTransaction.commit();
        mTab1.setSelected();
    }


    @OnClick(R.id.ctv_tab1)
    public void tab1() {
        if (mFragment1 == null) {
            mFragment1 = new StocksFragment1();
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_frame, mFragment1);
        mTab1.setSelected();
        mTab2.setUnselected();
        fragmentTransaction.commit();
    }

    @OnClick(R.id.ctv_tab2)
    public void tab2() {
        if (mFragment2 == null) {
            mFragment2 = new StocksFragment1();
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_frame, mFragment2);
        mTab1.setUnselected();
        mTab2.setSelected();
        fragmentTransaction.commit();
    }


}
