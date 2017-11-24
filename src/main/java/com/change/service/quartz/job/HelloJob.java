package com.change.service.quartz.job;

/**
 *
 * @author YangQing
 * @version 1.0.0
 */

import com.change.entity.quartz.User;
import com.change.service.quartz.UserSerivice;
import com.change.utils.SpringUtil;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HelloJob implements BaseJob {

    private static Logger logger = LoggerFactory.getLogger(HelloJob.class);

    private static UserSerivice userSerivice = SpringUtil.getBean(UserSerivice.class);

    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        List<User> users= userSerivice.findUsers();
        for (User dto:users){
            System.out.println(dto.getLoginname());
        }
        JobDetail jobDetail = context.getJobDetail();
        System.out.println("定时任务:" + jobDetail.getKey().getName() + "," + jobDetail.getJobClass().getName() + "执行时间: " + dateFormat().format(new Date()));
        logger.debug("定时任务:" + jobDetail.getKey().getName() + "调用批量扣费" + dateFormat().format(new Date()));

    }
}
