package com.sun.demo.network;

/**
 * Created by sun on 18/1/22.
 */

public class ApiException extends RuntimeException {

    public ApiException(int resultCode, String msg) {
        this(getApiExceptionMessage(resultCode, msg));
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     *
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(int code, String msg) {
//        String message = "";
//        switch (code) {
//            case NetworkConstants.FAILURE_CODE:
//                message = msg;
//                break;
//            case NetworkConstants.FAILURE_CODE_202:
//                message = msg;
//                break;
//            default:
//                message = "未知错误";
//        }
//        return message;
        return msg;
    }
}
