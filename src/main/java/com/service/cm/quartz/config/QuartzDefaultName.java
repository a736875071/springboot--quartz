package com.service.cm.quartz.config;

import java.util.Properties;

/**
 * 定时任务:一次性任务常量
 * 执行后删除(防止重启服务抛异常)
 *
 * @author YangQing
 * @version 1.0.0
 */

public class QuartzDefaultName {
    //任务名称
    public final static String SCHED_NAME = "OneOffName";

    //任务分组
    public final static String SCHED_GROUP = "OneOffGroup";

    //任务描述
    public final static String SCHED_DESCRIPTION = "一次性任务";

    //触发器名称
    public final static String TRIGGER_NAME = "OneOffTriggerName";

    //触发器分组
    public final static String TRIGGER_GROUP = "OneOffTriggerGroup";

    //任务频率
    public final static String CRON_EXPRESSION = "0/5 * * * * ?";

    //触发器描述
    public final static String TRIGGER_DESCRIPTION = "一次性触发器";

    //定时任务默认触发器名称
    public final static String DEFAULT_TRIGGER_NAME = "NxTriggerName";

    //定时任务默认触发器分组
    public final static String DEFAULT_TRRIGGER_GROUP = "NxTriggerGroup";
    public static Properties quartz() {
        Properties prop = new Properties();
        prop.put("quartz.scheduler.instanceName", "ServerScheduler");
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
        prop.put("org.quartz.scheduler.instanceId", "NON_CLUSTERED");
        prop.put("org.quartz.scheduler.jobFactory.class", "org.quartz.simpl.SimpleJobFactory");
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
        prop.put("org.quartz.jobStore.dataSource", "quartzDataSource");
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        prop.put("org.quartz.jobStore.isClustered", "true");
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "5");

        prop.put("org.quartz.dataSource.quartzDataSource.driver", "com.mysql.jdbc.Driver");
        prop.put("org.quartz.dataSource.quartzDataSource.URL", "jdbc:mysql://.0.0.1:3306/quartz?characterEncoding=utf-8&useSSL=false");
        prop.put("org.quartz.dataSource.quartzDataSource.user", "root");
        prop.put("org.quartz.dataSource.quartzDataSource.password", "root");
        prop.put("org.quartz.dataSource.quartzDataSource.maxConnections", "10");
        return prop;
    }
}
