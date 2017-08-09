package com.dao.cm.quartz;

import com.domain.cm.quartz.AutoDeductionCondition;
import com.domain.cm.quartz.QuartzTimedTaskDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自动扣费参数配置
 *
 * @author YangQing
 * @version 1.0.0
 */
public interface AutoDeductionExtDao {

    /**
     * 条件查询自动扣费参数配置
     *
     * @param autoDeductionCondition 查询条件
     * @return 查询结果
     */
    List<QuartzTimedTaskDto> selectAutoDeductionDtoByCondition(AutoDeductionCondition autoDeductionCondition);
    List<QuartzTimedTaskDto> selectAutoDeductionDto();

    /**
     * 条件查询自动扣费参数配置条数
     *
     * @param autoDeductionCondition 查询条件
     * @return 查询结果
     */
    int selectAutoDeductionDtoTotalByCondition(AutoDeductionCondition autoDeductionCondition);

    /**
     * 更改所有定时任务状态
     *
     * @param taskStatus 定时任务状态
     */
    void BatchAutoDeductionTaskStatus(@Param("taskStatus") String taskStatus);
}