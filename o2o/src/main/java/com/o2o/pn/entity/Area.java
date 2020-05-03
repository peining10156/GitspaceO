package com.o2o.pn.entity;

import java.util.Date;

public class Area{
        //id
    private Integer areaId;
        //名称
    private String areaName;
        //权重
    private Integer priority;
    //创建时间
    private Date createTime;
    //更新时间
    private Date lastEditTime;

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public Integer getAreId() {
        return areaId;
    }

    public Integer getPriorty() {
        return priority;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setAreId(Integer areId) {
        this.areaId = areId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public void setPriorty(Integer priorty) {
        this.priority = priorty;
    }

}
