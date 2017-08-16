package com.dao.cm.quartz;


import com.entity.cm.quartz.JobAndTrigger;

import java.util.List;

public interface JobAndTriggerDao {
    List<JobAndTrigger> getJobAndTriggerDetails();
}
