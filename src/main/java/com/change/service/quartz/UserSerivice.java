package com.change.service.quartz;

import com.change.entity.quartz.User;

import java.util.List;

public interface UserSerivice {
    int deleteByPrimaryKey(Integer user_id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer user_id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findUsers();
}