package com.domain.cm.quartz;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 自动扣费参数配置表查询条件
 *
 * @author YangQing
 * @version 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutoDeductionCondition {

    //主键
    private Long id;

    //组织机构
    private Long orgId;

    //启用状态
    private String taskStatus;

    //任务名称
    private String schedName;

    //触发器名称
    private String triggerName;

    //触发器分组
    private String triggerGroup;

    private Integer page;

    private Integer rows;

    public Integer getOffset() {
        return page != null && rows != null && page > 0 && rows > 0 ? (page - 1) * rows : null;
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
