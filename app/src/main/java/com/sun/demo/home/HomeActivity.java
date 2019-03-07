package com.sun.demo.home;

import android.view.View;

import com.sun.demo.R;
import com.sun.demo.base.BaseActivity;
import com.sun.demo.manager.UIManager;

import butterknife.OnClick;

public class HomeActivity extends BaseActivity {


    @Override
    public void setContent() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setModel() {

    }

    @Override
    public void setUpView() {
//测试masterNew分支
    }

    @OnClick({R.id.tv_1, R.id.tv_2, R.id.tv_3, R.id.tv_4})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                UIManager.getInstance().showStocksBriefActivity(this);
                break;
            case R.id.tv_2:
                UIManager.getInstance().showStocksActivity(this);
                break;
            case R.id.tv_3:
                break;
            case R.id.tv_4:
                break;
        }
    }
}
