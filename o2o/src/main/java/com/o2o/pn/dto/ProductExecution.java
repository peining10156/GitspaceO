package com.o2o.pn.dto;

import com.o2o.pn.entity.Product;
import com.o2o.pn.enums.ProductStateEnum;

import java.util.List;

public class ProductExecution {


    private int state;
    private String stateInfo;
    private int count;
    //操作的product （增删改的时候用）
    private Product product;
    //获取的product列表查询商品的列表时候用
    private List<Product>productList;

    public void setCount(int count) {
        this.count = count;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public ProductExecution(){

    }
    //失败的构造器
    public ProductExecution(ProductStateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();


    }
    //成功的构造器
    public ProductExecution(ProductStateEnum stateEnum,Product product){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.product = product;
    }
    //成功的构造器
    public ProductExecution(ProductStateEnum stateEnum,List<Product>products){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.productList = productList;



    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public int getCount() {
        return count;
    }

    public Product getProduct() {
        return product;
    }

    public List<Product> getProductList() {
        return productList;
    }



}
