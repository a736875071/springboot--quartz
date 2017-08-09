package com.service.cm.quartz;

import com.dao.cm.quartz.AutoDeductionDao;
import com.dao.cm.quartz.AutoDeductionExtDao;
import com.domain.cm.quartz.AutoDeductionCondition;
import com.domain.cm.quartz.AutoDeductionDto;
import com.domain.cm.quartz.QuartzTimedTaskDto;
import com.entity.cm.quartz.AutoDeduction;
import com.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 扣费参数信息
 *
 * @author YangQing
 * @version 1.0.0
 */
@Service
public class AutoDeductionServiceImpl implements AutoDeductionService {

    @Autowired
    private AutoDeductionDao autoDeductionDao;
    @Autowired
    private AutoDeductionExtDao autoDeductionExtDao;

    /**
     * 条件查询扣费参数信息
     *
     * @param autoDeductionCondition 查询条件
     * @return 扣费参数信息
     */
    @Override
    public List<QuartzTimedTaskDto> getAutoDeductionByCondition(AutoDeductionCondition autoDeductionCondition) {
        return autoDeductionExtDao.selectAutoDeductionDtoByCondition(autoDeductionCondition);
    }

    /**
     * 条件查询扣费参数信息条数
     *
     * @param autoDeductionCondition 查询条件
     * @return 条数
     */
    @Override
    public int getAutoDeductionTotalByCondition(AutoDeductionCondition autoDeductionCondition) {
        return autoDeductionExtDao.selectAutoDeductionDtoTotalByCondition(autoDeductionCondition);
    }

    /**
     * 主键查询扣费参数信息
     *
     * @param id 主键
     * @return 扣费参数信息
     */
    @Override
    public AutoDeductionDto getAutoDeductionById(Long id) {
        AutoDeduction autoDeduction = autoDeductionDao.selectByPrimaryKey(id);
        if (autoDeduction == null) {
            return null;
        }
        AutoDeductionDto autoDeductionDto = new AutoDeductionDto();
        BeanUtils.copyPropertiesIgnoreNullValue(autoDeduction, autoDeductionDto);
        return autoDeductionDto;
    }

    /**
     * 添加扣费参数信息
     *
     * @param autoDeductionDto 扣费参数信息
     * @return 扣费参数信息
     */
    @Override
    public AutoDeductionDto postAutoDeduction(AutoDeductionDto autoDeductionDto) {
        if (autoDeductionDto == null) {
            return null;
        }
        AutoDeduction autoDeduction = new AutoDeduction();
        BeanUtils.copyPropertiesIgnoreNullValue(autoDeductionDto, autoDeduction);
        autoDeductionDao.insertSelective(autoDeduction);
        return autoDeductionDto;
    }

    /**
     * 修改扣费参数信息
     *
     * @param autoDeductionDto 扣费参数信息
     * @return 扣费参数信息
     */
    @Override
    public AutoDeductionDto patchAutoDeduction(AutoDeductionDto autoDeductionDto) {
        if (autoDeductionDto == null) {
            return null;
        }
        AutoDeduction autoDeduction = new AutoDeduction();
        BeanUtils.copyPropertiesIgnoreNullValue(autoDeductionDto, autoDeduction);
        autoDeductionDao.updateByPrimaryKeySelective(autoDeduction);
        return autoDeductionDto;
    }

    /**
     * 更改所有定时任务状态
     *
     * @param taskStatus 定时任务状态
     */
    @Override
    public void BatchAutoDeductionTaskStatus(String taskStatus) {
        autoDeductionExtDao.BatchAutoDeductionTaskStatus(taskStatus);
    }

    /**
     * 删除扣费参数信息
     *
     * @param id 主键
     * @return
     */
    @Override
    public int deleteAutoDeduction(Long id) {
        return autoDeductionDao.deleteByPrimaryKey(id);
    }

}


