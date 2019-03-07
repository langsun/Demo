package com.sun.demo.network.service;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by sun on 18/7/27.
 */

public class RetrofitRequestBodyUtil {
    private static RetrofitRequestBodyUtil instance;

    private RetrofitRequestBodyUtil() {

    }

    public static RetrofitRequestBodyUtil getInstance() {
        if (instance == null) {
            synchronized (RetrofitRequestBodyUtil.class) {
                if (instance == null) {
                    instance = new RetrofitRequestBodyUtil();
                }
            }
        }
        return instance;
    }

    private RequestBody getRequestBody(Map<String, String> hashMap) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), new Gson().toJson(hashMap));
    }

    private RequestBody getRequestBody1(Map<String, Object> hashMap) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), new Gson().toJson(hashMap));
    }

    private RequestBody getRequestBodyFromJSONObject(JSONObject object) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), new Gson().toJson(object));
    }

//    public RequestBody getRequestBodyObject(Object object) {
//        return RequestBody.create(MediaType.parse("multipart/form-data"), new Gson().toJson(object));
//    }

    /**
     * 验证手机号是否存在
     *
     * @param mobile
     * @return
     */
    public Map<String, Object> getChencPhoneIsExistedRequestBody(String mobile) {
        Map<String, Object> map = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("mobile", mobile);

        } catch (JSONException e) {
            e.printStackTrace();
        }
//        map.put("SourceCode", NetworkConstants.APP_CODE);
        map.put("Param", jsonObject);
        return map;
    }

    public Map<String, Object> emptyRequestBody() {
        Map<String, Object> map = new HashMap<>();
        JSONObject jsonObject = new JSONObject();

        map.put("Param", jsonObject);
        return map;
    }


}
