package com.sid.controller;

import com.sid.model.User;
import com.sid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/u")
public class Usercontroller {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public void home(@RequestBody User user) {
         userService.insert(user);
    }

}
