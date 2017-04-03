package com.zx.dto;

/**
 * ajax 请求 返回的最外层对象
 * Created by 97038 on 2017-04-03.
 */
public class Result<T> {
    /*错误码*/
    private Integer code;
    /*提示信息*/
    private String msg;
    /*数据*/
    private T data;

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
