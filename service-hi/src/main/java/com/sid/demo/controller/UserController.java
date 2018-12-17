package com.sid.demo.controller;

import com.sid.demo.entity.User;
import com.sid.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2018-11-12 11:30:45
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

    /**
     * 通过用户对象查询对象集合
     *
     * @param user 用户对象
     * @return 对象集合
     */
    @GetMapping("queryAll")
    public List<User> queryAll(User user) {
        return this.userService.queryAll(user);
    }

    /**
     * 新增数据
     *
     * @param user 用户对象
     * @return 新增数据
     */
    @PostMapping("insert")
    public User insert(User user) {
        return this.userService.insert(user);
    }

    /**
     * 修改数据
     *
     * @param user 用户对象
     * @return 修改数据
     */
    @GetMapping("update")
    public User update(User user) {
        return this.userService.update(user);
    }

    /**
     * 删除数据
     *
     * @param id 用户对象
     * @return 修改数据
     */
    @GetMapping("deleteById")
    public Boolean deleteById(Long id) {
        return userService.deleteById(id);

    }

}