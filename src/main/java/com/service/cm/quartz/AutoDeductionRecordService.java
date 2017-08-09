package com.service.cm.quartz;


import com.entity.cm.quartz.AutoDeductionRecord;

/**
 * 自动扣费记录
 *
 * @author YangQing
 * @version 1.0.0
 */

public interface AutoDeductionRecordService {

    /**
     * 主键删除自动扣费记录
     *
     * @param id 主键
     * @return 条数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加自动扣费记录
     *
     * @param record 自动扣费记录
     * @return 自动扣费记录
     */
    AutoDeductionRecord insert(AutoDeductionRecord record);

    /**
     * 主键查询自动扣费记录
     *
     * @param id 主键
     * @return 查询结果
     */
    AutoDeductionRecord selectByPrimaryKey(Long id);

    /**
     * 修改自动扣费记录
     *
     * @param record 自动扣费记录
     * @return 自动扣费记录
     */
    AutoDeductionRecord updateByPrimaryKey(AutoDeductionRecord record);
}
