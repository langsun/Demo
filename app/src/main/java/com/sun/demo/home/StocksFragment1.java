package com.sun.demo.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.sun.demo.R;
import com.sun.demo.base.BaseFragment;
import com.sun.demo.home.adapter.StocksFragmentAdapter;
import com.sun.demo.home.bean.StocksCategoryBean;
import com.sun.demo.intf.ItemClickListener;
import com.sun.demo.network.NetworkManager;
import com.sun.demo.network.NetworkResult;
import com.sun.demo.network.service.RetrofitRequestBodyUtil;
import com.sun.demo.network.subscribers.ProgressSubscriber;
import com.sun.demo.network.subscribers.SubscriberOnErrorListener;
import com.sun.demo.network.subscribers.SubscriberOnNextListener;
import com.sun.demo.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;

/**
 * Created by sun on 18/9/27.
 */

public class StocksFragment1 extends BaseFragment {


    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.fl_frame)
    FrameLayout mFrameLayout;


    private StocksFragmentAdapter mAdapter;
    private List<StocksCategoryBean> mList;
    private StocksActivity mActivity;


    @Override
    protected int setContentView() {
        return R.layout.fragment_stocks;
    }

    @Override
    public void setModel() {

    }

    @Override
    public void setUpView() {
        mActivity = (StocksActivity) getActivity();
        getData();

    }


    private void getData() {
        NetworkManager.getInstance().queryStocksGoodsCategoryDataService(new ProgressSubscriber<List<StocksCategoryBean>>(mActivity, new SubscriberOnNextListener<NetworkResult<List<StocksCategoryBean>>>() {
            @Override
            public void onNext(NetworkResult<List<StocksCategoryBean>> networkResult) {

                mList = networkResult.getValue();

                if (mList == null || mAdapter == null) {
                    setRecycleView();
                }
            }
        }, new SubscriberOnErrorListener() {
            @Override
            public void OnError(Throwable e) {

                ToastUtil.showToast(e.getMessage());
            }
        }, true, "正在加载..."), RetrofitRequestBodyUtil.getInstance().emptyRequestBody());
    }

    private void setRecycleView() {


        mAdapter = new StocksFragmentAdapter(mActivity, mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void click(View v, int pos) {
                StocksCategoryBean bean = mList.get(pos);
                switch (bean.name) {
                    case "SJB":
//                        UIManager.getInstance().showWorldCupDetailActivity(mActivity);
                        break;
                }
            }
        });
    }
}
