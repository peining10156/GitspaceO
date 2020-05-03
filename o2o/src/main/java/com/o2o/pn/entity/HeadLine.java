package com.o2o.pn.entity;

import java.util.Date;

public class HeadLine{

    private Long lineId;
    private String lineName;
    private String lineLnk;
    private String lineimg;
    private Integer priority;
    //0不可用；1可用
    private Integer enableStatus;

    private Date createTime;
    private Date lastEditTime;

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLineLnk() {
        return lineLnk;
    }

    public void setLineLnk(String lineLnk) {
        this.lineLnk = lineLnk;
    }

    public String getLineimg() {
        return lineimg;
    }

    public void setLineimg(String lineimg) {
        this.lineimg = lineimg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}