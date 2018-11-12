
package com.sid.controller;

import com.sid.model.User;
import com.sid.service.UserService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
//@RequestMapping("/u")
public class Usercontroller {

    private static final Logger logger = Logger.getLogger(Usercontroller.class.getName());
    @Autowired
    private UserService userService;

    @Autowired
    protected RedisTemplate redisTemplate;

    @Autowired
    private AmqpTemplate rabbitTemplate;


    @RequestMapping(value = "/user", method = RequestMethod.POST)

    public void home(@ModelAttribute User user, HttpServletRequest request) throws IOException {
        userService.insert(user);
    }


    @RequestMapping("/hu")
    public String hu(@RequestParam String zhu) {
        return "sasasa";
    }

    /**
     * 测试redis
     * @param name
     * @return
     */
    @GetMapping("/hello")
    public String sayHi(@RequestParam String name){
        //从缓存中获取城市信息
        String key = name;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        //缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            String userName = operations.get(key);
            logger.info(" 从缓存中获取了姓名 >> " + userName);
            return userName;
        }
        //缓存不存在，将数据存入缓存
        operations.set(key, name, 10, TimeUnit.SECONDS);
        logger.info("CityServiceImpl.findCityById() : 城市插入缓存 >>  " +name);

        return " Welcome: "+name;
    }



}

