package com.sid.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@FeignClient(value = "service-hi" ,fallback = SchedualServiceHiHystric.class)
public interface UserService {
    @RequestMapping(value = "/hi",method = RequestMethod.POST)
    void insert(@RequestBody User user);
}
