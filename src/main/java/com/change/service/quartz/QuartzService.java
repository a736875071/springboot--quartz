package com.change.service.quartz;

import com.change.entity.quartz.JobAndTrigger;

import java.text.ParseException;
import java.util.List;

/**
 * @author YangQing
 * @version 1.0.0
 */

public interface QuartzService {

    /**
     * 定时任务详情
     *
     * @return
     */
    List<JobAndTrigger> getJobAndTriggerDetails();

    /**
     * 添加一条定时任务
     * （数据库存储）
     *
     * @param jobAndTrigger
     * @throws ParseException
     */
    void postQuartzByJobAndTrigger(JobAndTrigger jobAndTrigger) throws Exception;

    /**
     * 删除一条定时任务
     * （数据库存储）
     *
     * @param jobAndTrigger
     * @throws ParseException
     */
    void deleQuartzByJobAndTrigger(JobAndTrigger jobAndTrigger);

    /**
     * 暂停一条定时任务
     * （数据库存储）
     *
     * @param jobAndTrigger
     * @throws ParseException
     */
    void pauseQuartzByJobAndTrigger(JobAndTrigger jobAndTrigger);

    /**
     * 恢复一条定时任务
     * （数据库存储）
     *
     * @param jobAndTrigger
     * @throws ParseException
     */
    void resumeQuartzByJobAndTrigger(JobAndTrigger jobAndTrigger);
}
