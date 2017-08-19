package com.change.service.cm.quartz.job;

/**
 * @author YangQing
 * @version 1.0.0
 */

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob implements BaseJob {

    private static Logger logger = LoggerFactory.getLogger(HelloJob.class);

    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        System.out.println("定时任务:" + jobDetail.getKey().getName() + "," + jobDetail.getJobClass().getName() + "执行时间: " + dateFormat().format(new Date()));
        logger.debug("定时任务:" + jobDetail.getKey().getName() + "调用批量扣费" + dateFormat().format(new Date()));

    }
}
