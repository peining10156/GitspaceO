package com.o2o.pn.util;

public class PageCalculator {

        /*
        * 前台传过来的的分页数，转化成数据库需要的行数
        * */
    public static int calculateRowIndex(int pageIndex,int pageSize){
        return (pageIndex>0)?(pageIndex -1)*pageSize:0;
    }
}
