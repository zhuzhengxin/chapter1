package com.sid.web.UserController;

import com.common.entity.User;
import com.sid.feign.UserFeign;
import com.sid.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@RestController
@RequestMapping("/user")
@Api(value = "/collectivePlan",description = "集体备课表模块")
public class HiController {

    @Autowired
    UsersService userService;

    @Autowired
    private UserFeign userFeign;

    @GetMapping(value="/queryById/{id}")
    @ApiOperation(value = "通过id查询用户", notes = "返回响应对象")
    public User queryById(@PathVariable Long id){
        return userFeign.queryById(id);
    }

   @GetMapping(value = "/queryAllByLimit")
    @ApiOperation(value = "查询多条数据(起始位置)", notes = "返回响应对象")
    public List<User> queryAllByLimit(@ApiParam(value = "开始位置，结束位置", required = true)  @RequestParam("offset") int offset, @RequestParam("limit") int limit){
       return userService.queryAllByLimit(offset,limit);
    }

    @PostMapping(value = "/queryAll")
    @ApiOperation(value = "查询多条数据", notes = "返回响应对象")
    public List<User> queryAll(@ApiParam(value = "用户对象", required = true) @RequestBody User user){
        return userFeign.queryAll(user);
    }


    @PostMapping(value = "/update")
    @ApiOperation(value = "修改用户", notes = "返回响应对象")
    public void update( @ApiParam(value = "用户对象", required = true) @RequestBody User user){
        userFeign.update(user);
    }

    @GetMapping(value = "/deleteById")
    @ApiOperation(value = "根据用户id删除", notes = "返回响应对象")
    public void deleteById( @ApiParam(value = "用户id", required = true) Long id){
        userFeign.deleteById(id);
    }

    //@RequestMapping(value = "/insert",method = RequestMethod.POST)
    @PostMapping(value = "/insert")
    @ApiOperation(value = "新增用户", notes = "返回响应对象")
    public User insert( @ApiParam(value = "用户对象", required = true) @RequestBody User user){
        return userService.insert(user);
    }



}
