package com.sun.demo.view.shswiperefresh;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.sun.demo.R;
import com.sun.demo.base.MyApplication;
import com.sun.demo.utils.Constants;
import com.sun.demo.utils.DateUtil;
import com.sun.demo.utils.SPUtils;
import com.sun.demo.view.shswiperefresh.core.SHSwipeRefreshLayout;


/**
 * Created by sun on 18/8/11.
 */

public class RefreshAndLoadMoreManager {
    private static RefreshAndLoadMoreManager instance;

    public static RefreshAndLoadMoreManager getInstance() {
        if (instance == null) {
            synchronized (RefreshAndLoadMoreManager.class) {
                if (instance == null) {
                    instance = new RefreshAndLoadMoreManager();
                }
            }
        }
        return instance;
    }

    private RefreshAndLoadMoreManager() {
    }

    public void setSwipeRefreshLayout(final SHSwipeRefreshLayout mSHSwipeRefreshLayout, final RefreshAndLoadMoreListener listener) {
        /**
         * 这里Sample中的headerview使用默认设置，即可通过setRefreshViewText（String）来更改headerview中TextView的文字；
         * 而footview
         */

        //加载更多
        final View viewLoadMore = LayoutInflater.from(MyApplication.mContext).inflate(R.layout.view_load_more, null);
        final TextView loadMore = viewLoadMore.findViewById(R.id.load_more);
        final TextView loadMoreLeastTime = viewLoadMore.findViewById(R.id.load_more_least_time);
        mSHSwipeRefreshLayout.setFooterView(viewLoadMore);
        //下拉刷新
        View view = LayoutInflater.from(MyApplication.mContext).inflate(R.layout.view_refresh_header, null);
        mSHSwipeRefreshLayout.setHeaderView(view);
        final TextView refresh = view.findViewById(R.id.refresh);
        final TextView refreshLeastTime = view.findViewById(R.id.refresh_least_time);

        mSHSwipeRefreshLayout.setOnRefreshListener(new SHSwipeRefreshLayout.SHSOnRefreshListener() {
            @Override
            public void onRefresh() {
                listener.onRefresh();
            }

            @Override
            public void onLoading() {
                listener.onLoadMore();
            }

            /**
             * 监听下拉刷新过程中的状态改变
             * @param percent 当前下拉距离的百分比（0-1）
             * @param state 分三种状态{NOT_OVER_TRIGGER_POINT：还未到触发下拉刷新的距离；OVER_TRIGGER_POINT：已经到触发下拉刷新的距离；START：正在下拉刷新}
             */
            @Override
            public void onRefreshPulStateChange(float percent, int state) {
                switch (state) {
                    case SHSwipeRefreshLayout.NOT_OVER_TRIGGER_POINT:
                        refresh.setText("下拉可以刷新");
//                        mSwipeRefreshLayout.setRefreshViewText("下拉可以刷新");
                        break;
                    case SHSwipeRefreshLayout.OVER_TRIGGER_POINT:
                        refresh.setText("松开立即刷新");
                        refreshLeastTime.setText("最后刷新：" + SPUtils.getString(Constants.HOME_FRAGMENT_REFRESH_TIME, DateUtil.getDateAndTime(DateUtil.STYLE9)));
//                        mSwipeRefreshLayout.setRefreshViewText("松开立即刷新");
                        break;
                    case SHSwipeRefreshLayout.START:
                        refresh.setText("正在刷新数据中...");
//                        mSwipeRefreshLayout.setRefreshViewText("正在刷新数据中...");
                        break;
                }
            }

            @Override
            public void onLoadmorePullStateChange(float percent, int state) {
                switch (state) {
                    case SHSwipeRefreshLayout.NOT_OVER_TRIGGER_POINT:
                        loadMore.setText("上拉可以加载");
                        break;
                    case SHSwipeRefreshLayout.OVER_TRIGGER_POINT:
                        loadMore.setText("松开立即加载");
                        loadMoreLeastTime.setText("最后刷新：" + SPUtils.getString(Constants.HOME_FRAGMENT_REFRESH_TIME, DateUtil.getDateAndTime(DateUtil.STYLE9)));
                        break;
                    case SHSwipeRefreshLayout.START:
                        loadMore.setText("正在加载数据...");
                        break;
                }
            }
        });
    }

    public void setRefreshResult(SHSwipeRefreshLayout mSHSwipeRefreshLayout, boolean isSuccess) {
        mSHSwipeRefreshLayout.finishRefresh();
        if (isSuccess) {
            String dateAndTime = DateUtil.getDateAndTime(DateUtil.STYLE9);
            SPUtils.setString(Constants.HOME_FRAGMENT_REFRESH_TIME, dateAndTime);
//            ToastUtil.showToast("刷新数据成功");
        }
//        else {
//            ToastUtil.showToast("刷新数据失败");
//        }

    }

    public void setCanLoadMore(SHSwipeRefreshLayout mSHSwipeRefreshLayout, boolean canLoadMore) {
        if(!canLoadMore)
            mSHSwipeRefreshLayout.setLoadmoreEnable(false);
    }

    public void setLoadMoreResult(SHSwipeRefreshLayout mSHSwipeRefreshLayout) {
        mSHSwipeRefreshLayout.finishLoadmore();
    }

    public interface RefreshAndLoadMoreListener {
        void onRefresh();

        void onLoadMore();
    }

}
