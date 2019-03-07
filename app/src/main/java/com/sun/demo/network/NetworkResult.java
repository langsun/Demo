package com.sun.demo.network;

/**
 * Created by sun on 18/7/26.
 */

public class NetworkResult<T> {


    /**
     * MsgId : null
     * Code : 201
     * Message : 服务器内部错误，请联系接口提供商
     * Value :
     * Sign : a13b109e7ab508e1b89c264dc0d92c2e
     */

    private String MsgId;
    private int Code;
    private String Message;
    private T Value;
    private String Sign;

    public NetworkResult(String msgId, int code, String message, T value, String sign) {
        MsgId = msgId;
        Code = code;
        Message = message;
        Value = value;
        Sign = sign;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String MsgId) {
        this.MsgId = MsgId;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public T getValue() {
        return Value;
    }

    public void setValue(T Value) {
        this.Value = Value;
    }

    public String getSign() {
        return Sign;
    }

    public void setSign(String Sign) {
        this.Sign = Sign;
    }
}
