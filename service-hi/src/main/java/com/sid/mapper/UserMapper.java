package com.sid.mapper;

import com.sid.model.User;

public interface UserMapper {
    void deleteByPrimaryKey(Long id);

    void insert(User record);

    void insertSelective(User record);

    User selectByPrimaryKey(Long id);

    void updateByPrimaryKeySelective(User record);

    void updateByPrimaryKey(User record);
}