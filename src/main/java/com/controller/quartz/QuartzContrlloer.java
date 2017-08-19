package com.controller.quartz;

import com.entity.quartz.JobAndTrigger;
import com.service.cm.quartz.QuartzService;
import com.utils.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;


/**
 * 定时任务
 *
 * @author YangQing
 * @version 1.0.0
 */
@RestController
public class QuartzContrlloer {
    @Autowired
    private QuartzService quartzService;

    /**
     * 查询任务详情
     *
     * @return
     */
    @RequestMapping(value = "/epm/cm/quartz/getqueryjob", method = RequestMethod.GET)
    public Response<?> quartzTimedTaskService1() {
        List<JobAndTrigger> jobAndTriggers = quartzService.getJobAndTriggerDetails();
        return new Response<>().success(jobAndTriggers);
    }

    /**
     * 添加一条定时任务
     * （数据库存储）
     *
     * @param jobAndTrigger
     * @throws ParseException
     */
    @RequestMapping(value = "/epm/cm/quartz/postQuartzByJobAndTrigger", method = RequestMethod.POST)
    public Response<?> postQuartzByJobAndTrigger(@RequestBody JobAndTrigger jobAndTrigger) {
        quartzService.postQuartzByJobAndTrigger(jobAndTrigger);
        return new Response<>().success("成功");
    }

    /**
     * 删除一条定时任务
     * （数据库存储）
     *
     * @param jobAndTrigger
     * @throws ParseException
     */
    @RequestMapping(value = "/epm/cm/quartz/deleQuartzByJobAndTrigger", method = RequestMethod.DELETE)
    public Response<?> deleQuartzByJobAndTrigger(@RequestBody JobAndTrigger jobAndTrigger) throws ParseException {

        quartzService.deleQuartzByJobAndTrigger(jobAndTrigger);
        return new Response<>().success("成功");
    }

    /**
     * 暂停一条定时任务
     * （数据库存储）
     *
     * @param jobAndTrigger
     * @throws ParseException
     */
    @RequestMapping(value = "/epm/cm/quartz/pauseQuartzByJobAndTrigger", method = RequestMethod.PATCH)
    public Response<?> pauseQuartzByJobAndTrigger(@RequestBody JobAndTrigger jobAndTrigger) throws ParseException {

        quartzService.pauseQuartzByJobAndTrigger(jobAndTrigger);
        return new Response<>().success("成功");
    }

    /**
     * 恢复一条定时任务
     * （数据库存储）
     *
     * @param jobAndTrigger
     * @throws ParseException
     */
    @RequestMapping(value = "/epm/cm/quartz/resumeQuartzByJobAndTrigger", method = RequestMethod.PATCH)
    public Response<?> resumeQuartzByJobAndTrigger(@RequestBody JobAndTrigger jobAndTrigger) throws ParseException {

        quartzService.resumeQuartzByJobAndTrigger(jobAndTrigger);
        return new Response<>().success("成功");
    }
}
