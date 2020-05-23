package com.o2o.pn.exceptions;

public class LocalAuthOperationException extends RuntimeException {
    private static final long serialVersionUID = -7088653888651341643L;

    public LocalAuthOperationException(String msg){
        super(msg);
    }
}
