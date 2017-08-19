package com.dao.quartz;


import com.entity.quartz.JobAndTrigger;

import java.util.List;

public interface JobAndTriggerDao {

    List<JobAndTrigger> getJobAndTriggerDetails();
}
