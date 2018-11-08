package com.sid.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@RestController
public class HiController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/hi",method = RequestMethod.POST)
    public void sayHi(@RequestBody User user){
         userService.insert(user);
    }
}
