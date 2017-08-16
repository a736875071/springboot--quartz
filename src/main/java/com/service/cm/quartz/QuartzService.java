package com.service.cm.quartz;

import com.entity.cm.quartz.JobAndTrigger;

import java.util.List;

/**
 * @author YangQing
 * @version 1.0.0
 */

public interface QuartzService {

    List<JobAndTrigger> getJobAndTriggerDetails();
}
