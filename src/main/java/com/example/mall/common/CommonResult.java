package com.example.mall.common;


public class CommonResult {
    public int code;
    public String Message;
    public Object Data;

    public void setData(Object data) {
        Data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public CommonResult() {
    }

    public CommonResult(int code,String message , Object data) {
        this.code = code;
        Message = message;

        Data = data;
    }

    public Object getData() {
        return Data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return Message;
    }
    public static CommonResult success(int code , String Message,Object data){
        return new CommonResult(code,Message,data);
    }
    public static CommonResult error(int code ,String Message,Object data){
        return new CommonResult(code,Message,data);
    }

}
