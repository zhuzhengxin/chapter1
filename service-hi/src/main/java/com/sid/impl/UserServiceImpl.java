package com.sid.impl;

import com.sid.mapper.UserMapper;
import com.sid.model.User;
import com.sid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void deleteByPrimaryKey(Long id) {
         userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(User record) {
         userMapper.insert(record);
    }

    @Override
    public void insertSelective(User record) {
         userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKeySelective(User record) {
         userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void updateByPrimaryKey(User record) {
         userMapper.updateByPrimaryKey(record);
    }
}
