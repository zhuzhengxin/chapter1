package com.sid.service;

import com.sid.demo.entity.User;
import com.sid.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersService {


    @Autowired
    private UserFeign userFeign;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public User queryById(Long id) {
        return userFeign.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
/*    public List<User> queryAllByLimit(int offset, int limit) {
        return userFeign.queryAllByLimit(offset, limit);
    }*/

    public List<User> queryAll(User user) {
        return userFeign.queryAll(user);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    public User insert(User user) {
        userFeign.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    public User update(User user) {
        userFeign.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return userFeign.deleteById(id) > 0;
    }


}
