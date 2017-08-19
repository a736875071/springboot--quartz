package com.change.service.cm.quartz;

import com.change.dao.quartz.JobAndTriggerDao;
import com.change.entity.quartz.JobAndTrigger;
import com.change.service.cm.quartz.job.BaseJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * @author YangQing
 * @version 1.0.0
 */
@Service
public class QuartzServiceImpl implements QuartzService {
    @Autowired
    private JobAndTriggerDao jobAndTriggerDao;

    /**
     * 定时任务详情
     *
     * @return
     */
    @Override
    public List<JobAndTrigger> getJobAndTriggerDetails() {
        return jobAndTriggerDao.getJobAndTriggerDetails();
    }

    /**
     * 添加一条定时任务
     * （数据库存储）
     *
     * @param jobAndTrigger
     * @throws ParseException
     */
    @Override
    public void postQuartzByJobAndTrigger(JobAndTrigger jobAndTrigger) throws Exception {
        try {
            // 1、创建一个JobDetail实例，指定Quartz
            JobDetail jobDetail = JobBuilder.newJob(getClass(jobAndTrigger.getJob_CLASS_NAME()).getClass())
                    // 任务执行类
                    .withIdentity(jobAndTrigger.getJob_NAME(), jobAndTrigger.getJob_GROUP())
                    // 任务名，任务组
                    .build();
            String cron = jobAndTrigger.getCron_EXPRESSION();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(jobAndTrigger.getTrigger_NAME(), jobAndTrigger.getTrigger_GROUP()).startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron)
                    ).build();
            // 3、创建Scheduler\
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            scheduler.start();
            // 4、调度执行
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一条定时任务
     * （数据库存储）
     *
     * @param jobAndTrigger
     * @throws ParseException
     */
    @Override
    public void deleQuartzByJobAndTrigger(JobAndTrigger jobAndTrigger) {
        try {
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            JobKey jobKey = new JobKey(jobAndTrigger.getJob_NAME(), jobAndTrigger.getJob_GROUP());
            TriggerKey triggerKey = TriggerKey.triggerKey(jobAndTrigger.getTrigger_NAME(), jobAndTrigger.getTrigger_GROUP());
            scheduler.pauseTrigger(triggerKey);// 停止触发器
            scheduler.unscheduleJob(triggerKey);// 移除触发器
            scheduler.deleteJob(jobKey);// 删除任务
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 暂停一条定时任务
     * （数据库存储）
     *
     * @param jobAndTrigger
     * @throws ParseException
     */
    @Override
    public void pauseQuartzByJobAndTrigger(JobAndTrigger jobAndTrigger) {
        try {
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            JobKey jobKey = new JobKey(jobAndTrigger.getJob_NAME(), jobAndTrigger.getJob_GROUP());
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复一条定时任务
     * （数据库存储）
     *
     * @param jobAndTrigger
     * @throws ParseException
     */
    @Override
    public void resumeQuartzByJobAndTrigger(JobAndTrigger jobAndTrigger) {
        try {
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            JobKey jobKey = new JobKey(jobAndTrigger.getJob_NAME(), jobAndTrigger.getJob_GROUP());
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    private static BaseJob getClass(String classname) throws Exception {
        String classPath = "com.change.service.cm.quartz.job.";
        Class<?> class1 = Class.forName(classPath + classname);
        return (BaseJob) class1.newInstance();
    }
}
