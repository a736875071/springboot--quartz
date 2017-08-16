package com.service.cm.quartz;

import com.dao.cm.quartz.JobAndTriggerDao;
import com.entity.cm.quartz.JobAndTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangQing
 * @version 1.0.0
 */
@Service
public class QuartzServiceImpl implements QuartzService {
    @Autowired
    private JobAndTriggerDao jobAndTriggerDao;
    @Override
    public List<JobAndTrigger> getJobAndTriggerDetails() {
        return jobAndTriggerDao.getJobAndTriggerDetails();
    }
}
