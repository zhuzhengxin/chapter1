package com.sid.web;

import com.sid.model.User;
import com.sid.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestBody User user){
        return schedualServiceHi.sayHiFromClientOne(user);
    }
}
