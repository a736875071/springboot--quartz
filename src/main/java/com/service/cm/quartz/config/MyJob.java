package com.service.cm.quartz.config;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        System.out.println("===================================");
        System.out.println("Hello quzrtz  " + jobDetail.getKey().getName() + "时间:" +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));
        System.out.println("===========================================");

    }

}
