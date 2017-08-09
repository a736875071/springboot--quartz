package com.domain.cm.quartz;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author YangQing
 * @version 1.0.0
 */

public class QuartzTimedTaskDto {
    private Long id;

    //组织机构ID
    @NotNull(message = "组织机构不能为空")
    private Long orgId;

    //组织机构名称
    private String  orgName;

    //开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "开始时间不能为空")
    private Date beginTime;
    //循环扣费周期
    @NotNull(message = "循环扣费周期不能为空")
    private String deduCycle;

    //结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    //接口程序
    private String portProcedure;

    //启用状态
    private String taskStatus;

    //cron表达式
    private String cronExpression;

    //任务名称
    private String jobName;

    //任务分组
    private String jobGroup;

    //触发器名称
    private String triggerName;

    //触发器分组
    private String triggerGroup;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public String getDeduCycle() {
        return deduCycle;
    }

    public void setDeduCycle(String deduCycle) {
        this.deduCycle = deduCycle;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPortProcedure() {
        return portProcedure;
    }

    public void setPortProcedure(String portProcedure) {
        this.portProcedure = portProcedure;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
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
}
