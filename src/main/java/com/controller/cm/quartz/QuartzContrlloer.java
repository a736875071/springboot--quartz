package com.controller.cm.quartz;

import com.dao.cm.quartz.AutoDeductionExtDao;
import com.domain.cm.quartz.QuartzTimedTaskDto;
import com.service.cm.quartz.ScheduledJob;
import com.service.cm.quartz.config.MyJob;
import com.service.cm.quartz.config.QuartzDefaultName;
import com.service.cm.quartz.enums.QuartzEnum;
import com.utils.Response.Response;
import com.utils.ValidateUtils;
import com.utils.exception.MsgException;
import com.utils.log.EpmLogMessage;
import com.utils.log.LogMessage;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;
import java.util.UUID;


/**
 * 定时任务
 *
 * @author YangQing
 * @version 1.0.0
 */
@RestController
public class QuartzContrlloer {
    private static final Logger logger = LoggerFactory.getLogger(QuartzContrlloer.class);
    @Autowired
    private AutoDeductionExtDao autoDeductionExtDao;

    public StdSchedulerFactory myStdSchedulerFactory() {
        Properties quartzProperties = QuartzDefaultName.quartz();
        quartzProperties.setProperty("org.quartz.dataSource.quartzDataSource.URL", "jdbc:mysql://127.0.0.1:3306/quartz?characterEncoding=utf-8&useSSL=false");
        quartzProperties.setProperty("org.quartz.dataSource.quartzDataSource.user", "root");
        quartzProperties.setProperty("org.quartz.dataSource.quartzDataSource.password", "root");
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        try {
            stdSchedulerFactory.initialize(quartzProperties);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return stdSchedulerFactory;
    }

    /**
     * 添加一条定时任务记录
     * (ram存储)
     *
     * @param quartzTimedTaskDto 定时任务记录信息
     * @return 定时任务记录信息
     */
    @RequestMapping(value = "/epm/cm/quartz/postQuartz", method = RequestMethod.POST)
    public Response<?> postQuartzTimedTasks(@Valid @RequestBody QuartzTimedTaskDto quartzTimedTaskDto, BindingResult result) {
        if (result.hasErrors()) {
            return new Response().failure(ValidateUtils.getValidateErrors(result.getAllErrors()));
        }
        try {
            quartzTimedTaskDto.setJobName(quartzTimedTaskDto.getOrgId().toString());
            quartzTimedTaskDto.setJobGroup(quartzTimedTaskDto.getOrgId().toString());
            //默认触发器名称与分组
            quartzTimedTaskDto.setTriggerName(quartzTimedTaskDto.getOrgId().toString());
            quartzTimedTaskDto.setTriggerGroup(quartzTimedTaskDto.getOrgId().toString());
            //默认为停用状态
            quartzTimedTaskDto.setTaskStatus(QuartzEnum.TaskStatus.OUTAGE.value());
            try {
                startSchedule(quartzTimedTaskDto);
            } catch (Exception e) {
                e.printStackTrace();
            }
            logger.info(new LogMessage<>(UUID.randomUUID().toString(),
                    new EpmLogMessage("epm-cm-service",
                            "quartz",
                            "postQuartzTimedTasks",
                            "添加一条定时任务记录,记录信息:" + quartzTimedTaskDto)).toString());
            return new Response<>().success("");
        } catch (MsgException e) {
            logger.error(new EpmLogMessage("epm-cm-service",
                    "quartz",
                    "postQuartzTimedTasks",
                    "添加一条定时任务记录:" + quartzTimedTaskDto + ",操作失败,原因:" + e.getMessage()).toString(), e);
            return new Response<>().failure(e.getMessage());
        }

    }


    /**
     * ram存储添加定时任务
     *
     * @param quartzTimedTaskDto
     * @throws ParseException
     */
    public static void startSchedule(QuartzTimedTaskDto quartzTimedTaskDto) throws ParseException {
        try {
            // 1、创建一个JobDetail实例，指定Quartz
            JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                    // 任务执行类
                    .withIdentity(quartzTimedTaskDto.getJobName(), quartzTimedTaskDto.getJobGroup())
                    // 任务名，任务组
                    .build();
            String cron = "0/5 * * * * ?";
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(quartzTimedTaskDto.getTriggerName(), quartzTimedTaskDto.getTriggerGroup()).startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron)
                    ).build();
            // 3、创建Scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            // 4、调度执行
            scheduler.scheduleJob(jobDetail, trigger);
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除数据库存储定时任务
     *
     * @param orgId 单位
     * @throws ParseException
     */
    @RequestMapping(value = "/epm/cm/quartz/delQuartzByOrgId", method = RequestMethod.GET)
    public void delQuartzByOrgId(Long orgId) throws ParseException {
        Scheduler scheduler = null;
        try {
            scheduler = myStdSchedulerFactory().getScheduler();
            JobKey jobKey = new JobKey(orgId.toString(), orgId.toString());
            TriggerKey triggerKey = TriggerKey.triggerKey(orgId.toString(), orgId.toString());
            scheduler.pauseTrigger(triggerKey);// 停止触发器
            scheduler.unscheduleJob(triggerKey);// 移除触发器
            scheduler.deleteJob(jobKey);// 删除任务
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加一条定时任务
     * （数据库存储）
     *
     * @param orgId 单位
     * @throws ParseException
     */
    @RequestMapping(value = "/epm/cm/quartz/postQuartzByOrgId", method = RequestMethod.POST)
    public void postQuartzByOrgId(Long orgId) throws ParseException {

        try {
            // 1、创建一个JobDetail实例，指定Quartz
            JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class)
                    // 任务执行类
                    .withIdentity(orgId.toString(), orgId.toString())
                    // 任务名，任务组
                    .build();
            String cron = "0/10 * * * * ?";
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(orgId.toString(), orgId.toString()).startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron)
                    ).build();
            // 3、创建Scheduler\
            Scheduler scheduler = myStdSchedulerFactory().getScheduler();
            scheduler.start();
            // 4、调度执行
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取所有定时任务
     *
     * @param orgId
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/epm/cm/quartz/gets", method = RequestMethod.GET)
    public Response<?> quartzTimedTaskService(Long orgId) throws ParseException {
        List<QuartzTimedTaskDto> getQuartzTimedTasks = autoDeductionExtDao.selectAutoDeductionDto();
        return new Response<>().success(getQuartzTimedTasks);
    }
}
