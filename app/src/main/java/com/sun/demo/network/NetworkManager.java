package com.sun.demo.network;

import com.sun.demo.BuildConfig;
import com.sun.demo.home.bean.StocksCategoryBean;
import com.sun.demo.network.service.data.QueryStocksGoodsCategoryDataService;
import com.sun.demo.network.subscribers.ProgressSubscriber;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sun on 18/7/26.
 */

public class NetworkManager {
    private static NetworkManager instance;
    private Retrofit mRetrofit;
    private static final int DEFAULT_TIME_OUT = 5;
    private static final int DEFAULT_READ_TIME_OUT = 30;

    public static NetworkManager getInstance() {
        if (instance == null) {
            synchronized (NetworkManager.class) {
                if (instance == null) {
                    instance = new NetworkManager();
                }
            }

        }
        return instance;
    }

    private NetworkManager() {
        //创建OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);
        //添加日志拦截
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new LoggingInterceptor());
        }

        //添加公共参数拦截器
        HttpCommonInterceptor interceptor = new HttpCommonInterceptor.Builder()
                .addHeaderParams("userId", "")
                .addHeaderParams("userToken", "")
                .build();
        builder.addInterceptor(interceptor);
        // 创建Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(ResponseConvertFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(NetworkConstants.BASE_URL)
                .build();
    }

    private <T> void toSubscribe(Observable<T> observable, Subscriber<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取仓库物品分类
     *
     * @param subscriber
     */
    public void queryStocksGoodsCategoryDataService(ProgressSubscriber<List<StocksCategoryBean>> subscriber, Map<String, Object> map) {
        QueryStocksGoodsCategoryDataService service = mRetrofit.create(QueryStocksGoodsCategoryDataService.class);
        Observable observable = service.query(map);
        toSubscribe(observable, subscriber);
    }





}
