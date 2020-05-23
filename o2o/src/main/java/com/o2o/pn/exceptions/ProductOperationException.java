package com.o2o.pn.exceptions;

public class ProductOperationException extends RuntimeException {


    private static final long serialVersionUID = 3239721020501799616L;

    public ProductOperationException(String msg){
        super(msg);
    }

}
