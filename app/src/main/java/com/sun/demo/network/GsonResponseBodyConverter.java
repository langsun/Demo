package com.sun.demo.network;


import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by sun on 18/1/22.
 */

public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    public GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        Log.e("-------demo", response);
        NetworkResult networkResult = gson.fromJson(response, NetworkResult.class);
        switch (networkResult.getCode()) {
            case NetworkConstants.FAILURE_CODE:
                throw new ApiException(NetworkConstants.FAILURE_CODE, networkResult.getMessage());
            case NetworkConstants.FAILURE_CODE_202:
                throw new ApiException(NetworkConstants.FAILURE_CODE_202, networkResult.getMessage());
        }
        return gson.fromJson(response, type);
    }
}
