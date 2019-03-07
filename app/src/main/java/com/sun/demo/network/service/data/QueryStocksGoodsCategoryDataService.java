package com.sun.demo.network.service.data;


import com.sun.demo.network.NetworkConstants;
import com.sun.demo.network.NetworkResult;
import com.sun.demo.network.service.data.bean.HomeDataBean;

import java.util.List;
import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by sun on 18/7/26.
 */

public interface QueryStocksGoodsCategoryDataService {
    @FormUrlEncoded
    @POST(NetworkConstants.SERVICE_QUERY_STOCKS_GOODS_CATEGORY_DATA)
    Observable<NetworkResult<List<HomeDataBean>>> query(@FieldMap Map<String, Object> map);
}

