package com.change.service.quartz;

import com.change.dao.quartz.UserDao;
import com.change.entity.quartz.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangQing
 * @version 1.0.0
 */
@Service
public class UserSeriviceImpl implements  UserSerivice{
    @Autowired
    private UserDao userDao;
    @Override
    public int deleteByPrimaryKey(Integer user_id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer user_id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public List<User> findUsers() {
        return userDao.findUsers();
    }
}
