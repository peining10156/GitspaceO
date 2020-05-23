package com.o2o.pn.dto;
/*
* 封装json 对象，所有返回结果都使用他
* */
public class Result<T> {
    private boolean success;//是否成功的标志
    private T data;//成功返回时候的数据
    private String errorMsg;//错误信息
    private int code;//错误码



    public Result(){

    }
    //成功时候的构造器
    public Result(boolean success,T data){
        this.success = success;
        this.data = data;
    }
    //错误时候的构造器
    public Result(boolean success,int code,String errorMsg){
        this.success = success;
        this.code = code;
        this.errorMsg = errorMsg;

    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }





}
