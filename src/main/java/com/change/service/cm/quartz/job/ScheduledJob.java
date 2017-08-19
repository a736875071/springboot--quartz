package com.change.service.cm.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务job
 *
 * @author YangQing
 * @version 1.0.0
 */

public class ScheduledJob implements BaseJob {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey jobKey = context.getJobDetail().getKey();
        System.out.println("定时任务:" + jobKey.getName()+ ","+context.getJobDetail().getJobClass().getName()+ "执行时间: " + dateFormat().format(new Date()));
        //日志输出级别info
        logger.debug("定时任务:" + jobKey.getName() + "调用批量扣费" + dateFormat().format(new Date()));
    }
}