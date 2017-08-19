package com.change.dao.quartz;


import com.change.entity.quartz.JobAndTrigger;

import java.util.List;

public interface JobAndTriggerDao {

    List<JobAndTrigger> getJobAndTriggerDetails();
}
