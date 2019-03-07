package com.sun.demo.base;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by sun on 18/6/14.
 */

public abstract class BaseFragment extends Fragment {
    private View mView;
    private Unbinder mUnbinder;
    protected boolean isVisible = false;  //当前Fragment是否可见
    protected boolean isPrepare = false;  //当前Fragment的视图是否已经创建
    protected boolean isLoaded = false;  //当前Fragment是否已经调用过setModel加载数据
    protected boolean visibleToUser = false;  //真正意义上的可见

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(setContentView(), container, false);
            mUnbinder = ButterKnife.bind(this, mView);

            isPrepare = true;
            load();
            setUpView();
        }

        ViewGroup viewGroup = (ViewGroup) mView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(mView);
        }

        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            onVisibilityChangedToUser(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()) {
            onVisibilityChangedToUser(false);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            load();
        } else {
            isVisible = false;
        }
        if (isResumed()) {
            onVisibilityChangedToUser(isVisibleToUser);
        }
    }

    private void load() {
        if (isVisible && isPrepare && !isLoaded) {
            setModel();
        }
    }

    /**
     * 当Fragment对用户的可见性发生了改变的时候就会回调此方法，回调可能发生在setUserVisibleHintMethod方法里，或者发生在onResume或onPause方法里
     *
     * @param isVisibleToUser true：用户能看见当前Fragment；false：用户看不见当前Fragment
     */
    public void onVisibilityChangedToUser(boolean isVisibleToUser) {
        visibleToUser = isVisibleToUser;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        mUnbinder.unbind();
    }

    protected abstract int setContentView();

    protected abstract void setModel();

    protected abstract void setUpView();
}
