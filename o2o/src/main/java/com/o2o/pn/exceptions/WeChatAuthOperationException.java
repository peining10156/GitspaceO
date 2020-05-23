package com.o2o.pn.exceptions;

public class WeChatAuthOperationException extends RuntimeException{
    private static final long serialVersionUID = -6001064729696925789L;

    public WeChatAuthOperationException(String msg){
        super(msg);

    }
}
