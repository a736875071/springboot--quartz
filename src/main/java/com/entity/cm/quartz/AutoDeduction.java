package com.entity.cm.quartz;

import java.util.Date;

/**
 * 自动扣费参数配置表
 *
 * @author YangQing
 * @version 1.0.0
 */
public class AutoDeduction {
    private Long id;

    //组织机构ID
    private Long orgId;

    //循环扣费周期
    private String deduCycle;

    //开始时间
    private Date beginTime;

    //结束时间
    private Date endTime;

    //接口程序
    private String portProcedure;

    //启用状态
    private String taskStatus;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getDeduCycle() {
        return deduCycle;
    }

    public void setDeduCycle(String deduCycle) {
        this.deduCycle = deduCycle == null ? null : deduCycle.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPortProcedure() {
        return portProcedure;
    }

    public void setPortProcedure(String portProcedure) {
        this.portProcedure = portProcedure == null ? null : portProcedure.trim();
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus == null ? null : taskStatus.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}