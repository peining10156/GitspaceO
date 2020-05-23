package com.o2o.pn.exceptions;

public class ProductCategoryOperationException extends RuntimeException{

    private static final long serialVersionUID = 11724206029112163L;

    public ProductCategoryOperationException(String msg){
        super(msg);
    }
}
