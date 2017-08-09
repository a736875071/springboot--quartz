package com.service.cm.quartz;


import com.domain.cm.quartz.AutoDeductionCondition;
import com.domain.cm.quartz.AutoDeductionDto;
import com.domain.cm.quartz.QuartzTimedTaskDto;

import java.util.List;

/**
 * 扣费参数信息
 *
 * @author YangQing
 * @version 1.0.0
 */

public interface AutoDeductionService {

    /**
     * 条件查询扣费参数信息
     *
     * @param autoDeductionCondition 查询条件
     * @return 扣费参数信息
     */
    List<QuartzTimedTaskDto> getAutoDeductionByCondition(AutoDeductionCondition autoDeductionCondition);

    /**
     * 条件查询扣费参数信息条数
     *
     * @param autoDeductionCondition 查询条件
     * @return 条数
     */
    int getAutoDeductionTotalByCondition(AutoDeductionCondition autoDeductionCondition);

    /**
     * 主键查询扣费参数信息
     *
     * @param id 主键
     * @return 扣费参数信息
     */
    AutoDeductionDto getAutoDeductionById(Long id);

    /**
     * 添加扣费参数信息
     *
     * @param autoDeductionDto 扣费参数信息
     * @return 扣费参数信息
     */
    AutoDeductionDto postAutoDeduction(AutoDeductionDto autoDeductionDto);

    /**
     * 修改扣费参数信息
     *
     * @param autoDeductionDto 扣费参数信息
     * @return 扣费参数信息
     */
    AutoDeductionDto patchAutoDeduction(AutoDeductionDto autoDeductionDto);

    /**
     * 更改所有定时任务状态
     *
     * @param taskStatus 定时任务状态
     */
    void BatchAutoDeductionTaskStatus(String taskStatus);

    /**
     * 删除扣费参数信息
     *
     * @param id 主键
     * @return
     */
    int deleteAutoDeduction(Long id);


}
