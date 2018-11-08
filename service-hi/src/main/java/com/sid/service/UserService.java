package com.sid.service;

import com.sid.model.User;

public interface UserService {
    void deleteByPrimaryKey(Long id);

    void insert(User record);

    void insertSelective(User record);

    User selectByPrimaryKey(Long id);

    void updateByPrimaryKeySelective(User record);

    void updateByPrimaryKey(User record);

}
