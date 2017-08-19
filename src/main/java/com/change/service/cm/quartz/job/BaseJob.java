package com.change.service.cm.quartz.job;

/**
 * @author YangQing
 * @version 1.0.0
 */


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public interface BaseJob extends Job{
    public void execute(JobExecutionContext context) throws JobExecutionException;
}

