package com.entity.cm.quartz;

import java.util.Date;

/**
 * 自动扣费记录表
 *
 * @author YangQing
 * @version 1.0.0
 */
public class AutoDeductionRecord {
    private Long id;

    //扣费id
    private Long deduId;

    //执行状态
    private String executeStatus;

    //执行时间
    private Date executeTime;

    //扣费周期
    private String deduCycle;

    //组织机构ID
    private Long orgId;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeduId() {
        return deduId;
    }

    public void setDeduId(Long deduId) {
        this.deduId = deduId;
    }

    public String getExecuteStatus() {
        return executeStatus;
    }

    public void setExecuteStatus(String executeStatus) {
        this.executeStatus = executeStatus == null ? null : executeStatus.trim();
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public String getDeduCycle() {
        return deduCycle;
    }

    public void setDeduCycle(String deduCycle) {
        this.deduCycle = deduCycle == null ? null : deduCycle.trim();
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}