package com.baizhi.common.entity;

/**
 * Created by Administrator on 2017/11/28.
 */
public class Result {
    public boolean success;
    public String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result(boolean success, String msg) {

        this.success = success;
        this.msg = msg;
    }

    public Result() {

    }
}
