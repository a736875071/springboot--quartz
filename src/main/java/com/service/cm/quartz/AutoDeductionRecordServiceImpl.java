package com.service.cm.quartz;

import com.dao.cm.quartz.AutoDeductionRecordDao;
import com.entity.cm.quartz.AutoDeductionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 自动扣费记录
 *
 * @author YangQing
 * @version 1.0.0
 */
@Service
public class AutoDeductionRecordServiceImpl implements AutoDeductionRecordService {
    @Autowired
    private AutoDeductionRecordDao autoDeductionRecordDao;

    /**
     * 主键删除自动扣费记录
     *
     * @param id 主键
     * @return 条数
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    /**
     * 添加自动扣费记录
     *
     * @param record 自动扣费记录
     * @return 自动扣费记录
     */
    @Override
    public AutoDeductionRecord insert(AutoDeductionRecord record) {
        autoDeductionRecordDao.insert(record);
        return record;
    }

    /**
     * 主键查询自动扣费记录
     *
     * @param id 主键
     * @return 查询结果
     */
    @Override
    public AutoDeductionRecord selectByPrimaryKey(Long id) {
        return null;
    }

    /**
     * 修改自动扣费记录
     *
     * @param record 自动扣费记录
     * @return 自动扣费记录
     */
    @Override
    public AutoDeductionRecord updateByPrimaryKey(AutoDeductionRecord record) {
        return null;
    }
}
